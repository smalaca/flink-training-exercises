package com.smalaca;

import com.smalaca.domain.Report;
import com.smalaca.domain.ReportFactory;
import com.smalaca.domain.TransactionEvent;
import com.smalaca.domain.TransactionPosition;
import com.smalaca.transaction.source.TransactionEventSource;
import org.apache.flink.api.common.functions.RichFlatMapFunction;
import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.configuration.ConfigConstants;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

public class Lab1Job {
    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration();
        configuration.setBoolean(ConfigConstants.LOCAL_START_WEBSERVER, true);
        StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironmentWithWebUI(configuration);

        DataStreamSource<TransactionEvent> streamSource = env.addSource(new TransactionEventSource());
        ReportFactory reportFactory = new ReportFactory();

        streamSource
                .filter(TransactionEvent::isNotBlock)
                .keyBy(TransactionEvent::transactionId)
                .flatMap(new RichFlatMapFunction<TransactionEvent, Report>() {
                    private transient ValueState<TransactionPosition> transactionPosition;

                    @Override
                    public void open(Configuration parameters) {
                        ValueStateDescriptor<TransactionPosition> stateDescriptor = new ValueStateDescriptor<>("position", TransactionPosition.class);
                        transactionPosition = getRuntimeContext().getState(stateDescriptor);
                    }

                    @Override
                    public void flatMap(TransactionEvent transactionEvent, Collector<Report> collector) throws Exception {
                        if (transactionPosition.value() == null) {
                            collector.collect(reportFactory.aNew(transactionEvent));
                        } else {
                            collector.collect(reportFactory.anAmend(transactionEvent));
                        }

                        transactionPosition.update(new TransactionPosition(transactionEvent.transactionId()));
                    }
                })
                .print();

        env.execute();
    }
}

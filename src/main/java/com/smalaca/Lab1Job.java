package com.smalaca;

import com.smalaca.domain.ReportFactory;
import com.smalaca.domain.TransactionEvent;
import com.smalaca.transaction.source.TransactionEventSource;
import org.apache.flink.configuration.ConfigConstants;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class Lab1Job {
    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration();
        configuration.setBoolean(ConfigConstants.LOCAL_START_WEBSERVER, true);
        int parallelism = 3;
        StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironment(parallelism, configuration);

        DataStreamSource<TransactionEvent> streamSource = env.addSource(new TransactionEventSource());
        ReportFactory reportFactory = new ReportFactory();

        streamSource
                .filter(TransactionEvent::isNotBlock)
                .map(reportFactory::create)
                .print();

        env.execute();
    }
}

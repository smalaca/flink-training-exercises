package com.smalaca;

import com.smalaca.domain.ReportFactory;
import com.smalaca.domain.TransactionEvent;
import com.smalaca.transaction.source.TransactionEventSource;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class Lab1Job {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        env.setParallelism(1);

        DataStreamSource<TransactionEvent> streamSource = env.addSource(new TransactionEventSource());
        ReportFactory reportFactory = new ReportFactory();

        streamSource
                .filter(TransactionEvent::isNotBlock)
                .map(reportFactory::create)
                .print();

        env.execute();
    }
}

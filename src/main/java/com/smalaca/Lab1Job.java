package com.smalaca;

import com.smalaca.domain.TransactionEvent;
import com.smalaca.transaction.source.TransactionEventSource;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class Lab1Job {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStreamSource<TransactionEvent> streamSource = env.addSource(new TransactionEventSource());
        streamSource
                .filter(TransactionEvent::isNotBlock)
                .print();

        env.execute();
    }
}

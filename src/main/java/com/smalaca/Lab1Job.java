package com.smalaca;

import com.smalaca.domain.TransactionEvent;
import com.smalaca.transaction.source.TransactionEventSource;
import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.SourceFunction;

import java.util.UUID;

public class Lab1Job {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStreamSource<TransactionEvent> streamSource = env.addSource(new TransactionEventSource());
        streamSource.filter(TransactionEvent::isNotBlock);

        env.execute();
    }
}

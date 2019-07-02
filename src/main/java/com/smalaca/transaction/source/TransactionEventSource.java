package com.smalaca.transaction.source;

import com.smalaca.domain.TransactionEvent;
import org.apache.flink.streaming.api.functions.source.SourceFunction;

import java.util.UUID;

public class TransactionEventSource implements SourceFunction<TransactionEvent> {
    private final RandomTransactionEventFactory factory = new RandomTransactionEventFactory();

    @Override
    public void run(SourceContext<TransactionEvent> sourceContext) {
        sourceContext.collect(factory.allocation());
        sourceContext.collect(factory.allocation());
        sourceContext.collect(factory.allocation());
        sourceContext.collect(factory.bilateral());
        sourceContext.collect(factory.bilateral());
        sourceContext.collect(factory.block());
        sourceContext.collect(factory.block());

    }

    @Override
    public void cancel() {

    }
}
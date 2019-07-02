package com.smalaca.transaction.source;

import com.smalaca.domain.TransactionEvent;
import org.apache.flink.streaming.api.functions.source.SourceFunction;

import java.util.Random;

public class TransactionEventSource implements SourceFunction<TransactionEvent> {
    private final RandomTransactionEventFactory factory = new RandomTransactionEventFactory();

    @Override
    public void run(SourceContext<TransactionEvent> sourceContext) throws InterruptedException {
        for(int i = 0; i<100000; i++) {
            switch (transactionEventType()) {
                case 0:
                    sourceContext.collect(factory.allocation());
                case 1:
                    sourceContext.collect(factory.bilateral());
                case 2:
                    sourceContext.collect(factory.block());
            }

            Thread.sleep(100);
        }
    }

    private int transactionEventType() {
        return new Random().nextInt(4);
    }

    @Override
    public void cancel() {

    }
}

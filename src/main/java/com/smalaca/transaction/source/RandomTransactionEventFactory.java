package com.smalaca.transaction.source;

import com.smalaca.domain.TransactionEvent;

import java.util.UUID;

class RandomTransactionEventFactory {


    private String randomVersion() {
        return UUID.randomUUID().toString();
    }

    private String randomId() {
        return UUID.randomUUID().toString();
    }

    TransactionEvent allocation() {
        return TransactionEvent.allocation(randomId(), randomVersion());
    }

    TransactionEvent bilateral() {
        return TransactionEvent.bilateral(randomId(), randomVersion());
    }

    TransactionEvent block() {
        return TransactionEvent.block(randomId(), randomVersion());
    }
}

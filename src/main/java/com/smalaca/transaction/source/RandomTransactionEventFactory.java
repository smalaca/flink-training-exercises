package com.smalaca.transaction.source;

import com.smalaca.domain.TransactionEvent;

import java.io.Serializable;
import java.util.UUID;

class RandomTransactionEventFactory implements Serializable {
    private static final long serialVersionUID = 13L;

    private long randomVersion() {
        return 1L;
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

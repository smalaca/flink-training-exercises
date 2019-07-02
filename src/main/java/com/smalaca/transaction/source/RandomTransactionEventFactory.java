package com.smalaca.transaction.source;

import com.smalaca.domain.TransactionEvent;

import java.io.Serializable;
import java.util.UUID;

class RandomTransactionEventFactory implements Serializable {
    private static final long serialVersionUID = 13L;
    private int counter = 1;
    private String lastId;

    private long randomVersion() {
        return counter;
    }

    private String randomId() {
        if (counter == 1) {
            lastId = UUID.randomUUID().toString();
            counter++;
        } else if (counter == 2) {
            counter++;
        } else if (counter == 3) {
            counter = 1;
        }

        return lastId;
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

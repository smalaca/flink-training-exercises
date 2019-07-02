package com.smalaca.domain;

import java.io.Serializable;
import java.util.UUID;

public class ReportFactory implements Serializable {
    private static final long serialVersionUID = 13L;

    public Report create(TransactionEvent transactionEvent) {
        return Report.aNew(randomId(), transactionEvent);
    }

    private String randomId() {
        return UUID.randomUUID().toString();
    }
}

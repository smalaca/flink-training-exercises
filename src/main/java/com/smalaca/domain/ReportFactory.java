package com.smalaca.domain;

import java.io.Serializable;

public class ReportFactory implements Serializable {
    private static final long serialVersionUID = 13L;

    public Report create(TransactionEvent transactionEvent) {
        return Report.aNew(aReportId("NEW", transactionEvent), transactionEvent);
    }

    private String aReportId(String prefix, TransactionEvent transactionEvent) {
        return prefix + "." + transactionEvent.transactionId() + "." + transactionEvent.transactionVersion();
    }
}

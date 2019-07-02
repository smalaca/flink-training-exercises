package com.smalaca.domain;

import java.io.Serializable;

public class ReportFactory implements Serializable {
    private static final String NEW = "NEW";
    private static final long serialVersionUID = 13L;
    private static final String AMEND = "AMEND";

    public Report aNew(TransactionEvent transactionEvent) {
        return Report.aNew(aReportId(NEW, transactionEvent), transactionEvent);
    }

    public Report anAmend(TransactionEvent transactionEvent) {
        return Report.anAmend(aReportId(AMEND, transactionEvent), transactionEvent);
    }

    private String aReportId(String prefix, TransactionEvent transactionEvent) {
        return prefix + "." + transactionEvent.transactionId() + "." + transactionEvent.transactionVersion();
    }
}

package com.smalaca.domain;

public class Report {
    private final String reportId;
    private final String transactionId;
    private final TransactionType transactionType;
    private final ReportType reportType;

    private Report(String reportId, String transactionId, TransactionType transactionType, ReportType reportType) {
        this.reportId = reportId;
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.reportType = reportType;
    }

    public String reportId() {
        return reportId;
    }

    public String transactionId() {
        return transactionId;
    }

    public TransactionType transactionType() {
        return transactionType;
    }

    public ReportType reportType() {
        return reportType;
    }
}

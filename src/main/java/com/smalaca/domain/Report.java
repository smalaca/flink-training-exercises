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

    static Report aNew(String reportId, TransactionEvent transactionEvent) {
        return new Report(reportId, transactionEvent.transactionId(), transactionEvent.transactionType(), ReportType.NEW);
    }

    static Report anAmend(String reportId, TransactionEvent transactionEvent) {
        return new Report(reportId, transactionEvent.transactionId(), transactionEvent.transactionType(), ReportType.AMEND);
    }

    @Override
    public String toString() {
        return "Report{" +
                "reportId='" + reportId + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", transactionType=" + transactionType +
                ", reportType=" + reportType +
                '}';
    }
}

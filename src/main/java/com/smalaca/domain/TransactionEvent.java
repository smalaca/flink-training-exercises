package com.smalaca.domain;

public class TransactionEvent {
    private final String transactionId;
    private final String transactionVersion;
    private final TransactionType transactionType;

    private TransactionEvent(String transactionId, String transactionVersion, TransactionType transactionType) {
        this.transactionId = transactionId;
        this.transactionVersion = transactionVersion;
        this.transactionType = transactionType;
    }

    public static TransactionEvent allocation(String transactionId, String transactionVersion) {
        return new TransactionEvent(transactionId, transactionVersion, TransactionType.ALLOCATION);
    }

    public static TransactionEvent bilateral(String transactionId, String transactionVersion) {
        return new TransactionEvent(transactionId, transactionVersion, TransactionType.BILATERAL);
    }

    public static TransactionEvent block(String transactionId, String transactionVersion) {
        return new TransactionEvent(transactionId, transactionVersion, TransactionType.BLOCK);
    }

    public String transactionId() {
        return transactionId;
    }

    public String transactionVersion() {
        return transactionVersion;
    }

    public TransactionType transactionType() {
        return transactionType;
    }
}

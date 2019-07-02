package com.smalaca.domain;

import static com.smalaca.domain.TransactionType.BLOCK;

public class TransactionEvent {
    private final String transactionId;
    private final long transactionVersion;
    private final TransactionType transactionType;

    private TransactionEvent(String transactionId, long transactionVersion, TransactionType transactionType) {
        this.transactionId = transactionId;
        this.transactionVersion = transactionVersion;
        this.transactionType = transactionType;
    }

    public static TransactionEvent allocation(String transactionId, long transactionVersion) {
        return new TransactionEvent(transactionId, transactionVersion, TransactionType.ALLOCATION);
    }

    public static TransactionEvent bilateral(String transactionId, long transactionVersion) {
        return new TransactionEvent(transactionId, transactionVersion, TransactionType.BILATERAL);
    }

    public static TransactionEvent block(String transactionId, long transactionVersion) {
        return new TransactionEvent(transactionId, transactionVersion, TransactionType.BLOCK);
    }

    String transactionId() {
        return transactionId;
    }

    long transactionVersion() {
        return transactionVersion;
    }

    TransactionType transactionType() {
        return transactionType;
    }

    public boolean isNotBlock() {
        return !BLOCK.equals(transactionType);
    }

    @Override
    public String toString() {
        return "TransactionEvent{" +
                "transactionId='" + transactionId + '\'' +
                ", transactionVersion='" + transactionVersion + '\'' +
                ", transactionType=" + transactionType +
                '}';
    }
}

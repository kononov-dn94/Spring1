package com.example.demo.entity;

public enum Status {
    NEW("Новая"),
    IN_WORK("В работе"),
    CLOSE("Закрыта");

    public String status;

    Status(String status) {
        this.status = status;
    }

    public static Status valueOfLabel(String label) {
        for (Status e : values()) {
            if (e.status.equals(label)) {
                return e;
            }
        }
        return null;
    }
}

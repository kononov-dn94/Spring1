package com.example.demo.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatusTest {

    @Test
    void valueOfLabel() {
        Status result = Status.valueOfLabel("В работе");
        if (result != null) {
            System.out.println(result);
        } else {
            System.out.println("Такого статуса не существует");
        }
    }
}
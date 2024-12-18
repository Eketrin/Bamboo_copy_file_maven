package org.example;

// 1. Определение кастомного исключения
public class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

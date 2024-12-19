package ru.gb.homework12.logger;

import org.springframework.stereotype.Component;

public class ConsoleLogger implements Logger{
    @Override
    public void log(String text) {
        System.out.println("Logger :" + text);
    }
}

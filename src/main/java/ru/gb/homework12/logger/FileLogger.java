package ru.gb.homework12.logger;

import org.springframework.stereotype.Component;

import java.io.FileWriter;

@Component
public class FileLogger implements Logger{
    @Override
    public void log(String text) {
        try (FileWriter writer = new FileWriter("appLog.txt", true)){
            writer.write(text + "\n");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

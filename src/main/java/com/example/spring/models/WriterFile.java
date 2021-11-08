package com.example.spring.models;

import ch.qos.logback.classic.Logger;
import com.example.spring.ui.WritingFile;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;

public class WriterFile implements WritingFile {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(WriterFile.class);

    @Override
    public String write(String textWrite) {
        try (FileWriter fileWriter = new FileWriter("Result.txt", false)) {
            fileWriter.write(textWrite);
            fileWriter.flush();
        } catch (IOException ex) {
            logger.error("Write error.");
        }
        return textWrite;
    }
}
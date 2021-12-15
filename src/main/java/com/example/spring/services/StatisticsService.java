package com.example.spring.services;

import ch.qos.logback.classic.Logger;
import com.example.spring.models.Checker;
import com.example.spring.models.Counter;
import com.example.spring.models.ReaderFile;
import com.example.spring.models.WriterFile;
import com.example.spring.ui.Checking;
import com.example.spring.ui.Counting;
import com.example.spring.ui.ReadingFile;
import com.example.spring.ui.WritingFile;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    ReadingFile readingFile = new ReaderFile();
    Checking checking = new Checker();
    Counting counting = new Counter();
    WritingFile writingFile = new WriterFile();

    private static final Logger logger = (Logger) LoggerFactory.getLogger(StatisticsService.class);


    public String getTextFile() {
        logger.info("Read File");
        return readingFile.read();
    }

    public void setResultFile(String resultFile) {
        logger.info("Write File");
        writingFile.write(resultFile);
    }

    public String getResult(String textInput, String typeInput) {
        logger.info("Get Result file");
        String check = checking.determine(textInput);
        return counting.identify(check, typeInput);
    }
}
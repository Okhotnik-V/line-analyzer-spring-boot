package com.example.spring.models;

import ch.qos.logback.classic.Logger;
import com.example.spring.ui.Checking;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;

public class Checker implements Checking {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(Checker.class);

    @Override
    public String determine(String textDetermine) {
        try {
            boolean resultDetermine;
            if (textDetermine != null && !textDetermine.trim().isEmpty()) {
                resultDetermine = Pattern.matches("[" + "a-z A-Z" + "]" + "*", textDetermine);
            } else {
                resultDetermine = false;
                logger.error("Error, a sentence is entered that does not meet the requirements");
            }
            boolean correct = false;
            while (correct == false) {
                if (resultDetermine == true) {
                    correct = true;
                } else {
                    logger.error("Change error. Change the content.");
                    return null;
                }
            }
            return textDetermine;
        } catch (Exception e) {
            logger.error("Error: Occurred while checking text.");
            return null;
        }
    }
}
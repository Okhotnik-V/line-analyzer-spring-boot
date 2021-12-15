package com.example.spring.controllers;

import com.example.spring.services.MongoDBService;
import com.example.spring.services.MySQLService;
import com.example.spring.services.StatisticsService;
import com.example.spring.enums.Inputter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    String textInput;

    @Autowired
    private MySQLService mySQLServices;

    @Autowired
    private MongoDBService mongoDBServices;

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/console")
    public String console(Model model) {
        model.addAttribute("consoleTxt", "");
        model.addAttribute("resultRead", "");
        return "console";
    }

    @PostMapping("/console")
    public void consoleAdd(@RequestParam String consoleText, Model model) {
        model.addAttribute("consoleTxt", consoleText);
        model.addAttribute("resultRead", statisticsService.getResult(consoleText, Inputter.CONSOLE.getInputer()));
    }

    @GetMapping("/file")
    public String file(Model model) {
        textInput = statisticsService.getTextFile();
        String resultFile = statisticsService.getResult(textInput, Inputter.FILE.getInputer());
        statisticsService.setResultFile(resultFile);
        model.addAttribute("text", textInput);
        model.addAttribute("resultRead", resultFile);
        return "file";
    }

    @GetMapping("/mysql")
    public String mysql(Model model) {
        textInput = mySQLServices.getTextSQL();
        model.addAttribute("textMySQL", textInput);
        model.addAttribute("resultRead", statisticsService.getResult(textInput, Inputter.DB.getInputer()));
        return "mysql";
    }

    @GetMapping("/mongodb")
    public String mongodb(Model model) {
        textInput = mongoDBServices.getTextMongo();
        model.addAttribute("textMongoDB", textInput);
        model.addAttribute("resultRead", statisticsService.getResult(textInput, Inputter.DB.getInputer()));
        return "mongodb";
    }
}

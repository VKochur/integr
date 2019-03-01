package ru.ukbp.integr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/")
    public String helloPage(){
        System.err.println("!!!!");
        return "hello";
    }

    @RequestMapping("/create")
    public String createPage(Model model){
        String result = null;
        try {
            jdbcTemplate.execute("drop table if exists table1");
            jdbcTemplate.execute(
                "create table table1 (" +
                "id integer primary key not null," +
                "name varchar(50))");
        result = "create";
        } catch (Exception e) {
            result = "something is wrong";
        }
        model.addAttribute("status", result);
        return "create";
    }
}

package com.practice.highchart.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class HighChartController {

    @GetMapping("/")
    public String base() {
        return "base.html";
    }


}

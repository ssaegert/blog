package com.example.blog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {
    @GetMapping("/add/{firstNumber}/and/{secondNumber}")
    @ResponseBody
    public String add(@PathVariable int firstNumber, @PathVariable int secondNumber) {
        return firstNumber + " + " + secondNumber + " = " + (firstNumber + secondNumber);
    }

    @GetMapping("/subtract/{firstNumber}/from/{secondNumber}")
    @ResponseBody
    public String subtract(@PathVariable int firstNumber, @PathVariable int secondNumber) {
        return secondNumber + " - " + firstNumber + " = " + (secondNumber - firstNumber);
    }

    @GetMapping("/multiply/{firstNumber}/and/{secondNumber}")
    @ResponseBody
    public String multiply(@PathVariable int firstNumber, @PathVariable int secondNumber) {
        return firstNumber + " x " + secondNumber + " = " + (firstNumber * secondNumber);
    }

    @GetMapping("/divide/{firstNumber}/by/{secondNumber}")
    @ResponseBody
    public String divide(@PathVariable double firstNumber, @PathVariable double secondNumber) {

        if (firstNumber == 0 || secondNumber == 0) {
            return "Can't divide by zero";
        } else {
            return firstNumber + " / " + secondNumber + " = " + (firstNumber / secondNumber);
        }
    }

}

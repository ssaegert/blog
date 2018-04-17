package com.example.blog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RollDiceController {
    @GetMapping("/roll-dice")
    public  String rollDice(){
        return "roll-dice";
    }
}

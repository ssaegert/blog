package com.example.blog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class diceOutcomeController {
    //    @GetMapping("/roll-dice/{choice}")
    //    public  String diceOutcome(@PathVariable Integer choice, Model model){
    //        model.addAttribute("choice", choice);
    //        return "dice-outcome";
    //    }
    @GetMapping("/dice-outcome")
    public  String rollDice(){
        return "dice-outcome";
    }

    @GetMapping("/dice-outcome/{choice}")

    public String diceOutcome(@PathVariable Integer choice, Model model){
        int randNum1 = (int) (Math.random() * 6 + 1);
        int randNum2 = (int) (Math.random() * 6 + 1);
        model.addAttribute("choice", choice);
        model.addAttribute("randNum1", randNum1);
        model.addAttribute("randNum2", randNum2);
        return "dice-outcome";
    }
}

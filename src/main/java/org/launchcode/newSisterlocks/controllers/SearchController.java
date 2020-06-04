package org.launchcode.newSisterlocks.controllers;

import org.launchcode.newSisterlocks.models.*;
import org.launchcode.newSisterlocks.models.ConsultantData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import static org.launchcode.newSisterlocks.controllers.HomeController.columnChoices;
import static org.launchcode.newSisterlocks.controllers.HomeController.tableChoices;

import java.util.ArrayList;

@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        model.addAttribute("tableChoices", tableChoices);
        return "search";
    }



// TODO: add google api

// TODO: make search respond to actual data

    @PostMapping(value = "search")
    public String displaySearchResults(Model model,
                                       @RequestParam String zipCode/*,
                                       //i think this should be radius but i don't know how
                                       @RequestParam String searchType*/){
        model.addAttribute("columns", columnChoices);
        model.addAttribute("tableChoices", tableChoices);
        ArrayList<Consultant> consultants;
//        if (searchTerm.toLowerCase().equals("all") || searchTerm.toLowerCase().equals("")) {
//            jobs=JobData.findAll();
//            model.addAttribute("title", "All Jobs");
//        }
        consultants = ConsultantData.findByColumnAndValue(/*radius,*/ zipCode);
        model.addAttribute("title", "Consultants within 6 miles of Zip Code: " + zipCode);
        model.addAttribute("consultants", consultants);
        return "index";
    }


}

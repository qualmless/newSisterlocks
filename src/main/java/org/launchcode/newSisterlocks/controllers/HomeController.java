package org.launchcode.newSisterlocks.controllers;


import org.launchcode.newSisterlocks.models.Consultant;
import org.launchcode.newSisterlocks.models.ConsultantData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping(value = "")
public class HomeController {
    static HashMap<String, String> columnChoices = new HashMap<>();
    static HashMap<String, Object> tableChoices = new HashMap<>();

    public HomeController () {
        columnChoices.put("all", "All");
        columnChoices.put("name", "Consultant Name");
        columnChoices.put("address", "Address");
        columnChoices.put("city", "City");
        columnChoices.put("state", "State");
        columnChoices.put("zipCode", "ZipCode");
        columnChoices.put("phoneNumber", "Phone Number");
        columnChoices.put("email", "Email");
        columnChoices.put("salonOrHome", "Salon or Home");
        columnChoices.put("salonName", "Salon Name");
        columnChoices.put("traineeOrConsultant", "Trainee or Consultant");

        tableChoices.put("all", "View All");
        tableChoices.put("name", ConsultantData.getAllConsultants());
        tableChoices.put("city", ConsultantData.getAllCities());
        tableChoices.put("state", ConsultantData.getAllStates());
        tableChoices.put("zipCode", ConsultantData.getAllZipCodes());
    }

    @RequestMapping(value = "")
    public String list(Model model) {
        model.addAttribute("columns", columnChoices);
        model.addAttribute("tableChoices", tableChoices);
        model.addAttribute("all",ConsultantData.findAll());
        model.addAttribute("names", ConsultantData.getAllConsultants());
        model.addAttribute("cities", ConsultantData.getAllCities());
        model.addAttribute("states", ConsultantData.getAllStates());
        model.addAttribute("zipCodes", ConsultantData.getAllZipCodes());

        return "index";
    }

    @RequestMapping(value = "consultants")
    public String listConsultantsByColumnAndValue(Model model,
                                                  @RequestParam String column,
                                                  @RequestParam String value) {
        ArrayList<Consultant> consultants;
//        if (column.toLowerCase().equals("all")){
            consultants = ConsultantData.findAll();
            model.addAttribute("title", "All Consultants");
//        } else {
//            consultants = ConsultantData.findByColumnAndValue(column, value);
//            model.addAttribute("title", "Consultants with " + columnChoices.get(column) + ": " + value);
//        }
        model.addAttribute("consultants", consultants);

        return "list-consultants";
    }
}

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
        tableChoices.put("employer", ConsultantData.getAllConsultants());
        tableChoices.put("location", ConsultantData.getAllCities());
        tableChoices.put("positionType", ConsultantData.getAllStates());
        tableChoices.put("coreCompetency", ConsultantData.getAllZipCodes());
    }

    @RequestMapping(value = "")
    public String list(Model model) {
        model.addAttribute("columns", columnChoices);
        model.addAttribute("tableChoices", tableChoices);
        model.addAttribute("all",ConsultantData.findAll());
        model.addAttribute("employers", ConsultantData.getAllConsultants());
        model.addAttribute("locations", ConsultantData.getAllCities());
        model.addAttribute("positions", ConsultantData.getAllStates());
        model.addAttribute("skills", ConsultantData.getAllZipCodes());

        return "list";
    }

    @RequestMapping(value = "consultants")
    public String listConsultantsByColumnAndValue(Model model,
                                                  @RequestParam String column,
                                                  @RequestParam String value) {
        ArrayList<Consultant> consultants;
        if (column.toLowerCase().equals("all")){
            consultants = ConsultantData.findAll();
            model.addAttribute("title", "All Consultants");
        } else {
            consultants = ConsultantData.findByColumnAndValue(column, value);
            model.addAttribute("title", "Consultants with " + columnChoices.get(column) + ": " + value);
        }
        model.addAttribute("consultants", consultants);

        return "list-consultants";
    }
}

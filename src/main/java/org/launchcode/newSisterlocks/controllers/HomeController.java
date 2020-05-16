package org.launchcode.newSisterlocks.controllers;

import org.launchcode.newSisterlocks.models.Consultant;
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

    public ListController () {
        columnChoices.put("all", "All");
        columnChoices.put("name", "Consultant Name");
        columnChoices.put("address", "Address");
        columnChoices.put("city", "City");
        columnChoices.put("state", "State");
        columnChoices.put("zip", "Zip");
        columnChoices.put("phoneNumber", "Phone Number");
        columnChoices.put("email", "Email");
        columnChoices.put("salonOrHome", "Salon or Home");
        columnChoices.put("salonName", "Salon Name");
        columnChoices.put("traineeOrConsultant", "Trainee or Consultant");

        tableChoices.put("all", "View All");
        tableChoices.put("employer", JobData.getAllEmployers());
        tableChoices.put("location", JobData.getAllLocations());
        tableChoices.put("positionType", JobData.getAllPositionTypes());
        tableChoices.put("coreCompetency", JobData.getAllCoreCompetency());
    }

    @RequestMapping(value = "")
    public String list(Model model) {
        model.addAttribute("columns", columnChoices);
        model.addAttribute("tableChoices", tableChoices);
        model.addAttribute("all",JobData.findAll());
        model.addAttribute("employers", JobData.getAllEmployers());
        model.addAttribute("locations", JobData.getAllLocations());
        model.addAttribute("positions", JobData.getAllPositionTypes());
        model.addAttribute("skills", JobData.getAllCoreCompetency());

        return "list";
    }

    @RequestMapping(value = "consultants")
    public String listConsultantsByColumnAndValue(Model model,
                                                  @RequestParam String column,
                                                  @RequestParam String value) {
        ArrayList<Consultant> consultants;
        if (column.toLowerCase().equals("all")){
            jobs = JobData.findAll();
            model.addAttribute("title", "All Jobs");
        } else {
            jobs = JobData.findByColumnAndValue(column, value);
            model.addAttribute("title", "Jobs with " + columnChoices.get(column) + ": " + value);
        }
        model.addAttribute("consultants", consultants);

        return "list-jobs";
    }
}

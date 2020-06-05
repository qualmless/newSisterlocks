package org.launchcode.newSisterlocks.controllers;


import org.launchcode.newSisterlocks.models.Consultant;
import org.launchcode.newSisterlocks.models.ConsultantData;
import org.launchcode.newSisterlocks.models.SearchForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

@Controller
@RequestMapping(value = "")
public class HomeController {
//    static HashMap<String, String> columnChoices = new HashMap<>();
    static SortedMap<String, String> columnChoices = new TreeMap<>();
    static HashMap<String, Object> tableChoices = new HashMap<>();
//    static SortedMap<String, Object> tableChoices = new TreeMap<>();

    private Object searchForm;

    public HomeController () {
        columnChoices.put("name", "Name");
        columnChoices.put("city", "City");
        columnChoices.put("state", "State");
        columnChoices.put("zipCode", "ZipCode");

        tableChoices.put("consultants", ConsultantData.getAllConsultants());
        tableChoices.put("names", ConsultantData.getAllNames());
        tableChoices.put("cities", ConsultantData.getAllCities());
        tableChoices.put("states", ConsultantData.getAllStates());
        tableChoices.put("zipCodes", ConsultantData.getAllZipCodes());
    }

    @RequestMapping(value = "")
    public String list(Model model) {
        model.addAttribute("columns", columnChoices);
        model.addAttribute("tableChoices", tableChoices);
        model.addAttribute("all",ConsultantData.findAll());
        model.addAttribute("consultants", ConsultantData.getAllConsultants());
        model.addAttribute("names", ConsultantData.getAllNames());
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
        consultants = ConsultantData.findAll();
        model.addAttribute("title", "All Consultants");
        model.addAttribute("consultants", consultants);

        return "list-consultants";
    }
}

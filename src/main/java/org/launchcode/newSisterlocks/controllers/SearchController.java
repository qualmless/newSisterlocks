package org.launchcode.newSisterlocks.controllers;

import org.launchcode.newSisterlocks.models.*;
import org.launchcode.newSisterlocks.models.ConsultantData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import static org.launchcode.newSisterlocks.controllers.HomeController.columnChoices;
import static org.launchcode.newSisterlocks.controllers.HomeController.tableChoices;

import java.util.ArrayList;

@Controller
@RequestMapping("search")
public class SearchController {

//    @RequestMapping(value = "")
//    public String search(Model model) {
//        model.addAttribute("columns", columnChoices);
//        model.addAttribute("tableChoices", tableChoices);
//        model.addAttribute("all",ConsultantData.findAll());
//        model.addAttribute("consultants", ConsultantData.getAllConsultants());
//        model.addAttribute("names", ConsultantData.getAllNames());
//        model.addAttribute("cities", ConsultantData.getAllCities());
//        model.addAttribute("states", ConsultantData.getAllStates());
//        model.addAttribute("zipCodes", ConsultantData.getAllZipCodes());
//        model.addAttribute("consultantLevel", ConsultantType.values());
//        return "search";
//    }



// TODO: make search respond to actual data

    @PostMapping(value = "")
    public String displaySearchResults(Model model,
//                                       Consultant consultants,
                                       @RequestParam (required = false, name="consultantType", defaultValue = "anyType") String consultantLevel,
                                       @RequestParam (required = false, defaultValue = "false") Boolean salonOnly,
                                       @RequestParam (required = false) String city,
                                       @RequestParam (required = false) String state){
//        model.addAttribute("columns", columnChoices);
        ArrayList<Consultant> consultants = new ArrayList<>();

        if (salonOnly){
//            consultants = ConsultantData.findByColumnAndValue(salonOnly.toString().toLowerCase(), );
            consultants=ConsultantData.findByColumnAndValue("salonOnly","true");
            model.addAttribute("title", "Consultants in Salon Only");
            model.addAttribute("tableChoices", tableChoices);
        }
//        else if (city.toLowerCase().equals(columnChoices.get(city))) {
//            consultants = ConsultantData.findByColumnAndValue(columnChoices.get(city), city);
//            model.addAttribute("title", "Consultants in " + columnChoices.get(city));
//        }
//        else if (consultantLevel.equals(columnChoices.get(consultantLevel))){
//            consultants=ConsultantData.findByColumnAndValue(consultantLevel,consultantLevel);
//            model.addAttribute("title","Consultants with " + columnChoices.get(consultantLevel)+" Level");
//        }
//
//        else if (state.equals(columnChoices.get(state))){
//            consultants=ConsultantData.findByColumnAndValue(state,state);
//            model.addAttribute("title","Consultants in " + columnChoices.get(state));
//        }

        else {
//            consultants = ConsultantData.findByColumnAndValue(consultantLevel, consultantLevel);
            consultants=ConsultantData.findAll();
            model.addAttribute("tableChoices", tableChoices);
            model.addAttribute("title", "All Consultants");
        }

//        else {
//            if(consultantLevel.toLowerCase().equals(ConsultantType.values() ) ) {
//                consultants=ConsultantData.findByValue(ConsultantType.values().toString());
//                model.addAttribute("title",consultantLevel +"Level Stylists");
//            }
//        }

        model.addAttribute("consultants", consultants);
        return "search";
    }

//    @RequestMapping(value = "results")
//    public String listConsultantsByColumnAndValue(Model model,
//                                                  @RequestParam String column,
//                                                  @RequestParam String value) {
//        ArrayList<Consultant> consultants;
//        if (column.toLowerCase().equals("all")){
//            consultants = ConsultantData.findAll();
//            model.addAttribute("title", "All Jobs");
//        } else {
//            consultants = ConsultantData.findByColumnAndValue(column, value);
//            model.addAttribute("title", "Jobs with " + columnChoices.get(column) + ": " + value);
//        }
//        model.addAttribute("jobs", consultants);
//
//        return "search";
//    }


}

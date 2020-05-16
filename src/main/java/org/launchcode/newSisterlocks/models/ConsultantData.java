package org.launchcode.newSisterlocks.models;

import java.util.ArrayList;

public class ConsultantData {

    private static final String DATA_FILE = "consultant_data.csv";
    private static boolean isDataLoaded = false;

    private static ArrayList<Consultant> allConsultants;
    private static ArrayList<City> allCities = new ArrayList<>();
    private static ArrayList<State> allStates = new ArrayList<>();
    private static ArrayList<Zip> allZips = new ArrayList<>();


//    public static ArrayList<Employer> getAllEmployers() {
//        loadData();
//        allEmployers.sort(new NameSorter());
//        return allEmployers;
//    }
//
//    public static ArrayList<Location> getAllLocations() {
//        loadData();
//        allLocations.sort(new NameSorter());
//        return allLocations;
//    }
//
//    public static ArrayList<PositionType> getAllPositionTypes() {
//        loadData();
//        allPositionTypes.sort(new NameSorter());
//        return allPositionTypes;
//    }
//
//    public static ArrayList<CoreCompetency> getAllCoreCompetency() {
//        loadData();
//        allCoreCompetency.sort(new NameSorter());
//        return allCoreCompetency;
//    }

}

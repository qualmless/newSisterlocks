package org.launchcode.newSisterlocks.models;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.launchcode.newSisterlocks.NameSorter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class ConsultantData {

    private static final String DATA_FILE = "consultant_data.csv";
    private static boolean isDataLoaded = false;

    private static ArrayList<Consultant> allConsultants;
    private static ArrayList<Name> allNames;
    private static ArrayList<City> allCities = new ArrayList<>();
    private static ArrayList<State> allStates = new ArrayList<>();
    private static ArrayList<ZipCode> allZipCodes = new ArrayList<>();


    /**
     * Fetch list of all consultant objects from loaded data,
     * without duplicates, then return a copy.
     */
    public static ArrayList<Consultant> findAll() {

        // load data, if not already loaded
        loadData();

        // Bonus mission; normal version returns allConsultants
        return new ArrayList<>(allConsultants);
    }

    /**
     * Returns the results of searching the Consultants data by field and search term.
     *
     * For example, searching for employer "Enterprise" will include results
     * with "Enterprise Holdings, Inc".
     *
     * @param column Consultant field that should be searched.
     * @param value Value of the field to search for.
     * @return List of all consultants matching the criteria.
     */
    public static ArrayList<Consultant> findByColumnAndValue(String column, String value) {

        // load data, if not already loaded
        loadData();

        ArrayList<Consultant> consultants = new ArrayList<>();

        if (value.toLowerCase().equals("all")){
            return findAll();
        }

        if (column.equals("all")){
            consultants = findByValue(value);
            return consultants;
        }
        for (Consultant consultant : allConsultants) {

            String aValue = getFieldValue(consultant, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                consultants.add(consultant);
            }
        }

        return consultants;
    }


    public static String getFieldValue(Consultant consultant, String fieldName){

        String theValue = "";

        if (fieldName.equals("name")){
            theValue = consultant.getName();
        } else if (fieldName.equals("city")){
            theValue = consultant.getCity().toString();
        } else if (fieldName.equals("state")){
            theValue = consultant.getState().toString();
        } else if (fieldName.equals("zipCode")){
            theValue = consultant.getZipCode().toString();
        }

        return theValue;
    }

    /**
     * Search all Consultant fields for the given term.
     *
     * @param value The search term to look for.
     * @return      List of all consultants with at least one field containing the value.
     */
    public static ArrayList<Consultant> findByValue(String value) {

        // load data, if not already loaded
        loadData();

        ArrayList<Consultant> consultants = new ArrayList<>();

        for (Consultant consultant : allConsultants) {

            if (consultant.getName().toLowerCase().contains(value.toLowerCase())) {
                consultants.add(consultant);
            } else if (consultant.getCity().toString().toLowerCase().contains(value.toLowerCase())) {
                consultants.add(consultant);
            } else if (consultant.getState().toString().toLowerCase().contains(value.toLowerCase())) {
                consultants.add(consultant);
            } else if (consultant.getZipCode().toString().toLowerCase().contains(value.toLowerCase())) {
                consultants.add(consultant);
            }

        }

        return consultants;
    }

    private static Object findExistingObject(ArrayList list, String value){
        for (Object item : list){
            if (item.toString().toLowerCase().equals(value.toLowerCase())){
                return item;
            }
        }
        return null;
    }


    /**
     * Read in data from a CSV file and store it in an ArrayList of consultant objects.
     */
    private static void loadData() {

        // Only load data once
        if (isDataLoaded) {
            return;
        }

        try {

            // Open the CSV file and set up pull out column header info and records
            Resource resource = new ClassPathResource(DATA_FILE);
            InputStream is = resource.getInputStream();
            Reader reader = new InputStreamReader(is);
            CSVParser parser = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(reader);
            List<CSVRecord> records = parser.getRecords();
            Integer numberOfColumns = records.get(0).size();
            String[] headers = parser.getHeaderMap().keySet().toArray(new String[numberOfColumns]);

            allConsultants = new ArrayList<>();

            // Put the records into a more friendly format
            for (CSVRecord record : records) {


                String aName = record.get(0);
                String anAddress = record.get(1);
                String aCity = record.get(2);
                String aState = record.get(3);
                String aZipCode = record.get(4);
                String aPhoneNumber = record.get(5);
                String anEmail = record.get(6);
                String betweenSalonOrHome = record.get(7);
                String aSalonName = record.get(8);
                String betweenTraineeOrConsultant = record.get(9);

                Name newName = (Name) findExistingObject(allNames, aName);
                City newCity = (City) findExistingObject(allCities, aCity);
                State newState = (State) findExistingObject(allStates, aState);
                ZipCode newZipCode = (ZipCode) findExistingObject(allZipCodes, aZipCode);

                if (newName == null){
                    newName = new Name(aName);
                    allNames.add(newName);
                }

                if (newCity == null){
                    newCity = new City(aCity);
                    allCities.add(newCity);
                }

                if (newState == null){
                    newState = new State(aState);
                    allStates.add(newState);
                }

                if (newZipCode == null){
                    newZipCode = new ZipCode(aZipCode);
                    allZipCodes.add(newZipCode);
                }

                Consultant newConsultant = new Consultant(aName, anAddress, aCity, aState, aZipCode,aPhoneNumber,anEmail,betweenSalonOrHome,aSalonName,betweenTraineeOrConsultant);

                allConsultants.add(newConsultant);
            }
            // flag the data as loaded, so we don't do it twice
            isDataLoaded = true;

        } catch (IOException e) {
            System.out.println("Failed to load consultant info");
            e.printStackTrace();
        }
    }



    public static ArrayList<Consultant> getAllConsultants() {
        loadData();
        allConsultants.sort(new NameSorter());
        return allConsultants;
    }

    public static ArrayList<City> getAllCities() {
        loadData();
        allCities.sort(new NameSorter());
        return allCities;
    }

    public static ArrayList<State> getAllStates() {
        loadData();
        allStates.sort(new NameSorter());
        return allStates;
    }

    public static ArrayList<ZipCode> getAllZipCodes() {
        loadData();
        allZipCodes.sort(new NameSorter());
        return allZipCodes;
    }

}

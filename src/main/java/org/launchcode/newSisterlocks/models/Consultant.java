package org.launchcode.newSisterlocks.models;

import java.util.Objects;

public class Consultant {

    private int id;
    private static int nextId = 1;

    private String name;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String email;
    private String salonOrHome;
    private String salonName;


    // Initialize a unique ID.
    public Consultant() {
        id = nextId;
        nextId++;
    }

    // Initialize the id and value fields.
    public Consultant(String name,
               String address,
               String city,
               String state,
               String zipCode,
               String phoneNumber,
               String email,
               String salonOrHome,
               String salonName) {
        this();
        this.name=name;
        this.address=address;
        this.city=city;
        this.state=state;
        this.zipCode=zipCode;
        this.phoneNumber=phoneNumber;
        this.email=email;
        this.salonOrHome=salonOrHome;
        this.salonName=salonName;
    }

    public Consultant(String aName, String anAddress, String aCity, String aState, String aZipCode, String aPhoneNumber, String anEmail, String betweenSalonOrHome, String aSalonName, String betweenTraineeOrConsultant) {

    }


    //equals and hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consultant that = (Consultant) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalonOrHome() {
        return salonOrHome;
    }

    public void setSalonOrHome(String salonOrHome) {
        this.salonOrHome = salonOrHome;
    }

    public String getSalonName() {
        return salonName;
    }

    public void setSalonName(String salonName) {
        this.salonName = salonName;
    }
}

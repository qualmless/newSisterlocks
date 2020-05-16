package org.launchcode.newSisterlocks.models;

public class Consultant {

    private int id;
    private static int nextId = 1;

    private String name;
    private String address;
    private String city;
    private String state;
    private Integer zipCode;
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
    public Consultant(String aName,
               String address,
               String city,
               String state,
               Integer zipCode,
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

}

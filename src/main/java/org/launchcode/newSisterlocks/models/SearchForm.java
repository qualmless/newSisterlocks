package org.launchcode.newSisterlocks.models;

public class SearchForm {

//    private String salonOrHome;
    private Boolean salonOnly;
    private String consultantLevel;
    private String zipCode;
    private String radius;


    public Boolean getSalonOnly() {
        return salonOnly;
    }

    public void setSalonOnly(Boolean salonOnly) {
        this.salonOnly = salonOnly;
    }

    public String getConsultantLevel() {
        return consultantLevel;
    }

    public void setConsultantLevel(String consultantLevel) {
        this.consultantLevel = consultantLevel;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }
}

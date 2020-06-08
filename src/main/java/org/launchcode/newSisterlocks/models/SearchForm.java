package org.launchcode.newSisterlocks.models;

import java.util.Objects;

public class SearchForm {

//    private String salonOrHome;
    private Boolean salonOnly;
    private ConsultantType consultantLevel;
    private String zipCode;
    private String radius;


    public Boolean getSalonOnly() {
        return salonOnly;
    }

    public void setSalonOnly(Boolean salonOnly) {
        this.salonOnly = salonOnly;
    }

    public ConsultantType getConsultantLevel() {
        return consultantLevel;
    }

    public void setConsultantLevel(ConsultantType consultantLevel) {
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



//    @Override
//    public String toString() {
//        return "SearchForm{" +
//                "salonOnly=" + salonOnly +
//                ", consultantLevel='" + consultantLevel + '\'' +
//                ", zipCode='" + zipCode + '\'' +
//                ", radius='" + radius + '\'' +
//                '}';
//    }

    //
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        SearchForm that = (SearchForm) o;
//        return Objects.equals(salonOnly, that.salonOnly) &&
//                Objects.equals(consultantLevel, that.consultantLevel) &&
//                Objects.equals(zipCode, that.zipCode) &&
//                Objects.equals(radius, that.radius);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(salonOnly, consultantLevel, zipCode, radius);
//    }
}

package org.launchcode.newSisterlocks.models;

public enum ConsultantType {

    TRAINEE("Trainee"),
    CONSULTANT("Consultant"),
    APPROVED("Approved");

    private final String displayName;

    ConsultantType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}

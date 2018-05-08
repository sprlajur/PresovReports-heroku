/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpo;

import presentation.TableDataFormatter;

/**
 *
 * @author sprlajur
 */
public class RPOStatutoryStakeholderEntry extends AbstractRPOEntry {

    private String type;

    /*if legal person*/
    private String fullName;

    private String formattedName;

    private String firstName;

    private String lastName;

    private String formattedAddress;

    private String street;

    private String regNr;

    private String buildingNr;

    private String postalCode;

    private String municipality;

    private String country;

    private String district;

    private String ico;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFormattedName() {
        if (formattedName == null) {
            return TableDataFormatter.dataOrEmptyString(firstName) + " " + TableDataFormatter.dataOrEmptyString(lastName);
        }
        return formattedName;
    }

    public void setFormattedName(String formattedName) {
        this.formattedName = formattedName;
    }

    public String getFormattedAddress() {
        if (formattedAddress != null) {
            return formattedAddress;
        }
        String result = "";
        boolean addSpace = false;
        if (street != null) {
            result = result + street;
            addSpace = true;
        }
        if (buildingNr != null) {
            if (addSpace) {
                result += " " + buildingNr;
            } else {
                result += buildingNr;
            }
        }
        if (postalCode != null) {
            result += ", " + postalCode;
        }
        if (municipality != null) {
            if (addSpace) {
                result += ", " + municipality;
            } else {
                result += municipality;
            }
        }
        if (country != null) {
            if (addSpace) {
                result += ", " + country;
            } else {
                result += country;
            }
        }
        return result;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getRegNr() {
        return regNr;
    }

    public void setRegNr(String regNr) {
        this.regNr = regNr;
    }

    public String getBuildingNr() {
        return buildingNr;
    }

    public void setBuildingNr(String buildingNr) {
        this.buildingNr = buildingNr;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}

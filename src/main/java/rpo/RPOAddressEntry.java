/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpo;

/**
 *
 * @author sprlajur
 */
public class RPOAddressEntry extends AbstractRPOEntry {

    private String street;
    private String country;
    private String postalCode;
    private String municipality;
    private Integer reg_nr;
    private String building_nr;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public Integer getReg_nr() {
        return reg_nr;
    }

    public void setReg_nr(Integer reg_nr) {
        this.reg_nr = reg_nr;
    }

    public String getBuilding_nr() {
        return building_nr;
    }

    public void setBuilding_nr(String building_nr) {
        this.building_nr = building_nr;
    }

    public String getFormattedAddress() {
        String result = "";
        boolean addSpace = false;
        if (street != null) {
            result = result + street;
            addSpace = true;
        }
        if (building_nr != null) {
            if (addSpace) {
                result += " " + building_nr;
            } else {
                result += building_nr;
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

}

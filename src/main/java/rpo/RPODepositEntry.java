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
public class RPODepositEntry extends AbstractRPOEntry {

    /*	Used if the depositor is a legal person*/
    private String fullName;

    private String personFormattedName;

    private float amount;

    private String currency;

    private String type;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPersonFormattedName() {
        return personFormattedName;
    }

    public void setPersonFormattedName(String personFormattedName) {
        this.personFormattedName = personFormattedName;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}

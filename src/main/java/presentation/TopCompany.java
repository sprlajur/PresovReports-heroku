/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.math.BigDecimal;

/**
 *
 * @author sprlajur
 */
public class TopCompany {

    private String name;

    private String ico;

    private BigDecimal amount;

    public TopCompany(String name, String ico, BigDecimal amount) {
        this.name = name;
        this.ico = ico;
        this.amount = amount;
    }
    
    public TopCompany(String name, String ico, Long amount) {
        this.name = name;
        this.ico = ico;
        this.amount = new BigDecimal(amount);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}

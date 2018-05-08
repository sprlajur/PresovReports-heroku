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
public class RPOEquityEntry extends AbstractRPOEntry {

    private float investmentAmount;

    private String investmentCurrency;

    private float paidAmount;

    private String paidCurrency;

    private float approvedAmount;

    private String approvedCurrency;

    public float getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(float investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public String getInvestmentCurrency() {
        return investmentCurrency;
    }

    public void setInvestmentCurrency(String investmentCurrency) {
        this.investmentCurrency = investmentCurrency;
    }

    public float getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(float paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getPaidCurrency() {
        return paidCurrency;
    }

    public void setPaidCurrency(String paidCurrency) {
        this.paidCurrency = paidCurrency;
    }

    public float getApprovedAmount() {
        return approvedAmount;
    }

    public void setApprovedAmount(float approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    public String getApprovedCurrency() {
        return approvedCurrency;
    }

    public void setApprovedCurrency(String approvedCurrency) {
        this.approvedCurrency = approvedCurrency;
    }

}

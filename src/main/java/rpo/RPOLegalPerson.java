/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author sprlajur
 */
public class RPOLegalPerson {

//    available through premium API
    private int rpo_id;

    private String name;

    private String formatted_address;

    private LocalDateTime createdAt;

    private LocalDate established_on;

    private LocalDate terminated_on;

    private String registration_office;

    private String registration_nr;

//    available through RPO api
    private String source_register;

    private String rpo_API_url;

    private String accounting_entities_API_url;

    private List<RPOAddressEntry> addressEntries;

    private List<RPOOneStringEntry> alternateNameEntries;

    private List<RPOOneStringEntry> nameEntries;

    private List<RPOOneStringEntry> authorizationEntries;

    private List<RPODepositEntry> depositEntries;

    private List<RPOOneStringEntry> economicActivityEntries;

    private List<RPOEquityEntry> equityEntries;

    private List<RPOOneStringEntry> legalFormEntries;

    private List<RPOOneStringEntry> legalStatusEntries;

    private List<RPOShareEntry> shareEntries;

    private List<RPOPredecessorSuccessorEntry> predecessorEntries;

    private List<RPOPredecessorSuccessorEntry> successorEntries;

    private List<RPOStatutoryStakeholderEntry> stakeholderEntries;

    private List<RPOStatutoryStakeholderEntry> statutoryEntries;

    private String mainActivityCode;

    private String esa2010Code;

    private String skNACECategory;

    private String organizationSize;

    private String ownershipType;

    public void setRegistration_nr(String registration_nr) {
        this.registration_nr = registration_nr;
    }

    public String getRegistration_nr() {
        return registration_nr;
    }

    public int getRpo_id() {
        return rpo_id;
    }

    public String getName() {
        return name;
    }

    public String getFormatted_address() {
        return formatted_address;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDate getEstablished_on() {
        return established_on;
    }

    public LocalDate getTerminated_on() {
        return terminated_on;
    }

    public String getRegistration_office() {
        return registration_office;
    }

    public void setRpo_id(int rpo_id) {
        this.rpo_id = rpo_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFormatted_address(String formatted_address) {
        this.formatted_address = formatted_address;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setEstablished_on(LocalDate established_on) {
        this.established_on = established_on;
    }

    public void setTerminated_on(LocalDate terminated_on) {
        this.terminated_on = terminated_on;
    }

    public void setRegistration_office(String registration_office) {
        this.registration_office = registration_office;
    }

    public String getSource_register() {
        return source_register;
    }

    public String getRpo_API_url() {
        return rpo_API_url;
    }

    public String getAccounting_entities_API_url() {
        return accounting_entities_API_url;
    }

    public void setSource_register(String source_register) {
        this.source_register = source_register;
    }

    public void setRpo_API_url(String rpo_API_url) {
        this.rpo_API_url = rpo_API_url;
    }

    public void setAccounting_entities_API_url(String accounting_entities_API_url) {
        this.accounting_entities_API_url = accounting_entities_API_url;
    }

    public List<RPOAddressEntry> getAddressEntries() {
        return addressEntries;
    }

    public void setAddressEntries(List<RPOAddressEntry> addressEntries) {
        this.addressEntries = addressEntries;
    }

    public List<RPOOneStringEntry> getAlternateNameEntries() {
        return alternateNameEntries;
    }

    public void setAlternateNameEntries(List<RPOOneStringEntry> alternateNames) {
        this.alternateNameEntries = alternateNames;
    }

    public String getMainActivityCode() {
        return mainActivityCode;
    }

    public void setMainActivityCode(String mainActivityCode) {
        this.mainActivityCode = mainActivityCode;
    }

    public String getEsa2010Code() {
        return esa2010Code;
    }

    public void setEsa2010Code(String esa2010Code) {
        this.esa2010Code = esa2010Code;
    }

    public List<RPODepositEntry> getDepositEntries() {
        return depositEntries;
    }

    public void setDepositEntries(List<RPODepositEntry> depositEntries) {
        this.depositEntries = depositEntries;
    }

    public List<RPOEquityEntry> getEquityEntries() {
        return equityEntries;
    }

    public void setEquityEntries(List<RPOEquityEntry> equityEntries) {
        this.equityEntries = equityEntries;
    }

    @Override
    public String toString() {
        return "RPOLegalPerson{" + "rpo_id=" + rpo_id + ", name=" + name + ", formatted_address=" + formatted_address + ", createdAt=" + createdAt + ", established_on=" + established_on + ", terminated_on=" + terminated_on + ", registration_office=" + registration_office + ", registration_nr=" + registration_nr + '}';
    }

    public List<RPOOneStringEntry> getLegalForms() {
        return legalFormEntries;
    }

    public void setLegalForms(List<RPOOneStringEntry> legalForms) {
        this.legalFormEntries = legalForms;
    }

    public List<RPOShareEntry> getShareEntries() {
        return shareEntries;
    }

    public void setShareEntries(List<RPOShareEntry> shareEntries) {
        this.shareEntries = shareEntries;
    }

    public List<RPOPredecessorSuccessorEntry> getPredecessorEntries() {
        return predecessorEntries;
    }

    public void setPredecessorEntries(List<RPOPredecessorSuccessorEntry> predecessorEntries) {
        this.predecessorEntries = predecessorEntries;
    }

    public List<RPOPredecessorSuccessorEntry> getSuccessorEntries() {
        return successorEntries;
    }

    public void setSuccessorEntries(List<RPOPredecessorSuccessorEntry> successorEntries) {
        this.successorEntries = successorEntries;
    }

    public List<RPOStatutoryStakeholderEntry> getStakeholderEntries() {
        return stakeholderEntries;
    }

    public void setStakeholderEntries(List<RPOStatutoryStakeholderEntry> stakeholderEntries) {
        this.stakeholderEntries = stakeholderEntries;
    }

    public List<RPOStatutoryStakeholderEntry> getStatutoryEntries() {
        return statutoryEntries;
    }

    public void setStatutoryEntries(List<RPOStatutoryStakeholderEntry> statutoryEntries) {
        this.statutoryEntries = statutoryEntries;
    }

    public List<RPOOneStringEntry> getAuthorizationEntries() {
        return authorizationEntries;
    }

    public void setAuthorizationEntries(List<RPOOneStringEntry> authorizationEntries) {
        this.authorizationEntries = authorizationEntries;
    }

    public List<RPOOneStringEntry> getLegalFormEntries() {
        return legalFormEntries;
    }

    public void setLegalFormEntries(List<RPOOneStringEntry> legalFormEntries) {
        this.legalFormEntries = legalFormEntries;
    }

    public List<RPOOneStringEntry> getLegalStatusEntries() {
        return legalStatusEntries;
    }

    public void setLegalStatusEntries(List<RPOOneStringEntry> legalStatusEntries) {
        this.legalStatusEntries = legalStatusEntries;
    }

    public List<RPOOneStringEntry> getNameEntries() {
        return nameEntries;
    }

    public void setNameEntries(List<RPOOneStringEntry> nameEntries) {
        this.nameEntries = nameEntries;
    }

    public List<RPOOneStringEntry> getEconomicActivityEntries() {
        return economicActivityEntries;
    }

    public void setEconomicActivityEntries(List<RPOOneStringEntry> economicActivityEntries) {
        this.economicActivityEntries = economicActivityEntries;
    }

    public String getSkNACECategory() {
        return skNACECategory;
    }

    public void setSkNACECategory(String skNACECategory) {
        this.skNACECategory = skNACECategory;
    }

    public String getOrganizationSize() {
        return organizationSize;
    }

    public void setOrganizationSize(String organizationSize) {
        this.organizationSize = organizationSize;
    }

    public String getOwnershipType() {
        return ownershipType;
    }

    public void setOwnershipType(String ownershipType) {
        this.ownershipType = ownershipType;
    }
    
    public String getCurrentLegalForm(){
        if(legalFormEntries == null || legalFormEntries.isEmpty()){
            return null;
        }
        RPOOneStringEntry lfe =  legalFormEntries.stream().filter(ea -> ea.getEffectiveTo() == null).findFirst().orElse(null);
        if(lfe != null){
            return lfe.getBody();
        }
        return null;
    }

}

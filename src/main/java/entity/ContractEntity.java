/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author sprlajur
 */
@Entity
@Table(name = "contracts")
@NamedQueries({
    @NamedQuery(name = ContractEntity.Q_CONTRACT_ENTITY_FIND_ALL, query = "SELECT c FROM ContractEntity c")
    ,
    @NamedQuery(name = ContractEntity.Q_CONTRACT_ENTITY_FIND_BY_ICO, query = "SELECT c FROM ContractEntity c where partiesIco like :" + ContractEntity.SQL_PARAM_ICO)
    ,
    @NamedQuery(name = ContractEntity.Q_CONTRACT_ENTITY_FIND_TOP_BY_PRICE, query = "SELECT c FROM ContractEntity c ORDER BY COALESCE(c.price, -1) DESC")
    ,
    @NamedQuery(name = ContractEntity.Q_CONTRACT_ENTITY_FIND_BY_CONTRACT_NR, query = "SELECT c FROM ContractEntity c where contractNr = :" + ContractEntity.SQL_PARAM_CONTRACT_NR)
    ,
    @NamedQuery(name = ContractEntity.Q_CONTRACT_ENTITY_FIND_BY_PARTIES, query = "SELECT c FROM ContractEntity c where parties like :" + ContractEntity.SQL_PARAM_PARTIES_SEARCHED_STRING)
    ,
    @NamedQuery(name = ContractEntity.Q_CONTRACT_ENTITY_FIND_BY_SUBJECT, query = "SELECT c FROM ContractEntity c where subject like :" + ContractEntity.SQL_PARAM_SUBJECT_SEARCHED_STRING)
    ,
    @NamedQuery(name = ContractEntity.Q_CONTRACT_ENTITY_FIND_BY_PARTIES_AND_SUBJECT, query = "SELECT c FROM ContractEntity c where parties like :" + ContractEntity.SQL_PARAM_PARTIES_SEARCHED_STRING
            + " and subject like :" + ContractEntity.SQL_PARAM_SUBJECT_SEARCHED_STRING)
})
public class ContractEntity implements Serializable {

    public static final String Q_CONTRACT_ENTITY_FIND_ALL = "ContractEntity.findAll";
    public static final String Q_CONTRACT_ENTITY_FIND_TOP_BY_PRICE = "ContractEntity.findTopByPrice";
    public static final String Q_CONTRACT_ENTITY_FIND_BY_CONTRACT_NR = "ContractEntity.findByContractNr";
    public static final String Q_CONTRACT_ENTITY_FIND_BY_PARTIES = "ContractEntity.Q_CONTRACT_ENTITY_FIND_BY_PARTIES";
    public static final String Q_CONTRACT_ENTITY_FIND_BY_SUBJECT = "ContractEntity.Q_CONTRACT_ENTITY_FIND_BY_TEXT";
    public static final String Q_CONTRACT_ENTITY_FIND_BY_PARTIES_AND_SUBJECT = "ContractEntity.Q_CONTRACT_ENTITY_FIND_BY_PARTIES_AND_TEXT";
    public static final String Q_CONTRACT_ENTITY_FIND_BY_ICO = "ContractEntity.Q_CONTRACT_ENTITY_FIND_BY_ICO";

    public static final String SQL_PARAM_CONTRACT_NR = "contractNr";
    public static final String SQL_PARAM_PARTIES_SEARCHED_STRING = "partiesSearchedString";
    public static final String SQL_PARAM_SUBJECT_SEARCHED_STRING = "subjectSearchedString";
    public static final String SQL_PARAM_ICO = "ico";

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 20)
    @Column(name = "contract_nr")
    private String contractNr;
    @Size(max = 255)
    @Column(name = "type")
    private String type;
    @Size(max = 255)
    @Column(name = "kind")
    private String kind;
    @Size(max = 2147483647)
    @Column(name = "parties")
    private String parties;
    @Size(max = 2147483647)
    @Column(name = "subject")
    private String subject;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private BigDecimal price;
    @Size(max = 255)
    @Column(name = "currency")
    private String currency;
    @Column(name = "signature_date")
    @Temporal(TemporalType.DATE)
    private Date signatureDate;
    @Column(name = "release_date")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;
    @Size(max = 1000)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "main_or_appendix")
    private String mainOrAppendix;
    @Size(max = 2147483647)
    @Column(name = "parties_ico")
    private String partiesIco;
    @Size(max = 2147483647)
    @Column(name = "parties_addresses")
    private String partiesAddresses;
    @Size(max = 255)
    @Column(name = "signature_place")
    private String signaturePlace;
    @Column(name = "validity_date")
    @Temporal(TemporalType.DATE)
    private Date validityDate;
    @Size(max = 2147483647)
    @Column(name = "release_notes")
    private String releaseNotes;
    @Column(name = "cadaster_approval_date")
    @Temporal(TemporalType.DATE)
    private Date cadasterApprovalDate;

    public ContractEntity() {
    }

    public ContractEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContractNr() {
        return contractNr;
    }

    public void setContractNr(String contractNr) {
        this.contractNr = contractNr;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getParties() {
        return parties;
    }

    public void setParties(String parties) {
        this.parties = parties;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getSignatureDate() {
        return signatureDate;
    }

    public void setSignatureDate(Date signatureDate) {
        this.signatureDate = signatureDate;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMainOrAppendix() {
        return mainOrAppendix;
    }

    public void setMainOrAppendix(String mainOrAppendix) {
        this.mainOrAppendix = mainOrAppendix;
    }

    public String getPartiesIco() {
        return partiesIco;
    }

    public void setPartiesIco(String partiesIco) {
        this.partiesIco = partiesIco;
    }

    public String getPartiesAddresses() {
        return partiesAddresses;
    }

    public void setPartiesAddresses(String partiesAddresses) {
        this.partiesAddresses = partiesAddresses;
    }

    public String getSignaturePlace() {
        return signaturePlace;
    }

    public void setSignaturePlace(String signaturePlace) {
        this.signaturePlace = signaturePlace;
    }

    public Date getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(Date validityDate) {
        this.validityDate = validityDate;
    }

    public String getReleaseNotes() {
        return releaseNotes;
    }

    public void setReleaseNotes(String releaseNotes) {
        this.releaseNotes = releaseNotes;
    }

    public Date getCadasterApprovalDate() {
        return cadasterApprovalDate;
    }

    public void setCadasterApprovalDate(Date cadasterApprovalDate) {
        this.cadasterApprovalDate = cadasterApprovalDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContractEntity)) {
            return false;
        }
        ContractEntity other = (ContractEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ContractEntity{" + "id=" + id + ", contractNr=" + contractNr + ", type=" + type + ", kind=" + kind + ", parties=" + parties + ", subject=" + subject + ", price=" + price + ", currency=" + currency + ", signatureDate=" + signatureDate + ", releaseDate=" + releaseDate + ", name=" + name + ", mainOrAppendix=" + mainOrAppendix + ", partiesIco=" + partiesIco + ", partiesAddresses=" + partiesAddresses + ", signaturePlace=" + signaturePlace + ", validityDate=" + validityDate + ", releaseNotes=" + releaseNotes + ", cadasterApprovalDate=" + cadasterApprovalDate + '}';
    }

}

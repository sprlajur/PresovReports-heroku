/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author sprlajur
 */
@Entity
@Table(name = "grants")
@NamedQueries({
    @NamedQuery(name = GrantEntity.Q_GRANT_ENTITY_FIND_ALL, query = "SELECT g FROM GrantEntity g")
    ,
    @NamedQuery(name = GrantEntity.Q_GRANT_ENTITY_FIND_BY_ICO, query = "SELECT g FROM GrantEntity g where applicantIco = :" + GrantEntity.SQL_PARAM_ICO)
    ,
    @NamedQuery(name = GrantEntity.Q_GRANT_ENTITY_FIND_TOP_BY_PRICE, query = "SELECT g FROM GrantEntity g ORDER BY COALESCE(g.approvedGrant,'-1') DESC")
})
public class GrantEntity implements Serializable {

    public static final String Q_GRANT_ENTITY_FIND_ALL = "GrantEntity.findAll";
    public static final String Q_GRANT_ENTITY_FIND_BY_ICO = "GrantEntity.findByICO";
    public static final String Q_GRANT_ENTITY_FIND_TOP_BY_PRICE = "GrantEntity.findTopByPrice";

    public static final String SQL_PARAM_ICO = "ico";

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "grant_year")
    private Integer grantYear;
    @Size(max = 255)
    @Column(name = "type")
    private String type;
    @Size(max = 255)
    @Column(name = "recurrence")
    private String recurrence;
    @Size(max = 255)
    @Column(name = "status")
    private String status;
    @Size(max = 2147483647)
    @Column(name = "action")
    private String action;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "approved_grant")
    private BigDecimal approvedGrant;
    @Size(max = 255)
    @Column(name = "currency")
    private String currency;
    @Size(max = 255)
    @Column(name = "applicant")
    private String applicant;
    @Size(max = 255)
    @Column(name = "applicant_address")
    private String applicantAddress;
    @Size(max = 255)
    @Column(name = "applicant_city")
    private String applicantCity;
    @Size(max = 25)
    @Column(name = "applicant_ico")
    private String applicantIco;
    @Size(max = 2147483647)
    @Column(name = "purpose")
    private String purpose;

    public GrantEntity() {
    }

    public GrantEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGrantYear() {
        return grantYear;
    }

    public void setGrantYear(Integer grantYear) {
        this.grantYear = grantYear;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(String recurrence) {
        this.recurrence = recurrence;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public BigDecimal getApprovedGrant() {
        return approvedGrant;
    }

    public void setApprovedGrant(BigDecimal approvedGrant) {
        this.approvedGrant = approvedGrant;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getApplicantAddress() {
        return applicantAddress;
    }

    public void setApplicantAddress(String applicantAddress) {
        this.applicantAddress = applicantAddress;
    }

    public String getApplicantCity() {
        return applicantCity;
    }

    public void setApplicantCity(String applicantCity) {
        this.applicantCity = applicantCity;
    }

    public String getApplicantIco() {
        return applicantIco;
    }

    public void setApplicantIco(String applicantIco) {
        this.applicantIco = applicantIco;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
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
        if (!(object instanceof GrantEntity)) {
            return false;
        }
        GrantEntity other = (GrantEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.GrantEntity[ id=" + id + " ]";
    }

}

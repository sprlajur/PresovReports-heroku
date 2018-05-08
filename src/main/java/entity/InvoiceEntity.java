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
@Table(name = "invoices")
@NamedQueries({
    @NamedQuery(name = InvoiceEntity.Q_INVOICE_ENTITY_FIND_ALL, query = "SELECT i FROM InvoiceEntity i")
    ,
    @NamedQuery(name = InvoiceEntity.Q_INVOICE_ENTITY_FIND_TOP_SUPPLIERS_BY_TOTAL_AMOUNT, query = "SELECT NEW presentation.TopCompany(i.supplier, i.supplierIco, SUM(i.price)) FROM InvoiceEntity i WHERE i.paymentStatus = 'zaplatené' GROUP BY i.supplier, i.supplierIco ORDER BY SUM(i.price) DESC")
        ,
    @NamedQuery(name = InvoiceEntity.Q_INVOICE_ENTITY_FIND_TOP_SUPPLIERS_BY_NR_OF_INVOICES, query = "SELECT NEW presentation.TopCompany(i.supplier, i.supplierIco, COUNT(i.supplier)) FROM InvoiceEntity i WHERE i.paymentStatus = 'zaplatené' GROUP BY i.supplier, i.supplierIco ORDER BY COUNT(i.supplierIco) DESC")
        ,
    @NamedQuery(name = InvoiceEntity.Q_INVOICE_ENTITY_FIND_TOP_INVOICES_BY_PRICE, query = "SELECT i FROM InvoiceEntity i WHERE i.paymentStatus = 'zaplatené' ORDER BY I.price DESC")
})
public class InvoiceEntity implements Serializable {

    public static final String Q_INVOICE_ENTITY_FIND_ALL = "InvoiceEntity.findAll";
    public static final String Q_INVOICE_ENTITY_FIND_TOP_SUPPLIERS_BY_TOTAL_AMOUNT = "InvoiceEntity.findTopSuppliersByTotalAmount";
    public static final String Q_INVOICE_ENTITY_FIND_TOP_SUPPLIERS_BY_NR_OF_INVOICES = "InvoiceEntity.findTopSuppliersByNrOfInvoices";
    public static final String Q_INVOICE_ENTITY_FIND_TOP_INVOICES_BY_PRICE = "InvoiceEntity.findTopInvociesByPrice";
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "internal_invoice_nr")
    private String internalInvoiceNr;
    @Size(max = 255)
    @Column(name = "supplier")
    private String supplier;
    @Size(max = 255)
    @Column(name = "organization_name")
    private String organizationName;
    @Size(max = 2147483647)
    @Column(name = "payment_description")
    private String paymentDescription;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private BigDecimal price;
    @Size(max = 255)
    @Column(name = "currency")
    private String currency;
    @Column(name = "payment_date")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;
    @Size(max = 20)
    @Column(name = "contract_nr")
    private String contractNr;
    @Size(max = 255)
    @Column(name = "order_nr")
    private String orderNr;
    @Column(name = "release_date")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;
    @Size(max = 255)
    @Column(name = "supplier_ico")
    private String supplierIco;
    @Size(max = 2147483647)
    @Column(name = "supplier_address")
    private String supplierAddress;
    @Size(max = 255)
    @Column(name = "payment_status")
    private String paymentStatus;
    @Size(max = 255)
    @Column(name = "structure_office")
    private String structureOffice;
    @Size(max = 255)
    @Column(name = "invoice_nr")
    private String invoiceNr;
    @Size(max = 255)
    @Column(name = "final_deposit")
    private String finalDeposit;
    @Size(max = 255)
    @Column(name = "completement_status")
    private String completementStatus;

    public InvoiceEntity() {
    }

    public InvoiceEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInternalInvoiceNr() {
        return internalInvoiceNr;
    }

    public void setInternalInvoiceNr(String internalInvoiceNr) {
        this.internalInvoiceNr = internalInvoiceNr;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getPaymentDescription() {
        return paymentDescription;
    }

    public void setPaymentDescription(String paymentDescription) {
        this.paymentDescription = paymentDescription;
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

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getContractNr() {
        return contractNr;
    }

    public void setContractNr(String contractNr) {
        this.contractNr = contractNr;
    }

    public String getOrderNr() {
        return orderNr;
    }

    public void setOrderNr(String orderNr) {
        this.orderNr = orderNr;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getSupplierIco() {
        if (supplierIco != null) {
            return supplierIco.trim();
        }
        return supplierIco;
    }

    public void setSupplierIco(String supplierIco) {
        this.supplierIco = supplierIco;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getStructureOffice() {
        return structureOffice;
    }

    public void setStructureOffice(String structureOffice) {
        this.structureOffice = structureOffice;
    }

    public String getInvoiceNr() {
        return invoiceNr;
    }

    public void setInvoiceNr(String invoiceNr) {
        this.invoiceNr = invoiceNr;
    }

    public String getFinalDeposit() {
        return finalDeposit;
    }

    public void setFinalDeposit(String finalDeposit) {
        this.finalDeposit = finalDeposit;
    }

    public String getCompletementStatus() {
        return completementStatus;
    }

    public void setCompletementStatus(String completementStatus) {
        this.completementStatus = completementStatus;
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
        if (!(object instanceof InvoiceEntity)) {
            return false;
        }
        InvoiceEntity other = (InvoiceEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.InvoiceEntity[ id=" + id + " ]";
    }

}

package com.bala.pizza.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author engan.bala
 */
@Entity(name="ORDER")
@XmlRootElement
public class OnlineOrder implements Serializable {

	private static final long serialVersionUID = 1L;
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ORDER_ID")
    private Long orderId;
    
	@Column(name = "CUSTOMER_NAME")
    private String customerName;
	
    @Column(name = "CUSTOMER_ADDRESS")
    private String customerAddress;
    
    @Column(name = "CUSTOMER_CONTACT")
    private String customerContact;
    
    @Column(name = "TOTAL_AMOUNT")
    private BigDecimal totalAmount;
    
    @Column(name = "DELIVERY_NOTE")
    private String deliveryNote;
    
    @OneToMany(mappedBy = "orderId")
    private Collection<PizzaOrder> pizzaOrderCollection;

    public OnlineOrder() {
    }

    public OnlineOrder(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(String customerContact) {
        this.customerContact = customerContact;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getDeliveryNote() {
        return deliveryNote;
    }

    public void setDeliveryNote(String deliveryNote) {
        this.deliveryNote = deliveryNote;
    }

    @XmlTransient
    public Collection<PizzaOrder> getPizzaOrderCollection() {
        return pizzaOrderCollection;
    }

    public void setPizzaOrderCollection(Collection<PizzaOrder> pizzaOrderCollection) {
        this.pizzaOrderCollection = pizzaOrderCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof OnlineOrder)) {
            return false;
        }
        OnlineOrder other = (OnlineOrder) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pizzashop.OnlineOrder[ orderId=" + orderId + " ]";
    }
    
}

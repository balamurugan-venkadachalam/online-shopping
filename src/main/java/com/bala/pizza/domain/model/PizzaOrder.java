package com.bala.pizza.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 *
 * @author engan.bala
 */
@Entity(name="PizzaOrder")
@Table(name="PIZZA_ORDER")
@XmlRootElement
public class PizzaOrder implements Serializable {

	private static final long serialVersionUID = 1L;
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ORDER_ID")
    private Long orderId;
    
	@NotNull(message="Customer name mandatory")
	@Column(name = "CUSTOMER_NAME")
    private String customerName;
	
	@NotNull(message="Customer address mandatory")
    @Column(name = "CUSTOMER_ADDRESS")
    private String customerAddress;
    
	@NotNull(message="Customer contact number mandatory")
    @Column(name = "CUSTOMER_CONTACT")
    private String customerContact;
    
    @Column(name = "TOTAL_AMOUNT")
    private BigDecimal totalAmount;
    
    @Column(name = "DELIVERY_NOTE")
    private String deliveryNote;
    
    @Column(name = "ORDER_DATE")
    private Date orderDate;
    
    @Column(name = "DELIVER_DATE")
    private Date deliverDate;
    
    @NotNull(message="Atleast one line item mandatory")
    @OneToMany(mappedBy = "pizzaOrder", fetch = FetchType.EAGER, cascade = { CascadeType.ALL }, orphanRemoval = true )
    @JsonManagedReference
    private Collection<PizzaLineItem> pizzaOrderCollection =  new ArrayList<>();

    public PizzaOrder() {
    }

    public PizzaOrder(Long orderId) {
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
    public Collection<PizzaLineItem> getPizzaLineItemCollection() {
        return pizzaOrderCollection;
    }

    public void setPizzaLineItemCollection(Collection<PizzaLineItem> pizzaOrderCollection) {
        this.pizzaOrderCollection = pizzaOrderCollection;
    }
    
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getDeliverDate() {
		return deliverDate;
	}

	public void setDeliverDate(Date deliverDate) {
		this.deliverDate = deliverDate;
	}

	public void addAmount(BigDecimal price){
		this.setTotalAmount(this.getTotalAmount().add(price));
	}

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PizzaOrder)) {
            return false;
        }
        PizzaOrder other = (PizzaOrder) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "PizzaOrder [orderId=" + orderId + ", customerName=" + customerName + ", customerAddress="
				+ customerAddress + ", customerContact=" + customerContact + ", totalAmount=" + totalAmount
				+ ", deliveryNote=" + deliveryNote + ", pizzaOrderCollection=" + pizzaOrderCollection + "]";
	}

   
    
}

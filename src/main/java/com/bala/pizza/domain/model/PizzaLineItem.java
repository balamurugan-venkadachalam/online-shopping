package com.bala.pizza.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 *
 * @author engan.bala
 */
@Entity(name = "PizzaLineItem")
@Table(name="PIZZA_ORDER")
@XmlRootElement
public class PizzaLineItem implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "PIZZA_ORDER_ID")
	private Integer pizzaOrderId;
	
    @JoinColumn(name = "PIZZA_SIZE_ID", referencedColumnName = "PIZZA_SIZE_ID")
    @ManyToOne
    private PizzaSize pizzaSizeId;
	
	@Column(name = "PRICE")
	private BigDecimal price;
	
	@Column(name = "NOTES")
	private String notes;
	
	@JoinColumn(name = "CRUST_ID", referencedColumnName = "CUST_ID")
	@ManyToOne
	private Crust crustId;
	
	@JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")
	@ManyToOne
	@JsonBackReference
	private PizzaOrder orderId;
	
	@JoinColumn(name = "PIZZA_ID", referencedColumnName = "PIZZA_ID")
	@ManyToOne
	private Pizza pizzaId;
	
	@OneToMany(mappedBy = "pizzaOrderId", fetch = FetchType.LAZY, cascade = { CascadeType.ALL }, orphanRemoval = true )
	@JsonManagedReference
	private Collection<PizzaTopping> pizzaToppingCollection =  new ArrayList<>();

	public PizzaLineItem() {
	}

	public PizzaLineItem(Integer pizzaOrderId) {
		this.pizzaOrderId = pizzaOrderId;
	}

	public Integer getPizzaOrderId() {
		return pizzaOrderId;
	}

	public void setPizzaOrderId(Integer pizzaOrderId) {
		this.pizzaOrderId = pizzaOrderId;
	}

    public PizzaSize getPizzaSizeId() {
        return pizzaSizeId;
    }

    public void setPizzaSizeId(PizzaSize pizzaSizeId) {
        this.pizzaSizeId = pizzaSizeId;
    }

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Crust getCrustId() {
		return crustId;
	}

	public void setCrustId(Crust crustId) {
		this.crustId = crustId;
	}

	public PizzaOrder getOrderId() {
		return orderId;
	}

	public void setOrderId(PizzaOrder orderId) {
		this.orderId = orderId;
	}

	public Pizza getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(Pizza pizzaId) {
		this.pizzaId = pizzaId;
	}
	
	public void addPrice(BigDecimal price){
		this.setPrice(this.getPrice().add(price));
	}

	@XmlTransient
	public Collection<PizzaTopping> getPizzaToppingCollection() {
		return pizzaToppingCollection;
	}

	public void setPizzaToppingCollection(Collection<PizzaTopping> pizzaToppingCollection) {
		this.pizzaToppingCollection = pizzaToppingCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (pizzaOrderId != null ? pizzaOrderId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof PizzaLineItem)) {
			return false;
		}
		PizzaLineItem other = (PizzaLineItem) object;
		if ((this.pizzaOrderId == null && other.pizzaOrderId != null)
				|| (this.pizzaOrderId != null && !this.pizzaOrderId.equals(other.pizzaOrderId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "pizzashop.PizzaOrder[ pizzaOrderId=" + pizzaOrderId + " ]";
	}

}

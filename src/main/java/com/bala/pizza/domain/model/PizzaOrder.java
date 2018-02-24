package com.bala.pizza.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author engan.bala
 */
@Entity(name = "PIZZA_ORDER")
@XmlRootElement
public class PizzaOrder implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
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
	private OnlineOrder orderId;
	
	@JoinColumn(name = "PIZZA_ID", referencedColumnName = "PIZZA_ID")
	@ManyToOne
	private Pizza pizzaId;
	
	@OneToMany(mappedBy = "pizzaOrderId")
	private Collection<PizzaTopping> pizzaToppingCollection;

	public PizzaOrder() {
	}

	public PizzaOrder(Integer pizzaOrderId) {
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

	public OnlineOrder getOrderId() {
		return orderId;
	}

	public void setOrderId(OnlineOrder orderId) {
		this.orderId = orderId;
	}

	public Pizza getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(Pizza pizzaId) {
		this.pizzaId = pizzaId;
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
		if (!(object instanceof PizzaOrder)) {
			return false;
		}
		PizzaOrder other = (PizzaOrder) object;
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

package com.bala.pizza.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 *
 * @author engan.bala
 */
@Entity(name = "PizzaLineItem")
@Table(name="PIZZA_LINE_ITEM")
@XmlRootElement
public class PizzaLineItem implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "LINE_ITEM_ID")
	private Integer pizzaLineItem;
	
	@NotNull(message="Pizza size mandatory")
    @JoinColumn(name = "PIZZA_SIZE_ID", referencedColumnName = "PIZZA_SIZE_ID")
    @ManyToOne
    private PizzaSize pizzaSize;
	
	@Column(name = "PRICE")
	private BigDecimal price;
	
	@Column(name = "NOTES")
	private String notes;
	
	@NotNull(message="Crust mandatory")
	@JoinColumn(name = "CRUST_ID", referencedColumnName = "CUST_ID")
	@ManyToOne
	private Crust crust;
	
	@JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")
	@ManyToOne
	@JsonBackReference
	private PizzaOrder pizzaOrder;
	
	@NotNull(message="Pizza mandatory")
	@JoinColumn(name = "PIZZA_ID", referencedColumnName = "PIZZA_ID")
	@ManyToOne
	private Pizza pizza;
	

	private int[] toppingIds;
	
	@NotNull(message="Toopings mandatory")
	@OneToMany(mappedBy = "pizzaLineItem", fetch = FetchType.LAZY, cascade = { CascadeType.ALL }, orphanRemoval = true )
	@JsonManagedReference
	private Collection<PizzaTopping> pizzaToppingCollection =  new ArrayList<>();

	public PizzaLineItem() {
	}

	public void setPizzaLineItem(Integer pizzaLineItem) {
		this.pizzaLineItem = pizzaLineItem;
	}

	public Integer getPizzaLineItem() {
		return pizzaLineItem;
	}

	public void setPizzaOrderId(Integer pizzaLineItem) {
		this.pizzaLineItem = pizzaLineItem;
	}

    public PizzaSize getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(PizzaSize pizzaSize) {
        this.pizzaSize = pizzaSize;
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

	public Crust getCrust() {
		return crust;
	}

	public void setCrust(Crust crust) {
		this.crust = crust;
	}

	public PizzaOrder getPizzaOrder() {
		return pizzaOrder;
	}

	public void setPizzaOrder(PizzaOrder pizzaOrder) {
		this.pizzaOrder = pizzaOrder;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	
	public void addPrice(BigDecimal price){
		this.setPrice(this.getPrice().add(price));
	}
	
	public int[] getToppingIds() {
		return toppingIds;
	}

	public void setToppingIds(int[] toppingIds) {
		this.toppingIds = toppingIds;
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
		hash += (pizzaLineItem != null ? pizzaLineItem.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof PizzaLineItem)) {
			return false;
		}
		PizzaLineItem other = (PizzaLineItem) object;
		if ((this.pizzaLineItem == null && other.pizzaLineItem != null)
				|| (this.pizzaLineItem != null && !this.pizzaLineItem.equals(other.pizzaLineItem))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "PizzaLineItem [pizzaLineItem=" + pizzaLineItem + ", pizzaSize=" + pizzaSize + ", price=" + price
				+ ", notes=" + notes + ", crust=" + crust + ", pizzaOrder=" + pizzaOrder.getOrderId() + ", pizza=" + pizza
				+ ", toppingIds=" + Arrays.toString(toppingIds) + ", pizzaToppingCollection=" + pizzaToppingCollection
				+ "]";
	}



}

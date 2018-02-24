package com.bala.pizza.domain.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 *
 * @author engan.bala
 */
@Entity(name="PizzaTopping")
@Table(name="PIZZA_TOPPING")
@XmlRootElement
public class PizzaTopping implements Serializable {

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    
    @JoinColumn(name = "LINE_ITEM_ID", referencedColumnName = "LINE_ITEM_ID")
    @ManyToOne
    @JsonBackReference
    private PizzaLineItem pizzaLineItem;
    
    @JoinColumn(name = "TOPPING_ID", referencedColumnName = "TOOPING_ID")
    @ManyToOne
    private Tooping toppingId;

    public PizzaTopping() {
    }

    public PizzaTopping(Integer id) {
        this.id = id;
    }
    
    public PizzaTopping(PizzaLineItem pizzaLineItem, Tooping toppingId) {
        this.pizzaLineItem = pizzaLineItem;
        this.toppingId = toppingId;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PizzaLineItem getPizzaLineItem() {
        return pizzaLineItem;
    }

    public void setPizzaLineItem(PizzaLineItem pizzaOrderId) {
        this.pizzaLineItem = pizzaOrderId;
    }

    public Tooping getToppingId() {
        return toppingId;
    }

    public void setToppingId(Tooping toppingId) {
        this.toppingId = toppingId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof PizzaTopping)) {
            return false;
        }
        PizzaTopping other = (PizzaTopping) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pizzashop.PizzaTopping[ id=" + id + " ]";
    }
    
}

package com.bala.pizza.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author engan.bala
 */
@Entity(name = "PIZZA")
@XmlRootElement
public class Pizza implements Serializable {

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PIZZA_ID")
    private Integer pizzaId;
    
    @Column(name = "PIZZA_NAME")
    private String pizzaName;
    
    @Column(name = "PIZZA_PRICE")
    private BigDecimal pizzaPrice;
    
    @Column(name = "PIZZA_DESCRIPTION")
    private String pizzaDescription;
    
    public Pizza() {
    }

    public Pizza(Integer pizzaId) {
        this.pizzaId = pizzaId;
    }

    public Integer getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(Integer pizzaId) {
        this.pizzaId = pizzaId;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public BigDecimal getPizzaPrice() {
        return pizzaPrice;
    }

    public void setPizzaPrice(BigDecimal pizzaPrice) {
        this.pizzaPrice = pizzaPrice;
    }

    public String getPizzaDescription() {
        return pizzaDescription;
    }

    public void setPizzaDescription(String pizzaDescription) {
        this.pizzaDescription = pizzaDescription;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pizzaId != null ? pizzaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Pizza)) {
            return false;
        }
        Pizza other = (Pizza) object;
        if ((this.pizzaId == null && other.pizzaId != null) || (this.pizzaId != null && !this.pizzaId.equals(other.pizzaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pizzashop.Pizza[ pizzaId=" + pizzaId + " ]";
    }
    
}

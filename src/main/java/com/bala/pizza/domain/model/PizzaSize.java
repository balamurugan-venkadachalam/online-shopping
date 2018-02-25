package com.bala.pizza.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author engan.bala
 */
@Entity(name = "PizzaSize")
@Table(name = "PIZZA_SIZE")
@XmlRootElement
public class PizzaSize implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PIZZA_SIZE_ID")
	@NotNull(message="Pizza size id mandatory")
    private Integer pizzaSizeId;
    
    @Column(name = "PIZZA_SIZE_NAME")
    private String pizzaSizeName;
    
    @Column(name = "PIZZA_SIZE_PRICE")
    private BigDecimal pizzaSizePrice;

    public PizzaSize() {
    }

    public PizzaSize(Integer pizzaSizeId) {
        this.pizzaSizeId = pizzaSizeId;
    }

    public Integer getPizzaSizeId() {
        return pizzaSizeId;
    }

    public void setPizzaSizeId(Integer pizzaSizeId) {
        this.pizzaSizeId = pizzaSizeId;
    }

    public String getPizzaSizeName() {
        return pizzaSizeName;
    }

    public void setPizzaSizeName(String pizzaSizeName) {
        this.pizzaSizeName = pizzaSizeName;
    }

    public BigDecimal getPizzaSizePrice() {
        return pizzaSizePrice;
    }

    public void setPizzaSizePrice(BigDecimal pizzaSizePrice) {
        this.pizzaSizePrice = pizzaSizePrice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pizzaSizeId != null ? pizzaSizeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PizzaSize)) {
            return false;
        }
        PizzaSize other = (PizzaSize) object;
        if ((this.pizzaSizeId == null && other.pizzaSizeId != null) || (this.pizzaSizeId != null && !this.pizzaSizeId.equals(other.pizzaSizeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pizzashop.PizzaSize[ pizzaSizeId=" + pizzaSizeId + " ]";
    }
    
}

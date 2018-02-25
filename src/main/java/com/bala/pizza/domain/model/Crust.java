package com.bala.pizza.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Cacheable;
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
@Entity(name = "Crust")
@Table(name="CRUST")
@XmlRootElement
@Cacheable
public class Crust implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "CUST_ID")
	@NotNull(message="Pizza crust id mandatory")
	private Integer custId;

	@Column(name = "CUST_NAME")
	private String custName;

	@Column(name = "CUST_PRICE")
	private BigDecimal custPrice;

	@Column(name = "CUST_DESCIRIPTION")
	private String custDesciription;

	

	public Crust() {
	}

	public Crust(Integer custId) {
		this.custId = custId;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public BigDecimal getCustPrice() {
		return custPrice;
	}

	public void setCustPrice(BigDecimal custPrice) {
		this.custPrice = custPrice;
	}

	public String getCustDesciription() {
		return custDesciription;
	}

	public void setCustDesciription(String custDesciription) {
		this.custDesciription = custDesciription;
	}

	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (custId != null ? custId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {		
		if (!(object instanceof Crust)) {
			return false;
		}
		Crust other = (Crust) object;
		if ((this.custId == null && other.custId != null)
				|| (this.custId != null && !this.custId.equals(other.custId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "pizzashop.Crust[ custId=" + custId + " ]";
	}

}

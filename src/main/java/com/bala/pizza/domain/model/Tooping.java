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
@XmlRootElement
@Entity(name = "Tooping")
@Table(name = "TOOPING")
public class Tooping implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "TOOPING_ID")
	@NotNull(message="Tooping id mandatory")
	private Integer toopingId;

	@Column(name = "TOOPING_NAME")
	private String toopingName;

	@Column(name = "TOOPING_PRICE")
	private BigDecimal toopingPrice;

	@Column(name = "TOOPING_DESCRIPTION")
	private String toopingDescription;


	public Tooping() {
	}
		

	public Tooping(Integer toopingId) {
		this.toopingId = toopingId;	
	}

	public Integer getToopingId() {
		return toopingId;
	}

	public void setToopingId(Integer toopingId) {
		this.toopingId = toopingId;
	}

	public String getToopingName() {
		return toopingName;
	}

	public void setToopingName(String toopingName) {
		this.toopingName = toopingName;
	}

	public BigDecimal getToopingPrice() {
		return toopingPrice;
	}

	public void setToopingPrice(BigDecimal toopingPrice) {
		this.toopingPrice = toopingPrice;
	}

	public String getToopingDescription() {
		return toopingDescription;
	}

	public void setToopingDescription(String toopingDescription) {
		this.toopingDescription = toopingDescription;
	}



	@Override
	public int hashCode() {
		int hash = 0;
		hash += (toopingId != null ? toopingId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Tooping)) {
			return false;
		}
		Tooping other = (Tooping) object;
		if ((this.toopingId == null && other.toopingId != null)
				|| (this.toopingId != null && !this.toopingId.equals(other.toopingId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "pizzashop.Tooping[ toopingId=" + toopingId + " ]";
	}

}

package com.mobwink.percentoff.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String title;
	
	private String description;

	@NotNull
	private BigDecimal oldPrice;

	@NotNull
	private BigDecimal bestPrice;

	@NotNull
	private String url;
	
	private String img;
	
	@Transient
	private String identifier;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(BigDecimal oldPrice) {
		this.oldPrice = oldPrice;
	}

	public BigDecimal getBestPrice() {
		return bestPrice;
	}

	public void setBestPrice(BigDecimal bestPrice) {
		this.bestPrice = bestPrice;
	}

	public String getUrl() {
		if (!"".equals(this.identifier)){
			return url + "?utm_source=PolishopComVC&utm_campaign=257308&utm_medium=" + this.identifier;
		}
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public BigDecimal getDiscount(){
		double divValue = bestPrice.doubleValue() / oldPrice.doubleValue();
		BigDecimal discount = new BigDecimal(divValue);
		discount = discount.multiply(new BigDecimal(100)).subtract(new BigDecimal(100)).multiply(new BigDecimal(-1));
		return discount.setScale(2, RoundingMode.HALF_DOWN);
	}
	
}

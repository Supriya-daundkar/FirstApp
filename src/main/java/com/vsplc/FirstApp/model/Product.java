package com.vsplc.FirstApp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

public class Product  extends AbstractTimestampEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer productId;
	
	@NotEmpty
    @Column(name="PRODUCT_NAME", nullable=false)
	private String productName;
	
	@NotEmpty
    @Column(name="PRIZE", nullable=false)
	private Float prize;
	
	@NotEmpty
    @Column(name="IMAGE_PATH", nullable=false)
	private String imagePath;
	
	@NotEmpty
    @Column(name="QUANTITY", nullable=false)
	private int quantity;
	
	@NotEmpty
    @Column(name="ACTIVE", nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private Active active;
	
    @Column(name="CREATED_BY", nullable=false)
	private int createdBy;
			
    @Column(name="MODIFIED_BY", nullable=false)
	private int modifiedBy;
	
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Float getPrize() {
		return prize;
	}
	public void setPrize(Float prize) {
		this.prize = prize;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
		
	public Active getActive() {
		return active;
	}
	public void setActive(Active active) {
		this.active = active;
	}
	
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	
	public int getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", prize=" + prize + ", imagePath="
				+ imagePath + ", quantity=" + quantity + ", active=" + active
				+ ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		return true;
	}
	
	
}

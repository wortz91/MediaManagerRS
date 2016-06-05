package org.nick.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the PurchaseInfoMediaItem database table.
 * 
 */
@Entity
@NamedQuery(name="PurchaseInfoMediaItem.findAll", query="SELECT p FROM PurchaseInfoMediaItem p")
public class PurchaseInfoMediaItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date purchaseDate;

	private BigDecimal purchasePrice;

	//bi-directional many-to-one association to MediaItem
	@ManyToOne
	@JoinColumn(name="MediaItemID")
	private MediaItem mediaItem;

	//bi-directional many-to-one association to PurchaseInfo
	@ManyToOne
	@JoinColumn(name="PurchaseInfoID")
	private PurchaseInfo purchaseInfo;

	public PurchaseInfoMediaItem() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPurchaseDate() {
		return this.purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public BigDecimal getPurchasePrice() {
		return this.purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public MediaItem getMediaItem() {
		return this.mediaItem;
	}

	public void setMediaItem(MediaItem mediaItem) {
		this.mediaItem = mediaItem;
	}

	public PurchaseInfo getPurchaseInfo() {
		return this.purchaseInfo;
	}

	public void setPurchaseInfo(PurchaseInfo purchaseInfo) {
		this.purchaseInfo = purchaseInfo;
	}

}
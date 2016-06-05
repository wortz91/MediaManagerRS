package org.nick.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PurchaseInfo database table.
 * 
 */
@Entity
@NamedQuery(name="PurchaseInfo.findAll", query="SELECT p FROM PurchaseInfo p")
public class PurchaseInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String purchaseLocation;

	//bi-directional many-to-one association to PurchaseInfoMediaItem
	@OneToMany(mappedBy="purchaseInfo")
	private List<PurchaseInfoMediaItem> purchaseInfoMediaItems;

	public PurchaseInfo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPurchaseLocation() {
		return this.purchaseLocation;
	}

	public void setPurchaseLocation(String purchaseLocation) {
		this.purchaseLocation = purchaseLocation;
	}

	public List<PurchaseInfoMediaItem> getPurchaseInfoMediaItems() {
		return this.purchaseInfoMediaItems;
	}

	public void setPurchaseInfoMediaItems(List<PurchaseInfoMediaItem> purchaseInfoMediaItems) {
		this.purchaseInfoMediaItems = purchaseInfoMediaItems;
	}

	public PurchaseInfoMediaItem addPurchaseInfoMediaItem(PurchaseInfoMediaItem purchaseInfoMediaItem) {
		getPurchaseInfoMediaItems().add(purchaseInfoMediaItem);
		purchaseInfoMediaItem.setPurchaseInfo(this);

		return purchaseInfoMediaItem;
	}

	public PurchaseInfoMediaItem removePurchaseInfoMediaItem(PurchaseInfoMediaItem purchaseInfoMediaItem) {
		getPurchaseInfoMediaItems().remove(purchaseInfoMediaItem);
		purchaseInfoMediaItem.setPurchaseInfo(null);

		return purchaseInfoMediaItem;
	}

}
package org.nick.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the MediaItem database table.
 * 
 */
@Entity
@NamedQuery(name="MediaItem.findAll", query="SELECT m FROM MediaItem m")
public class MediaItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String comments;

	private double currentValue;

	private String name;

	private int year;

	//bi-directional many-to-one association to Genre
	@ManyToOne
	@JoinColumn(name="GenreID")
	private Genre genre;

	//bi-directional many-to-one association to MediaType
	@ManyToOne
	@JoinColumn(name="MediaTypeID")
	private MediaType mediaType;

	//bi-directional many-to-one association to PurchaseInfoMediaItem
	@OneToMany(mappedBy="mediaItem")
	private List<PurchaseInfoMediaItem> purchaseInfoMediaItems;

	public MediaItem() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public double getCurrentValue() {
		return this.currentValue;
	}

	public void setCurrentValue(double currentValue) {
		this.currentValue = currentValue;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Genre getGenre() {
		return this.genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public MediaType getMediaType() {
		return this.mediaType;
	}

	public void setMediaType(MediaType mediaType) {
		this.mediaType = mediaType;
	}

	public List<PurchaseInfoMediaItem> getPurchaseInfoMediaItems() {
		return this.purchaseInfoMediaItems;
	}

	public void setPurchaseInfoMediaItems(List<PurchaseInfoMediaItem> purchaseInfoMediaItems) {
		this.purchaseInfoMediaItems = purchaseInfoMediaItems;
	}

	public PurchaseInfoMediaItem addPurchaseInfoMediaItem(PurchaseInfoMediaItem purchaseInfoMediaItem) {
		getPurchaseInfoMediaItems().add(purchaseInfoMediaItem);
		purchaseInfoMediaItem.setMediaItem(this);

		return purchaseInfoMediaItem;
	}

	public PurchaseInfoMediaItem removePurchaseInfoMediaItem(PurchaseInfoMediaItem purchaseInfoMediaItem) {
		getPurchaseInfoMediaItems().remove(purchaseInfoMediaItem);
		purchaseInfoMediaItem.setMediaItem(null);

		return purchaseInfoMediaItem;
	}

}
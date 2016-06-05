package org.nick.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the MediaType database table.
 * 
 */
@Entity
@NamedQuery(name="MediaType.findAll", query="SELECT m FROM MediaType m")
public class MediaType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String mediaTypeDescription;

//	//bi-directional many-to-one association to MediaItem
//	@OneToMany(mappedBy="mediaType")
//	private List<MediaItem> mediaItems;

	public MediaType() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMediaTypeDescription() {
		return this.mediaTypeDescription;
	}

	public void setMediaTypeDescription(String mediaTypeDescription) {
		this.mediaTypeDescription = mediaTypeDescription;
	}

//	public List<MediaItem> getMediaItems() {
//		return this.mediaItems;
//	}
//
//	public void setMediaItems(List<MediaItem> mediaItems) {
//		this.mediaItems = mediaItems;
//	}
//
//	public MediaItem addMediaItem(MediaItem mediaItem) {
//		getMediaItems().add(mediaItem);
//		mediaItem.setMediaType(this);
//
//		return mediaItem;
//	}

//	public MediaItem removeMediaItem(MediaItem mediaItem) {
//		getMediaItems().remove(mediaItem);
//		mediaItem.setMediaType(null);
//
//		return mediaItem;
//	}

}
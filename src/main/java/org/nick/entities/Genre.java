package org.nick.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;


/**
 * The persistent class for the Genre database table.
 * 
 */
@Entity
@XmlRootElement(name="genre")
@NamedQuery(name="Genre.findAll", query="SELECT g FROM Genre g")
public class Genre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String genreDescription;

//	//bi-directional many-to-one association to MediaItem
//	@OneToMany(mappedBy="genre")
//	private List<MediaItem> mediaItems;

	public Genre() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGenreDescription() {
		return this.genreDescription;
	}

	public void setGenreDescription(String genreDescription) {
		this.genreDescription = genreDescription;
	}

//	public List<MediaItem> getMediaItems() {
//		return this.mediaItems;
//	}
//
//	public void setMediaItems(List<MediaItem> mediaItems) {
//		this.mediaItems = mediaItems;
//	}

//	public MediaItem addMediaItem(MediaItem mediaItem) {
//		getMediaItems().add(mediaItem);
//		mediaItem.setGenre(this);
//
//		return mediaItem;
//	}
//
//	public MediaItem removeMediaItem(MediaItem mediaItem) {
//		getMediaItems().remove(mediaItem);
//		mediaItem.setGenre(null);
//
//		return mediaItem;
//	}

}
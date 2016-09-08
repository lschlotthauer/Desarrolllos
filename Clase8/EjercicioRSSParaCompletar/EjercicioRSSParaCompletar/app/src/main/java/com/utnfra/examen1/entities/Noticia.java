package com.utnfra.examen1.entities;

import android.graphics.Bitmap;

public class Noticia {

	// tags obligatorios RSS para <item>
	private String title;
	private String description;
	private String link;
	
	// tags opcionales RSS (Algunos) para <item>
	private String category;
	private String author;
	private String pubDate;

    private String imageUrl;
    private Bitmap bitmap;
	
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
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	public String getPubDate() {
		return pubDate;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAuthor() {
		return author;
	}

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}

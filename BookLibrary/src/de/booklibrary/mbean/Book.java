package de.booklibrary.mbean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {

	private String id;
	private String isbn;
	private String title;
	private String author;
	private String publisher; 
	private String edition;
	private double price;
	private String description;
	
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String get() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	@Override
	public boolean equals (Object object){
		if (!(object instanceof Book)) {
			return false;
		}
		Book other = (Book) object;
		return(this.id != null||other.id ==null) && (this.id == null || this.id.equals (other.id));
	}
	
	@Override
	public String toString(){
		return "de.booklibrary.entities.Book[id=" + id + "] ";
	}
	
}

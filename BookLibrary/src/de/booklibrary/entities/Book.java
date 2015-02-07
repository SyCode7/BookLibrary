package de.booklibrary.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;



@Entity
@Table(name = "BOOK")
@XmlRootElement

@NamedQueries({@NamedQuery (name= "Book.findAll" , query = "SELECT b FROM Book b")})
public class Book implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 15)
	@Column(name = "ISBN")
	private String isbn;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "TITLE")
	private String title;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 75)
	@Column(name = "AUTHOR")
	private String author;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 75)
	@Column(name = "PUBLISHER")
	private String publisher; 
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 15)
	@Column(name = "EDITION")
	private String edition;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "PRICE")
	private double price;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "DESCRIPTION")
	private String description;
	
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID")
	private Integer id;
	
	public Book (){
		
	}
	
	public Book (Integer id){
		this.id = id ;
	}

	/**
	 * @param isbn
	 * @param title
	 * @param author
	 * @param publisher
	 * @param edition
	 * @param price
	 * @param description
	 * @param id
	 */
	public Book(Integer id, String isbn, String title, String author, String publisher,
			String edition, double  price, String description) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.edition = edition;
		this.price = price;
		this.description = description;
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

	public String getAuthor() {
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

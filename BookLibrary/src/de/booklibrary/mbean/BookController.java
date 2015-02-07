package de.booklibrary.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import de.booklibrary.jaxrs.client.BookRestClient;


@Named(value = "bk")
@RequestScoped
class BookController {
	@Inject
	private BookRestClient rc;
	private Book book = new Book();
	List<Book> books = new ArrayList<>();
	FacesContext facesContext = FacesContext.getCurrentInstance();
	
	
	public BookController(){
		
	}
	
	public Book getBook(){
		return book;
	}
	
	public void  setBook(Book book){
		this.book = book;
	}
	
	public String addNewBook(){
		String status ="";
		try {
			if (validate()) {
				status = rc.addNewBook(book);
				facesContext.addMessage(status, new FacesMessage(
							 FacesMessage.SEVERITY_INFO,
							 "New Book added successfully",
							 book.toString()));
				
			}
		} catch (Exception ex) {
			facesContext.addMessage(status, new FacesMessage(
					 FacesMessage.SEVERITY_ERROR,
					 "New Book cannot be added",
					 ex.getMessage()));
		}
		return "register.xhtml";
		
	}
	
	public void  getBookById(){
		book = rc.getBook(book.getId());
	}

	private boolean validate() {
			if (book.getIsbn() == null || book.getIsbn().trim().isEmpty()) {
				facesContext.addMessage("form:isbn",
				new FacesMessage(FacesMessage.SEVERITY_WARN,
						"Invalid ISBN", "Please enter a valid ISBN number"));
			}
			
			if (book.getTitle() == null || book.getTitle().trim().isEmpty() ) {
				facesContext.addMessage("form:title",
				new FacesMessage(FacesMessage.SEVERITY_WARN,
				"Invalid Title", "Please enter a valid title"));
							
			}
			
		return facesContext.getMessageList().isEmpty();
	}
	
}

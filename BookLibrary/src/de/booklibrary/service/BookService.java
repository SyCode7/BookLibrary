package de.booklibrary.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.ValidationException;

import de.booklibrary.entities.Book;

@Stateless
public class BookService {

	@PersistenceContext(unitName= "BookLibraryPU")
	EntityManager entityManager;
	
	public Book createBook (Book book){
		if (book == null) {
		throw new ValidationException("book object is null");	
		}
		entityManager.persist(book);
		return book;
	}
	
	public void deleteBook (String id){
		if (id == null) {
			throw new ValidationException("invalid book id");	

		}
		entityManager.remove(findBook(id));
	}
	
	public  Book getBook (String id){
		if (id == null) {
			throw new ValidationException("invalid book id");	

		}
		return findBook(id);
	}
	
	private Book findBook(String id){
		if (id == null) {
			throw new ValidationException("invalid book id");	

		}
		return entityManager.find(Book.class,Integer.parseInt(id));
		
	}
	
	public List<Book> findAllBooks(){
		TypedQuery<Book> typedQuery = entityManager.createNamedQuery("Book.findAll", Book.class);
		return typedQuery.getResultList();
	}

	
	
	
}

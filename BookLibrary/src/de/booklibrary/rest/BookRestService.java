package de.booklibrary.rest;

import java.net.URI;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import de.booklibrary.entities.Book;
import de.booklibrary.jaxb.Books;
import de.booklibrary.service.BookService;


@Path("/book")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@ApplicationScoped
public class BookRestService {
	
	@Inject
	BookService bookService;
	
	@Context
	private UriInfo uriInfo;
	
	@POST
	public Response createBook(Book book){
		Book newBook = bookService.createBook(book);
		URI uri = uriInfo.getAbsolutePathBuilder().path(newBook.getId().toString()).build();
		return Response.created(uri).build();
		
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteBook (@PathParam("id") String id){
		bookService.deleteBook(id);
		return Response.noContent().build();
	}
	
	@GET
	@Path("{id}")
	public Response getBook (@PathParam("id") String id){
		Book book = bookService.getBook(id);
		if (book == null) {
			throw new NotFoundException();
		}
		
		return Response.ok(book).build();
	}
	@GET
	public Books getBooks(){
		return new Books(bookService.findAllBooks());
	}

}

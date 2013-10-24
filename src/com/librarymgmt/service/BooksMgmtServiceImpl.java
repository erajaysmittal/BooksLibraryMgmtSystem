package com.librarymgmt.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.librarymgmt.action.AuthorAction;
import com.librarymgmt.action.BookAction;
import com.librarymgmt.action.CategoryAction;
import com.librarymgmt.doa.LibraryDbMgmt;
import com.librarymgmt.doa.LibraryDbMgmtImpl;
import com.librarymgmt.model.Author;
import com.librarymgmt.model.Book;
import com.librarymgmt.model.Category;


@Path("/booksMgmtService")
public class BooksMgmtServiceImpl implements BooksMgmtService {

	private BookAction bookAction;
	private AuthorAction authorAction;
	private CategoryAction categoryAction;

	public BooksMgmtServiceImpl() throws Exception{
		LibraryDbMgmt libraryDbMgmt = new LibraryDbMgmtImpl();
		this.bookAction = new BookAction(libraryDbMgmt);
		this.authorAction = new AuthorAction(libraryDbMgmt);
		this.categoryAction = new CategoryAction(libraryDbMgmt);
	}

	@GET
	@Path("/books")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<Book> getBooks() {
		//http://localhost:8080/BooksLibrary/BooksLibrary/booksMgmtService/books
		return new ArrayList<>(bookAction.getBooks());
	}

	@POST
	@Path("/books")
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public void createBook(Book book) {
		bookAction.createBook(book);
	}

	@GET
	@Path("/books/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Book getBookByID(@PathParam("id") String id) {
		return bookAction.getBookByID(Integer.parseInt(id));
	}

	@POST
	@Path("/books/{id}")
	@Override
	public void editBook(Book book) {
		bookAction.editBook(book);
	}

	@DELETE
	@Path("/books/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public void deleteBookByID(@PathParam("id") String id) {
		bookAction.deleteBookById(Integer.parseInt(id));
	}

	@GET
	@Path("/authors")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<Author> getAuthor() {
		return authorAction.getAuthors();
	}

	@POST
	@Path("/author")
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public void createAuthor(Author author) {
		authorAction.createAuthor(author);
	}

	@GET
	@Path("/authors/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Author getAuthorByID(@PathParam("id") String id) {
		return authorAction.getAuthorByID(Integer.parseInt(id));
	}

	@POST
	@Path("/authors/{id}")
	@Override
	public void editAuthor(Author author) {
		authorAction.editAuthor(author);
	}

	@DELETE
	@Path("/authors/id")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public void deleteAuthorByID(@PathParam("id") String id) {
		authorAction.deleteAuthorByID(Integer.parseInt(id));
	}

	@GET
	@Path("/category")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<Category> getCategory() {
		return categoryAction.getCategories();
	}

	@POST
	@Path("/category")
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public void createCategory(Category category) {
		categoryAction.createCategory(category);
	}

	@GET
	@Path("/category/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Category getCategoryByID(@PathParam("id") String id) {
		return categoryAction.getCategoryByID(Integer.parseInt(id));
	}

	@POST
	@Path("/category/{id}")
	@Override
	public void editCategory(Category category) {
		categoryAction.editCategory(category);
	}

	@DELETE
	@Path("/category/id")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public void deleteCategoryByID(@PathParam("id") String id) {
		categoryAction.deleteCategoryByID(Integer.parseInt(id));
	}
}
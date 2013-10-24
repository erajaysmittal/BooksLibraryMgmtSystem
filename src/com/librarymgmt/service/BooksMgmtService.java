package com.librarymgmt.service;

import java.util.List;

import com.librarymgmt.model.Author;
import com.librarymgmt.model.Book;
import com.librarymgmt.model.Category;


public interface BooksMgmtService {

	public List<Book> getBooks();
	public void createBook(Book book);
	public Book getBookByID(String id);
	public void editBook(Book book);
	public void deleteBookByID(String id);

	public List<Author> getAuthor();
	public void createAuthor(Author author);
	public Author getAuthorByID(String id);
	public void editAuthor(Author author);
	public void deleteAuthorByID(String id);

	public List<Category> getCategory();
	public void createCategory(Category category);
	public Category getCategoryByID(String id);
	public void editCategory(Category category);
	public void deleteCategoryByID(String id);
}
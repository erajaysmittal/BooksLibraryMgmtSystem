package com.librarymgmt.doa;

import java.util.List;

import com.librarymgmt.model.Author;
import com.librarymgmt.model.Book;
import com.librarymgmt.model.Category;


public interface LibraryDbMgmt {

	public Book getBookById(int id);
	public List<Book> getBooksByCategoryId(int categoryId);
	public List<Book> getAllBooks();
	public void createBook(Book book);
	public void updateBook(Book book);
	public void deleteBookById(int id);

	public Author getAuthorById(int id);
	public List<Author> getBooksByAuthorId(int authorId);
	public List<Author> getAllAuthors();
	public void createAuthor(Author author);
	public void updateAuthor(Author author);
	public void deleteAuthorById(int id);

	public Category getCategorybyId(int id);
	public List<Category> getAllCategories();
	public void createCategory(Category category);
	public void updateCategory(Category category);
	public void deleteCategoryById(int id);


}

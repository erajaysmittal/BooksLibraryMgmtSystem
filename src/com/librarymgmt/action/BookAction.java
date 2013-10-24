package com.librarymgmt.action;

import java.util.List;

import com.librarymgmt.doa.LibraryDbMgmt;
import com.librarymgmt.model.Book;


public class BookAction {

	private LibraryDbMgmt libraryDbMgmt;

	public BookAction() {
	}

	public BookAction(LibraryDbMgmt libraryDbMgmt) {
		this.libraryDbMgmt = libraryDbMgmt;
	}

	public void createBook(Book book){
		libraryDbMgmt.createBook(book);
	}

	public Book getBookByID(int id){
		return libraryDbMgmt.getBookById(id);
	}

	public void editBook(Book book){
		libraryDbMgmt.updateBook(book);
	}

	public void deleteBookById(int id){
		libraryDbMgmt.deleteBookById(id);
	}

	public List<Book> getBooks() {
		return libraryDbMgmt.getAllBooks();
	}

	public LibraryDbMgmt getLibraryDbMgmt() {
		return libraryDbMgmt;
	}

	public void setLibraryDbMgmt(LibraryDbMgmt libraryDbMgmt) {
		this.libraryDbMgmt = libraryDbMgmt;
	}
}

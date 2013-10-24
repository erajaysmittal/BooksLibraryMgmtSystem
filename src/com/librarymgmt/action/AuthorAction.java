package com.librarymgmt.action;

import java.util.List;

import com.librarymgmt.doa.LibraryDbMgmt;
import com.librarymgmt.model.Author;

public class AuthorAction {

	private LibraryDbMgmt libraryDbMgmt;

	public AuthorAction() {
	}

	public AuthorAction(LibraryDbMgmt libraryDbMgmt) {
		this.libraryDbMgmt = libraryDbMgmt;
	}

	public void createAuthor(Author author){
		libraryDbMgmt.createAuthor(author);
	}

	public Author getAuthorByID(int id){
		return libraryDbMgmt.getAuthorById(id);
	}

	public List<Author> getAuthors(){
		return libraryDbMgmt.getAllAuthors();
	}

	public void editAuthor(Author author){
		libraryDbMgmt.updateAuthor(author);
	}

	public void deleteAuthorByID(int id){
		libraryDbMgmt.deleteAuthorById(id);
	}

	public LibraryDbMgmt getLibraryDbMgmt() {
		return libraryDbMgmt;
	}

	public void setLibraryDbMgmt(LibraryDbMgmt libraryDbMgmt) {
		this.libraryDbMgmt = libraryDbMgmt;
	}
}
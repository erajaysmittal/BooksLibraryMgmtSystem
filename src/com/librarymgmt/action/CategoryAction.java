package com.librarymgmt.action;

import java.util.List;

import com.librarymgmt.doa.LibraryDbMgmt;
import com.librarymgmt.model.Category;


public class CategoryAction {

	private LibraryDbMgmt libraryDbMgmt;

	public CategoryAction() {
	}

	public CategoryAction(LibraryDbMgmt libraryDbMgmt) {
		this.libraryDbMgmt = libraryDbMgmt;
	}

	public void createCategory(Category category){
		libraryDbMgmt.createCategory(category);
	}

	public Category getCategoryByID(int id){
		return libraryDbMgmt.getCategorybyId(id);
	}

	public List<Category> getCategories(){
		return libraryDbMgmt.getAllCategories();
	}

	public void editCategory(Category category){
		libraryDbMgmt.updateCategory(category);
	}

	public void deleteCategoryByID(int id){
		libraryDbMgmt.deleteCategoryById(id);
	}

	public LibraryDbMgmt getLibraryDbMgmt() {
		return libraryDbMgmt;
	}

	public void setLibraryDbMgmt(LibraryDbMgmt libraryDbMgmt) {
		this.libraryDbMgmt = libraryDbMgmt;
	}
}

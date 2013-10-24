package com.librarymgmt.model;

import java.io.Serializable;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
//{"book":[{"authorMap":{"entry":{"key":"1","value":{"id":"1","lastName":"MITTAL","name":"AJAY"}}},"category":{"id":"1","name":"novels"},"id":"1","title":"GANGA Tales"}]}
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown=true)
public class Book implements Serializable {

	private int id;
	private String title;
	private Category category;
	private Map<Integer, Author> authorMap;

	public Book() {
	}

	//@JsonCreator
	public Book(int id, String title, Category category, Map<Integer, Author> authorMap) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.authorMap = authorMap;
	}


	@JsonProperty("id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty("category")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@JsonProperty("authorMap")
	public Map<Integer, Author> getAuthorMap() {
		return authorMap;
	}

	public void setAuthorMap(Map<Integer, Author> authorMap) {
		this.authorMap = authorMap;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Book other = (Book) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", category=" + category
				+ ", authorMap=" + authorMap + "]";
	}
}

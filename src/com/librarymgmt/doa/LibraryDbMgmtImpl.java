package com.librarymgmt.doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.librarymgmt.model.Author;
import com.librarymgmt.model.Book;
import com.librarymgmt.model.Category;


public class LibraryDbMgmtImpl implements LibraryDbMgmt {

	private String driver;
	private String username;
	private String password;
	private String dburl;

	private Connection connection=null;

	private PreparedStatement psBooks = null;
	private PreparedStatement psBook = null;
	private PreparedStatement psDelBook = null;

	private PreparedStatement psAuthors = null;
	private PreparedStatement psAuthor = null;
	private PreparedStatement psDelAuthor = null;

	private PreparedStatement psCategories = null;
	private PreparedStatement psCategory = null;
	private PreparedStatement psDelCategory = null;



	public LibraryDbMgmtImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException,SQLException{
		this.driver = "com.mysql.jdbc.Driver";
		this.username = "root";
		this.password = "my123sql";
		this.dburl = "jdbc:mysql://localhost:3306/librarysystem";
		Class.forName(this.driver).newInstance();
	}

	public LibraryDbMgmtImpl(String driver,String username, String password,String dburl) throws InstantiationException, IllegalAccessException, ClassNotFoundException,SQLException{
		this.driver = driver;
		this.username = username;
		this.password = password;
		this.dburl=dburl;
		Class.forName(driver).newInstance();
	}

	private synchronized Connection getConnection() throws SQLException {
		if (connection == null || connection.isClosed()){
			connection = DriverManager.getConnection(dburl,username,password);
		}
		return connection;
	}

	private synchronized PreparedStatement getPreparedStatementForBooks() throws SQLException{
		if (psBooks == null || psBooks.isClosed()){
			String query = "select * from book;";
			psBooks = getConnection().prepareStatement(query);
		}
		return psBooks;
	}

	private synchronized PreparedStatement getPreparedStatementForBook() throws SQLException{
		if (psBook == null || psBook.isClosed()){
			String query = "select * from book where id=?;";
			psBook = getConnection().prepareStatement(query);
		}
		return psBook;
	}

	private synchronized PreparedStatement getPreparedStatementToDeleteBook() throws SQLException{
		if (psDelBook == null || psDelBook.isClosed()){
			String query = "Delete from book where id=?;";
			psDelBook = getConnection().prepareStatement(query);
		}
		return psDelBook;
	}


	private synchronized PreparedStatement getPreparedStatementForAuthors() throws SQLException{
		if (psAuthors == null || psAuthors.isClosed()){
			String query = "select * from author;";
			psAuthors = getConnection().prepareStatement(query);
		}
		return psAuthors;
	}

	private synchronized PreparedStatement getPreparedStatementForAuthor() throws SQLException{
		if (psAuthor == null || psAuthor.isClosed()){
			String query = "select * from author where id=?;";
			psAuthor = getConnection().prepareStatement(query);
		}
		return psAuthor;
	}

	private synchronized PreparedStatement getPreparedStatementToDeleteAuthor() throws SQLException{
		if (psDelAuthor == null || psDelAuthor.isClosed()){
			String query = "Delete from author where id=?;";
			psDelAuthor = getConnection().prepareStatement(query);
		}
		return psDelAuthor;
	}

	private synchronized PreparedStatement getPreparedStatementForCategories() throws SQLException{
		if (psCategories == null || psCategories.isClosed()){
			String query = "select * from category;";
			psCategories = getConnection().prepareStatement(query);
		}
		return psCategories;
	}

	private synchronized PreparedStatement getPreparedStatementForCategory() throws SQLException{
		if (psCategory == null || psCategory.isClosed()){
			String query = "select * from category where id=?;";
			psCategory = getConnection().prepareStatement(query);
		}
		return psCategory;
	}

	private synchronized PreparedStatement getPreparedStatementToDeleteCategory() throws SQLException{
		if (psDelCategory == null || psDelCategory.isClosed()){
			String query = "Delete from category where id=?;";
			psCategory = getConnection().prepareStatement(query);
		}
		return psDelCategory;
	}

	@Override
	public Book getBookById(int id) {
		ResultSet resultSet = null;
		ResultSet rscat = null;
		ResultSet rsauth = null;
		try {
			psBook = getPreparedStatementForBook();
			psBook.setInt(1, id);
			resultSet = psBook.executeQuery();
			if (resultSet.next()){
				Book book = new Book();
				Author author = new Author();
				Map<Integer, Author> authormap = new HashMap<>();
				book.setId(resultSet.getInt(1));
				book.setTitle(resultSet.getString(2));
				psCategory = getPreparedStatementForCategory();
				psCategory.setInt(1, resultSet.getInt(3));
				rscat = psCategory.executeQuery();
				if(rscat.next()){
					book.setCategory(new Category(rscat.getInt(1), resultSet.getString(2)));
				}
				psAuthor = getPreparedStatementForAuthor();
				psAuthor.setInt(1,resultSet.getInt(4));
				rsauth = psAuthor.executeQuery();
				if(rsauth.next()){
					author.setId(rsauth.getInt(1));
					author.setName(rsauth.getString(2));
					authormap.put(rsauth.getInt(1), author);
					book.setAuthorMap(authormap);
				}
				return book;
			}

		}
		catch (Exception exception) {
			System.out.println("Exception occurred: "+exception);
		}
		finally {
			try {
				if (rsauth != null) {
					rsauth.close();
				}
				if (rscat != null) {
					rscat.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			}
			catch (Exception exception) {
				System.out.println("Exception occurred: "+exception);
			}
		}
		return null;
	}

	@Override
	public List<Book> getBooksByCategoryId(int categoryId) {
		return null;
	}

	@Override
	public List<Book> getAllBooks() {
		ResultSet resultSet = null;
		List<Book> books = new ArrayList<>();
		try {
			psBooks = getPreparedStatementForBooks();
			resultSet = psBooks.executeQuery();
			while(resultSet.next()){
				Book book = new Book();
				book.setId(resultSet.getInt("id"));
				book.setTitle(resultSet.getString("title"));
				books.add(book);
			}
		}
		catch (Exception exception) {
			System.out.println("Exception occurred: "+exception);
		}
		finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			}
			catch (Exception exception) {
				System.out.println("Exception occurred: "+exception);
			}
		}
		return books;
	}

	@Override
	public void createBook(Book book) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBookById(int id) {
		int result = 0;
		try {
			psDelBook = getPreparedStatementToDeleteBook();
			psDelBook.setInt(1, id);
			result = psDelBook.executeUpdate();
		}
		catch (Exception exception) {
			System.out.println("Exception occurred: "+exception);
		}
	}

	@Override
	public Author getAuthorById(int id) {
		Author author = null;
		ResultSet resultSet = null;
		try {
			psAuthor = getPreparedStatementForAuthor();
			psAuthor.setInt(1, id);
			resultSet = psAuthor.executeQuery();
			if (resultSet.next()){
				author = new Author(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("lastname"), resultSet.getDate("birthday"));
			}
		}
		catch (Exception exception) {
			System.out.println("Exception occurred: "+exception);
		}
		finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			}
			catch (Exception exception) {
				System.out.println("Exception occurred: "+exception);
			}
		}
		return author;
	}

	@Override
	public List<Author> getBooksByAuthorId(int authorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Author> getAllAuthors() {
		ResultSet resultSet = null;
		List<Author> authors = new ArrayList<>();
		try {
			psAuthors = getPreparedStatementForAuthors();
			resultSet = psAuthors.executeQuery();
			while(resultSet.next()){
				Author author = new Author();
				author.setId(resultSet.getInt("id"));
				author.setName(resultSet.getString("name"));
				author.setLastName(resultSet.getString("lastname"));
				author.setBirthday(resultSet.getDate("birthday"));
				authors.add(author);
			}
		}
		catch (Exception exception) {
			System.out.println("Exception occurred: "+exception);
		}
		finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			}
			catch (Exception exception) {
				System.out.println("Exception occurred: "+exception);
			}
		}
		return authors;
	}

	@Override
	public void createAuthor(Author author) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAuthor(Author author) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAuthorById(int id) {
		int result = 0;
		try {
			psDelAuthor = getPreparedStatementToDeleteAuthor();
			psDelAuthor.setInt(1, id);
			result = psDelAuthor.executeUpdate();
		}
		catch (Exception exception) {
			System.out.println("Exception occurred: "+exception);
		}

	}

	@Override
	public Category getCategorybyId(int id) {
		Category category = null;
		ResultSet resultSet = null;
		try {
			psCategory = getPreparedStatementForCategory();
			psCategory.setInt(1, id);
			resultSet = psCategory.executeQuery();
			if (resultSet.next()){
				category = new Category(resultSet.getInt("id"), resultSet.getString("name"));
			}
		}
		catch (Exception exception) {
			System.out.println("Exception occurred: "+exception);
		}
		finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			}
			catch (Exception exception) {
				System.out.println("Exception occurred: "+exception);
			}
		}
		return category;
	}

	@Override
	public List<Category> getAllCategories() {
		ResultSet resultSet = null;
		List<Category> categories = new ArrayList<>();
		try {
			psCategories = getPreparedStatementForCategories();
			resultSet = psCategories.executeQuery();
			while(resultSet.next()){
				Category category = new Category();
				category.setId(resultSet.getInt("id"));
				category.setName(resultSet.getString("name"));
				categories.add(category);
			}
		}
		catch (Exception exception) {
			System.out.println("Exception occurred: "+exception);
		}
		finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			}
			catch (Exception exception) {
				System.out.println("Exception occurred: "+exception);
			}
		}
		return categories;
	}

	@Override
	public void createCategory(Category category) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCategoryById(int id) {
		int result = 0;
		try {
			psDelCategory = getPreparedStatementToDeleteCategory();
			psDelCategory.setInt(1, id);
			result = psDelCategory.executeUpdate();
		}
		catch (Exception exception) {
			System.out.println("Exception occurred: "+exception);
		}

	}

	public static void main(String[] args){
		Properties prop = new Properties();
		try {
			/*prop.load(LibraryDbMgmtImpl.class.getClassLoader().getResourceAsStream("configuration.properties"));
			String userName = prop.getProperty("username");
			String password = prop.getProperty("password");
			String dbUrl = prop.getProperty("dburl");
			String driver = prop.getProperty("driver");*/

			LibraryDbMgmt libraryDbMgmt = new LibraryDbMgmtImpl("com.mysql.jdbc.Driver", "root", "my123sql", "jdbc:mysql://localhost:3306/librarysystem");
			System.out.println(libraryDbMgmt.getAllAuthors());
			System.out.println(libraryDbMgmt.getAllCategories());
			System.out.println(libraryDbMgmt.getAllBooks());
			System.out.println(libraryDbMgmt.getAuthorById(1));
			System.out.println(libraryDbMgmt.getCategorybyId(1));
			System.out.println(libraryDbMgmt.getBookById(1));
			libraryDbMgmt.deleteAuthorById(1);
			System.out.println(libraryDbMgmt.getAllAuthors());

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

}

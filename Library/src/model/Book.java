/**
 * 
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.Database;
import db.Parameter;

/**
 * @author 214475
 *
 */
public class Book {
	// Author, Title, Genre, & Location
	/**
	 * This is the database row ID.
	 */
	private int rowID;
	/**
	 * This is the author of the book.
	 */
	private String author;
	/**
	 * This is the title of the book.
	 */
	private String title;
	/**
	 * This is the genre of the book.
	 */
	private String genre;
	/**
	 * This is the location of the book.
	 */
	private String location;

	/**
	 * This method will return the rowID variable of the book.
	 * 
	 * @return This returns the row ID of the book.
	 */
	public int getRowID() {
		return rowID;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(final String author) {
		this.author = author;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(final String title) {
		this.title = title;
	}

	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(final String genre) {
		this.genre = genre;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(final String location) {
		this.location = location;
	}

	/**
	 * This creates a new book in the database.
	 * 
	 * @throws SQLException
	 */
	public void create() throws SQLException {
		Database db = new Database();
		List<Parameter<?>> params = new ArrayList<>();

		params.add(new Parameter<String>(author));
		params.add(new Parameter<String>(title));
		params.add(new Parameter<String>(genre));
		params.add(new Parameter<String>(location));

		ResultSet rsBook = db.getResultSet("usp_CreateBook", params);
		if (rsBook.next()) {
			rowID = rsBook.getInt(1);
		}
	}

	/**
	 * This updates a pre-existing book in the database.
	 * 
	 * @throws SQLException
	 */
	public void update() throws SQLException {
		Database db = new Database("db.cberkstresser.name", "library");
		List<Parameter<?>> params = new ArrayList<>();

		params.add(new Parameter<Integer>(rowID));
		params.add(new Parameter<String>(author));
		params.add(new Parameter<String>(title));
		params.add(new Parameter<String>(genre));
		params.add(new Parameter<String>(location));

		db.executeSql("usp_UpdateBook", params);
	}

	/**
	 * This will load a book from the database.
	 * 
	 * @param rowID
	 * @throws SQLException
	 */
	public void get(final int rowID) throws SQLException {
		Database db = new Database("db.cberkstresser.name", "library");
		List<Parameter<?>> params = new ArrayList<>();

		params.add(new Parameter<Integer>(rowID));

		ResultSet rsBook = db.getResultSet("usp_GetBook", params);
		if (rsBook.next()) {
			this.rowID = rsBook.getInt("RowID");
			this.author = rsBook.getString("Author");
			this.title = rsBook.getString("Title");
			this.genre = rsBook.getString("Genre");
			this.location = rsBook.getString("Location");
		} else {
			throw new IllegalArgumentException("That book was not found.");
		}
	}

	/**
	 * This will delete a book from the database.
	 * 
	 * @throws SQLException
	 */
	public void delete() throws SQLException {
		Database db = new Database("db.cberkstresser.name", "library");
		List<Parameter<?>> params = new ArrayList<>();

		params.add(new Parameter<Integer>(rowID));

		db.executeSql("usp_DeleteBook", params);
	}

	/**
	 * This will return a list of all the books in the database.
	 * 
	 * @return This returns the list of all the books in the database.
	 * @throws SQLException
	 */
	public static List<Book> getAll() throws SQLException {
		Database db = new Database("db.cberkstresser.name", "library");
		List<Book> allBooks = new ArrayList<>();

		ResultSet rsBook = db.getResultSet("usp_GetAllBooks");

		while (rsBook.next()) {
			Book b = new Book();
			b.rowID = rsBook.getInt("RowID");
			b.author = rsBook.getString("Author");
			b.title = rsBook.getString("Title");
			b.genre = rsBook.getString("Genre");
			b.location = rsBook.getString("Location");
			allBooks.add(b);
		}
		return allBooks;
	}
}

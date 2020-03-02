package controller;

import model.Book;

import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * @author 214475
 *
 */
public class Controller {
	/**
	 * 
	 */
	Book myBook = new Book();

	/**
	 * 
	 */
	@FXML // fx:id="btnSave"
	private Button btnSave; // Value injected by FXMLLoader

	/**
	 * 
	 */
	@FXML // fx:id="btnDelete"
	private Button btnDelete; // Value injected by FXMLLoader

	/**
	 * 
	 */
	@FXML // fx:id="btnUpdate"
	private Button btnUpdate; // Value injected by FXMLLoader

	/**
	 * 
	 */
	@FXML
	private TextField txtGenre;

	/**
	 * 
	 */
	@FXML
	private TextField txtAuthor;

	/**
	 * 
	 */
	@FXML
	private TextField txtTitle;

	/**
	 * 
	 */
	@FXML
	private TextField txtLocation;

	@FXML
	final void handleSave(final ActionEvent event) throws SQLException {
		myBook.setAuthor(txtAuthor.getText());
		myBook.setTitle(txtTitle.getText());
		myBook.setGenre(txtGenre.getText());
		myBook.setLocation(txtLocation.getText());
		myBook.create();
	}

	@FXML
	void handleUpdate(final ActionEvent event) {

	}

	@FXML
	void handleDelete(final ActionEvent event) {

	}
}
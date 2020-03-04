package controller;

import model.Book;

import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
	@FXML // fx:id="tableBooks"
	private TableView<Book> tblBooks; // Value injected by FXMLLoader

	/**
	 * 
	 */
	@FXML // fx:id="tcAuthor"
	private TableColumn<String, Book> tcAuthor; // Value injected by FXMLLoader

	/**
	 * 
	 */
	@FXML // fx:id="tcTitle"
	private TableColumn<String, Book> tcTitle; // Value injected by FXMLLoader

	/**
	 * 
	 */
	@FXML // fx:id="tcGenre"
	private TableColumn<String, Book> tcGenre; // Value injected by FXMLLoader

	/**
	 * 
	 */
	@FXML // fx:id="tcLocation"
	private TableColumn<String, Book> tcLocation; // Value injected by FXMLLoader

	/**
	 * 
	 */
	@FXML // fx:id="btnSave"
	private Button btnSave; // Value injected by FXMLLoader

	/**
	 * 
	 */
	@FXML // fx:id="btnRefresh"
	private Button btnRefresh; // Value injected by FXMLLoader

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

	private void refresh() throws SQLException {
		tblBooks.getItems().setAll(Book.getAll());
		tcAuthor.setCellValueFactory(new PropertyValueFactory<>("Author"));
		tcTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
		tcGenre.setCellValueFactory(new PropertyValueFactory<>("Genre"));
		tcLocation.setCellValueFactory(new PropertyValueFactory<>("Location"));
		System.out.println("Refreshed");
	}

	@FXML
	private void initialize() throws SQLException {
		refresh();
	}

	@FXML
	final void handleSave(final ActionEvent event) throws SQLException {
		myBook.setAuthor(txtAuthor.getText());
		myBook.setTitle(txtTitle.getText());
		myBook.setGenre(txtGenre.getText());
		myBook.setLocation(txtLocation.getText());
		myBook.create();
	}

	@FXML
	final void handleRefresh(final ActionEvent event) throws SQLException {
		refresh();
	}

	@FXML
	final void handleDelete(final ActionEvent event) throws SQLException {
		myBook = tblBooks.getSelectionModel().getSelectedItem();
		myBook.delete();
	}

	@FXML
	final void handleUpdate(final ActionEvent event) throws SQLException {
		myBook = tblBooks.getSelectionModel().getSelectedItem();
		if (!txtAuthor.getText().isBlank()) {
			myBook.setAuthor(txtAuthor.getText());
		}
		if (!txtTitle.getText().isBlank()) {
			myBook.setTitle(txtTitle.getText());
		}
		if (!txtGenre.getText().isBlank()) {
			myBook.setGenre(txtGenre.getText());
		}
		if (!txtLocation.getText().isBlank()) {
			myBook.setLocation(txtLocation.getText());
		}
		myBook.update();
	}

}

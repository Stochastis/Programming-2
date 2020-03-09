package controller;

import model.Book;

import java.sql.SQLException;

import javafx.animation.FadeTransition;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;

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
	@FXML // fx:id="txtSearch"
	private TextField txtSearch; // Value injected by FXMLLoader

	/**
	 * 
	 */
	@FXML
	private TextField txtLocation;

	/**
	 * An editable text field that will display a fading error message when a value
	 * isn't entered properly.
	 */
	@FXML // fx:id="errorMessage"
	private Label errorMessage; // Value injected by FXMLLoader

	/**
	 * This is a fading animation that can be called whenever it is needed.
	 */
	private FadeTransition fade = new FadeTransition();

	/*
	 * This method displays a fading error message. The text of the message can be
	 * passed into the method as a parameter.
	 */
	private void playMessage(final String pMessage) {
		errorMessage.setText(pMessage);
		fade.stop();
		errorMessage.setOpacity(1);
		fade.play();
	}

	private void refresh() throws SQLException {
		tblBooks.getItems().setAll(Book.getAll());
		tcAuthor.setCellValueFactory(new PropertyValueFactory<>("Author"));
		tcTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
		tcGenre.setCellValueFactory(new PropertyValueFactory<>("Genre"));
		tcLocation.setCellValueFactory(new PropertyValueFactory<>("Location"));
	}

	@FXML
	private void initialize() throws SQLException {
		fade.setDuration(Duration.millis(5000));
		fade.setFromValue(10);
		fade.setToValue(0);
		fade.setCycleCount(1000);
		fade.setNode(errorMessage);
		fade.setCycleCount(1);
		refresh();
	}

	@FXML
	final void handleSave(final ActionEvent event) throws SQLException {
		myBook = new Book();
		if (!(txtAuthor.getText().isBlank()) && !(txtTitle.getText().isBlank()) && !(txtGenre.getText().isBlank())
				&& !(txtLocation.getText().isBlank())) {
			myBook.setAuthor(txtAuthor.getText());
			myBook.setTitle(txtTitle.getText());
			myBook.setGenre(txtGenre.getText());
			myBook.setLocation(txtLocation.getText());
			myBook.create();
			playMessage("Book Saved");
			refresh();
		} else {
			playMessage("Please Make Sure All Fields Have Something Before Saving");
		}
	}

	@FXML
	final void handleRefresh(final ActionEvent event) throws SQLException {
		refresh();
		playMessage("Database Refreshed");
	}

	@FXML
	final void handleDelete(final ActionEvent event) throws SQLException {
		myBook = tblBooks.getSelectionModel().getSelectedItem();
		if (myBook == null) {
			playMessage("Please Select A Book To Delete");
		} else {
			myBook.delete();
			playMessage("Book Deleted");
			refresh();
		}
	}

	@FXML
	final int handleUpdate(final ActionEvent event) throws SQLException {
		myBook = tblBooks.getSelectionModel().getSelectedItem();

		if (myBook == null) {
			playMessage("Please Select A Book To Update");
			return 0;
		}
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
		playMessage("Book Updated");
		refresh();
		return 0;
	}

	@FXML
	void handleSearch(final ActionEvent event) {

	}
}

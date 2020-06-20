package testJavaFXButton;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ColorApplication extends Application {

	private Button yellowButton;
	private Button redButton;
	private Button greenButton;
	private ComboBox<String> colorComboBox;
	private MenuBar menuBar;
	private Menu colorMenu;
	private MenuItem redMI;
	private ListView<String> nameListView;
	private ObservableList<String> nameOL;

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox vbox = new VBox();

		MenuItem redMI = new MenuItem("Red");
		redMI.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				vbox.setStyle("-fx-background-color: #FF0000;");
			}

		});
		MenuItem greenMI = new MenuItem("Green");
		greenMI.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				vbox.setStyle("-fx-background-color: #00FF00;");
			}

		});
		MenuItem yellowMI = new MenuItem("Yellow");
		yellowMI.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				vbox.setStyle("-fx-background-color: #FFFF00;");
			}

		});

		Menu colorMenu = new Menu("Color");

		colorMenu.getItems().add(redMI);
		colorMenu.getItems().add(greenMI);
		colorMenu.getItems().add(yellowMI);
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().add(colorMenu);
		vbox.getChildren().add(menuBar);

		yellowButton = new Button("Yellow");
		yellowButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				vbox.setStyle("-fx-background-color: #FFFF00;");
				System.out.println("yellow button pressed");
			}
		});

		vbox.getChildren().add(yellowButton);

		redButton = new Button("Red");
		redButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				vbox.setStyle("-fx-background-color: #FF0000;");
				System.out.println("red button pressed");
			}
		});

		vbox.getChildren().add(redButton);

		greenButton = new Button("Green");
		greenButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				vbox.setStyle("-fx-background-color: #00FF00;");
				System.out.println("green button pressed");
			}
		});

		vbox.getChildren().add(greenButton);
		
		ComboBox<String> colorComboBox = new ComboBox<String>();
		colorComboBox.getItems().add("Yellow");
		colorComboBox.getItems().add("Red");
		colorComboBox.getItems().add("Green");

		colorComboBox.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String selectedItem = colorComboBox.getSelectionModel().getSelectedItem();
				if (selectedItem.equals("Yellow")) {
					vbox.setStyle("-fx-background-color: #FFFF00;");
					System.out.println("Yellow");
				}
				if (selectedItem.equals("Red")) {
					vbox.setStyle("-fx-background-color: #FF0000;");
					System.out.println("Red");
				}
				if (selectedItem.equals("Green")) {
					vbox.setStyle("-fx-background-color: #00FF00;");
					System.out.println("Green");
				}
			}
		});
		
		vbox.getChildren().add(colorComboBox);
		
		nameListView = new ListView<String>();
		nameOL = FXCollections.observableArrayList ( "A", "B", "C", "D");
		nameListView.setItems(nameOL);
		nameOL.add("Islanders");
		vbox.getChildren().add(nameListView);

		Scene scene = new Scene(vbox, 500, 500);

		primaryStage.setScene(scene);

		primaryStage.setTitle("Lab - Colors");
		primaryStage.show();

	}

}

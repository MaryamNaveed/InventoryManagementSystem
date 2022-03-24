package application;

import java.io.IOException;

import buisnessLayer.Category;
import buisnessLayer.Product;
import buisnessLayer.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class UpdateProductController {

	@FXML
	private Label Selectedcategory;

	@FXML
	private MenuButton categoryMenu;

	@FXML
	private Label Selectedproduct;

	@FXML
	private MenuButton productMenu;

	@FXML
	private TextField item_name;

	@FXML
	private GridPane itemcategory;

	@FXML
	private TextField purchased_price;

	@FXML
	private TextField quantity;

	@FXML
	private TextField selling_price;

	Store store;

	@FXML
	void HandlecategoryMenu(ActionEvent event) {
		Selectedcategory.setText(((MenuItem) event.getSource()).getText());

	}

	@FXML
	void HandleproductMenu(ActionEvent event) {
		Selectedproduct.setText(((MenuItem) event.getSource()).getText());
		
		Product tempP = this.store.searchProduct(Selectedproduct.getText());
		
		item_name.setText(tempP.getName());
		purchased_price.setText(String.valueOf(tempP.getPurchasedPrice()));
		selling_price.setText(String.valueOf(tempP.getSellingPrice()));
		quantity.setText(String.valueOf(tempP.getQuantity()));
		Selectedcategory.setText(tempP.getCategory().getName());
	}

	public void initData(Store s) {
		this.store = s;

		for (int i = 0; i < this.store.getProductCatalog().getProducts().size(); i++) {
			MenuItem menuItem = new MenuItem(this.store.getProductCatalog().getProducts().get(i).getName());
			menuItem.setOnAction(this::HandleproductMenu);
			menuItem.setStyle("-fx-pref-height: 30px");
			productMenu.getItems().add(menuItem);
		}

		for (int i = 0; i < this.store.getProductCatalog().getCategories().size(); i++) {
			MenuItem menuItem = new MenuItem(this.store.getProductCatalog().getCategories().get(i).getName());
			menuItem.setOnAction(this::HandlecategoryMenu);
			menuItem.setStyle("-fx-pref-height: 30px");
			categoryMenu.getItems().add(menuItem);
		}
	}

	@FXML
	void UpdateProduct(ActionEvent event) {
		Product tempP = this.store.searchProduct(Selectedproduct.getText());
		if (tempP != null) {
			Category c = this.store.searchCategory(Selectedcategory.getText());
			if(item_name.getText() == null || item_name.getText().trim().isEmpty()) {
				Alert a1 = new Alert(AlertType.NONE);

				a1.setAlertType(AlertType.ERROR);

				a1.setHeaderText("Product Name is required!!!");

				a1.show();
			} else if (!isInt(quantity.getText())) {
				Alert a1 = new Alert(AlertType.NONE);

				a1.setAlertType(AlertType.ERROR);

				a1.setHeaderText("Quantity should be a positive integer value");

				a1.show();
			} else if (!isDouble(selling_price.getText())) {
				Alert a1 = new Alert(AlertType.NONE);

				a1.setAlertType(AlertType.ERROR);

				a1.setHeaderText("Selling Price should be a positive decimal value");

				a1.show();
			} else if (!isDouble(purchased_price.getText())) {
				Alert a1 = new Alert(AlertType.NONE);

				a1.setAlertType(AlertType.ERROR);

				a1.setHeaderText("Purchased Price should be a positive decimal value");

				a1.show();
			} else {
				

				if (c != null) {
					Product p = new Product(item_name.getText(), Integer.parseInt(quantity.getText()),
							Double.parseDouble(selling_price.getText()), Double.parseDouble(purchased_price.getText()),
							c);
					String result = this.store.UpdateProduct(tempP.getId(), p);

					if (result == null) {
						Alert a1 = new Alert(AlertType.NONE);

						a1.setAlertType(AlertType.INFORMATION);

						a1.setHeaderText("Successfully Updated Product");

						a1.show();
						Parent root;
						try {
							FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
							root = (Parent) loader.load();
							MainController controller = loader.getController();
							controller.initData(this.store);

							Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
							Scene scene = new Scene(root);
							stage.setScene(scene);
							stage.show();
						} catch (IOException e) {
							e.printStackTrace();
						}

					} else {
						Alert a1 = new Alert(AlertType.NONE);

						a1.setAlertType(AlertType.ERROR);

						a1.setHeaderText(result);

						a1.show();
					}
				} else {
					Alert a1 = new Alert(AlertType.NONE);

					a1.setAlertType(AlertType.ERROR);

					a1.setHeaderText("Please Select a category for product");

					a1.show();
				}
			}

		}
		else {
			Alert a1 = new Alert(AlertType.NONE);

			a1.setAlertType(AlertType.ERROR);

			a1.setHeaderText("Please Select a product to be updated");

			a1.show();
		}


	}

	private static boolean isDouble(String str) {
		try {
			double d = Double.parseDouble(str);
			if (d <= 0) {
				return false;
			}

		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	private static boolean isInt(String str) {
		try {
			int d = Integer.parseInt(str);
			if (d <= 0) {
				return false;
			}

		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

}

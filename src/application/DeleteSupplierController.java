package application;



import buisnessLayer.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class DeleteSupplierController {
	

	
Store store;
@FXML
private Label Selectedsupplier;

@FXML
private MenuButton supplierMenu;



@FXML
void HandlecustomerMenu(ActionEvent event) {
	Selectedsupplier.setText(((MenuItem) event.getSource()).getText());

}

public void initData(Store s) {
	this.store = s;
	
	for (int i = 0; i < this.store.getSuppliers().size(); i++) {
		MenuItem menuItem = new MenuItem(this.store.getSuppliers().get(i).getId()+","+this.store.getSuppliers().get(i).getName()+"("+this.store.getSuppliers().get(i).getEmail()+")");
		menuItem.setOnAction(this::HandlecustomerMenu);
		menuItem.setStyle("-fx-pref-height: 30px");
		supplierMenu.getItems().add(menuItem);
	}
}

}

package application;

import java.util.ArrayList;
import java.util.Arrays;

import buisnessLayer.Store;
import buisnessLayer.Supplier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class UpdateSupplierController {

	
Store store;
@FXML
private Label Selectedsupplier;

@FXML
private MenuButton supplierMenu;

@FXML
private TextField address;

@FXML
private TextField email;

@FXML
private TextField name;

@FXML
private TextField phone;

@FXML
void HandlecustomerMenu(ActionEvent event) {
	Selectedsupplier.setText(((MenuItem) event.getSource()).getText());
	
	ArrayList<String> arr=new ArrayList<>(Arrays.asList(Selectedsupplier.getText().split(",")));
	String reqid=arr.get(0);
	Supplier tempc=this.store.searchSupplier(Integer.parseInt(reqid));
	
	name.setText(tempc.getName());
	address.setText(tempc.getAddress());
	email.setText(tempc.getEmail());
	phone.setText(tempc.getPhone());
	

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

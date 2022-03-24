package application;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import buisnessLayer.Store;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Tab;

public class StockController implements Initializable {
	 @FXML
    private Tab addStockTab;

    @FXML
    private Tab availableStockTab;

    @FXML
    private Tab deleteStockTab;

    @FXML
    private Tab updateStockTab;
    
	
	Store store;
	    
    
    public void initData(Store s) {
    	this.store=s;
    	
    	try {
    		FXMLLoader loader1=new FXMLLoader(getClass().getResource("AvailableStock.fxml"));
	    	Node node1=(Node) loader1.load();
			AvailableStockController controller1= loader1.getController();
			controller1.initData(this.store);
    	
    	
			availableStockTab.setContent(node1);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	
    	
    }

}

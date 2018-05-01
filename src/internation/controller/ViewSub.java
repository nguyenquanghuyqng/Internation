package internation.controller;

import java.util.List;
import java.util.ResourceBundle;
import internation.dao.GetSub;
import internation.model.Sub;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.media.MediaView;
import javafx.util.Duration;



public class ViewSub extends BorderPane {
	
	private TableView<Sub> tableview = new TableView<Sub>();
	private ObservableList<Sub> data = FXCollections.observableArrayList();
	private MediaPlayer mp;
	//private TableView tableSub = new TableView();
	private HBox pane; 
	 
	public ViewSub(final MediaPlayer mp)
	{
		this.mp=mp;
		
		//Tao tableSub
		TableColumn timeCol = new TableColumn("Time");
		timeCol.setMinWidth(10);
		timeCol.setCellValueFactory(new PropertyValueFactory<Sub, String>("time"));
		
        TableColumn subCol = new TableColumn("Sub");
        subCol.setMinWidth(420);
        subCol.setCellValueFactory(new PropertyValueFactory<Sub, String>("content"));

        tableview.getColumns().addAll(timeCol, subCol);
        //
        //Xuat du lieu
        
        List<Sub> lsubtime = GetSub.GetListSub(1);
		List<Sub> lsubtsub = GetSub.GetListSub(1);
		for (Sub s : lsubtsub) {
			try {
				System.out.println("Sub :" + s.getContent());
				System.out.println("Time :" + s.getTime());
				data.add(new Sub(s.getTime(), s.getContent()));
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}

		tableview.getColumns().addAll(timeCol, subCol);

		tableview.getItems().setAll(data);
        
		pane = new HBox();
		pane.setAlignment(Pos.CENTER);
		//pane.setMargin(mp,new Insets(5,5,5,5));
        BorderPane.setAlignment(pane, Pos.CENTER);
		pane.getChildren().add(tableview);		
		setRight(pane);
				
	}

}

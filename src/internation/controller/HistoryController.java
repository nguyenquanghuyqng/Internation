package internation.controller;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import internation.dao.GetListReview;
import internation.dao.GetListVideo;
import internation.model.Review;
import internation.model.Video;
import internation.model.tablevideo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class HistoryController implements Initializable{
	@FXML
	private TableView<tablevideo> videotable=new TableView<tablevideo>();
	@FXML
	private TableColumn<tablevideo,ImageView> hinh;
	@FXML
	private TableColumn<tablevideo,String> name;
	@FXML
	private ListView<String> txtview;
	@FXML
	private Button btnsearch;
	@FXML
	private Button btnsearch1;
	@FXML
	private TextField txtsearch;
	@FXML 
	private ListView<String> senlist;
	
	private ObservableList<tablevideo> video = FXCollections.observableArrayList();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//File file = new File("src/Images/search.png");
		 BackgroundImage backgroundImage = new BackgroundImage( new Image("Images/search.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
	        Background background = new Background(backgroundImage);
	      btnsearch.setBackground(background);
	      btnsearch1.setBackground(background);
	    

		List<Video> listvd=GetListVideo.GetList();
		List<Review> listrv=GetListReview.GetList();
	
		
		//	hinh.setMinWidth(400);
		hinh.setCellValueFactory(new PropertyValueFactory<tablevideo, ImageView>("img"));

		//name.setMinWidth(600);
		name.setCellValueFactory(new PropertyValueFactory<tablevideo, String>("videoname"));  





		for (Video vd :listvd){
		
		
			
		
		    video.add(new tablevideo(vd.getId(),new ImageView(new Image(vd.getImage().toString())),vd.getVideoname()));
//
//
		}
		//videotable.getColumns().addAll(hinh,name);
		
		
		
		
		videotable.getItems().setAll(video);
		videotable.autosize();
		
		
		//hien cac cau trong video
		for (Review vr :listrv){    		
		
			senlist.getItems().add(vr.getContent().toString());

//
		}
		videotable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			 txtview.getItems().clear();
			 System.out.println(newSelection.getVideoname());
		    if (newSelection == null) {
		        System.out.println("old");
		    }
		    else
		    {
		    	for (Review vr :listrv){
		    		
					if(vr.getVideo_id() == newSelection.getId() ){				
					  
				       txtview.getItems().add(vr.getContent().toString());
					}
				//	senlist.getItems().add(vr.getContent().toString());

		//
				}
		    }
		});
		
	   
		
	}

}

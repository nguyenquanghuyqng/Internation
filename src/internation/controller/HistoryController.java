package internation.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import internation.dao.GetListReview;
import internation.dao.GetListVideo;
import internation.model.Review;
import internation.model.Video;
import internation.model.tablevideo;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
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
	@FXML
	private TextField sensearch;


	private int vt;
	List<Video> listvd=GetListVideo.GetList();
	List<Review> listrv=GetListReview.GetList();
	ObservableList<Review> entries = FXCollections.observableArrayList();


	private ObservableList<tablevideo> video = FXCollections.observableArrayList();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//File file = new File("src/Images/search.png");
		BackgroundImage backgroundImage = new BackgroundImage( new Image("Images/search.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		Background background = new Background(backgroundImage);
		btnsearch.setBackground(background);
		btnsearch1.setBackground(background);


		//FilteredList<Review> filteredData = new FilteredList<>(entries,p -> true);


		//	hinh.setMinWidth(400);
		hinh.setCellValueFactory(new PropertyValueFactory<tablevideo, ImageView>("img"));

		//name.setMinWidth(600);
		name.setCellValueFactory(new PropertyValueFactory<tablevideo, String>("videoname"));  





		for (Video vd :listvd){


            if(vd.getTimepause().toString()!="00:00:00"){

			video.add(new tablevideo(vd.getId(),new ImageView(new Image(vd.getImage().toString())),vd.getVideoname()));
            }
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
			System.out.println(newSelection.getId());
			vt=newSelection.getId();
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
		//		txtsearch.setOnKeyReleased(e ->{
		//			txtsearch.textProperty().addListener((observable, oldValue, newValue) -> {
		//				filteredData.setPredicate(Review ->{
		//					// If filter text is empty, display all persons.
		//					if(newValue == null || newValue.isEmpty()){
		//						return true;
		//					}
		//
		//					// Compare first name and last name of every client with filter text.
		//					String lowerCaseFilter = newValue.toLowerCase();
		//
		//					if(Review.getContent().toLowerCase().contains(lowerCaseFilter)){
		//						return true; //filter matches first name
		//
		//					}
		//					return false; //Does not match
		//				});
		//			});
		//
		//
		//			SortedList<Review> sortedData = new SortedList<>(filteredData);
		//			txtview.setItems(sortedData);
		//		});
		txtsearch.textProperty().addListener(
				new ChangeListener() {
					public void changed(ObservableValue observable, 
							Object oldVal, Object newVal) {

						txtview.getItems().clear();
						handleSearchByKey((String)oldVal, (String)newVal);
					}
				});
		sensearch.textProperty().addListener(
				new ChangeListener() {
					public void changed(ObservableValue observable, 
							Object oldVal, Object newVal) {

						senlist.getItems().clear();
						handleSearchByKey2((String)oldVal, (String)newVal);
					}
				});



		//



	}

	public void handleSearchByKey(String oldVal, String newVal) {


		// If the number of characters in the text box is less than last time
		// it must be because the user pressed delete
		if ( oldVal != null && (newVal.length() < oldVal.length()) ) {

			// Restore the lists original set of entries 
			// and start from the beginning
			for (Review vr :listrv){

				if(vr.getVideo_id() == vt){				

					txtview.getItems().add(vr.getContent().toString());

				}
			}
		}
		else{for (Review vr :listrv){

			if(vr.getVideo_id() == vt){				

				txtview.getItems().add(vr.getContent().toString());

			}
		}}




		// Break out all of the parts of the search text 
		// by splitting on white space
		String[] parts = newVal.toUpperCase().split(" ");

		// Filter out the entries that don't contain the entered text
		ObservableList<String> subentries = FXCollections.observableArrayList();
		//System.out.println(txtview.getItems().toString());
		for ( Object entry: txtview.getItems() ) {

			boolean match = true;
			String entryText = (String)entry;
			for ( String part: parts ) {
				// The entry needs to contain all portions of the
				// search string *but* in any order
				if ( ! entryText.toUpperCase().contains(part) ) {
					match = false;
					break;
				}
			}

			if ( match ) {
				subentries.add(entryText);
			}
		}
		txtview.setItems(subentries);
	}
	public void handleSearchByKey2(String oldVal, String newVal) {


		// If the number of characters in the text box is less than last time
		// it must be because the user pressed delete
		if ( oldVal != null && (newVal.length() < oldVal.length()) ) {

			// Restore the lists original set of entries 
			// and start from the beginning
			for (Review vr :listrv){


				senlist.getItems().add(vr.getContent().toString());


			}
		}
		else{for (Review vr :listrv){



			senlist.getItems().add(vr.getContent().toString());


		}}




		// Break out all of the parts of the search text 
		// by splitting on white space
		String[] parts = newVal.toUpperCase().split(" ");

		// Filter out the entries that don't contain the entered text
		ObservableList<String> subentries = FXCollections.observableArrayList();
		//System.out.println(txtview.getItems().toString());
		for ( Object entry: senlist.getItems() ) {

			boolean match = true;
			String entryText = (String)entry;
			for ( String part: parts ) {
				// The entry needs to contain all portions of the
				// search string *but* in any order
				if ( ! entryText.toUpperCase().contains(part) ) {
					match = false;
					break;
				}
			}

			if ( match ) {
				subentries.add(entryText);
			}
		}
		senlist.setItems(subentries);
	}
}

//


package internation.controller;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import internation.dao.GetSub;
import internation.model.Sub;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class MainController implements Initializable {
	@FXML
	private MediaView mv;
	@FXML
	private ListView listsub;	
	private MediaPlayer mp;
	private Media me;
	private Slider slider;
//	final VBox vbox = new VBox();
	
	public static final ObservableList subtime = 
	        FXCollections.observableArrayList();
	    public static final ObservableList sub = 
	        FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		List<Sub> lsubtime = GetSub.GetListTime(1);	
		List<Sub> lsubtsub = GetSub.GetListSub(1); 	
		
		// Lấy file path của video
		String path = new File("src/media/huy.mp4").getAbsolutePath();
		me = new Media(new File(path).toURI().toString());
		mp = new MediaPlayer(me);
		mv.setMediaPlayer(mp);
		mp.setAutoPlay(true);
//	
//		DoubleProperty width = mv.fitWidthProperty();
//		DoubleProperty height = mv.fitHeightProperty();
//		width.bind(Bindings.selectDouble(mv.sceneProperty(), "width"));
//		height.bind(Bindings.selectDouble(mv.sceneProperty(), "height"));
		
		
		
//		vbox.getChildren().add(slider);
//		mp.play();
		mp.setOnReady(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				int w= mp.getMedia().getWidth();
				int h= mp.getMedia().getHeight();
						
				slider.setMinSize(w, 100);
//				vbox.setTranslateY(h-100);
			}
		});
		
		System.out.println("Start show sub");
		for (Sub s : lsubtsub) {
			sub.add(s.getContent());
		}
		listsub.setItems(sub);
		
		
		//huy
			System.out.println("Huy");
		//Huy
		
	}

}

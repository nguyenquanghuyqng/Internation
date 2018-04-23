package internation.controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

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
	private ListView sub;
	private MediaPlayer mp;
	private Media me;
	private Slider slider;
//	final VBox vbox = new VBox();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Lấy file path của video
		String path = new File("src/media/Huy.mp4").getAbsolutePath();
		me = new Media(new File(path).toURI().toString());
		mp = new MediaPlayer(me);
		mv.setMediaPlayer(mp);
//		mp.setAutoPlay(true);
	
//		DoubleProperty width = mv.fitWidthProperty();
//		DoubleProperty height = mv.fitHeightProperty();
//		width.bind(Bindings.selectDouble(mv.sceneProperty(), "width"));
//		height.bind(Bindings.selectDouble(mv.sceneProperty(), "height"));
		
//		vbox.getChildren().add(slider);
		mp.play();
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
		
	}

}

package internation;

import java.awt.Label;
import java.io.File;
import java.net.URL;
import java.time.Duration;

import internation.controller.MediaControl;
import internation.controller.ViewSub;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class Main extends Application {
	private MediaPlayer mp;
    private MediaView mediaView;
    private final boolean repeat = false;
    private boolean stopRequested = false;
    private boolean atEndOfMedia = false;
    private Duration duration;
    private Slider timeSlider;
    private Label playTime;
    private Slider volumeSlider;
    private HBox mediaBar;
	@Override
	public void start(Stage primaryStage) {
		try {
			/*Parent root = FXMLLoader.load(getClass().getResource("/internation/Main.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			*/
			//Hiep 
			Group root = new Group();
			Scene scene = new Scene(root, 1500, 600);
			String path = new File("src/media/Video3.mp4").getAbsolutePath();
			Media pick = new Media(new File(path).toURI().toString());
			//Media pick = new Media("file:///" + System.getProperty("user.dir").replace('\\', '/') + "/" + "media/Video3.mp4");
	        //Media media = new Media (pick);
	        MediaPlayer mediaPlayer = new MediaPlayer(pick);
	        mediaPlayer.setAutoPlay(true);
	        MediaControl mediaControl = new MediaControl(mediaPlayer);
	        //ViewSub sub = new ViewSub(mediaPlayer);
	        root.getChildren().add(mediaControl);
	        //root.getChildren().add(sub);
	        scene.setRoot(root);

	        
	        primaryStage.setScene(scene);
	        
	        primaryStage.show();
	        //
	} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
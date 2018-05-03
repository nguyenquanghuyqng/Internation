package internation.controller;

import java.io.File;
import java.net.URL;
import java.util.DuplicateFormatFlagsException;
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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.media.MediaPlayer.Status;
import javafx.util.Duration;

public class VideoController implements Initializable {
	@FXML
	private MediaView mediaView;
	//@FXML
	//private TableView tableview;
	@FXML
	private Label playTime;
	@FXML
	private Slider timeSlider;
	@FXML
	private Button playButton;
	
	private Media me;
	private MediaPlayer mp;

	private final boolean repeat = false;
	private boolean stopRequested = false;
	private boolean atEndOfMedia = false;
	private Duration duration;
	@FXML
	private TableView<Sub> tableview = new TableView<Sub>();
	@FXML
	private TableView<Sub> tableviewInternation = new TableView<Sub>();
	private ObservableList<Sub> data1 = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		
        
		// Láº¥y file path cá»§a video
		String path = new File("src/media/Video3.mp4").getAbsolutePath();
		me = new Media(new File(path).toURI().toString());
		mp = new MediaPlayer(me);
		mediaView.setMediaPlayer(mp);
		mp.setAutoPlay(true);
		playButton.setStyle("-fx-background-image: url('/Images/pause.png')");
		
		//Thong bao
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Help");
        alert.setHeaderText("Hướng dẫn học thao tac chuột trên video");
        alert.setContentText("Để tua nhanh video bạn dùng chuột kéo thanh slider phái dưới màn hình video \n Click chuột phải để tua video lại thời điểm bạn cần nghe \n Click chuột phải để lưu câu đó");
 
        alert.showAndWait();

		playButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                System.out.println(tableview.getColumns().indexOf(1));
                Status status = mp.getStatus();

                if (status == Status.UNKNOWN || status == Status.HALTED) {
                    // don't do anything in these states
                    return;
                }

                if (status == Status.PAUSED
                        || status == Status.READY
                        || status == Status.STOPPED) {
                    // rewind the movie if we're sitting at the end
                    if (atEndOfMedia) {
                        mp.seek(mp.getStartTime());
                        atEndOfMedia = false;
                    }
                    mp.play();
                    playButton.setStyle("-fx-background-image: url('/Images/pause.png')");
                } else {
                    mp.pause();
                    playButton.setStyle("-fx-background-image: url('/Images/play.png')");
                }
                System.out.println("1");
            }
        });
		
		 //Su kiá»‡n slider di chuyá»ƒn  khi cháº¡y video 
        mp.currentTimeProperty().addListener(new InvalidationListener() {
            public void invalidated(Observable ov) {
                updateValues();
                System.out.println("2");
            }
        });
        
        mp.setOnPlaying(new Runnable() {
            public void run() {
                if (stopRequested) {
                    mp.pause();
                    stopRequested = false;
                } else {
                    //playButton.setText("||");
                    playButton.setStyle("-fx-background-image: url('/Images/pause.png')");
                }
                System.out.println("3");
            }
        });

        mp.setOnPaused(new Runnable() {
            public void run() {
                System.out.println("onPaused");
                //playButton.setText(">");
                playButton.setStyle("-fx-background-image: url('/Images/play.png')");
                System.out.println("4");
            }
        });

        mp.setOnReady(new Runnable() {
            public void run() {
                duration = mp.getMedia().getDuration();
                updateValues();
                System.out.println("5");
            }
        });

        mp.setCycleCount(repeat ? MediaPlayer.INDEFINITE : 1);
        mp.setOnEndOfMedia(new Runnable() {
            public void run() {
                if (!repeat) {
                    //playButton.setText(">");
                    playButton.setStyle("-fx-background-image: url('/Images/play.png')");
                    stopRequested = true;
                    atEndOfMedia = true;
                }
                System.out.println("6");
            }
        });
        
      //Ham keo chuot
        timeSlider.valueProperty().addListener(new InvalidationListener() {
            public void invalidated(Observable ov) {
                if (timeSlider.isValueChanging()) {
                    // multiply duration by percentage calculated by slider position
                    mp.seek(duration.multiply(timeSlider.getValue() / 100.0));
                }
                System.out.println("7");
            }
        });
        
       
        
        
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
        		data1.add(new Sub(s.getTime(), s.getContent()));
        	} catch (Exception e) {
        		System.out.println("Error: " + e.getMessage());
        	}
        }

        tableview.getColumns().addAll(timeCol, subCol);

        tableview.getItems().setAll(data1);
//        
        tableview.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				String timeStart =tableview.getSelectionModel().getSelectedItem().getTime();
				int t_Start=conVertTimeToInt(timeStart);
				//int time = Integer.parseInt(timeStart);
				int index = tableview.getSelectionModel().getSelectedIndex();
				//String timeStop = tableview.getColumns().get(index+1).getCellObservableValue(0).getValue().toString();
				System.out.println(t_Start +"   " + index);
			    //gan lai gia tri cho slide --> tu slider thong qua updateValue de xet thoi gian video
				timeSlider.setValue(t_Start/2);
				updateValues();
				mp.seek(duration.multiply(timeSlider.getValue() / 100.0));
;
			}
        	
		});
       
		
	}
	protected void updateValues() {
        if (playTime != null && timeSlider != null ) {
            Platform.runLater(new Runnable() {
                public void run() {
                    Duration currentTime = mp.getCurrentTime();
                    playTime.setText(formatTime(currentTime, duration));
                    timeSlider.setDisable(duration.isUnknown());
                    if (!timeSlider.isDisabled()
                            && duration.greaterThan(Duration.ZERO)
                            && !timeSlider.isValueChanging()) {
                        timeSlider.setValue(currentTime.divide(duration).toMillis()
                                * 100.0);
                    }
                }
            });
        }
    }
	
	private static String formatTime(Duration elapsed, Duration duration) {
        int intElapsed = (int) Math.floor(elapsed.toSeconds());
        int elapsedHours = intElapsed / (60 * 60);
        if (elapsedHours > 0) {
            intElapsed -= elapsedHours * 60 * 60;
        }
        int elapsedMinutes = intElapsed / 60;
        int elapsedSeconds = intElapsed - elapsedHours * 60 * 60
                - elapsedMinutes * 60;

        if (duration.greaterThan(Duration.ZERO)) {
            int intDuration = (int) Math.floor(duration.toSeconds());
            int durationHours = intDuration / (60 * 60);
            if (durationHours > 0) {
                intDuration -= durationHours * 60 * 60;
            }
            int durationMinutes = intDuration / 60;
            int durationSeconds = intDuration - durationHours * 60 * 60
                    - durationMinutes * 60;
            if (durationHours > 0) {
                return String.format("%d:%02d:%02d/%d:%02d:%02d",
                        elapsedHours, elapsedMinutes, elapsedSeconds,
                        durationHours, durationMinutes, durationSeconds);
            } else {
                return String.format("%02d:%02d/%02d:%02d",
                        elapsedMinutes, elapsedSeconds, durationMinutes,
                        durationSeconds);
            }
        } else {
            if (elapsedHours > 0) {
                return String.format("%d:%02d:%02d", elapsedHours,
                        elapsedMinutes, elapsedSeconds);
            } else {
                return String.format("%02d:%02d", elapsedMinutes,
                        elapsedSeconds);
            }
        }
    }
    public int conVertTimeToInt(String time )
    {
    	int timeAfterConvert=0;
    	char t;
    	int v;
    	//chuc phut
    	t=time.charAt(0);
    	if(t!='0')
    	{
    		v= t-'0';
    		timeAfterConvert=v*10;
    	}
    	//phut don vi
    	t=time.charAt(1);
    	if(t!='0')
    	{
    		v= t-'0';
    		timeAfterConvert=timeAfterConvert+v;
    	}
    	//giay 
    	t=time.charAt(3);
    	if(t!='0')
    	{
    		v= t-'0';
    		timeAfterConvert=timeAfterConvert*60+v*10;
    		t=time.charAt(4);
        	if(t!='0')
        	{
        		v= t-'0';
        		timeAfterConvert=timeAfterConvert+v;;
        	}
    	}
    	
    	if(t=='0')
    	{
 
    		t=time.charAt(4);
        	if(t!='0')
        	{
        		v= t-'0';
        		timeAfterConvert=timeAfterConvert*60+v;;
        	}
    	}
    	return timeAfterConvert;
    }

}

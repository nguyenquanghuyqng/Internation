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
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class MainController implements Initializable {
	@FXML
	private MediaView mv;
	private MediaPlayer mp;
	private Media me;
	private Slider slider;
	@FXML
	private TableView<Sub> tableview = new TableView<Sub>();

	// public static final ObservableList subtime =
	// FXCollections.observableArrayList();
	// public static final ObservableList<Sub> sub =
	// FXCollections.observableArrayList();

	// private final ObservableList<Video> data =
	// FXCollections.observableArrayList();

	private ObservableList<Sub> data = FXCollections.observableArrayList();

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		List<Sub> lsubtime = GetSub.GetListTime(1);
		List<Sub> lsubtsub = GetSub.GetListSub(1);

		// Lấy file path của video
		String path = new File("src/media/Video3.mp4").getAbsolutePath();
		me = new Media(new File(path).toURI().toString());
		mp = new MediaPlayer(me);
		mv.setMediaPlayer(mp);
		mp.setAutoPlay(true);

		// vbox.getChildren().add(slider);
		// mp.play();
		// mp.setOnReady(new Runnable() {
		//
		// @Override
		// public void run() {
		// // TODO Auto-generated method stub
		// int w= mp.getMedia().getWidth();
		// int h= mp.getMedia().getHeight();
		//
		// slider.setMinSize(w, 100);
		//// vbox.setTranslateY(h-100);
		// }
		// });

		// System.out.println("Start show sub");
		// for (Sub s : lsubtsub) {
		// tableview.setItems(lsubtsub);
		// }
		// listsub.setItems(sub);

		TableColumn Time = new TableColumn("Time1");
		Time.setMinWidth(10);
		Time.setCellValueFactory(new PropertyValueFactory<Sub, String>("time"));

		TableColumn Sub = new TableColumn("Sub2");
		Sub.setMinWidth(420);
		Sub.setCellValueFactory(new PropertyValueFactory<Sub, String>("content"));

		for (Sub s : lsubtsub) {
			try {
				System.out.println("Sub :" + s.getContent());
				System.out.println("Time :" + s.getTime());
				data.add(new Sub(s.getTime(), s.getContent()));
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}

		tableview.getColumns().addAll(Time, Sub);

		tableview.getItems().setAll(data);
	}

}

package internation.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import internation.dao.GetListVideo;
import internation.model.Video;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class ListVideoController implements Initializable {
	@FXML
	private ImageView video1;
	@FXML
	private ImageView video2;
	@FXML
	private ImageView video3;
	@FXML
	private Text content1;
	@FXML
	private Text content2;
	@FXML
	private Text content3;
	@FXML
	private Text descontent1;
	@FXML
	private Text descontent2;
	@FXML
	private Text descontent3;

	public void ForwardVideo(ActionEvent event) {
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		System.out.println("Hello Huy");

		List<Video> list = GetListVideo.GetList();

		for (Video video : list) {

			if (video.getId() == 1) {
				 content1.setText(video.getVideoname());
				 descontent1.setText(video.getContent());
				String img = video.getImage();
				System.out.println("Hello Huy" + img);
				video1.setImage(new Image(img));
				
			} else {
				if (video.getId() == 2) {
					 content2.setText(video.getVideoname());
					 descontent2.setText(video.getContent());
					String img = video.getImage();
					video2.setImage(new Image(img));
				} else {
					if (video.getId() == 3) {
						 content3.setText(video.getVideoname());
						 descontent3.setText(video.getContent());
						String img = video.getImage();
						video3.setImage(new Image(img));
					}
				}
			}
		}
		
		

	}
}
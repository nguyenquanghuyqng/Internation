package internation.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import internation.dao.GetListVideo;
import internation.model.Video;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ListVideoController implements Initializable{
	@FXML
	private ImageView video1;
	@FXML
	private ImageView video2;
	@FXML
	private ImageView video3;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		List<Video> list = GetListVideo.GetList();
		
		for (Video video : list) {

			if (video.getId() == 1) {
//				lblVideo1.setText(video.getVideoname());
//				lblContent1.setText(video.getContent());
				String img = video.getImage();
				video1.setImage(new Image(img));
			} else {
				if (video.getId() == 2) {
//					lblVideo2.setText(video.getVideoname());
//					lblContent2.setText(video.getContent());
					String img = video.getImage();
					video2.setImage(new Image(img));
				} else {
					if (video.getId() == 3) {
//						lblVideo3.setText(video.getVideoname());
//						lblContent3.setText(video.getContent());
						String img = video.getImage();
						video3.setImage(new Image(img));
					}
				}
			}
		}
		
	}
}

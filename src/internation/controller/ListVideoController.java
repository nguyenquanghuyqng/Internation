package internation.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import internation.dao.GetListVideo;
import internation.model.ItemVideo;
import internation.model.Review;
import internation.model.Video;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ListVideoController implements Initializable {
	@FXML
	private ListView<ItemVideo> listView;
	@FXML
	private Pane pnParent;
	private final ObservableList<ItemVideo> data = FXCollections.observableArrayList();

	int id=1;
	@FXML
	public void handleMouseClick(MouseEvent arg0) {
		// System.out.println("clicked on " +
		// listView.getSelectionModel().getSelectedItem());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		List<Video> listvideo = GetListVideo.GetList();
		for (Video vd : listvideo) {
			data.add(new ItemVideo(vd.getImage(), vd.getVideoname(), vd.getContent()));
		}
		// data.addAll(new ItemVideo("link","huy","hello"),new
		// ItemVideo("link","huy","hello"),new ItemVideo("link","huy","hello"));

		listView.setCellFactory(new Callback<ListView<ItemVideo>, ListCell<ItemVideo>>() {

			@Override
			public ListCell<ItemVideo> call(ListView<ItemVideo> arg0) {
				// TODO Auto-generated method stub
				System.out.println("Show list ");
				return new ListCell<ItemVideo>() {

					@Override
					protected void updateItem(ItemVideo item, boolean bln) {
						super.updateItem(item, bln);
						if (item != null) {
							System.out.println(item.getImage());

							javafx.scene.image.Image img = new javafx.scene.image.Image(item.getImage());
							ImageView imageView = new ImageView(img);
							setGraphic(imageView);

							VBox vbox = new VBox(new Text(item.getContent()), new Text(item.getDescontent()));

							HBox hBox = new HBox(new ImageView(img), vbox);

							hBox.setSpacing(10);
							setGraphic(hBox);

						}
					}
				};
			}
		});

		listView.setItems(data);

		listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Parent root;
				try {
					Container.getInstance().x = id;
					root = FXMLLoader.load(getClass().getResource("/internation/Main.fxml"));
					pnParent.getChildren().add(root);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}

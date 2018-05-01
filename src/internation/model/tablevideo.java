package internation.model;

import javafx.scene.image.ImageView;

public class tablevideo {
	private int id;
	private ImageView img;
	private String videoname;

	

	

	public tablevideo(int id, ImageView img, String videoname) {
		super();
		this.id = id;
		this.img = img;
		this.videoname = videoname;
	}

	public tablevideo(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ImageView getImg() {
		return img;
	}

	public void setImg(ImageView img) {
		this.img = img;
	}

	public String getVideoname() {
		return videoname;
	}

	public void setVideoname(String videoname) {
		this.videoname = videoname;
	}

	
	


	
	
}

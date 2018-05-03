package internation.model;

import java.io.File;
import java.sql.Time;


public class Video {

	private int id;
	private String videoname;
	private String content;
	private Time timepause;
	private String image;
	private String link;

	public Video(int id, String videoname, String content, Time timepause, String image, String link) {
		super();
		this.id = id;
		this.videoname = videoname;
		this.content = content;
		this.timepause = timepause;
		this.image = image;
		this.link = link;
	}

	public Video() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVideoname() {
		return videoname;
	}

	public void setVideoname(String videoname) {
		this.videoname = videoname;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Time getTimepause() {
		return timepause;
	}

	public void setTimepause(Time timepause) {
		this.timepause = timepause;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}

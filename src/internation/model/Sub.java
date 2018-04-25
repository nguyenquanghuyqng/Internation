package internation.model;


import java.sql.Time;

import javafx.collections.ObservableList;

public class Sub {

	private int id;
	private String content;
	private String content_internation;
	private String time;
	private int video_id;

	public Sub(String time,String content) {
		super();
		this.content = content;
		this.time = time;
	}

	public Sub() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent_internation() {
		return content_internation;
	}

	public void setContent_internation(String content_internation) {
		this.content_internation = content_internation;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getVideo_id() {
		return video_id;
	}

	public void setVideo_id(int video_id) {
		this.video_id = video_id;
	}

}

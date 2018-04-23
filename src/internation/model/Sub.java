package internation.model;


import java.sql.Time;

public class Sub {

	private int id;
	private String content;
	private String content_internation;
	private String time;
	private int video_id;

	public Sub(int id, String content, String content_internation, String time, int video_id) {
		super();
		this.id = id;
		this.content = content;
		this.content_internation = content_internation;
		this.time = time;
		this.video_id = video_id;
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

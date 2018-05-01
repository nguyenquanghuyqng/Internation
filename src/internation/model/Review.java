package internation.model;

public class Review {
	private int id;
	private String content;
	private int video_id;
	private int sub_id;
	
	public Review(String content, int video_id, int sub_id) {
		super();
		this.content = content;
		this.video_id = video_id;
		this.sub_id = sub_id;
	}
	public Review() {

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
	public int getVideo_id() {
		return video_id;
	}
	public void setVideo_id(int video_id) {
		this.video_id = video_id;
	}
	public int getSub_id() {
		return sub_id;
	}
	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}
	
	
	
	
	
	
	
}

package internation.model;

public class ItemVideo {

	private String image;
	private String content;
	private String descontent;
	
	public ItemVideo(){
		
	}
	
	public ItemVideo(String image, String content, String descontent) {
		super();
		this.image = image;
		this.content = content;
		this.descontent = descontent;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDescontent() {
		return descontent;
	}
	public void setDescontent(String descontent) {
		this.descontent = descontent;
	}
}

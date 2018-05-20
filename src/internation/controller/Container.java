package internation.controller;

public class Container {

	public int x;
	public int y;
	
	private static Container instance =null;
	private void Container() {
		
	}
	public static Container getInstance() {
		if(instance == null) {
			instance = new Container();
		}
		return instance;
	}
	
}

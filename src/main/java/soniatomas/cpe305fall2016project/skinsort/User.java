package main.java.soniatomas.cpe305fall2016project.skinsort;

public class User {
	
	private UserInformation userInfo;
	private ProductHistory neutralProductHistory;
	private ProductHistory positiveProductHistory;
	private ProductHistory negativeProductHistory;

	public User(){
		neutralProductHistory = new ProductHistory();
		positiveProductHistory = new ProductHistory();
		negativeProductHistory = new ProductHistory();
	}
}

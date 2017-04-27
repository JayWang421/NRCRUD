package wzj.util;

import java.util.ResourceBundle;

public class MessageUtils {
	private ResourceBundle rs ;
	public MessageUtils(String baseName) {
		// TODO Auto-generated constructor stub
		this.rs=ResourceBundle.getBundle(baseName) ;
	}
	public String getValues(String key){
		return this.rs.getString(key) ;
	}
}

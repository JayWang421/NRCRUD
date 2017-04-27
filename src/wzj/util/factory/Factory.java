package wzj.util.factory;

import wzj.util.MessageUtils;
import wzj.util.service.proxy.ProxyService;
@SuppressWarnings("unchecked")
public class Factory {
	private static final MessageUtils daoMU=new MessageUtils("wzj.util.message.dao") ;
	private static final MessageUtils serviceMU=new MessageUtils("wzj.util.message.service") ;
	public static <T> T getDAOInstance(String className){
		try {
			return (T) Class.forName(daoMU.getValues(className)).newInstance() ;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null ;
	}
	public static <T> T getServiceInstance(String className){
		try {
			return (T) new ProxyService().bind(Class.forName(serviceMU.getValues(className)).newInstance()) ;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null ;
	}
}

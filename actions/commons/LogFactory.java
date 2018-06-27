package commons;

import java.util.logging.Logger;

public class LogFactory {
	private static Logger log = Logger.getLogger(LogFactory.class.getName());
	
	public static void info(String message) {
		log.info(message);
		System.out.println("Message = "+message);
	}
	
	public static void error(String message) {
		log.info(message);
		System.out.println("Error = "+message);
		
	}

}

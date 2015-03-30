package volk.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class LoadProperties {

	private static int CHANGE_STATE;
	private static int HISTORY_COUNT;
	private static String FILE_DUMP;
	private static String FILE_LOG;
	private static String URL;
	private static String USER;
	private static String PASSWORD;
	private static int SOCKET_PORT;
	
	public LoadProperties(String file)  {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File(file)));
			CHANGE_STATE = Integer.valueOf(prop.getProperty("CHANGE_STATE"));
			HISTORY_COUNT = Integer.valueOf(prop.getProperty("HISTORY_COUNT"));
			FILE_DUMP=prop.getProperty("FILE_DUMP");
			FILE_LOG=prop.getProperty("FILE_LOG");
			URL=prop.getProperty("URL");
			USER=prop.getProperty("USER");;
			PASSWORD=prop.getProperty("PASSWORD");;
			SOCKET_PORT=Integer.valueOf(prop.getProperty("SOCKET_PORT"));
			
		} catch (Exception e) {
			
		}
		
	}

	public static int getSOCKET_PORT() {
		return SOCKET_PORT;
	}

	public static String getURL() {
		return URL;
	}

	public static String getUSER() {
		return USER;
	}

	public static String getPASSWORD() {
		return PASSWORD;
	}

	public static int getHISTORY_COUNT() {
		return HISTORY_COUNT;
	}

	public static int getCHANGE_STATE() {
		return CHANGE_STATE;
	}

	public static String getFILE_DUMP() {
		return FILE_DUMP;
	}

	public static String getFILE_LOG() {
		return FILE_LOG;
	}
	

}

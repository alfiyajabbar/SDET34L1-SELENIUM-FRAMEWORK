package com.sdet32l1.genericcentre;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains only property file specific common methods
 * @author Mypc
 *
 */
public class FileCentre {
	static Properties pobj;
	/**
	 * This method is used to open the property file
	 * @throws IOException
	 */
public static void openPropertyFile(String filepath) throws IOException {
FileInputStream fis=new FileInputStream(filepath);
pobj=new Properties();
pobj.load(fis);
}

	/**
	 * this method is used to fetch the data from the property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
public static String getDataFromPropertyFile(String key)
{
	String value=pobj.getProperty(key);
	return value;
}
}

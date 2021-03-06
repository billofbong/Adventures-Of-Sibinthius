/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.awesomecraft;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Will
 */
public class SaveLoad {
    /**
     * Saves a specified object to a location
     * @param obj Object to save
     * @param path Patha to save to
     * @throws Exception 
     */
    public static void save(Object obj,String path) throws Exception
	{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
		oos.writeObject(obj);
		oos.flush();
		oos.close();
	}
    /**
     * Loads a specified object from a location
     * @param Path to load from
     * @return Loaded object
     * @throws Exception 
     */
	public static Object load(String path) throws Exception
	{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
		Object result = ois.readObject();
		ois.close();
		return result;
	}
    
}

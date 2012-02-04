
package org.awesomecraft;
import java.io.*;

/**
 *
 * @author Will Wright
 */
public class SaveLoad {
    
    public static Object LoadSave(File f) {
        Object ret = null;
        try {
        ObjectInputStream obj = new ObjectInputStream(new FileInputStream(f));
         ret = obj.readObject();
        }
        catch(ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        catch(FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        return ret;
    }
    
    public static void Save(File f) {
        try{
 
       FileOutputStream FileOut = new FileOutputStream(f);
 
       ObjectOutputStream ObjOut = new ObjectOutputStream(FileOut);
       
       ObjOut.writeObject(f);
  
       ObjOut.close();
        
        }
  
       catch(IOException e){

    }

    }
    
}

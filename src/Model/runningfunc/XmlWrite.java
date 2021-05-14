package Model.runningfunc;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class XmlWrite {

    public void serializeToXML(Properties col){
        //write a object in java into an xml, write the min,max and name of the column
        try {
            FileOutputStream xml = new FileOutputStream("src/Properties.xml");
            XMLEncoder encoder = new XMLEncoder(xml);
            encoder.writeObject(col);
            encoder.close();
            xml.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public Properties deserializeFromXML(){
        Properties col = new Properties();
        //write an xml into an java object, write the port'ip and index of the name of the column
        try {
            FileInputStream obj = new FileInputStream("Properties.xml");
            XMLDecoder dec = new XMLDecoder(obj);
            col = (Properties) dec.readObject();
            dec.close();
            obj.close();
            return col;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return col;
    }





}

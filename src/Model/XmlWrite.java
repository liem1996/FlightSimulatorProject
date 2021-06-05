package Model;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class XmlWrite {

    public void serializeToXML(property col){
        //write a object in java into an xml, write the min,max and name of the column
        try {
            FileOutputStream xml = new FileOutputStream("Properties.xml");
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

    public property deserializeFromXML(String filename){
        property col = new property();
        //write an xml into an java object, write the port'ip and index of the name of the column
        try {
            FileInputStream obj = new FileInputStream(filename);
            XMLDecoder dec = new XMLDecoder(obj);
            col = (property) dec.readObject();
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
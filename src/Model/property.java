package Model;

import java.util.HashMap;
import java.util.Map;

public class property {

        public HashMap<Integer, String> nameColIndex;
        public int port;
        public String ip;
        public double timeperSeconed;
        public HashMap<String,Integer> minimum;
        public HashMap<String,Integer> maximum;

    public property() {
        this.nameColIndex = new HashMap<>();
        this.port =50;
        this.ip = "10.0.0.128";
        this.timeperSeconed=1;
        this.minimum=new HashMap<>();
        this.maximum=new HashMap<>();
    }


    public Map<Integer, String> getNameColIndex() {
        return nameColIndex;
    }

    public void setNameColIndex(HashMap<Integer, String> nameColIndex) {
        this.nameColIndex = nameColIndex;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public double getTimeperSeconed() {
        return timeperSeconed;
    }

    public void setTimeperSeconed(double timeperSeconed) {
        this.timeperSeconed = timeperSeconed;
    }

    public HashMap<String, Integer> getMinimum() {
        return minimum;
    }

    public void setMinimum(HashMap<String, Integer> minimum) {
        this.minimum = minimum;
    }

    public HashMap<String, Integer> getMaximum() {
        return maximum;
    }

    public void setMaximum(HashMap<String, Integer> maximum) {
        this.maximum = maximum;
    }
}

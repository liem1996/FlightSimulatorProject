package Model;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.io.PrintWriter;
import java.net.Socket;

public class Model implements Observable {

    PrintWriter out2fg;
    Socket fg;

    public Model (String propertiesFileName)
    {

    }

    @Override
    public void addListener(InvalidationListener invalidationListener) {

    }

    @Override
    public void removeListener(InvalidationListener invalidationListener) {

    }
}

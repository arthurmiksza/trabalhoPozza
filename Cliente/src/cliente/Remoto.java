package cliente;

import java.rmi.Remote;
import classes.Boi;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Remoto extends Remote {
    public ArrayList<Boi> getBois() throws RemoteException;   
}

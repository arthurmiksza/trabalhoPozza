package servidor;

import java.rmi.Remote;
import classes.Boi;
import java.rmi.RemoteException;

public interface Remoto extends Remote {
    public Boi[] getBoi() throws RemoteException;   
}

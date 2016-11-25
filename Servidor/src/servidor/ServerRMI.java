package servidor;
import classes.*;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class ServerRMI implements Remoto {
    public ArrayList<Boi> bois = BoiAux.bois;
    @Override
    public ArrayList<Boi> getBois() throws RemoteException {
        return this.bois;
    }
    
}

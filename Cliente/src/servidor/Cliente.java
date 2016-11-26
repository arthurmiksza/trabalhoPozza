package servidor;

import view.index;
import classes.Boi;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Cliente {
    public static void main(String[] args) throws RemoteException {
        new index().setVisible(true);
    }
}

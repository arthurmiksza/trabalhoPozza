package servidor;

import classes.Boi;
import java.rmi.RemoteException;
import java.util.ArrayList;
import view.principal;

public class Cliente {
    public static void main(String[] args) throws RemoteException {
        ServerRMI sv = new ServerRMI();
        try {
            for(Boi b: sv.getServer().getBois())
                System.out.println(b.toString());
        } catch (NullPointerException er) {
            System.out.println(er);
        }
    }
    
}

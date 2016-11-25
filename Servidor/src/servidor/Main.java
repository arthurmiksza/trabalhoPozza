package servidor;

import java.io.File;
import infos.InfoArquivos;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Server s = new Server();
        new Thread(s).start();
    }
    
}

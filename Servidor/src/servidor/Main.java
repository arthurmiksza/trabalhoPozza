package servidor;

import java.io.File;
import infos.InfoArquivos;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        new Thread(new Server()).start();
    }
    
}

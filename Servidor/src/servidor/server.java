package servidor;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server implements Runnable {
    DataInputStream input;
    public ServerSocket svSocket;
    public int porta = 9000;
    
    @Override
    public void run() {
        try {
            svSocket = new ServerSocket(porta);
            while(true) {
                Socket cli = svSocket.accept();
                input = new DataInputStream(cli.getInputStream());
                String opcoes = input.readUTF();
                switch(Integer.parseInt(opcoes)) {
                    //Fazer retornar se esta fora ou não
                    case 1:
                        break;
                    //Fazer retornar a posição
                    case 2:
                        break;    
                }
            }
        } catch (IOException er) {
            System.out.println("Erro: " + er);
        }
    }
}

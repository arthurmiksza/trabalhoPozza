package infos;
import classes.Boi;
import java.util.ArrayList;

import java.io.File;
public class InfoArquivos {
    public final String pathArquivos = new File(System.getProperty("user.dir")).getParent() + "/SinalgoWsn/src/data";
    
    public InfoArquivos() {
        
    }
    
    public String caminhoArquivos() {
        return this.pathArquivos;
    }
    
    public int qtd() {
        return new File(this.pathArquivos).listFiles().length;
    }
    
    public File[] listaArquivos() {
        return new File(this.pathArquivos).listFiles();
    }
}

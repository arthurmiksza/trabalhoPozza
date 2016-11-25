package infos;
import java.io.File;
public class InfoArquivos {
    public final String pathArquivos = new File(System.getProperty("user.dir")).getParent() + "/SinalgoWsn/src/data";
    
    public InfoArquivos() {
        
    }
    
    public String caminhoArquivos() {
        return this.pathArquivos;
    }
    
    public int qtd() {
        return new File(this.caminhoArquivos()).listFiles().length;
    }
    
    public File[] listaArquivos() {
        return new File(this.caminhoArquivos()).listFiles();
    }
    
    public boolean checkRequeriments() {
        return this.qtd() > 0 && (new File(this.caminhoArquivos()).exists());
    }
    
    public String[] trataResposta(String t) {
        String[] sep = t.split(";");
        String ID = sep[0].split("&")[1];
        String OUT = sep[1].split("&")[1];
        String[] POS = sep[2].split("&");
        String POSX = POS[1].split("separa")[0].split("-")[1];
        String POSY = POS[1].split("separa")[1].split("-")[1];
        String[] temp = {ID, OUT, POSX, POSY};
        return temp;
    }
}

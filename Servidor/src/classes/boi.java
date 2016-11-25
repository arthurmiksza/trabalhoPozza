package classes;

public class boi {
    public int ID;
    public boolean fora;
    public posicao pos;
    
    public boi(int i, boolean f, posicao p) {
        this.ID = i;
        this.fora = f;
        this.pos = p;
    }

    public int getID() {
        return ID;
    }

    public boolean isFora() {
        return fora;
    }

    public posicao getPos() {
        return pos;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFora(boolean fora) {
        this.fora = fora;
    }

    public void setPos(posicao pos) {
        this.pos = pos;
    }
    
    
}

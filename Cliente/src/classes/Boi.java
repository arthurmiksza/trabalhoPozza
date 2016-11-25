package classes;

import java.util.ArrayList;

public class Boi {
    public int ID;
    public boolean fora;
    public Posicao pos;
    
    public Boi() {
    }
    
    public Boi(int i, boolean f, Posicao p) {
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

    public Posicao getPos() {
        return pos;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFora(boolean fora) {
        this.fora = fora;
    }

    public void setPos(Posicao pos) {
        this.pos = pos;
    }
    
    public Boi acharPeloId(ArrayList<Boi> b, int id) {
        for(Boi boi : b) {
            if (boi.getID() == id)
                return boi;
        }
        return null;
    }    
    
    public boolean JaTemEsseBoi(ArrayList<Boi>bois, Boi esse) {
        return bois.stream().anyMatch((b) -> (b.getID() == esse.getID()));
    }
    
    @Override
    public String toString() {
        return "ID: " + this.ID + "; FORA? " + (this.isFora()? "TRUE" : "FALSE") + " POS: " + this.getPos().toString();
    }
}

package classes;


public class Posicao {
    public float X;
    public float Y;
    
    public Posicao(float x, float y) {
        this.X = x;
        this.Y = y;
    }

    public float getX() {
        return X;
    }

    public float getY() {
        return Y;
    }

    public void setX(float X) {
        this.X = X;
    }

    public void setY(float Y) {
        this.Y = Y;
    }
    
    public String toString() {
        return "X: " + this.getX() + "; Y: " + this.getY();
    }
    
}

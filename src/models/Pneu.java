package models;

public class Pneu {
    private TypePneu type;
    private double pression;
    
    public Pneu(TypePneu type, double pression) {
        this.type = type;
        this.pression = pression;
    }

    public TypePneu getType() {
        return type;
    }

    public double getPression() {
        return pression;
    }

    @Override
    public String toString() {
        return "Pneu [type=" + type + ", pression=" + pression + "]";
    }
}

package model;

public class PrivateKeyModel {
    private int n;
    private int d;

    public PrivateKeyModel(int n, int d) {
        this.n = n;
        this.d = d;
    }

    @Override
    public String toString() {
        return "PrivateKeyModel{" +
                "n=" + n +
                ", d=" + d +
                '}';
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }
}

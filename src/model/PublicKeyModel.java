package model;

public class PublicKeyModel {
    private int n;
    private int e;

    public PublicKeyModel(int n, int e) {
        this.n = n;
        this.e = e;
    }

    @Override
    public String toString() {
        return "PublicKeyModel{" +
                "n=" + n +
                ", e=" + e +
                '}';
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getE() {
        return e;
    }

    public void setE(int e) {
        this.e = e;
    }
}

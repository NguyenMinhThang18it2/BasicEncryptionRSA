package model;

public class KeyModel {
    private PublicKeyModel publicKeyModel;
    private PrivateKeyModel privateKeyModel;

    public KeyModel(PublicKeyModel publicKeyModel, PrivateKeyModel privateKeyModel) {
        this.publicKeyModel = publicKeyModel;
        this.privateKeyModel = privateKeyModel;
    }

    @Override
    public String toString() {
        return "keyModel{" +
                "publicKeyModel=" + publicKeyModel +
                ", privateKeyModel=" + privateKeyModel +
                '}';
    }

    public PublicKeyModel getPublicKeyModel() {
        return publicKeyModel;
    }

    public void setPublicKeyModel(PublicKeyModel publicKeyModel) {
        this.publicKeyModel = publicKeyModel;
    }

    public PrivateKeyModel getPrivateKeyModel() {
        return privateKeyModel;
    }

    public void setPrivateKeyModel(PrivateKeyModel privateKeyModel) {
        this.privateKeyModel = privateKeyModel;
    }
}

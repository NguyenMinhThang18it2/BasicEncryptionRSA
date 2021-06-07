import model.KeyModel;

public class main {
    public static void main(String[] args) {
        SimpleRSA simpleRSA = new SimpleRSA();
        KeyModel keyModel = simpleRSA.createkey();
        String mess = " má ơi, b, c, d, f, g, h, j, k, l, m, n, p, q, r, s, t, v, w, x, y, z 1231231231";
        // mã hóa
        String enCode =  simpleRSA.enCode(mess, keyModel.getPublicKeyModel());
        // giải mã
        String deCode = simpleRSA.deCode(enCode, keyModel.getPrivateKeyModel());
        System.out.println("mã hóa: "+ enCode);
        System.out.println("giải mã: "+deCode);
    }
}

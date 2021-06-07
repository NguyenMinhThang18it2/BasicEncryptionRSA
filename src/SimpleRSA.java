import model.KeyModel;
import model.PrivateKeyModel;
import model.PublicKeyModel;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class SimpleRSA {
    private  int n , e, d;

    public  SimpleRSA() {

    }
    public KeyModel createkey(){
        generateKey();
        KeyModel keyModel = new KeyModel(new PublicKeyModel(n, e), new PrivateKeyModel(n, d));

        return keyModel;
    }
    public String enCode(String mess, PublicKeyModel publicKeyModel){
        String enCode = "";
        ArrayList<Integer> numberCode = letterToNumber(mess);
        // mã hóa
        for (int i = 0; i < numberCode.size(); i++) {
            int m = numberCode.get(i);
            int a = encodeWithPublicKey(m, publicKeyModel.getN(), publicKeyModel.getE());
            if(i == numberCode.size()-1) enCode += a;
            else enCode += a + "-";
        }
        return enCode;
    }

    public String deCode(String mess, PrivateKeyModel privateKeyModel){
        String[] yourMess = mess.split("-");
        ArrayList<Integer> numberCode = new ArrayList<>();
        for (String s : yourMess) {
            int c = Integer.parseInt(s);
            int a = decodeWithPrivateKey(c, privateKeyModel.getN(), privateKeyModel.getD());
            numberCode.add(a);
        }
        String deCodeMess = numberToString(numberCode);
        return deCodeMess;
    }
    private ArrayList<Integer> letterToNumber(String mess){
        ArrayList<Integer> integers = new ArrayList<>();
        char[] letters = mess.toCharArray();
        for (char ch : letters) {
            integers.add((int) ch);
        }
        return integers;
    }
    private String numberToString(ArrayList<Integer> numberCodes){
        String stringDeCode = "";
        for (int i = 0; i < numberCodes.size(); i++) {
            int a = numberCodes.get(i);
            stringDeCode += (char) a;
        }

        byte[] bytes = stringDeCode.getBytes(StandardCharsets.UTF_8);

        String utf8EncodedString = new String(bytes, StandardCharsets.UTF_8);
        return utf8EncodedString;
    }

    private void generateKey(){
        int p = 61;
        int q = 53;

        n = p * q;
        // const phi = (p - 1) * (q - 1);
        int phi = BCNN(p - 1, q - 1);
        e = 2;
        while (e < phi) {
            if (UCLN(e, phi) == 1) break;
            else e++;
        }
        d = 1;
        while ((d * e - 1) % (2 * phi) != 0) {
            d++;
        }
    }

    private int UCLN(int a, int b){
        while (a != b) {
            if (a > b) a = a - b;
            else b = b - a;
        }
        return a;
    }
    private int BCNN(int a, int b){
        return (a * b) / UCLN(a, b);
    }
    private int encodeWithPublicKey(int m, int n, int e){
        return convert(m, e, n);
    }
    private int decodeWithPrivateKey(int c, int n, int d){
        return convert(c, d, n);
    }
    private int convert(int number1, int number2, int n){
        int result = number1;
        for (int i=1; i < number2; i++)
            result = (result * number1) % n;

        return result;
        //        return BigInteger.valueOf(number1).pow(number2).mod(BigInteger.valueOf(n));
    }
}

import model.KeyModel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class main {
    public static void main(String[] args) {

        SimpleRSA simpleRSA = new SimpleRSA();
        KeyModel keyModel = simpleRSA.createkey();
//        String mess = "ớ ở ợ ờ ỡ ố ồ ộ ổ ỗ ứ ừ ự ử ữ ấ ầ ậ ẩ ẫ ắ ằ ặ ẳ ẵ";
//        // mã hóa
//        String enCode =  simpleRSA.enCode(mess, keyModel.getPublicKeyModel());
//        // giải mã
//        String deCode = simpleRSA.deCode(enCode, keyModel.getPrivateKeyModel());
//        System.out.println("mã hóa: "+ enCode);
//        System.out.println("giải mã: "+deCode);
        //send image
        try {
            EncryptionImage encryptionImage = new EncryptionImage();
            // file to base64
            String enCodeImage = encryptionImage.enCodeImage("C:\\Users\\ADMIN\\Desktop\\a\\a.png");
            //mã hóa
            String enCode =  simpleRSA.enCode(enCodeImage, keyModel.getPublicKeyModel());
            // giải mã
            String deCode = simpleRSA.deCode(enCode, keyModel.getPrivateKeyModel());
//            System.out.println("mã hóa: "+ enCode);
//            System.out.println("giải mã: "+deCode);
            // đổi base64 thành byte image
            byte[] data = encryptionImage.deCodeImage(deCode);
            // xuất file
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\ADMIN\\Desktop\\a\\b.jpg");
            fileOutputStream.write(data);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

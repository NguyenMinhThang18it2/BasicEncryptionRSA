import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

public class EncryptionImage {
    public EncryptionImage() {
    }
    public String enCodeImage(String path) throws IOException {
        FileInputStream stream = new FileInputStream(path);
        byte[] data = stream.readAllBytes();
        String imageBase64 = Base64.getEncoder().encodeToString(data);

        stream.close();
        return imageBase64;
    }

    public byte[] deCodeImage(String imageBase64){
        byte[] data = Base64.getDecoder().decode(imageBase64);

        return data;
    }
}

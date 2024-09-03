import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class sha {

    public static String generateMD5(String input) {
        try {
            
            MessageDigest md = MessageDigest.getInstance("MD5");

            // convert the input string bytes to digest
            md.update(input.getBytes());

            // Get the MD5 hash value as byte array
            byte[] digest = md.digest();

            // Convert byte array to hexadecimal string
            StringBuilder result = new StringBuilder();
            for (byte b : digest) {
                result.append(String.format("%02x", b & 0xff));
            }
            return result.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the Message");
        String input =s.nextLine();
        String md5Hash = generateMD5(input);
        System.out.println("MD5 Hash: " + md5Hash);
    }
}

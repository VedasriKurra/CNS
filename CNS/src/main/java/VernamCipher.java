import java.util.Scanner;

public class VernamCipher {

// Function to perform Vernam cipher encryption

public static String encrypt(String plaintext, String key) {

StringBuilder ciphertext = new StringBuilder();

for (int i = 0; i < plaintext.length(); i++) {

// XOR operation between plaintext and key characters

char encryptedChar = (char) (plaintext.charAt(i) ^ key.charAt(i % key.length()));

ciphertext.append(encryptedChar);

}

return ciphertext.toString();

}

// Function to perform Vernam cipher decryption

public static String decrypt(String ciphertext, String key) {

StringBuilder plaintext = new StringBuilder();

for (int i = 0; i < ciphertext.length(); i++) {

// XOR operation between ciphertext and key characters

char decryptedChar = (char) (ciphertext.charAt(i) ^ key.charAt(i % key.length()));

plaintext.append(decryptedChar);

}

return plaintext.toString();

}

public static void main(String[] args) {

Scanner scanner = new Scanner(System.in);

// Input plaintext

System.out.print("Enter plaintext: ");

String plaintext = scanner.nextLine().toUpperCase();

// Input key

System.out.print("Enter key: ");

String key = scanner.nextLine().toUpperCase();

// Encrypt plaintext using Vernam cipher

String encryptedText = encrypt(plaintext, key);

System.out.println("Encrypted Text: " + encryptedText);

// Decrypt ciphertext using Vernam cipher

String decryptedText = decrypt(encryptedText, key);

System.out.println("Decrypted Text: " + decryptedText);

scanner.close();

}

}
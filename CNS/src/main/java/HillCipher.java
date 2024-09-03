import java.util.Scanner;

public class HillCipher {

// Function to perform Hill cipher encryption

public static String encrypt(String plaintext, int[][] key) {

StringBuilder ciphertext = new StringBuilder();

// Padding plaintext with 'X' if its length is not divisible by 3

while (plaintext.length() % 3 != 0) {

plaintext += 'X';

}

// Convert plaintext to uppercase

plaintext = plaintext.toUpperCase();

// Iterate over plaintext by blocks of 3 characters

for (int i = 0; i < plaintext.length(); i += 3) {

int[] block = new int[3];

// Fill the block with ASCII values of characters

for (int j = 0; j < 3; j++) {

block[j] = plaintext.charAt(i + j) - 'A';

}

// Multiply the key matrix with the block

int[] result = multiplyMatrix(key, block);

// Convert the result to ciphertext characters

for (int j = 0; j < 3; j++) {

ciphertext.append((char) (result[j] % 26 + 'A'));

}

}

return ciphertext.toString();

}

// Function to multiply a 3x3 matrix with a 3-element vector

private static int[] multiplyMatrix(int[][] matrix, int[] vector) {

int[] result = new int[3];

for (int i = 0; i < 3; i++) {

result[i] = 0;

for (int j = 0; j < 3; j++) {

result[i] += matrix[i][j] * vector[j];

}

}

return result;

}

public static void main(String[] args) {

Scanner scanner = new Scanner(System.in);

// Input plaintext

System.out.print("Enter plaintext: ");

String plaintext = scanner.nextLine();

// Input key matrix

int[][] key = new int[3][3];

System.out.println("Enter key matrix (3x3):");

for (int i = 0; i < 3; i++) {

for (int j = 0; j < 3; j++) {

key[i][j] = scanner.nextInt();

}

}

// Encrypt plaintext using Hill cipher

String encryptedText = encrypt(plaintext, key);

System.out.println("Encrypted Text: " + encryptedText);

scanner.close();

}

}
import java.math.BigInteger;

import java.security.SecureRandom;

import java.util.*;

public class RSAAlgorithm{

private BigInteger privateKey;

private BigInteger publicKey;

private BigInteger n;

// Constructor to generate public and private keys

public RSAAlgorithm(int bitLength) {

SecureRandom random = new SecureRandom();

BigInteger p = BigInteger.probablePrime(bitLength / 2, random);

System.out.println("First Prime Number p="+p);

BigInteger q = BigInteger.probablePrime(bitLength / 2, random);

System.out.println("Second Prime Number q="+q);

n = p.multiply(q);

BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));

publicKey = generatePublicKey(phi, random);

privateKey = publicKey.modInverse(phi);

}

// Function to generate a public key randomly such that gcd(e, phi) = 1

private BigInteger generatePublicKey(BigInteger phi, SecureRandom random) {

BigInteger e;

do {

e = new BigInteger(phi.bitLength(), random);

} while (e.compareTo(BigInteger.ONE) <= 0 || e.compareTo(phi) >= 0 || !e.gcd(phi).equals(BigInteger.ONE));

return e;

}

// Encrypts the given message

public BigInteger[] encrypt(String message) {

byte[] bytes = message.getBytes();

BigInteger[] encrypted = new BigInteger[bytes.length];

for (int i = 0; i < bytes.length; i++) {

encrypted[i] = BigInteger.valueOf(bytes[i]).modPow(publicKey, n);

}

return encrypted;

}

// Decrypts the given ciphertext

public String decrypt(BigInteger[] ciphertext) {

byte[] decryptedBytes = new byte[ciphertext.length];

for (int i = 0; i < ciphertext.length; i++) {

decryptedBytes[i] = ciphertext[i].modPow(privateKey, n).byteValue();

}

return new String(decryptedBytes);

}

public static void main(String[] args) {

int bitLength = 1024; // Change this to desired bit length

RSAAlgorithm rsa = new RSAAlgorithm(bitLength);

Scanner s=new Scanner(System.in);

String message =s.nextLine();

BigInteger[] encryptedMessage = rsa.encrypt(message);

System.out.println("Encrypted Message: " + encryptedMessage);

String decryptedMessage = rsa.decrypt(encryptedMessage);

System.out.println("Decrypted Message: " + decryptedMessage);

}

}
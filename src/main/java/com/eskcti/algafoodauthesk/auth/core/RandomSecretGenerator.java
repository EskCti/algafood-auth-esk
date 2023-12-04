package com.eskcti.algafoodauthesk.auth.core;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class RandomSecretGenerator {
    public static void main(String[] args) {
        int keyLength = 256;

        byte[] secret = generateRandomSecret(keyLength);

        String encodedSecret = Base64.getEncoder().encodeToString(secret);

        System.out.println("Encoded Secret (256 bits): " + encodedSecret);
    }

    private static byte[] generateRandomSecret(int keyLength) {
        try {
            SecureRandom secureRandom = new SecureRandom();
            byte[] salt = new byte[keyLength / 8];
            secureRandom.nextBytes(salt);

            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            PBEKeySpec keySpec = new PBEKeySpec("algaworks".toCharArray(), salt, 65536, keyLength);
            SecretKey secretKey = secretKeyFactory.generateSecret(keySpec);

            return secretKey.getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException("Algoritmo de criptografia não suportado", e);
        }
    }
}

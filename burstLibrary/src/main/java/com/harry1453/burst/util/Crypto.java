package com.harry1453.burst.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Crypto {

    public static byte[] getPublicKey(String secretPhrase) {
        byte[] publicKey = new byte[32];
        Curve25519.keygen(publicKey, null, Crypto.sha256().digest(Convert.toBytes(secretPhrase)));
        return publicKey;
    }

    public static byte[] getPrivateKey(String secretPhrase) {
        byte[] s = sha256().digest(Convert.toBytes(secretPhrase));
        Curve25519.clamp(s);
        return s;
    }

    public static long getAccountId(byte[] publicKey) {
        byte[] publicKeyHash = sha256().digest(publicKey);
        return Convert.fullHashToId(publicKeyHash);
    }

    private static MessageDigest getMessageDigest(String algorithm) {
        try {
            return MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private static MessageDigest sha256() {
        return getMessageDigest("SHA-256");
    }
}

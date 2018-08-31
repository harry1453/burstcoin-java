package com.harry1453.burst.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Arrays;

public class Convert {

    private static final char[] hexChars = { '0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f' };
    private static final BigInteger two64 = new BigInteger("18446744073709551616");

    static byte[] toBytes(String s) {
        try {
            return s.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.toString(), e);
        }
    }

    public static String toHexString(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        char[] chars = new char[bytes.length * 2];
        for (int i = 0; i < bytes.length; i++) {
            chars[i * 2] = hexChars[((bytes[i] >> 4) & 0xF)];
            chars[i * 2 + 1] = hexChars[(bytes[i] & 0xF)];
        }
        return String.valueOf(chars);
    }

    public static byte[] hexStringToByteArray(String string) {
        int len = string.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(string.charAt(i), 16) << 4)
                    + Character.digit(string.charAt(i+1), 16));
        }
        return data;
    }

    public static String toUnsignedLong(long objectId) {
        if (objectId >= 0) {
            return String.valueOf(objectId);
        }
        BigInteger id = BigInteger.valueOf(objectId).add(two64);
        return id.toString();
    }

    public static long fullHashToId(byte[] hash) {
        if (hash == null || hash.length < 8) {
            throw new IllegalArgumentException("Invalid hash: " + Arrays.toString(hash));
        }
        BigInteger bigInteger = new BigInteger(1, new byte[] {hash[7], hash[6], hash[5], hash[4], hash[3], hash[2], hash[1], hash[0]});
        return bigInteger.longValue();
    }
}
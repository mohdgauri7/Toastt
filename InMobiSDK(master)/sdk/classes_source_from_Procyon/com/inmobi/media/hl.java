// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.content.Context;
import java.security.spec.KeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.math.BigInteger;
import java.nio.ByteOrder;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;
import android.annotation.SuppressLint;
import java.security.spec.AlgorithmParameterSpec;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import android.util.Base64;

public class hl
{
    private static final String a;
    private static String b;
    private static String c;
    private static byte[] d;
    
    public static String a(final String s, byte[] array, byte[] a, byte[] a2, final String s2, final String s3) {
        try {
            final byte[] b2;
            final byte[] b = b(b2 = b(s.getBytes("UTF-8"), array, a), a2);
            final byte[] a3 = a(b2);
            final byte[] a4 = a(b);
            a = a(a);
            array = a(array);
            a2 = a(a2);
            array = a(a(a(a(array, a2), a), s3, s2));
            return new String(Base64.encode(a(array, a(a3, a4)), 8));
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    @SuppressLint({ "TrulyRandom" })
    private static byte[] b(final byte[] input, final byte[] key, final byte[] iv) {
        byte[] doFinal = null;
        final SecretKeySpec key2 = new SecretKeySpec(key, hl.b);
        final IvParameterSpec params = new IvParameterSpec(iv);
        try {
            final Cipher instance;
            (instance = Cipher.getInstance(hl.c)).init(1, key2, params);
            instance.init(1, key2, params);
            instance.init(1, key2, params);
            doFinal = instance.doFinal(input);
        }
        catch (Throwable t) {}
        return doFinal;
    }
    
    private static byte[] b() {
        try {
            final KeyGenerator instance;
            (instance = KeyGenerator.getInstance("AES")).init(128, new SecureRandom());
            final SecretKey generateKey;
            if ((generateKey = instance.generateKey()) != null) {
                return generateKey.getEncoded();
            }
        }
        catch (Exception ex) {}
        return null;
    }
    
    private static byte[] b(final byte[] input, final byte[] key) {
        byte[] doFinal = null;
        final SecretKeySpec key2 = new SecretKeySpec(key, 0, key.length, "HmacSHA1");
        try {
            final Mac instance;
            (instance = Mac.getInstance("HmacSHA1")).init(key2);
            doFinal = instance.doFinal(input);
        }
        catch (NoSuchAlgorithmException ex) {}
        catch (InvalidKeyException ex2) {}
        return doFinal;
    }
    
    public static byte[] a(final byte[] array) {
        final long n = array.length;
        final ByteBuffer allocate;
        (allocate = ByteBuffer.allocate(8)).order(ByteOrder.LITTLE_ENDIAN);
        allocate.putLong(n);
        final byte[] array3;
        final byte[] array2 = new byte[(array3 = allocate.array()).length + array.length];
        System.arraycopy(array3, 0, array2, 0, array3.length);
        System.arraycopy(array, 0, array2, array3.length, array.length);
        return array2;
    }
    
    public static byte[] a(final byte[] input, final String val, final String val2) {
        byte[] doFinal = null;
        final BigInteger modulus = new BigInteger(val2, 16);
        final BigInteger publicExponent = new BigInteger(val, 16);
        try {
            final Cipher instance;
            (instance = Cipher.getInstance("RSA/ECB/nopadding")).init(1, KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(modulus, publicExponent)));
            doFinal = instance.doFinal(input);
        }
        catch (Throwable t) {}
        return doFinal;
    }
    
    public static byte[] a(final byte[] array, final byte[] array2) {
        final byte[] array3 = new byte[array.length + array2.length];
        System.arraycopy(array, 0, array3, 0, array.length);
        System.arraycopy(array2, 0, array3, array.length, array2.length);
        return array3;
    }
    
    public static synchronized byte[] a() {
        final Context c;
        if ((c = gz.c()) == null) {
            return hl.d;
        }
        final hi hi = new hi(c, "aes_key_store");
        final long n = System.currentTimeMillis() / 1000L - hi.a();
        try {
            if (n > 86400L) {
                hi.b("aes_public_key", Base64.encodeToString(hl.d = b(), 0));
            }
            else if (hl.d == null) {
                final String b = hi.b("aes_public_key");
                try {
                    hl.d = Base64.decode(b, 0);
                }
                catch (IllegalArgumentException ex) {
                    hi.b("aes_public_key", Base64.encodeToString(hl.d = b(), 0));
                }
            }
        }
        catch (Exception ex2) {}
        return hl.d;
    }
    
    public static byte[] a(final byte[] input, final byte[] key, final byte[] iv) {
        byte[] doFinal = null;
        final SecretKeySpec key2 = new SecretKeySpec(key, hl.b);
        try {
            final Cipher instance;
            (instance = Cipher.getInstance(hl.c)).init(2, key2, new IvParameterSpec(iv));
            doFinal = instance.doFinal(input);
        }
        catch (Throwable t) {}
        return doFinal;
    }
    
    public static byte[] a(int n) {
        bytes = (int)(Object)new byte[n];
        try {
            new SecureRandom().nextBytes((byte[])(Object)bytes);
        }
        catch (Exception ex) {}
        return (byte[])(Object)bytes;
    }
    
    static {
        a = hl.class.getSimpleName();
        hl.b = "AES";
        hl.c = "AES/CBC/PKCS7Padding";
    }
}

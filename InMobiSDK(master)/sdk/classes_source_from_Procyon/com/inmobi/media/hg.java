// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.net.HttpURLConnection;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.io.ByteArrayInputStream;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;
import java.util.HashMap;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import android.os.Build;
import android.os.PowerManager;
import android.annotation.SuppressLint;
import android.net.NetworkInfo;
import android.content.Context;
import android.net.ConnectivityManager;

public class hg
{
    private static final String a;
    
    @SuppressLint({ "MissingPermission" })
    public static boolean a() {
        final Context c;
        if ((c = gz.c()) == null) {
            return false;
        }
        try {
            final NetworkInfo activeNetworkInfo;
            return (activeNetworkInfo = ((ConnectivityManager)c.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected() && !b();
        }
        catch (Exception ex) {
            return false;
        }
    }
    
    private static boolean b() {
        boolean deviceIdleMode = false;
        final Context c;
        if ((c = gz.c()) == null) {
            return false;
        }
        try {
            final PowerManager powerManager = (PowerManager)c.getSystemService("power");
            if (Build.VERSION.SDK_INT > 22 && powerManager != null) {
                deviceIdleMode = powerManager.isDeviceIdleMode();
            }
        }
        catch (Exception ex) {}
        return deviceIdleMode;
    }
    
    public static String a(final Map<String, String> map, final String str) {
        final StringBuilder sb = new StringBuilder();
        if (map != null) {
            for (final Map.Entry<String, String> entry : map.entrySet()) {
                if (sb.length() > 0) {
                    sb.append(str);
                }
                sb.append(String.format(Locale.US, "%s=%s", a(entry.getKey()), a(entry.getValue())));
            }
        }
        return sb.toString();
    }
    
    private static String a(final String s) {
        String encode = "";
        try {
            encode = URLEncoder.encode(s, "UTF-8");
        }
        catch (UnsupportedEncodingException ex) {}
        return encode;
    }
    
    public static void a(final Map<String, String> map) {
        if (map != null) {
            final Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            while (iterator.hasNext()) {
                final Map.Entry<String, String> entry;
                if ((entry = iterator.next()).getValue() != null && entry.getValue().trim().length() != 0 && entry.getKey() != null && entry.getKey().trim().length() != 0) {
                    hashMap.put(entry.getKey().trim(), entry.getValue().trim());
                }
            }
            map.clear();
            map.putAll(hashMap);
        }
    }
    
    @NonNull
    public static HashMap<String, String> a(@Nullable final JSONObject jsonObject) {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        if (jsonObject != null) {
            try {
                final Iterator keys = jsonObject.keys();
                while (keys.hasNext()) {
                    final String key = keys.next();
                    hashMap.put(key, jsonObject.getString(key));
                }
            }
            catch (Exception ex) {}
        }
        return hashMap;
    }
    
    public static String a(String replace, final Map<String, String> map) {
        if (map != null && map.size() > 0) {
            for (final Map.Entry<String, String> entry : map.entrySet()) {
                replace = replace.replace(entry.getKey(), entry.getValue());
            }
        }
        return replace;
    }
    
    public static byte[] a(@NonNull byte[] array) {
        array = (byte[])(Object)new ByteArrayInputStream(array);
        Closeable closeable = null;
        try {
            return a((InputStream)(closeable = new GZIPInputStream((InputStream)(Object)array)));
        }
        catch (IOException ex) {
            hf.a((byte)2, hg.a, "Failed to decompress response", ex);
            return null;
        }
        finally {
            a((Closeable)(Object)array);
            a(closeable);
        }
    }
    
    public static byte[] a(final InputStream inputStream) throws IOException {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final byte[] array = new byte[4096];
        try {
            int read;
            while (-1 != (read = inputStream.read(array))) {
                byteArrayOutputStream.write(array, 0, read);
            }
            return byteArrayOutputStream.toByteArray();
        }
        finally {
            a(byteArrayOutputStream);
        }
    }
    
    public static void a(final HttpURLConnection httpURLConnection) {
        try {
            a((Closeable)httpURLConnection.getInputStream());
        }
        catch (IOException ex) {}
    }
    
    public static void a(final Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        }
        catch (IOException ex) {}
    }
    
    static {
        a = hg.class.getSimpleName();
    }
}

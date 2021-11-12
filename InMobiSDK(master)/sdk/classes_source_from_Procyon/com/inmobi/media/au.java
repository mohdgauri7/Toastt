// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONArray;
import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.ArrayList;
import androidx.annotation.Nullable;
import java.util.List;
import android.content.ContentValues;

public class au
{
    private static final String b;
    public static final String[] a;
    
    public static au a() {
        return au.a.a;
    }
    
    private au() {
        final gt a;
        (a = gt.a()).a("asset", "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, pending_attempts INTEGER NOT NULL, url TEXT NOT NULL, disk_uri TEXT, ts TEXT NOT NULL, created_ts TEXT NOT NULL, ttl TEXT NOT NULL, soft_ttl TEXT NOT NULL)");
        a.b();
    }
    
    public final synchronized void a(final al al) {
        if (b(al) <= 0) {
            final gt a;
            (a = gt.a()).a("asset", d(al));
            a.b();
        }
    }
    
    @Nullable
    static al b() {
        final List<ContentValues> a;
        if ((a = gt.a().a("asset", au.a, null, null, null, null, "ts ASC ", null)).size() == 0) {
            return null;
        }
        return a(a.get(0));
    }
    
    @NonNull
    static List<al> c() {
        final ArrayList<al> list = new ArrayList<al>();
        final gt a;
        final Iterator<ContentValues> iterator = (a = gt.a()).a("asset", au.a, null, null, null, null, "ts ASC ", null).iterator();
        while (iterator.hasNext()) {
            list.add(a(iterator.next()));
        }
        a.b();
        final ArrayList<al> list2 = new ArrayList<al>();
        final Iterator<Object> iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            final al al;
            if (!(al = iterator2.next()).a()) {
                list2.add(al);
            }
        }
        return list2;
    }
    
    static List<al> d() {
        final ArrayList<al> list = new ArrayList<al>();
        final gt a;
        if ((a = gt.a()).a("asset") == 0) {
            return list;
        }
        final List<ContentValues> a2 = a.a("asset", au.a, "disk_uri IS NOT NULL", null, null, null, "created_ts DESC ", null);
        a.b();
        final Iterator<ContentValues> iterator = a2.iterator();
        while (iterator.hasNext()) {
            list.add(a(iterator.next()));
        }
        return list;
    }
    
    public static String e() {
        final List<al> d = d();
        if (0 == d.size()) {
            return null;
        }
        final JSONArray jsonArray = new JSONArray();
        for (final al al : d) {
            try {
                jsonArray.put((Object)URLEncoder.encode(al.d, "UTF-8"));
            }
            catch (UnsupportedEncodingException ex) {}
        }
        return jsonArray.toString();
    }
    
    @Nullable
    static al a(final String s) {
        final gt a2;
        final List<ContentValues> a = (a2 = gt.a()).a("asset", au.a, "url=? ", new String[] { s }, null, null, "created_ts DESC ", "1");
        a2.b();
        if (a.isEmpty()) {
            return null;
        }
        return a(a.get(0));
    }
    
    public static List<String> f() {
        final ArrayList<String> list = new ArrayList<String>();
        final gt a;
        if ((a = gt.a()).a("asset") == 0) {
            return list;
        }
        final List<ContentValues> a2 = a.a("asset", new String[] { "url" }, null, null, null, null, "created_ts DESC ", null);
        a.b();
        final Iterator<ContentValues> iterator = a2.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next().getAsString("url"));
        }
        return list;
    }
    
    public static al b(final String s) {
        final gt a2;
        final List<ContentValues> a = (a2 = gt.a()).a("asset", au.a, "url=? ", new String[] { s }, null, null, "created_ts DESC ", "1");
        a2.b();
        if (a.isEmpty()) {
            return null;
        }
        return a(a.get(0));
    }
    
    public static int b(final al al) {
        final gt a = gt.a();
        final int b = a.b("asset", d(al), "url = ?", new String[] { String.valueOf(al.d) });
        a.b();
        return b;
    }
    
    public static void c(final al al) {
        final gt a = gt.a();
        a.a("asset", "id = ?", new String[] { String.valueOf(al.b) });
        a.b();
    }
    
    public static al a(final ContentValues contentValues) {
        return new al(contentValues.getAsInteger("id"), contentValues.getAsString("url"), contentValues.getAsString("disk_uri"), contentValues.getAsInteger("pending_attempts"), Long.valueOf(contentValues.getAsString("ts")), Long.valueOf(contentValues.getAsString("created_ts")), Long.valueOf(contentValues.getAsString("ttl")), Long.valueOf(contentValues.getAsString("soft_ttl")));
    }
    
    private static ContentValues d(final al al) {
        final ContentValues contentValues;
        (contentValues = new ContentValues()).put("id", Integer.valueOf(al.b));
        contentValues.put("url", al.d);
        contentValues.put("disk_uri", al.e);
        contentValues.put("pending_attempts", Integer.valueOf(al.c));
        contentValues.put("ts", Long.toString(al.f));
        contentValues.put("created_ts", Long.toString(al.g));
        contentValues.put("ttl", Long.toString(al.h));
        contentValues.put("soft_ttl", Long.toString(al.i));
        return contentValues;
    }
    
    static {
        b = au.class.getSimpleName();
        a = new String[] { "id", "pending_attempts", "url", "disk_uri", "ts", "created_ts", "ttl", "soft_ttl" };
    }
    
    static final class a
    {
        static final au a;
        
        static {
            a = new au((byte)0);
        }
    }
}

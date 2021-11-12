// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.content.Context;
import java.util.concurrent.TimeUnit;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;

public class fw extends ga
{
    private static final String a;
    
    public fw() {
        final gt a;
        (a = gt.a()).a("crash", "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, componentType TEXT NOT NULL, eventId TEXT NOT NULL, eventType TEXT NOT NULL, payload TEXT NOT NULL, ts TEXT NOT NULL)");
        a.b();
    }
    
    public static void a(final fx fx) {
        final gt a = gt.a();
        final String s = "crash";
        final ContentValues contentValues;
        (contentValues = new ContentValues()).put("eventId", fx.b);
        contentValues.put("componentType", fx.d);
        contentValues.put("eventType", fx.c);
        contentValues.put("payload", fx.a());
        contentValues.put("ts", String.valueOf(fx.e));
        a.a(s, contentValues);
        a.b();
    }
    
    public static List<fx> a(final int i) {
        final gt a2;
        final List<ContentValues> a = (a2 = gt.a()).a("crash", null, null, null, null, null, "ts ASC", String.valueOf(i));
        final ArrayList<fx> list = new ArrayList<fx>();
        a2.b();
        final Iterator<ContentValues> iterator = a.iterator();
        while (iterator.hasNext()) {
            list.add(fx.a(iterator.next()));
        }
        return list;
    }
    
    @Override
    public final boolean a(final long n) {
        final List<fx> a = a(1);
        boolean b = false;
        if (a.size() > 0 && TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - a.get(0).e) > n) {
            b = true;
        }
        return b;
    }
    
    @Override
    public final boolean a(final long n, final long n2) {
        final long n3 = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) + n;
        final List<fx> a = a(1);
        boolean b = false;
        if (a.size() > 0 && n3 - TimeUnit.MILLISECONDS.toSeconds(a.get(0).e) >= n2) {
            b = true;
        }
        return b;
    }
    
    @Override
    public final int a() {
        final gt a2;
        final int a = (a2 = gt.a()).a("crash");
        a2.b();
        return a;
    }
    
    @Override
    public final void b(final long n) {
        final gt a = gt.a();
        a.a("crash", "ts<?", new String[] { String.valueOf(System.currentTimeMillis() - n * 1000L) });
        a.b();
    }
    
    @Override
    public final void a(final List<Integer> list) {
        if (list.isEmpty()) {
            return;
        }
        final gt a = gt.a();
        final StringBuilder obj = new StringBuilder();
        for (int i = 0; i < list.size() - 1; ++i) {
            obj.append(list.get(i)).append(",");
        }
        obj.append(String.valueOf(list.get(list.size() - 1)));
        a.a("crash", "id IN (" + (Object)obj + ")", null);
        a.b();
    }
    
    public static void b() {
        final gt a2;
        final List<ContentValues> a;
        if (!(a = (a2 = gt.a()).a("crash", null, null, null, null, null, "ts ASC", "1")).isEmpty()) {
            a2.a("crash", "id IN (" + a.get(0).getAsString("id") + ")", null);
        }
        a2.b();
    }
    
    @Override
    public final void c(final long n) {
        final Context c;
        if ((c = gz.c()) != null) {
            gu.a(c, "batch_processing_info").a("crash_last_batch_process", n);
        }
    }
    
    @Override
    public final long c() {
        final Context c;
        if ((c = gz.c()) != null) {
            return gu.a(c, "batch_processing_info").b("crash_last_batch_process", -1L);
        }
        return -1L;
    }
    
    static {
        a = fw.class.getSimpleName();
    }
}

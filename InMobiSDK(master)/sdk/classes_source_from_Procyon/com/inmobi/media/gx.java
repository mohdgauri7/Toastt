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

public class gx extends ga
{
    private static final String a;
    
    public gx() {
        final gt a;
        (a = gt.a()).a("telemetry", "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, eventType TEXT NOT NULL, payload TEXT NOT NULL, ts TEXT NOT NULL)");
        a.b();
    }
    
    public static void a(final gy gy) {
        final gt a = gt.a();
        final String s = "telemetry";
        final ContentValues contentValues;
        (contentValues = new ContentValues()).put("eventType", gy.b);
        contentValues.put("payload", gy.a());
        contentValues.put("ts", String.valueOf(gy.c));
        a.a(s, contentValues);
        a.b();
    }
    
    public static List<gy> a(final int i) {
        final gt a2;
        final List<ContentValues> a = (a2 = gt.a()).a("telemetry", null, null, null, null, null, "ts ASC", String.valueOf(i));
        final ArrayList<gy> list = new ArrayList<gy>();
        a2.b();
        final Iterator<ContentValues> iterator = a.iterator();
        while (iterator.hasNext()) {
            list.add(gy.a(iterator.next()));
        }
        return list;
    }
    
    @Override
    public final boolean a(final long n) {
        final List<gy> a = a(1);
        boolean b = false;
        if (a.size() > 0 && TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - a.get(0).c) >= n) {
            b = true;
        }
        return b;
    }
    
    @Override
    public final boolean a(final long n, final long n2) {
        final long n3 = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) + n;
        final List<gy> a = a(1);
        boolean b = false;
        if (a.size() > 0 && n3 - TimeUnit.MILLISECONDS.toSeconds(a.get(0).c) > n2) {
            b = true;
        }
        return b;
    }
    
    @Override
    public final int a() {
        final gt a2;
        final int a = (a2 = gt.a()).a("telemetry");
        a2.b();
        return a;
    }
    
    @Override
    public final void b(final long n) {
        final gt a = gt.a();
        a.a("telemetry", "ts<?", new String[] { String.valueOf(System.currentTimeMillis() - n * 1000L) });
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
        a.a("telemetry", "id IN (" + (Object)obj + ")", null);
        a.b();
    }
    
    @Override
    public final void c(final long n) {
        final Context c;
        if ((c = gz.c()) != null) {
            gu.a(c, "batch_processing_info").a("telemetry_last_batch_process", n);
        }
    }
    
    @Override
    public final long c() {
        final Context c;
        if ((c = gz.c()) == null) {
            return -1L;
        }
        return gu.a(c, "batch_processing_info").b("telemetry_last_batch_process", -1L);
    }
    
    static {
        a = gx.class.getSimpleName();
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.NonNull;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;

public final class gu
{
    private static HashMap<String, gu> b;
    private static final Object c;
    public SharedPreferences a;
    
    private gu(@NonNull final Context context, final String s) {
        this.a = context.getSharedPreferences(s, 0);
    }
    
    public static String a(final String obj) {
        return "com.im.keyValueStore.".concat(String.valueOf(obj));
    }
    
    @NonNull
    public static gu a(@NonNull final Context context, String a) {
        a = a(a);
        final gu gu;
        if ((gu = com.inmobi.media.gu.b.get(a)) != null) {
            return gu;
        }
        synchronized (com.inmobi.media.gu.c) {
            final gu gu2;
            if ((gu2 = com.inmobi.media.gu.b.get(a)) != null) {
                return gu2;
            }
            final gu value = new gu(context, a);
            com.inmobi.media.gu.b.put(a, value);
            return value;
        }
    }
    
    public final void a(final String s, final String s2) {
        final SharedPreferences.Editor edit;
        (edit = this.a.edit()).putString(s, s2);
        edit.apply();
    }
    
    public final String b(final String s) {
        return this.a.getString(s, (String)null);
    }
    
    public final void a(final String s, final int n) {
        final SharedPreferences.Editor edit;
        (edit = this.a.edit()).putInt(s, n);
        edit.apply();
    }
    
    public final int c(final String s) {
        return this.a.getInt(s, Integer.MIN_VALUE);
    }
    
    public final void a(final String s, final long n) {
        final SharedPreferences.Editor edit;
        (edit = this.a.edit()).putLong(s, n);
        edit.apply();
    }
    
    public final long b(final String s, final long n) {
        return this.a.getLong(s, n);
    }
    
    public final void a(final String s, final boolean b) {
        final SharedPreferences.Editor edit;
        (edit = this.a.edit()).putBoolean(s, b);
        edit.apply();
    }
    
    public final boolean b(final String s, final boolean b) {
        return this.a.getBoolean(s, b);
    }
    
    public final boolean d(final String s) {
        return this.a.contains(s);
    }
    
    public final boolean e(final String s) {
        if (this.d(s)) {
            final SharedPreferences.Editor edit;
            (edit = this.a.edit()).remove(s);
            edit.apply();
            return true;
        }
        return false;
    }
    
    static {
        gu.b = new HashMap<String, gu>();
        c = new Object();
    }
}

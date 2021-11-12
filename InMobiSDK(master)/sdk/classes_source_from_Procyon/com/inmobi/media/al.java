// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.Map;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.List;
import java.util.Random;
import java.io.File;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;

public class al
{
    private static final String m;
    long a;
    int b;
    int c;
    public String d;
    public String e;
    long f;
    long g;
    long h;
    long i;
    boolean j;
    public String k;
    public byte l;
    
    al(final int b, @NonNull final String d, @Nullable final String e, final int c, final long f, final long g, final long h, final long i) {
        this.a = 0L;
        this.b = b;
        this.d = d;
        this.e = e;
        this.c = c;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = false;
        this.k = null;
    }
    
    public final boolean a() {
        return this.e != null && 0 != this.e.length() && new File(this.e).exists();
    }
    
    @Override
    public boolean equals(final Object o) {
        return this == o || (o != null && this.getClass() == o.getClass() && this.d.equals(((al)o).d));
    }
    
    @Override
    public int hashCode() {
        return this.d.hashCode();
    }
    
    @Override
    public String toString() {
        return "AdAsset{url='" + this.d + '\'' + '}';
    }
    
    static {
        m = al.class.getSimpleName();
    }
    
    public static final class a
    {
        int a;
        int b;
        String c;
        String d;
        long e;
        long f;
        long g;
        long h;
        
        public a() {
            this.a = (new Random().nextInt() & Integer.MAX_VALUE);
            this.e = System.currentTimeMillis();
            this.f = System.currentTimeMillis();
        }
        
        public final a a(final String c, final int b, final long n) {
            this.c = c;
            this.b = b;
            this.g = System.currentTimeMillis() + n;
            return this;
        }
        
        public final a a(final String c, final String d, gn c2, final int b, final long n) {
            c2 = (gn)c2.c;
            final long currentTimeMillis = System.currentTimeMillis();
            long a = 0L;
            long a2 = 0L;
            long h = 0L;
            long b2 = 0L;
            long long1 = 0L;
            long long2 = 0L;
            boolean b3 = false;
            boolean b4 = false;
            final List list;
            final String s;
            if ((list = ((Map<K, List>)c2).get("Date")) != null && list.size() > 0 && (s = ((Map<K, List<String>>)c2).get("Date").get(0)) != null) {
                a = a(s);
            }
            final List list2;
            final String s2;
            if ((list2 = ((Map<K, List>)c2).get("Cache-Control")) != null && list2.size() > 0 && (s2 = ((Map<K, List<String>>)c2).get("Cache-Control").get(0)) != null) {
                b3 = true;
                String[] split;
                for (int length = (split = s2.split(",")).length, i = 0; i < length; ++i) {
                    final String trim = split[i].trim();
                    if (!"no-cache".equals(trim) && !"no-store".equals(trim)) {
                        if (trim.startsWith("max-age=")) {
                            try {
                                long1 = Long.parseLong(trim.substring(8));
                            }
                            catch (Exception ex) {
                                al.m;
                            }
                        }
                        else if (trim.startsWith("stale-while-revalidate=")) {
                            try {
                                long2 = Long.parseLong(trim.substring(23));
                            }
                            catch (Exception ex2) {
                                al.m;
                            }
                        }
                        else if ("must-revalidate".equals(trim) || "proxy-revalidate".equals(trim)) {
                            b4 = true;
                        }
                    }
                }
            }
            final List list3;
            final String s3;
            if ((list3 = ((Map<K, List>)c2).get("Expires")) != null && list3.size() > 0 && (s3 = ((Map<K, List<String>>)c2).get("Expires").get(0)) != null) {
                a2 = a(s3);
            }
            if (b3) {
                h = currentTimeMillis + long1 * 1000L;
                b2 = (b4 ? h : (h + long2 * 1000L));
            }
            else if (a > 0L && a2 >= a) {
                h = (b2 = currentTimeMillis + (a2 - a));
            }
            this.c = c;
            this.d = d;
            this.b = b;
            this.g = currentTimeMillis + n * 1000L;
            this.h = h;
            this.g = Math.min(this.g, b2);
            return this;
        }
        
        private static long a(final String source) {
            final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE,dd MMM yyyy HH:mm:ss z", Locale.ENGLISH);
            try {
                return simpleDateFormat.parse(source).getTime();
            }
            catch (ParseException ex) {
                fv.a().a(new gv(ex));
                return 0L;
            }
        }
        
        @NonNull
        public final al a() {
            return new al(this.a, this.c, this.d, this.b, this.e, this.f, this.g, this.h);
        }
    }
}

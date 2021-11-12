// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.Locale;
import java.util.HashMap;
import android.content.Context;
import android.location.Location;

public final class hs
{
    private static int a;
    private static String b;
    private static String c;
    private static String d;
    private static String e;
    private static String f;
    private static String g;
    private static int h;
    private static String i;
    private static String j;
    private static String k;
    private static String l;
    private static Location m;
    
    public static void a() {
        a(hs.a);
        a(hs.b);
        b(hs.c);
        c(hs.d);
        d(hs.e);
        e(hs.f);
        f(hs.g);
        b(hs.h);
        g(hs.i);
        h(hs.j);
        i(hs.k);
        j(hs.l);
        a(hs.m);
        d();
        e();
        f();
        g();
        h();
        i();
        j();
        k();
        l();
        m();
        n();
        o();
        b();
    }
    
    public static void a(final int a) {
        final Context c = gz.c();
        if (a != Integer.MIN_VALUE) {
            hs.a = a;
            if (c != null) {
                gu.a(c, "user_info_store").a("user_age", a);
            }
        }
    }
    
    private static int d() {
        if (hs.a != Integer.MIN_VALUE) {
            return hs.a;
        }
        final Context c;
        return hs.a = (((c = gz.c()) == null) ? Integer.MIN_VALUE : gu.a(c, "user_info_store").c("user_age"));
    }
    
    public static void a(final String b) {
        final Context c = gz.c();
        if (b != null) {
            hs.b = b;
            if (c != null) {
                gu.a(c, "user_info_store").a("user_age_group", b);
            }
        }
    }
    
    private static String e() {
        if (hs.b != null) {
            return hs.b;
        }
        final Context c;
        return hs.b = (((c = gz.c()) == null) ? null : gu.a(c, "user_info_store").b("user_age_group"));
    }
    
    public static void b(final String c) {
        final Context c2 = gz.c();
        hs.c = c;
        if (c2 != null && c != null) {
            gu.a(c2, "user_info_store").a("user_area_code", c);
        }
    }
    
    private static String f() {
        if (hs.c != null) {
            return hs.c;
        }
        final Context c;
        return hs.c = (((c = gz.c()) == null) ? null : gu.a(c, "user_info_store").b("user_area_code"));
    }
    
    public static void c(final String d) {
        final Context c = gz.c();
        if (d != null) {
            hs.d = d;
            if (c != null) {
                gu.a(c, "user_info_store").a("user_post_code", d);
            }
        }
    }
    
    private static String g() {
        if (hs.d != null) {
            return hs.d;
        }
        final Context c;
        return hs.d = (((c = gz.c()) == null) ? null : gu.a(c, "user_info_store").b("user_post_code"));
    }
    
    public static void d(final String e) {
        final Context c = gz.c();
        if (e != null) {
            hs.e = e;
            if (c != null) {
                gu.a(c, "user_info_store").a("user_city_code", e);
            }
        }
    }
    
    private static String h() {
        if (hs.e != null) {
            return hs.e;
        }
        final Context c;
        return hs.e = (((c = gz.c()) == null) ? null : gu.a(c, "user_info_store").b("user_city_code"));
    }
    
    private static String i() {
        if (hs.f != null) {
            return hs.f;
        }
        final Context c;
        return hs.f = (((c = gz.c()) == null) ? null : gu.a(c, "user_info_store").b("user_state_code"));
    }
    
    public static void e(final String f) {
        final Context c = gz.c();
        if (f != null) {
            hs.f = f;
            if (c != null) {
                gu.a(c, "user_info_store").a("user_state_code", f);
            }
        }
    }
    
    public static void f(final String g) {
        final Context c = gz.c();
        if (g != null) {
            hs.g = g;
            if (c != null) {
                gu.a(c, "user_info_store").a("user_country_code", g);
            }
        }
    }
    
    private static String j() {
        if (hs.g != null) {
            return hs.g;
        }
        final Context c;
        return hs.g = (((c = gz.c()) == null) ? null : gu.a(c, "user_info_store").b("user_country_code"));
    }
    
    public static void b(final int h) {
        final Context c = gz.c();
        if (h != Integer.MIN_VALUE) {
            hs.h = h;
            if (c != null) {
                gu.a(c, "user_info_store").a("user_yob", h);
            }
        }
    }
    
    private static int k() {
        if (hs.h != Integer.MIN_VALUE) {
            return hs.h;
        }
        final Context c;
        return hs.h = (((c = gz.c()) == null) ? Integer.MIN_VALUE : gu.a(c, "user_info_store").c("user_yob"));
    }
    
    public static void g(final String i) {
        final Context c = gz.c();
        if (i != null) {
            hs.i = i;
            if (c != null) {
                gu.a(c, "user_info_store").a("user_gender", i);
            }
        }
    }
    
    private static String l() {
        if (hs.i != null) {
            return hs.i;
        }
        final Context c;
        return hs.i = (((c = gz.c()) == null) ? null : gu.a(c, "user_info_store").b("user_gender"));
    }
    
    public static void h(final String j) {
        final Context c = gz.c();
        if (j != null) {
            hs.j = j;
            if (c != null) {
                gu.a(c, "user_info_store").a("user_education", j);
            }
        }
    }
    
    private static String m() {
        if (hs.j != null) {
            return hs.j;
        }
        final Context c;
        return hs.j = (((c = gz.c()) == null) ? null : gu.a(c, "user_info_store").b("user_education"));
    }
    
    private static String n() {
        if (hs.k != null) {
            return hs.k;
        }
        final Context c;
        return hs.k = (((c = gz.c()) == null) ? null : gu.a(c, "user_info_store").b("user_language"));
    }
    
    public static void i(final String k) {
        final Context c = gz.c();
        if (k != null) {
            hs.k = k;
            if (c != null) {
                gu.a(c, "user_info_store").a("user_language", k);
            }
        }
    }
    
    public static void j(final String l) {
        final Context c = gz.c();
        if (l != null) {
            hs.l = l;
            if (c != null) {
                gu.a(c, "user_info_store").a("user_interest", l);
            }
        }
    }
    
    private static String o() {
        if (hs.l != null) {
            return hs.l;
        }
        final Context c;
        return hs.l = (((c = gz.c()) == null) ? null : gu.a(c, "user_info_store").b("user_interest"));
    }
    
    public static Location b() {
        if (hs.m != null) {
            return hs.m;
        }
        final Context c;
        if ((c = gz.c()) == null) {
            return null;
        }
        final String b;
        if ((b = gu.a(c, "user_info_store").b("user_location")) == null) {
            return null;
        }
        Location m = new Location("");
        try {
            final String[] split = b.split(",");
            m.setLatitude(Double.parseDouble(split[0]));
            m.setLongitude(Double.parseDouble(split[1]));
            m.setAccuracy(Float.parseFloat(split[2]));
            m.setTime(Long.parseLong(split[3]));
        }
        catch (NumberFormatException ex) {
            m = null;
        }
        catch (ArrayIndexOutOfBoundsException ex2) {
            m = null;
        }
        return hs.m = m;
    }
    
    public static void a(final Location m) {
        final Context c = gz.c();
        if (m != null) {
            hs.m = m;
            if (c != null) {
                gu.a(c, "user_info_store").a("user_location", b(m));
            }
        }
    }
    
    public static HashMap<String, String> c() {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        final int d;
        if ((d = d()) > 0) {
            hashMap.put("u-age", String.valueOf(d));
        }
        final int k;
        if ((k = k()) > 0) {
            hashMap.put("u-yearofbirth", String.valueOf(k));
        }
        final String h = h();
        final String i = i();
        final String j = j();
        final String s = i;
        final String s2 = h;
        String s3 = "";
        if (s2 != null && s2.trim().length() != 0) {
            s3 = s2.trim();
        }
        if (s != null && s.trim().length() != 0) {
            s3 = s3 + "-" + s.trim();
        }
        if (j != null && j.trim().length() != 0) {
            s3 = s3 + "-" + j.trim();
        }
        final String value;
        if ((value = s3) != null && value.trim().length() != 0) {
            hashMap.put("u-location", value);
        }
        final String e;
        if ((e = e()) != null) {
            hashMap.put("u-agegroup", e.toLowerCase(Locale.ENGLISH));
        }
        final String f;
        if ((f = f()) != null) {
            hashMap.put("u-areacode", f);
        }
        final String g;
        if ((g = g()) != null) {
            hashMap.put("u-postalcode", g);
        }
        final String l;
        if ((l = l()) != null) {
            hashMap.put("u-gender", l);
        }
        final String m;
        if ((m = m()) != null) {
            hashMap.put("u-education", m);
        }
        final String n;
        if ((n = n()) != null) {
            hashMap.put("u-language", n);
        }
        final String o;
        if ((o = o()) != null) {
            hashMap.put("u-interests", o);
        }
        return hashMap;
    }
    
    private static String b(final Location location) {
        return location.getLatitude() + "," + location.getLongitude() + "," + (int)location.getAccuracy() + "," + location.getTime();
    }
    
    static {
        hs.a = Integer.MIN_VALUE;
        hs.h = Integer.MIN_VALUE;
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.Nullable;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.annotation.CallSuper;
import java.util.HashMap;
import org.json.JSONObject;
import java.util.Map;

public class gm
{
    private static final String a;
    protected Map<String, String> g;
    protected Map<String, String> h;
    protected Map<String, String> i;
    protected JSONObject j;
    String k;
    String l;
    private String b;
    private id c;
    public int m;
    public int n;
    public boolean o;
    boolean p;
    private byte[] d;
    private byte[] e;
    public boolean q;
    long r;
    boolean s;
    public boolean t;
    private boolean f;
    protected boolean u;
    private fr x;
    protected String v;
    public boolean w;
    
    public gm(final String s, final String s2, final id id) {
        this(s, s2, false, id, false, false, "application/x-www-form-urlencoded");
    }
    
    public gm(final String s, final String s2) {
        this(s, s2, false, null, false, false, "application/x-www-form-urlencoded");
        this.f = false;
    }
    
    public gm(final String s, final String s2, final boolean b, final id id, final boolean b2, final String s3) {
        this(s, s2, b, id, false, b2, s3);
    }
    
    public gm(final String anObject, final String b, final boolean p7, final id c, final boolean s, final boolean t, final String l) {
        this.g = new HashMap<String, String>();
        this.m = 60000;
        this.n = 60000;
        this.o = true;
        this.q = true;
        this.r = -1L;
        this.t = false;
        this.f = true;
        this.u = false;
        this.v = gz.f();
        this.w = true;
        this.k = anObject;
        this.b = b;
        this.p = p7;
        this.c = c;
        this.g.put("User-Agent", gz.i());
        this.s = s;
        this.t = t;
        if ("GET".equals(anObject)) {
            this.h = new HashMap<String, String>();
        }
        else if ("POST".equals(anObject)) {
            this.i = new HashMap<String, String>();
            this.j = new JSONObject();
        }
        this.l = l;
    }
    
    protected final fr c() {
        if (this.x == null) {
            this.x = (fr)fg.a("pk", this.v, null);
        }
        return this.x;
    }
    
    public final boolean d() {
        return this.r != -1L;
    }
    
    public final void a(final Map<String, String> map) {
        if (map != null) {
            this.g.putAll(map);
        }
    }
    
    public final void b(final Map<String, String> map) {
        if (map != null) {
            this.h.putAll(map);
        }
    }
    
    public final void c(final Map<String, String> map) {
        this.i.putAll(map);
    }
    
    public final Map<String, String> e() {
        hg.a(this.g);
        return this.g;
    }
    
    public final String f() {
        String str = this.b;
        final String b;
        if (this.h != null && (b = this.b()) != null && b.trim().length() != 0) {
            if (!str.contains("?")) {
                str += "?";
            }
            if (!str.endsWith("&") && !str.endsWith("?")) {
                str += "&";
            }
            str += b;
        }
        return str;
    }
    
    @CallSuper
    @WorkerThread
    public void a() {
        hq.g();
        this.t = hq.a(this.t);
        if (this.q) {
            if ("GET".equals(this.k)) {
                this.e(this.h);
            }
            else if ("POST".equals(this.k)) {
                this.e(this.i);
            }
        }
        final JSONObject b;
        if (this.f && (b = hq.b()) != null) {
            if ("GET".equals(this.k)) {
                this.h.put("consentObject", b.toString());
            }
            else if ("POST".equals(this.k)) {
                this.i.put("consentObject", b.toString());
            }
        }
        if (this.w) {
            if ("GET".equals(this.k)) {
                this.h.put("u-appsecure", Byte.toString(hm.a().d));
                return;
            }
            if ("POST".equals(this.k)) {
                this.i.put("u-appsecure", Byte.toString(hm.a().d));
            }
        }
    }
    
    private String b() {
        hg.a(this.h);
        return hg.a(this.h, "&");
    }
    
    public final String g() {
        String string = "";
        final String l = this.l;
        switch (l) {
            case "application/json": {
                string = this.j.toString();
                break;
            }
            case "application/x-www-form-urlencoded": {
                hg.a(this.i);
                String s = hg.a(this.i, "&");
                if (this.p) {
                    this.d = hl.a(16);
                    this.e = hl.a();
                    final byte[] d = this.d;
                    final byte[] e = this.e;
                    final String s2 = s;
                    final fr c = this.c();
                    final String s3 = s2;
                    final byte[] array = e;
                    final byte[] array2 = d;
                    final byte[] a = hl.a(8);
                    final HashMap<String, String> hashMap = new HashMap<String, String>();
                    hashMap.put("sm", hl.a(s3, array, array2, a, c.m, c.e));
                    hashMap.put("sn", c.ver);
                    s = hg.a(hashMap, "&");
                }
                string = s;
                break;
            }
        }
        return string;
    }
    
    public final void a(final boolean u) {
        this.u = u;
    }
    
    private void e(@NonNull final Map<String, String> map) {
        map.putAll(hm.a().c);
        map.putAll(hn.a(this.u));
        map.putAll(hr.a());
        this.d(map);
    }
    
    protected final void d(@NonNull final Map<String, String> map) {
        if (this.c != null) {
            map.putAll(this.c.a());
        }
    }
    
    @Nullable
    public final byte[] a(final byte[] array) {
        try {
            return hl.a(Base64.decode(array, 0), this.e, this.d);
        }
        catch (IllegalArgumentException ex) {
            return null;
        }
    }
    
    public final long h() {
        long n = 0L;
        try {
            if ("GET".equals(this.k)) {
                n = 0L + this.b().length();
            }
            else if ("POST".equals(this.k)) {
                n = 0L + this.g().length();
            }
        }
        catch (Exception ex) {}
        return n;
    }
    
    static {
        a = gm.class.getSimpleName();
    }
}

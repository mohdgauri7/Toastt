// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.Iterator;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;
import org.json.JSONObject;

public class bj
{
    private static final String z;
    String a;
    public String b;
    public bk c;
    public String d;
    public Object e;
    JSONObject f;
    String g;
    public boolean h;
    public byte i;
    public String j;
    public byte k;
    public byte l;
    public byte m;
    byte n;
    public int o;
    public int p;
    String q;
    public String r;
    public String s;
    public bj t;
    public List<bv> u;
    public Map<String, Object> v;
    public Object w;
    public int x;
    public bj y;
    
    public bj() {
        this("", "root", "CONTAINER", new bk());
    }
    
    public bj(final String s, final String s2, final String s3, final bk bk) {
        this(s, s2, s3, bk, new LinkedList<bv>());
    }
    
    public bj(final String a, final String d, final String b, final bk c, final List<bv> list) {
        this.a = a;
        this.d = d;
        this.b = b;
        this.c = c;
        this.e = null;
        this.g = "";
        this.h = false;
        this.i = 0;
        this.j = "";
        this.l = 0;
        this.k = 0;
        this.m = 0;
        this.n = 2;
        this.x = 0;
        this.o = -1;
        this.q = "";
        this.r = "";
        this.f = new JSONObject();
        (this.u = new LinkedList<bv>()).addAll(list);
        this.v = new HashMap<String, Object>();
    }
    
    public static void a(@NonNull final bv bv, @Nullable final Map<String, String> map) {
        ba.a().a(hg.a(bv.b, map), bv.e, true);
    }
    
    public final void a(final String s, @Nullable final Map<String, String> map) {
        if (0 == this.u.size()) {
            return;
        }
        for (final bv bv : this.u) {
            if (s.equals(bv.d)) {
                a(bv, map);
            }
        }
    }
    
    public final void a(final List<bv> list) {
        this.u.addAll(list);
    }
    
    public final void a(final String s) {
        this.r = s.trim();
    }
    
    public final void b(@NonNull final String s) {
        this.s = s.trim();
    }
    
    static {
        z = bj.class.getSimpleName();
    }
}

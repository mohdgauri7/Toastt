// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

final class fm
{
    private static final String b;
    private TreeMap<String, ff> c;
    Map<String, a> a;
    private gn d;
    private fi e;
    private long f;
    
    fm(final fl fl, final gn d, final long f) {
        this.c = new TreeMap<String, ff>(fl.c);
        this.d = d;
        this.a = new HashMap<String, a>();
        this.f = f;
        this.c();
    }
    
    @WorkerThread
    private void c() {
        if (!this.d.a()) {
            try {
                final JSONObject jsonObject;
                final Iterator keys = (jsonObject = new JSONObject(this.d.b())).keys();
                while (keys.hasNext()) {
                    final String s = keys.next();
                    final JSONObject jsonObject2 = jsonObject.getJSONObject(s);
                    if (this.c.get(s) != null) {
                        this.a.put(s, new a(jsonObject2, this.c.get(s)));
                    }
                }
                final HashMap<String, Object> hashMap;
                (hashMap = new HashMap<String, Object>()).put("name", a(this.c));
                hashMap.put("lts", b(this.c));
                gw.a().a("ConfigFetched", hashMap);
                return;
            }
            catch (JSONException ex) {
                this.e = new fi((byte)2, ex.getLocalizedMessage());
                final HashMap<String, Object> hashMap2;
                (hashMap2 = new HashMap<String, Object>()).put("errorCode", 1);
                hashMap2.put("name", a(this.c));
                hashMap2.put("lts", b(this.c));
                hashMap2.put("networkType", hn.b());
                gw.a().a("InvalidConfig", hashMap2);
                return;
            }
        }
        for (final Map.Entry<String, ff> entry : this.c.entrySet()) {
            final a a;
            (a = new a(null, entry.getValue())).c = new fi((byte)0, "Network error in fetching config.");
            this.a.put(entry.getKey(), a);
        }
        this.e = new fi((byte)0, this.d.a.b);
        final HashMap<String, Object> hashMap3;
        (hashMap3 = new HashMap<String, Object>()).put("errorCode", String.valueOf(this.d.a.a));
        hashMap3.put("name", a(this.c));
        hashMap3.put("lts", b(this.c));
        hashMap3.put("networkType", hn.b());
        gw.a().a("InvalidConfig", hashMap3);
    }
    
    final boolean a() {
        return this.d != null && null != this.d.a && (this.d.a.a == -7 || a(this.d.a.a));
    }
    
    private static boolean a(final int n) {
        return 500 <= n && n < 600;
    }
    
    @WorkerThread
    private static String a(@NonNull final Map<String, ff> map) {
        if (map.isEmpty()) {
            return "[]";
        }
        final StringBuilder sb = new StringBuilder();
        final Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next()).append(",");
        }
        return "[" + sb.substring(0, sb.length() - 1) + "]";
    }
    
    @WorkerThread
    private static String b(@NonNull final Map<String, ff> map) {
        if (map.isEmpty()) {
            return "[]";
        }
        final StringBuilder sb = new StringBuilder();
        new fh();
        for (final Map.Entry<String, ff> entry : map.entrySet()) {
            sb.append(fh.c(entry.getKey(), entry.getValue().g())).append(",");
        }
        return "[" + sb.substring(0, sb.length() - 1) + "]";
    }
    
    static {
        b = fm.class.getSimpleName();
    }
    
    public static final class a
    {
        int a;
        ff b;
        fi c;
        
        a(JSONObject jsonObject, ff a) {
            this.b = a;
            if (jsonObject != null) {
                final JSONObject jsonObject2 = jsonObject;
                jsonObject = (JSONObject)this;
                try {
                    final JSONObject jsonObject3 = jsonObject;
                    int a2 = 0;
                    switch (jsonObject2.getInt("status")) {
                        default: {
                            a2 = -1;
                            break;
                        }
                        case 200: {
                            a2 = 200;
                            break;
                        }
                        case 304: {
                            a2 = 304;
                            break;
                        }
                        case 404: {
                            a2 = 404;
                            break;
                        }
                        case 500: {
                            a2 = 500;
                            break;
                        }
                    }
                    ((a)jsonObject3).a = a2;
                    if (((a)jsonObject).a == 200) {
                        if ((a = ff.a(((a)jsonObject).b.b(), jsonObject2.getJSONObject("content"), ((a)jsonObject).b.g())) != null) {
                            ((a)jsonObject).b = a;
                        }
                        if (((a)jsonObject).b == null || !((a)jsonObject).b.d()) {
                            ((a)jsonObject).c = new fi((byte)2, "The received config has failed validation.");
                            fm.b;
                            ((a)jsonObject).b.b();
                        }
                        return;
                    }
                    if (((a)jsonObject).a == 304) {
                        fm.b;
                        ((a)jsonObject).b.b();
                        return;
                    }
                    ((a)jsonObject).c = new fi((byte)1, "Internal error");
                    fm.b;
                    ((a)jsonObject).b.b();
                }
                catch (JSONException ex) {
                    ((a)jsonObject).c = new fi((byte)2, ex.getLocalizedMessage());
                    fm.b;
                    ((a)jsonObject).b.b();
                }
            }
        }
        
        public final boolean a() {
            return this.c != null;
        }
    }
}

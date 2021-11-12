// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.Map;
import org.json.JSONObject;
import java.util.HashMap;
import androidx.annotation.NonNull;

public class id
{
    private fp a;
    
    public id(@NonNull final fp a) {
        this.a = a;
    }
    
    public final HashMap<String, String> a() {
        final HashMap<String, String> hashMap;
        (hashMap = new HashMap<String, String>()).put("u-id-map", this.b());
        return hashMap;
    }
    
    private String b() {
        return new JSONObject((Map)this.c()).toString();
    }
    
    private Map<String, String> c() {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        String b = null;
        try {
            final ib e;
            if (this.a.GPID && (e = ic.a().e()) != null && (b = e.b()) != null) {
                hashMap.put("GPID", b);
            }
            this.a(hashMap, b);
        }
        catch (Exception ex) {
            id.class.getSimpleName();
            this.a(hashMap, b);
        }
        return hashMap;
    }
    
    private void a(final Map<String, String> map, final String s) {
        try {
            if (this.a.UM5 && s == null) {
                ic.a();
                ic.a();
                map.put("UM5", ic.a(ic.d(), "MD5"));
            }
            if (this.a.O1 && s == null) {
                ic.a();
                ic.a();
                map.put("O1", ic.a(ic.d(), "SHA-1"));
            }
        }
        catch (Exception ex) {
            id.class.getSimpleName();
        }
    }
}

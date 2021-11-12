// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.Map;
import java.util.HashMap;
import androidx.annotation.UiThread;

public class cp
{
    public static final String a;
    
    @UiThread
    public static cp a() {
        return cp.a.a;
    }
    
    public static void a(final int i, final long n) {
        final HashMap<String, String> hashMap;
        (hashMap = new HashMap<String, String>()).put("latency", (String)(System.currentTimeMillis() - n));
        hashMap.put("networkType", hn.b());
        hashMap.put("errorCode", (String)i);
        hashMap.put("plType", "AB");
        gw.a().a("AdGetSignalsFailed", (Map<String, Object>)hashMap);
    }
    
    static {
        a = cp.class.getName();
    }
    
    static final class a
    {
        static final cp a;
        
        static {
            a = new cp();
        }
    }
}

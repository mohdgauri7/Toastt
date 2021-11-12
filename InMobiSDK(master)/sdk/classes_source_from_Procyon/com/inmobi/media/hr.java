// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class hr
{
    private static final String a;
    
    public static Map<String, String> a() {
        final HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        try {
            hashMap.put("mk-version", ha.a());
            final Boolean f;
            if ((f = ic.a().f()) != null) {
                hashMap.put("u-id-adt", String.valueOf((int)(((boolean)f) ? 1 : 0)));
            }
            hashMap.put("ts", String.valueOf(Calendar.getInstance().getTimeInMillis()));
            final Map<String, String> map = (Map<String, String>)hashMap;
            final String s = "tz";
            final Calendar instance = Calendar.getInstance();
            map.put(s, String.valueOf(instance.get(15) + instance.get(16)));
            final HashMap<Object, Object> hashMap2 = hashMap;
            final ht a = ht.a();
            final HashMap<String, String> hashMap3 = new HashMap<String, String>();
            if (a.d && a.a != null) {
                hashMap3.put("u-s-id", a.a);
            }
            hashMap2.putAll(hashMap3);
        }
        catch (Exception ex) {}
        return (Map<String, String>)hashMap;
    }
    
    static {
        a = hr.class.getSimpleName();
    }
}

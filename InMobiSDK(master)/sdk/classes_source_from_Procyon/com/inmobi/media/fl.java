// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import androidx.annotation.WorkerThread;
import java.util.Iterator;
import androidx.annotation.NonNull;
import java.util.Map;
import androidx.annotation.VisibleForTesting;

@VisibleForTesting(otherwise = 3)
public final class fl extends gm
{
    private static final String d;
    int a;
    int b;
    Map<String, ff> c;
    private static String e;
    private static Map<String, String> f;
    
    fl(final Map<String, ff> map, final id id, final String s, final int n, final int n2, final boolean b, @NonNull final String s2) {
        this(map, id, s, n, n2, false, b, s2);
    }
    
    fl(final Map<String, ff> c, final id id, final String s, final int a, final int b, final boolean b2, final boolean b3, @NonNull final String v) {
        final String s2 = "POST";
        final String s3 = b2 ? "https://config.inmobi.com/config-server/v1/config/secure.cfg" : fl.e;
        super(s2, (null != c.get("root") || s == null || s.trim().length() == 0) ? s3 : s, true, id, b3, "application/x-www-form-urlencoded");
        this.c = c;
        this.a = a;
        this.b = b;
        this.v = v;
    }
    
    @WorkerThread
    @Override
    public final void a() {
        super.a();
        this.i.put("p", this.i());
        this.i.put("im-accid", this.v);
        if (fl.f != null) {
            for (final Map.Entry<String, String> entry : fl.f.entrySet()) {
                if (!this.g.containsKey(entry.getKey())) {
                    this.g.put(entry.getKey(), entry.getValue());
                }
            }
        }
    }
    
    private String i() {
        new fh();
        String string = "";
        try {
            final JSONArray jsonArray = new JSONArray();
            for (final Map.Entry<String, ff> entry : this.c.entrySet()) {
                final JSONObject jsonObject;
                (jsonObject = new JSONObject()).put("n", (Object)entry.getKey());
                jsonObject.put("t", (null == entry.getValue().g()) ? 0L : fh.c(entry.getKey(), entry.getValue().g()));
                jsonArray.put((Object)jsonObject);
            }
            string = jsonArray.toString();
        }
        catch (JSONException ex) {}
        return string;
    }
    
    public final String b() {
        return this.v;
    }
    
    static {
        d = fl.class.getSimpleName();
        fl.e = "https://config.inmobi.com/config-server/v1/config/secure.cfg";
    }
}

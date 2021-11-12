// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.UiThread;
import org.json.JSONObject;
import java.util.Iterator;
import android.os.Build;
import androidx.annotation.NonNull;
import java.util.Map;
import androidx.annotation.Nullable;

public final class cq extends gm
{
    @Nullable
    public String a;
    @Nullable
    public Map<String, String> b;
    
    public cq(@NonNull final id id) {
        super("POST", null, false, id, false, false, "application/x-www-form-urlencoded");
        this.v = gz.f();
        super.q = false;
    }
    
    @UiThread
    @Override
    public final void a() {
        super.a();
        final by a;
        if ((a = ix.a()).a != null) {
            this.i.put("ufid", a.a);
        }
        this.i.put("is-unifid-service-used", new StringBuilder().append(a.b).toString());
        this.i.putAll(ig.a().d());
        this.i.putAll(hr.a());
        this.i.put("d-media-volume", String.valueOf(hn.a(gz.c(), this.u)));
        this.d(this.i);
        if (this.a != null) {
            this.i.put("p-keywords", this.a);
        }
        if (this.b != null) {
            for (final Map.Entry<String, String> entry : this.b.entrySet()) {
                if (!this.i.containsKey(entry.getKey())) {
                    this.i.put(entry.getKey(), entry.getValue());
                }
            }
        }
        final JSONObject ext;
        if ((ext = ((ft)fg.a("signals", this.v, null)).ext) != null && ext.length() > 0) {
            this.i.put("im-ext", ext.toString());
        }
        final String d;
        if (Build.VERSION.SDK_INT >= 29 && (d = ho.d()) != null) {
            this.i.put("d-device-gesture-margins", d);
        }
        final fe fe;
        this.i.put("cct-enabled", String.valueOf((fe = (fe)fg.a("ads", this.v, null)) != null && fe.cctEnabled && null != com.inmobi.media.g.a(gz.c())));
        this.i.putAll(hs.c());
        this.i.putAll(ho.c());
    }
}

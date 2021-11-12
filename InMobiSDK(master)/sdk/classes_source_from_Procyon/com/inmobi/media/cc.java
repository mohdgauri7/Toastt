// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import org.json.JSONObject;
import java.util.Iterator;
import java.util.ArrayList;
import android.os.Build;
import java.util.Locale;
import java.util.HashMap;
import android.net.Uri;
import android.annotation.TargetApi;
import androidx.annotation.WorkerThread;
import androidx.annotation.Nullable;
import com.inmobi.unification.sdk.model.ASRequestParams;
import java.util.Map;
import androidx.annotation.NonNull;

public final class cc extends gm
{
    private static final String x;
    @NonNull
    private aq y;
    public String a;
    public String b;
    public String c;
    public Map<String, String> d;
    public final cr e;
    @Nullable
    public ASRequestParams f;
    @Nullable
    private static String z;
    @Nullable
    private static Map<String, String> A;
    
    @WorkerThread
    @TargetApi(29)
    public cc(final String s, final id id, final String s2, @NonNull final aq y) {
        final String s3 = "POST";
        String z;
        String s4;
        String z2;
        if (cc.z == null) {
            z = s;
            s4 = s;
            z2 = s;
        }
        else {
            s4 = (z2 = (z = cc.z));
        }
        cc.z = z2;
        super(s3, z, a(s4), id, a(cc.z), false, "application/x-www-form-urlencoded");
        this.a = "json";
        this.y = y;
        this.v = gz.f();
        this.i.putAll(ho.c());
        this.i.put("u-appIS", hm.a().b);
        this.i.put("client-request-id", this.y.o());
        if (s2 != null) {
            this.i.put("u-appcache", s2);
        }
        this.i.put("sdk-flavor", "row");
        this.e = new cr();
    }
    
    private static boolean a(final String s) {
        if (s == null) {
            return true;
        }
        final Uri parse = Uri.parse(s);
        return "http".equals(parse.getScheme()) || !"https".equals(parse.getScheme());
    }
    
    @WorkerThread
    @Override
    public final void a() {
        super.a();
        final by a;
        if ((a = ix.a()).a != null) {
            this.i.put("ufid", a.a);
        }
        this.i.put("is-unifid-service-used", new StringBuilder().append(a.b).toString());
        this.i.put("format", this.a);
        this.i.put("adtype", this.b);
        this.i.putAll(ig.a().d());
        final Map<String, String> i = this.i;
        final ig a2 = ig.a();
        final HashMap<String, String> hashMap;
        (hashMap = new HashMap<String, String>()).put("loc-consent-status", (ig.c() ? (a2.e() ? "AUTHORISED" : "DENIED") : "DENIED").toLowerCase(Locale.ENGLISH));
        i.putAll(hashMap);
        final Map<String, String> j = this.i;
        im im = null;
        ii.a();
        final String m = gz.m();
        final ip c;
        final String s = ((c = ir.c()) != null) ? c.e() : null;
        final boolean b = c != null && c.d();
        final boolean b2 = m == null || ii.a(m).w.cwe;
        final boolean b3 = s == null || c.b();
        final boolean b4 = !b || ii.a(s).w.cwe;
        if (b2 && b3 && b4) {
            boolean b5 = false;
            Label_0357: {
                if (gz.a()) {
                    final boolean a3 = hh.a(gz.c(), "android.permission.ACCESS_WIFI_STATE");
                    if (Build.VERSION.SDK_INT < 29) {
                        b5 = a3;
                        break Label_0357;
                    }
                    final boolean a4 = hh.a(gz.c(), "android.permission.ACCESS_FINE_LOCATION");
                    if (a3 && a4) {
                        b5 = true;
                        break Label_0357;
                    }
                }
                b5 = false;
            }
            im a5;
            if (!b5) {
                a5 = null;
            }
            else {
                ii.a();
                final int wf = ii.e().w.wf;
                a5 = in.a(in.a(wf), in.a(wf, 1));
            }
            im = a5;
        }
        final HashMap<String, String> hashMap2 = new HashMap<String, String>();
        if (im != null) {
            hashMap2.put("c-ap-bssid", String.valueOf(im.a));
        }
        j.putAll(hashMap2);
        final Map<String, String> k = this.i;
        ArrayList<im> list = null;
        ii.a();
        if (ii.h()) {
            list = (ArrayList<im>)(ArrayList)io.b();
        }
        final HashMap<String, String> hashMap3 = new HashMap<String, String>();
        if (list != null && list.size() > 0) {
            final HashMap<String, String> hashMap4 = hashMap3;
            final String key = "v-ap-bssid";
            final ArrayList<im> list2 = list;
            hashMap4.put(key, String.valueOf(list2.get(list2.size() - 1).a));
        }
        k.putAll(hashMap3);
        this.i.putAll(il.a(this.y.a()));
        this.i.putAll(il.a());
        this.i.putAll(il.b());
        this.i.put("skdv", this.c().ver);
        this.i.put("skdm", this.e.a(this.c().m, this.c().e));
        if (this.c != null) {
            this.i.put("p-keywords", this.c);
        }
        String s2;
        if (null != this.y.n()) {
            if ("others".equals(this.y.n())) {
                s2 = "M10N_CONTEXT_OTHER";
            }
            else {
                s2 = "M10N_CONTEXT_ACTIVITY";
            }
        }
        else {
            s2 = "M10N_CONTEXT_ACTIVITY";
        }
        this.i.put("m10n_context", s2);
        if (this.y.c() != null) {
            for (final Map.Entry<String, String> entry : this.y.c().entrySet()) {
                if (!this.i.containsKey(entry.getKey())) {
                    this.i.put(entry.getKey(), entry.getValue());
                }
            }
        }
        if (this.d != null) {
            this.i.putAll(this.d);
        }
        if (this.y.j() != Long.MIN_VALUE) {
            this.i.put("im-plid", String.valueOf(this.y.j()));
        }
        if (this.y.i() != Long.MIN_VALUE) {
            this.i.put("as-plid", String.valueOf(this.y.i()));
        }
        this.i.put("int-origin", this.y.b());
        final JSONObject ext;
        if ((ext = ((ft)fg.a("signals", this.v, null)).ext) != null && ext.length() > 0) {
            this.i.put("im-ext", ext.toString());
        }
        this.i.put("has-dynamic-mediation", String.valueOf(this.f != null && this.f.d));
        final ip c2;
        final String s3;
        if (this.y.i() != Long.MIN_VALUE && (s3 = (((c2 = ir.c()) != null) ? c2.g() : null)) != null) {
            this.i.put("as-ext", s3);
        }
        if (this.f != null) {
            if (this.f.b != null) {
                this.i.put("a9_params", this.f.b);
            }
            if (this.f.a != null) {
                this.i.put("publisher_keys", this.f.a);
            }
            if (this.f.c != null) {
                this.i.put("vc_user_id", this.f.c);
            }
        }
        if (cc.A != null) {
            this.a(cc.A);
        }
        final String d;
        if (Build.VERSION.SDK_INT >= 29 && (d = ho.d()) != null) {
            this.i.put("d-device-gesture-margins", d);
        }
        final fe fe;
        this.i.put("cct-enabled", String.valueOf((fe = (fe)fg.a("ads", this.v, null)) != null && fe.cctEnabled && null != com.inmobi.media.g.a(gz.c())));
        this.i.putAll(hs.c());
    }
    
    static {
        x = cc.class.getSimpleName();
        cc.A = null;
    }
}

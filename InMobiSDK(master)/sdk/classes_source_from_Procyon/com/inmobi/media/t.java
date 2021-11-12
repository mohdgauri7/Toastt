// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.Arrays;
import java.util.UUID;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.net.URL;
import android.text.TextUtils;
import com.iab.omid.library.inmobi.adsession.VerificationScriptResource;
import androidx.annotation.CallSuper;
import android.annotation.SuppressLint;
import android.os.SystemClock;
import com.squareup.picasso.Picasso;
import androidx.recyclerview.widget.RecyclerView;
import org.json.JSONArray;
import android.app.Application;
import org.json.JSONObject;
import org.json.JSONException;
import com.inmobi.ads.AdMetaInfo;
import java.util.Map;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import com.inmobi.ads.InMobiAdRequestStatus;
import android.os.Looper;
import java.util.TreeSet;
import java.util.HashSet;
import android.os.Handler;
import java.util.Set;
import java.util.HashMap;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import androidx.annotation.Nullable;
import android.content.Context;
import java.lang.ref.WeakReference;

public abstract class t extends q implements as.a, be, ct, db, fg.c, i, y
{
    static final String a;
    byte b;
    private WeakReference<Context> x;
    fe c;
    private it y;
    @Nullable
    private as z;
    private WeakReference<a> A;
    @NonNull
    protected ArrayList<o> d;
    long e;
    long f;
    private long B;
    public l g;
    private HashMap<Integer, Set<de>> C;
    byte h;
    public Handler i;
    boolean j;
    private boolean D;
    private o E;
    boolean k;
    boolean l;
    boolean m;
    @Nullable
    bz n;
    aq o;
    @Nullable
    ar p;
    @Nullable
    private cu F;
    boolean q;
    private static HashSet<Byte> G;
    int r;
    int s;
    long t;
    TreeSet<Integer> u;
    boolean v;
    private String H;
    final hb w;
    private q I;
    
    public t(@NonNull final Context referent, @NonNull final aq o, @Nullable final a referent2) {
        this.d = new ArrayList<o>();
        this.f = 0L;
        this.B = 0L;
        this.l = false;
        this.q = false;
        this.r = 0;
        this.s = 0;
        this.t = 0L;
        this.u = new TreeSet<Integer>();
        this.v = false;
        this.H = null;
        this.w = hb.a();
        this.I = new q() {
            @Override
            public final void c(final o o) {
                if (2 == com.inmobi.media.t.this.j()) {
                    new Handler(Looper.getMainLooper()).post((Runnable)new Runnable() {
                        @Override
                        public final void run() {
                            com.inmobi.media.t.this.f((byte)2);
                            com.inmobi.media.t.this.D = true;
                            com.inmobi.media.t.this.O();
                        }
                    });
                }
            }
            
            @Override
            public final void d(final o o) {
                new Handler(Looper.getMainLooper()).post((Runnable)new Runnable() {
                    @Override
                    public final void run() {
                        com.inmobi.media.t.this.f((byte)2);
                        com.inmobi.media.t.this.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), false, (byte)43);
                    }
                });
            }
            
            @Override
            public final void e(final o o) {
                if (2 == com.inmobi.media.t.this.j()) {
                    com.inmobi.media.t.this.Q();
                }
            }
            
            @Override
            public final void g(final o o) {
                if (2 == com.inmobi.media.t.this.j()) {
                    com.inmobi.media.t.this.f((byte)2);
                    com.inmobi.media.t.this.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), false, (byte)42);
                }
            }
            
            @Override
            public final it c_() {
                return com.inmobi.media.t.this.y;
            }
        };
        this.x = new WeakReference<Context>(referent);
        this.o = o;
        this.A = new WeakReference<a>(referent2);
        final String f = gz.f();
        this.c = (fe)fg.a("ads", f, this);
        fg.a("pk", f, null);
        final ip c;
        final it it;
        this.y = (("AerServ".equals(this.o.a()) && (it = (((c = ir.c()) != null) ? c.f() : null)) != null) ? it : this.c.timeouts);
        this.b = 0;
        this.z = new as(this, this, this.o);
        this.C = new HashMap<Integer, Set<de>>();
        this.h = -1;
        this.i = new Handler(Looper.getMainLooper());
        this.j = false;
        this.F = new cu(this);
    }
    
    final void a(@NonNull final Context context, @NonNull final aq o, @Nullable final a a) {
        this.a(context);
        this.a(a);
        this.o = o;
    }
    
    @WorkerThread
    @Override
    public void a(final ff ff) {
        if (ff instanceof fe) {
            this.c = (fe)ff;
        }
    }
    
    @Nullable
    public final Context h() {
        if (this.x == null) {
            return null;
        }
        return this.x.get();
    }
    
    public void a(final Context referent) {
        this.x = new WeakReference<Context>(referent);
    }
    
    public final aq i() {
        return this.o;
    }
    
    @UiThread
    public final byte j() {
        return this.b;
    }
    
    public abstract String k();
    
    private Set<de> e(final int i) {
        return this.C.get(i);
    }
    
    protected abstract byte l();
    
    @NonNull
    protected Map<String, String> m() {
        return new HashMap<String, String>();
    }
    
    @NonNull
    final String a(final int n) {
        if (n > 0 && !this.v) {
            return "";
        }
        if (this.b(n) == null) {
            return null;
        }
        return this.b(n).k();
    }
    
    final String n() {
        final ak u;
        if ((u = this.u()) == null) {
            return "unknown";
        }
        return u.i();
    }
    
    public final fe o() {
        return this.c;
    }
    
    @Nullable
    final a p() {
        final a a;
        if ((a = this.A.get()) == null) {
            hf.a((byte)2, "InMobi", "Listener was garbage collected. Unable to give callback");
        }
        return a;
    }
    
    public final void a(final a referent) {
        this.A = new WeakReference<a>(referent);
    }
    
    public final boolean q() {
        final ak u;
        return (u = this.u()) != null && u.a(this.c.a(this.k()).timeToLive);
    }
    
    @NonNull
    public final as r() {
        if (this.z == null) {
            this.z = new as(this, this, this.i());
        }
        return this.z;
    }
    
    @Nullable
    public h s() {
        final byte j = this.j();
        final String n = this.n();
        switch (n) {
            default: {
                return null;
            }
            case "html": {
                if (j == 0 || j || 3 == j) {
                    return null;
                }
                return this.t();
            }
            case "inmobiJson": {
                if (j == 0 || j || 3 == j || 2 == j) {
                    return null;
                }
                return this.g;
            }
        }
    }
    
    @Nullable
    public o t() {
        return this.d.get(this.s);
    }
    
    private boolean f(final int n) {
        final ak b;
        return (b = this.b(n)) != null && b.e();
    }
    
    @Nullable
    public ak u() {
        return this.b(0);
    }
    
    @Nullable
    public ak b(final int index) {
        if (index > 0) {
            if (this.p == null) {
                return null;
            }
            return this.p.b().get(index);
        }
        else {
            if (this.p == null) {
                return null;
            }
            return this.p.l();
        }
    }
    
    @Nullable
    private AdMetaInfo Y() {
        final ak u;
        if ((u = this.u()) == null) {
            return null;
        }
        return u.g();
    }
    
    final void b(@NonNull final a a) {
        final AdMetaInfo y;
        if ((y = this.Y()) == null) {
            this.a((byte)3);
            a.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
            return;
        }
        a.a(y);
    }
    
    final void c(@NonNull final a a) {
        final AdMetaInfo y;
        if ((y = this.Y()) == null) {
            a.a(this, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
            return;
        }
        a.b(y);
    }
    
    final void d(@NonNull final a a) {
        final AdMetaInfo y;
        if ((y = this.Y()) == null) {
            this.a(a, (byte)85);
            return;
        }
        a.c(y);
    }
    
    final void a(@NonNull final a a, final byte b) {
        this.c((int)b);
        a.a();
    }
    
    final boolean a(@NonNull final ak ak, final int n) {
        boolean b = false;
        try {
            final JSONObject b2 = ak.b();
            final String i = ak.i();
            if ("unknown".equals(i)) {
                return false;
            }
            final String k;
            if ((k = ak.k()).length() != 0) {
                ak.b(k.replace("@__imm_aft@", String.valueOf(System.currentTimeMillis() - this.e)));
                b = true;
            }
            if ("mediationJson".equals(i)) {
                return b;
            }
            final Context c;
            if ((c = gz.c()) == null) {
                return b;
            }
            if (this.C.get(n) == null) {
                this.C.put(n, new HashSet<de>());
            }
            final Set<de> set;
            if ((set = this.C.get(n)) != null && set.isEmpty()) {
                final Map<String, Object> a;
                final Application d;
                if (this.c.viewability.moatEnabled && b2.has("viewability") && (a = com.inmobi.media.t.b.a(b2.getJSONArray("viewability"))) != null && a.get("enabled") && (d = gz.d()) != null) {
                    dt.a(d);
                    final de de;
                    (de = new de((byte)1)).b = a;
                    set.add(de);
                }
                final JSONObject jsonObject;
                final JSONObject jsonObject2;
                if (this.c.viewability.omidConfig.omidEnabled && b2.has("metaInfo") && (jsonObject = b2.getJSONObject("metaInfo")).has("omsdkInfo") && (jsonObject2 = jsonObject.getJSONObject("omsdkInfo")).has("omidEnabled") && jsonObject2.getBoolean("omidEnabled")) {
                    String string = "unknown";
                    if (jsonObject.has("creativeType")) {
                        string = jsonObject.getString("creativeType");
                    }
                    this.i.post((Runnable)new Runnable() {
                        @Override
                        public final void run() {
                            ef.a.a.a(c.getApplicationContext(), com.inmobi.media.t.this.c);
                        }
                    });
                    final de de2 = new de((byte)3);
                    de2.b = com.inmobi.media.t.c.a(string, jsonObject2.optString("customReferenceData"), jsonObject2.optBoolean("isolateVerificationScripts"), jsonObject2.optJSONObject("macros"), (byte)jsonObject2.optInt("impressionType"));
                    set.add(de2);
                }
                final Map<String, Object> a2;
                if (b2.has("viewability") && (a2 = a(b2.getJSONArray("viewability"))) != null && !a2.isEmpty()) {
                    final de de3;
                    (de3 = new de((byte)2)).b = a2;
                    final Set<de> set2;
                    if ((set2 = this.C.get(n)) != null) {
                        set2.add(de3);
                    }
                }
                if (b2.has("tracking") && "web".equals(b2.getString("tracking"))) {
                    this.h = 0;
                }
            }
        }
        catch (JSONException ex) {
            b = false;
            fv.a().a(new gv((Throwable)ex));
            final HashMap<String, Object> hashMap;
            (hashMap = new HashMap<String, Object>()).put("errorCode", 1);
            hashMap.put("reason", ex.getMessage());
            this.b(hashMap);
        }
        catch (IllegalArgumentException ex2) {
            b = false;
            final HashMap<String, Object> hashMap2;
            (hashMap2 = new HashMap<String, Object>()).put("errorCode", 1);
            hashMap2.put("reason", ex2.getMessage());
            this.b(hashMap2);
            fv.a().a(new gv(ex2));
        }
        return b;
    }
    
    private static Map<String, Object> a(final JSONArray jsonArray) {
        try {
            JSONObject jsonObject = null;
            for (int length = jsonArray.length(), i = 0; i < length; ++i) {
                final JSONObject jsonObject2;
                if ((jsonObject2 = jsonArray.getJSONObject(i)).has("inmobi")) {
                    jsonObject = jsonObject2.getJSONObject("inmobi");
                    break;
                }
            }
            if (jsonObject != null) {
                final HashMap<String, Integer> hashMap;
                (hashMap = new HashMap<String, Integer>()).put("frame", jsonObject.optJSONArray("frame"));
                final int c;
                if ((c = c(jsonObject.optString("time"))) != -1) {
                    hashMap.put("time", c);
                }
                final int c2;
                if ((c2 = c(jsonObject.optString("view"))) != -1) {
                    hashMap.put("view", c2);
                }
                final int c3;
                if ((c3 = c(jsonObject.optString("pixel"))) != -1) {
                    hashMap.put("pixel", c3);
                }
                final int optInt;
                if ((optInt = jsonObject.optInt("type")) != -1) {
                    hashMap.put("type", optInt);
                }
                return (Map<String, Object>)hashMap;
            }
            return null;
        }
        catch (JSONException ex) {
            fv.a().a(new gv((Throwable)ex));
            return null;
        }
    }
    
    private static int c(String substring) {
        final String prefix = "track_";
        if (substring.startsWith(prefix)) {
            substring = substring.substring(prefix.length());
        }
        try {
            return Integer.parseInt(substring);
        }
        catch (NumberFormatException ex) {
            return -1;
        }
    }
    
    @UiThread
    @Override
    public void a(@NonNull final aq aq, final boolean b, final byte b2) {
        if (this.l || null == this.h()) {
            return;
        }
        if (b2 != 0) {
            this.a(b2);
        }
        this.a(aq, b);
    }
    
    @UiThread
    protected void a(@NonNull final aq aq, final boolean b) {
    }
    
    @UiThread
    final void a(@NonNull final ar ar) {
        if (this.l || null == this.h()) {
            return;
        }
        this.b(ar);
    }
    
    @UiThread
    protected void b(@NonNull final ar p) {
        if (this.j() == 1) {
            this.p = p;
            this.v = this.p.d();
            this.d = new ArrayList<o>(this.p.b().size());
            for (int i = 0; i < this.p.b().size(); ++i) {
                this.d.add(null);
            }
            final ak l;
            if ((l = p.l()) == null) {
                this.a(false, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
                return;
            }
            this.w.a(this.hashCode(), new ah(this, l, p, false, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR)));
        }
    }
    
    @UiThread
    void a(final boolean b, @NonNull final InMobiAdRequestStatus inMobiAdRequestStatus) {
        if (b) {
            this.b = 2;
            return;
        }
        this.a(inMobiAdRequestStatus, true, (byte)0);
    }
    
    @UiThread
    public void a(@NonNull final aq aq, final InMobiAdRequestStatus inMobiAdRequestStatus, final byte b) {
        if (this.l || null == this.h()) {
            return;
        }
        try {
            if (this.o.equals(aq) && this.j() == 1) {
                hf.a((byte)2, "InMobi", "Failed to fetch ad for placement id: " + this.o.toString() + ", reason phrase available in onAdLoadFailed callback.");
                inMobiAdRequestStatus.getMessage();
                this.b = 3;
                if (b != 0) {
                    this.b(b);
                }
                final a p3;
                if ((p3 = this.p()) != null) {
                    p3.a(inMobiAdRequestStatus);
                }
            }
        }
        catch (Exception ex) {
            hf.a((byte)1, "InMobi", "Unable to load Ad; SDK encountered an unexpected error");
            fv.a().a(new gv(ex));
        }
    }
    
    @UiThread
    public final void a(final InMobiAdRequestStatus inMobiAdRequestStatus, final boolean b, final byte b2) {
        if (this.j() == 1 && b) {
            this.b = 3;
        }
        final a p3;
        if ((p3 = this.p()) != null) {
            p3.a(this, inMobiAdRequestStatus);
        }
        if (com.inmobi.media.t.G.contains(b2)) {
            this.b(b2);
            return;
        }
        if (b2 != 0) {
            this.a(b2);
        }
    }
    
    @UiThread
    final void a(final boolean b) {
        try {
            final int r = this.r;
            final Context h;
            if ((h = this.h()) != null) {
                try {
                    if (null == this.d.get(r) || this.d.get(r).r.get()) {
                        final ak b2 = this.b(r);
                        final o element = new o(h, this.l(), this.C.get(r), (b2 == null) ? null : b2.f());
                        if (b2 != null) {
                            element.setLandingScheme(b2.v());
                            element.z = b2.w();
                        }
                        this.d.set(r, element);
                        if (this.o.l().equals("banner")) {
                            element.setAdSize(this.o.m());
                        }
                        element.a(this, this.o(), this.U(), true);
                        element.setAdPodHandler(this);
                        element.setPlacementId(this.o.e());
                        element.setAllowAutoRedirection(this.f(r));
                        element.setContentUrl(this.o.h());
                        final AdMetaInfo y;
                        if ((y = this.Y()) != null) {
                            element.setCreativeId(y.getCreativeID());
                        }
                        if (this.o.f()) {
                            element.a();
                        }
                    }
                }
                catch (Exception ex) {
                    this.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), false, (byte)42);
                    fv.a().a(new gv(ex));
                }
            }
            if (!b || this.e((byte)2)) {
                this.p.b().get(this.r).f();
                final o o;
                if ((o = this.d.get(this.r)) != null) {
                    o.b(this.a(this.r));
                }
                this.l(o);
            }
        }
        catch (Exception ex2) {
            this.f((byte)2);
            hf.a((byte)1, "InMobi", "Unable to load ad; SDK encountered an internal error");
            fv.a().a(new gv(ex2));
            this.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), false, (byte)42);
        }
    }
    
    public void b(final String s) {
        this.o.b(s);
    }
    
    public void a(final Map<String, String> map) {
        this.o.b(map);
    }
    
    public Map<String, String> v() {
        return this.o.c();
    }
    
    @Nullable
    Integer w() {
        return null;
    }
    
    boolean x() {
        try {
            RecyclerView.class.getName();
            Picasso.class.getName();
        }
        catch (NoClassDefFoundError noClassDefFoundError) {
            return true;
        }
        return false;
    }
    
    public void a(@NonNull final JSONObject jsonObject) {
        new Handler(Looper.getMainLooper()).post((Runnable)new Runnable() {
            @Override
            public final void run() {
                com.inmobi.media.t.this.w.a(com.inmobi.media.t.this.hashCode(), new u(com.inmobi.media.t.this, jsonObject));
            }
        });
    }
    
    @UiThread
    public void y() {
        this.f = SystemClock.elapsedRealtime();
        if (!hg.a()) {
            this.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.NETWORK_UNREACHABLE), true, (byte)5);
            return;
        }
        this.Z();
    }
    
    @UiThread
    public void a(@Nullable final byte[] array) {
        if (this.A()) {
            return;
        }
        if (array == null || array.length == 0) {
            this.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INVALID_RESPONSE_IN_LOAD), true, (byte)3);
            return;
        }
        if (this.n == null) {
            this.n = new bz(this);
        }
        this.b = 1;
        this.w.a(this.hashCode(), new ad(this, this.n, array, this.i().e()));
    }
    
    @UiThread
    final void c(@NonNull final ar ar) {
        this.a(ar);
    }
    
    public void z() {
        final a p = this.p();
        final long currentTimeMillis = System.currentTimeMillis();
        final a a = p;
        boolean b;
        if (this.m) {
            hf.a((byte)2, "InMobi", "getSignals() call is already in progress. Please wait for its execution to get complete");
            b = true;
        }
        else if (this.x()) {
            if (a != null) {
                a.b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.MISSING_REQUIRED_DEPENDENCIES));
            }
            this.a(39, currentTimeMillis);
            b = true;
        }
        else {
            b = false;
        }
        if (b) {
            return;
        }
        this.m = true;
        if (this.n == null) {
            this.n = new bz(this);
        }
        this.w.a(this.hashCode(), new z(this, currentTimeMillis));
    }
    
    @SuppressLint({ "SwitchIntDef" })
    protected final boolean A() {
        if (!hg.a()) {
            this.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.NETWORK_UNREACHABLE), true, (byte)5);
            return true;
        }
        if (!hq.h()) {
            this.D();
            this.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.GDPR_COMPLIANCE_ENFORCED), false, (byte)21);
            return true;
        }
        if (this.x()) {
            this.k();
            this.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.MISSING_REQUIRED_DEPENDENCIES), true, (byte)39);
            return true;
        }
        switch (this.b) {
            case 1: {
                this.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.LOAD_WITH_RESPONSE_CALLED_WHILE_LOADING), false, (byte)53);
                return true;
            }
            case 7: {
                this.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.AD_ACTIVE), false, (byte)15);
                return true;
            }
            default: {
                return false;
            }
        }
    }
    
    @UiThread
    private int Z() {
        try {
            this.b = 1;
            ic.a().c();
            if (this.e((byte)0)) {
                this.w.a(this.hashCode(), new s(this));
                return 0;
            }
        }
        catch (Exception ex) {
            hf.a((byte)1, "InMobi", "Unable to load ad; SDK encountered an unexpected error");
            fv.a().a(new gv(ex));
        }
        return -2;
    }
    
    final void a(final WeakReference<a> weakReference, final byte b, @NonNull final InMobiAdRequestStatus inMobiAdRequestStatus) {
        this.b = 3;
        if (this.l) {
            return;
        }
        final a a;
        if ((a = weakReference.get()) == null) {
            hf.a((byte)2, "InMobi", "Listener was garbage collected. Unable to give callback");
            return;
        }
        if ("int".equals(this.k())) {
            this.a(a, b);
            return;
        }
        this.a(b);
        a.a(this, inMobiAdRequestStatus);
    }
    
    final byte e(final a referent) {
        final WeakReference weakReference = new WeakReference((T)referent);
        try {
            final byte l = this.l();
            final JSONObject jsonObject = new JSONObject(this.a(0));
            final fe o = this.o();
            final HashMap<String, String> hashMap = (this.p == null) ? null : hg.a(this.p.m());
            final ak u;
            if ((u = this.u()) == null) {
                throw new IllegalStateException("No ad");
            }
            dc dc = null;
            if (u instanceof bb) {
                final bb bb = (bb)u;
                au.a();
                final al b;
                if ((b = au.b(bb.a)) == null || !b.a()) {
                    throw new IllegalStateException("Asset not available in cache");
                }
                dc = new dc(b.e, bb.b, bb.c, bb.d, bb.e, this.o().vastVideo);
            }
            final bn bn = new bn(l, jsonObject, o, hashMap, dc);
            final ak u2 = this.u();
            if (bn.d() && this.h() != null && u2 != null) {
                final l a;
                (a = com.inmobi.media.l.b.a(this.h(), this.l(), bn, u2.f(), this.e(0), this.o(), this.o.e(), this.f(0), u2.u())).a(new l.c() {
                    @Override
                    public final void a() {
                        if (t.this.l) {
                            return;
                        }
                        final t.a a;
                        if ((a = (t.a)weakReference.get()) != null) {
                            t.this.a(a, (byte)91);
                            return;
                        }
                        hf.a((byte)2, "InMobi", "Listener was garbage collected. Unable to give callback");
                    }
                    
                    @UiThread
                    @Override
                    public final void b() {
                        t.this.f((byte)4);
                        if (t.this.l) {
                            return;
                        }
                        t.this.i.post((Runnable)new Runnable() {
                            @Override
                            public final void run() {
                                t.this.f((t.a)weakReference.get());
                            }
                        });
                    }
                    
                    @Override
                    public final void c() {
                        if (t.this.l) {
                            return;
                        }
                        final t.a a;
                        if ((a = (t.a)weakReference.get()) != null) {
                            a.b();
                            return;
                        }
                        hf.a((byte)2, "InMobi", "Listener was garbage collected. Unable to give callback");
                    }
                    
                    @Override
                    public final void d() {
                        hf.a((byte)2, "InMobi", "Successfully impressed ad for placement id: " + t.this.o.toString());
                        if (t.this.l) {
                            return;
                        }
                        final t.a a;
                        if ((a = (t.a)weakReference.get()) != null) {
                            a.e();
                            return;
                        }
                        hf.a((byte)2, "InMobi", "Listener was garbage collected. Unable to give callback");
                    }
                    
                    @Override
                    public final void e() {
                        hf.a((byte)2, "InMobi", "Ad interaction for placement id: " + t.this.o.toString());
                        if (t.this.l) {
                            return;
                        }
                        final t.a a;
                        if ((a = (t.a)weakReference.get()) != null) {
                            a.a(new HashMap<Object, Object>());
                            return;
                        }
                        hf.a((byte)2, "InMobi", "Listener was garbage collected. Unable to give callback");
                    }
                    
                    @Override
                    public final void f() {
                        if (t.this.l) {
                            return;
                        }
                        hf.a((byte)2, "InMobi", "Ad dismissed for placement id: " + t.this.o.toString());
                        t.this.i.post((Runnable)new Runnable() {
                            @Override
                            public final void run() {
                                t.this.g((t.a)weakReference.get());
                            }
                        });
                    }
                    
                    @Override
                    public final void a(final Map<String, String> m) {
                        if (t.this.l) {
                            return;
                        }
                        final t.a a;
                        if ((a = (t.a)weakReference.get()) != null) {
                            a.b(new HashMap<Object, Object>(m));
                            return;
                        }
                        hf.a((byte)2, "InMobi", "Listener was garbage collected. Unable to give callback");
                    }
                    
                    @Override
                    public final void g() {
                        if (t.this.l) {
                            return;
                        }
                        final t.a a;
                        if ((a = (t.a)weakReference.get()) != null) {
                            a.d();
                            return;
                        }
                        hf.a((byte)2, "InMobi", "Listener was garbage collected. Unable to give callback");
                    }
                    
                    @Override
                    public final void h() {
                        if (t.this.l) {
                            return;
                        }
                        final t.a a;
                        if ((a = (t.a)weakReference.get()) != null) {
                            a.f();
                            return;
                        }
                        hf.a((byte)2, "InMobi", "Listener was garbage collected. Unable to give callback");
                    }
                    
                    @Override
                    public final void i() {
                        if (t.this.l) {
                            return;
                        }
                        final t.a a;
                        if ((a = (t.a)weakReference.get()) != null) {
                            a.h();
                            return;
                        }
                        hf.a((byte)2, "InMobi", "Listener was garbage collected. Unable to give callback");
                    }
                    
                    @Override
                    public final void a(final boolean b) {
                        if (t.this.l) {
                            return;
                        }
                        final t.a a;
                        if ((a = (t.a)weakReference.get()) != null) {
                            a.a(b);
                            return;
                        }
                        hf.a((byte)2, "InMobi", "Listener was garbage collected. Unable to give callback");
                    }
                });
                this.g = a;
                return 0;
            }
            return 20;
        }
        catch (JSONException ex) {
            fv.a().a(new gv((Throwable)ex));
            return 13;
        }
        catch (IllegalStateException ex3) {
            return 83;
        }
        catch (Exception ex2) {
            fv.a().a(new gv(ex2));
            return 88;
        }
    }
    
    @UiThread
    void f(final a a) {
    }
    
    @UiThread
    void g(final a a) {
    }
    
    final void B() {
        final h s;
        if ((s = this.s()) == null) {
            return;
        }
        s.a((byte)2, null);
    }
    
    @WorkerThread
    @NonNull
    public cc C() {
        final String url = this.c.url;
        final id id = new id(this.c.f());
        au.a();
        final cc cc;
        (cc = new cc(url, id, au.e(), this.o)).c = this.o.d();
        cc.b = this.k();
        cc.a = "unifiedSdkJson";
        cc.d = this.m();
        cc.m = this.c.fetchTimeout * 1000;
        cc.n = this.c.fetchTimeout * 1000;
        cc.a(this.c.rendering.enablePubMuteControl && gz.e());
        cc.f = this.o.g();
        return cc;
    }
    
    @UiThread
    public void D() {
        if (this.l) {
            return;
        }
        this.l = true;
        this.E();
        this.C.clear();
        this.F();
        this.b = 0;
        this.w.a(this.hashCode());
        this.D = false;
        this.E = null;
        this.j = false;
        this.k = false;
        this.m = false;
        this.p = null;
        this.v = false;
    }
    
    protected final void E() {
        if (this.v) {
            this.X();
            this.d.clear();
            this.r = 0;
            this.s = 0;
            this.u.clear();
        }
    }
    
    @UiThread
    @CallSuper
    void F() {
        if (this.g != null) {
            this.g.destroy();
            this.g = null;
        }
        if (this.s >= 0 && this.d.size() > this.s && this.d.get(this.s) != null) {
            this.d(this.s);
        }
    }
    
    @Override
    public final void c(final o o) {
        if (this.l || null == this.h()) {
            return;
        }
        this.i.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                com.inmobi.media.t.this.j(o);
            }
        });
    }
    
    @UiThread
    protected void j(final o o) {
        this.d.indexOf(o);
    }
    
    @Override
    public final void d(final o o) {
        if (this.l || null == this.h()) {
            return;
        }
        this.i.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                com.inmobi.media.t.this.k(o);
            }
        });
    }
    
    @UiThread
    protected void k(final o o) {
        this.d.indexOf(o);
        this.a((byte)22);
    }
    
    @Override
    public void e(final o o) {
        this.d.indexOf(o);
    }
    
    @Override
    public void f(final o o) {
        this.d.indexOf(o);
    }
    
    @WorkerThread
    @Override
    public void a(final String h) {
        if (this.v) {
            this.H = h;
        }
    }
    
    @WorkerThread
    @Nullable
    @Override
    public String e() {
        if (this.v) {
            return this.H;
        }
        return null;
    }
    
    @Override
    public void a() {
        if (this.l || null == this.h()) {
            return;
        }
        this.i.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                if (6 == com.inmobi.media.t.this.j()) {
                    com.inmobi.media.t.this.b = 3;
                    if (com.inmobi.media.t.this.p() != null) {
                        com.inmobi.media.t.this.a(com.inmobi.media.t.this.p(), (byte)92);
                    }
                }
            }
        });
    }
    
    @Override
    public void g(final o o) {
        if (this.l || null == this.h()) {
            return;
        }
        try {
            this.i.post((Runnable)new Runnable() {
                @Override
                public final void run() {
                    com.inmobi.media.t.this.G();
                }
            });
        }
        catch (Exception ex) {
            hf.a((byte)1, "InMobi", "Unable to load ad; SDK encountered an internal error");
        }
    }
    
    @UiThread
    protected void G() {
        if (2 == this.j()) {
            this.f((byte)2);
            this.b = 3;
            this.a((byte)42);
            if (this.p() != null) {
                this.p().a(this, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
            }
        }
    }
    
    @Override
    public void b(@NonNull final HashMap<Object, Object> hashMap) {
        if (this.l || null == this.h()) {
            return;
        }
        if (this.p() != null) {
            this.p().b(hashMap);
        }
    }
    
    @Override
    public void a(@NonNull final HashMap<Object, Object> hashMap) {
        if (this.l || null == this.h()) {
            return;
        }
        if (this.p() != null) {
            this.p().a(hashMap);
        }
    }
    
    @Override
    public void a_() {
        if (this.l || null == this.h()) {
            return;
        }
        if (this.p() != null) {
            this.p().d();
        }
    }
    
    @UiThread
    void a(@NonNull final InMobiAdRequestStatus inMobiAdRequestStatus) {
        if (this.H()) {
            try {
                final o m;
                if ((m = this.M()) != null) {
                    m.stopLoading();
                    return;
                }
                final h s;
                if ((s = this.s()) instanceof o) {
                    ((o)s).stopLoading();
                }
            }
            catch (Exception ex) {
                fv.a().a(new gv(ex));
            }
            this.b = 3;
            this.a((byte)41);
            if (this.p() != null) {
                this.p().a(this, inMobiAdRequestStatus);
            }
        }
    }
    
    protected boolean H() {
        return this.j() == 2;
    }
    
    final void I() {
        final HashMap<String, Object> hashMap;
        (hashMap = new HashMap<String, Object>()).put("latency", SystemClock.elapsedRealtime() - this.f);
        this.c(hashMap);
        this.c("AdLoadSuccessful", hashMap);
    }
    
    private void c(final Map<String, Object> map) {
        map.put("adType", this.k());
        map.put("networkType", hn.b());
        map.put("plId", this.o.e());
        map.put("plType", this.o.p());
    }
    
    final void a(final byte b) {
        final HashMap<String, Byte> hashMap;
        (hashMap = new HashMap<String, Byte>()).put("latency", (Byte)(Object)Long.valueOf(SystemClock.elapsedRealtime() - this.f));
        hashMap.put("errorCode", b);
        this.c((Map<String, Object>)hashMap);
        this.d((Map<String, Object>)hashMap);
        this.c("AdLoadFailed", (Map<String, Object>)hashMap);
    }
    
    final void J() {
        final HashMap<String, Object> hashMap = new HashMap<String, Object>();
        this.c(hashMap);
        this.c("AdLoadCalled", hashMap);
    }
    
    final void b(final byte b) {
        final HashMap<String, Object> hashMap;
        (hashMap = new HashMap<String, Object>()).put("errorCode", b);
        this.c(hashMap);
        this.c("AdLoadDroppedAtSDK", hashMap);
    }
    
    final void b(final Map<String, Object> map) {
        if (this.z == null) {
            return;
        }
        if (map.get("reason") == null) {
            map.put("reason", "");
        }
        this.d(map);
        this.z.a(map);
    }
    
    final void a(final int i, final long n) {
        this.m = false;
        final HashMap<String, Long> hashMap;
        (hashMap = new HashMap<String, Long>()).put("adType", (Long)this.k());
        hashMap.put("latency", System.currentTimeMillis() - n);
        hashMap.put("networkType", (Long)hn.b());
        hashMap.put("errorCode", Long.valueOf(Integer.valueOf(i)));
        this.c("AdGetSignalsFailed", (Map<String, Object>)hashMap);
    }
    
    public void K() {
        this.B = SystemClock.elapsedRealtime();
        final HashMap<String, Object> hashMap = new HashMap<String, Object>();
        this.c(hashMap);
        this.c("AdShowCalled", hashMap);
    }
    
    public void L() {
        final HashMap<String, Object> hashMap;
        (hashMap = new HashMap<String, Object>()).put("latency", SystemClock.elapsedRealtime() - this.B);
        this.c(hashMap);
        this.c("AdShowSuccessful", hashMap);
    }
    
    final void c(final int i) {
        final HashMap<String, Integer> hashMap;
        (hashMap = new HashMap<String, Integer>()).put("latency", (Integer)(Object)Long.valueOf(SystemClock.elapsedRealtime() - this.B));
        hashMap.put("errorCode", i);
        this.c((Map<String, Object>)hashMap);
        this.d((Map<String, Object>)hashMap);
        this.c("AdShowFailed", (Map<String, Object>)hashMap);
    }
    
    private void d(final Map<String, Object> map) {
        final ak u;
        if ((u = this.u()) != null) {
            map.put("creativeId", "\"" + u.u() + "\"");
            map.put("impressionId", "\"" + u.f() + "\"");
        }
    }
    
    @Override
    public void a(final String s, final Map<String, Object> map) {
        this.c(s, map);
    }
    
    @Override
    public final void b(final String s, final Map<String, Object> map) {
        this.c(s, map);
    }
    
    public void c(final String s, final Map<String, Object> map) {
        gw.a().a(s, map);
    }
    
    final void a(@NonNull final ak ak) {
        final Context h = this.h();
        if (!this.o().viewability.omidConfig.omidEnabled || !ef.a.a.a()) {
            return;
        }
        final boolean b = ak instanceof bb;
        for (final de de : this.e(0)) {
            if (3 == de.a) {
                if ("video" == de.b.get("creativeType") && b) {
                    final bb bb = (bb)ak;
                    final Context context = h;
                    final de de2 = de;
                    final Context context2 = context;
                    final bb bb2 = bb;
                    try {
                        final bn bn;
                        final bw bw = (bn = new bn(this.l(), new JSONObject(this.a(0)), this.o(), (this.p == null) ? null : hg.a(this.p.m()), new dc(bb2.a, bb2.b, bb2.c, bb2.d, bb2.e, this.o().vastVideo))).c("VIDEO").get(0);
                        if (context2 == null) {
                            continue;
                        }
                        final ArrayList<VerificationScriptResource> list = new ArrayList<VerificationScriptResource>();
                        for (final bv bv : bw.u) {
                            if ("OMID_VIEWABILITY".equals(bv.d) && bv instanceof ea) {
                                final ea ea = (ea)bv;
                                final Map map = de2.a("macros", Map.class);
                                final String d = d(ea.g, map);
                                final String h2 = ea.h;
                                final String d2 = d(ea.b, map);
                                VerificationScriptResource verificationScriptResource;
                                if (!TextUtils.isEmpty((CharSequence)d) && !TextUtils.isEmpty((CharSequence)h2)) {
                                    verificationScriptResource = VerificationScriptResource.createVerificationScriptResourceWithParameters(h2, new URL(d2), d);
                                }
                                else {
                                    verificationScriptResource = VerificationScriptResource.createVerificationScriptResourceWithoutParameters(new URL(d2));
                                }
                                list.add(verificationScriptResource);
                            }
                        }
                        if (list.size() == 0) {
                            continue;
                        }
                        final bj a;
                        if ((a = a(bn)) != null) {
                            de2.b.put("videoSkippable", Boolean.TRUE);
                            de2.b.put("videoSkipOffset", a.o);
                        }
                        else {
                            de2.b.put("videoSkippable", Boolean.FALSE);
                            de2.b.put("videoSkipOffset", 0);
                        }
                        de2.b.put("videoAutoPlay", bw.v.get("shouldAutoPlay"));
                        de2.b.put("omidAdSession", ee.a(list, de2.b.get("creativeType"), this.o.h()));
                        de2.b.put("deferred", Boolean.TRUE);
                    }
                    catch (Exception ex) {
                        fv.a().a(new gv(ex));
                    }
                }
                else {
                    this.a(h, de);
                }
            }
        }
    }
    
    private void a(final Context context, final de de) {
        try {
            final bj bj = new bn(this.l(), new JSONObject(this.a(0)), this.o(), (this.p == null) ? null : hg.a(this.p.m()), null).c("CONTAINER").get(0);
            if (context != null) {
                final ArrayList<VerificationScriptResource> list = new ArrayList<VerificationScriptResource>();
                for (final bv bv : bj.u) {
                    if ("OMID_VIEWABILITY".equals(bv.d) && bv instanceof ea) {
                        final ea ea = (ea)bv;
                        final Map map = de.a("macros", Map.class);
                        final String d = d(ea.g, map);
                        final String h = ea.h;
                        final String d2 = d(ea.b, map);
                        VerificationScriptResource verificationScriptResource;
                        if (!TextUtils.isEmpty((CharSequence)d) && !TextUtils.isEmpty((CharSequence)h)) {
                            verificationScriptResource = VerificationScriptResource.createVerificationScriptResourceWithParameters(h, new URL(d2), d);
                        }
                        else {
                            verificationScriptResource = VerificationScriptResource.createVerificationScriptResourceWithoutParameters(new URL(d2));
                        }
                        list.add(verificationScriptResource);
                    }
                }
                if (list.size() == 0) {
                    return;
                }
                de.b.put("omidAdSession", ed.a(list, this.o.h(), de.b.get("creativeType")));
                de.b.put("deferred", Boolean.TRUE);
            }
        }
        catch (Exception ex) {
            fv.a().a(new gv(ex));
        }
    }
    
    private static bj a(final bn bn) {
        final Iterator<String> iterator = bn.e().iterator();
        while (iterator.hasNext()) {
            final bj bj = bn.c(iterator.next()).get(0);
            if (2 == bj.l) {
                return bj;
            }
        }
        return null;
    }
    
    final void l(final o o) {
        if (!this.o().viewability.omidConfig.omidEnabled || !ef.a.a.a()) {
            return;
        }
        for (final de de : this.e(this.d.indexOf(o))) {
            if (3 == de.a) {
                try {
                    final dy a;
                    if ((a = ec.a(de.a("creativeType", String.class), o, de.a("isolateVerificationScripts", Boolean.class), this.o.h(), de.a("impressionType", Byte.class), de.a("customReferenceData", String.class))) == null) {
                        continue;
                    }
                    de.b.put("omidAdSession", a);
                    de.b.put("deferred", Boolean.TRUE);
                }
                catch (Exception ex) {
                    fv.a().a(new gv(ex));
                }
            }
        }
    }
    
    @Nullable
    private static String d(String replace, final Map map) {
        if (map == null || replace == null) {
            return replace;
        }
        for (final Object next : map.keySet()) {
            replace = replace.replace(next.toString(), map.get(next).toString());
        }
        return replace;
    }
    
    public o M() {
        return this.E;
    }
    
    @Override
    public void a(final String s, final String s2) {
        this.w.a(this.hashCode(), new v<t>(this) {
            @Override
            public final void a() {
                final t t;
                if ((t = this.f.get()) != null) {
                    final ak u;
                    if ((u = t.u()) != null && s != null && u.f().equals(s2)) {
                        com.inmobi.media.t.a(t, u, s);
                        final String a = com.inmobi.media.t.a;
                        return;
                    }
                    final String a2 = com.inmobi.media.t.a;
                }
            }
        });
    }
    
    @Override
    public void a(final String s, final String s2, @NonNull final j j, final String s3) {
        this.w.a(this.hashCode(), new v<t>(this) {
            @Override
            public final void a() {
                final t t;
                if ((t = this.f.get()) != null) {
                    try {
                        final ak u;
                        if ((u = t.u()) != null && u.f().equals(s3)) {
                            j.a(s, s2, u.c());
                            final String a = com.inmobi.media.t.a;
                            return;
                        }
                        final String a2 = com.inmobi.media.t.a;
                        j.a(s, s2, "");
                    }
                    catch (Exception ex) {
                        final String a3 = com.inmobi.media.t.a;
                        fv.a().a(new gv(ex));
                    }
                }
            }
        });
    }
    
    final void N() {
        this.w.a(this.hashCode(), new v<t>(this) {
            @Override
            public final void a() {
                final t t;
                if ((t = this.f.get()) != null) {
                    try {
                        com.inmobi.media.t.this.i.post((Runnable)new Runnable() {
                            final /* synthetic */ bn a = new bn(t.l(), new JSONObject(t.a(0)), t.o(), (t.p == null) ? null : hg.a(t.p.m()), null);
                            
                            @Override
                            public final void run() {
                                try {
                                    final bx k = this.a.k;
                                    final ak u = com.inmobi.media.t.this.u();
                                    if (k != null && com.inmobi.media.t.this.h() != null && u != null) {
                                        final t a;
                                        com.inmobi.media.t.this.E = new o(com.inmobi.media.t.this.h(), com.inmobi.media.t.this.l(), com.inmobi.media.t.b(com.inmobi.media.t.this), ((a = com.inmobi.media.t.this).p == null) ? null : a.p.e());
                                        com.inmobi.media.t.this.E.a(com.inmobi.media.t.this.I, com.inmobi.media.t.this.o(), com.inmobi.media.t.this.U(), false);
                                        com.inmobi.media.t.this.E.i = true;
                                        com.inmobi.media.t.this.E.setBlobProvider(com.inmobi.media.t.this);
                                        com.inmobi.media.t.this.E.setIsPreload(true);
                                        com.inmobi.media.t.this.E.setPlacementId(com.inmobi.media.t.this.o.e());
                                        com.inmobi.media.t.this.E.setCreativeId(u.u());
                                        com.inmobi.media.t.this.E.setAllowAutoRedirection(com.inmobi.media.t.e(com.inmobi.media.t.this));
                                        com.inmobi.media.t.this.E.setShouldFireRenderBeacon(false);
                                        if (com.inmobi.media.t.this.h == 0) {
                                            com.inmobi.media.t.this.l(com.inmobi.media.t.this.E);
                                        }
                                        if (!com.inmobi.media.t.this.e((byte)2)) {
                                            return;
                                        }
                                        if ("URL".equals(k.z)) {
                                            com.inmobi.media.t.this.E.c((String)k.e);
                                            return;
                                        }
                                        com.inmobi.media.t.this.E.b((String)k.e);
                                    }
                                }
                                catch (Exception ex) {
                                    final String a2 = com.inmobi.media.t.a;
                                    com.inmobi.media.t.this.b = 3;
                                    com.inmobi.media.t.this.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), false, (byte)76);
                                    fv.a().a(new gv(ex));
                                }
                            }
                        });
                    }
                    catch (Exception ex) {
                        final String a = com.inmobi.media.t.a;
                        t.b = 3;
                        t.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), false, (byte)76);
                        fv.a().a(new gv(ex));
                    }
                }
            }
            
            @Override
            public final void b() {
                super.b();
                final t t;
                if ((t = this.f.get()) != null) {
                    t.b = 3;
                    t.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.LOW_MEMORY), false, (byte)40);
                }
            }
        });
    }
    
    final void O() {
        if (this.j && this.k && this.D) {
            this.P();
        }
    }
    
    void P() {
    }
    
    void Q() {
    }
    
    @UiThread
    public void b(@NonNull final InMobiAdRequestStatus inMobiAdRequestStatus) {
        final ak ak;
        if ((ak = ((this.p == null) ? null : this.p.k())) == null) {
            final a p;
            if ((p = this.p()) != null) {
                p.a(this, false, inMobiAdRequestStatus);
            }
            return;
        }
        this.w.a(this.hashCode(), new ah(this, ak, this.p, true, inMobiAdRequestStatus));
    }
    
    @UiThread
    final void b(final boolean b, @NonNull final InMobiAdRequestStatus inMobiAdRequestStatus) {
        if (b) {
            this.b = 2;
        }
        final a p2;
        if ((p2 = this.p()) != null) {
            p2.a(this, b, inMobiAdRequestStatus);
        }
    }
    
    final boolean R() {
        final ak u;
        if ((u = this.u()) != null && 4 == this.j() && !this.q()) {
            final a p;
            if ((p = this.p()) != null) {
                this.c(p);
            }
            return true;
        }
        if (u == null || 2 != this.j() || this.q()) {
            this.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.AD_NO_LONGER_AVAILABLE), true, (byte)49);
            return true;
        }
        return false;
    }
    
    @UiThread
    public abstract void S();
    
    final void T() throws IllegalStateException {
        final ak aa;
        if ((aa = this.aa()) == null) {
            throw new IllegalStateException("Unable to get topAd");
        }
        final String i = aa.i();
        switch (i) {
            default: {
                aa.i();
                throw new IllegalStateException("Can not handle fallback for markup type: " + aa.i());
            }
            case "html": {
                break;
            }
            case "inmobiJson": {
                aa.f();
                if (this.p != null) {
                    this.p.a(this.c, this);
                    break;
                }
                break;
            }
        }
        final List<String> c = aa.c("win_beacon");
        if (this.v) {
            for (int j = 1; j < this.p.b().size(); ++j) {
                final List<String> c2;
                if ((c2 = this.p.b().get(j).c("win_beacon")) != null) {
                    c.addAll(c2);
                }
            }
        }
        if (c == null) {
            return;
        }
        final Iterator<String> iterator = c.iterator();
        while (iterator.hasNext()) {
            ba.a().a(iterator.next(), true);
        }
    }
    
    @Nullable
    private ak aa() {
        final ak u;
        if ((u = this.u()) == null) {
            return null;
        }
        if (this.q()) {
            return null;
        }
        return u;
    }
    
    @UiThread
    @Override
    public void a(final ak ak, final boolean b, final byte b2) {
        final ak aa;
        if ((aa = this.aa()) == null) {
            return;
        }
        aa.f();
        final String i = aa.i();
        switch (i) {
            default: {
                aa.i();
                throw new IllegalStateException("Can not handle fallback for markup type: " + aa.i());
            }
            case "html": {}
            case "inmobiJson": {
                if (this.j() == 2 && this.p != null) {
                    this.p.a(ak);
                    final as r = this.r();
                    final String h = this.p.h();
                    final as as = r;
                    if (ak != null) {
                        final Set<bd> h2;
                        if ((h2 = ak.h()).size() == 0) {
                            as.a.a(as.b, true, (byte)0);
                            return;
                        }
                        final am am = new am(UUID.randomUUID().toString(), h, h2, as.d);
                        final aw a = aw.a();
                        a.a.execute(new Runnable() {
                            final /* synthetic */ String b = ak.a();
                            
                            @Override
                            public final void run() {
                                aw.a(a, am);
                                aw.e();
                                am.b.size();
                                final ArrayList<String> list = new ArrayList<String>();
                                final ArrayList<String> list2 = new ArrayList<String>();
                                final Iterator<bd> iterator = am.b.iterator();
                                while (iterator.hasNext()) {
                                    final bd bd;
                                    if ((bd = iterator.next()).b.trim().length() > 0 && bd.a == 2) {
                                        list.add(bd.b);
                                    }
                                    else {
                                        list2.add(bd.b);
                                    }
                                }
                                aw.a(a, list, this.b);
                                aw.e(a);
                                aw.f(a);
                                final Iterator<Object> iterator2 = list2.iterator();
                                while (iterator2.hasNext()) {
                                    aw.b(a, iterator2.next());
                                }
                            }
                        });
                    }
                }
            }
        }
    }
    
    protected final boolean U() {
        final ak u;
        return (u = this.u()) != null && u.s();
    }
    
    @UiThread
    @Override
    public void f() {
        this.f((byte)4);
        final a p;
        if ((p = this.p()) != null) {
            p.k();
            p.e();
        }
    }
    
    @WorkerThread
    @Override
    public int a(final o o) {
        if (this.v) {
            return this.d.indexOf(o);
        }
        return -1;
    }
    
    @WorkerThread
    @Override
    public void b(final int s, final o o) {
        this.d.indexOf(o);
        if (s >= 0) {
            this.s = s;
            return;
        }
        ++this.s;
    }
    
    @WorkerThread
    @Override
    public long b_() {
        if (this.v) {
            return System.currentTimeMillis() - this.t;
        }
        return -1L;
    }
    
    @WorkerThread
    @Override
    public long d() {
        if (this.v) {
            return this.t;
        }
        return -1L;
    }
    
    @NonNull
    @WorkerThread
    @Override
    public JSONArray c() {
        final JSONArray jsonArray = new JSONArray();
        final Iterator<Integer> iterator = this.u.iterator();
        while (iterator.hasNext()) {
            jsonArray.put((int)iterator.next());
        }
        return jsonArray;
    }
    
    @CallSuper
    @Override
    public void g() {
        this.i.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                final a p;
                if ((com.inmobi.media.t.this.j() == 6 || com.inmobi.media.t.this.j() == 7) && (p = com.inmobi.media.t.this.p()) != null) {
                    p.j();
                }
            }
        });
    }
    
    @UiThread
    @Override
    public void c(final byte b) {
        switch (b) {
            case 0: {
                this.a(this.o, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.REQUEST_TIMED_OUT), (byte)7);
            }
            case 1: {
                if (2 == this.j()) {
                    this.b = 3;
                    final a p;
                    if ((p = this.p()) != null) {
                        p.b(this, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
                    }
                    this.a((byte)47);
                    return;
                }
                break;
            }
            case 4: {
                final a p2;
                if ((p2 = this.p()) != null) {
                    p2.i();
                    return;
                }
                break;
            }
            case 2: {
                this.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
                break;
            }
        }
    }
    
    @Override
    public void d(final byte b) {
        switch (b) {
            case 0: {
                this.a(this.o, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.LOW_MEMORY), (byte)56);
            }
            case 1: {
                if (2 == this.j()) {
                    this.b = 3;
                    final a p;
                    if ((p = this.p()) != null) {
                        p.b(this, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.LOW_MEMORY));
                    }
                    this.a((byte)40);
                    return;
                }
                break;
            }
            case 4: {
                final a p2;
                if ((p2 = this.p()) != null) {
                    p2.i();
                    return;
                }
                break;
            }
            case 2: {
                this.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.LOW_MEMORY));
                break;
            }
        }
    }
    
    @SuppressLint({ "SwitchIntDef" })
    @UiThread
    final boolean e(final byte b) {
        long n = 0L;
        switch (b) {
            case 0: {
                n = this.y.c();
                break;
            }
            case 1: {
                n = this.y.f();
                break;
            }
            case 2: {
                n = this.y.i();
                break;
            }
            case 4: {
                n = this.y.g();
                break;
            }
            default: {
                return false;
            }
        }
        return this.F != null && this.F.a(b, n);
    }
    
    @UiThread
    final void f(final byte b) {
        if (this.F != null) {
            this.F.a(b);
        }
    }
    
    @Override
    public it c_() {
        return this.y;
    }
    
    public boolean V() {
        return this.q;
    }
    
    public void W() {
        this.q = false;
    }
    
    @UiThread
    final void X() {
        for (int i = 0; i < this.d.size(); ++i) {
            this.d(i);
        }
    }
    
    @UiThread
    final void d(final int n) {
        if (this.d.size() > n && this.d.get(n) != null) {
            this.d.get(n).stopLoading();
            this.d.get(n).destroy();
            this.d.set(n, null);
        }
    }
    
    public void a(final int n, final boolean b, final int n2) {
        final o o;
        if (n > 0 && this.d.size() > n && (o = this.d.get(n2)) != null) {
            o.d(b);
        }
        if (!b) {
            this.s = n2;
        }
    }
    
    @Override
    public void h(final o o) {
        super.h(o);
        final ak b;
        if ((b = this.b(this.d.indexOf(o))) != null && b.w() != null && b.w().equals("video")) {
            return;
        }
        if (b != null) {
            final List<String> c;
            if ((c = b.c("click")) == null) {
                return;
            }
            final Iterator<String> iterator = c.iterator();
            while (iterator.hasNext()) {
                ba.a().a(iterator.next(), true);
            }
        }
    }
    
    @Override
    public void i(final o o) {
        super.i(o);
        final ak b;
        if ((b = this.b(this.d.indexOf(o))) != null && b.w() != null && b.w().equals("video")) {
            return;
        }
        if (b != null) {
            final List<String> c;
            if ((c = b.c("impression")) == null) {
                return;
            }
            final Iterator<String> iterator = c.iterator();
            while (iterator.hasNext()) {
                ba.a().a(iterator.next(), true);
            }
        }
    }
    
    static /* synthetic */ void a(final t t, final ak ak, final String s) {
        ak.a(s);
        if (t.p != null) {
            t.p.a(ak);
        }
    }
    
    static /* synthetic */ Set b(final t t) {
        return t.e(0);
    }
    
    static /* synthetic */ boolean e(final t t) {
        return t.f(0);
    }
    
    static {
        a = t.class.getSimpleName();
        t.G = new HashSet<Byte>(Arrays.asList(5, 53, 16, 39, 21));
    }
    
    public abstract static class a
    {
        public void a(@NonNull final AdMetaInfo adMetaInfo) {
        }
        
        public void a(@NonNull final InMobiAdRequestStatus inMobiAdRequestStatus) {
        }
        
        public void a(@NonNull final t t, final boolean b, @NonNull final InMobiAdRequestStatus inMobiAdRequestStatus) {
        }
        
        public void b(@NonNull final AdMetaInfo adMetaInfo) {
        }
        
        public void a(final t t, final InMobiAdRequestStatus inMobiAdRequestStatus) {
        }
        
        public void a() {
        }
        
        public void b() {
        }
        
        public void c(@NonNull final AdMetaInfo adMetaInfo) {
        }
        
        public void c() {
        }
        
        public void a(@NonNull final Map<Object, Object> map) {
        }
        
        public void d() {
        }
        
        public void b(@NonNull final Map<Object, Object> map) {
        }
        
        public void e() {
        }
        
        public void f() {
        }
        
        public boolean g() {
            return true;
        }
        
        public void h() {
        }
        
        public void a(final byte[] array) {
        }
        
        public void b(final InMobiAdRequestStatus inMobiAdRequestStatus) {
        }
        
        public void a(@NonNull final aq aq, @NonNull final ar ar) {
        }
        
        public void a(final boolean b) {
        }
        
        public void b(final t t, final InMobiAdRequestStatus inMobiAdRequestStatus) {
        }
        
        public void i() {
        }
        
        public void j() {
        }
        
        public void k() {
        }
        
        @UiThread
        public void a(final int n, final int n2, final o o) {
        }
    }
    
    public static final class b
    {
        @NonNull
        public static HashMap<String, String> a(@NonNull final String str, @NonNull final String str2, final JSONArray jsonArray, final JSONArray jsonArray2, final JSONObject jsonObject) {
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            try {
                if (jsonArray != null) {
                    for (int length = jsonArray.length(), i = 0; i < length; ++i) {
                        hashMap.put(str + (i + 1), jsonArray.getString(i));
                    }
                }
                if (jsonArray2 != null) {
                    for (int length2 = jsonArray2.length(), j = 0; j < length2; ++j) {
                        hashMap.put(str2 + (j + 1), jsonArray2.getString(j));
                    }
                }
                if (jsonObject != null) {
                    final Iterator keys = jsonObject.keys();
                    while (keys.hasNext()) {
                        final String key = keys.next();
                        hashMap.put(key, jsonObject.optString(key));
                    }
                }
            }
            catch (Exception ex) {
                final String a = t.a;
                fv.a().a(new gv(ex));
            }
            return hashMap;
        }
        
        @Nullable
        static Map<String, Object> a(@NonNull final JSONArray jsonArray) {
            try {
                JSONObject jsonObject = null;
                for (int length = jsonArray.length(), i = 0; i < length; ++i) {
                    final JSONObject jsonObject2;
                    if ((jsonObject2 = jsonArray.getJSONObject(i)).has("moat")) {
                        jsonObject = jsonObject2.getJSONObject("moat");
                        break;
                    }
                }
                if (jsonObject != null) {
                    final HashMap<String, Boolean> hashMap;
                    (hashMap = (HashMap<String, Boolean>)new HashMap<String, JSONObject>()).put("enabled", (JSONObject)jsonObject.getBoolean("enabled"));
                    hashMap.put("instrumentVideo", (JSONObject)jsonObject.optBoolean("instrumentVideo", false));
                    hashMap.put("partnerCode", (JSONObject)jsonObject.optString("partnerCode", (String)null));
                    hashMap.put("clientLevels", (JSONObject)jsonObject.optJSONArray("clientLevels"));
                    hashMap.put("clientSlicers", (JSONObject)jsonObject.optJSONArray("clientSlicers"));
                    hashMap.put("zMoatExtras", jsonObject.optJSONObject("zMoatExtras"));
                    return (Map<String, Object>)hashMap;
                }
                return null;
            }
            catch (JSONException ex) {
                final String a = t.a;
                fv.a().a(new gv((Throwable)ex));
                return null;
            }
        }
    }
    
    public static final class c
    {
        static Map<String, Object> a(String s, String s2, final boolean b, final JSONObject jsonObject, final byte b2) {
            final HashMap<String, String> hashMap = (HashMap<String, String>)new HashMap<String, Boolean>();
            switch (s) {
                default: {
                    s = "unknown";
                    break;
                }
                case "nonvideo": {
                    s = "nonvideo";
                    break;
                }
                case "video": {
                    s = "video";
                    break;
                }
            }
            hashMap.put("creativeType", (Boolean)s);
            hashMap.put("customReferenceData", (Boolean)s2);
            hashMap.put("impressionType", (Boolean)(Object)Byte.valueOf(b2));
            final HashMap hashMap2 = new HashMap<String, String>();
            if (jsonObject != null) {
                final Iterator keys = jsonObject.keys();
                while (keys.hasNext()) {
                    s2 = keys.next();
                    hashMap2.put(s2, jsonObject.optString(s2));
                }
            }
            hashMap.put("macros", (Boolean)hashMap2);
            hashMap.put("isolateVerificationScripts", Boolean.valueOf(b));
            return (Map<String, Object>)hashMap;
        }
    }
}

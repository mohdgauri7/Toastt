// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.LinkedList;
import java.util.Collections;
import java.util.Collection;
import android.graphics.Point;
import java.util.ArrayList;
import android.text.TextUtils;
import java.util.Locale;
import android.webkit.URLUtil;
import java.util.Iterator;
import org.json.JSONException;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import androidx.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

public class bn
{
    private static final String m;
    private JSONObject n;
    public byte a;
    public boolean b;
    public boolean c;
    private JSONObject o;
    public bl d;
    public JSONArray e;
    @Nullable
    public bn f;
    @Nullable
    public Map<String, String> g;
    private Map<String, List<bj>> p;
    private Map<String, bj> q;
    private Map<String, String> r;
    @Nullable
    public dc h;
    private fe s;
    private int t;
    public a i;
    public boolean j;
    public bx k;
    private boolean u;
    @Nullable
    HashMap<String, String> l;
    
    public bn() {
        this.f = null;
    }
    
    public bn(final int n, @NonNull final JSONObject jsonObject, @NonNull final fe fe, @Nullable final HashMap<String, String> hashMap, @Nullable final dc dc) {
        this(n, jsonObject, null, false, fe, hashMap, dc);
    }
    
    public bn(final int n, @NonNull final JSONObject jsonObject, @Nullable final bn bn, final boolean b, @NonNull final fe fe) {
        this(n, jsonObject, bn, b, fe, (bn == null) ? null : bn.l, null);
    }
    
    private bn(final int t, @NonNull final JSONObject n, @Nullable final bn f, final boolean u, @NonNull final fe s, @Nullable final HashMap<String, String> l, @Nullable final dc h) {
        this.t = t;
        this.f = f;
        this.s = s;
        this.n = n;
        this.a = 0;
        this.b = false;
        this.h = h;
        this.q = new HashMap<String, bj>();
        this.r = new HashMap<String, String>();
        this.p = new HashMap<String, List<bj>>();
        this.i = new a();
        this.u = u;
        this.l = l;
        this.i();
    }
    
    @NonNull
    public final HashMap<String, String> a() {
        if (this.l == null) {
            return new HashMap<String, String>();
        }
        return this.l;
    }
    
    public final JSONObject b() {
        try {
            return this.e.getJSONObject(0);
        }
        catch (JSONException ex) {
            fv.a().a(new gv((Throwable)ex));
            return null;
        }
    }
    
    private bl f() {
        final Iterator<bj> iterator = this.d.iterator();
        while (iterator.hasNext()) {
            final bj bj;
            if ((bj = iterator.next()).d.equalsIgnoreCase("card_scrollable")) {
                return (bl)bj;
            }
        }
        return null;
    }
    
    public final int c() {
        if (this.d == null) {
            return 0;
        }
        final Iterator<bj> iterator = this.d.iterator();
        while (iterator.hasNext()) {
            final bj bj;
            if ((bj = iterator.next()).d.equalsIgnoreCase("card_scrollable")) {
                return ((bl)bj).C;
            }
        }
        return 0;
    }
    
    public final bl a(final int n) {
        final Iterator<bj> iterator = this.d.iterator();
        while (iterator.hasNext()) {
            final bj bj;
            if ((bj = iterator.next()).d.equalsIgnoreCase("card_scrollable")) {
                if (n >= ((bl)bj).C) {
                    return null;
                }
                return (bl)((bl)bj).a(n);
            }
        }
        return null;
    }
    
    public static bl a(@NonNull final bj bj) {
        if (bj instanceof bl && a((bl)bj)) {
            return (bl)bj;
        }
        for (bl bl = (bl)bj.t; bl != null; bl = (bl)bl.t) {
            if (a(bl)) {
                return bl;
            }
        }
        return null;
    }
    
    private static boolean a(@NonNull final bl bl) {
        return "card_scrollable".equalsIgnoreCase(bl.d);
    }
    
    private static void a(final bw bw) {
        bw.x = 8;
        final HashMap<String, String> hashMap;
        (hashMap = new HashMap<String, String>()).put("[ERRORCODE]", "601");
        bw.a("error", hashMap);
    }
    
    private void g() {
        final Iterator<bj> iterator = this.c("IMAGE").iterator();
        while (iterator.hasNext()) {
            final bj bj;
            final bj a;
            if (!URLUtil.isValidUrl((String)(bj = iterator.next()).e) && (a = a(this, bj)) != null) {
                if (a.b.equals(bj.b)) {
                    bj.e = a.e;
                }
                else {
                    if (!"VIDEO".equals(a.b) || 1 == a.m || 2 != a.m) {
                        continue;
                    }
                    final bw bw;
                    final dd b = (bw = (bw)a).b();
                    final cw a2;
                    final List<cw.a> list = ((a2 = cv.a(bw, bj)) == null) ? null : a2.a(1);
                    cw.a a3 = null;
                    if (list != null) {
                        final Iterator<cw.a> iterator2 = list.iterator();
                        while (iterator2.hasNext()) {
                            final cw.a a4;
                            if (URLUtil.isValidUrl((a4 = iterator2.next()).b)) {
                                a3 = a4;
                                break;
                            }
                        }
                    }
                    if (a2 == null || a3 == null) {
                        if (b.e().size() <= 0) {
                            continue;
                        }
                        a(bw);
                    }
                    else {
                        b.a(a2);
                        bj.e = a3.b;
                        bj.a(a2.a("creativeView"));
                        final bj bj2 = bj;
                        final List<bv> u = bw.u;
                        final String s = "error";
                        final List<bv> list2 = u;
                        final bj bj3 = bj2;
                        for (final bv bv : list2) {
                            if (s.equals(bv.d)) {
                                bj3.u.add(bv);
                            }
                        }
                    }
                }
            }
        }
    }
    
    private void h() {
        final Iterator<bj> iterator = this.c("WEBVIEW").iterator();
        while (iterator.hasNext()) {
            final bj bj;
            final bx bx = (bx)(bj = iterator.next());
            final bj a;
            if (!"URL".equals(bx.z) && !"HTML".equals(bx.z) && (a = a(this, bj)) != null) {
                if (a.b.equals(bj.b)) {
                    bj.e = a.e;
                }
                else {
                    if (!"VIDEO".equals(a.b) || 2 != a.m) {
                        continue;
                    }
                    final bw bw;
                    final dd b = (bw = (bw)a).b();
                    final cw a2;
                    String s = null;
                    Label_0364: {
                        if ((a2 = cv.a(bw, bj)) != null) {
                            final cw cw = a2;
                            final bx bx2 = bx;
                            final cw cw2 = cw;
                            if ("REF_HTML".equals(bx2.z)) {
                                final List<cw.a> a3;
                                if ((a3 = cw2.a(2)).size() > 0) {
                                    s = a3.get(0).b;
                                    break Label_0364;
                                }
                                final List<cw.a> a4;
                                if ((a4 = cw2.a(3)).size() > 0) {
                                    final String b2;
                                    if (URLUtil.isValidUrl(b2 = a4.get(0).b)) {
                                        bx2.z = "REF_IFRAME";
                                        s = b2;
                                        break Label_0364;
                                    }
                                }
                            }
                            else if ("REF_IFRAME".equals(bx2.z)) {
                                final List<cw.a> a5;
                                if ((a5 = cw2.a(3)).size() > 0) {
                                    final String b3;
                                    if (URLUtil.isValidUrl(b3 = a5.get(0).b)) {
                                        bx2.z = "REF_IFRAME";
                                        s = b3;
                                        break Label_0364;
                                    }
                                }
                                else {
                                    final List<cw.a> a6;
                                    if ((a6 = cw2.a(2)).size() > 0) {
                                        bx2.z = "REF_HTML";
                                        s = a6.get(0).b;
                                        break Label_0364;
                                    }
                                }
                            }
                        }
                        s = null;
                    }
                    final String e = s;
                    final boolean equals = "REF_IFRAME".equals(bx.z);
                    final boolean equals2 = "REF_HTML".equals(bx.z);
                    if (a2 == null || (equals && !URLUtil.isValidUrl(e)) || (equals2 && e == null)) {
                        if (b.e().size() > 0) {
                            a(bw);
                        }
                        bx.z = "UNKNOWN";
                    }
                    else {
                        b.a(a2);
                        bj.e = e;
                        bj.a(a2.a("creativeView"));
                    }
                }
            }
        }
    }
    
    private void i() {
        try {
            this.o = this.n.optJSONObject("styleRefs");
            bn bn;
            byte a = 0;
            if (this.n.isNull("orientation")) {
                bn = this;
                a = 0;
            }
            else {
                bn = this;
                final String trim = this.n.getString("orientation").toLowerCase(Locale.US).trim();
                switch (trim) {
                    default: {
                        a = 0;
                        break;
                    }
                    case "portrait": {
                        a = 1;
                        break;
                    }
                    case "landscape": {
                        a = 2;
                        break;
                    }
                }
            }
            bn.a = a;
            this.j = this.n.optBoolean("shouldAutoOpenLandingPage", true);
            this.b = this.n.optBoolean("disableBackButton", false);
            this.d = (bl)this.a(this.n.getJSONObject("rootContainer"), "CONTAINER", "/rootContainer");
            try {
                if (!this.n.isNull("passThroughJson")) {
                    this.i.a = this.n.getJSONObject("passThroughJson");
                }
                final JSONObject jsonObject;
                if (!this.n.isNull("adContent") && (jsonObject = this.n.getJSONObject("adContent")) != null) {
                    final a i = this.i;
                    i.getClass();
                    final a.a b;
                    (b = i.new a()).a = jsonObject.optString("title", (String)null);
                    b.b = jsonObject.optString("description", (String)null);
                    b.d = jsonObject.optString("ctaText", (String)null);
                    b.c = jsonObject.optString("iconUrl", (String)null);
                    b.e = (float)jsonObject.optLong("rating", 0L);
                    b.f = jsonObject.optString("landingPageUrl", (String)null);
                    b.g = jsonObject.optBoolean("isApp");
                    this.i.b = b;
                }
                final bj c = new bj();
                if (!this.n.isNull("onClick")) {
                    final JSONObject jsonObject2 = this.n.getJSONObject("onClick");
                    try {
                        final bj bj = c;
                        final JSONObject jsonObject3 = jsonObject2;
                        final bj bj2 = bj;
                        String string = "";
                        String string2 = "";
                        boolean h = false;
                        if (!jsonObject3.isNull("itemUrl")) {
                            string = jsonObject3.getString("itemUrl");
                            h = true;
                        }
                        if (!jsonObject3.isNull("action")) {
                            string2 = jsonObject3.getString("action");
                            h = true;
                        }
                        bj2.a(string);
                        bj2.b(jsonObject3.optString("fallbackUrl"));
                        bj2.j = string2;
                        bj2.h = h;
                        bj2.w = jsonObject3.optString("appBundleId");
                    }
                    catch (JSONException ex4) {}
                    if (!jsonObject2.isNull("openMode")) {
                        c.i = d(jsonObject2.getString("openMode"));
                        c.b(jsonObject2.optString("fallbackUrl"));
                    }
                }
                if (!this.n.isNull("trackers")) {
                    c.a(b(this.n));
                }
                this.i.c = c;
            }
            catch (JSONException ex) {
                fv.a().a(new gv((Throwable)ex));
            }
            this.c = false;
            if (this.n.has("rewards")) {
                this.g = new HashMap<String, String>();
            }
            final Map<String, String> b2;
            if ((b2 = ak.b(this.n)) != null) {
                this.g.putAll(b2);
            }
            this.g();
            this.h();
            final Iterator<Map.Entry<String, String>> iterator = this.r.entrySet().iterator();
            while (iterator.hasNext()) {
                final Map.Entry<String, String> entry;
                final String s = (entry = iterator.next()).getValue();
                final bj bj3;
                final bj bj4;
                if ((bj3 = this.q.get(entry.getKey())) != null && 4 == bj3.n && (bj3.o != -1 || bj3.p != -1) && (bj4 = this.q.get(s)) != null && "VIDEO".equals(bj4.b)) {
                    final String[] split = ((dc)((bw)bj4).b()).b.split(":");
                    int n2;
                    try {
                        n2 = Integer.parseInt(split[1]) * 60 + Integer.parseInt(split[2]);
                    }
                    catch (ArrayIndexOutOfBoundsException ex2) {
                        n2 = 0;
                        fv.a().a(new gv(ex2));
                    }
                    if (n2 == 0) {
                        bj3.o = 0;
                    }
                    else {
                        switch (bj3.o) {
                            case -1:
                            case 0: {
                                break;
                            }
                            default: {
                                bj3.o = n2 / 4;
                                break;
                            }
                            case 50: {
                                bj3.o = n2 / 2;
                                break;
                            }
                            case 75: {
                                bj3.o = 3 * n2 / 4;
                                break;
                            }
                            case 100: {
                                bj3.o = n2;
                                break;
                            }
                        }
                        switch (bj3.p) {
                            case -1:
                            case 0: {
                                break;
                            }
                            default: {
                                bj3.p = n2 / 4;
                                break;
                            }
                            case 50: {
                                bj3.p = n2 / 2;
                                break;
                            }
                            case 75: {
                                bj3.p = 3 * n2 / 4;
                                break;
                            }
                            case 100: {
                                bj3.p = n2;
                                break;
                            }
                        }
                    }
                    ((bw)bj4).z.add(bj3);
                }
            }
            if (this.n.isNull("pages")) {
                this.e = new JSONArray();
                return;
            }
            this.e = this.n.getJSONArray("pages");
        }
        catch (JSONException ex3) {
            fv.a().a(new gv((Throwable)ex3));
        }
    }
    
    private static bj a(@NonNull bn f, @NonNull final bj obj) {
        String s;
        while ((s = (String)obj.e) != null && 0 != s.length()) {
            final String[] split = s.split("\\|");
            final bj b;
            if ((b = f.b(split[0])) == null) {
                if ((f = f.f) == null) {
                    return null;
                }
                continue;
            }
            else {
                if (b.equals(obj)) {
                    return null;
                }
                if (1 == split.length) {
                    b.m = 1;
                    return b;
                }
                b.m = a(split[1]);
                return b;
            }
        }
        return null;
    }
    
    public static byte a(String trim) {
        trim = trim.toLowerCase(Locale.US).trim();
        switch (trim) {
            default: {
                return 0;
            }
            case "":
            case "video": {
                return 1;
            }
            case "companion": {
                return 2;
            }
        }
    }
    
    public final boolean d() {
        if (this.d == null) {
            return false;
        }
        if (this.f() == null) {
            return this.j();
        }
        return this.c() > 0 && this.j();
    }
    
    private boolean j() {
        final List<bj> c;
        if ((c = this.c("VIDEO")) == null || c.size() <= 0) {
            return true;
        }
        final Iterator<bj> iterator = c.iterator();
        while (iterator.hasNext()) {
            final bj bj;
            (bj = iterator.next()).a.length();
            final bw bw;
            if ((bw = (bw)bj).b() == null) {
                return false;
            }
            final List<cx> c2;
            if ((c2 = bw.b().c()) == null || c2.size() == 0) {
                return false;
            }
            final String b;
            if ((b = bw.b().b()) == null || 0 == b.length()) {
                final HashMap<String, String> hashMap;
                (hashMap = new HashMap<String, String>()).put("[ERRORCODE]", "403");
                bw.a("error", hashMap);
                return false;
            }
        }
        return true;
    }
    
    private bj a(@NonNull final JSONObject jsonObject, final String s, final String g) {
        final String d = d(jsonObject);
        final String e = e(jsonObject);
        final JSONObject i;
        if (!a(i = this.i(jsonObject), s)) {
            return null;
        }
        final Point j = this.j(jsonObject);
        final Point a = this.a(jsonObject, j);
        final Point k = this.k(jsonObject);
        final Point b = this.b(jsonObject, k);
        final List<bv> b2 = b(jsonObject);
        final byte l = l(jsonObject);
        final int a2 = a(jsonObject, true);
        final int a3 = a(jsonObject, false);
        final String m = m(jsonObject);
        bj bj = null;
        bj y = null;
        String string = null;
        final String trim = g(jsonObject).trim();
        int n2 = 0;
        switch (trim) {
            default: {
                n2 = 0;
                break;
            }
            case "reference": {
                n2 = 1;
                break;
            }
        }
        final int n3 = n2;
        final JSONArray o;
        if ((o = o(jsonObject)) != null && o.length() != 0) {
            try {
                if (TextUtils.isEmpty((CharSequence)(string = o.getString(0)))) {
                    return null;
                }
                if (n3 == 1 && (y = this.b(string)) == null && this.f != null) {
                    y = this.f.b(string);
                }
            }
            catch (JSONException ex) {
                fv.a().a(new gv((Throwable)ex));
            }
        }
        try {
            switch (s) {
                case "CONTAINER": {
                    final bk a4 = this.a(j, k, a, b, i);
                    String optString = null;
                    byte d2 = 0;
                    if (p(jsonObject)) {
                        d2 = 2;
                        if (!jsonObject.getJSONObject("assetOnclick").isNull("openMode")) {
                            d2 = d(jsonObject.getJSONObject("assetOnclick").getString("openMode"));
                        }
                        optString = jsonObject.getJSONObject("assetOnclick").optString("fallbackUrl");
                    }
                    byte b3 = 0;
                    if (i.has("transitionEffect")) {
                        final String trim2 = i.getString("transitionEffect").trim();
                        byte b4 = 0;
                        switch (trim2) {
                            default: {
                                b4 = 0;
                                break;
                            }
                            case "free": {
                                b4 = 1;
                                break;
                            }
                        }
                        b3 = b4;
                    }
                    bl t;
                    if (b2 == null || 0 == b2.size()) {
                        t = new bl(d, e, a4, d2, jsonObject, b3);
                    }
                    else {
                        t = new bl(d, e, a4, b2, d2, jsonObject, b3);
                    }
                    t.g = g;
                    if (optString != null) {
                        t.b(optString);
                    }
                    a(t, jsonObject);
                    final JSONArray jsonArray = jsonObject.getJSONArray("assetValue");
                    for (int i2 = 0; i2 < jsonArray.length(); ++i2) {
                        final String string2 = g + ".assetValue[" + i2 + "]";
                        final JSONObject jsonObject2 = jsonArray.getJSONObject(i2);
                        final String trim3 = f(jsonObject2).toLowerCase(Locale.US).trim();
                        String s2 = null;
                        switch (trim3) {
                            default: {
                                s2 = "CONTAINER";
                                break;
                            }
                            case "icon": {
                                s2 = "ICON";
                                break;
                            }
                            case "image": {
                                s2 = "IMAGE";
                                break;
                            }
                            case "video": {
                                s2 = "VIDEO";
                                break;
                            }
                            case "text": {
                                s2 = "TEXT";
                                break;
                            }
                            case "cta": {
                                s2 = "CTA";
                                break;
                            }
                            case "rating": {
                                s2 = "RATING";
                                break;
                            }
                            case "timer": {
                                s2 = "TIMER";
                                break;
                            }
                            case "webview": {
                                s2 = "WEBVIEW";
                                break;
                            }
                            case "gif": {
                                s2 = "GIF";
                                break;
                            }
                        }
                        final bj a5;
                        if ((a5 = this.a(jsonObject2, s2, string2)) != null) {
                            a5.g = string2;
                            a5.t = t;
                            final bl bl = t;
                            final bj bj2 = a5;
                            final bl bl2 = bl;
                            if (bl.C < 16) {
                                if (bl2.C == bl2.B.length) {
                                    final bl bl3 = bl2;
                                    final int n7 = 2 * bl2.B.length;
                                    final bl bl4 = bl3;
                                    final bj[] b5 = new bj[n7];
                                    System.arraycopy(bl4.B, 0, b5, 0, bl4.C);
                                    bl4.B = b5;
                                }
                                bl2.B[bl2.C++] = bj2;
                            }
                        }
                    }
                    bj = t;
                    break;
                }
                case "TEXT": {
                    final br br;
                    (br = new br(d, e, this.b(j, k, a, b, i), string)).g = g;
                    bj = br;
                    break;
                }
                case "ICON": {
                    final bp bp;
                    (bp = new bp(d, e, this.a(j, k, a, b, i), c(jsonObject))).g = g;
                    bj = bp;
                    break;
                }
                case "TIMER": {
                    final bk a6 = this.a(j, k, a, b, i);
                    bs.a q = null;
                    if (jsonObject.has("startOffset")) {
                        q = this.q(jsonObject.getJSONObject("startOffset"));
                    }
                    bs.a q2 = null;
                    if (jsonObject.has("timerDuration")) {
                        q2 = this.q(jsonObject.getJSONObject("timerDuration"));
                    }
                    final bt bt;
                    (bt = new bt(d, e, a6, new bs(q, q2))).z = jsonObject.optBoolean("displayTimer", true);
                    final JSONObject jsonObject3;
                    if (jsonObject.has("assetOnFinish") && (jsonObject3 = (JSONObject)jsonObject.get("assetOnFinish")).has("action")) {
                        final String string3 = jsonObject3.getString("action");
                        final bt bt2 = bt;
                        final String trim4 = string3.toUpperCase(Locale.US).trim();
                        byte k2 = 0;
                        switch (trim4) {
                            default: {
                                k2 = 0;
                                break;
                            }
                            case "EXIT": {
                                k2 = 1;
                                break;
                            }
                        }
                        bt2.k = k2;
                    }
                    bt.g = g;
                    bj = bt;
                    break;
                }
                case "IMAGE":
                case "GIF": {
                    String optString2 = null;
                    final bk a7 = this.a(j, k, a, b, i);
                    byte d3 = 0;
                    if (p(jsonObject)) {
                        d3 = 2;
                        if (!jsonObject.getJSONObject("assetOnclick").isNull("openMode")) {
                            d3 = d(jsonObject.getJSONObject("assetOnclick").getString("openMode"));
                        }
                        optString2 = jsonObject.getJSONObject("assetOnclick").optString("fallbackUrl");
                    }
                    if (b2 == null || 0 == b2.size()) {
                        if ("IMAGE".equals(s)) {
                            bj = new bq(d, e, a7, c(jsonObject), d3, jsonObject);
                        }
                        else {
                            bj = new bo(d, e, a7, c(jsonObject), d3, jsonObject);
                        }
                    }
                    else if ("IMAGE".equals(s)) {
                        bj = new bq(d, e, a7, c(jsonObject), b2, d3, jsonObject);
                    }
                    else {
                        bj = new bo(d, e, a7, c(jsonObject), b2, d3, jsonObject);
                    }
                    bj.g = g;
                    a(bj, jsonObject);
                    if (optString2 != null) {
                        bj.b(optString2);
                        break;
                    }
                    break;
                }
                case "WEBVIEW": {
                    if (string == null) {
                        return null;
                    }
                    final String c = bx.c(h(jsonObject));
                    if ("URL".equals(c) && !URLUtil.isValidUrl(string)) {
                        return null;
                    }
                    final bx k3;
                    (k3 = new bx(d, e, this.a(j, k, a, b, i), string, jsonObject.optBoolean("isScrollable"))).z = c;
                    k3.g = g;
                    bj = k3;
                    if (jsonObject.optBoolean("preload", false)) {
                        k3.A = true;
                        this.k = k3;
                        break;
                    }
                    break;
                }
                case "VIDEO": {
                    this.p.get("VIDEO");
                    final bw.a a8 = new bw.a(j.x, j.y, k.x, k.y, a.x, a.y, b.x, b.y, this.s(i));
                    final dd dd = (this.h == null) ? this.a(jsonObject, string, y) : this.h;
                    boolean b6 = true;
                    boolean b7 = true;
                    boolean b8 = false;
                    boolean b9 = true;
                    boolean b10 = true;
                    int n9 = Integer.MAX_VALUE;
                    int f = 0;
                    if (this.t == 0) {
                        if (y != null) {
                            if ((boolean)y.v.get("didRequestFullScreen") || this.u) {
                                b8 = jsonObject.optBoolean("loop", false);
                                b10 = jsonObject.optBoolean("showProgress", true);
                                b6 = jsonObject.optBoolean("soundOn", true);
                                b7 = jsonObject.optBoolean("showMute", true);
                                b9 = jsonObject.optBoolean("autoPlay", true);
                                n9 = ((bw)y).E;
                                f = (int)jsonObject.optDouble("pauseAfter", 0.0);
                            }
                        }
                        else {
                            b8 = jsonObject.optBoolean("loop", true);
                            b10 = jsonObject.optBoolean("showProgress", false);
                            b6 = jsonObject.optBoolean("soundOn", false);
                            b7 = jsonObject.optBoolean("showMute", false);
                            b9 = jsonObject.optBoolean("autoPlay", true);
                            n9 = jsonObject.optInt("completeAfter", Integer.MAX_VALUE);
                            f = (int)jsonObject.optDouble("pauseAfter", 0.0);
                        }
                    }
                    else {
                        b8 = jsonObject.optBoolean("loop", false);
                        b10 = jsonObject.optBoolean("showProgress", true);
                        b6 = jsonObject.optBoolean("soundOn", true);
                        b7 = jsonObject.optBoolean("showMute", true);
                        b9 = jsonObject.optBoolean("autoPlay", true);
                        n9 = jsonObject.optInt("completeAfter", Integer.MAX_VALUE);
                        f = (int)jsonObject.optDouble("pauseAfter", 0.0);
                    }
                    final HashMap<String, Object> m2 = new HashMap<String, Object>();
                    if (!jsonObject.isNull("videoViewabilityConfig")) {
                        final JSONObject jsonObject4;
                        final Iterator keys = (jsonObject4 = jsonObject.getJSONObject("videoViewabilityConfig")).keys();
                        while (keys.hasNext()) {
                            final String s3 = keys.next();
                            m2.put(s3, jsonObject4.get(s3));
                        }
                    }
                    final bw y2;
                    (y2 = new bw(d, e, a8, dd, b6, b7, b8, b10, b9, b2, jsonObject, this.s.rendering.enablePubMuteControl)).G = new HashMap<String, Object>(m2);
                    y2.E = ((n9 <= 0) ? Integer.MAX_VALUE : n9);
                    y2.g = g;
                    if ((y2.y = y) != null) {
                        y.y = y2;
                    }
                    if (f != 0) {
                        y2.F = f;
                    }
                    bj = y2;
                    break;
                }
                case "RATING": {
                    bj = null;
                    break;
                }
                case "CTA": {
                    if (!p(jsonObject)) {
                        return null;
                    }
                    final br.a c2 = this.c(j, k, a, b, i);
                    byte d4 = 2;
                    if (!jsonObject.getJSONObject("assetOnclick").isNull("openMode")) {
                        d4 = d(jsonObject.getJSONObject("assetOnclick").getString("openMode"));
                    }
                    final String optString3 = jsonObject.getJSONObject("assetOnclick").optString("fallbackUrl");
                    bm bm;
                    if (b2 == null || 0 == b2.size()) {
                        bm = new bm(d, e, c2, string, d4, jsonObject);
                    }
                    else {
                        bm = new bm(d, e, c2, string, b2, d4, jsonObject);
                    }
                    bm.g = g;
                    a(bm, jsonObject);
                    if (optString3 != null) {
                        bm.b(optString3);
                    }
                    bj = bm;
                    break;
                }
            }
        }
        catch (JSONException ex2) {
            fv.a().a(new gv((Throwable)ex2));
            bj = null;
        }
        if (bj != null) {
            bj.n = l;
            bj.o = a2;
            bj.p = a3;
            bj.q = m;
            if (m != null && 0 != m.length()) {
                this.r.put(d, m);
            }
            if (0 != d.length() && !this.q.containsKey(d)) {
                this.q.put(d, bj);
            }
            if (this.p.containsKey(s)) {
                this.p.get(s).add(bj);
            }
            else {
                final ArrayList<bj> list;
                (list = new ArrayList<bj>()).add(bj);
                this.p.put(s, list);
            }
        }
        return bj;
    }
    
    private static void a(@NonNull final bj bj, @NonNull final JSONObject jsonObject) throws JSONException {
        String string = "";
        String string2 = "";
        boolean h = false;
        if (p(jsonObject)) {
            if (!jsonObject.getJSONObject("assetOnclick").isNull("itemUrl")) {
                string = jsonObject.getJSONObject("assetOnclick").getString("itemUrl");
                h = true;
            }
            if (!jsonObject.getJSONObject("assetOnclick").isNull("action")) {
                string2 = jsonObject.getJSONObject("assetOnclick").getString("action");
                h = true;
            }
        }
        bj.a(string);
        bj.j = string2;
        bj.h = h;
    }
    
    @Nullable
    public final bj b(final String s) {
        if (s == null || 0 == s.length()) {
            return null;
        }
        if (this.q.get(s) != null) {
            return this.q.get(s);
        }
        if (this.f != null) {
            return this.f.q.get(s);
        }
        return null;
    }
    
    public final List<String> e() {
        return new ArrayList<String>(this.p.keySet());
    }
    
    public final List<bj> c(final String s) {
        if (this.p.containsKey(s)) {
            return this.p.get(s);
        }
        return Collections.emptyList();
    }
    
    private static boolean a(JSONObject jsonObject, final String s) {
        if (jsonObject.isNull("geometry")) {
            return false;
        }
        try {
            if (!a(jsonObject.getJSONArray("geometry"))) {
                return false;
            }
            switch (s) {
                default: {
                    return false;
                }
                case "CONTAINER":
                case "ICON":
                case "IMAGE":
                case "VIDEO":
                case "TIMER":
                case "WEBVIEW":
                case "GIF": {
                    return true;
                }
                case "TEXT":
                case "CTA": {
                    if (jsonObject.isNull("text")) {
                        return false;
                    }
                    jsonObject = jsonObject.getJSONObject("text");
                    int n2;
                    try {
                        n2 = (int)Double.parseDouble(jsonObject.getString("size"));
                    }
                    catch (NumberFormatException ex) {
                        fv.a().a(new gv(ex));
                        return false;
                    }
                    return n2 > 0;
                }
            }
        }
        catch (JSONException ex2) {
            fv.a().a(new gv((Throwable)ex2));
            return false;
        }
    }
    
    private static boolean a(final JSONArray jsonArray) {
        try {
            final int int1 = jsonArray.getInt(2);
            final int int2 = jsonArray.getInt(3);
            return int1 > 0 && int2 > 0;
        }
        catch (JSONException ex) {
            fv.a().a(new gv((Throwable)ex));
            return false;
        }
    }
    
    private static bv a(final int n, final String anObject, final JSONObject jsonObject) throws JSONException {
        final String s = jsonObject.isNull("url") ? "" : jsonObject.getString("url").trim();
        final HashMap<String, ArrayList<String>> m = new HashMap<String, ArrayList<String>>();
        if ("VideoImpression".equals(anObject)) {
            final JSONArray optJSONArray = jsonObject.optJSONArray("events");
            if ((0 == s.length() || (s.startsWith("http") && !URLUtil.isValidUrl(s)) || !s.startsWith("http")) && optJSONArray == null) {
                return null;
            }
            final ArrayList<String> list = new ArrayList<String>();
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); ++i) {
                    final String a = bv.a(optJSONArray.getString(i));
                    if ("creativeView".equals(a) || "start".equals(a) || "Impression".equals(a)) {
                        list.add(a);
                    }
                }
            }
            m.put("referencedEvents", list);
        }
        else if (0 == s.length() || !URLUtil.isValidUrl(s)) {
            return null;
        }
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        try {
            if (!jsonObject.isNull("params")) {
                final JSONObject jsonObject2;
                final Iterator keys = (jsonObject2 = jsonObject.getJSONObject("params")).keys();
                while (keys.hasNext()) {
                    final String s2 = keys.next();
                    hashMap.put(s2, jsonObject2.getString(s2));
                }
            }
        }
        catch (JSONException ex) {
            fv.a().a(new gv((Throwable)ex));
        }
        final bv bv;
        (bv = new bv(s, n, anObject, hashMap)).f = new HashMap<String, Object>(m);
        return bv;
    }
    
    private static List<bv> a(final JSONObject jsonObject) {
        final LinkedList<bv> list = new LinkedList<bv>();
        try {
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            if (!jsonObject.isNull("macros")) {
                final JSONObject jsonObject2;
                final Iterator keys = (jsonObject2 = jsonObject.getJSONObject("macros")).keys();
                while (keys.hasNext()) {
                    final String s = keys.next();
                    hashMap.put(s, jsonObject2.getString(s));
                }
            }
            JSONArray jsonArray;
            for (int length = (jsonArray = jsonObject.getJSONArray("adVerifications")).length(), i = 0; i < length; ++i) {
                final JSONObject jsonObject3;
                if (!(jsonObject3 = jsonArray.getJSONObject(i)).isNull("url")) {
                    list.add(new ea(jsonObject3.optString("vendor"), jsonObject3.optString("verificationParams"), jsonObject3.getString("url"), "OMID_VIEWABILITY", hashMap));
                }
            }
            if (list.isEmpty()) {
                list.add(new bv("", 0, "OMID_VIEWABILITY", hashMap));
            }
        }
        catch (Exception ex) {
            fv.a().a(new gv(ex));
        }
        return list;
    }
    
    private static List<bv> b(@NonNull final JSONObject jsonObject) {
        if (jsonObject.isNull("trackers")) {
            return null;
        }
        final LinkedList<bv> list = new LinkedList<bv>();
        try {
            final JSONArray jsonArray;
            final int length;
            if ((length = (jsonArray = jsonObject.getJSONArray("trackers")).length()) == 0) {
                return list;
            }
            for (int i = 0; i < length; ++i) {
                final JSONObject jsonObject2;
                if (!(jsonObject2 = jsonArray.getJSONObject(i)).isNull("trackerType")) {
                    final String trim = jsonObject2.getString("trackerType").toUpperCase(Locale.US).trim();
                    String anObject = null;
                    switch (trim) {
                        default: {
                            anObject = "unknown";
                            break;
                        }
                        case "URL_PING": {
                            anObject = "url_ping";
                            break;
                        }
                        case "URL_WEBVIEW_PING": {
                            anObject = "webview_ping";
                            break;
                        }
                        case "HTML_SCRIPT": {
                            anObject = "html_script";
                            break;
                        }
                    }
                    if ("url_ping".equals(anObject)) {
                        final int optInt = jsonObject2.optInt("eventId", 0);
                        if (!jsonObject2.isNull("uiEvent")) {
                            final String string;
                            final String trim2 = (string = jsonObject2.getString("uiEvent")).toUpperCase(Locale.US).trim();
                            int n2 = -1;
                            switch (trim2.hashCode()) {
                                case 2342118: {
                                    if (trim2.equals("LOAD")) {
                                        n2 = 1;
                                        break;
                                    }
                                    break;
                                }
                                case 2008409463: {
                                    if (trim2.equals("CLIENT_FILL")) {
                                        n2 = 2;
                                        break;
                                    }
                                    break;
                                }
                                case -1881262698: {
                                    if (trim2.equals("RENDER")) {
                                        n2 = 3;
                                        break;
                                    }
                                    break;
                                }
                                case 2634405: {
                                    if (trim2.equals("VIEW")) {
                                        n2 = 4;
                                        break;
                                    }
                                    break;
                                }
                                case 64212328: {
                                    if (trim2.equals("CLICK")) {
                                        n2 = 5;
                                        break;
                                    }
                                    break;
                                }
                                case 1963885793: {
                                    if (trim2.equals("VIDEO_VIEWABILITY")) {
                                        n2 = 6;
                                        break;
                                    }
                                    break;
                                }
                                case 368426751: {
                                    if (trim2.equals("OMID_VIEWABILITY")) {
                                        n2 = 7;
                                        break;
                                    }
                                    break;
                                }
                                case -825499301: {
                                    if (trim2.equals("FALLBACK_URL_CLICK")) {
                                        n2 = 8;
                                        break;
                                    }
                                    break;
                                }
                            }
                            String s = null;
                            Label_0738: {
                                switch (n2) {
                                    default: {
                                        final String trim3 = string.toUpperCase(Locale.US).trim();
                                        switch (trim3) {
                                            default: {
                                                s = "unknown";
                                                break Label_0738;
                                            }
                                            case "DOWNLOADER_INITIALIZED": {
                                                s = "TRACKER_EVENT_TYPE_FALLBACK_URL";
                                                break Label_0738;
                                            }
                                            case "DOWNLOADER_DOWNLOADING": {
                                                s = "TRACKER_EVENT_TYPE_DOWNLOADER_DOWNLOADING";
                                                break Label_0738;
                                            }
                                            case "DOWNLOADER_DOWNLOADED": {
                                                s = "TRACKER_EVENT_TYPE_DOWNLOADER_DOWNLOADED";
                                                break Label_0738;
                                            }
                                            case "DOWNLOADER_ERROR": {
                                                s = "TRACKER_EVENT_TYPE_DOWNLOADER_ERROR";
                                                break Label_0738;
                                            }
                                        }
                                        break;
                                    }
                                    case 1: {
                                        s = "load";
                                        break;
                                    }
                                    case 2: {
                                        s = "client_fill";
                                        break;
                                    }
                                    case 3: {
                                        s = "Impression";
                                        break;
                                    }
                                    case 4: {
                                        s = "page_view";
                                        break;
                                    }
                                    case 5: {
                                        s = "click";
                                        break;
                                    }
                                    case 6: {
                                        s = "VideoImpression";
                                        break;
                                    }
                                    case 7: {
                                        s = "OMID_VIEWABILITY";
                                        break;
                                    }
                                    case 8: {
                                        s = "TRACKER_EVENT_TYPE_FALLBACK_URL";
                                        break;
                                    }
                                }
                            }
                            final String s2 = s;
                            if (!"unknown".equals(s2)) {
                                if (!"OMID_VIEWABILITY".equals(s2)) {
                                    final bv a;
                                    if ((a = a(optInt, s2, jsonObject2)) != null) {
                                        list.add(a);
                                    }
                                }
                                else {
                                    list.addAll((Collection<?>)a(jsonObject2));
                                }
                            }
                        }
                    }
                }
            }
            return list;
        }
        catch (JSONException ex) {
            fv.a().a(new gv((Throwable)ex));
            return list;
        }
    }
    
    @Nullable
    private dd a(@NonNull final JSONObject jsonObject, @NonNull final String s, final bj bj) {
        if (f(jsonObject).equalsIgnoreCase("VIDEO")) {
            try {
                final JSONArray jsonArray;
                if ((jsonArray = jsonObject.getJSONArray("assetValue")) == null || 0 == jsonArray.length()) {
                    return null;
                }
                if (bj instanceof bw) {
                    return (dd)bj.e;
                }
                return new cz(this.s.vastVideo).a(s);
            }
            catch (JSONException ex) {
                fv.a().a(new gv((Throwable)ex));
            }
        }
        return null;
    }
    
    private static String c(@NonNull final JSONObject jsonObject) {
        try {
            if ((f(jsonObject).equalsIgnoreCase("ICON") || f(jsonObject).equalsIgnoreCase("IMAGE") || f(jsonObject).equalsIgnoreCase("GIF")) && jsonObject.getJSONArray("assetValue").getString(0).length() != 0) {
                return jsonObject.getJSONArray("assetValue").getString(0);
            }
        }
        catch (JSONException ex) {
            fv.a().a(new gv((Throwable)ex));
        }
        return "";
    }
    
    private static String d(@NonNull final JSONObject jsonObject) {
        try {
            return jsonObject.getString("assetId");
        }
        catch (JSONException ex) {
            fv.a().a(new gv((Throwable)ex));
            return Integer.toString(jsonObject.hashCode());
        }
    }
    
    private static String e(@NonNull final JSONObject jsonObject) {
        try {
            return jsonObject.getString("assetName");
        }
        catch (JSONException ex) {
            fv.a().a(new gv((Throwable)ex));
            return "";
        }
    }
    
    private static String f(@NonNull final JSONObject jsonObject) {
        try {
            return jsonObject.getString("assetType");
        }
        catch (JSONException ex) {
            fv.a().a(new gv((Throwable)ex));
            return "";
        }
    }
    
    private static String g(@NonNull final JSONObject jsonObject) {
        try {
            return jsonObject.getString("valueType");
        }
        catch (JSONException ex) {
            fv.a().a(new gv((Throwable)ex));
            return "";
        }
    }
    
    private static String h(@NonNull final JSONObject jsonObject) {
        try {
            return jsonObject.getString("dataType");
        }
        catch (JSONException ex) {
            fv.a().a(new gv((Throwable)ex));
            return "";
        }
    }
    
    @NonNull
    private JSONObject i(@NonNull final JSONObject jsonObject) {
        try {
            JSONObject jsonObject2;
            if ((jsonObject2 = (jsonObject.isNull("assetStyle") ? null : jsonObject.getJSONObject("assetStyle"))) == null) {
                if (jsonObject.isNull("assetStyleRef")) {
                    return new JSONObject();
                }
                final String string = jsonObject.getString("assetStyleRef");
                jsonObject2 = ((this.o == null) ? new JSONObject() : this.o.getJSONObject(string));
            }
            return jsonObject2;
        }
        catch (JSONException ex) {
            fv.a().a(new gv((Throwable)ex));
            return new JSONObject();
        }
    }
    
    private Point j(@NonNull JSONObject i) {
        final Point point = new Point();
        try {
            if ((i = this.i(i)).isNull("geometry")) {
                return point;
            }
            final JSONArray jsonArray = i.getJSONArray("geometry");
            point.x = ho.a(jsonArray.getInt(0));
            point.y = ho.a(jsonArray.getInt(1));
        }
        catch (JSONException ex) {
            fv.a().a(new gv((Throwable)ex));
        }
        return point;
    }
    
    private Point a(@NonNull final JSONObject jsonObject, @NonNull final Point point) {
        Point point2;
        try {
            final JSONObject i;
            if ((i = this.i(jsonObject)).isNull("finalGeometry")) {
                return point;
            }
            point2 = new Point();
            final JSONArray jsonArray = i.getJSONArray("finalGeometry");
            point2.x = ho.a(jsonArray.getInt(0));
            point2.y = ho.a(jsonArray.getInt(1));
        }
        catch (JSONException ex) {
            point2 = point;
        }
        return point2;
    }
    
    private Point k(@NonNull JSONObject i) {
        final Point point = new Point();
        try {
            if ((i = this.i(i)).isNull("geometry")) {
                return point;
            }
            final JSONArray jsonArray = i.getJSONArray("geometry");
            point.x = ho.a(jsonArray.getInt(2));
            point.y = ho.a(jsonArray.getInt(3));
        }
        catch (JSONException ex) {
            fv.a().a(new gv((Throwable)ex));
        }
        return point;
    }
    
    private Point b(@NonNull final JSONObject jsonObject, @NonNull final Point point) {
        Point point2;
        try {
            final JSONObject i;
            if ((i = this.i(jsonObject)).isNull("finalGeometry")) {
                return point;
            }
            point2 = new Point();
            final JSONArray jsonArray = i.getJSONArray("finalGeometry");
            point2.x = ho.a(jsonArray.getInt(2));
            point2.y = ho.a(jsonArray.getInt(3));
        }
        catch (JSONException ex) {
            point2 = point;
        }
        return point2;
    }
    
    private static byte l(@NonNull JSONObject n) {
        try {
            if ((n = n(n)).isNull("type")) {
                return 2;
            }
            final String lowerCase = n.getString("type").trim().toLowerCase(Locale.US);
            switch (lowerCase) {
                default: {
                    return 1;
                }
                case "absolute": {
                    return 3;
                }
                case "percentage": {
                    return 4;
                }
            }
        }
        catch (JSONException ex) {
            fv.a().a(new gv((Throwable)ex));
            return 2;
        }
    }
    
    private static int a(@NonNull final JSONObject jsonObject, final boolean b) {
        try {
            final JSONObject n;
            if ((n = n(jsonObject)).isNull(b ? "delay" : "hideAfterDelay")) {
                return -1;
            }
            final int int1 = n.getInt(b ? "delay" : "hideAfterDelay");
            if (3 == l(jsonObject)) {
                return int1;
            }
            if (4 != l(jsonObject)) {
                return -1;
            }
            if (int1 == 0) {
                return int1;
            }
            if (int1 > 0 && int1 <= 100) {
                final int[] array = { 25, 50, 75, 100 };
                int n2 = -1;
                double n3 = Double.MAX_VALUE;
                for (int i = 0; i < 4; ++i) {
                    final int n4 = array[i];
                    final double n5;
                    if ((n5 = (int1 - n4) * (int1 - n4)) < n3) {
                        n3 = n5;
                        n2 = i;
                    }
                }
                return array[n2];
            }
            return -1;
        }
        catch (JSONException ex) {
            fv.a().a(new gv((Throwable)ex));
            return -1;
        }
    }
    
    private static String m(@NonNull JSONObject n) {
        try {
            if ((n = n(n)).isNull("reference")) {
                return "";
            }
            return n.getString("reference");
        }
        catch (JSONException ex) {
            fv.a().a(new gv((Throwable)ex));
            return "";
        }
    }
    
    private static JSONObject n(@NonNull final JSONObject jsonObject) {
        if (jsonObject.isNull("display")) {
            return new JSONObject();
        }
        try {
            return jsonObject.getJSONObject("display");
        }
        catch (JSONException ex) {
            fv.a().a(new gv((Throwable)ex));
            return new JSONObject();
        }
    }
    
    private static JSONArray o(@NonNull final JSONObject jsonObject) {
        try {
            return jsonObject.getJSONArray("assetValue");
        }
        catch (JSONException ex) {
            fv.a().a(new gv((Throwable)ex));
            return new JSONArray();
        }
    }
    
    private static boolean p(@NonNull final JSONObject jsonObject) {
        return !jsonObject.isNull("assetOnclick");
    }
    
    private static byte d(@NonNull String trim) {
        trim = trim.toUpperCase(Locale.US).trim();
        switch (trim) {
            default: {
                return 2;
            }
            case "INAPP": {
                return 1;
            }
            case "DEEPLINK": {
                return 3;
            }
            case "DOWNLOAD": {
                return 4;
            }
        }
    }
    
    private static String e(@NonNull String trim) {
        trim = trim.toLowerCase(Locale.US).trim();
        switch (trim) {
            default: {
                return "none";
            }
            case "bold": {
                return "bold";
            }
            case "italic": {
                return "italic";
            }
            case "strike": {
                return "strike";
            }
            case "underline": {
                return "underline";
            }
        }
    }
    
    private static String f(@NonNull String trim) {
        trim = trim.toLowerCase(Locale.US).trim();
        switch (trim) {
            default: {
                return "none";
            }
            case "line": {
                return "line";
            }
        }
    }
    
    private static String g(@NonNull String trim) {
        trim = trim.toLowerCase(Locale.US).trim();
        switch (trim) {
            default: {
                return "straight";
            }
            case "curved": {
                return "curved";
            }
        }
    }
    
    private static String h(@NonNull String trim) {
        trim = trim.trim();
        switch (trim) {
            default: {
                return "unspecified";
            }
            case "fill": {
                return "fill";
            }
            case "aspectFill": {
                return "aspectFill";
            }
            case "aspectFit": {
                return "aspectFit";
            }
        }
    }
    
    private bs.a q(final JSONObject jsonObject) {
        return new bs.a(jsonObject.optLong("absolute"), jsonObject.optLong("percentage"), jsonObject.optString("reference"), this);
    }
    
    private bs.a r(final JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        return new bs.a(jsonObject.optLong("absolute"), jsonObject.optLong("percentage"), jsonObject.optString("reference"), this);
    }
    
    private bk a(@NonNull final Point point, @NonNull final Point point2, @NonNull final Point point3, @NonNull final Point point4, @NonNull final JSONObject jsonObject) throws JSONException {
        String f;
        String g;
        String trim;
        if (jsonObject.isNull("border")) {
            f = "none";
            g = "straight";
            trim = "#ff000000";
        }
        else {
            final JSONObject jsonObject2;
            if ((jsonObject2 = jsonObject.getJSONObject("border")).isNull("style")) {
                f = "none";
                g = "straight";
                trim = "#ff000000";
            }
            else {
                f = f(jsonObject2.getString("style"));
                if (jsonObject2.isNull("corner")) {
                    g = "straight";
                }
                else {
                    g = g(jsonObject2.getString("corner"));
                }
                if (jsonObject2.isNull("color")) {
                    trim = "#ff000000";
                }
                else {
                    trim = jsonObject2.getString("color").trim();
                }
            }
        }
        final String s = jsonObject.isNull("backgroundColor") ? "#00000000" : jsonObject.getString("backgroundColor").trim();
        String h = "fill";
        if (!jsonObject.isNull("contentMode")) {
            h = h(jsonObject.getString("contentMode"));
        }
        return new bk(point.x, point.y, point2.x, point2.y, point3.x, point3.y, point4.x, point4.y, h, f, g, trim, s, this.s(jsonObject));
    }
    
    private bs s(final JSONObject jsonObject) throws JSONException {
        bs.a r = null;
        if (!jsonObject.isNull("startOffset")) {
            r = this.r(jsonObject.optJSONObject("startOffset"));
        }
        bs.a r2 = null;
        if (!jsonObject.isNull("timerDuration")) {
            r2 = this.r(jsonObject.optJSONObject("timerDuration"));
        }
        return new bs(r, r2);
    }
    
    private br.a b(@NonNull final Point point, @NonNull final Point point2, @NonNull final Point point3, @NonNull final Point point4, @NonNull final JSONObject jsonObject) throws JSONException {
        String f;
        String g;
        String trim;
        if (jsonObject.isNull("border")) {
            f = "none";
            g = "straight";
            trim = "#ff000000";
        }
        else {
            final JSONObject jsonObject2;
            if ((jsonObject2 = jsonObject.getJSONObject("border")).isNull("style")) {
                f = "none";
                g = "straight";
                trim = "#ff000000";
            }
            else {
                f = f(jsonObject2.getString("style"));
                if (jsonObject2.isNull("corner")) {
                    g = "straight";
                }
                else {
                    g = g(jsonObject2.getString("corner"));
                }
                if (jsonObject2.isNull("color")) {
                    trim = "#ff000000";
                }
                else {
                    trim = jsonObject2.getString("color").trim();
                }
            }
        }
        final String s = jsonObject.isNull("backgroundColor") ? "#00000000" : jsonObject.getString("backgroundColor").trim();
        final JSONObject jsonObject3 = jsonObject.getJSONObject("text");
        int n;
        try {
            n = (int)Double.parseDouble(jsonObject3.getString("size"));
        }
        catch (NumberFormatException ex2) {
            final JSONException ex = new JSONException(ex2.getMessage());
            fv.a().a(new gv(ex2));
            throw ex;
        }
        final int n2 = jsonObject3.isNull("length") ? Integer.MAX_VALUE : Integer.parseInt(jsonObject3.getString("length"));
        final String s2 = jsonObject3.isNull("color") ? "#ff000000" : jsonObject3.getString("color").trim();
        String[] array;
        if (jsonObject3.isNull("style")) {
            array = new String[] { "none" };
        }
        else {
            final int length;
            if ((length = jsonObject3.getJSONArray("style").length()) == 0) {
                array = new String[] { "none" };
            }
            else {
                array = new String[length];
                for (int i = 0; i < length; ++i) {
                    array[i] = e(jsonObject3.getJSONArray("style").getString(i));
                }
            }
        }
        byte b = 0;
        if (!jsonObject3.isNull("align")) {
            final String trim2 = jsonObject3.getString("align").trim();
            byte b2 = 0;
            switch (trim2) {
                default: {
                    b2 = 0;
                    break;
                }
                case "right": {
                    b2 = 1;
                    break;
                }
                case "centre": {
                    b2 = 2;
                    break;
                }
            }
            b = b2;
        }
        return new br.a(point.x, point.y, point2.x, point2.y, point3.x, point3.y, point4.x, point4.y, f, g, trim, s, n, b, n2, s2, array, this.s(jsonObject));
    }
    
    private br.a c(@NonNull final Point point, @NonNull final Point point2, @NonNull final Point point3, @NonNull final Point point4, @NonNull final JSONObject jsonObject) throws JSONException {
        String f;
        String g;
        String trim;
        if (jsonObject.isNull("border")) {
            f = "none";
            g = "straight";
            trim = "#ff000000";
        }
        else {
            final JSONObject jsonObject2;
            if ((jsonObject2 = jsonObject.getJSONObject("border")).isNull("style")) {
                f = "none";
                g = "straight";
                trim = "#ff000000";
            }
            else {
                f = f(jsonObject2.getString("style"));
                if (jsonObject2.isNull("corner")) {
                    g = "straight";
                }
                else {
                    g = g(jsonObject2.getString("corner"));
                }
                if (jsonObject2.isNull("color")) {
                    trim = "#ff000000";
                }
                else {
                    trim = jsonObject2.getString("color").trim();
                }
            }
        }
        final String s = jsonObject.isNull("backgroundColor") ? "#00000000" : jsonObject.getString("backgroundColor").trim();
        final JSONObject jsonObject3 = jsonObject.getJSONObject("text");
        int n;
        try {
            n = (int)Double.parseDouble(jsonObject3.getString("size"));
        }
        catch (NumberFormatException ex2) {
            final JSONException ex = new JSONException(ex2.getMessage());
            fv.a().a(new gv(ex2));
            throw ex;
        }
        final String s2 = jsonObject3.isNull("color") ? "#ff000000" : jsonObject3.getString("color").trim();
        String[] array;
        if (jsonObject3.isNull("style")) {
            array = new String[] { "none" };
        }
        else {
            final int length;
            if ((length = jsonObject3.getJSONArray("style").length()) == 0) {
                array = new String[] { "none" };
            }
            else {
                array = new String[length];
                for (int i = 0; i < length; ++i) {
                    array[i] = e(jsonObject3.getJSONArray("style").getString(i));
                }
            }
        }
        return new bm.a(point.x, point.y, point2.x, point2.y, point3.x, point3.y, point4.x, point4.y, f, g, trim, s, n, s2, array, this.s(jsonObject));
    }
    
    static {
        m = bn.class.getSimpleName();
    }
    
    public final class a
    {
        public JSONObject a;
        @NonNull
        public bn.a.a b;
        public bj c;
        
        public a() {
            this.b = new bn.a.a();
        }
        
        public final class a
        {
            public String a;
            public String b;
            public String c;
            public String d;
            public float e;
            public String f;
            public boolean g;
        }
    }
}

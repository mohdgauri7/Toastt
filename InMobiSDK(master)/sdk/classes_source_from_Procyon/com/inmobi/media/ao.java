// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import android.util.Base64;
import java.util.concurrent.TimeUnit;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import org.json.JSONObject;
import androidx.annotation.NonNull;

public final class ao
{
    private static final String a;
    
    public static void a(@NonNull final ak ak, final JSONObject mAdContent, final String mAdType, @Nullable final cr cr, final long duration) throws JSONException, IllegalStateException {
        if ("unknown".equals(ak.markupType) || TextUtils.isEmpty((CharSequence)ak.impressionId)) {
            throw new IllegalStateException("Invalid Ad");
        }
        final long optLong;
        final long n = ((optLong = mAdContent.optLong("expiry", TimeUnit.MILLISECONDS.toSeconds(duration))) <= 0L) ? -1L : TimeUnit.SECONDS.toMillis(optLong);
        float float1 = 0.0f;
        if (mAdContent.has("bid") && cr != null) {
            float1 = Float.parseFloat(gn.a(hl.a(Base64.decode(mAdContent.getString("bid"), 0), cr.b, cr.a)));
        }
        final long n2 = n;
        final float mBid = float1;
        final long mExpiryDurationInMillis = n2;
        ak.mAdContent = mAdContent;
        ak.mAdType = mAdType;
        ak.mInsertionTimestampInMillis = System.currentTimeMillis();
        ak.mExpiryDurationInMillis = mExpiryDurationInMillis;
        ak.mBid = mBid;
        if ("inmobiJson".equals(ak.i())) {
            a(ak, mAdContent);
        }
    }
    
    private static void a(@NonNull final ak ak, JSONObject jsonObject) {
        try {
            if (!(jsonObject = jsonObject.getJSONObject("pubContent")).isNull("rootContainer")) {
                jsonObject = jsonObject.getJSONObject("rootContainer");
                final JSONArray assetUrls = new JSONArray();
                final Iterator<String> iterator = e(jsonObject).iterator();
                while (iterator.hasNext()) {
                    a(assetUrls, iterator.next(), (byte)2);
                }
                final Iterator<String> iterator2 = f(jsonObject).iterator();
                while (iterator2.hasNext()) {
                    a(assetUrls, iterator2.next(), (byte)1);
                }
                final boolean d = d(jsonObject);
                ak.assetUrls = assetUrls;
                ak.mIsPreloadWebView = d;
            }
        }
        catch (Exception ex) {
            fv.a().a(new gv(ex));
        }
    }
    
    public static ak a(@NonNull final ak ak, @NonNull final fe fe) throws JSONException, bh {
        if (!"inmobiJson".equals(ak.i())) {
            return ak;
        }
        final JSONObject jsonObject;
        final String c = c((jsonObject = new JSONObject(ak.k())).getJSONObject("rootContainer"));
        if (0 == c.trim().length()) {
            return ak;
        }
        final dc a = new cz(fe.vastVideo).a(c);
        final JSONArray assetUrls = ak.assetUrls;
        if (a.f != 0) {
            throw new bh(a.f);
        }
        final String b;
        if ((b = a.b()) == null || b.isEmpty()) {
            throw new bh(401);
        }
        a(assetUrls, b, (byte)0);
        final List<String> a2;
        (a2 = a(jsonObject, fe.vastVideo)).size();
        final Iterator<String> iterator = a2.iterator();
        while (iterator.hasNext()) {
            a(assetUrls, iterator.next(), (byte)0);
        }
        final Iterator<String> iterator2 = a(jsonObject).iterator();
        while (iterator2.hasNext()) {
            a(assetUrls, iterator2.next(), (byte)2);
        }
        final Iterator<String> iterator3 = b(jsonObject).iterator();
        while (iterator3.hasNext()) {
            a(assetUrls, iterator3.next(), (byte)1);
        }
        return new bb(ak, assetUrls, a.b(), a.b, a.c, a.d, a.e);
    }
    
    private static void a(final JSONArray jsonArray, final String s, final byte b) throws JSONException {
        final JSONObject jsonObject;
        (jsonObject = new JSONObject()).put("type", (int)b);
        jsonObject.put("url", (Object)s);
        jsonArray.put((Object)jsonObject);
    }
    
    private static List<String> a(final JSONObject jsonObject, final fe.k k) {
        final ArrayList<String> list = new ArrayList<String>();
        try {
            final JSONArray jsonArray = jsonObject.getJSONArray("pages");
            for (int i = 0; i < jsonArray.length(); ++i) {
                if (!jsonArray.getJSONObject(i).isNull("rootContainer")) {
                    final String c = c(jsonArray.getJSONObject(i).getJSONObject("rootContainer"));
                    if (0 != c.trim().length()) {
                        final dc a;
                        if ((a = new cz(k).a(c)) != null && a.f == 0) {
                            final String b;
                            if ((b = a.b()) != null && !b.isEmpty()) {
                                list.add(b);
                            }
                        }
                    }
                }
            }
        }
        catch (JSONException ex) {}
        return list;
    }
    
    private static List<String> a(final JSONObject jsonObject) {
        final ArrayList<Object> list = (ArrayList<Object>)new ArrayList<String>();
        try {
            final JSONArray jsonArray = jsonObject.getJSONArray("pages");
            for (int i = 0; i < jsonArray.length(); ++i) {
                if (!jsonArray.getJSONObject(i).isNull("rootContainer")) {
                    list.addAll(e(jsonArray.getJSONObject(i).getJSONObject("rootContainer")));
                }
            }
        }
        catch (JSONException ex) {}
        return (List<String>)list;
    }
    
    private static List<String> b(final JSONObject jsonObject) {
        final ArrayList<Object> list = (ArrayList<Object>)new ArrayList<String>();
        try {
            final JSONArray jsonArray = jsonObject.getJSONArray("pages");
            for (int i = 0; i < jsonArray.length(); ++i) {
                if (!jsonArray.getJSONObject(i).isNull("rootContainer")) {
                    list.addAll(f(jsonArray.getJSONObject(i).getJSONObject("rootContainer")));
                }
            }
        }
        catch (JSONException ex) {}
        return (List<String>)list;
    }
    
    @NonNull
    private static String c(@NonNull final JSONObject jsonObject) {
        try {
            final JSONArray jsonArray = jsonObject.getJSONArray("assetValue");
            if (0 == jsonArray.length()) {
                return "";
            }
            final String string = jsonObject.getString("assetType");
            if ("video".equalsIgnoreCase(string)) {
                return jsonArray.getString(0);
            }
            if ("container".equalsIgnoreCase(string)) {
                String c = "";
                for (int n = 0; n < jsonArray.length() && (c = c(jsonArray.getJSONObject(n))).trim().length() == 0; ++n) {}
                return c;
            }
            return "";
        }
        catch (JSONException ex) {
            fv.a().a(new gv((Throwable)ex));
            return "";
        }
    }
    
    private static boolean d(@NonNull final JSONObject jsonObject) {
        try {
            final JSONArray jsonArray = jsonObject.getJSONArray("assetValue");
            if (0 == jsonArray.length()) {
                return false;
            }
            final String string = jsonObject.getString("assetType");
            if ("webview".equalsIgnoreCase(string)) {
                return !jsonObject.isNull("preload") && jsonObject.getBoolean("preload");
            }
            if ("container".equalsIgnoreCase(string)) {
                boolean d = false;
                for (int n = 0; n < jsonArray.length() && !(d = d(jsonArray.getJSONObject(n))); ++n) {}
                return d;
            }
            return false;
        }
        catch (JSONException ex) {
            fv.a().a(new gv((Throwable)ex));
            return false;
        }
    }
    
    @NonNull
    private static List<String> e(@NonNull final JSONObject jsonObject) {
        final ArrayList<String> list = new ArrayList<String>();
        try {
            final JSONArray jsonArray = jsonObject.getJSONArray("assetValue");
            if (0 == jsonArray.length()) {
                return list;
            }
            final String string = jsonObject.getString("assetType");
            if ("image".equalsIgnoreCase(string)) {
                if (!jsonObject.isNull("preload") && jsonObject.getBoolean("preload")) {
                    list.add(jsonArray.getString(0));
                }
                return list;
            }
            if ("container".equalsIgnoreCase(string)) {
                for (int i = 0; i < jsonArray.length(); ++i) {
                    list.addAll((Collection<?>)e(jsonArray.getJSONObject(i)));
                }
                return list;
            }
            return list;
        }
        catch (JSONException ex) {
            return list;
        }
    }
    
    @NonNull
    private static List<String> f(@NonNull final JSONObject jsonObject) {
        final ArrayList<String> list = new ArrayList<String>();
        try {
            final JSONArray jsonArray = jsonObject.getJSONArray("assetValue");
            if (0 == jsonArray.length()) {
                return list;
            }
            final String string = jsonObject.getString("assetType");
            if ("gif".equalsIgnoreCase(string)) {
                list.add(jsonArray.getString(0));
                return list;
            }
            if ("container".equalsIgnoreCase(string)) {
                for (int i = 0; i < jsonArray.length(); ++i) {
                    list.addAll((Collection<?>)f(jsonArray.getJSONObject(i)));
                }
                return list;
            }
            return list;
        }
        catch (JSONException ex) {
            return list;
        }
    }
    
    static {
        a = ak.class.getSimpleName();
    }
}

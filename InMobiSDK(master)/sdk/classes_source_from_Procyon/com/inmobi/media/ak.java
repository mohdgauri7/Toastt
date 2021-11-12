// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import org.json.JSONException;
import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import com.inmobi.ads.AdMetaInfo;
import androidx.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import androidx.annotation.NonNull;

@hw
public class ak
{
    private static final String TAG;
    private static final long INVALID_AD_EXPIRY = -1L;
    public static final String WIN_BEACON = "win_beacon";
    public static final String CLICK_BEACON = "click";
    public static final String IMPRESSION_BEACON = "impression";
    private static final boolean DEFAULT_ALLOW_AUTO_REDIRECTION = false;
    @NonNull
    String markupType;
    String mAdType;
    JSONObject mAdContent;
    long mInsertionTimestampInMillis;
    long mExpiryDurationInMillis;
    JSONArray assetUrls;
    private String mWebVast;
    boolean mIsPreloadWebView;
    float mBid;
    private String adAuctionMeta;
    @NonNull
    String impressionId;
    private boolean canLoadBeforeShow;
    private String pubContent;
    private boolean applyBitmap;
    private JSONObject metaInfo;
    private JSONArray landingPageParams;
    @Nullable
    private JSONArray trackers;
    @Nullable
    JSONObject transaction;
    private boolean allowAutoRedirection;
    
    public ak() {
        this.markupType = "unknown";
        this.mWebVast = "";
        this.adAuctionMeta = null;
        this.impressionId = "";
        this.canLoadBeforeShow = true;
        this.pubContent = "";
        this.applyBitmap = false;
        this.trackers = null;
        this.allowAutoRedirection = false;
        this.mInsertionTimestampInMillis = System.currentTimeMillis();
    }
    
    ak(@NonNull final ak ak, final JSONArray assetUrls) {
        this.markupType = "unknown";
        this.mWebVast = "";
        this.adAuctionMeta = null;
        this.impressionId = "";
        this.canLoadBeforeShow = true;
        this.pubContent = "";
        this.applyBitmap = false;
        this.trackers = null;
        this.allowAutoRedirection = false;
        hv.a(ak, this);
        this.assetUrls = assetUrls;
    }
    
    public final String a() {
        return this.mAdType;
    }
    
    public final JSONObject b() {
        return this.mAdContent;
    }
    
    public String c() {
        return this.mWebVast;
    }
    
    public boolean d() {
        return this.mIsPreloadWebView;
    }
    
    public boolean e() {
        return this.allowAutoRedirection;
    }
    
    @NonNull
    public final String f() {
        return this.impressionId;
    }
    
    @NonNull
    public AdMetaInfo g() {
        return new AdMetaInfo(this.u(), this.transaction);
    }
    
    private long x() {
        if (this.mExpiryDurationInMillis == -1L) {
            return -1L;
        }
        return this.mInsertionTimestampInMillis + this.mExpiryDurationInMillis;
    }
    
    public boolean a(final long duration) {
        long n;
        if (this.x() == -1L) {
            n = this.mInsertionTimestampInMillis + TimeUnit.SECONDS.toMillis(duration) - System.currentTimeMillis();
        }
        else {
            n = this.x() - System.currentTimeMillis();
        }
        return n < 0L;
    }
    
    @NonNull
    public final Set<bd> h() {
        final HashSet<bd> set = new HashSet<bd>();
        try {
            if (this.assetUrls != null) {
                for (int i = 0; i < this.assetUrls.length(); ++i) {
                    final JSONObject jsonObject;
                    final byte b = (byte)(jsonObject = new JSONObject(this.assetUrls.getString(i))).getInt("type");
                    final String optString;
                    if (!TextUtils.isEmpty((CharSequence)(optString = jsonObject.optString("url")))) {
                        set.add(new bd(b, optString));
                    }
                }
            }
            return set;
        }
        catch (JSONException ex) {
            fv.a().a(new gv((Throwable)ex));
            return set;
        }
    }
    
    @NonNull
    public final String i() {
        return this.markupType;
    }
    
    public void a(final String mWebVast) {
        this.mWebVast = mWebVast;
    }
    
    public float j() {
        return this.mBid;
    }
    
    @NonNull
    public String k() {
        return this.pubContent;
    }
    
    public void b(@NonNull final String pubContent) throws JSONException {
        if ("inmobiJson".equals(this.i())) {
            this.mAdContent.put("pubContent", (Object)new JSONObject(pubContent));
        }
        else {
            this.mAdContent.put("pubContent", (Object)pubContent);
        }
        this.pubContent = pubContent;
    }
    
    public boolean l() {
        return this.canLoadBeforeShow;
    }
    
    @Nullable
    public JSONObject m() {
        return this.transaction;
    }
    
    final void a(@Nullable final JSONObject jsonObject) throws JSONException {
        if (jsonObject != null) {
            final Iterator keys = jsonObject.keys();
            while (keys.hasNext()) {
                final String target = keys.next();
                this.pubContent = this.pubContent.replace(target, jsonObject.getString(target));
            }
        }
        this.b(this.pubContent);
    }
    
    @Nullable
    public JSONArray n() {
        return this.mAdContent.optJSONArray("trackingEvents");
    }
    
    @Nullable
    public String o() {
        return this.mAdContent.optString("baseEventUrl", (String)null);
    }
    
    @Nullable
    public Long p() {
        try {
            if (this.mAdContent.has("asPlcId")) {
                return this.mAdContent.getLong("asPlcId");
            }
            return null;
        }
        catch (JSONException ex) {
            fv.a().a(new gv((Throwable)ex));
            return null;
        }
    }
    
    public long q() {
        return this.mAdContent.optLong("lineItemId", Long.MIN_VALUE);
    }
    
    @Nullable
    public String r() {
        return this.adAuctionMeta;
    }
    
    public boolean s() {
        return this.applyBitmap;
    }
    
    @Nullable
    public static Map<String, String> b(@NonNull JSONObject optJSONObject) throws JSONException {
        if (optJSONObject.has("rewards")) {
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            if ((optJSONObject = optJSONObject.optJSONObject("rewards")) != null) {
                final Iterator keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    final String s = keys.next();
                    hashMap.put(s, optJSONObject.getString(s));
                }
            }
            return hashMap;
        }
        return null;
    }
    
    @Nullable
    public Map<String, String> t() {
        try {
            return b(this.mAdContent.getJSONObject("pubContent"));
        }
        catch (JSONException ex) {
            fv.a().a(new gv((Throwable)ex));
            return null;
        }
    }
    
    @NonNull
    public String u() {
        return this.mAdContent.optString("creativeId");
    }
    
    @Nullable
    public List<String> c(final String s) {
        if (this.trackers == null) {
            return null;
        }
        final LinkedList<String> list = new LinkedList<String>();
        for (int i = 0; i < this.trackers.length(); ++i) {
            try {
                final JSONObject jsonObject = this.trackers.getJSONObject(i);
                final JSONArray optJSONArray;
                if (s.equals(jsonObject.optString("type")) && (optJSONArray = jsonObject.optJSONArray("url")) != null) {
                    for (int j = 0; j < optJSONArray.length(); ++j) {
                        list.add(optJSONArray.getString(j));
                    }
                }
            }
            catch (JSONException ex) {
                return null;
            }
        }
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }
    
    public String v() {
        String optString = "DEFAULT";
        if (this.metaInfo != null) {
            this.landingPageParams = this.metaInfo.optJSONArray("landingPageParams");
            final JSONObject jsonObject;
            if (this.landingPageParams != null && (jsonObject = (JSONObject)this.landingPageParams.opt(0)) != null) {
                optString = jsonObject.optString("openMode", "DEFAULT");
            }
        }
        return optString;
    }
    
    public String w() {
        if (this.metaInfo != null) {
            return this.metaInfo.optString("creativeType", (String)null);
        }
        return null;
    }
    
    static {
        TAG = ak.class.getSimpleName();
    }
}

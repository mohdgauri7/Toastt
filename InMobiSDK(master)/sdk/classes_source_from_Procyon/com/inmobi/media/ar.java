// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import android.text.TextUtils;
import java.util.concurrent.TimeUnit;
import androidx.annotation.VisibleForTesting;
import java.util.List;
import com.inmobi.commons.utils.json.Constructor;
import androidx.annotation.Nullable;
import org.json.JSONObject;
import java.util.LinkedList;
import androidx.annotation.NonNull;

@hw
public final class ar
{
    private static final String TAG;
    private static final long INVALID_AD_EXPIRY = -1L;
    private static final String KEY_ADS = "ads";
    private static final String KEY_AD_SET_EXPIRY = "expiry";
    private static final String KEY_IMPRESSION_ID = "impressionId";
    private static final String KEY_MACROS = "macros";
    public static final String KEY_REQUEST_ID = "requestId";
    public static final String CTX_HASH_KEY = "ctxHash";
    public static final String MACRO_CTX_HASH = "${ctxhash}";
    private static final String MACRO_ADV_PRICE = "${advPrice}";
    static final String BUYER_PRICE = "buyerPrice";
    @NonNull
    private String adSetId;
    private String requestId;
    private boolean isAuctionClosed;
    private boolean isPod;
    private long mPlacementId;
    private String mAdType;
    @NonNull
    private LinkedList<ak> ads;
    private String adSetAuctionMeta;
    @Nullable
    private JSONObject mMacros;
    private boolean mCanLoadBeforeShow;
    
    public ar() {
        this.adSetId = "";
        this.requestId = "";
        this.isAuctionClosed = true;
        this.isPod = false;
        this.ads = new LinkedList<ak>();
        this.adSetAuctionMeta = null;
    }
    
    @VisibleForTesting
    public static hv<ar> a() {
        return new hv<ar>().a(new ia("ads", ar.class), new hx(new Constructor<List<ak>>() {}, ak.class));
    }
    
    @Nullable
    public static ar a(JSONObject jsonObject, long n, final String mAdType, @NonNull final String requestId, @Nullable final cr cr) {
        try {
            final long optLong;
            final long n2 = ((optLong = jsonObject.optLong("expiry", -1L)) <= 0L) ? -1L : TimeUnit.SECONDS.toMillis(optLong);
            final JSONArray jsonArray;
            if ((jsonArray = jsonObject.getJSONArray("ads")).length() == 0) {
                return null;
            }
            if ((jsonObject = (JSONObject)a().a(jsonObject, ar.class)) == null || TextUtils.isEmpty((CharSequence)((ar)jsonObject).adSetId)) {
                return null;
            }
            ((ar)jsonObject).mPlacementId = mPlacementId;
            ((ar)jsonObject).requestId = requestId;
            ((ar)jsonObject).mAdType = mAdType;
            JSONObject jsonObject2;
            Object o;
            Iterator<ak> iterator;
            ak ak;
            for (n = 0; n < jsonArray.length(); ++n) {
                jsonObject2 = jsonArray.getJSONObject((int)n);
                o = null;
                iterator = (Iterator<ak>)((ar)jsonObject).ads.iterator();
                while (iterator.hasNext()) {
                    ak = iterator.next();
                    if (jsonObject2.optString("impressionId").equals(ak.f())) {
                        try {
                            ao.a(ak, jsonArray.getJSONObject((int)n), mAdType, cr, n2);
                        }
                        catch (Exception ex) {
                            o = ak;
                            fv.a().a(new gv(ex));
                        }
                        break;
                    }
                }
                if (o != null) {
                    ((ar)jsonObject).ads.remove(o);
                }
            }
            final boolean empty;
            if (!(empty = ((ar)jsonObject).ads.isEmpty())) {
                final JSONObject jsonObject3 = jsonObject;
                ((ar)jsonObject3).mCanLoadBeforeShow = ((ar)jsonObject3).ads.get(0).l();
            }
            if (empty) {
                return null;
            }
            return (ar)jsonObject;
        }
        catch (JSONException ex2) {
            return null;
        }
    }
    
    @NonNull
    public final LinkedList<ak> b() {
        return this.ads;
    }
    
    public final boolean c() {
        return this.isAuctionClosed;
    }
    
    public final boolean d() {
        return this.isPod;
    }
    
    @NonNull
    public final String e() {
        return this.adSetId;
    }
    
    public final String f() {
        return this.mAdType;
    }
    
    public final String g() {
        return this.adSetAuctionMeta;
    }
    
    @NonNull
    public final String h() {
        return this.requestId;
    }
    
    public final long i() {
        return this.mPlacementId;
    }
    
    public final boolean j() {
        return this.mCanLoadBeforeShow;
    }
    
    @Nullable
    public final ak k() {
        try {
            if (!this.ads.isEmpty()) {
                this.ads.removeFirst();
            }
        }
        catch (Exception ex) {}
        return this.l();
    }
    
    @Nullable
    public final ak l() {
        try {
            if (this.ads.isEmpty()) {
                return null;
            }
            return this.ads.getFirst();
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    @Nullable
    private ak a(@NonNull final String s) {
        for (final ak ak : this.ads) {
            if (s.equals(ak.f())) {
                return ak;
            }
        }
        return null;
    }
    
    public final void a(@NonNull JSONObject jsonArray, @NonNull final fe fe) throws JSONException {
        if (this.isAuctionClosed) {
            throw new IllegalStateException("Auction was already closed. Can't process UAS response");
        }
        final String string = jsonArray.getString("requestId");
        jsonArray = (JSONObject)jsonArray.getJSONArray("ads");
        if (!this.requestId.equals(string)) {
            throw new IllegalArgumentException("UAS response supplied was of a different requestId");
        }
        final int length;
        if ((length = ((JSONArray)jsonArray).length()) == 0) {
            throw new IllegalArgumentException("UAS response supplied doesn't have any ads");
        }
        final LinkedList<ak> c = new LinkedList<ak>();
        for (int i = 0; i < length; ++i) {
            final JSONObject jsonObject;
            final String string2 = (jsonObject = ((JSONArray)jsonArray).getJSONObject(i)).getString("impressionId");
            this.mMacros = jsonObject.optJSONObject("macros");
            ak e;
            if ((e = this.a(string2)) != null) {
                e.a(this.mMacros);
                try {
                    e = ao.a(e, fe);
                }
                catch (bh bh) {}
                if (e != null) {
                    if (this.mMacros != null) {
                        if (this.mMacros.has("${advPrice}")) {
                            final ak ak = e;
                            final String string3 = this.mMacros.getString("${advPrice}");
                            final ak ak2 = ak;
                            try {
                                if (ak2.transaction != null) {
                                    ak2.transaction.put("buyerPrice", Double.parseDouble(string3));
                                    ak2.mAdContent.put("transaction", (Object)ak2.transaction);
                                }
                            }
                            catch (Exception ex) {
                                fv.a().a(new gv(ex));
                            }
                        }
                        if (this.mMacros.has("${ctxhash}")) {
                            final ak ak3 = e;
                            final String string4 = this.mMacros.getString("${ctxhash}");
                            final ak ak4 = ak3;
                            try {
                                if (ak4.transaction != null) {
                                    ak4.transaction.put("ctxHash", (Object)string4);
                                    ak4.mAdContent.put("transaction", (Object)ak4.transaction);
                                }
                            }
                            catch (JSONException ex2) {
                                fv.a().a(new gv((Throwable)ex2));
                            }
                        }
                    }
                    c.add(e);
                }
            }
        }
        this.ads.clear();
        this.ads.addAll(c);
        if (this.ads.isEmpty()) {
            throw new IllegalArgumentException("No matching ads to render");
        }
        this.isAuctionClosed = true;
    }
    
    @Nullable
    public final JSONObject m() {
        return this.mMacros;
    }
    
    public final void a(@NonNull final fe fe, final db db) {
        final ak l;
        if ((l = this.l()) != null) {
            final da a = da.a();
            a.a.execute(new Runnable() {
                @Override
                public final void run() {
                    da.a(a, l, fe, db);
                }
            });
        }
    }
    
    public final void a(final ak e) {
        try {
            if (this.l() != null) {
                this.ads.removeFirst();
            }
        }
        catch (Exception ex) {}
        this.ads.addFirst(e);
    }
    
    static {
        TAG = ar.class.getSimpleName();
    }
}

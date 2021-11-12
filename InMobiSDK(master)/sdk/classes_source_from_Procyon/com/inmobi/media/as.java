// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.UiThread;
import org.json.JSONArray;
import android.text.TextUtils;
import android.os.SystemClock;
import org.json.JSONException;
import com.inmobi.ads.InMobiAdRequestStatus;
import org.json.JSONObject;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;

public class as
{
    private static final String e;
    @NonNull
    public final a a;
    @NonNull
    private final be f;
    @NonNull
    public final aq b;
    public long c;
    public final ax d;
    private final ax g;
    
    public as(@NonNull final a a, @NonNull final be f, @NonNull final aq b) {
        this.c = 0L;
        this.d = new ax() {
            @Override
            public final void a(final am am, final byte b) {
                as.this.g.a(am, b);
                as.e;
                as.this.b;
                new Handler(Looper.getMainLooper()).post((Runnable)new Runnable() {
                    @Override
                    public final void run() {
                        as.this.a.a(as.this.b, false, as.a(b));
                    }
                });
            }
            
            @Override
            public final void a(final am am) {
                as.this.g.a(am);
                as.e;
                as.this.b;
                new Handler(Looper.getMainLooper()).post((Runnable)new Runnable() {
                    @Override
                    public final void run() {
                        as.this.a.a(as.this.b, true, (byte)0);
                    }
                });
            }
        };
        this.g = new ax() {
            @Override
            public final void a(final am am, final byte b) {
                as.e;
                if (am == null) {
                    return;
                }
            }
            
            @Override
            public final void a(final am am) {
                as.e;
                if (am != null) {
                    final Set<bd> b = am.b;
                    final Iterator<al> iterator = am.a.iterator();
                    while (iterator.hasNext()) {
                        final al al;
                        if (!(al = iterator.next()).j) {
                            final String a = as.a(b, al);
                            final HashMap<String, Object> hashMap;
                            (hashMap = new HashMap<String, Object>()).put("latency", al.a);
                            hashMap.put("size", 1.0f * ie.a(al.e) / 1024.0f);
                            hashMap.put("assetType", a);
                            hashMap.put("networkType", hn.b());
                            hashMap.put("adType", as.this.b.l());
                            as.this.f.b("AssetDownloaded", hashMap);
                        }
                    }
                }
                as.e;
                as.this.b;
            }
        };
        this.a = a;
        this.f = f;
        this.b = b;
    }
    
    public static void a(final cc cc) {
        if (cc != null) {
            Map<String, String> d;
            if ((d = cc.d) == null) {
                d = new HashMap<String, String>();
            }
            cc.d = d;
        }
    }
    
    @NonNull
    public final ar a(@Nullable final cd cd, @Nullable final cr cr) throws bf {
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(cd.a.b());
        }
        catch (JSONException ex) {
            final HashMap<String, Object> hashMap;
            (hashMap = new HashMap<String, Object>()).put("errorCode", 3);
            this.a(hashMap);
            throw new bf(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), (byte)0);
        }
        return this.a(jsonObject, cr);
    }
    
    public final ar a(@NonNull final JSONObject jsonObject, @Nullable final cr cr) throws bf {
        final ar b;
        if ((b = this.b(jsonObject, cr)) == null) {
            final HashMap<String, Object> hashMap;
            (hashMap = new HashMap<String, Object>()).put("errorCode", 3);
            this.a(hashMap);
            throw new bf(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), (byte)0);
        }
        this.b();
        if (!b.c()) {
            return b;
        }
        if (b.l() == null) {
            final HashMap<String, Object> hashMap2;
            (hashMap2 = new HashMap<String, Object>()).put("errorCode", 3);
            this.a(hashMap2);
            throw new bf(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), (byte)0);
        }
        return b;
    }
    
    private void b() {
        final HashMap<String, Long> hashMap;
        (hashMap = new HashMap<String, Long>()).put("latency", SystemClock.elapsedRealtime() - this.c);
        hashMap.put("adType", this.b.l());
        hashMap.put("networkType", (Long)hn.b());
        hashMap.put("plId", this.b.e());
        hashMap.put("plType", "NonAB");
        this.f.b("ServerFill", (Map<String, Object>)hashMap);
    }
    
    @Nullable
    private ar b(final JSONObject jsonObject, @Nullable final cr cr) {
        try {
            final String trim = jsonObject.optString("winningAdSetId").trim();
            final JSONArray jsonArray = jsonObject.getJSONArray("adSets");
            final String string = jsonObject.getString("requestId");
            if (jsonArray.length() != 0) {
                final ar a;
                if ((a = ar.a(jsonArray.getJSONObject(0), this.b.e(), this.b.l(), string, cr)) != null) {
                    return a;
                }
                final HashMap<String, Object> hashMap;
                (hashMap = new HashMap<String, Object>()).put("errorCode", 3);
                this.a(hashMap);
                return null;
            }
            else if (TextUtils.isEmpty((CharSequence)trim)) {
                final HashMap<String, Long> hashMap2;
                (hashMap2 = new HashMap<String, Long>()).put("latency", SystemClock.elapsedRealtime() - this.c);
                hashMap2.put("adType", this.b.l());
                hashMap2.put("networkType", (Long)hn.b());
                hashMap2.put("plId", this.b.e());
                hashMap2.put("plType", "NonAB");
                this.f.b("ServerNoFill", (Map<String, Object>)hashMap2);
                throw new bf(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.NO_FILL), (byte)0);
            }
        }
        catch (JSONException ex) {}
        return null;
    }
    
    public final void a(@NonNull final Map<String, Object> map) {
        map.put("latency", SystemClock.elapsedRealtime() - this.c);
        map.put("adType", this.b.l());
        map.put("networkType", hn.b());
        map.put("plId", this.b.e());
        map.put("plType", "NonAB");
        this.f.b("ServerError", map);
    }
    
    static /* synthetic */ byte a(final byte b) {
        byte b2 = 0;
        switch (b) {
            case 1: {
                b2 = 78;
                break;
            }
            case 2: {
                b2 = 79;
                break;
            }
            case 3: {
                b2 = 80;
                break;
            }
            case 4: {
                b2 = 81;
                break;
            }
            case 5: {
                b2 = 5;
                break;
            }
            case 6: {
                b2 = 77;
                break;
            }
            case 7: {
                b2 = 31;
                break;
            }
            case 8: {
                b2 = 27;
                break;
            }
            default: {
                b2 = 82;
                break;
            }
        }
        return b2;
    }
    
    static /* synthetic */ String a(final Set set, final al al) {
        String s = "";
        final Iterator<bd> iterator = set.iterator();
        while (iterator.hasNext()) {
            final bd bd;
            if ((bd = iterator.next()).b.equals(al.d)) {
                final bd bd2 = bd;
                String s2 = "";
                switch (bd2.a) {
                    case 2: {
                        s2 = "image";
                        break;
                    }
                    case 1: {
                        s2 = "gif";
                        break;
                    }
                    case 0: {
                        s2 = "video";
                        break;
                    }
                }
                s = s2;
                break;
            }
        }
        return s;
    }
    
    static {
        e = as.class.getSimpleName();
    }
    
    public interface a
    {
        @UiThread
        void a(@NonNull final aq p0, final boolean p1, final byte p2);
    }
}

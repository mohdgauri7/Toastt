// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.Collection;
import java.util.Arrays;
import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.List;
import android.content.ContentValues;
import java.util.Iterator;
import java.util.UUID;
import androidx.annotation.NonNull;
import java.util.Map;
import androidx.annotation.WorkerThread;
import java.util.ArrayList;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.atomic.AtomicBoolean;

public class gw implements gf
{
    private static final String d;
    public static AtomicBoolean a;
    private fu e;
    private gx f;
    private String g;
    @VisibleForTesting
    public static double b;
    private static final ArrayList<String> h;
    public gc c;
    
    public static gw a() {
        return gw.a.a;
    }
    
    @WorkerThread
    public final void b() {
        gw.a.set(false);
        this.e = (fu)fg.a("telemetry", gz.f(), null);
        this.g = this.e.telemetryUrl;
        if (this.f.a() > 0) {
            this.e();
        }
    }
    
    private gw() {
        this.f = new gx();
        this.e = (fu)ff.a("telemetry", null);
        this.g = this.e.telemetryUrl;
    }
    
    public final void a(final String s, @NonNull final Map<String, Object> map) {
        gz.a(new Runnable() {
            @Override
            public final void run() {
                gw.d;
                try {
                    final gy gy = new gy(s);
                    if (!map.isEmpty() && s.equals("AssetDownloaded")) {
                        for (final Map.Entry<Object, V> entry : map.entrySet()) {
                            if ("assetType".equals(entry.getKey())) {
                                if ("image".equals(entry.getKey()) && !gw.this.e.assetReporting.image) {
                                    gw.d;
                                    return;
                                }
                                if ("gif".equals(entry.getKey()) && !gw.this.e.assetReporting.gif) {
                                    gw.d;
                                    return;
                                }
                                if ("video".equals(entry.getKey()) && !gw.this.e.assetReporting.video) {
                                    gw.d;
                                    return;
                                }
                                continue;
                            }
                        }
                    }
                    map.put("eventType", gy.b);
                    map.put("eventId", UUID.randomUUID().toString());
                    gy.d = map.toString();
                    gw.a(gw.this, gy);
                }
                catch (Exception ex) {
                    gw.d;
                }
            }
        });
    }
    
    private void a(final gy gy) {
        if (!this.e.base.enabled) {
            return;
        }
        final int n;
        if ((n = this.f.a() + 1 - this.e.maxEventsToPersist) > 0) {
            final gx f = this.f;
            final int i = n;
            final gx gx = f;
            final gt a2;
            final List<ContentValues> a = (a2 = gt.a()).a("telemetry", null, null, null, null, null, "ts ASC", String.valueOf(i));
            final ArrayList<Integer> list = new ArrayList<Integer>();
            final Iterator<ContentValues> iterator = a.iterator();
            while (iterator.hasNext()) {
                final ContentValues contentValues;
                (contentValues = iterator.next()).getAsString("id");
                list.add(Integer.parseInt(contentValues.getAsString("id")));
            }
            gx.a(list);
            a2.b();
        }
        gx.a(gy);
    }
    
    private void e() {
        if (gw.a.get()) {
            return;
        }
        final fz e;
        (e = this.e.e()).e = this.g;
        e.b = "default";
        if (this.c == null) {
            this.c = new gc(this.f, this, e);
        }
        else {
            this.c.a(e);
        }
        this.c.a("default", true);
    }
    
    @Override
    public final gb c() {
        gb gb = null;
        List<gy> list = null;
        switch (hn.a()) {
            case 1: {
                list = gx.a(this.e.networkType.wifi.maxBatchSize);
                break;
            }
            default: {
                list = gx.a(this.e.networkType.others.maxBatchSize);
                break;
            }
        }
        if (!list.isEmpty()) {
            final ArrayList<Integer> list2 = new ArrayList<Integer>();
            final Iterator<gy> iterator = list.iterator();
            while (iterator.hasNext()) {
                list2.add(iterator.next().a);
            }
            final String a;
            if ((a = a(list)) != null) {
                gb = new gb(list2, a);
            }
        }
        return gb;
    }
    
    @Nullable
    private static String a(final List<gy> list) {
        try {
            final HashMap<String, String> hashMap;
            (hashMap = new HashMap<String, String>()).put("im-accid", (gz.g() != null) ? gz.g() : "");
            hashMap.put("as-accid", (gz.h() != null) ? gz.h() : "");
            hashMap.put("version", "4.0.0");
            hashMap.put("mk-version", ha.a());
            hashMap.put("u-appbid", hm.a().a);
            hashMap.put("tp", ha.g());
            if (ha.f() != null) {
                hashMap.put("tp-ver", ha.f());
            }
            final JSONObject jsonObject = new JSONObject((Map)hashMap);
            final JSONArray jsonArray = new JSONArray();
            final Iterator<gy> iterator = list.iterator();
            while (iterator.hasNext()) {
                final gy gy;
                if (!(gy = iterator.next()).a().trim().isEmpty()) {
                    jsonArray.put((Object)new JSONObject(gy.a()));
                }
            }
            jsonObject.put("payload", (Object)jsonArray);
            return jsonObject.toString();
        }
        catch (JSONException ex) {
            return null;
        }
    }
    
    static /* synthetic */ void a(final gw gw, final gy gy) {
        if (gw.e.base.enabled && (!gw.e.disableAllGeneralEvents || gw.e.priorityEvents.contains(gy.b)) && (!gw.h.contains(gy.b) || gw.b >= gw.e.samplingFactor)) {
            if ("CrashEventOccurred".equals(gy.b)) {
                gw.a(gy);
                return;
            }
            gw.a(gy);
            gw.e();
        }
    }
    
    static {
        d = gw.class.getSimpleName();
        gw.a = new AtomicBoolean(false);
        gw.b = Math.random();
        h = new ArrayList<String>(Arrays.asList("AdLoadCalled", "AdLoadDroppedAtSDK", "AdLoadSuccessful", "AdLoadFailed", "ServerFill", "ServerNoFill", "ServerError", "AssetDownloaded", "AdShowCalled", "AdShowSuccessful", "AdShowFailed", "AdGetSignalsCalled", "AdGetSignalsSucceeded", "AdGetSignalsFailed", "UnifiedIdNetworkCallRequested", "UnifiedIdNetworkResponseFailure", "FetchApiInvoked", "FetchCallbackFailure "));
    }
    
    static final class a
    {
        static final gw a;
        
        static {
            a = new gw((byte)0);
        }
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import androidx.annotation.WorkerThread;
import java.util.concurrent.atomic.AtomicBoolean;

public class fv implements fg.c, gf
{
    private static final String e;
    public static AtomicBoolean a;
    public fo b;
    public fw c;
    public String d;
    private gc f;
    
    public static fv a() {
        return fv.a.a;
    }
    
    private fv() {
        Thread.setDefaultUncaughtExceptionHandler(new fy(Thread.getDefaultUncaughtExceptionHandler()));
        this.c = new fw();
        this.b = (fo)ff.a("crashReporting", null);
    }
    
    @Override
    public void a(final ff ff) {
        this.b = (fo)ff;
        this.d = this.b.url;
    }
    
    public final void a(final gv gv) {
        if (!this.b.catchEnabled) {
            return;
        }
        gz.a(new Runnable() {
            @WorkerThread
            @Override
            public final void run() {
                fv.this.a((fx)gv);
                fv.this.b();
            }
        });
    }
    
    public final void a(final fx fx) {
        if (!(fx instanceof gv)) {
            if (!this.b.crashEnabled) {
                return;
            }
            gw.a().a("CrashEventOccurred", new HashMap<String, Object>());
        }
        this.c.b(this.b.eventTTL);
        if (this.c.a() + 1 - this.b.maxEventsToPersist >= 0) {
            fw.b();
        }
        fw.a(fx);
    }
    
    @WorkerThread
    public final void b() {
        if (fv.a.get()) {
            return;
        }
        final fo b = this.b;
        final fz fz;
        (fz = new fz(b.maxRetryCount, b.eventTTL, b.processingInterval, b.txLatency, b.networkType.wifi.minBatchSize, b.networkType.wifi.maxBatchSize, b.networkType.others.minBatchSize, b.networkType.others.maxBatchSize, b.networkType.wifi.retryInterval, b.networkType.others.retryInterval)).e = this.d;
        fz.b = "default";
        if (this.f == null) {
            this.f = new gc(this.c, this, fz);
        }
        else {
            this.f.a(fz);
        }
        this.f.a("default", false);
    }
    
    @Override
    public final gb c() {
        gb gb = null;
        int n = 0;
        switch (hn.a()) {
            case 1: {
                n = this.b.networkType.wifi.maxBatchSize;
                break;
            }
            default: {
                n = this.b.networkType.others.maxBatchSize;
                break;
            }
        }
        final List<fx> a;
        if (!(a = fw.a(n)).isEmpty()) {
            final ArrayList<Integer> list = new ArrayList<Integer>();
            final Iterator<fx> iterator = a.iterator();
            while (iterator.hasNext()) {
                list.add(iterator.next().a);
            }
            final String a2;
            if ((a2 = a(a)) != null) {
                gb = new gb(list, a2);
            }
        }
        return gb;
    }
    
    @Nullable
    private static String a(final List<fx> list) {
        try {
            final HashMap<String, String> hashMap;
            (hashMap = new HashMap<String, String>(hn.a(false))).put("im-accid", gz.f());
            hashMap.put("version", "2.0.0");
            hashMap.put("component", "crash");
            hashMap.put("mk-version", ha.a());
            hashMap.putAll((Map<?, ?>)hm.a().c);
            final JSONObject jsonObject = new JSONObject((Map)hashMap);
            final JSONArray jsonArray = new JSONArray();
            for (final fx fx : list) {
                final JSONObject jsonObject2;
                (jsonObject2 = new JSONObject()).put("eventId", (Object)fx.b);
                jsonObject2.put("eventType", (Object)fx.c);
                if (!fx.a().trim().isEmpty()) {
                    jsonObject2.put("crash_report", (Object)fx.a());
                }
                jsonObject2.put("ts", fx.e);
                jsonArray.put((Object)jsonObject2);
            }
            jsonObject.put("crash", (Object)jsonArray);
            return jsonObject.toString();
        }
        catch (JSONException ex) {
            return null;
        }
    }
    
    static {
        e = fv.class.getSimpleName();
        fv.a = new AtomicBoolean(false);
    }
    
    static final class a
    {
        static final fv a;
        
        static {
            a = new fv((byte)0);
        }
    }
}

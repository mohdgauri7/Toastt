// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.content.Context;
import java.io.UnsupportedEncodingException;
import java.util.List;
import android.os.SystemClock;
import java.util.Map;
import java.util.HashMap;

public class eb
{
    private static final String a;
    
    public static void a(final fe.h h) {
        final String url = h.url;
        final int maxRetries = h.maxRetries;
        final int retryInterval = h.retryInterval;
        if (url == null) {
            return;
        }
        final gm gm = new gm("GET", url);
        final HashMap<String, String> hashMap;
        (hashMap = new HashMap<String, String>()).put("Accept-Encoding", "gzip");
        gm.w = false;
        gm.q = false;
        gm.a(hashMap);
        new Thread(new Runnable() {
            @Override
            public final void run() {
                if (!eb.b(h)) {
                    return;
                }
                int i = 0;
                while (i <= maxRetries) {
                    eb.a;
                    final long elapsedRealtime = SystemClock.elapsedRealtime();
                    final gn a = new gp(gm).a();
                    try {
                        ih.a().a(gm.h());
                        ih.a().b(a.d());
                        ih.a().c(SystemClock.elapsedRealtime() - elapsedRealtime);
                    }
                    catch (Exception ex) {
                        eb.a;
                    }
                    final Context c = gz.c();
                    if (a.a()) {
                        eb.a;
                        if (++i > maxRetries) {
                            break;
                        }
                        try {
                            Thread.sleep(retryInterval * 1000);
                        }
                        catch (InterruptedException ex2) {
                            eb.a;
                        }
                    }
                    else {
                        if (c == null) {
                            continue;
                        }
                        final hi hi = new hi(c, "omid_js_store");
                        final List<String> list;
                        if ((list = a.c.get("Content-Encoding")) != null && list.get(0).equals("gzip")) {
                            eb.a;
                            final byte[] a2;
                            if ((a2 = hg.a(a.c())) != null) {
                                try {
                                    hi.b("omid_js_string", new String(a2, "UTF-8"));
                                    eb.a;
                                }
                                catch (UnsupportedEncodingException ex3) {
                                    eb.a;
                                    eb.a;
                                }
                            }
                            return;
                        }
                        hi.b("omid_js_string", a.b());
                        eb.a;
                    }
                }
            }
        }).start();
    }
    
    static /* synthetic */ boolean b(final fe.h h) {
        final Context c;
        return (c = gz.c()) != null && System.currentTimeMillis() / 1000L - new hi(c, "omid_js_store").a() > h.expiry;
    }
    
    static {
        a = eb.class.getSimpleName();
    }
}

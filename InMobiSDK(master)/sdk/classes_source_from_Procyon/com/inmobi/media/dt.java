// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import com.moat.analytics.mobile.inm.MoatPlugin;
import com.moat.analytics.mobile.inm.ReactiveVideoTrackerPlugin;
import com.moat.analytics.mobile.inm.ReactiveVideoTracker;
import com.moat.analytics.mobile.inm.NativeDisplayTracker;
import java.util.Map;
import android.view.View;
import com.moat.analytics.mobile.inm.MoatFactory;
import com.moat.analytics.mobile.inm.WebAdTracker;
import android.webkit.WebView;
import com.moat.analytics.mobile.inm.MoatAnalytics;
import com.moat.analytics.mobile.inm.MoatOptions;
import android.app.Application;

public class dt
{
    private static final String a;
    private static boolean b;
    
    public static void a(final Application application) {
        if (dt.b) {
            return;
        }
        try {
            final MoatOptions moatOptions;
            (moatOptions = new MoatOptions()).loggingEnabled = false;
            final MoatOptions moatOptions2 = moatOptions;
            ii.a();
            moatOptions2.disableLocationServices = !ii.e().locationEnabled;
            final Boolean f;
            if ((f = ic.a().f()) == null || f) {
                moatOptions.disableAdIdCollection = true;
            }
            MoatAnalytics.getInstance().start(moatOptions, application);
            dt.b = true;
        }
        catch (Exception ex) {
            fv.a().a(new gv(ex));
        }
    }
    
    static WebAdTracker a(final Application application, final WebView webView) {
        if (!dt.b) {
            a(application);
        }
        return MoatFactory.create().createWebAdTracker(webView);
    }
    
    static NativeDisplayTracker a(final Application application, final String s, final View view, final Map<String, String> map) {
        if (!dt.b) {
            a(application);
        }
        MoatAnalytics.getInstance().prepareNativeDisplayTracking(s);
        return MoatFactory.create().createNativeDisplayTracker(view, (Map)map);
    }
    
    static ReactiveVideoTracker a(final Application application, final String s) {
        if (!dt.b) {
            a(application);
        }
        return (ReactiveVideoTracker)MoatFactory.create().createCustomTracker((MoatPlugin)new ReactiveVideoTrackerPlugin(s));
    }
    
    static {
        a = dt.class.getSimpleName();
        dt.b = false;
    }
}

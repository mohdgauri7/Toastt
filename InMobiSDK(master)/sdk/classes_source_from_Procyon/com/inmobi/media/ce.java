// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.content.ServiceConnection;
import android.app.Activity;
import androidx.browser.customtabs.CustomTabsIntent;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsCallback;
import android.net.Uri;
import androidx.annotation.NonNull;
import android.content.Context;
import android.app.Application;

public final class ce implements Application.ActivityLifecycleCallbacks, f.a
{
    private final f a;
    private String b;
    private Context c;
    private h d;
    
    public ce(@NonNull final String b, @NonNull final Context context, @NonNull final h d) {
        this.b = b;
        this.a = new f();
        this.a.c = this;
        this.c = context.getApplicationContext();
        this.d = d;
        gz.a(context, (Application.ActivityLifecycleCallbacks)this);
    }
    
    public final void b() {
        this.a.a(this.c);
    }
    
    public final void a() {
        final Uri parse = Uri.parse(this.b);
        final f a;
        final CustomTabsIntent.Builder builder;
        (builder = new CustomTabsIntent.Builder(((a = this.a).a == null) ? null : a.a.newSession((CustomTabsCallback)new CustomTabsCallback() {
            public final void onNavigationEvent(final int n, final Bundle bundle) {
                super.onNavigationEvent(n, bundle);
                f.a();
                if (null != f.a(a)) {
                    f.a(a).a(n);
                }
            }
        }))).enableUrlBarHiding();
        f.a(this.c, builder.build(), parse, this.d);
    }
    
    public final void a(final int n) {
        switch (n) {
            default: {}
            case 5: {
                this.d.e();
            }
            case 6: {
                this.d.f();
            }
        }
    }
    
    public final void onActivityCreated(@NonNull final Activity activity, final Bundle bundle) {
    }
    
    public final void onActivityStarted(@NonNull final Activity activity) {
    }
    
    public final void onActivityResumed(@NonNull final Activity activity) {
    }
    
    public final void onActivityPaused(@NonNull final Activity activity) {
    }
    
    public final void onActivityStopped(@NonNull final Activity activity) {
    }
    
    public final void onActivitySaveInstanceState(@NonNull final Activity activity, @NonNull final Bundle bundle) {
    }
    
    public final void onActivityDestroyed(@NonNull final Activity activity) {
        final f a = this.a;
        final Context c = this.c;
        final f f = a;
        if (a.b != null) {
            c.unbindService((ServiceConnection)f.b);
            f.a = null;
            f.b = null;
        }
        activity.getApplication().unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this);
    }
}

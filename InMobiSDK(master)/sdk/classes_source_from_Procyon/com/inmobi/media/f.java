// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.content.ComponentName;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.annotation.NonNull;
import android.content.Context;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsClient;

public class f
{
    private static final String d;
    public CustomTabsClient a;
    public CustomTabsServiceConnection b;
    public a c;
    
    public static void a(@NonNull final Context context, @NonNull final CustomTabsIntent customTabsIntent, @NonNull final Uri uri, @NonNull final h h) {
        final String a = g.a(context);
        try {
            if (a == null) {
                h.a(uri.toString());
                return;
            }
            customTabsIntent.intent.setFlags(268435456);
            customTabsIntent.intent.setPackage(a);
            customTabsIntent.launchUrl(context, uri);
        }
        catch (Exception ex) {
            try {
                hd.b(context, uri.toString());
            }
            catch (Exception ex2) {}
        }
    }
    
    public final void a(final Context context) {
        if (this.a != null || context == null) {
            return;
        }
        final String a;
        if ((a = g.a(context)) == null) {
            return;
        }
        CustomTabsClient.bindCustomTabsService(context, a, this.b = new CustomTabsServiceConnection() {
            public final void onCustomTabsServiceConnected(final ComponentName componentName, final CustomTabsClient customTabsClient) {
                f.this.a = customTabsClient;
                if (f.this.c != null) {
                    f.this.c.a();
                }
            }
            
            public final void onServiceDisconnected(final ComponentName componentName) {
                f.this.a = null;
                if (f.this.c != null) {
                    f.this.c;
                }
            }
            
            public final void onBindingDied(final ComponentName componentName) {
                f.this.a = null;
                if (f.this.c != null) {
                    f.this.c;
                }
            }
        });
    }
    
    static {
        d = f.class.getSimpleName();
    }
    
    public interface a
    {
        void a();
        
        void a(final int p0);
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.NonNull;
import android.webkit.WebView;
import java.lang.ref.WeakReference;

final class n implements Runnable
{
    @NonNull
    private WeakReference<WebView> a;
    
    n(@NonNull final WebView referent) {
        this.a = new WeakReference<WebView>(referent);
    }
    
    @Override
    public final void run() {
        final WebView webView;
        if ((webView = this.a.get()) != null) {
            webView.getSettings().setBlockNetworkLoads(true);
        }
    }
}

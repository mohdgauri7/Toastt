// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class gr
{
    private static final String d;
    public gm a;
    public WebViewClient b;
    public a c;
    
    public gr(final gm a, final WebViewClient b) {
        this.b = b;
        this.a = a;
    }
    
    static {
        d = gr.class.getSimpleName();
    }
    
    public final class a extends WebView
    {
        public boolean a;
        
        public a(final Context context) {
            super(context);
        }
        
        public final void destroy() {
            this.a = true;
            super.destroy();
        }
    }
}

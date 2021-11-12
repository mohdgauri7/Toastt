// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import com.iab.omid.library.inmobi.adsession.VerificationScriptResource;
import java.util.List;
import com.iab.omid.library.inmobi.adsession.AdSessionContext;
import android.webkit.WebView;
import android.content.Context;

public abstract class ef
{
    public abstract boolean a();
    
    public abstract void a(final Context p0, final fe p1);
    
    public AdSessionContext a(final WebView webView, final String s, final String s2) {
        return null;
    }
    
    public AdSessionContext a(final List<VerificationScriptResource> list, final String s, final String s2) {
        return null;
    }
    
    public static final class a
    {
        public static final ef a;
        
        static {
            a = new eg();
        }
    }
}

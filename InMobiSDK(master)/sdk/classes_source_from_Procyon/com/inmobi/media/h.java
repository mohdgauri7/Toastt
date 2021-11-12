// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.NonNull;
import java.util.Map;
import androidx.annotation.Nullable;
import android.view.View;
import android.app.Activity;

public interface h
{
    byte getPlacementType();
    
    Object getDataModel();
    
    void a();
    
    void setFullScreenActivityContext(final Activity p0);
    
    @Nullable
    View getVideoContainerView();
    
    a getFullScreenEventsListener();
    
    void b();
    
    boolean c();
    
    void destroy();
    
    dg getViewableAd();
    
    String getMarkupType();
    
    void a(final byte p0, final Map<String, String> p1);
    
    void d();
    
    @NonNull
    fe getAdConfig();
    
    void a(final String p0);
    
    void e();
    
    void f();
    
    public interface a
    {
        void a();
        
        void a(final Object p0);
        
        void b(final Object p0);
    }
}

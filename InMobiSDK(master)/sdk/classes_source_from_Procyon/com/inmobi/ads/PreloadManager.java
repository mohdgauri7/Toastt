// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.ads;

import androidx.annotation.UiThread;

public interface PreloadManager
{
    @UiThread
    void preload();
    
    @UiThread
    void load();
}

// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.content.Context;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import android.content.Intent;

public class gh
{
    private static final String a;
    
    public static void a(final Intent intent) {
        intent.getAction();
        final Context c;
        if ((c = gz.c()) != null) {
            LocalBroadcastManager.getInstance(c).sendBroadcast(intent);
        }
    }
    
    static {
        a = gh.class.getName();
    }
    
    public enum a
    {
        a, 
        b, 
        c, 
        d;
    }
}

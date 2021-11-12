// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.content.Context;

public class hh
{
    private static final String a;
    
    public static boolean a(final Context context, final String s) {
        try {
            return context.checkCallingOrSelfPermission(s) == 0;
        }
        catch (Exception ex) {
            return false;
        }
    }
    
    static {
        a = hh.class.getSimpleName();
    }
}

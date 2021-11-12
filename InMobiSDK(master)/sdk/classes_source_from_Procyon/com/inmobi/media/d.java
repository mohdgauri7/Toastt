// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.app.Activity;
import androidx.annotation.NonNull;
import android.content.Context;

public final class d
{
    public static String a(@NonNull final Context context) {
        if (context instanceof Activity) {
            return "activity";
        }
        return "others";
    }
}

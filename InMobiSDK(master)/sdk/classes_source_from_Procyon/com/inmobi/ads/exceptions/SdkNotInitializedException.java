// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.ads.exceptions;

import androidx.annotation.NonNull;
import androidx.annotation.Keep;

@Keep
public final class SdkNotInitializedException extends IllegalStateException
{
    public SdkNotInitializedException(@NonNull final String str) {
        super("Please initialize the SDK before creating " + str + " ad");
    }
}

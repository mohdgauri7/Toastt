// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.ads.exceptions;

import androidx.annotation.Keep;

@Keep
public final class InvalidPlacementIdException extends IllegalArgumentException
{
    public InvalidPlacementIdException() {
        super("AdPlacement id value is not supplied in XML layout. Banner creation failed.");
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.NonNull;
import com.inmobi.ads.InMobiAdRequestStatus;

public final class bf extends RuntimeException
{
    public final InMobiAdRequestStatus a;
    public final byte b;
    
    public bf(@NonNull final InMobiAdRequestStatus a, final byte b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final String getMessage() {
        return this.a.getMessage();
    }
}

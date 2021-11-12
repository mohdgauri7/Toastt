// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.ads;

import androidx.annotation.Nullable;
import org.json.JSONObject;
import androidx.annotation.NonNull;

public final class AdMetaInfo
{
    @NonNull
    private String a;
    @Nullable
    private JSONObject b;
    
    public AdMetaInfo(@NonNull final String a, @Nullable final JSONObject b) {
        this.a = a;
        this.b = b;
    }
    
    public final double getBid() {
        if (this.b == null) {
            return 0.0;
        }
        return this.b.optDouble("buyerPrice");
    }
    
    public final JSONObject getBidInfo() {
        if (this.b == null) {
            return new JSONObject();
        }
        return this.b;
    }
    
    @NonNull
    public final String getCreativeID() {
        return this.a;
    }
    
    @Nullable
    public final String getBidKeyword() {
        if (this.b == null) {
            return null;
        }
        return this.b.optString("bidKeyword");
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import org.json.JSONException;
import org.json.JSONObject;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;

@hw
public class co
{
    private static final String TAG;
    public static final String DEFAULT_POSITION = "top-right";
    String customClosePosition;
    int width;
    int height;
    int offsetX;
    int offsetY;
    Boolean allowOffscreen;
    
    public co(@NonNull final String customClosePosition, @NonNull final Boolean allowOffscreen) {
        this.offsetX = 0;
        this.offsetY = 0;
        this.customClosePosition = customClosePosition;
        this.allowOffscreen = allowOffscreen;
    }
    
    public static co a(final String s, @Nullable final co co) {
        try {
            final co co2;
            if ((co2 = new hv<co>().a(new JSONObject(s), co.class)) != null) {
                if (co2.customClosePosition == null) {
                    co2.customClosePosition = ((co == null) ? "top-right" : co.customClosePosition);
                }
                if (co2.allowOffscreen == null) {
                    co2.allowOffscreen = (co == null || co.allowOffscreen);
                }
                return co2;
            }
        }
        catch (JSONException ex) {}
        return null;
    }
    
    static {
        TAG = co.class.getSimpleName();
    }
}

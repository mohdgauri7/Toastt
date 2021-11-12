// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.VisibleForTesting;
import androidx.annotation.NonNull;
import org.json.JSONObject;
import androidx.annotation.Nullable;

@hw
public abstract class ff
{
    private fp includeIds;
    @hu
    @Nullable
    private String mAccountId;
    
    public abstract String b();
    
    public abstract boolean d();
    
    @Nullable
    public abstract JSONObject c();
    
    public ff(@Nullable final String mAccountId) {
        this.includeIds = new fp();
        this.mAccountId = mAccountId;
    }
    
    public fp f() {
        return this.includeIds;
    }
    
    @Nullable
    public String g() {
        return this.mAccountId;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof ff)) {
            return false;
        }
        final ff ff = (ff)o;
        boolean b = false;
        if (ff.b().equals(this.b())) {
            if (this.mAccountId == null && ff.mAccountId == null) {
                b = true;
            }
            else if (this.mAccountId != null && this.mAccountId.equals(ff.mAccountId)) {
                b = true;
            }
        }
        return b;
    }
    
    @Override
    public int hashCode() {
        return this.b().hashCode() + ((this.mAccountId == null) ? 0 : this.mAccountId.hashCode());
    }
    
    @NonNull
    public static ff a(final String s, @Nullable final String s2) {
        ff ff = null;
        switch (s) {
            default: {
                ff = new fe(s2);
                break;
            }
            case "crashReporting": {
                ff = new fo(s2);
                break;
            }
            case "pk": {
                ff = new fr(s2);
                break;
            }
            case "root": {
                ff = new fs(s2);
                break;
            }
            case "signals": {
                ff = new ft(s2);
                break;
            }
            case "telemetry": {
                ff = new fu(s2);
                break;
            }
        }
        return ff;
    }
    
    @VisibleForTesting(otherwise = 3)
    @Nullable
    public static ff a(final String s, @NonNull final JSONObject jsonObject, @Nullable final String mAccountId) {
        ff ff = null;
        switch (s) {
            case "ads": {
                ff = fe.a().a(jsonObject, fe.class);
                break;
            }
            case "crashReporting": {
                ff = fo.a().a(jsonObject, fo.class);
                break;
            }
            case "pk": {
                ff = fr.a().a(jsonObject, fr.class);
                break;
            }
            case "root": {
                ff = fs.a().a(jsonObject, fs.class);
                break;
            }
            case "signals": {
                ff = ft.a().a(jsonObject, ft.class);
                break;
            }
            case "telemetry": {
                ff = fu.a().a(jsonObject, fu.class);
                break;
            }
        }
        if (ff != null) {
            ff.mAccountId = mAccountId;
        }
        return ff;
    }
}

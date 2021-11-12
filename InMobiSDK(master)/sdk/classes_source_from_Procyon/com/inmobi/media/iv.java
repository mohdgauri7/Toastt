// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.HashMap;
import com.inmobi.unifiedId.InMobiUserDataTypes;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.Nullable;
import com.inmobi.unifiedId.InMobiUserDataModel;

public final class iv
{
    private static InMobiUserDataModel a;
    
    @VisibleForTesting(otherwise = 4)
    public static synchronized void a(@Nullable final InMobiUserDataModel a) {
        iv.a = a;
    }
    
    @Nullable
    public static InMobiUserDataTypes a() {
        if (iv.a == null) {
            return null;
        }
        return a(iv.a.getPhoneNumber());
    }
    
    @Nullable
    public static InMobiUserDataTypes b() {
        if (iv.a == null) {
            return null;
        }
        return a(iv.a.getEmailId());
    }
    
    private static InMobiUserDataTypes a(final InMobiUserDataTypes inMobiUserDataTypes) {
        if (inMobiUserDataTypes == null) {
            return null;
        }
        if (inMobiUserDataTypes.getMd5() == null && inMobiUserDataTypes.getSha1() == null && inMobiUserDataTypes.getSha256() == null) {
            return null;
        }
        return inMobiUserDataTypes;
    }
    
    @Nullable
    public static HashMap<String, String> c() {
        if (iv.a == null) {
            return null;
        }
        return iv.a.getExtras();
    }
    
    public static boolean b(final InMobiUserDataModel inMobiUserDataModel) {
        return (inMobiUserDataModel == null && iv.a == null) || (inMobiUserDataModel != null && iv.a != null && inMobiUserDataModel.equals(iv.a));
    }
    
    static {
        iv.a = null;
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import com.iab.omid.library.inmobi.adsession.AdSessionContext;
import androidx.annotation.Nullable;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import java.util.Map;
import androidx.annotation.NonNull;
import android.view.View;
import com.iab.omid.library.inmobi.adsession.media.VastProperties;

public interface dy
{
    void a();
    
    void a(final int p0, final int p1, final float p2, final VastProperties p3);
    
    void a(final int p0);
    
    void a(@NonNull final View p0, @Nullable final Map<View, FriendlyObstructionPurpose> p1, @Nullable final View p2);
    
    void a(@Nullable final AdSessionContext p0);
}

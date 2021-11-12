// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import com.iab.omid.library.inmobi.adsession.AdSession;
import com.iab.omid.library.inmobi.adsession.media.MediaEvents;
import com.iab.omid.library.inmobi.adsession.AdEvents;

final class dx
{
    AdEvents a;
    MediaEvents b;
    
    public dx(final AdSession adSession, final String s) {
        switch (s) {
            case "native_video_ad": {
                this.b = MediaEvents.createMediaEvents(adSession);
                break;
            }
        }
        this.a = AdEvents.createAdEvents(adSession);
    }
    
    public final void a() {
        if (this.a == null) {
            return;
        }
        this.a.impressionOccurred();
    }
}

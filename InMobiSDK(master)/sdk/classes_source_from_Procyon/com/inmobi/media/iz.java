// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.Iterator;
import org.json.JSONException;
import java.util.Map;
import java.util.HashMap;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import com.inmobi.unifiedId.InMobiUnifiedIdInterface;
import java.util.Set;
import org.json.JSONObject;

public final class iz implements gj<JSONObject>
{
    ja a;
    Set<InMobiUnifiedIdInterface> b;
    
    public iz(@NonNull final ja a, @NonNull final Set<InMobiUnifiedIdInterface> b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void a(@Nullable final gl gl) {
        synchronized (iy.class) {
            final HashMap<String, Object> hashMap;
            (hashMap = new HashMap<String, Object>()).put("errorCode", gl.a);
            gw.a().a("UnifiedIdNetworkResponseFailure", hashMap);
            if (this.a.a.get()) {
                return;
            }
            iy.d();
            this.a();
        }
    }
    
    private void a() {
        final JSONObject c = ix.c(iw.a());
        try {
            if (c != null && c.has("ufids") && c.getJSONArray("ufids").length() > 0) {
                final Iterator<InMobiUnifiedIdInterface> iterator = this.b.iterator();
                while (iterator.hasNext()) {
                    ix.a(iterator.next(), c, null);
                }
            }
            else {
                final Iterator<InMobiUnifiedIdInterface> iterator2 = this.b.iterator();
                while (iterator2.hasNext()) {
                    ix.a(iterator2.next(), null, new Error("Fetching the unifiedIds from ID Service has failed and there are no unified ids present in cache"));
                }
            }
        }
        catch (JSONException ex) {
            ex.printStackTrace();
        }
        finally {
            this.b.clear();
        }
    }
}

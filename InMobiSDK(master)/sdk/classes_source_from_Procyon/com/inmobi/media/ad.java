// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.UiThread;
import java.util.Map;
import java.util.HashMap;
import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import com.inmobi.ads.InMobiAdRequestStatus;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

final class ad extends ai<ar>
{
    @NonNull
    private final WeakReference<bz> a;
    @NonNull
    private byte[] b;
    private long c;
    private byte d;
    private String e;
    
    ad(@NonNull final t t, @NonNull final bz referent, @NonNull final byte[] b, final long c) {
        super(t, (byte)3);
        this.d = 0;
        this.e = null;
        this.a = new WeakReference<bz>(referent);
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final void b() {
        super.b();
        final bz bz;
        if ((bz = this.a.get()) != null) {
            bz.a.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.LOW_MEMORY), true, (byte)40);
        }
    }
    
    @Override
    public final void a() {
        final bz bz;
        if ((bz = this.a.get()) == null) {
            this.b(null);
            return;
        }
        final gn gn;
        (gn = new gn()).b(this.b);
        final cd cd = new cd(null, gn);
        try {
            final JSONObject jsonObject;
            if (this.c == (jsonObject = new JSONObject(cd.a.b())).getLong("placementId")) {
                this.b(bz.a.r().a(jsonObject, null));
                return;
            }
            hf.a((byte)1, "InMobi", "Placement Id of Request and response doesn't match");
            this.d = 46;
            throw new bf(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), this.d);
        }
        catch (bf bf) {
            this.c();
        }
        catch (JSONException ex) {
            this.e = ex.getMessage();
            this.c();
        }
    }
    
    private void c() {
        final String a = t.a;
        this.d = 1;
        this.b(null);
    }
}

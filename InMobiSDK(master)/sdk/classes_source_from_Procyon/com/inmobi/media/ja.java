// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.WorkerThread;
import java.util.HashMap;
import java.util.Map;
import com.inmobi.unifiedId.InMobiUserDataTypes;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;

public final class ja extends go
{
    protected ja(@NonNull final String s, @NonNull final String s2, @Nullable final id id, @NonNull final String s3, final int n, final int n2, final int m) {
        super(s, s2, id, s3, n, n2, "application/x-www-form-urlencoded");
        super.m = m;
    }
    
    @WorkerThread
    @Override
    public final void a() {
        super.a();
        final HashMap<String, String> c = hs.c();
        this.i.put("mk-version", ha.a());
        this.i.put("bundle-id", hm.a().a);
        this.i.put("ua", gz.i());
        this.i.put("ts", String.valueOf(System.currentTimeMillis()));
        this.i.put("account_id", this.v);
        final Boolean f;
        if ((f = ic.a().f()) == null) {
            this.i.put("lat", "true");
        }
        else {
            this.i.put("lat", f.toString());
        }
        if (c.get("u-age") != null) {
            this.i.put("age", (String)c.get("u-age"));
        }
        if (iv.b() != null) {
            this.i.put("email", new hv<InMobiUserDataTypes>().a(iv.b()).toString());
        }
        if (iv.a() != null) {
            this.i.put("phone", new hv<InMobiUserDataTypes>().a(iv.a()).toString());
        }
        this.i.put("ufids", ix.d().toString());
        if (iv.c() != null) {
            this.i.putAll(iv.c());
        }
    }
}

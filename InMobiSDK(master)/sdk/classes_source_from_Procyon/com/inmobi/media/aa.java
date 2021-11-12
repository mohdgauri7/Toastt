// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.UiThread;
import com.inmobi.ads.InMobiAdRequestStatus;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

final class aa extends ai<Boolean>
{
    @NonNull
    private final WeakReference<ab> a;
    @NonNull
    private final WeakReference<t.a> b;
    private byte c;
    
    aa(@NonNull final ab referent, @NonNull final t.a referent2) {
        super(referent, (byte)5);
        this.a = new WeakReference<ab>(referent);
        this.b = new WeakReference<t.a>(referent2);
    }
    
    @Override
    public final void b() {
        super.b();
        final ab ab;
        if ((ab = this.a.get()) == null) {
            return;
        }
        if (this.b.get() != null) {
            ab.a(this.b, (byte)40, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.LOW_MEMORY));
        }
    }
    
    @Override
    public final void a() {
        final ab ab;
        if ((ab = this.a.get()) == null) {
            this.b(Boolean.FALSE);
            return;
        }
        final t.a a;
        if ((a = this.b.get()) == null) {
            this.b(Boolean.FALSE);
            return;
        }
        final ab ab2;
        final ak u;
        if ((u = (ab2 = ab).u()) != null && !u.a(ab2.c.a(ab2.k()).timeToLive)) {
            this.c = ab.e(a);
            this.b(this.c == 0);
            return;
        }
        this.b(Boolean.FALSE);
    }
}

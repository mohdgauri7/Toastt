// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.ListIterator;
import java.util.LinkedList;
import com.inmobi.ads.InMobiAdRequestStatus;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

final class ah extends ai<Boolean>
{
    @NonNull
    private final WeakReference<t> a;
    @NonNull
    private final ak b;
    private final ar c;
    private final boolean d;
    @NonNull
    private InMobiAdRequestStatus e;
    
    ah(@NonNull final t referent, @NonNull final ak b, @NonNull final ar c, final boolean d, @NonNull final InMobiAdRequestStatus e) {
        super(referent, (byte)1);
        this.a = new WeakReference<t>(referent);
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    @Override
    public final void b() {
        super.b();
        this.e = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.LOW_MEMORY);
        this.a(Boolean.FALSE);
    }
    
    private void a(final Boolean b) {
        final t t;
        if ((t = this.a.get()) != null) {
            if (this.d) {
                t.b(b, this.e);
                return;
            }
            t.a(b, this.e);
        }
    }
    
    @Override
    public final void a() {
        final t t;
        if ((t = this.a.get()) == null) {
            this.b(Boolean.FALSE);
            return;
        }
        if (!this.c.d()) {
            this.b(t.a(this.b, 0));
            return;
        }
        final LinkedList<ak> b;
        if (t.a((b = this.c.b()).getFirst(), 0)) {
            final ListIterator<ak> listIterator = b.listIterator(1);
            while (listIterator.hasNext()) {
                final ak o = listIterator.next();
                if (!t.a(o, b.indexOf(o))) {
                    listIterator.remove();
                }
            }
            this.b(Boolean.TRUE);
            return;
        }
        this.b(Boolean.FALSE);
    }
}

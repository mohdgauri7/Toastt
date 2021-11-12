// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import org.json.JSONObject;
import androidx.annotation.WorkerThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class gi<T> implements Runnable
{
    private static final String b;
    Class<T> a;
    private go c;
    private gj d;
    
    public gi(@Nullable final gj<T> d, @NonNull final go c, @Nullable final Class<T> a) {
        this.d = d;
        this.c = c;
        this.a = a;
    }
    
    @WorkerThread
    public final void a() {
        new Thread(this).start();
    }
    
    @WorkerThread
    @Override
    public void run() {
        for (int i = 0; i <= this.c.b; ++i) {
            final gn a = new gk(this.c).a();
            if (this.c.a.get()) {
                return;
            }
            if (a.a()) {
                if (i == this.c.b) {
                    this.d.a(a.a);
                    return;
                }
            }
            else {
                try {
                    if (this.d != null) {
                        final JSONObject jsonObject = new JSONObject(a.b());
                        if (this.a.equals(JSONObject.class)) {
                            this.d.a(jsonObject);
                            return;
                        }
                        this.d.a(new hv<T>().a(jsonObject, this.a));
                    }
                    return;
                }
                catch (Exception ex) {
                    if (this.d != null && i == this.c.b) {
                        this.d.a(new gl(-10, ex.getMessage()));
                        return;
                    }
                }
            }
            try {
                Thread.sleep(this.c.c * 1000);
            }
            catch (InterruptedException ex2) {}
            if (this.c.a.get()) {
                return;
            }
        }
    }
    
    static {
        b = gi.class.getSimpleName();
    }
}

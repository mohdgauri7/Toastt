// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.NonNull;
import android.os.SystemClock;
import androidx.annotation.WorkerThread;
import java.util.Iterator;
import java.util.Map;

class fk implements Runnable
{
    private static final String a;
    private fl b;
    private a c;
    private final fl d;
    
    fk(final a c, final fl b, final fl d) {
        this.c = c;
        this.b = b;
        this.d = d;
    }
    
    private boolean a(final fl fl, final int n, final Map<String, fm.a> map) throws InterruptedException {
        if (n > fl.a) {
            final Iterator<Map.Entry<String, ff>> iterator = fl.c.entrySet().iterator();
            while (iterator.hasNext()) {
                final String s = iterator.next().getKey();
                if (map.containsKey(s)) {
                    this.c.a(map.get(s));
                }
            }
            return true;
        }
        Thread.sleep(fl.b * 1000);
        return false;
    }
    
    @WorkerThread
    private void a(final fl fl, final Map<String, fm.a> map) {
        final Iterator<Map.Entry<String, fm.a>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            final Map.Entry<String, fm.a> entry;
            final fm.a a = (entry = iterator.next()).getValue();
            final String s = entry.getKey();
            if (!a.a()) {
                this.c.a(a);
                fl.c.remove(s);
            }
        }
    }
    
    @WorkerThread
    @NonNull
    private static fm a(final fl fl) {
        return new fm(fl, new gp(fl).a(), SystemClock.elapsedRealtime() - SystemClock.elapsedRealtime());
    }
    
    @WorkerThread
    @Override
    public void run() {
        try {
            int i = 0;
            while (i <= this.b.a) {
                final fm a2;
                final Map<String, fm.a> a = (a2 = a(this.b)).a;
                if (a2.a() && this.d != null) {
                    int j = 0;
                    while (j <= this.d.a) {
                        final fm a4;
                        final Map<String, fm.a> a3 = (a4 = a(this.d)).a;
                        if (a4.a()) {
                            break;
                        }
                        this.a(this.d, a3);
                        if (this.d.c.isEmpty()) {
                            break;
                        }
                        ++j;
                        if (this.a(this.d, j, a3)) {
                            break;
                        }
                    }
                    this.c.a(this.d.b());
                    return;
                }
                this.a(this.b, a);
                if (this.b.c.isEmpty()) {
                    break;
                }
                ++i;
                if (this.a(this.b, i, a)) {
                    break;
                }
            }
            this.c.a(this.b.b());
        }
        catch (InterruptedException ex) {}
    }
    
    static {
        a = fk.class.getSimpleName();
    }
    
    public interface a
    {
        void a(final fm.a p0);
        
        void a(final String p0);
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import org.json.JSONException;
import java.util.Iterator;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.Executors;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;

public class da
{
    private static final String b;
    public ExecutorService a;
    private HashMap<String, List<WeakReference<db>>> c;
    
    public static da a() {
        return a.a;
    }
    
    private da() {
        this.a = Executors.newCachedThreadPool(new he(da.b));
        this.c = new HashMap<String, List<WeakReference<db>>>(2);
    }
    
    private synchronized boolean a(final String s, final db db) {
        final List<WeakReference<db>> list;
        if ((list = this.c.get(s)) != null) {
            list.add(new WeakReference<db>(db));
            return false;
        }
        final ArrayList<WeakReference<db>> value;
        (value = new ArrayList<WeakReference<db>>()).add(new WeakReference<db>(db));
        this.c.put(s, value);
        return true;
    }
    
    private synchronized void a(final ak ak, final boolean b, final byte b2) {
        final List<WeakReference<db>> list;
        if ((list = this.c.remove(ak.f())) != null) {
            final Iterator<WeakReference<db>> iterator = list.iterator();
            while (iterator.hasNext()) {
                final db db;
                if ((db = iterator.next().get()) != null) {
                    new Handler(Looper.getMainLooper()).post((Runnable)new Runnable() {
                        @Override
                        public final void run() {
                            db.a(ak, b, b2);
                        }
                    });
                }
            }
        }
    }
    
    static {
        b = da.class.getSimpleName();
    }
    
    static final class a
    {
        static final da a;
        
        static {
            a = new da((byte)0);
        }
    }
}

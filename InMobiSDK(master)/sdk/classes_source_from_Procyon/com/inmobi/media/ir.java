// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.Map;
import java.util.HashMap;
import androidx.annotation.Nullable;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import androidx.annotation.WorkerThread;
import java.io.File;
import androidx.annotation.NonNull;
import android.content.Context;
import androidx.annotation.UiThread;
import com.iab.omid.library.inmobi.Omid;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.annotation.VisibleForTesting;

public final class ir
{
    private static final String b;
    @VisibleForTesting
    public static boolean a;
    private static hc.c c;
    
    @UiThread
    public static boolean a() {
        try {
            CustomTabsClient.class.getName();
            Omid.class.getName();
        }
        catch (NoClassDefFoundError noClassDefFoundError) {
            return true;
        }
        return false;
    }
    
    @WorkerThread
    public static void a(@NonNull final Context context) {
        if (ha.a(context) == null || !ha.a(context).equals(ha.b())) {
            ha.a(context, ie.a(context));
            ha.a(context, ha.b());
            final Context applicationContext;
            final File b = gz.b(applicationContext = context.getApplicationContext());
            final File c = gz.c(applicationContext);
            gz.a(b, null);
            gz.a(c, null);
            gz.d(applicationContext);
            if (!b.mkdir()) {
                b.isDirectory();
            }
            if (!c.mkdir()) {
                c.isDirectory();
            }
        }
    }
    
    @UiThread
    public static void b(@NonNull final Context context) {
        final hc a;
        if ((a = hc.a()) != null) {
            a.a(context, ir.c);
        }
    }
    
    @WorkerThread
    public static void c(@NonNull final Context context) {
        if (ir.a) {
            return;
        }
        fg.a();
        gw.a().b();
        ic.a().b();
        gz.a(new Runnable() {
            @Override
            public final void run() {
                if (ha.b(context) && ie.b(context).isEmpty()) {
                    ha.a(context, false);
                }
                hs.a();
                iw.c();
                ho.d();
                ir.d();
                try {
                    aw.a().b();
                    aw.a().d();
                }
                catch (Exception ex) {
                    ir.b;
                }
                ir.a = true;
            }
        });
    }
    
    @WorkerThread
    @VisibleForTesting
    public static void b() {
        try {
            fg.b();
            final gw a = gw.a();
            gw.a.set(true);
            if (a.c != null) {
                final gc c;
                if ((c = a.c).e != null) {
                    c.e.shutdownNow();
                    c.e = null;
                }
                c.a.set(false);
                c.b.set(true);
                c.d.clear();
                c.c.clear();
                a.c = null;
            }
            ii.a().c();
            aw.a().c();
        }
        catch (Exception ex) {
            hf.a((byte)1, ir.b, "SDK encountered unexpected error while stopping internal components");
        }
    }
    
    public static void a(final ip obj) {
        OutputStream out = null;
        Closeable closeable = null;
        try {
            gz.l();
            final Context c;
            if ((c = gz.c()) != null) {
                final File file;
                if ((file = new File(gz.c(c), "asConfigs")).exists()) {
                    file.delete();
                }
                out = new FileOutputStream(file);
                ((ObjectOutputStream)(closeable = new ObjectOutputStream(out))).writeObject(obj);
            }
        }
        catch (IOException ex) {}
        finally {
            hg.a(out);
            hg.a(closeable);
        }
    }
    
    @Nullable
    public static ip c() {
        InputStream in = null;
        Closeable closeable = null;
        try {
            final File file;
            if (gz.c() != null && (file = new File(gz.c(gz.c()), "asConfigs")).exists()) {
                in = new FileInputStream(file);
                final ip ip = (ip)((ObjectInputStream)(closeable = new ObjectInputStream(in))).readObject();
            }
        }
        catch (IOException ex) {}
        catch (ClassNotFoundException ex2) {}
        finally {
            hg.a((Closeable)in);
            hg.a(closeable);
        }
        return;
    }
    
    static /* synthetic */ void d() {
        try {
            ic.a().b();
            fg.a();
            ba.a().b();
            final fv a = fv.a();
            fv.a.set(false);
            a.b = (fo)fg.a("crashReporting", gz.f(), a);
            final fv fv = a;
            fv.d = fv.b.url;
            if (a.c.a() > 0) {
                a.b();
            }
            gw.a().b();
            ii.a().b();
            aw.a().b();
            gw.a().a("SessionStarted", new HashMap<String, Object>());
        }
        catch (Exception ex) {
            hf.a((byte)2, ir.b, "SDK encountered unexpected error while starting internal components");
        }
    }
    
    static {
        b = ir.class.getSimpleName();
        ir.c = new a((byte)0);
    }
    
    static final class a implements hc.c
    {
        private a() {
        }
        
        @UiThread
        @Override
        public final void a(final boolean b) {
            gz.b(b);
            gz.a(new Runnable() {
                @WorkerThread
                @Override
                public final void run() {
                    if (b) {
                        ir.d();
                        return;
                    }
                    ir.b();
                }
            });
        }
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.Executors;
import androidx.annotation.WorkerThread;
import android.content.Intent;
import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.webkit.WebSettings;
import android.annotation.TargetApi;
import java.io.File;
import android.text.TextUtils;
import android.app.Application;
import androidx.annotation.Nullable;
import android.webkit.WebView;
import android.os.Build;
import androidx.annotation.NonNull;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import android.content.Context;

public final class gz
{
    private static final String a;
    private static Context b;
    private static String c;
    private static String d;
    private static String e;
    private static AtomicBoolean f;
    private static boolean g;
    private static final ExecutorService h;
    
    public static void a(@NonNull final Runnable runnable) {
        gz.h.submit(runnable);
    }
    
    private static void e(@NonNull final Context context) {
        a(context.getApplicationContext());
        gz.f.set(true);
        if (Build.VERSION.SDK_INT >= 17 || gz.c != null) {
            return;
        }
        try {
            gz.c = new WebView(context).getSettings().getUserAgentString();
        }
        catch (Exception ex) {
            a((Context)null);
        }
    }
    
    public static void a(@NonNull final Context context, @NonNull final String d) {
        e(context);
        gz.d = d;
    }
    
    public static void b(@NonNull final Context context, @NonNull final String e) {
        e(context);
        gz.e = e;
    }
    
    public static boolean a() {
        return gz.b != null;
    }
    
    public static boolean b() {
        return gz.b != null && gz.d != null;
    }
    
    @Nullable
    public static Context c() {
        return gz.b;
    }
    
    @Nullable
    public static Application d() {
        if (gz.b == null) {
            return null;
        }
        final Context applicationContext;
        if ((applicationContext = gz.b.getApplicationContext()) instanceof Application) {
            return (Application)applicationContext;
        }
        return null;
    }
    
    public static void a(@Nullable final Context b) {
        gz.b = b;
    }
    
    public static void a(final boolean g) {
        gz.g = g;
    }
    
    public static boolean e() {
        return gz.g;
    }
    
    @Nullable
    public static String f() {
        if (gz.d == null) {
            return gz.e;
        }
        return gz.d;
    }
    
    @Nullable
    public static String g() {
        return gz.d;
    }
    
    @Nullable
    public static String h() {
        return gz.e;
    }
    
    public static String i() {
        if (TextUtils.isEmpty((CharSequence)gz.c) && Build.VERSION.SDK_INT >= 17) {
            gz.c = f(gz.b);
        }
        return gz.c;
    }
    
    public static boolean j() {
        return gz.f.get();
    }
    
    public static void b(final boolean newValue) {
        gz.f.set(newValue);
    }
    
    public static File b(final Context context) {
        return new File(context.getFilesDir(), "im_cached_content");
    }
    
    public static File c(@NonNull final Context context) {
        return new File(context.getFilesDir(), "as_cached_content");
    }
    
    public static void a(final File parent, final String child) {
        if (child != null && 0 != child.trim().length()) {
            ie.a(new File(parent, child));
            return;
        }
        ie.a(parent);
    }
    
    public static void d(@NonNull final Context context) {
        try {
            final File file;
            if ((file = new File(context.getCacheDir(), "im_cached_content")).exists()) {
                ie.a(file);
            }
        }
        catch (Exception ex) {}
    }
    
    public static void k() {
        final Context c;
        final File b;
        if ((c = c()) != null && !(b = b(c)).mkdir()) {
            b.isDirectory();
        }
    }
    
    public static void l() {
        final Context c;
        final File c2;
        if ((c = c()) != null && !(c2 = c(c)).mkdir()) {
            c2.isDirectory();
        }
    }
    
    @TargetApi(17)
    private static String f(final Context context) {
        String property = "";
        try {
            return g(context);
        }
        catch (bg bg) {
            fv.a().a(new gv(bg));
            try {
                if ((property = System.getProperty("http.agent")) == null) {
                    return "";
                }
            }
            catch (Exception ex) {
                fv.a().a(new gv(ex));
            }
            return property;
        }
    }
    
    @TargetApi(17)
    private static String g(final Context context) throws bg {
        try {
            return WebSettings.getDefaultUserAgent(context.getApplicationContext());
        }
        catch (Exception ex) {
            throw new bg(ex.getMessage());
        }
    }
    
    public static boolean c(final Context context, final String s) {
        if (context == null || s == null) {
            return false;
        }
        final PackageManager packageManager = context.getPackageManager();
        boolean d;
        if (Build.VERSION.SDK_INT < 23) {
            d = (0 == packageManager.checkPermission(s, packageManager.getNameForUid(Binder.getCallingUid())));
        }
        else {
            d = d(context, s);
        }
        return d;
    }
    
    private static boolean d(final Context context, final String anObject) {
        if (context == null || anObject == null) {
            return false;
        }
        try {
            final PackageInfo packageInfo;
            if ((packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096)).requestedPermissions != null) {
                String[] requestedPermissions;
                for (int length = (requestedPermissions = packageInfo.requestedPermissions).length, i = 0; i < length; ++i) {
                    if (requestedPermissions[i].equals(anObject)) {
                        return true;
                    }
                }
            }
        }
        catch (Exception ex) {}
        return false;
    }
    
    public static void a(final Context context, final Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (!(context instanceof Activity)) {
            return;
        }
        ((Activity)context).getApplication().unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        ((Activity)context).getApplication().registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }
    
    public static void a(final Context context, final Intent intent) {
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }
    
    public static File a(final String s) {
        k();
        final File b = b(c());
        final int n = s.length() / 2;
        return new File(b, String.valueOf(s.substring(0, n).hashCode() & Integer.MAX_VALUE) + String.valueOf(s.substring(n).hashCode() & Integer.MAX_VALUE));
    }
    
    @WorkerThread
    public static void b(final String s) {
        if (c() != null) {
            gu.a(c(), "coppa_store").a("im_accid", s);
        }
    }
    
    @Nullable
    @WorkerThread
    public static String m() {
        if (c() != null) {
            return gu.a(c(), "coppa_store").b("im_accid");
        }
        return null;
    }
    
    static {
        a = gz.class.getSimpleName();
        gz.c = "";
        gz.d = null;
        gz.e = null;
        gz.f = new AtomicBoolean();
        gz.g = false;
        h = Executors.newSingleThreadExecutor(new he(gz.a));
    }
}

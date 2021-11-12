// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.annotation.SuppressLint;
import android.security.NetworkSecurityPolicy;
import android.content.pm.PackageInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.Context;
import android.os.Build;
import java.util.HashMap;
import java.util.Map;

public class hm
{
    private static final String e;
    public String a;
    private String f;
    private String g;
    public String b;
    public Map<String, String> c;
    public byte d;
    
    private hm() {
        this.c = new HashMap<String, String>();
        final Context c = gz.c();
        try {
            final PackageManager packageManager;
            final ApplicationInfo applicationInfo;
            if ((applicationInfo = (packageManager = c.getPackageManager()).getApplicationInfo(c.getPackageName(), 128)) != null) {
                this.a = applicationInfo.packageName;
                this.f = applicationInfo.loadLabel(packageManager).toString();
                this.b = packageManager.getInstallerPackageName(this.a);
            }
            final PackageInfo packageInfo = packageManager.getPackageInfo(c.getPackageName(), 128);
            String g = null;
            if (packageInfo != null && ((g = packageInfo.versionName) == null || "".equals(g))) {
                if (Build.VERSION.SDK_INT < 28) {
                    g = new StringBuilder().append(packageInfo.versionCode).toString();
                }
                else {
                    g = new StringBuilder().append(packageInfo.getLongVersionCode()).toString();
                }
            }
            if (g != null && !"".equals(g)) {
                this.g = g;
            }
        }
        catch (Exception ex) {}
        this.d = b();
        this.c.put("u-appbid", this.a);
        this.c.put("u-appdnm", this.f);
        this.c.put("u-appver", this.g);
        this.c.put("u-appsecure", Byte.toString(this.d));
    }
    
    public static hm a() {
        return a.a;
    }
    
    @SuppressLint({ "NewApi" })
    private static byte b() {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                if (NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
                    return 0;
                }
                return 1;
            }
        }
        catch (Exception ex) {
            return 2;
        }
        return 0;
    }
    
    static {
        e = hm.class.getSimpleName();
    }
    
    static final class a
    {
        static final hm a;
        
        static {
            a = new hm((byte)0);
        }
    }
}

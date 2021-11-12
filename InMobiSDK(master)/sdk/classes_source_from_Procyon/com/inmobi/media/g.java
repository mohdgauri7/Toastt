// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.content.IntentFilter;
import android.util.Log;
import java.util.Iterator;
import java.util.List;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.content.pm.ResolveInfo;
import java.util.ArrayList;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.Nullable;
import android.content.Context;

public final class g
{
    private static final String a;
    private static String b;
    
    private g() {
    }
    
    public static String a(@Nullable final Context context) {
        if (context == null || g.b != null) {
            return g.b;
        }
        try {
            final PackageManager packageManager = context.getPackageManager();
            final Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.google.com"));
            final ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
            CharSequence packageName = null;
            if (resolveActivity != null) {
                packageName = resolveActivity.activityInfo.packageName;
            }
            final List queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
            final ArrayList<String> list = new ArrayList<String>();
            for (final ResolveInfo resolveInfo : queryIntentActivities) {
                final Intent intent2;
                (intent2 = new Intent()).setAction("android.support.customtabs.action.CustomTabsService");
                intent2.setPackage(resolveInfo.activityInfo.packageName);
                if (packageManager.resolveService(intent2, 0) != null) {
                    list.add(resolveInfo.activityInfo.packageName);
                }
            }
            if (list.isEmpty()) {
                g.b = null;
            }
            else if (list.size() == 1) {
                g.b = (String)list.get(0);
            }
            else if (!TextUtils.isEmpty(packageName) && !a(context, intent) && list.contains(packageName)) {
                g.b = (String)packageName;
            }
            else if (list.contains("com.android.chrome")) {
                g.b = "com.android.chrome";
            }
            else if (list.contains("com.chrome.beta")) {
                g.b = "com.chrome.beta";
            }
            else if (list.contains("com.chrome.dev")) {
                g.b = "com.chrome.dev";
            }
            else if (list.contains("com.google.android.apps.chrome")) {
                g.b = "com.google.android.apps.chrome";
            }
        }
        catch (Exception ex) {}
        return g.b;
    }
    
    private static boolean a(final Context context, final Intent intent) {
        try {
            final List queryIntentActivities;
            if ((queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 64)) == null || queryIntentActivities.size() == 0) {
                return false;
            }
            final Iterator<ResolveInfo> iterator = queryIntentActivities.iterator();
            while (iterator.hasNext()) {
                final ResolveInfo resolveInfo;
                final IntentFilter filter;
                if ((filter = (resolveInfo = iterator.next()).filter) != null && filter.countDataAuthorities() != 0 && filter.countDataPaths() != 0 && resolveInfo.activityInfo != null) {
                    return true;
                }
            }
        }
        catch (RuntimeException ex) {
            Log.e(g.a, "Runtime exception while getting specialized handlers");
        }
        return false;
    }
    
    static {
        a = g.class.getSimpleName();
    }
}

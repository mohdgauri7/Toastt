// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.Iterator;
import android.content.ComponentName;
import java.util.ArrayList;
import java.util.List;
import java.net.URLDecoder;
import java.net.URISyntaxException;
import android.text.TextUtils;
import android.content.ActivityNotFoundException;
import android.content.pm.ResolveInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.content.Intent;
import android.net.Uri;
import android.content.Context;

public class hd
{
    private static final String a;
    
    public static boolean a(final Context context, final String s) {
        if (s == null) {
            return false;
        }
        if (context != null) {
            try {
                return new Intent("android.intent.action.VIEW", Uri.parse(s)).resolveActivity(context.getPackageManager()) != null;
            }
            catch (Exception ex) {
                return false;
            }
        }
        return a(Uri.parse(s));
    }
    
    public static void a(@Nullable final Context context, @NonNull final Uri uri, @Nullable final ResolveInfo resolveInfo) throws ActivityNotFoundException {
        if (context == null) {
            return;
        }
        final Intent intent = new Intent("android.intent.action.VIEW", uri);
        if (resolveInfo != null) {
            intent.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        }
        intent.setFlags(268435456);
        context.startActivity(intent);
    }
    
    public static void b(final Context context, @NonNull String b) throws URISyntaxException, ActivityNotFoundException {
        while (context != null) {
            try {
                final Intent uri;
                (uri = Intent.parseUri(b, 0)).setFlags(268435456);
                context.startActivity(uri);
            }
            catch (ActivityNotFoundException ex) {
                if (!"intent".equals(Uri.parse(b).getScheme()) || TextUtils.isEmpty((CharSequence)(b = b(b)))) {
                    throw ex;
                }
                continue;
            }
        }
    }
    
    @Nullable
    public static String a(@Nullable final Context context, @NonNull String b, @Nullable final String s) {
        if (context == null) {
            return null;
        }
        try {
            final Intent uri;
            if ((uri = Intent.parseUri(b, 0)).resolveActivity(context.getPackageManager()) != null) {
                uri.setFlags(268435456);
                context.startActivity(uri);
                return b;
            }
            if (!TextUtils.isEmpty((CharSequence)s)) {
                return a(context, s, null);
            }
            if ("intent".equals(Uri.parse(b).getScheme()) && !TextUtils.isEmpty((CharSequence)(b = b(b)))) {
                return a(context, URLDecoder.decode(b, "UTF-8"), null);
            }
        }
        catch (Exception ex) {}
        return null;
    }
    
    @Nullable
    private static String b(final String s) {
        String stringExtra = null;
        try {
            stringExtra = Intent.parseUri(s, 1).getStringExtra("browser_fallback_url");
        }
        catch (URISyntaxException ex) {}
        return stringExtra;
    }
    
    public static boolean a(@NonNull final Uri uri) {
        return "http".equals(uri.getScheme()) || "https".equals(uri.getScheme());
    }
    
    public static boolean a(@NonNull final String s) {
        final Uri parse;
        return a(parse = Uri.parse(s)) && !"play.google.com".equals(parse.getHost()) && !"market.android.com".equals(parse.getHost()) && !"market".equals(parse.getScheme());
    }
    
    public static void c(final Context context, @NonNull final String s) {
        if (context == null) {
            return;
        }
        if (!a(context)) {
            return;
        }
        if (TextUtils.isEmpty((CharSequence)s)) {
            return;
        }
        if (!a(Uri.parse(s))) {
            return;
        }
        a(context, Uri.parse(s), d(context, s).get(0));
    }
    
    public static boolean a(final Context context) {
        return d(context, "http://").size() > 0;
    }
    
    public static List<ResolveInfo> d(@Nullable final Context context, @NonNull final String s) {
        final ArrayList<ResolveInfo> list = new ArrayList<ResolveInfo>();
        if (TextUtils.isEmpty((CharSequence)s)) {
            return list;
        }
        if (context == null) {
            return list;
        }
        final Uri parse = Uri.parse(s);
        final Intent intent;
        (intent = new Intent()).setAction("android.intent.action.VIEW");
        intent.setData(parse);
        final Iterator iterator = context.getPackageManager().queryIntentActivityOptions((ComponentName)null, (Intent[])null, intent, 0).iterator();
        while (iterator.hasNext()) {
            final ResolveInfo resolveInfo;
            if ((resolveInfo = iterator.next()).activityInfo.exported) {
                list.add(resolveInfo);
            }
        }
        return list;
    }
    
    static {
        a = hd.class.getSimpleName();
    }
}

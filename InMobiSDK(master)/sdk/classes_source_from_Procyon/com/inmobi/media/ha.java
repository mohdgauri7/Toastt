// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import android.content.Context;
import android.text.TextUtils;

public final class ha
{
    private static String a;
    private static String b;
    
    public static String a() {
        final String str = "";
        String str2 = "pr-SAND-" + b() + "-20211018";
        if (!TextUtils.isEmpty((CharSequence)str)) {
            str2 = str2 + "-" + str;
        }
        return str2;
    }
    
    public static String b() {
        return "10.0.1";
    }
    
    public static String c() {
        return "2.0";
    }
    
    public static String d() {
        return "android";
    }
    
    public static String e() {
        return "https://www.inmobi.com/products/sdk/#downloads";
    }
    
    public static String a(@NonNull final Context context) {
        return gu.a(context, "sdk_version_store").b("sdk_version");
    }
    
    public static void a(@NonNull final Context context, final String s) {
        gu.a(context, "sdk_version_store").a("sdk_version", s);
    }
    
    public static boolean b(@NonNull final Context context) {
        return gu.a(context, "sdk_version_store").b("db_deletion_failed", false);
    }
    
    public static void a(@NonNull final Context context, final boolean b) {
        gu.a(context, "sdk_version_store").a("db_deletion_failed", b);
    }
    
    public static void a(@Nullable final String a) {
        if (!TextUtils.isEmpty((CharSequence)a)) {
            ha.a = a;
        }
    }
    
    public static void b(@Nullable final String b) {
        if (!TextUtils.isEmpty((CharSequence)b)) {
            ha.b = b;
        }
    }
    
    public static String f() {
        return ha.b;
    }
    
    public static String g() {
        return ha.a;
    }
    
    static {
        ha.a = "dir";
        ha.b = null;
    }
}

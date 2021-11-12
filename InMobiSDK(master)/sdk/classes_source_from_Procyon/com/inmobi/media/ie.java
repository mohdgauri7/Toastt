// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.net.Uri;
import java.util.HashSet;
import java.util.ArrayList;
import android.annotation.SuppressLint;
import java.util.List;
import java.util.Iterator;
import android.os.Build;
import java.io.File;
import java.util.Arrays;
import androidx.annotation.NonNull;
import android.content.Context;

public final class ie
{
    private static final String a;
    
    @SuppressLint({ "SdCardPath" })
    public static boolean a(@NonNull final Context context) {
        final Iterator<String> iterator = Arrays.asList("carbpreference", "IMAdMLtvpRuleCache", "inmobiAppAnalyticsSession", "aeskeygenerate", "impref", "IMAdTrackerStatusUpload", "IMAdMMediationCache", "inmobiAppAnalyticsAppId", "inmobiAppAnalyticsSession", "inmobisdkaid", "IMAdTrackerStatusUpload", "testAppPref").iterator();
        while (iterator.hasNext()) {
            final File file;
            if ((file = new File("/data/data/" + context.getPackageName() + "/shared_prefs/" + iterator.next() + ".xml")).exists()) {
                file.delete();
            }
        }
        final List<String> list = Arrays.asList(gu.a("carb_store"), gu.a("aes_key_store"), gu.a("mraid_js_store"), gu.a("omid_js_store"), gu.a("user_info_store"), gu.a("coppa_store"), gu.a("gesture_info_store"), gu.a("unified_id_info_store"), gu.a("app_bundle_store"));
        if (Build.VERSION.SDK_INT >= 24) {
            final Iterator<String> iterator2 = list.iterator();
            while (iterator2.hasNext()) {
                context.deleteSharedPreferences((String)iterator2.next());
            }
        }
        else {
            final Iterator<String> iterator3 = list.iterator();
            while (iterator3.hasNext()) {
                final File file2;
                if ((file2 = new File("/data/data/" + context.getPackageName() + "/shared_prefs/" + iterator3.next() + ".xml")).exists()) {
                    file2.delete();
                }
            }
        }
        for (final String child : Arrays.asList("inmobi.cache", "inmobi.cache.data", "inmobi.cache.data.events.number", "inmobi.cache.data.events.timestamp")) {
            final File file3;
            if (context.getCacheDir() != null && (file3 = new File(context.getCacheDir(), child)).exists()) {
                file3.delete();
            }
        }
        for (final String child2 : Arrays.asList("eventlog", "imai_click_events")) {
            final File file4;
            if (context.getDir("data", 0) != null && (file4 = new File(context.getDir("data", 0), child2)).exists()) {
                file4.delete();
            }
        }
        return b(context).size() != 0;
    }
    
    private static boolean a(final Context context, final String s) {
        final File databasePath;
        return (databasePath = context.getDatabasePath(s)) == null || !databasePath.exists() || context.deleteDatabase(s);
    }
    
    public static List<String> b(final Context context) {
        final ArrayList<String> list = new ArrayList<String>();
        final HashSet<String> set;
        (set = new HashSet<String>()).add("adcache.db");
        set.add("appengage.db");
        set.add("im.db");
        set.add("ltvp.db");
        set.add("analytics.db");
        set.add("com.im.db");
        set.add("IMInitialization.db");
        final String[] databaseList;
        if ((databaseList = context.databaseList()) != null && databaseList.length > 0) {
            for (final String s : databaseList) {
                if (set.contains(s) && !a(context, s)) {
                    list.add(s);
                }
                else if (s.matches("com\\.im_([0-9]+\\.){3}db") && !s.equals(gs.a) && !a(context, s)) {
                    list.add(s);
                }
            }
        }
        return list;
    }
    
    public static void a(final File file) {
        try {
            if (file.exists()) {
                final File[] listFiles;
                if ((listFiles = file.listFiles()) != null) {
                    for (int length = listFiles.length, i = 0; i < length; ++i) {
                        final File file2;
                        if ((file2 = listFiles[i]).isDirectory()) {
                            a(file2);
                        }
                        else {
                            file2.delete();
                        }
                    }
                }
                file.delete();
            }
        }
        catch (Exception ex) {}
    }
    
    public static long a(final String s) {
        long length = 0L;
        try {
            final File file;
            if ((file = new File(Uri.parse(s).getPath())).exists()) {
                length = file.length();
            }
        }
        catch (Exception ex) {
            length = 0L;
        }
        return length;
    }
    
    static {
        a = ie.class.getSimpleName();
    }
}

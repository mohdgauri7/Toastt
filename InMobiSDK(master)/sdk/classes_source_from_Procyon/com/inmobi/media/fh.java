// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import androidx.annotation.NonNull;
import android.content.ContentValues;

public class fh
{
    private static final String a;
    private static final String[] b;
    
    @Nullable
    private static ff a(@NonNull final ContentValues contentValues) throws JSONException {
        final String asString;
        if ((asString = contentValues.getAsString("config_value")) == null) {
            return null;
        }
        return ff.a(contentValues.getAsString("config_type"), new JSONObject(asString), contentValues.getAsString("account_id"));
    }
    
    private static String[] d(final String s, @NonNull final String s2) {
        return new String[] { s2, s };
    }
    
    @VisibleForTesting(otherwise = 3)
    public fh() {
        final gt a;
        (a = gt.a()).a("config_db", "(account_id TEXT NOT NULL,config_value TEXT NOT NULL,config_type TEXT NOT NULL,update_ts INTEGER DEFAULT 0,UNIQUE(account_id,config_type))");
        a.b();
    }
    
    public static void a(final ff ff) {
        try {
            if (null == ff.g()) {
                return;
            }
            final gt a = gt.a();
            final String s = "config_db";
            final ContentValues contentValues;
            (contentValues = new ContentValues()).put("account_id", ff.g());
            JSONObject c;
            if ((c = ff.c()) == null) {
                c = new JSONObject();
            }
            contentValues.put("config_value", c.toString());
            contentValues.put("config_type", ff.b());
            contentValues.put("update_ts", Long.valueOf(System.currentTimeMillis()));
            a.a(s, contentValues, "account_id=? AND config_type=?", d(ff.b(), ff.g()));
            a.b();
        }
        catch (Exception ex) {}
    }
    
    @NonNull
    public static ff a(@NonNull final String s, @NonNull final String s2) {
        ff ff = null;
        try {
            final gt a2;
            final List<ContentValues> a;
            if (!(a = (a2 = gt.a()).a("config_db", fh.b, "account_id=? AND config_type=?", d(s, s2), null, null, null, null)).isEmpty()) {
                ff = a(a.get(0));
            }
            a2.b();
        }
        catch (Exception ex) {}
        if (ff == null) {
            ff = com.inmobi.media.ff.a(s, null);
        }
        return ff;
    }
    
    @NonNull
    public static LinkedList<ff> a() {
        final LinkedList<ff> list = new LinkedList<ff>();
        try {
            final gt a2;
            final List<ContentValues> a;
            if (!(a = (a2 = gt.a()).a("config_db", fh.b, null, null, null, null, null, null)).isEmpty()) {
                final Iterator<ContentValues> iterator = a.iterator();
                while (iterator.hasNext()) {
                    list.add(a(iterator.next()));
                }
            }
            a2.b();
        }
        catch (Exception ex) {}
        return list;
    }
    
    public static boolean b(@NonNull final String s, @NonNull final String s2) {
        try {
            final gt a;
            final int b = (a = gt.a()).b("config_db", "account_id=? AND config_type=?", d(s, s2));
            a.b();
            return b <= 0;
        }
        catch (Exception ex) {
            return true;
        }
    }
    
    public static long c(@NonNull final String s, @NonNull final String s2) {
        long longValue = 0L;
        try {
            final gt a2;
            final List<ContentValues> a;
            if (!(a = (a2 = gt.a()).a("config_db", fh.b, "account_id=? AND config_type=?", d(s, s2), null, null, null, null)).isEmpty()) {
                longValue = a.get(0).getAsLong("update_ts");
            }
            a2.b();
        }
        catch (Exception ex) {}
        return longValue;
    }
    
    public static void a(@NonNull final String s, @NonNull final String s2, final long l) {
        try {
            final gt a = gt.a();
            final ContentValues contentValues;
            (contentValues = new ContentValues()).put("update_ts", Long.valueOf(l));
            a.b("config_db", contentValues, "account_id=? AND config_type=?", d(s, s2));
            a.b();
        }
        catch (Exception ex) {}
    }
    
    static {
        a = fh.class.getSimpleName();
        b = new String[] { "account_id", "config_value", "config_type", "update_ts" };
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import org.json.JSONException;
import android.net.Uri;
import org.json.JSONObject;
import java.io.File;
import androidx.annotation.NonNull;

public final class an
{
    private static final String b;
    av a;
    
    an(final av a) {
        this.a = a;
    }
    
    static String a(@NonNull final al al, final File file, final long n, final long n2) {
        final JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("url", (Object)al.d);
            jsonObject.put("saved_url", (Object)Uri.fromFile(file));
            jsonObject.put("size_in_bytes", file.length());
            jsonObject.put("download_started_at", n);
            jsonObject.put("download_ended_at", n2);
        }
        catch (JSONException ex) {
            fv.a().a(new gv((Throwable)ex));
        }
        return jsonObject.toString().replace("\"", "\\\"");
    }
    
    static void a(final long n, final long n2, final long n3) {
        try {
            ih.a().a(0L);
            ih.a().b(n2);
            ih.a().c(n3 - n);
        }
        catch (Exception ex) {
            fv.a().a(new gv(ex));
        }
    }
    
    static {
        b = an.class.getSimpleName();
    }
}

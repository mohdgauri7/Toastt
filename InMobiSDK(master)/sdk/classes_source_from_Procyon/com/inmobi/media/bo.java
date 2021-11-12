// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.os.Build;
import java.util.List;
import java.util.LinkedList;
import org.json.JSONObject;

public class bo extends bj
{
    private static final String A;
    public ej z;
    
    bo(final String s, final String s2, final bk bk, final String s3, final byte b, final JSONObject jsonObject) {
        this(s, s2, bk, s3, new LinkedList<bv>(), b, jsonObject);
    }
    
    bo(String e, final String s, final bk bk, final String s2, final List<bv> list, final byte i, final JSONObject f) {
        super(e, s, "GIF", bk, list);
        au.a();
        final al b = au.b(s2);
        this.e = ((b == null) ? null : b.e);
        if (b != null) {
            try {
                e = b.e;
                this.z = ((Build.VERSION.SDK_INT < 28) ? new ek(e) : new eh(e));
            }
            catch (Exception ex) {
                this.z = null;
                fv.a().a(new gv(ex));
            }
        }
        if (f != null) {
            this.i = i;
            this.f = f;
        }
    }
    
    static {
        A = bo.class.getSimpleName();
    }
}

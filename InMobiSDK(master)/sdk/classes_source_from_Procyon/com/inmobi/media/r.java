// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.view.MotionEvent;
import org.json.JSONArray;

public class r
{
    public float a;
    public float b;
    public float c;
    public float d;
    public int e;
    public int f;
    public float g;
    public JSONArray h;
    public MotionEvent i;
    public int j;
    private final String l;
    public final a k;
    
    public r(final a k) {
        this.j = Integer.MAX_VALUE;
        this.l = r.class.getSimpleName();
        this.k = k;
        this.e = -1;
        this.f = -1;
    }
    
    public static int a(final float n, final float n2, final float n3, final float n4) {
        return (int)Math.sqrt((n - n2) * (n - n2) + (n3 - n4) * (n3 - n4));
    }
    
    public static float a(float n, float n2, final float n3, final float n4, final float n5, final float n6, final float n7, final float n8) {
        n = (float)Math.atan2(n2 - n4, n - n3);
        n2 = (float)Math.atan2(n6 - n8, n5 - n7);
        if ((n = (float)Math.toDegrees(n - n2) % 360.0f) < -180.0f) {
            n += 360.0f;
        }
        if (n > 180.0f) {
            n -= 360.0f;
        }
        return n;
    }
    
    public interface a
    {
        void a(final MotionEvent p0, final MotionEvent p1);
        
        void a(final r p0);
        
        void a(final MotionEvent p0);
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.List;
import android.graphics.Point;

public final class cv
{
    @Nullable
    public static cw a(final bw bw, final bj bj) {
        final dd b = bw.b();
        final Point a = bj.c.a;
        final List<cw> e = b.e();
        final float c = ho.a().c;
        final double n = a.y / c;
        final double n3;
        final double n2 = (n3 = a.x / c) / n;
        final double n4 = n3 * n;
        double n5 = -1.0;
        double n6 = 0.0;
        cw cw = null;
        final Iterator<cw> iterator = e.iterator();
        while (iterator.hasNext()) {
            final cw cw2;
            final int b2 = (cw2 = iterator.next()).b;
            final int a2;
            double n7;
            double n8;
            if (n2 > (a2 = cw2.a) / (double)b2) {
                n7 = a2 * (n / b2);
                n8 = n;
            }
            else {
                n7 = n3;
                n8 = b2 * (n3 / a2);
            }
            final double n9;
            if (b2 >= n8 * 0.33 && a2 >= n7 * 0.33 && (n9 = n7 * n8) > 0.5 * n4) {
                if (n9 > n5) {
                    n5 = n9;
                    cw = cw2;
                    n6 = b2 / n8;
                }
                else {
                    if (n9 != n5) {
                        continue;
                    }
                    final float c2 = ho.a().c;
                    final double n10;
                    if (((n10 = b2 / n8) <= n6 || n6 >= c2) && (n6 <= c2 || n10 >= n6 || n10 <= c2)) {
                        continue;
                    }
                    cw = cw2;
                    n6 = n10;
                }
            }
        }
        return cw;
    }
}

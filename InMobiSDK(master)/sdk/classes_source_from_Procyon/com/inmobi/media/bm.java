// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import java.util.List;
import java.util.LinkedList;
import org.json.JSONObject;

public final class bm extends br
{
    bm(final String s, final String s2, final bk bk, final String s3, final byte b, final JSONObject jsonObject) {
        this(s, s2, bk, s3, new LinkedList<bv>(), b, jsonObject);
    }
    
    bm(final String s, final String s2, final bk bk, final String s3, final List<bv> list, final byte i, final JSONObject f) {
        super(s, s2, "CTA", bk, s3);
        this.a(list);
        if (f != null) {
            this.i = i;
            this.f = f;
        }
    }
    
    public static final class a extends br.a
    {
        a(int min, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final String s, final String s2, @NonNull final String s3, @NonNull final String s4, final int l, final String s5, final String[] array, @Nullable final bs bs) {
            super(min, n, n2, n3, n4, n5, n6, n7, s, s2, s3, s4, bs);
            this.l = l;
            this.n = Integer.MAX_VALUE;
            this.m = ((0 == s5.length()) ? "#ff000000" : s5);
            min = Math.min(array.length, 1);
            System.arraycopy(array, 0, this.o = new String[min], 0, min);
        }
    }
}

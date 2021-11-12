// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.Locale;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;

public class br extends bj
{
    public br(final String s, final String s2, final bk bk, final String e) {
        super(s, s2, "TEXT", bk);
        this.e = e;
    }
    
    public br(final String s, final String s2, final String s3, final bk bk, final String e) {
        super(s, s2, s3, bk);
        this.e = e;
    }
    
    public static class a extends bk
    {
        protected int l;
        protected String m;
        protected int n;
        protected String[] o;
        public byte p;
        
        public a(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8, final String s, final String s2, @NonNull final String s3, @NonNull final String s4, @Nullable final bs bs) {
            this(n, n2, n3, n4, n5, n6, n7, n8, s, s2, s3, s4, 12, (byte)0, Integer.MAX_VALUE, "#ff000000", new String[] { "none" }, bs);
        }
        
        public a(int min, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final String s, final String s2, @NonNull final String s3, @NonNull final String s4, final int l, final byte p18, final int n8, @NonNull final String s5, final String[] array, @Nullable final bs bs) {
            super(min, n, n2, n3, n4, n5, n6, n7, s, s2, s3, s4, bs);
            this.l = l;
            this.m = ((0 == s5.length()) ? "#ff000000" : s5);
            this.n = n8;
            min = Math.min(array.length, 4);
            this.o = new String[min];
            this.p = p18;
            System.arraycopy(array, 0, this.o, 0, min);
        }
        
        public final int h() {
            return this.l;
        }
        
        public final String i() {
            return this.m.toLowerCase(Locale.US);
        }
        
        public final String[] j() {
            return this.o;
        }
        
        @Override
        public final String e() {
            return this.j.toLowerCase(Locale.US);
        }
    }
}

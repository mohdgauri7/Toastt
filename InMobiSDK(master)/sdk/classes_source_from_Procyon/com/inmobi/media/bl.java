// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.List;
import java.util.LinkedList;
import org.json.JSONObject;
import java.util.Iterator;

public final class bl extends bj implements Iterable<bj>
{
    public long z;
    public byte A;
    bj[] B;
    int C;
    
    @Override
    public final Iterator<bj> iterator() {
        return new a();
    }
    
    public bl(final String s, final String s2, final bk bk, final byte b, final JSONObject jsonObject, final byte b2) {
        this(s, s2, bk, new LinkedList<bv>(), b, jsonObject, b2);
    }
    
    public bl(final String s, final String s2, final bk bk, final List<bv> list, final byte i, final JSONObject f, final byte a) {
        super(s, s2, "CONTAINER", bk, list);
        this.z = 0L;
        this.f = f;
        this.B = new bj[1];
        this.i = i;
        this.C = 0;
        this.A = a;
    }
    
    public final bj a(final int n) {
        if (n >= 0 && n < this.C) {
            return this.B[n];
        }
        return null;
    }
    
    public final boolean a() {
        return "root".equalsIgnoreCase(this.d);
    }
    
    public final boolean b() {
        return "card_scrollable".equalsIgnoreCase(this.d);
    }
    
    final class a implements Iterator<bj>
    {
        private int b;
        
        public a() {
            this.b = 0;
        }
        
        @Override
        public final boolean hasNext() {
            return this.b < bl.this.C;
        }
        
        @Override
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }
}

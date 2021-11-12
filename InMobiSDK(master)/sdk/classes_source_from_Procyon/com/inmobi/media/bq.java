// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.List;
import java.util.LinkedList;
import org.json.JSONObject;

public final class bq extends bj
{
    public bq(final String s, final String s2, final bk bk, final String s3, final byte b, final JSONObject jsonObject) {
        this(s, s2, bk, s3, new LinkedList<bv>(), b, jsonObject);
    }
    
    public bq(final String s, final String s2, final bk bk, final String e, final List<bv> list, final byte i, final JSONObject f) {
        super(s, s2, "IMAGE", bk, list);
        this.e = e;
        if (f != null) {
            this.i = i;
            this.f = f;
        }
    }
}

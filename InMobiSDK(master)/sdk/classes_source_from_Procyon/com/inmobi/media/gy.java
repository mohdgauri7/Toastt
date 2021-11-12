// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.content.ContentValues;

public class gy
{
    int a;
    String b;
    long c;
    String d;
    
    public gy(final String b) {
        this.b = b;
        this.d = null;
        this.c = System.currentTimeMillis();
    }
    
    private gy(final String b, final String d) {
        this.b = b;
        this.d = d;
        this.c = System.currentTimeMillis();
    }
    
    public final String a() {
        if (this.d == null) {
            return "";
        }
        return this.d;
    }
    
    @Override
    public String toString() {
        return this.b + " ";
    }
    
    public static gy a(final ContentValues contentValues) {
        final gy gy;
        (gy = new gy(contentValues.getAsString("eventType"), contentValues.getAsString("payload"))).c = Long.valueOf(contentValues.getAsString("ts"));
        gy.a = contentValues.getAsInteger("id");
        return gy;
    }
}

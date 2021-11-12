// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.HashSet;
import java.util.ArrayList;
import java.lang.ref.WeakReference;
import androidx.annotation.Nullable;
import java.util.Set;
import java.util.List;

public final class am
{
    private String h;
    public List<al> a;
    Set<bd> b;
    Set<String> c;
    int d;
    int e;
    private String i;
    @Nullable
    public String f;
    private final WeakReference<ax> j;
    public String g;
    
    public am(final String h, final String i, final Set<bd> b, final ax referent) {
        this.h = h;
        this.i = i;
        this.b = b;
        this.j = new WeakReference<ax>(referent);
        this.a = new ArrayList<al>();
        this.c = new HashSet<String>();
    }
    
    public am(final String h, final Set<bd> b, final ax referent, final String g) {
        this.h = h;
        this.g = g;
        this.b = b;
        this.j = new WeakReference<ax>(referent);
        this.a = new ArrayList<al>();
        this.c = new HashSet<String>();
    }
    
    @Nullable
    public final ax a() {
        return this.j.get();
    }
    
    @Override
    public final String toString() {
        return "AdAssetBatch{mRawAssets=" + this.b + ", mBatchDownloadSuccessCount=" + this.d + ", mBatchDownloadFailureCount=" + this.e + '}';
    }
}

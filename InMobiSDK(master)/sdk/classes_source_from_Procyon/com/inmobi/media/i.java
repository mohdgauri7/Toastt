// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import org.json.JSONArray;
import androidx.annotation.WorkerThread;

public interface i
{
    @WorkerThread
    void a(final int p0, final o p1);
    
    @WorkerThread
    int a(final o p0);
    
    @WorkerThread
    void b(final int p0, final o p1);
    
    @WorkerThread
    long b_();
    
    @WorkerThread
    void b();
    
    @NonNull
    @WorkerThread
    JSONArray c();
    
    @WorkerThread
    void b(final o p0);
    
    @WorkerThread
    long d();
    
    @WorkerThread
    void a(final String p0);
    
    @WorkerThread
    @Nullable
    String e();
}

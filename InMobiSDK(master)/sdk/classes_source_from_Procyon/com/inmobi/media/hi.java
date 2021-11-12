// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import android.content.SharedPreferences$Editor;
import java.util.Set;
import android.content.Context;
import androidx.annotation.NonNull;

public final class hi
{
    @NonNull
    private final gu a;
    
    public hi(@NonNull final Context context, @NonNull final String s) {
        this.a = gu.a(context, s);
    }
    
    public final void a(@NonNull final String s, @NonNull final String s2) {
        this.a.a(s, s2);
    }
    
    public final void b(@NonNull final String s, @NonNull final String s2) {
        this.a.a(s, s2);
        this.a(System.currentTimeMillis() / 1000L);
    }
    
    public final void a(@NonNull final String s, @NonNull final Set<String> set) {
        final SharedPreferences$Editor edit;
        (edit = this.a.a.edit()).putStringSet(s, (Set)set);
        edit.apply();
    }
    
    public final void a(@NonNull final String s, final boolean b) {
        this.a.a(s, b);
    }
    
    @WorkerThread
    @Nullable
    public final Set<String> a(@NonNull final String s) {
        return (Set<String>)this.a.a.getStringSet(s, (Set)null);
    }
    
    @WorkerThread
    public final String b(@NonNull final String s) {
        return this.a.b(s);
    }
    
    @WorkerThread
    public final Boolean c(@NonNull final String s) {
        if (this.a.d(s)) {
            return this.a.b(s, true);
        }
        return null;
    }
    
    @WorkerThread
    public final long a() {
        return this.a.b("last_ts", 0L);
    }
    
    public final void a(final long n) {
        this.a.a("last_ts", n);
    }
    
    @WorkerThread
    public final boolean d(@NonNull final String s) {
        return this.a.d(s);
    }
    
    @WorkerThread
    public final boolean e(@NonNull final String s) {
        return this.a.e(s);
    }
    
    @WorkerThread
    public final void b() {
        final SharedPreferences$Editor edit;
        (edit = this.a.a.edit()).clear();
        edit.apply();
    }
}

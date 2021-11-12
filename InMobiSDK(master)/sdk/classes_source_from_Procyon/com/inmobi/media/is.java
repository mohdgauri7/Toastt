// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.WorkerThread;
import java.util.concurrent.CountDownLatch;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import android.view.View;
import java.lang.ref.WeakReference;

public class is
{
    private static final String b;
    private final WeakReference<a> c;
    public final WeakReference<View> a;
    private boolean d;
    private boolean e;
    
    public is(@NonNull final View referent, @NonNull final a referent2) {
        this.d = false;
        this.e = false;
        this.c = new WeakReference<a>(referent2);
        this.a = new WeakReference<View>(referent);
    }
    
    @WorkerThread
    private static Bitmap b(final View view) throws IllegalStateException {
        final int measuredWidth = view.getMeasuredWidth();
        final int measuredHeight = view.getMeasuredHeight();
        if (measuredWidth <= 0 || measuredHeight <= 0) {
            throw new IllegalStateException();
        }
        final Bitmap bitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(bitmap);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        view.post((Runnable)new Runnable() {
            @Override
            public final void run() {
                view.draw(canvas);
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        }
        catch (InterruptedException ex) {}
        return bitmap;
    }
    
    static {
        b = is.class.getSimpleName();
    }
    
    public interface a
    {
        void l();
        
        void m();
    }
}

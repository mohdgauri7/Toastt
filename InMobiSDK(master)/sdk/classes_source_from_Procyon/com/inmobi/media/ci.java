// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.lang.reflect.Field;
import android.view.WindowManager;
import android.os.Bundle;
import java.lang.reflect.InvocationTargetException;
import java.io.UnsupportedEncodingException;
import android.widget.MediaController;
import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import android.view.View;
import android.os.Build;
import android.content.Context;
import android.app.Activity;
import java.lang.ref.WeakReference;
import android.view.ViewGroup;
import android.graphics.Bitmap;
import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.app.Application;
import android.widget.VideoView;

@SuppressLint({ "ViewConstructor" })
public final class ci extends VideoView implements Application.ActivityLifecycleCallbacks, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener
{
    private static final String l;
    public a a;
    public Bitmap b;
    public ViewGroup c;
    public b d;
    private boolean m;
    private WeakReference<Activity> n;
    int e;
    boolean f;
    public String g;
    public String h;
    boolean i;
    int j;
    int k;
    
    public ci(final Activity referent) {
        super((Context)referent);
        this.m = false;
        this.setZOrderOnTop(true);
        this.setFocusable(true);
        this.setFocusableInTouchMode(true);
        if (Build.VERSION.SDK_INT < 28) {
            this.setDrawingCacheEnabled(true);
        }
        this.e = 100;
        this.j = -1;
        this.k = 0;
        this.f = false;
        this.n = new WeakReference<Activity>(referent);
        gz.a((Context)referent, (Application.ActivityLifecycleCallbacks)this);
    }
    
    protected final void onWindowVisibilityChanged(final int n) {
        super.onWindowVisibilityChanged(n);
    }
    
    protected final void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        super.onLayout(b, n, n2, n3, n4);
        this.getHolder().setSizeFromLayout();
    }
    
    @TargetApi(16)
    protected final void onVisibilityChanged(@NonNull final View view, final int n) {
        super.onVisibilityChanged(view, n);
        if (n == 0) {
            if (Build.VERSION.SDK_INT >= 16) {
                final Context c;
                if ((c = gz.c()) != null) {
                    this.setBackground((Drawable)new BitmapDrawable(c.getResources(), this.b));
                }
                return;
            }
            this.setBackgroundDrawable((Drawable)new BitmapDrawable(this.b));
        }
    }
    
    public final void onCompletion(final MediaPlayer mediaPlayer) {
    }
    
    public final boolean onError(final MediaPlayer mediaPlayer, final int n, final int n2) {
        this.a();
        return false;
    }
    
    public final void onPrepared(final MediaPlayer mediaPlayer) {
        mediaPlayer.setOnVideoSizeChangedListener((MediaPlayer.OnVideoSizeChangedListener)new MediaPlayer.OnVideoSizeChangedListener() {
            public final void onVideoSizeChanged(final MediaPlayer mediaPlayer, final int n, final int n2) {
                ci.l;
                if (null == ci.this.a) {
                    ci.this.a = new a(ci.this.getContext());
                    ci.this.a.setAnchorView((View)ci.this);
                    ci.this.setMediaController((MediaController)ci.this.a);
                    ci.this.requestLayout();
                    ci.this.requestFocus();
                }
            }
        });
        final int k = this.k;
        if (k < this.getDuration()) {
            this.seekTo(this.k = k);
        }
        this.i = true;
        this.d.a();
        this.start();
    }
    
    public final void setPlaybackData(final String s) {
        this.h = a(s);
        this.g = "anonymous";
        if (this.b == null) {
            this.b = Bitmap.createBitmap(24, 24, Bitmap.Config.ARGB_8888);
            this.b = b(this.h);
        }
    }
    
    public final void start() {
        if (this.m) {
            return;
        }
        super.start();
    }
    
    public final void pause() {
        super.pause();
    }
    
    public final void a() {
        this.stopPlayback();
        this.c();
        super.setMediaController((MediaController)null);
        this.a = null;
        if (this.d != null) {
            this.d.a(this);
        }
    }
    
    public final ViewGroup getViewContainer() {
        return this.c;
    }
    
    public final void setViewContainer(final ViewGroup c) {
        this.c = c;
    }
    
    public final void setListener(final b d) {
        this.d = d;
    }
    
    private void c() {
        if (this.c != null) {
            final ViewGroup viewGroup;
            if ((viewGroup = (ViewGroup)this.c.getParent()) != null) {
                viewGroup.removeView((View)this.c);
            }
            final ViewGroup viewGroup2;
            if ((viewGroup2 = (ViewGroup)this.getParent()) != null) {
                viewGroup2.removeView((View)this);
            }
            this.setBackgroundColor(0);
            this.c = null;
        }
    }
    
    public static String a(final String s) {
        final String s2 = "";
        final byte[] bytes = s.getBytes();
        final StringBuilder sb = new StringBuilder();
        for (int length = bytes.length, i = 0; i < length; ++i) {
            final byte b;
            if (((b = bytes[i]) & 0x80) > 0) {
                final StringBuilder append = sb.append("%");
                final char[] array = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
                append.append(new String(new char[] { array[b >> 4 & 0xF], array[b & 0xF] }));
            }
            else {
                sb.append((char)b);
            }
        }
        try {
            return new String(sb.toString().getBytes(), "ISO-8859-1");
        }
        catch (UnsupportedEncodingException ex) {
            return s2;
        }
    }
    
    public static Bitmap b(final String s) {
        try {
            return (Bitmap)Class.forName("android.media.ThumbnailUtils").getDeclaredMethod("createVideoThumbnail", String.class, Integer.TYPE).invoke(null, s, 1);
        }
        catch (ClassNotFoundException ex) {
            return null;
        }
        catch (InvocationTargetException ex2) {
            return null;
        }
        catch (NoSuchMethodException ex3) {
            return null;
        }
        catch (IllegalAccessException ex4) {
            return null;
        }
    }
    
    public final void onActivityCreated(final Activity activity, final Bundle bundle) {
    }
    
    public final void onActivityStarted(final Activity obj) {
        if (this.n.get() != null && this.n.get().equals(obj)) {
            this.m = false;
            this.start();
        }
    }
    
    public final void onActivityResumed(final Activity activity) {
    }
    
    public final void onActivityPaused(final Activity activity) {
    }
    
    public final void onActivityStopped(final Activity obj) {
        final Activity activity;
        if ((activity = this.n.get()) != null && activity.equals(obj)) {
            this.m = true;
            if (this.getCurrentPosition() != 0) {
                this.k = this.getCurrentPosition();
            }
            this.pause();
        }
    }
    
    public final void onActivitySaveInstanceState(final Activity activity, final Bundle bundle) {
    }
    
    public final void onActivityDestroyed(final Activity activity) {
        activity.getApplication().unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this);
    }
    
    static {
        l = ci.class.getSimpleName();
    }
    
    public static final class a extends MediaController
    {
        public a(final Context context) {
            super(context);
        }
        
        public final void show(final int n) {
            super.show(n);
            if (Build.VERSION.SDK_INT < 19) {
                try {
                    final Field declaredField;
                    (declaredField = MediaController.class.getDeclaredField("mAnchor")).setAccessible(true);
                    final View view = (View)declaredField.get(this);
                    final Field declaredField2;
                    (declaredField2 = MediaController.class.getDeclaredField("mDecor")).setAccessible(true);
                    final View view2 = (View)declaredField2.get(this);
                    final Field declaredField3;
                    (declaredField3 = MediaController.class.getDeclaredField("mDecorLayoutParams")).setAccessible(true);
                    final WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams)declaredField3.get(this);
                    final Field declaredField4;
                    (declaredField4 = MediaController.class.getDeclaredField("mWindowManager")).setAccessible(true);
                    final WindowManager windowManager = (WindowManager)declaredField4.get(this);
                    final int[] array = new int[2];
                    view.getLocationOnScreen(array);
                    view2.measure(View.MeasureSpec.makeMeasureSpec(view.getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(view.getHeight(), Integer.MIN_VALUE));
                    view2.setPadding(0, 0, 0, 0);
                    layoutParams.verticalMargin = 0.0f;
                    layoutParams.horizontalMargin = 0.0f;
                    layoutParams.width = view.getWidth();
                    layoutParams.gravity = 8388659;
                    layoutParams.x = array[0];
                    layoutParams.y = array[1] + view.getHeight() - view2.getMeasuredHeight();
                    windowManager.updateViewLayout(view2, (ViewGroup.LayoutParams)layoutParams);
                }
                catch (Exception ex) {}
            }
        }
    }
    
    interface b
    {
        void a(final ci p0);
        
        void a();
    }
}

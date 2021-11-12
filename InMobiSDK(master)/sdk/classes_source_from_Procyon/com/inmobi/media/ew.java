// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.os.Message;
import java.lang.ref.WeakReference;
import android.os.Handler;
import java.util.HashMap;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import java.util.Map;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.view.ViewGroup;
import android.util.AttributeSet;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.ProgressBar;
import android.widget.FrameLayout;

public class ew extends FrameLayout
{
    private static final String b;
    private m c;
    private a d;
    private ex e;
    boolean a;
    private cf f;
    private cf g;
    private ProgressBar h;
    private RelativeLayout i;
    private boolean j;
    private float k;
    private final View.OnClickListener l;
    
    public ew(final Context context) {
        this(context, (byte)0);
    }
    
    private ew(final Context context, final byte b) {
        this(context, '\0');
    }
    
    private ew(final Context context, final char c) {
        super(context, (AttributeSet)null, 0);
        this.j = false;
        this.l = (View.OnClickListener)new View.OnClickListener() {
            public final void onClick(final View view) {
                ew.c(ew.this);
            }
        };
        this.addView((View)(this.i = new RelativeLayout(this.getContext())), (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
        this.i.setPadding(0, 0, 0, 0);
        if (this.i != null) {
            this.k = ho.a().c;
            this.f = new cf(this.getContext(), this.k, (byte)9);
            this.g = new cf(this.getContext(), this.k, (byte)11);
            (this.h = new ProgressBar(this.getContext(), (AttributeSet)null, 16842872)).setScaleY(0.8f);
            this.e();
            final RelativeLayout.LayoutParams layoutParams;
            (layoutParams = new RelativeLayout.LayoutParams(-1, -2)).addRule(12, -1);
            final float c2 = ho.a().c;
            layoutParams.setMargins(0, (int)(-6.0f * c2), 0, (int)(-8.0f * c2));
            final LayerDrawable layerDrawable;
            if ((layerDrawable = (LayerDrawable)this.h.getProgressDrawable()) != null) {
                layerDrawable.getDrawable(0).setColorFilter(-1, PorterDuff.Mode.SRC_IN);
                layerDrawable.getDrawable(2).setColorFilter(-327674, PorterDuff.Mode.SRC_IN);
            }
            this.i.addView((View)this.h, (ViewGroup.LayoutParams)layoutParams);
        }
        this.d = new a(this);
    }
    
    public void setMediaPlayer(@NonNull final ex e) {
        this.e = e;
        final bw bw;
        if ((bw = (bw)this.e.getTag()) != null && bw.B && !bw.a()) {
            this.j = true;
            this.i.removeView((View)this.g);
            this.i.removeView((View)this.f);
            this.f();
        }
    }
    
    private void e() {
        final RelativeLayout.LayoutParams layoutParams;
        (layoutParams = new RelativeLayout.LayoutParams((int)(30.0f * this.k), (int)(30.0f * this.k))).addRule(9, -1);
        layoutParams.addRule(12, -1);
        this.i.addView((View)this.f, (ViewGroup.LayoutParams)layoutParams);
        this.f.setOnClickListener(this.l);
    }
    
    private void f() {
        final RelativeLayout.LayoutParams layoutParams;
        (layoutParams = new RelativeLayout.LayoutParams((int)(30.0f * this.k), (int)(30.0f * this.k))).addRule(9, -1);
        layoutParams.addRule(12, -1);
        this.i.addView((View)this.g, (ViewGroup.LayoutParams)layoutParams);
        this.g.setOnClickListener(this.l);
    }
    
    public final void a() {
        if (!this.a) {
            this.g();
            this.a = true;
            final bw bw;
            if ((bw = (bw)this.e.getTag()) != null) {
                this.f.setVisibility(bw.B ? 0 : 4);
                this.h.setVisibility(bw.D ? 0 : 4);
            }
            this.setVisibility(0);
        }
        this.d.sendEmptyMessage(2);
    }
    
    public final void b() {
        if (this.a) {
            try {
                this.d.removeMessages(2);
                this.setVisibility(8);
            }
            catch (IllegalArgumentException ex) {
                fv.a().a(new gv(ex));
            }
            this.a = false;
        }
    }
    
    private void g() {
        if (this.e == null) {
            return;
        }
        final int currentPosition = this.e.getCurrentPosition();
        final int duration = this.e.getDuration();
        if (this.h != null && duration != 0) {
            this.h.setProgress(currentPosition * 100 / duration);
        }
    }
    
    public boolean onTrackballEvent(final MotionEvent motionEvent) {
        if (this.e != null && this.e.f()) {
            if (this.a) {
                this.b();
            }
            else {
                this.a();
            }
        }
        return false;
    }
    
    public boolean dispatchKeyEvent(final KeyEvent keyEvent) {
        final int keyCode = keyEvent.getKeyCode();
        final boolean b = keyEvent.getRepeatCount() == 0 && keyEvent.getAction() == 0;
        if (keyCode == 79 || keyCode == 85 || keyCode == 62) {
            if (b) {
                if (this.e.isPlaying()) {
                    this.e.pause();
                }
                else {
                    this.e.start();
                }
                this.a();
            }
            return true;
        }
        if (keyCode == 126) {
            if (b && !this.e.isPlaying()) {
                this.e.start();
                this.a();
            }
            return true;
        }
        if (keyCode == 86 || keyCode == 127) {
            if (b && this.e.isPlaying()) {
                this.e.pause();
                this.a();
            }
            return true;
        }
        if (keyCode == 25 || keyCode == 24 || keyCode == 164 || keyCode == 27) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.a();
        return super.dispatchKeyEvent(keyEvent);
    }
    
    public void onInitializeAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)ew.class.getName());
    }
    
    public void onInitializeAccessibilityNodeInfo(final AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName((CharSequence)ew.class.getName());
    }
    
    public final void c() {
        if (this.e != null) {
            this.j = false;
            this.i.removeView((View)this.g);
            this.i.removeView((View)this.f);
            this.e();
        }
    }
    
    public final void d() {
        if (this.e != null) {
            this.j = true;
            this.i.removeView((View)this.f);
            this.i.removeView((View)this.g);
            this.f();
        }
    }
    
    public void setVideoAd(final m c) {
        this.c = c;
    }
    
    @NonNull
    public Map<View, FriendlyObstructionPurpose> getFriendlyViews() {
        final HashMap<cf, FriendlyObstructionPurpose> hashMap;
        (hashMap = (HashMap<cf, FriendlyObstructionPurpose>)new HashMap<View, FriendlyObstructionPurpose>()).put((cf)this.h, FriendlyObstructionPurpose.VIDEO_CONTROLS);
        hashMap.put(this.f, FriendlyObstructionPurpose.VIDEO_CONTROLS);
        hashMap.put(this.g, FriendlyObstructionPurpose.VIDEO_CONTROLS);
        return (Map<View, FriendlyObstructionPurpose>)hashMap;
    }
    
    static /* synthetic */ void c(final ew ew) {
        if (ew.e != null) {
            final bw bw = (bw)ew.e.getTag();
            if (ew.j) {
                ew.e.i();
                ew.j = false;
                ew.i.removeView((View)ew.g);
                ew.i.removeView((View)ew.f);
                ew.e();
                if (bw == null || ew.c == null) {
                    return;
                }
                try {
                    ew.c.f(bw);
                    bw.A = true;
                    return;
                }
                catch (Exception ex) {
                    fv.a().a(new gv(ex));
                    return;
                }
            }
            ew.e.h();
            ew.j = true;
            ew.i.removeView((View)ew.f);
            ew.i.removeView((View)ew.g);
            ew.f();
            if (bw != null && ew.c != null) {
                try {
                    ew.c.e(bw);
                    bw.A = false;
                }
                catch (Exception ex2) {
                    fv.a().a(new gv(ex2));
                }
            }
        }
    }
    
    static {
        b = ew.class.getSimpleName();
    }
    
    static final class a extends Handler
    {
        @NonNull
        private final WeakReference<ew> a;
        
        a(@NonNull final ew referent) {
            this.a = new WeakReference<ew>(referent);
        }
        
        public final void handleMessage(Message obtainMessage) {
            switch (obtainMessage.what) {
                default: {
                    super.handleMessage(obtainMessage);
                }
                case 2: {
                    final ew ew;
                    if ((ew = this.a.get()) != null) {
                        ew.g();
                        if (ew.a && ew.e.isPlaying()) {
                            obtainMessage = this.obtainMessage(2);
                            this.sendMessageDelayed(obtainMessage, 200L);
                        }
                    }
                }
            }
        }
    }
}

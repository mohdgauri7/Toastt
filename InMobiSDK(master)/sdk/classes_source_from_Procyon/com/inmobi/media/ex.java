// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.List;
import android.content.ContentValues;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.app.KeyguardManager;
import android.os.PowerManager;
import android.view.View;
import java.io.IOException;
import androidx.annotation.NonNull;
import android.graphics.SurfaceTexture;
import android.annotation.TargetApi;
import android.os.Build;
import android.content.Context;
import android.media.MediaPlayer;
import androidx.annotation.Nullable;
import android.os.Handler;
import android.view.Surface;
import java.util.Map;
import android.net.Uri;
import android.widget.MediaController;
import android.view.TextureView;

public class ex extends TextureView implements MediaController.MediaPlayerControl, em.a
{
    private static final String g;
    private Uri h;
    private Map<String, String> i;
    private Surface j;
    public er a;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    public final em b;
    private c q;
    private b r;
    private a s;
    private boolean t;
    private d u;
    private ew v;
    private int w;
    private boolean x;
    private boolean y;
    private boolean z;
    @Nullable
    public Handler c;
    public boolean d;
    MediaPlayer.OnVideoSizeChangedListener e;
    MediaPlayer.OnPreparedListener f;
    private MediaPlayer.OnCompletionListener A;
    private MediaPlayer.OnInfoListener B;
    private MediaPlayer.OnBufferingUpdateListener C;
    private MediaPlayer.OnErrorListener D;
    private final TextureView.SurfaceTextureListener E;
    
    public ex(final Context context) {
        super(context);
        this.j = null;
        this.a = null;
        this.o = Integer.MIN_VALUE;
        this.p = 0;
        this.e = (MediaPlayer.OnVideoSizeChangedListener)new MediaPlayer.OnVideoSizeChangedListener() {
            public final void onVideoSizeChanged(final MediaPlayer mediaPlayer, final int n, final int n2) {
                ex.this.l = mediaPlayer.getVideoWidth();
                ex.this.m = mediaPlayer.getVideoHeight();
                if (ex.this.l != 0 && ex.this.m != 0) {
                    ex.this.requestLayout();
                }
            }
        };
        this.f = (MediaPlayer.OnPreparedListener)new MediaPlayer.OnPreparedListener() {
            public final void onPrepared(final MediaPlayer mediaPlayer) {
                if (null == ex.this.a) {
                    return;
                }
                ex.this.a.a = 2;
                ex.this.x = (ex.this.y = (ex.this.z = true));
                if (ex.this.v != null) {
                    ex.this.v.setEnabled(true);
                }
                ex.this.l = mediaPlayer.getVideoWidth();
                ex.this.m = mediaPlayer.getVideoHeight();
                final bw bw;
                if ((bw = (bw)ex.this.getTag()) != null && (boolean)bw.v.get("didCompleteQ4")) {
                    ex.this.a(8, 0);
                    if ((byte)bw.v.get("placementType") == 1) {
                        return;
                    }
                }
                if (ex.this.getPlaybackEventListener() != null) {
                    ex.this.getPlaybackEventListener().a((byte)0);
                }
                int intValue = 0;
                if (bw != null && !(boolean)bw.v.get("didCompleteQ4")) {
                    intValue = bw.v.get("seekPosition");
                }
                if (ex.this.l != 0 && ex.this.m != 0) {
                    if (3 == ex.this.a.b) {
                        if (bw != null && (boolean)bw.v.get("isFullScreen")) {
                            ex.this.start();
                        }
                        if (ex.this.v != null) {
                            ex.this.v.a();
                        }
                    }
                    else if (!ex.this.isPlaying() && (intValue != 0 || ex.this.getCurrentPosition() > 0) && ex.this.v != null) {
                        ex.this.v.a();
                    }
                }
                else if (3 == ex.this.a.b && bw != null && (boolean)bw.v.get("isFullScreen")) {
                    ex.this.start();
                }
            }
        };
        this.A = (MediaPlayer.OnCompletionListener)new MediaPlayer.OnCompletionListener() {
            public final void onCompletion(final MediaPlayer mediaPlayer) {
                try {
                    ex.f(ex.this);
                }
                catch (Exception ex) {
                    ex.g;
                    fv.a().a(new gv(ex));
                }
            }
        };
        this.B = (MediaPlayer.OnInfoListener)new MediaPlayer.OnInfoListener() {
            @TargetApi(17)
            public final boolean onInfo(final MediaPlayer mediaPlayer, final int n, final int n2) {
                if (Build.VERSION.SDK_INT >= 17 && 3 == n) {
                    ex.this.a(8, 8);
                }
                return true;
            }
        };
        this.C = (MediaPlayer.OnBufferingUpdateListener)new MediaPlayer.OnBufferingUpdateListener() {
            public final void onBufferingUpdate(final MediaPlayer mediaPlayer, final int n) {
                ex.this.w = n;
            }
        };
        this.D = (MediaPlayer.OnErrorListener)new MediaPlayer.OnErrorListener() {
            public final boolean onError(final MediaPlayer mediaPlayer, final int n, final int n2) {
                ex.g;
                if (ex.this.s != null) {
                    ex.this.s.a();
                }
                if (ex.this.a != null) {
                    ex.this.a.a = -1;
                    ex.this.a.b = -1;
                }
                if (ex.this.v != null) {
                    ex.this.v.b();
                }
                ex.h(ex.this);
                return true;
            }
        };
        this.E = (TextureView.SurfaceTextureListener)new TextureView.SurfaceTextureListener() {
            @TargetApi(16)
            public final void onSurfaceTextureAvailable(final SurfaceTexture surfaceTexture, final int n, final int n2) {
                ex.this.j = new Surface(surfaceTexture);
                ex.this.k();
            }
            
            public final void onSurfaceTextureSizeChanged(final SurfaceTexture surfaceTexture, int n, final int n2) {
                final boolean b = null != ex.this.a && ex.this.a.b == 3;
                n = ((n > 0 && n2 > 0) ? 1 : 0);
                if (ex.this.a != null && b && n != 0) {
                    final int intValue;
                    if (ex.this.getTag() != null && (intValue = ((bw)ex.this.getTag()).v.get("seekPosition")) != 0) {
                        ex.this.a(intValue);
                    }
                    ex.this.start();
                }
            }
            
            public final boolean onSurfaceTextureDestroyed(final SurfaceTexture surfaceTexture) {
                if (ex.this.j != null) {
                    ex.this.j.release();
                    ex.this.j = null;
                }
                if (ex.this.v != null) {
                    ex.this.v.b();
                }
                ex.this.g();
                return true;
            }
            
            public final void onSurfaceTextureUpdated(final SurfaceTexture surfaceTexture) {
            }
        };
        this.b = new em(this.getContext(), this);
        this.requestLayout();
        this.invalidate();
    }
    
    public final void a(@NonNull final bw tag) {
        this.l = 0;
        this.m = 0;
        this.h = Uri.parse(((dd)tag.e).b());
        this.a = ((1 == tag.v.get("placementType")) ? new er() : er.a());
        if (this.k != 0) {
            this.a.setAudioSessionId(this.k);
        }
        else {
            this.k = this.a.getAudioSessionId();
        }
        try {
            this.a.setDataSource(this.getContext().getApplicationContext(), this.h, (Map)this.i);
        }
        catch (IOException ex) {
            this.a.a = -1;
            this.a.b = -1;
            return;
        }
        this.setTag((Object)tag);
        this.u = new d(this);
        this.setSurfaceTextureListener(this.E);
        this.setFocusable(true);
        this.setFocusableInTouchMode(true);
        this.requestFocus();
    }
    
    public er getMediaPlayer() {
        return this.a;
    }
    
    public final void e() {
        if (this.j != null) {
            this.j.release();
            this.j = null;
        }
        this.g();
    }
    
    public int getState() {
        if (this.a != null) {
            return this.a.a;
        }
        return 0;
    }
    
    protected void onMeasure(int size, int size2) {
        try {
            int n = getDefaultSize(this.l, size);
            int n2 = getDefaultSize(this.m, size2);
            if (this.l > 0 && this.m > 0) {
                final int mode = View.MeasureSpec.getMode(size);
                size = View.MeasureSpec.getSize(size);
                final int mode2 = View.MeasureSpec.getMode(size2);
                size2 = View.MeasureSpec.getSize(size2);
                if (mode == 1073741824 && mode2 == 1073741824) {
                    n = size;
                    n2 = size2;
                    if (this.l * size2 < size * this.m) {
                        n2 = size * this.m / this.l;
                    }
                    else if (this.l * size2 > size * this.m) {
                        n = size2 * this.l / this.m;
                    }
                }
                else if (mode == 1073741824) {
                    n2 = (n = size) * this.m / this.l;
                    if (mode2 == Integer.MIN_VALUE && n2 > size2) {
                        n2 = size2;
                    }
                }
                else if (mode2 == 1073741824) {
                    n = (n2 = size2) * this.l / this.m;
                    if (mode == Integer.MIN_VALUE && n > size) {
                        n = size;
                    }
                }
                else {
                    n = this.l;
                    n2 = this.m;
                    if (mode2 == Integer.MIN_VALUE && n2 > size2) {
                        n = (n2 = size2) * this.l / this.m;
                    }
                    if (mode == Integer.MIN_VALUE && n > size) {
                        n2 = (n = size) * this.m / this.l;
                    }
                }
            }
            this.setMeasuredDimension(n, n2);
        }
        catch (Exception ex) {}
    }
    
    @Nullable
    public ew getMediaController() {
        return this.v;
    }
    
    public final boolean f() {
        return this.a != null && this.a.a != -1 && this.a.a != 0 && this.a.a != 1;
    }
    
    public void setIsLockScreen(final boolean t) {
        this.t = t;
    }
    
    @TargetApi(20)
    public void start() {
        final PowerManager powerManager = (PowerManager)this.getContext().getSystemService("power");
        final boolean inKeyguardRestrictedInputMode = ((KeyguardManager)this.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        final boolean b = (Build.VERSION.SDK_INT < 20) ? powerManager.isScreenOn() : powerManager.isInteractive();
        final boolean f = this.f();
        final bw bw;
        final boolean b2 = (bw = (bw)this.getTag()) == null || bw.v.get("shouldAutoPlay");
        if (f && !b2) {
            this.a(8, 0);
        }
        if (f && b && !this.a.isPlaying() && b2 && (this.t || !inKeyguardRestrictedInputMode)) {
            int intValue = 0;
            if (bw != null && !(boolean)bw.v.get("didCompleteQ4")) {
                intValue = bw.v.get("seekPosition");
            }
            this.a(intValue);
            final bw bw2 = bw;
            boolean a = false;
            if (bw2 != null) {
                a = bw2.a();
            }
            if (a) {
                this.b.b();
            }
            else {
                this.h();
            }
            this.a.start();
            this.a.a = 3;
            this.a(8, 8);
            if (bw != null) {
                bw.v.put("didCompleteQ4", Boolean.FALSE);
                if (bw.v.get("didPause")) {
                    this.getPlaybackEventListener().a((byte)3);
                    bw.v.put("didPause", Boolean.FALSE);
                }
                else {
                    this.getPlaybackEventListener().a((byte)1);
                }
                if (this.u != null && !this.u.hasMessages(1)) {
                    this.u.sendEmptyMessage(1);
                }
            }
            if (this.v != null) {
                this.v.a();
            }
        }
        if (this.a != null) {
            this.a.b = 3;
        }
    }
    
    public void pause() {
        if (this.f() && this.a.isPlaying()) {
            this.a.pause();
            this.a.a = 4;
            this.b.a();
            if (this.getTag() != null) {
                final bw bw;
                (bw = (bw)this.getTag()).v.put("didPause", Boolean.TRUE);
                bw.v.put("seekPosition", this.getCurrentPosition());
            }
            this.getPlaybackEventListener().a((byte)2);
        }
        if (this.a != null) {
            this.a.b = 4;
        }
        this.d = false;
    }
    
    public int getDuration() {
        if (this.f()) {
            return this.a.getDuration();
        }
        return -1;
    }
    
    public int getCurrentPosition() {
        if (this.f()) {
            return this.a.getCurrentPosition();
        }
        return 0;
    }
    
    final void a(final int n) {
        if (this.f()) {
            this.a.seekTo(n);
        }
    }
    
    public void seekTo(final int n) {
    }
    
    public boolean isPlaying() {
        return this.f() && this.a.isPlaying();
    }
    
    public int getBufferPercentage() {
        if (this.a != null) {
            return this.w;
        }
        return 0;
    }
    
    public boolean canPause() {
        return this.x;
    }
    
    public boolean canSeekBackward() {
        return this.y;
    }
    
    public boolean canSeekForward() {
        return this.z;
    }
    
    public int getAudioSessionId() {
        if (this.k == 0) {
            final MediaPlayer mediaPlayer = new MediaPlayer();
            this.k = mediaPlayer.getAudioSessionId();
            mediaPlayer.release();
        }
        return this.k;
    }
    
    public void setVideoPath(final String s) {
        this.setVideoURI(Uri.parse(s));
    }
    
    public void setVideoURI(final Uri h) {
        this.h = h;
        this.i = null;
        this.k();
        this.requestLayout();
        this.invalidate();
    }
    
    private void k() {
        if (this.h == null || this.j == null) {
            return;
        }
        if (this.a == null) {
            final bw bw = (bw)this.getTag();
            byte byteValue = 1;
            if (bw != null) {
                byteValue = bw.v.get("placementType");
            }
            this.a = ((byteValue != 0) ? new er() : er.a());
            if (this.k != 0) {
                this.a.setAudioSessionId(this.k);
            }
            else {
                this.k = this.a.getAudioSessionId();
            }
            try {
                this.a.setDataSource(this.getContext().getApplicationContext(), this.h, (Map)this.i);
            }
            catch (IOException ex2) {
                this.a.a = -1;
                this.a.b = -1;
                return;
            }
        }
        try {
            final bw bw2 = (bw)this.getTag();
            this.a.setOnPreparedListener(this.f);
            this.a.setOnVideoSizeChangedListener(this.e);
            this.a.setOnCompletionListener(this.A);
            this.a.setOnErrorListener(this.D);
            this.a.setOnInfoListener(this.B);
            this.a.setOnBufferingUpdateListener(this.C);
            this.a.setSurface(this.j);
            if (Build.VERSION.SDK_INT >= 26) {
                this.a.setAudioAttributes(this.b.a);
            }
            else {
                this.a.setAudioStreamType(3);
            }
            this.a.prepareAsync();
            this.w = 0;
            this.a.a = 1;
            this.o();
            if (bw2 != null) {
                if (bw2.v.get("shouldAutoPlay")) {
                    this.a.b = 3;
                }
                if (bw2.v.get("didCompleteQ4")) {
                    this.a(8, 0);
                    return;
                }
            }
            this.a(0, 0);
        }
        catch (Exception ex) {
            this.a.a = -1;
            this.a.b = -1;
            this.D.onError((MediaPlayer)this.a, 1, 0);
            fv.a().a(new gv(ex));
        }
    }
    
    public final void g() {
        if (this.a != null) {
            this.b.c();
            if (this.u != null) {
                this.u.removeMessages(1);
            }
            if (this.getTag() != null) {
                ((bw)this.getTag()).v.put("seekPosition", this.getCurrentPosition());
            }
            this.a.a = 0;
            this.a.b = 0;
            this.a.reset();
            this.l();
            if (this.getTag() != null) {
                if (0 == ((bw)this.getTag()).v.get("placementType")) {
                    this.a.b();
                }
            }
            else {
                this.a.b();
            }
            this.a = null;
        }
    }
    
    public em getAudioFocusManager() {
        return this.b;
    }
    
    public final void a() {
        this.n();
        if (this.v != null) {
            this.v.c();
        }
    }
    
    public final void b() {
        this.m();
        if (this.v != null) {
            this.v.d();
        }
    }
    
    public final void c() {
        if (this.isPlaying()) {
            this.n();
            if (this.v != null) {
                this.v.c();
            }
        }
    }
    
    public final void d() {
        this.m();
        if (this.v != null) {
            this.v.d();
        }
    }
    
    private void l() {
        this.a.setOnPreparedListener((MediaPlayer.OnPreparedListener)null);
        this.a.setOnVideoSizeChangedListener((MediaPlayer.OnVideoSizeChangedListener)null);
        this.a.setOnCompletionListener((MediaPlayer.OnCompletionListener)null);
        this.a.setOnErrorListener((MediaPlayer.OnErrorListener)null);
        this.a.setOnInfoListener((MediaPlayer.OnInfoListener)null);
        this.a.setOnBufferingUpdateListener((MediaPlayer.OnBufferingUpdateListener)null);
    }
    
    public final void h() {
        if (this.a != null) {
            this.b.a();
            this.m();
        }
    }
    
    private void m() {
        if (this.a != null) {
            this.n = 0;
            this.a.setVolume(0.0f, 0.0f);
            if (this.getTag() != null) {
                ((bw)this.getTag()).v.put("currentMediaVolume", 0);
            }
        }
    }
    
    public final void i() {
        if (this.a != null) {
            if (this.isPlaying()) {
                this.b.b();
                return;
            }
            this.n();
        }
    }
    
    private void n() {
        if (this.a != null) {
            this.n = 1;
            this.a.setVolume(1.0f, 1.0f);
            if (this.getTag() != null) {
                ((bw)this.getTag()).v.put("currentMediaVolume", 15);
            }
        }
    }
    
    public int getVolume() {
        if (this.f()) {
            return this.n;
        }
        return -1;
    }
    
    private void o() {
        if (this.a != null && this.v != null) {
            this.v.setMediaPlayer(this);
            this.v.setEnabled(this.f());
            this.v.a();
        }
    }
    
    final void a(final int visibility, final int visibility2) {
        if (this.a != null) {
            final ProgressBar progressBar = ((ey)this.getParent()).getProgressBar();
            final ImageView poster = ((ey)this.getParent()).getPoster();
            progressBar.setVisibility(visibility);
            poster.setVisibility(visibility2);
        }
    }
    
    public int getVideoVolume() {
        if (this.isPlaying()) {
            return this.n;
        }
        return -1;
    }
    
    public int getLastVolume() {
        return this.o;
    }
    
    public void setLastVolume(final int o) {
        this.o = o;
    }
    
    public void setMediaController(final ew v) {
        if (v != null) {
            this.v = v;
            this.o();
        }
    }
    
    public c getQuartileCompletedListener() {
        return this.q;
    }
    
    public void setQuartileCompletedListener(final c q) {
        this.q = q;
    }
    
    public b getPlaybackEventListener() {
        return this.r;
    }
    
    public void setPlaybackEventListener(final b r) {
        this.r = r;
    }
    
    public void setMediaErrorListener(final a s) {
        this.s = s;
    }
    
    static /* synthetic */ void f(final ex ex) {
        if (ex.a != null) {
            ex.a.a = 5;
            ex.a.b = 5;
        }
        if (ex.v != null) {
            ex.v.b();
        }
        if (ex.u != null) {
            ex.u.removeMessages(1);
        }
        if (ex.getTag() != null) {
            final bw bw;
            if (!(boolean)(bw = (bw)ex.getTag()).v.get("didCompleteQ4")) {
                bw.v.put("didCompleteQ4", Boolean.TRUE);
                if (ex.getQuartileCompletedListener() != null) {
                    ex.getQuartileCompletedListener().a((byte)3);
                }
            }
            bw.v.put("didSignalVideoCompleted", Boolean.TRUE);
            final bw bw2;
            if ((bw2 = bw) != null) {
                bw2.v.put("didCompleteQ1", Boolean.FALSE);
                bw2.v.put("didCompleteQ2", Boolean.FALSE);
                bw2.v.put("didCompleteQ3", Boolean.FALSE);
                bw2.v.put("didPause", Boolean.FALSE);
                bw2.v.put("didStartPlaying", Boolean.FALSE);
                bw2.v.put("didQ4Fire", Boolean.FALSE);
            }
            if (bw.C) {
                ex.start();
                return;
            }
            ex.b.a();
            if (bw.v.get("isFullScreen")) {
                ex.a(8, 0);
            }
        }
    }
    
    static /* synthetic */ void h(final ex ex) {
        try {
            if (ex.h != null) {
                final String string = ex.h.toString();
                au.a();
                final gt a2;
                final List<ContentValues> a = (a2 = gt.a()).a("asset", au.a, "disk_uri=? ", new String[] { string }, null, null, "created_ts DESC ", "1");
                a2.b();
                final al al = a.isEmpty() ? null : au.a(a.get(0));
                final al.a a3 = new al.a();
                if (al != null) {
                    final al a4 = a3.a(al.d, 0, 0L).a();
                    au.a();
                    au.b(a4);
                }
            }
        }
        catch (Exception ex2) {}
    }
    
    static {
        g = ex.class.getSimpleName();
    }
    
    static final class d extends Handler
    {
        private final WeakReference<ex> a;
        
        d(final ex referent) {
            this.a = new WeakReference<ex>(referent);
        }
        
        public final void handleMessage(final Message message) {
            final ex ex;
            if ((ex = this.a.get()) != null && message.what == 1) {
                final int duration = ex.getDuration();
                final int currentPosition = ex.getCurrentPosition();
                if (duration != -1 && currentPosition != 0) {
                    final bw bw;
                    if (!(bw = (bw)ex.getTag()).v.get("didCompleteQ1") && 4 * currentPosition - duration >= 0) {
                        bw.v.put("didCompleteQ1", Boolean.TRUE);
                        ex.getQuartileCompletedListener().a((byte)0);
                    }
                    if (!bw.v.get("didCompleteQ2") && 2 * currentPosition - duration >= 0) {
                        bw.v.put("didCompleteQ2", Boolean.TRUE);
                        ex.getQuartileCompletedListener().a((byte)1);
                    }
                    if (!bw.v.get("didCompleteQ3") && 4 * currentPosition - 3 * duration >= 0) {
                        bw.v.put("didCompleteQ3", Boolean.TRUE);
                        ex.getQuartileCompletedListener().a((byte)2);
                    }
                    final boolean booleanValue = bw.v.get("didQ4Fire");
                    if (currentPosition / (float)duration * 100.0f > bw.E && !booleanValue) {
                        ex.getPlaybackEventListener().a((byte)5);
                    }
                }
                this.sendEmptyMessageDelayed(1, 1000L);
            }
            super.handleMessage(message);
        }
    }
    
    public interface b
    {
        void a(final byte p0);
    }
    
    interface c
    {
        void a(final byte p0);
    }
    
    interface a
    {
        void a();
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.graphics.Canvas;
import android.webkit.ValueCallback;
import androidx.annotation.WorkerThread;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import android.graphics.Paint;
import java.util.Locale;
import com.inmobi.ads.rendering.InMobiAdActivity;
import android.view.ViewGroup$LayoutParams;
import android.widget.RelativeLayout$LayoutParams;
import android.view.ViewParent;
import android.os.Handler;
import android.graphics.Rect;
import android.annotation.TargetApi;
import java.util.Iterator;
import android.webkit.WebViewClient;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import android.graphics.Bitmap;
import java.util.Timer;
import java.util.TimerTask;
import android.os.Build;
import androidx.annotation.NonNull;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.view.KeyEvent;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.webkit.JsPromptResult;
import android.content.DialogInterface;
import android.app.AlertDialog;
import android.webkit.JsResult;
import android.content.Context;
import org.json.JSONException;
import android.os.SystemClock;
import java.util.Collection;
import java.util.Arrays;
import org.json.JSONArray;
import android.view.MotionEvent;
import java.util.Set;
import androidx.annotation.Nullable;
import android.webkit.WebChromeClient;
import android.view.View;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import android.view.ViewGroup;
import android.app.Activity;
import java.lang.ref.WeakReference;
import android.annotation.SuppressLint;
import android.view.GestureDetector;
import android.webkit.WebView;

@SuppressLint({ "SetJavaScriptEnabled", "ViewConstructor", "ClickableViewAccessibility" })
public final class o extends WebView implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, h, is.a, j, r.a
{
    public static final q a;
    private static final String B;
    private byte C;
    private o D;
    public WeakReference<Activity> b;
    boolean c;
    private WeakReference<ViewGroup> E;
    private q F;
    public String d;
    public byte e;
    public cj f;
    public cm g;
    public cl h;
    private fe G;
    private boolean H;
    public boolean i;
    private ch I;
    private co J;
    private cn K;
    private JSONObject L;
    private JSONObject M;
    public boolean j;
    public boolean k;
    public boolean l;
    private boolean N;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public String q;
    public AtomicBoolean r;
    private final Object O;
    private final Object P;
    public boolean s;
    private boolean Q;
    private View R;
    private WebChromeClient.CustomViewCallback S;
    private int T;
    private boolean U;
    private long V;
    private String W;
    String t;
    public String u;
    public y v;
    private h aa;
    public boolean w;
    private boolean ab;
    private long ac;
    @Nullable
    public i x;
    @Nullable
    private ds ad;
    @Nullable
    private dm ae;
    @Nullable
    private final Set<de> af;
    private dg ag;
    private boolean ah;
    private boolean ai;
    private boolean aj;
    private int ak;
    private int al;
    private String am;
    private int[] an;
    private long ao;
    private int ap;
    private int aq;
    private int ar;
    private final r as;
    private final GestureDetector at;
    private final k au;
    public boolean y;
    private final p av;
    private String aw;
    public String z;
    private final dm.a ax;
    private static final dl.a ay;
    private final h.a az;
    private final WebChromeClient aA;
    public final ax A;
    
    public final void a(final r r) {
        if (!this.getRenderingConfig().gestures.contains(2)) {
            return;
        }
        r.h.length();
        this.e("window.imraidview.onGestureDetected('2', '" + r.h.toString() + "');");
    }
    
    public final void a(final MotionEvent motionEvent) {
        if (!this.getRenderingConfig().gestures.contains(4)) {
            return;
        }
        final JSONArray jsonArray = new JSONArray();
        jsonArray.put((Object)new JSONArray((Collection)Arrays.asList((motionEvent.getX() + motionEvent.getX(1)) / 2.0f, (motionEvent.getY() + motionEvent.getY(1)) / 2.0f)));
        this.e("window.imraidview.onGestureDetected('4', '" + jsonArray.toString() + "');");
    }
    
    public final void a(final MotionEvent motionEvent, final MotionEvent motionEvent2) {
        if (!this.getRenderingConfig().gestures.contains(3)) {
            return;
        }
        final JSONArray jsonArray;
        (jsonArray = new JSONArray()).put((Object)new JSONArray((Collection)Arrays.asList(motionEvent.getX(), motionEvent.getY())));
        jsonArray.put((Object)new JSONArray((Collection)Arrays.asList(motionEvent.getX(1), motionEvent.getY(1))));
        jsonArray.put((Object)new JSONArray((Collection)Arrays.asList(motionEvent2.getX(), motionEvent2.getY())));
        jsonArray.put((Object)new JSONArray((Collection)Arrays.asList(motionEvent2.getX(1), motionEvent2.getY(1))));
        this.e("window.imraidview.onGestureDetected('3', '" + jsonArray.toString() + "');");
    }
    
    public final boolean onDown(final MotionEvent motionEvent) {
        return false;
    }
    
    public final void onShowPress(final MotionEvent motionEvent) {
    }
    
    public final boolean onSingleTapUp(final MotionEvent motionEvent) {
        this.ac = SystemClock.elapsedRealtime();
        return false;
    }
    
    public final boolean onScroll(final MotionEvent motionEvent, final MotionEvent motionEvent2, final float n, final float n2) {
        return false;
    }
    
    public final void onLongPress(final MotionEvent motionEvent) {
        if (!this.getRenderingConfig().gestures.contains(5)) {
            return;
        }
        final JSONArray jsonArray = new JSONArray();
        try {
            jsonArray.put((double)motionEvent.getX());
            jsonArray.put((double)motionEvent.getY());
        }
        catch (JSONException ex) {}
        final JSONArray jsonArray2;
        (jsonArray2 = new JSONArray()).put((Object)jsonArray);
        this.e("window.imraidview.onGestureDetected('5', '" + jsonArray2.toString() + "');");
    }
    
    public final boolean onFling(final MotionEvent motionEvent, final MotionEvent motionEvent2, final float n, final float n2) {
        return false;
    }
    
    public final boolean onSingleTapConfirmed(final MotionEvent motionEvent) {
        if (!this.getRenderingConfig().gestures.contains(0)) {
            return false;
        }
        final JSONArray jsonArray = new JSONArray();
        try {
            jsonArray.put((double)motionEvent.getX());
            jsonArray.put((double)motionEvent.getY());
        }
        catch (JSONException ex) {}
        final JSONArray jsonArray2;
        (jsonArray2 = new JSONArray()).put((Object)jsonArray);
        this.e("window.imraidview.onGestureDetected('0', '" + jsonArray2.toString() + "');");
        return false;
    }
    
    public final boolean onDoubleTap(final MotionEvent motionEvent) {
        if (!this.getRenderingConfig().gestures.contains(1)) {
            return false;
        }
        this.ac = SystemClock.elapsedRealtime();
        if (motionEvent.getAction() == 1) {
            final JSONArray jsonArray = new JSONArray();
            try {
                jsonArray.put((double)motionEvent.getX());
                jsonArray.put((double)motionEvent.getY());
            }
            catch (JSONException ex) {}
            final JSONArray jsonArray2;
            (jsonArray2 = new JSONArray()).put((Object)jsonArray);
            this.e("window.imraidview.onGestureDetected('1', '" + jsonArray2.toString() + "');");
        }
        return false;
    }
    
    public final boolean onDoubleTapEvent(final MotionEvent motionEvent) {
        return false;
    }
    
    public o(final Context context, final byte e, @Nullable final Set<de> af, @Nullable final String u) {
        super(context.getApplicationContext());
        this.C = 0;
        this.c = false;
        this.d = "Default";
        this.j = true;
        this.k = true;
        this.l = false;
        this.N = true;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = null;
        this.r = new AtomicBoolean(false);
        this.O = new Object();
        this.P = new Object();
        this.Q = true;
        this.T = -1;
        this.U = false;
        this.V = Long.MIN_VALUE;
        this.ab = false;
        this.ac = -1L;
        this.aj = true;
        this.aq = Integer.MIN_VALUE;
        this.ar = Integer.MIN_VALUE;
        this.y = false;
        this.av = new p();
        this.aw = "DEFAULT";
        this.ax = new dm.a() {
            @Override
            public final void a(final View view, final Object o) {
                if (view instanceof o) {
                    o.this.j();
                }
            }
        };
        this.az = new h.a() {
            @Override
            public final void a() {
                com.inmobi.media.o.B;
                com.inmobi.media.o.this.getListener().a();
            }
            
            @Override
            public final void a(final Object o) {
                o.B;
                if (0 == o.this.e) {
                    if (null != o.this.D) {
                        o.this.D.setAndUpdateViewState("Expanded");
                    }
                    else {
                        o.this.setAndUpdateViewState("Expanded");
                    }
                    o.this.s = false;
                }
                o.this.getListener().a_(o.this);
            }
            
            @Override
            public final void b(final Object o) {
                o.B;
                if (0 == o.this.e) {
                    o.this.setAndUpdateViewState("Default");
                    if (o.this.D != null) {
                        o.this.D.setAndUpdateViewState("Default");
                    }
                }
                else if ("Default".equals(o.this.d)) {
                    o.this.setAndUpdateViewState("Hidden");
                }
                o.this.getListener().b_(o.this);
            }
        };
        this.aA = new WebChromeClient() {
            public final boolean onJsAlert(final WebView webView, final String title, final String message, final JsResult jsResult) {
                com.inmobi.media.o.B;
                if (com.inmobi.media.o.a(com.inmobi.media.o.this, jsResult)) {
                    final Activity fullScreenActivity;
                    if ((fullScreenActivity = com.inmobi.media.o.this.getFullScreenActivity()) != null) {
                        new AlertDialog.Builder((Context)fullScreenActivity).setMessage((CharSequence)message).setTitle((CharSequence)title).setPositiveButton(17039370, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener() {
                            public final void onClick(final DialogInterface dialogInterface, final int n) {
                                jsResult.confirm();
                            }
                        }).setCancelable(false).create().show();
                    }
                    else {
                        jsResult.cancel();
                    }
                }
                return true;
            }
            
            public final boolean onJsConfirm(final WebView webView, final String s, final String message, final JsResult jsResult) {
                com.inmobi.media.o.B;
                if (com.inmobi.media.o.a(com.inmobi.media.o.this, jsResult)) {
                    final Activity fullScreenActivity;
                    if ((fullScreenActivity = com.inmobi.media.o.this.getFullScreenActivity()) != null) {
                        new AlertDialog.Builder((Context)fullScreenActivity).setMessage((CharSequence)message).setPositiveButton(17039370, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener() {
                            public final void onClick(final DialogInterface dialogInterface, final int n) {
                                jsResult.confirm();
                            }
                        }).setNegativeButton(17039360, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener() {
                            public final void onClick(final DialogInterface dialogInterface, final int n) {
                                jsResult.cancel();
                            }
                        }).create().show();
                    }
                    else {
                        jsResult.cancel();
                    }
                }
                return true;
            }
            
            public final boolean onJsPrompt(final WebView webView, final String s, final String s2, final String s3, final JsPromptResult jsPromptResult) {
                com.inmobi.media.o.B;
                if (!com.inmobi.media.o.a(com.inmobi.media.o.this, (JsResult)jsPromptResult)) {
                    return true;
                }
                if (com.inmobi.media.o.this.getFullScreenActivity() == null) {
                    jsPromptResult.cancel();
                    return true;
                }
                return false;
            }
            
            public final void onShowCustomView(View view, final WebChromeClient.CustomViewCallback customViewCallback) {
                if (com.inmobi.media.o.this.b != null && com.inmobi.media.o.this.b.get() != null) {
                    com.inmobi.media.o.this.R = view;
                    com.inmobi.media.o.this.S = customViewCallback;
                    com.inmobi.media.o.this.R.setOnTouchListener((View.OnTouchListener)new View.OnTouchListener() {
                        public final boolean onTouch(final View view, final MotionEvent motionEvent) {
                            return true;
                        }
                    });
                    final FrameLayout frameLayout = (FrameLayout)((Activity)com.inmobi.media.o.this.b.get()).findViewById(16908290);
                    com.inmobi.media.o.this.R.setBackgroundColor(-16777216);
                    frameLayout.addView(com.inmobi.media.o.this.R, (ViewGroup.LayoutParams)new AbsoluteLayout.LayoutParams(-1, -1, 0, 0));
                    com.inmobi.media.o.this.R.requestFocus();
                    final View k = com.inmobi.media.o.this.R;
                    final View.OnKeyListener onKeyListener = (View.OnKeyListener)new View.OnKeyListener() {
                        public final boolean onKey(final View view, final int n, final KeyEvent keyEvent) {
                            if (4 == keyEvent.getKeyCode() && keyEvent.getAction() == 0) {
                                com.inmobi.media.o.B;
                                o$6.this.a();
                                return true;
                            }
                            return false;
                        }
                    };
                    view = k;
                    k.setOnKeyListener((View.OnKeyListener)onKeyListener);
                    view.setFocusable(true);
                    view.setFocusableInTouchMode(true);
                    view.requestFocus();
                }
            }
            
            public final void onHideCustomView() {
                this.a();
                super.onHideCustomView();
            }
            
            private void a() {
                if (com.inmobi.media.o.this.R == null) {
                    return;
                }
                if (com.inmobi.media.o.this.S != null) {
                    com.inmobi.media.o.this.S.onCustomViewHidden();
                    com.inmobi.media.o.this.S = null;
                }
                if (com.inmobi.media.o.this.R != null && com.inmobi.media.o.this.R.getParent() != null) {
                    ((ViewGroup)com.inmobi.media.o.this.R.getParent()).removeView(com.inmobi.media.o.this.R);
                    com.inmobi.media.o.this.R = null;
                }
            }
            
            public final void onGeolocationPermissionsShowPrompt(final String s, final GeolocationPermissions.Callback callback) {
                if (com.inmobi.media.o.this.b != null && com.inmobi.media.o.this.b.get() != null) {
                    new AlertDialog.Builder((Context)com.inmobi.media.o.this.b.get()).setTitle((CharSequence)"Location Permission").setMessage((CharSequence)"Allow location access").setPositiveButton(17039370, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener() {
                        public final void onClick(final DialogInterface dialogInterface, final int n) {
                            callback.invoke(s, true, false);
                        }
                    }).setNegativeButton(17039360, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener() {
                        public final void onClick(final DialogInterface dialogInterface, final int n) {
                            callback.invoke(s, false, false);
                        }
                    }).create().show();
                }
                super.onGeolocationPermissionsShowPrompt(s, callback);
            }
            
            public final boolean onConsoleMessage(final ConsoleMessage consoleMessage) {
                consoleMessage.message();
                consoleMessage.lineNumber();
                consoleMessage.sourceId();
                com.inmobi.media.o.B;
                return true;
            }
        };
        this.A = new ax() {
            @Override
            public final void a(final am am, byte b) {
                if (am.f != null && am.a.size() > 0) {
                    b = (byte)new JSONObject();
                    try {
                        ((JSONObject)b).put("url", (Object)am.a.get(0).d);
                        ((JSONObject)b).put("reason", (int)am.a.get(0).l);
                    }
                    catch (JSONException ex) {}
                    final String string = "sendSaveContentResult(\"saveContent_" + am.g + "\", 'failed', \"" + ((JSONObject)b).toString().replace("\"", "\\\"") + "\");";
                    com.inmobi.media.o.B;
                    com.inmobi.media.o.this.a(am.f, string);
                }
            }
            
            @Override
            public final void a(final am am) {
                if (am.f != null && am.a.size() > 0) {
                    final String string = "sendSaveContentResult(\"saveContent_" + am.g + "\", 'success', \"" + am.a.get(0).k + "\");";
                    com.inmobi.media.o.B;
                    com.inmobi.media.o.this.a(am.f, string);
                }
            }
        };
        this.D = null;
        this.e = e;
        this.s = false;
        this.af = af;
        this.u = u;
        this.setReferenceContainer(this);
        this.aa = this;
        this.ai = true;
        this.as = new r(this);
        (this.at = new GestureDetector(context, (GestureDetector.OnGestureListener)this)).setOnDoubleTapListener((GestureDetector.OnDoubleTapListener)this);
        this.au = new k(this);
        this.at.setIsLongpressEnabled(e == 1);
    }
    
    public final void setAdPodHandler(@Nullable final i x) {
        this.x = x;
    }
    
    @Nullable
    public final i getAdPodHandler() {
        return this.x;
    }
    
    public final void setAdSize(@NonNull final String w) {
        this.W = w;
        this.al = ho.a(Integer.parseInt(w.split("x")[0]));
        this.ak = ho.a(Integer.parseInt(w.split("x")[1]));
        this.ao = this.ak * this.al;
    }
    
    public final void setIsPreload(final boolean w) {
        this.w = w;
    }
    
    public final void setPlacementId(final long v) {
        this.V = v;
    }
    
    public final void setImpressionId(final String u) {
        this.u = u;
    }
    
    public final void setCreativeId(final String t) {
        this.t = t;
    }
    
    public final void setAllowAutoRedirection(final boolean ab) {
        this.ab = ab;
    }
    
    public final void setBlobProvider(final y v) {
        this.v = v;
    }
    
    public final String getImpressionId() {
        return this.u;
    }
    
    public final String getCreativeId() {
        return this.t;
    }
    
    public final long getPlacementId() {
        return this.V;
    }
    
    public final boolean getAllowAutoRedirection() {
        return this.ab;
    }
    
    public final void setOriginalRenderView(final o d) {
        this.D = d;
    }
    
    public final o getOriginalRenderView() {
        return this.D;
    }
    
    public final Object getDataModel() {
        return null;
    }
    
    public final h.a getFullScreenEventsListener() {
        return this.az;
    }
    
    public final byte getPlacementType() {
        return this.e;
    }
    
    public final String getState() {
        return this.d;
    }
    
    public final Object getDefaultPositionMonitor() {
        return this.O;
    }
    
    public final Object getCurrentPositionMonitor() {
        return this.P;
    }
    
    public final void setShouldFireRenderBeacon(final boolean aj) {
        this.aj = aj;
    }
    
    public final String getContentUrl() {
        return this.am;
    }
    
    public final void setContentUrl(final String am) {
        this.am = am;
    }
    
    @NonNull
    public final Context getContainerContext() {
        if (this.b != null && this.b.get() != null) {
            return this.b.get();
        }
        return this.getContext();
    }
    
    public final void g() {
        final int[] array = new int[2];
        this.L = new JSONObject();
        if (this.E == null) {
            this.E = new WeakReference<ViewGroup>((ViewGroup)this.getParent());
        }
        if (this.E.get() != null) {
            this.E.get().getLocationOnScreen(array);
            try {
                this.L.put("x", ho.b(array[0]));
                this.L.put("y", ho.b(array[1]));
                final int b = ho.b(this.E.get().getWidth());
                final int b2 = ho.b(this.E.get().getHeight());
                this.L.put("width", b);
                this.L.put("height", b2);
            }
            catch (JSONException ex) {}
        }
        else {
            try {
                this.L.put("x", 0);
                this.L.put("y", 0);
                this.L.put("width", 0);
                this.L.put("height", 0);
            }
            catch (JSONException ex2) {}
        }
        synchronized (this.O) {
            this.j = false;
            this.O.notifyAll();
        }
    }
    
    public final String getDefaultPosition() {
        if (this.L == null) {
            return "";
        }
        return this.L.toString();
    }
    
    public final void h() {
        this.M = new JSONObject();
        final int[] array = new int[2];
        this.getLocationOnScreen(array);
        try {
            this.M.put("x", ho.b(array[0]));
            this.M.put("y", ho.b(array[1]));
            final int b = ho.b(this.getWidth());
            final int b2 = ho.b(this.getHeight());
            this.M.put("width", b);
            this.M.put("height", b2);
        }
        catch (JSONException ex) {}
        synchronized (this.P) {
            this.k = false;
            this.P.notifyAll();
        }
    }
    
    public final String getCurrentPosition() {
        if (this.M == null) {
            return "";
        }
        return this.M.toString();
    }
    
    public final void setFullScreenActivityContext(final Activity referent) {
        this.b = new WeakReference<Activity>(referent);
        if (this.K != null) {
            this.setOrientationProperties(this.K);
        }
    }
    
    @Nullable
    public final Activity getFullScreenActivity() {
        if (this.b == null) {
            return null;
        }
        return this.b.get();
    }
    
    public final fe.i getRenderingConfig() {
        return this.G.rendering;
    }
    
    public final fe.g getMraidConfig() {
        return this.G.mraid;
    }
    
    protected final void onSizeChanged(int b, int b2, int i, final int n) {
        super.onSizeChanged(b, b2, i, n);
        if (b != 0 && b2 != 0) {
            b = ho.b(b);
            b2 = ho.b(b2);
            final int n2 = b;
            i = b2;
            b2 = n2;
            this.e("window.mraidview.broadcastEvent('sizeChange'," + b2 + "," + i + ");");
        }
    }
    
    public final void onWindowVisibilityChanged(final int n) {
        super.onWindowVisibilityChanged(n);
        this.f(n == 0);
    }
    
    public final void onWindowFocusChanged(boolean b) {
        super.onWindowFocusChanged(b);
        this.U = !b;
        if (b) {
            b = (this.isShown() && com.inmobi.media.o.ay.a((View)this, (View)this, this.getAdConfig().viewability.web.impressionMinPercentageViewed, null) && com.inmobi.media.o.ay.a((View)this, (View)this, this.getAdConfig().viewability.web.impressionMinPercentageViewed));
        }
        this.e(b);
    }
    
    public final void onScreenStateChanged(final int n) {
        super.onScreenStateChanged(n);
        if (n == 0) {
            this.e(false);
            return;
        }
        if (!this.U) {
            this.e(true);
        }
    }
    
    private void e(final boolean b) {
        if (this.n == b) {
            return;
        }
        if (Build.VERSION.SDK_INT > 23 && this.getFullScreenActivity() != null && this.getFullScreenActivity().isInMultiWindowMode()) {
            return;
        }
        this.f(b);
    }
    
    private void f(final boolean n) {
        if (this.n == n) {
            return;
        }
        if (!this.s) {
            this.n = n;
            if (n) {
                this.getListener().f(this);
            }
            this.g(this.n);
        }
    }
    
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.H = this.isHardwareAccelerated();
        if (this.E == null) {
            this.E = new WeakReference<ViewGroup>((ViewGroup)this.getParent());
        }
        if (this.aj && this.ah) {
            final is is = new is((View)this, this);
            final long n = this.getListener().c_().b();
            final is is2 = is;
            final TimerTask timerTask = new TimerTask() {
                @Override
                public final void run() {
                    final a a = (a)is.a(is2).get();
                    if (!is.b(is2)) {
                        is.c(is2);
                        if (a != null) {
                            a.m();
                        }
                    }
                }
            };
            final View view;
            if ((view = is2.a.get()) != null) {
                view.post((Runnable)new Runnable() {
                    final /* synthetic */ TimerTask a = timerTask;
                    
                    @Override
                    public final void run() {
                        final a a = (a)is.a(is2).get();
                        final Timer timer;
                        (timer = new Timer(is.a())).schedule(this.a, n);
                        new Thread(new Runnable() {
                            @Override
                            public final void run() {
                                try {
                                    do {
                                        try {
                                            final View view;
                                            if ((view = (View)is.d(is2).get()) != null) {
                                                final Bitmap a;
                                                if ((a = is.a(view)) != null) {
                                                    final int[] array = new int[a.getWidth() * a.getHeight()];
                                                    a.getPixels(array, 0, a.getWidth(), 0, 0, a.getWidth(), a.getHeight());
                                                    final int[] array2;
                                                    final int length = (array2 = array).length;
                                                    int i = 0;
                                                    while (i < length) {
                                                        final int n;
                                                        if ((n = array2[i]) > -16777216 && n < 0) {
                                                            is.a();
                                                            is.e(is2);
                                                            timer.cancel();
                                                            if (a != null) {
                                                                a.l();
                                                                break;
                                                            }
                                                            break;
                                                        }
                                                        else {
                                                            ++i;
                                                        }
                                                    }
                                                    if (!is.b(is2)) {
                                                        Thread.sleep(200L);
                                                    }
                                                }
                                            }
                                            else {
                                                is.a();
                                                timer.cancel();
                                                if (a != null) {
                                                    a.m();
                                                }
                                            }
                                        }
                                        catch (IllegalStateException ex) {
                                            if (a != null) {
                                                a.m();
                                            }
                                        }
                                    } while (!is.f(is2) && !is.b(is2));
                                }
                                catch (InterruptedException ex2) {
                                    if (a != null) {
                                        a.m();
                                    }
                                }
                            }
                        }).start();
                    }
                });
            }
        }
    }
    
    public final boolean onTouchEvent(final MotionEvent motionEvent) {
        if (this.e == 1) {
            final r as = this.as;
            switch (motionEvent.getActionMasked()) {
                case 0: {
                    as.e = motionEvent.getPointerId(motionEvent.getActionIndex());
                    (as.h = new JSONArray()).put((Object)new JSONArray((Collection)Arrays.asList(motionEvent.getX(), motionEvent.getY())));
                    break;
                }
                case 5: {
                    as.f = motionEvent.getPointerId(motionEvent.getActionIndex());
                    as.i = MotionEvent.obtain(motionEvent);
                    final int pointerIndex = motionEvent.findPointerIndex(as.e);
                    final int pointerIndex2 = motionEvent.findPointerIndex(as.f);
                    if (pointerIndex >= 0) {
                        as.c = motionEvent.getX(pointerIndex);
                        as.d = motionEvent.getY(pointerIndex);
                    }
                    else {
                        fv.a().a(new gv(new IllegalArgumentException("Index for mPtrID1=" + as.e + " is" + pointerIndex + " | Pointer count=" + motionEvent.getPointerCount())));
                    }
                    if (pointerIndex2 >= 0) {
                        as.a = motionEvent.getX(pointerIndex2);
                        as.b = motionEvent.getY(pointerIndex2);
                    }
                    else {
                        fv.a().a(new gv(new IllegalArgumentException("Index for mPtrID2=" + as.f + " is" + pointerIndex2 + " | Pointer count=" + motionEvent.getPointerCount())));
                    }
                    final r r = as;
                    r.j = com.inmobi.media.r.a(r.c, as.a, as.d, as.b);
                    break;
                }
                case 2: {
                    if (as.e != -1 && as.f != -1) {
                        float x = 0.0f;
                        float y = 0.0f;
                        float x2 = 0.0f;
                        float y2 = 0.0f;
                        final int pointerIndex3 = motionEvent.findPointerIndex(as.e);
                        final int pointerIndex4 = motionEvent.findPointerIndex(as.f);
                        if (pointerIndex3 >= 0) {
                            x2 = motionEvent.getX(pointerIndex3);
                            y2 = motionEvent.getY(pointerIndex3);
                        }
                        else {
                            fv.a().a(new gv(new IllegalArgumentException("Index for mPtrID1=" + as.e + " is" + pointerIndex3 + " | Pointer count=" + motionEvent.getPointerCount())));
                        }
                        if (pointerIndex4 >= 0) {
                            x = motionEvent.getX(pointerIndex4);
                            y = motionEvent.getY(pointerIndex4);
                        }
                        else {
                            fv.a().a(new gv(new IllegalArgumentException("Index for mPtrID1=" + as.f + " is" + pointerIndex4 + " | Pointer count=" + motionEvent.getPointerCount())));
                        }
                        final r r2 = as;
                        r2.g = Math.abs(com.inmobi.media.r.a(r2.a, as.b, as.c, as.d, x, y, x2, y2));
                        break;
                    }
                    if (as.e != -1 && as.h.length() > 0 && as.h.length() < 50) {
                        try {
                            final float x3 = motionEvent.getX();
                            final float y3 = motionEvent.getY();
                            final JSONArray jsonArray = as.h.getJSONArray(as.h.length() - 1);
                            final JSONArray jsonArray2 = new JSONArray((Collection)Arrays.asList(x3, y3));
                            if (com.inmobi.media.r.a((float)jsonArray.getInt(0), (float)jsonArray2.getInt(0), (float)jsonArray.getInt(1), (float)jsonArray2.getInt(1)) > 100) {
                                as.h.put((Object)jsonArray2);
                            }
                        }
                        catch (JSONException ex) {}
                        break;
                    }
                    break;
                }
                case 1: {
                    as.e = -1;
                    if (as.h.length() > 5) {
                        as.k.a(as);
                        as.h = new JSONArray();
                        break;
                    }
                    break;
                }
                case 6: {
                    as.f = -1;
                    if (as.g > 30.0f) {
                        as.k.a(as.i, motionEvent);
                        as.g = 0.0f;
                    }
                    if (Math.abs(com.inmobi.media.r.a(motionEvent.getX(), motionEvent.getX(1), motionEvent.getY(), motionEvent.getY(1)) - as.j) > 500) {
                        as.k.a(motionEvent);
                        as.j = Integer.MAX_VALUE;
                        break;
                    }
                    break;
                }
                case 3: {
                    as.e = -1;
                    as.f = -1;
                    break;
                }
            }
        }
        this.at.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }
    
    public final void onDetachedFromWindow() {
        this.av.a();
        this.getMediaProcessor().b();
        this.getMediaProcessor().c();
        this.getMediaProcessor().e();
        try {
            super.onDetachedFromWindow();
        }
        catch (IllegalArgumentException ex) {}
    }
    
    private void p() {
        this.s();
        this.r();
        this.q();
    }
    
    private void q() {
        this.C = ((this.W != null) ? this.G.viewability.banner.impressionType : this.G.viewability.interstitial.impressionType);
    }
    
    private void r() {
        if ("video".equals(this.z)) {
            this.ar = this.G.viewability.video.impressionMinPercentageViewed;
            return;
        }
        this.ar = this.G.viewability.web.impressionMinPercentageViewed;
    }
    
    private void s() {
        if ("video".equals(this.z)) {
            this.aq = this.G.viewability.video.impressionMinTimeViewed;
            return;
        }
        this.aq = this.G.viewability.web.impressionMinTimeViewed;
    }
    
    public final byte getImpressionType() {
        return this.C;
    }
    
    @SuppressLint({ "AddJavascriptInterface" })
    @TargetApi(19)
    public final void a(final q f, @NonNull fe g, final boolean ah, final boolean aj) {
        this.G = g;
        g = (fe)this;
        if (this.af == null) {
            ((o)g).p();
        }
        else {
            try {
                ((o)g).p();
                final Iterator<de> iterator = ((o)g).af.iterator();
                while (iterator.hasNext()) {
                    final de de;
                    if ((de = iterator.next()).a == 2) {
                        if (de.b.containsKey("type")) {
                            ((o)g).C = (byte)(int)de.b.get("type");
                        }
                        else {
                            ((o)g).q();
                        }
                        if (de.b.containsKey("time")) {
                            ((o)g).aq = (int)de.b.get("time");
                        }
                        else {
                            ((o)g).s();
                        }
                        if (de.b.containsKey("view")) {
                            ((o)g).ar = (int)de.b.get("view");
                        }
                        else {
                            ((o)g).r();
                        }
                        if (((o)g).getImpressionType() != 2) {
                            continue;
                        }
                        if (de.b.containsKey("pixel")) {
                            ((o)g).ap = (int)de.b.get("pixel");
                        }
                        else {
                            ((o)g).q();
                        }
                        if (de.b.containsKey("frame")) {
                            final JSONArray jsonArray = de.b.get("frame");
                            ((o)g).an = new int[jsonArray.length()];
                            for (int i = 0; i < jsonArray.length(); ++i) {
                                ((o)g).an[i] = (int)jsonArray.get(i);
                            }
                        }
                        else {
                            ((o)g).q();
                        }
                    }
                }
            }
            catch (JSONException ex) {
                ((o)g).p();
            }
            catch (Exception ex2) {
                ((o)g).p();
            }
        }
        if ((this.getImpressionType() == 1 || this.getImpressionType() == 2) && !"video".equals(this.z)) {
            this.ad = new dl(com.inmobi.media.o.ay, this.G.viewability, this.getImpressionType());
            this.ae = new dm(this.G.viewability, this.ad, this.ax);
        }
        this.F = f;
        this.ah = ah;
        this.E = new WeakReference<ViewGroup>((ViewGroup)this.getParent());
        this.aj = aj;
        if (this.getRenderingConfig() != null) {
            this.setBackgroundColor(this.getRenderingConfig().a());
        }
        final ck ck;
        if (this.getMraidConfig() != null && (ck = new ck(this.getMraidConfig().url, this.getMraidConfig().maxRetries, this.getMraidConfig().retryInterval, this.getMraidConfig().expiry)).a != null) {
            ck.b = new gm("GET", ck.a);
            ck.b.q = false;
            ck.b.w = false;
            final HashMap<String, String> hashMap;
            (hashMap = new HashMap<String, String>()).put("Accept-Encoding", "gzip");
            ck.b.a(hashMap);
            new Thread(new Runnable() {
                @Override
                public final void run() {
                    if (!ck.a(ck)) {
                        return;
                    }
                    int i = 0;
                    while (i <= ck.b(ck)) {
                        ck.a();
                        final long elapsedRealtime = SystemClock.elapsedRealtime();
                        final gn a = new gp(ck.c(ck)).a();
                        try {
                            ih.a().a(ck.c(ck).h());
                            ih.a().b(a.d());
                            ih.a().c(SystemClock.elapsedRealtime() - elapsedRealtime);
                        }
                        catch (Exception ex) {
                            ck.a();
                        }
                        final Context c = gz.c();
                        if (a.a()) {
                            ck.a();
                            if (++i > ck.b(ck)) {
                                break;
                            }
                            try {
                                Thread.sleep(ck.d(ck) * 1000);
                            }
                            catch (InterruptedException ex2) {
                                ck.a();
                            }
                        }
                        else {
                            if (c == null) {
                                continue;
                            }
                            final hi hi = new hi(c, "mraid_js_store");
                            final List<String> list;
                            if ((list = a.c.get("Content-Encoding")) != null && list.get(0).equals("gzip")) {
                                ck.a();
                                final byte[] a2;
                                if ((a2 = hg.a(a.c())) != null) {
                                    try {
                                        hi.b("mraid_js_string", new String(a2, "UTF-8"));
                                        ck.a();
                                    }
                                    catch (UnsupportedEncodingException ex3) {
                                        ck.a();
                                        ck.a();
                                    }
                                }
                                return;
                            }
                            hi.b("mraid_js_string", a.b());
                            ck.a();
                        }
                    }
                }
            }).start();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.setImportantForAccessibility(2);
        }
        this.setScrollable(false);
        if (Build.VERSION.SDK_INT >= 17) {
            this.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        this.getSettings().setJavaScriptEnabled(true);
        this.getSettings().setGeolocationEnabled(true);
        this.av.a = (short)((this.e == 0) ? this.G.rendering.bannerNetworkLoadsLimit : this.G.rendering.otherNetworkLoadsLimit);
        this.setWebViewClient((WebViewClient)this.av);
        this.setWebChromeClient(this.aA);
        this.addJavascriptInterface((Object)new cg(this, this.e), "sdkController");
        this.f = new cj(this);
        this.g = new cm(this);
        this.h = new cl(this);
        this.I = new ch();
        this.J = new co("top-right", Boolean.TRUE);
        this.K = new cn();
    }
    
    protected final void onVisibilityChanged(@NonNull final View view, final int n) {
        super.onVisibilityChanged(view, n);
        if (view instanceof o) {
            this.f(n == 0);
            return;
        }
        this.f(false);
    }
    
    private Rect getAdFrameRect() {
        final int[] array = new int[2];
        this.getLocationInWindow(array);
        final int n = array[0] + this.an[0];
        final int n2 = array[1] + this.an[1];
        return new Rect(n, n2, n + this.an[2], n2 + this.an[3]);
    }
    
    public final void setScrollable(final boolean horizontalScrollBarEnabled) {
        this.setScrollContainer(horizontalScrollBarEnabled);
        this.setVerticalScrollBarEnabled(horizontalScrollBarEnabled);
        this.setHorizontalScrollBarEnabled(horizontalScrollBarEnabled);
    }
    
    public final void setIsInAppBrowser(final boolean c) {
        this.c = c;
    }
    
    public final boolean c() {
        return this.r.get();
    }
    
    public final void i() {
        super.destroy();
    }
    
    @TargetApi(11)
    public final void destroy() {
        if (this.r.get()) {
            return;
        }
        if (!this.N) {
            this.N = true;
            return;
        }
        this.r.set(true);
        this.s = true;
        this.T = -1;
        this.removeJavascriptInterface("sdkController");
        if (this.b != null) {
            final Activity activity;
            if ((activity = this.b.get()) != null) {
                activity.finish();
            }
            this.b.clear();
        }
        if (this.E != null) {
            this.E.clear();
        }
        if (this.ag != null) {
            this.ag.d();
            this.ag.e();
        }
        this.F = null;
        this.x = null;
        this.aa = null;
        final ViewParent parent;
        if ((parent = this.getParent()) != null) {
            ((ViewGroup)parent).removeView((View)this);
            this.removeAllViews();
        }
        final fe.h omidConfig = this.G.viewability.omidConfig;
        if (this.ai && omidConfig.omidEnabled && ef.a.a.a()) {
            final fa fa = new fa(this, omidConfig.webViewRetainTime);
            new Handler().postDelayed((Runnable)new Runnable() {
                final /* synthetic */ fd a = fa;
                
                @Override
                public final void run() {
                    this.a.a(this.a.a);
                    this.a.a = null;
                }
            }, fa.b);
            return;
        }
        super.destroy();
    }
    
    public final void a(final byte b, final Map<String, String> map) {
        switch (b) {
            default: {}
            case 2: {
                this.e("inmobi.recordEvent(120,null);");
            }
        }
    }
    
    public final void d() {
        if (this.getFullScreenActivity() != null && this.K != null) {
            this.setOrientationProperties(this.K);
        }
    }
    
    @Nullable
    public final View getVideoContainerView() {
        return null;
    }
    
    public final void setReferenceContainer(final h aa) {
        this.aa = aa;
    }
    
    public final h getReferenceContainer() {
        return this.aa;
    }
    
    @NonNull
    public final fe getAdConfig() {
        return this.G;
    }
    
    @SuppressLint({ "SwitchIntDef" })
    @NonNull
    public final dg getViewableAd() {
        if (this.ag == null) {
            this.ag = ((this.ae != null) ? new dn(this, this.ae, new dh(this), (this.ar == Integer.MIN_VALUE) ? this.getAdConfig().viewability.web.impressionMinPercentageViewed : this.ar, (this.aq == Integer.MIN_VALUE) ? this.getAdConfig().viewability.web.impressionMinTimeViewed : this.aq) : new dh(this));
            if (this.af != null) {
                for (final de de : this.af) {
                    try {
                        switch (de.a) {
                            case 3: {
                                final dy dy = de.b.get("omidAdSession");
                                final boolean b = de.b.containsKey("deferred") && de.b.get("deferred");
                                final String s = de.b.get("customReferenceData");
                                if (b) {
                                    dy.a(ec.a(this, this.getContentUrl(), s));
                                }
                                if (dy != null) {
                                    this.ag = new ec(this, this.ag, dy);
                                    continue;
                                }
                                continue;
                            }
                            case 1: {
                                this.ag = new du(this, this.getContext(), this.ag, de.b);
                                continue;
                            }
                        }
                    }
                    catch (Exception ex) {}
                }
            }
        }
        return this.ag;
    }
    
    public final String getMarkupType() {
        return "html";
    }
    
    public final void b(final String s) {
        this.s = false;
        if (!this.r.get()) {
            this.loadDataWithBaseURL("", s, "text/html", "UTF-8", (String)null);
        }
    }
    
    public final void c(final String s) {
        this.s = false;
        if (!this.r.get()) {
            this.loadUrl(s);
        }
    }
    
    public final void stopLoading() {
        if (!this.r.get()) {
            super.stopLoading();
        }
    }
    
    public final void d(String str) {
        this.e("window.mraidview.fireRedirectFraudBeacon('" + str + "')");
        final String s = str;
        str = ((this.W != null) ? "banner" : "int");
        final String s2 = s;
        final HashMap<String, String> hashMap;
        (hashMap = new HashMap<String, String>()).put("creativeId", this.t);
        hashMap.put("trigger", s2);
        hashMap.put("impressionId", this.getImpressionId());
        hashMap.put("adType", str);
        this.a("BlockAutoRedirection", (Map<String, Object>)hashMap);
    }
    
    public final void a(final boolean b) {
        this.e("window.imraidview.broadcastEvent('adLoadSuccess'," + b + ");");
    }
    
    private void g(final boolean b) {
        this.e("window.mraidview.broadcastEvent('viewableChange'," + b + ");");
    }
    
    public final void j() {
        if ("video".equals(this.z)) {
            return;
        }
        this.e("window.imraidview.impressionRendered();");
        this.getListener().i(this);
    }
    
    public final void b(final String s, String string, final String str) {
        if (s == null || str == null) {
            return;
        }
        string = "broadcastEvent('error',\"" + string + "\", \"" + str + "\")";
        this.a(s, string);
    }
    
    public final void a(String string, final String str) {
        if (string == null) {
            return;
        }
        string = string + "." + str;
        this.e(string);
    }
    
    public final void a(final String s, final Map<String, Object> map) {
        this.getListener().a(s, map);
    }
    
    public final void e(final String s) {
        new Handler(this.getContainerContext().getMainLooper()).postAtFrontOfQueue((Runnable)new Runnable() {
            @Override
            public final void run() {
                try {
                    if (!com.inmobi.media.o.this.r.get()) {
                        final String string = "javascript:try{" + s + "}catch(e){}";
                        com.inmobi.media.o.B;
                        if (Build.VERSION.SDK_INT < 19) {
                            com.inmobi.media.o.a(com.inmobi.media.o.this, string);
                            return;
                        }
                        com.inmobi.media.o.b(com.inmobi.media.o.this, string);
                    }
                }
                catch (Exception ex) {
                    com.inmobi.media.o.B;
                }
            }
        });
    }
    
    public final void setUseCustomClose(final boolean l) {
        this.l = l;
    }
    
    public final void setCloseRegionDisabled(final boolean o) {
        this.o = o;
    }
    
    public final void setDisableBackButton(final boolean p) {
        this.p = p;
    }
    
    public final void b(final boolean closeRegionDisabled) {
        this.setCloseRegionDisabled(closeRegionDisabled);
        final View rootView;
        final cf cf;
        if ((rootView = this.getRootView()) != null && (cf = (cf)rootView.findViewById(65531)) != null) {
            cf.setVisibility(this.o ? 8 : 0);
        }
    }
    
    public final void c(final boolean useCustomClose) {
        this.setUseCustomClose(useCustomClose);
        final View rootView;
        final cf cf;
        if ((rootView = this.getRootView()) != null && (cf = (cf)rootView.findViewById(65532)) != null) {
            cf.setVisibility(this.l ? 8 : 0);
        }
    }
    
    public final void b() {
        final cl h;
        if ((h = this.h).b != null) {
            h.b.a();
            h.b = null;
        }
        if ("Expanded".equals(this.d)) {
            if (!"Default".equals(this.d)) {
                this.s = true;
                final cj f = this.f;
                final View rootView;
                if (null == f.a.getOriginalRenderView() && f.c != null && (rootView = f.c.getRootView()) != null) {
                    final View viewById = rootView.findViewById(65535);
                    ((ViewGroup)f.a.getParent()).removeView((View)f.a);
                    final ViewGroup viewGroup;
                    if ((viewGroup = ((viewById != null && viewById.getParent() instanceof ViewGroup) ? ((ViewGroup)viewById.getParent()) : null)) != null) {
                        viewGroup.removeView(viewById);
                    }
                    f.c.addView((View)f.a, f.d, (ViewGroup$LayoutParams)new RelativeLayout$LayoutParams(f.c.getWidth(), f.c.getHeight()));
                    f.a.u();
                }
                this.t();
                this.s = false;
            }
            this.N = false;
        }
        else if ("Resized".equals(this.d)) {
            if (!"Default".equals(this.d)) {
                this.s = true;
                final cm g;
                final ViewGroup viewGroup2;
                final View view2;
                final View view = ((view2 = (((viewGroup2 = (((g = this.g).a.getParent() instanceof ViewGroup) ? g.a.getParent() : null)) == null) ? null : viewGroup2.getRootView())) == null) ? null : view2.findViewById(65534);
                final View view4;
                final View view3;
                final ViewGroup viewGroup3 = ((view3 = (((view4 = ((g.b == null) ? null : g.b.getRootView())) == null) ? null : view4.findViewById(65535))) == null) ? null : ((ViewGroup)view3.getParent());
                final ViewGroup viewGroup4;
                if ((viewGroup4 = ((view == null) ? null : ((ViewGroup)view.getParent()))) != null) {
                    viewGroup4.removeView(view);
                }
                if (viewGroup3 != null) {
                    viewGroup3.removeView(view3);
                }
                if (viewGroup2 != null) {
                    viewGroup2.removeView((View)g.a);
                }
                if (g.b != null) {
                    g.b.addView((View)g.a, g.c, (ViewGroup$LayoutParams)new RelativeLayout$LayoutParams(g.b.getWidth(), g.b.getHeight()));
                }
                g.a.u();
                this.setAndUpdateViewState("Default");
                this.getListener().b_(this);
                this.s = false;
            }
        }
        else if ("Default".equals(this.d)) {
            this.setAndUpdateViewState("Hidden");
            final ViewParent parent = this.getParent();
            if (1 == this.e) {
                this.t();
            }
            else if (parent instanceof ViewGroup) {
                ((ViewGroup)parent).removeAllViews();
            }
        }
        if (this.x != null && this.n) {
            this.x.b(this);
        }
        this.av.a();
        this.m = false;
    }
    
    private void t() {
        InMobiAdActivity.a((Object)this);
        final Activity fullScreenActivity;
        if ((fullScreenActivity = this.getFullScreenActivity()) != null) {
            ((InMobiAdActivity)fullScreenActivity).a = true;
            fullScreenActivity.finish();
            if (this.T != -1) {
                fullScreenActivity.overridePendingTransition(0, this.T);
            }
        }
        else {
            if (this.e == 0) {
                this.setAndUpdateViewState("Default");
                if (this.D != null) {
                    this.D.setAndUpdateViewState("Default");
                }
            }
            else if ("Default".equals(this.d)) {
                this.setAndUpdateViewState("Hidden");
            }
            this.getListener().b_(this);
        }
    }
    
    public final void setExitAnimation(final int t) {
        this.T = t;
    }
    
    public final void a(final String s) {
        this.au.a(s);
    }
    
    public final void e() {
        this.getListener().a_(this);
        this.c(null, null, null);
    }
    
    public final void f() {
        this.getListener().b_(this);
    }
    
    public final void setRenderViewEventListener(final q f) {
        this.F = f;
    }
    
    public final q getListener() {
        if (this.F == null) {
            return this.F = com.inmobi.media.o.a;
        }
        return this.F;
    }
    
    public final String getViewState() {
        return this.d;
    }
    
    public final cl getMediaProcessor() {
        return this.h;
    }
    
    public final ch getExpandProperties() {
        return this.I;
    }
    
    public final void setExpandProperties(final ch i) {
        if (i.b) {
            this.setUseCustomClose(i.a);
        }
        this.I = i;
    }
    
    public final co getResizeProperties() {
        return this.J;
    }
    
    public final void setResizeProperties(final co j) {
        this.J = j;
    }
    
    public final void setAndUpdateViewState(String lowerCase) {
        this.d = lowerCase;
        lowerCase = this.d.toLowerCase(Locale.ENGLISH);
        this.e("window.mraidview.broadcastEvent('stateChange','" + lowerCase + "');");
    }
    
    private void u() {
        this.setVisibility(0);
        this.requestLayout();
    }
    
    public final void setAdActiveFlag(final boolean m) {
        this.m = m;
    }
    
    public final cn getOrientationProperties() {
        return this.K;
    }
    
    public final void setOrientationProperties(final cn k) {
        this.K = k;
        if (this.b != null && this.b.get() != null && !k.a) {
            final String b = k.b;
            switch (b) {
                case "landscape": {
                    if (ho.b() == 3 || ho.b() == 4) {
                        if (3 == ho.b()) {
                            this.b.get().setRequestedOrientation(0);
                            return;
                        }
                        this.b.get().setRequestedOrientation(8);
                        return;
                    }
                    else {
                        if (k.c.equals("left")) {
                            this.b.get().setRequestedOrientation(8);
                            return;
                        }
                        if (k.c.equals("right")) {
                            this.b.get().setRequestedOrientation(0);
                            return;
                        }
                        break;
                    }
                    break;
                }
                case "portrait": {
                    if (ho.b() == 2) {
                        this.b.get().setRequestedOrientation(9);
                        return;
                    }
                    this.b.get().setRequestedOrientation(1);
                }
                default: {
                    if (ho.b() == 2) {
                        this.b.get().setRequestedOrientation(9);
                        return;
                    }
                    if (ho.b() == 4) {
                        this.b.get().setRequestedOrientation(8);
                        return;
                    }
                    if (ho.b() == 3) {
                        this.b.get().setRequestedOrientation(0);
                        return;
                    }
                    this.b.get().setRequestedOrientation(1);
                    break;
                }
            }
        }
    }
    
    public final String getMraidJsString() {
        String b;
        if ((b = new hi(this.getContext(), "mraid_js_store").b("mraid_js_string")) == null) {
            b = "var imIsObjValid=function(a){return\"undefined\"!=typeof a&&null!=a?!0:!1},EventListeners=function(a){this.event=a;this.count=0;var b=[];this.add=function(a){b.push(a);++this.count};this.remove=function(a){var e=!1,d=this;b=b.filter(function(b){if(b=b===a)--d.count,e=!0;return!b});return e};this.removeAll=function(){b=[];this.count=0};this.broadcast=function(a){b.forEach(function(e){try{e.apply({},a)}catch(d){}})};this.toString=function(){var c=[a,\":\"];b.forEach(function(a){c.push(\"|\",String(a),\"|\")});\nreturn c.join(\"\")}},InmobiObj=function(){this.listeners=[];this.addEventListener=function(a,b){try{if(imIsObjValid(b)&&imIsObjValid(a)){var c=this.listeners;c[a]||(c[a]=new EventListeners);c[a].add(b);\"micIntensityChange\"==a&&window.imraidview.startListeningMicIntensity();\"deviceMuted\"==a&&window.imraidview.startListeningDeviceMuteEvents();\"deviceVolumeChange\"==a&&window.imraidview.startListeningDeviceVolumeChange();\"volumeChange\"==a&&window.imraidview.startListeningVolumeChange();\"headphones\"==a&&\nwindow.imraidview.startListeningHeadphonePluggedEvents();\"backButtonPressed\"==a&&window.imraidview.startListeningForBackButtonPressedEvent();\"downloadStatusChanged\"==a&&window.imraidview.registerDownloaderCallbacks()}}catch(e){this.log(e)}};this.removeEventListener=function(a,b){if(imIsObjValid(a)){var c=this.listeners;imIsObjValid(c[a])&&(imIsObjValid(b)?c[a].remove(b):c[a].removeAll());\"micIntensityChange\"==a&&0==c[a].count&&window.imraidview.stopListeningMicIntensity();\"deviceMuted\"==a&&0==c[a].count&&\nwindow.imraidview.stopListeningDeviceMuteEvents();\"deviceVolumeChange\"==a&&0==c[a].count&&window.imraidview.stopListeningDeviceVolumeChange();\"volumeChange\"==a&&0==c[a].count&&window.imraidview.stopListeningVolumeChange();\"headphones\"==a&&0==c[a].count&&window.imraidview.stopListeningHeadphonePluggedEvents();\"backButtonPressed\"==a&&0==c[a].count&&window.imraidview.stopListeningForBackButtonPressedEvent();\"downloadStatusChanged\"==a&&0==c[a].count&&window.imraidview.unregisterDownloaderCallbacks()}};\nthis.broadcastEvent=function(a){if(imIsObjValid(a)){for(var b=Array(arguments.length),c=0;c<arguments.length;c++)b[c]=arguments[c];c=b.shift();try{this.listeners[c]&&this.listeners[c].broadcast(b)}catch(e){}}};this.sendSaveContentResult=function(a){if(imIsObjValid(a)){for(var b=Array(arguments.length),c=0;c<arguments.length;c++)if(2==c){var e=arguments[c],e=JSON.parse(e);b[c]=e}else b[c]=arguments[c];e=b[1];\"success\"!=e&&(c=b[0].substring(b[0].indexOf(\"_\")+1),imraid.saveContentIDMap[c]&&delete imraid.saveContentIDMap[c]);\nwindow.imraid.broadcastEvent(b[0],b[1],b[2])}}},__im__iosNativeMessageHandler=void 0;window.webkit&&(window.webkit.messageHandlers&&window.webkit.messageHandlers.nativeMessageHandler)&&(__im__iosNativeMessageHandler=window.webkit.messageHandlers.nativeMessageHandler);\nvar __im__iosNativeCall={nativeCallInFlight:!1,nativeCallQueue:[],executeNativeCall:function(a){this.nativeCallInFlight?this.nativeCallQueue.push(a):(this.nativeCallInFlight=!0,imIsObjValid(__im__iosNativeMessageHandler)?__im__iosNativeMessageHandler.postMessage(a):window.location=a)},nativeCallComplete:function(a){0==this.nativeCallQueue.length?this.nativeCallInFlight=!1:(a=this.nativeCallQueue.shift(),imIsObjValid(__im__iosNativeMessageHandler)?__im__iosNativeMessageHandler.postMessage(a):window.location=\na)}},IOSNativeCall=function(){this.urlScheme=\"\";this.executeNativeCall=function(a){if(imIsObjValid(__im__iosNativeMessageHandler)){e={};e.command=a;e.scheme=this.urlScheme;for(var b={},c=1;c<arguments.length;c+=2)d=arguments[c+1],null!=d&&(b[arguments[c]]=\"\"+d);e.params=b}else for(var e=this.urlScheme+\"://\"+a,d,b=!0,c=1;c<arguments.length;c+=2)d=arguments[c+1],null!=d&&(b?(e+=\"?\",b=!1):e+=\"&\",e+=arguments[c]+\"=\"+escape(d));__im__iosNativeCall.executeNativeCall(e);return\"OK\"};this.nativeCallComplete=\nfunction(a){__im__iosNativeCall.nativeCallComplete(a);return\"OK\"};this.updateKV=function(a,b){this[a]=b;var c=this.broadcastMap[a];c&&this.broadcastEvent(c,b)}};\n(function(){var a=window.mraidview={};a.orientationProperties={allowOrientationChange:!0,forceOrientation:\"none\",direction:\"right\"};var b=[],c=!1;a.detectAndBlockFraud=function(e){a.isPossibleFraud()&&a.fireRedirectFraudBeacon(e);return!1};a.popupBlocked=function(e){a.firePopupBlockedBeacon(e)};a.zeroPad=function(a){var d=\"\";10>a&&(d+=\"0\");return d+a};a.supports=function(a){console.log(\"bridge: supports (MRAID)\");if(\"string\"!=typeof a)window.mraid.broadcastEvent(\"error\",\"Supports method expects string parameter\",\n\"supports\");else return\"false\"!=sdkController.supports(\"window.mraidview\",a)};a.useCustomClose=function(a){try{sdkController.useCustomClose(\"window.mraidview\",a)}catch(d){imraidview.showAlert(\"use CustomClose: \"+d)}};a.close=function(){try{sdkController.close(\"window.mraidview\")}catch(a){imraidview.showAlert(\"close: \"+a)}};a.stackCommands=function(a,d){c?b.push(a):(eval(a),d&&(c=!0))};a.expand=function(a){try{\"undefined\"==typeof a&&(a=null),sdkController.expand(\"window.mraidview\",a)}catch(d){imraidview.showAlert(\"executeNativeExpand: \"+\nd+\", URL = \"+a)}};a.setExpandProperties=function(b){try{b?this.props=b:b=null;if(\"undefined\"!=typeof b.lockOrientation&&null!=b.lockOrientation&&\"undefined\"!=typeof b.orientation&&null!=b.orientation){var d={};d.allowOrientationChange=!b.lockOrientation;d.forceOrientation=b.orientation;a.setOrientationProperties(d)}sdkController.setExpandProperties(\"window.mraidview\",a.stringify(b))}catch(c){imraidview.showAlert(\"executeNativesetExpandProperties: \"+c+\", props = \"+b)}};a.getExpandProperties=function(){try{return eval(\"(\"+\nsdkController.getExpandProperties(\"window.mraidview\")+\")\")}catch(a){imraidview.showAlert(\"getExpandProperties: \"+a)}};a.setOrientationProperties=function(b){try{b?(\"undefined\"!=typeof b.allowOrientationChange&&(a.orientationProperties.allowOrientationChange=b.allowOrientationChange),\"undefined\"!=typeof b.forceOrientation&&(a.orientationProperties.forceOrientation=b.forceOrientation)):b=null,sdkController.setOrientationProperties(\"window.mraidview\",a.stringify(a.orientationProperties))}catch(d){imraidview.showAlert(\"setOrientationProperties: \"+\nd+\", props = \"+b)}};a.getOrientationProperties=function(){return{forceOrientation:a.orientationProperties.forceOrientation,allowOrientationChange:a.orientationProperties.allowOrientationChange}};a.resizeProps=null;a.setResizeProperties=function(b){var d,c;try{d=parseInt(b.width);c=parseInt(b.height);if(isNaN(d)||isNaN(c)||1>d||1>c)throw\"Invalid\";b.width=d;b.height=c;a.resizeProps=b;sdkController.setResizeProperties(\"window.mraidview\",a.stringify(b))}catch(h){window.mraid.broadcastEvent(\"error\",\"Invalid properties.\",\n\"setResizeProperties\")}};a.getResizeProperties=function(){try{return eval(\"(\"+sdkController.getResizeProperties(\"window.mraidview\")+\")\")}catch(a){imraidview.showAlert(\"getResizeProperties: \"+a)}};a.open=function(a){\"undefined\"==typeof a&&(a=null);try{sdkController.open(\"window.mraidview\",a)}catch(d){imraidview.showAlert(\"open: \"+d)}};a.getScreenSize=function(){try{return eval(\"(\"+sdkController.getScreenSize(\"window.mraidview\")+\")\")}catch(a){imraidview.showAlert(\"getScreenSize: \"+a)}};a.getMaxSize=\nfunction(){try{return eval(\"(\"+sdkController.getMaxSize(\"window.mraidview\")+\")\")}catch(a){imraidview.showAlert(\"getMaxSize: \"+a)}};a.getCurrentPosition=function(){try{return eval(\"(\"+sdkController.getCurrentPosition(\"window.mraidview\")+\")\")}catch(a){imraidview.showAlert(\"getCurrentPosition: \"+a)}};a.getDefaultPosition=function(){try{return eval(\"(\"+sdkController.getDefaultPosition(\"window.mraidview\")+\")\")}catch(a){imraidview.showAlert(\"getDefaultPosition: \"+a)}};a.getState=function(){try{return String(sdkController.getState(\"window.mraidview\"))}catch(a){imraidview.showAlert(\"getState: \"+\na)}};a.isViewable=function(){try{return sdkController.isViewable(\"window.mraidview\")}catch(a){imraidview.showAlert(\"isViewable: \"+a)}};a.getPlacementType=function(){return sdkController.getPlacementType(\"window.mraidview\")};a.close=function(){try{sdkController.close(\"window.mraidview\")}catch(a){imraidview.showAlert(\"close: \"+a)}};\"function\"!=typeof String.prototype.startsWith&&(String.prototype.startsWith=function(a){return 0==this.indexOf(a)});a.playVideo=function(a){var d=\"\";null!=a&&(d=a);try{sdkController.playVideo(\"window.mraidview\",\nd)}catch(b){imraidview.showAlert(\"playVideo: \"+b)}};a.stringify=function(b){if(\"undefined\"===typeof JSON){var d=\"\",c;if(\"undefined\"==typeof b.length)return a.stringifyArg(b);for(c=0;c<b.length;c++)0<c&&(d+=\",\"),d+=a.stringifyArg(b[c]);return d+\"]\"}return JSON.stringify(b)};a.stringifyArg=function(a){var d,b,c;b=typeof a;d=\"\";if(\"number\"===b||\"boolean\"===b)d+=args;else if(a instanceof Array)d=d+\"[\"+a+\"]\";else if(a instanceof Object){b=!0;d+=\"{\";for(c in a)null!==a[c]&&(b||(d+=\",\"),d=d+'\"'+c+'\":',b=\ntypeof a[c],d=\"number\"===b||\"boolean\"===b?d+a[c]:\"function\"===typeof a[c]?d+'\"\"':a[c]instanceof Object?d+this.stringify(args[i][c]):d+'\"'+a[c]+'\"',b=!1);d+=\"}\"}else a=a.replace(/\\\\/g,\"\\\\\\\\\"),a=a.replace(/\"/g,'\\\\\"'),d=d+'\"'+a+'\"';imraidview.showAlert(\"json:\"+d);return d};getPID=function(a){var b=\"\";null!=a&&(\"undefined\"!=typeof a.id&&null!=a.id)&&(b=a.id);return b};a.resize=function(){if(null==a.resizeProps)window.mraid.broadcastEvent(\"error\",\"Valid resize dimensions must be provided before calling resize\",\n\"resize\");else try{sdkController.resize(\"window.mraidview\")}catch(b){imraidview.showAlert(\"resize called in bridge\")}};a.storePicture=function(b){console.log(\"bridge: storePicture\");if(\"string\"!=typeof b)window.mraid.broadcastEvent(\"error\",\"storePicture method expects url as string parameter\",\"storePicture\");else{if(a.supports(\"storePicture\"))return!window.confirm(\"Do you want to download the file?\")?(window.mraid.broadcastEvent(\"error\",\"Store picture on \"+b+\" was cancelled by user.\",\"storePicture\"),\n!1):sdkController.storePicture(\"window.mraidview\",b);window.mraid.broadcastEvent(\"error\",\"Store picture on \"+b+\" was cancelled because it is unsupported in this device/app.\",\"storePicture\")}};a.fireMediaTrackingEvent=function(a,b){};a.fireMediaErrorEvent=function(a,b){};a.fireMediaTimeUpdateEvent=function(a,b,c){};a.fireMediaCloseEvent=function(a,b,c){};a.fireMediaVolumeChangeEvent=function(a,b,c){};a.broadcastEvent=function(){window.mraid.broadcastEvent.apply(window.mraid,arguments)}})();\n(function(){var a=window.mraid=new InmobiObj,b=window.mraidview,c=!1;b.isAdShownToUser=!1;b.onUserInteraction=function(){c=!0};b.isPossibleFraud=function(){return a.supports(\"redirectFraudDetection\")&&(!b.isAdShownToUser||!c)};b.fireRedirectFraudBeacon=function(a){if(\"undefined\"!=typeof inmobi&&inmobi.recordEvent){var d={};d.trigger=a;d.isAdShown=b.isAdShownToUser.toString();inmobi.recordEvent(135,d)}};b.firePopupBlockedBeacon=function(a){if(\"undefined\"!=typeof inmobi&&inmobi.recordEvent){var b={};\nb.trigger=a;inmobi.recordEvent(136,b)}};window.onbeforeunload=function(){b.detectAndBlockFraud(\"redirect\")};a.addEventListener(\"viewableChange\",function(a){a&&!b.isAdShownToUser&&(b.isAdShownToUser=!0)});a.useCustomClose=b.useCustomClose;a.close=b.close;a.getExpandProperties=b.getExpandProperties;a.setExpandProperties=function(c){\"undefined\"!=typeof c&&(\"useCustomClose\"in c&&\"undefined\"!=typeof a.getState()&&\"expanded\"!=a.getState())&&a.useCustomClose(c.useCustomClose);b.setExpandProperties(c)};a.getResizeProperties=\nb.getResizeProperties;a.setResizeProperties=b.setResizeProperties;a.getOrientationProperties=b.getOrientationProperties;a.setOrientationProperties=b.setOrientationProperties;a.expand=b.expand;a.getMaxSize=b.getMaxSize;a.getState=b.getState;a.isViewable=b.isViewable;a.createCalendarEvent=function(a){window.mraid.broadcastEvent(\"error\",\"Method not supported\",\"createCalendarEvent\")};a.open=function(c){b.detectAndBlockFraud(\"mraid.open\")||(\"string\"!=typeof c?a.broadcastEvent(\"error\",\"URL is required.\",\n\"open\"):b.open(c))};a.resize=b.resize;a.getVersion=function(){return\"2.0\"};a.getPlacementType=b.getPlacementType;a.playVideo=function(a){b.playVideo(a)};a.getScreenSize=b.getScreenSize;a.getCurrentPosition=b.getCurrentPosition;a.getDefaultPosition=b.getDefaultPosition;a.supports=function(a){return b.supports(a)};a.storePicture=function(c){\"string\"!=typeof c?a.broadcastEvent(\"error\",\"Request must specify a valid URL\",\"storePicture\"):b.storePicture(c)}})();\n(function(){var a=window.imraidview={},b,c=!0;a.setOrientationProperties=function(b){try{b?(\"undefined\"!=typeof b.allowOrientationChange&&(mraidview.orientationProperties.allowOrientationChange=b.allowOrientationChange),\"undefined\"!=typeof b.forceOrientation&&(mraidview.orientationProperties.forceOrientation=b.forceOrientation),\"undefined\"!=typeof b.direction&&(mraidview.orientationProperties.direction=b.direction)):b=null,sdkController.setOrientationProperties(\"window.imraidview\",mraidview.stringify(mraidview.orientationProperties))}catch(c){a.showAlert(\"setOrientationProperties: \"+\nc+\", props = \"+b)}};a.getOrientationProperties=function(){return mraidview.orientationProperties};a.getWindowOrientation=function(){var a=window.orientation;0>a&&(a+=360);window.innerWidth!==this.previousWidth&&0==a&&window.innerWidth>window.innerHeight&&(a=90);return a};var e=function(){window.setTimeout(function(){if(c||a.getWindowOrientation()!==b)c=!1,b=a.getWindowOrientation(),sdkController.onOrientationChange(\"window.imraidview\"),imraid.broadcastEvent(\"orientationChange\",b)},200)};a.registerOrientationListener=\nfunction(){b=a.getWindowOrientation();window.addEventListener(\"resize\",e,!1);window.addEventListener(\"orientationchange\",e,!1)};a.unRegisterOrientationListener=function(){window.removeEventListener(\"resize\",e,!1);window.removeEventListener(\"orientationchange\",e,!1)};window.imraidview.registerOrientationListener();a.firePostStatusEvent=function(a){window.imraid.broadcastEvent(\"postStatus\",a)};a.fireMediaTrackingEvent=function(a,b){var c={};c.name=a;var f=\"inmobi_media_\"+a;\"undefined\"!=typeof b&&(null!=\nb&&\"\"!=b)&&(f=f+\"_\"+b);window.imraid.broadcastEvent(f,c)};a.fireMediaErrorEvent=function(a,b){var c={name:\"error\"};c.code=b;var f=\"inmobi_media_\"+c.name;\"undefined\"!=typeof a&&(null!=a&&\"\"!=a)&&(f=f+\"_\"+a);window.imraid.broadcastEvent(f,c)};a.fireMediaTimeUpdateEvent=function(a,b,c){var f={name:\"timeupdate\",target:{}};f.target.currentTime=b;f.target.duration=c;b=\"inmobi_media_\"+f.name;\"undefined\"!=typeof a&&(null!=a&&\"\"!=a)&&(b=b+\"_\"+a);window.imraid.broadcastEvent(b,f)};a.saveContent=function(a,\nb,c){window.imraid.addEventListener(\"saveContent_\"+a,c);sdkController.saveContent(\"window.imraidview\",a,b)};a.cancelSaveContent=function(a){sdkController.cancelSaveContent(\"window.imraidview\",a)};a.disableCloseRegion=function(a){sdkController.disableCloseRegion(\"window.imraidview\",a)};a.fireGalleryImageSelectedEvent=function(a,b,c){var f=new Image;f.src=\"data:image/jpeg;base64,\"+a;f.width=b;f.height=c;window.imraid.broadcastEvent(\"galleryImageSelected\",f)};a.fireCameraPictureCatpturedEvent=function(a,\nb,c){var f=new Image;f.src=\"data:image/jpeg;base64,\"+a;f.width=b;f.height=c;window.imraid.broadcastEvent(\"cameraPictureCaptured\",f)};a.fireMediaCloseEvent=function(a,b,c){var f={name:\"close\"};f.viaUserInteraction=b;f.target={};f.target.currentTime=c;b=\"inmobi_media_\"+f.name;\"undefined\"!=typeof a&&(null!=a&&\"\"!=a)&&(b=b+\"_\"+a);window.imraid.broadcastEvent(b,f)};a.fireMediaVolumeChangeEvent=function(a,b,c){var f={name:\"volumechange\",target:{}};f.target.volume=b;f.target.muted=c;b=\"inmobi_media_\"+f.name;\n\"undefined\"!=typeof a&&(null!=a&&\"\"!=a)&&(b=b+\"_\"+a);window.imraid.broadcastEvent(b,f)};a.fireDeviceMuteChangeEvent=function(a){window.imraid.broadcastEvent(\"deviceMuted\",a)};a.fireDeviceVolumeChangeEvent=function(a){window.imraid.broadcastEvent(\"deviceVolumeChange\",a)};a.fireHeadphonePluggedEvent=function(a){window.imraid.broadcastEvent(\"headphones\",a)};a.showAlert=function(a){sdkController.showAlert(\"window.imraidview\",a)};a.openExternal=function(b,c){try{600<=getSdkVersionInt()?sdkController.openExternal(\"window.imraidview\",\nb,c):sdkController.openExternal(\"window.imraidview\",b)}catch(e){a.showAlert(\"openExternal: \"+e)}};a.log=function(b){try{sdkController.log(\"window.imraidview\",b)}catch(c){a.showAlert(\"log: \"+c)}};a.getPlatform=function(){return\"android\"};a.asyncPing=function(b){try{sdkController.asyncPing(\"window.imraidview\",b)}catch(c){a.showAlert(\"asyncPing: \"+c)}};a.startListeningDeviceMuteEvents=function(){sdkController.registerDeviceMuteEventListener(\"window.imraidview\")};a.stopListeningDeviceMuteEvents=function(){sdkController.unregisterDeviceMuteEventListener(\"window.imraidview\")};\na.startListeningDeviceVolumeChange=function(){sdkController.registerDeviceVolumeChangeEventListener(\"window.imraidview\")};a.stopListeningDeviceVolumeChange=function(){sdkController.unregisterDeviceVolumeChangeEventListener(\"window.imraidview\")};a.startListeningHeadphonePluggedEvents=function(){sdkController.registerHeadphonePluggedEventListener(\"window.imraidview\")};a.stopListeningHeadphonePluggedEvents=function(){sdkController.unregisterHeadphonePluggedEventListener(\"window.imraidview\")};getSdkVersionInt=\nfunction(){for(var b=a.getSdkVersion().split(\".\"),c=b.length,e=\"\",f=0;f<c;f++)e+=b[f];return parseInt(e)};a.getSdkVersion=function(){return window._im_imaiview.getSdkVersion()};a.supports=function(a){console.log(\"bridge: supports (IMRAID)\");if(\"string\"!=typeof a)window.imraid.broadcastEvent(\"error\",\"Supports method expects string parameter\",\"supports\");else return\"false\"!=sdkController.supports(\"window.imraidview\",a)};a.postToSocial=function(b,c,e,f){window.imraid.broadcastEvent(\"error\",\"Method not supported\",\n\"postToSocial\");a.log(\"Method postToSocial not supported\")};a.incentCompleted=function(a){if(\"object\"!=typeof a||null==a)sdkController.incentCompleted(\"window.imraidview\",null);else try{sdkController.incentCompleted(\"window.imraidview\",JSON.stringify(a))}catch(b){sdkController.incentCompleted(\"window.imraidview\",null)}};a.getOrientation=function(){try{return String(sdkController.getOrientation(\"window.imraidview\"))}catch(b){a.showAlert(\"getOrientation: \"+b)}};a.acceptAction=function(b){try{sdkController.acceptAction(\"window.imraidview\",\nmraidview.stringify(b))}catch(c){a.showAlert(\"acceptAction: \"+c+\", params = \"+b)}};a.rejectAction=function(b){try{sdkController.rejectAction(\"window.imraidview\",mraidview.stringify(b))}catch(c){a.showAlert(\"rejectAction: \"+c+\", params = \"+b)}};a.updateToPassbook=function(b){window.imraid.broadcastEvent(\"error\",\"Method not supported\",\"updateToPassbook\");a.log(\"Method not supported\")};a.isDeviceMuted=function(){return\"false\"!=sdkController.isDeviceMuted(\"window.imraidview\")};a.getDeviceVolume=function(){return 603>=\ngetSdkVersionInt()?-1:sdkController.getDeviceVolume(\"window.imraidview\")};a.isHeadPhonesPlugged=function(){return\"false\"!=sdkController.isHeadphonePlugged(\"window.imraidview\")};a.sendSaveContentResult=function(){window.imraid.sendSaveContentResult.apply(window.imraid,arguments)};a.broadcastEvent=function(){window.imraid.broadcastEvent.apply(window.imraid,arguments)};a.disableBackButton=function(a){void 0==a||\"boolean\"!=typeof a?console.log(\"disableBackButton called with invalid params\"):sdkController.disableBackButton(\"window.imraidview\",\na)};a.isBackButtonDisabled=function(){return sdkController.isBackButtonDisabled(\"window.imraidview\")};a.startListeningForBackButtonPressedEvent=function(){sdkController.registerBackButtonPressedEventListener(\"window.imraidview\")};a.stopListeningForBackButtonPressedEvent=function(){sdkController.unregisterBackButtonPressedEventListener(\"window.imraidview\")};a.hideStatusBar=function(){};a.setOpaqueBackground=function(){};a.startDownloader=function(a,b,c){682<=getSdkVersionInt()&&sdkController.startDownloader(\"window.imraidview\",\na,b,c)};a.registerDownloaderCallbacks=function(){682<=getSdkVersionInt()&&sdkController.registerDownloaderCallbacks(\"window.imraidview\")};a.unregisterDownloaderCallbacks=function(){682<=getSdkVersionInt()&&sdkController.unregisterDownloaderCallbacks(\"window.imraidview\")};a.getDownloadProgress=function(){return 682<=getSdkVersionInt()?sdkController.getDownloadProgress(\"window.imraidview\"):-1};a.getDownloadStatus=function(){return 682<=getSdkVersionInt()?sdkController.getDownloadStatus(\"window.imraidview\"):\n-1};a.fireEvent=function(a){700<=getSdkVersionInt()&&(\"fireSkip\"===a?sdkController.fireSkip(\"window.imraidview\"):\"fireComplete\"===a?sdkController.fireComplete(\"window.imraidview\"):\"showEndCard\"===a&&sdkController.showEndCard(\"window.imraidview\"))};a.saveBlob=function(a){700<=getSdkVersionInt()&&sdkController.saveBlob(\"window.imraidview\",a)};a.getBlob=function(a,b){700<=getSdkVersionInt()&&sdkController.getBlob(a,b)};a.setCloseEndCardTracker=function(a){700<=getSdkVersionInt()&&sdkController.setCloseEndCardTracker(\"window.imraidview\",\na)};a.getRenderableAdIndexes=function(){try{if(917<=getSdkVersionInt())return sdkController.getRenderableAdIndexes(\"window.imraidview\")}catch(a){}return\"[]\"};a.getCurrentRenderingIndex=function(){try{if(917<=getSdkVersionInt())return sdkController.getCurrentRenderingIndex(\"window.imraidview\")}catch(a){}return-1};a.showAd=function(a){try{917<=getSdkVersionInt()&&sdkController.showAd(\"window.imraidview\",a)}catch(b){}};a.timeSinceShow=function(){try{if(917<=getSdkVersionInt())return sdkController.timeSinceShow(\"window.imraidview\")}catch(a){}return-1};\na.getShowTimeStamp=function(){try{if(917<=getSdkVersionInt())return sdkController.getShowTimeStamp(\"window.imraidview\")}catch(a){}return-1};a.closeAll=function(){try{917<=getSdkVersionInt()&&sdkController.closeAll(\"window.imraidview\")}catch(a){}};a.loadAd=function(a){try{917<=getSdkVersionInt()&&sdkController.loadAd(\"window.imraidview\",a)}catch(b){}};a.setAdContext=function(a){try{917<=getSdkVersionInt()&&sdkController.setAdContext(\"window.imraidview\",a)}catch(b){}};a.getAdContext=function(){try{if(917<=\ngetSdkVersionInt())return sdkController.getAdContext(\"window.imraidview\")}catch(a){}return\"\"};a.openWithoutTracker=function(a){try{\"undefined\"==typeof a&&(a=null),sdkController.openWithoutTracker(\"window.imraidview\",a)}catch(b){}};a.impressionRendered=function(){window.imraid.broadcastEvent(\"impressionRendered\")};a.onGestureDetected=function(a,b){window.imraid.broadcastEvent(\"onGestureDetected\",a,b)};a.onUserLandingCompleted=function(){window.imraid.broadcastEvent(\"onUserLandingCompleted\")}})();\n(function(){var a=window.imraid=new InmobiObj,b=window.imraidview;a.getOrientation=b.getOrientation;a.setOrientationProperties=b.setOrientationProperties;a.getOrientationProperties=b.getOrientationProperties;a.saveContentIDMap={};a.saveContent=function(c,e,d){var k=arguments.length,h,f=null;if(3>k){if(\"function\"===typeof arguments[k-1])h=arguments[k-1];else return;f={reason:1}}else a.saveContentIDMap[c]&&(h=arguments[2],f={reason:11,url:arguments[1]});\"function\"!==!h&&(f?(window.imraid.addEventListener(\"saveContent_failed_\"+\nc,h),window.imraid.sendSaveContentResult(\"saveContent_failed_\"+c,\"failed\",JSON.stringify(f))):(a.removeEventListener(\"saveContent_\"+c),a.saveContentIDMap[c]=!0,b.saveContent(c,e,d)))};a.cancelSaveContent=function(a){b.cancelSaveContent(a)};a.asyncPing=function(c){\"string\"!=typeof c?a.broadcastEvent(\"error\",\"URL is required.\",\"asyncPing\"):b.asyncPing(c)};a.disableCloseRegion=b.disableCloseRegion;a.getSdkVersion=b.getSdkVersion;a.log=function(c){\"undefined\"==typeof c?a.broadcastEvent(\"error\",\"message is required.\",\n\"log\"):\"string\"==typeof c?b.log(c):b.log(JSON.stringify(c))};a.getInMobiAIVersion=function(){return\"2.0\"};a.getVendorName=function(){return\"inmobi\"};a.openExternal=function(a,e){console.log(\"openExternal is deprecated, will be removed in future version\");mraidview.detectAndBlockFraud(\"imraid.openExternal\")||b.openExternal(a,e)};a.updateToPassbook=function(c){mraidview.detectAndBlockFraud(\"imraid.updateToPassbook\")||(\"string\"!=typeof c?a.broadcastEvent(\"error\",\"Request must specify a valid URL\",\"updateToPassbook\"):\nb.updateToPassbook(c))};a.postToSocial=function(a,e,d,k){mraidview.detectAndBlockFraud(\"imraid.postToSocial\")||b.postToSocial(a,e,d,k)};a.getPlatform=b.getPlatform;a.incentCompleted=b.incentCompleted;a.loadSKStore=b.loadSKStore;a.showSKStore=function(a,e,d,k,h,f,g,l){mraidview.detectAndBlockFraud(\"imraid.showSKStore\")||b.showSKStore(a,e,d,k,h,f,g,l)};a.supports=function(a){return b.supports(a)};a.isDeviceMuted=function(){return!imIsObjValid(a.listeners.deviceMuted)?-1:b.isDeviceMuted()};a.isHeadPhonesPlugged=\nfunction(){return!imIsObjValid(a.listeners.headphones)?!1:b.isHeadPhonesPlugged()};a.getDeviceVolume=function(){return b.getDeviceVolume()};a.setDeviceVolume=function(a){b.setDeviceVolume(a)};a.hideStatusBar=function(){b.hideStatusBar()};a.setOpaqueBackground=function(){b.setOpaqueBackground()};a.getRenderableAdIndexes=b.getRenderableAdIndexes;a.getCurrentRenderingIndex=b.getCurrentRenderingIndex;a.showAd=b.showAd;a.timeSinceShow=b.timeSinceShow;a.closeAll=b.closeAll;a.loadAd=b.loadAd;a.setAdContext=\nb.setAdContext;a.getAdContext=b.getAdContext;a.getShowTimeStamp=b.getShowTimeStamp;a.disableBackButton=b.disableBackButton;a.isBackButtonDisabled=b.isBackButtonDisabled;a.startDownloader=b.startDownloader;a.getDownloadProgress=b.getDownloadProgress;a.getDownloadStatus=b.getDownloadStatus;a.fireEvent=b.fireEvent;a.saveBlob=b.saveBlob;a.getBlob=b.getBlob;a.setCloseEndCardTracker=b.setCloseEndCardTracker;a.openWithoutTracker=b.openWithoutTracker;a.impressionRendered=b.impressionRendered;a.onGestureDetected=\nb.onGestureDetected;a.onUserLandingCompleted=b.onUserLandingCompleted})();\n(function(){var a=window._im_imaiview={ios:{}};window.imaiview=a;a.broadcastEvent=function(){for(var a=Array(arguments.length),c=0;c<arguments.length;c++)a[c]=arguments[c];c=a.shift();try{window.mraid.broadcastEvent(c,a)}catch(e){}};a.getPlatform=function(){return\"android\"};a.getPlatformVersion=function(){return sdkController.getPlatformVersion(\"window.imaiview\")};a.log=function(a){sdkController.log(\"window.imaiview\",a)};a.openEmbedded=function(a){sdkController.openEmbedded(\"window.imaiview\",a)};\na.openExternal=function(a,c){600<=getSdkVersionInt()?sdkController.openExternal(\"window.imaiview\",a,c):sdkController.openExternal(\"window.imaiview\",a)};a.ping=function(a,c){sdkController.ping(\"window.imaiview\",a,c)};a.pingInWebView=function(a,c){sdkController.pingInWebView(\"window.imaiview\",a,c)};a.getSdkVersion=function(){try{var a=sdkController.getSdkVersion(\"window.imaiview\");if(\"string\"==typeof a&&null!=a)return a}catch(c){return\"3.7.0\"}};a.onUserInteraction=function(a){if(\"object\"!=typeof a||\nnull==a)sdkController.onUserInteraction(\"window.imaiview\",null);else try{sdkController.onUserInteraction(\"window.imaiview\",JSON.stringify(a))}catch(c){sdkController.onUserInteraction(\"window.imaiview\",null)}};a.fireAdReady=function(){sdkController.fireAdReady(\"window.imaiview\")};a.fireAdFailed=function(){sdkController.fireAdFailed(\"window.imaiview\")};a.broadcastEvent=function(){window.imai.broadcastEvent.apply(window.imai,arguments)}})();\n(function(){var a=window._im_imaiview;window._im_imai=new InmobiObj;window._im_imai.ios=new InmobiObj;var b=window._im_imai;window.imai=window._im_imai;b.matchString=function(a,b){if(\"string\"!=typeof a||null==a||null==b)return-1;var d=-1;try{d=a.indexOf(b)}catch(k){}return d};b.isHttpUrl=function(a){return\"string\"!=typeof a||null==a?!1:0==b.matchString(a,\"http://\")?!0:0==b.matchString(a,\"https://\")?!0:!1};b.appendTapParams=function(a,e,d){if(!imIsObjValid(e)||!imIsObjValid(d))return a;b.isHttpUrl(a)&&\n(a=-1==b.matchString(a,\"?\")?a+(\"?u-tap-o=\"+e+\",\"+d):a+(\"&u-tap-o=\"+e+\",\"+d));return a};b.performAdClick=function(a,e){e=e||event;if(imIsObjValid(a)){var d=a.clickConfig,k=a.landingConfig;if(!imIsObjValid(d)&&!imIsObjValid(k))b.log(\"click/landing config are invalid, Nothing to process .\"),this.broadcastEvent(\"error\",\"click/landing config are invalid, Nothing to process .\");else{var h=null,f=null,g=null,l=null,n=null,m=null,q=null,p=null;if(imIsObjValid(e))try{l=e.changedTouches[0].pageX,n=e.changedTouches[0].pageY}catch(r){n=\nl=0}imIsObjValid(k)?imIsObjValid(d)?(m=k.url,q=k.fallbackUrl,p=k.urlType,h=d.url,f=d.pingWV,g=d.fr):(m=k.url,p=k.urlType):(m=d.url,p=d.urlType);d=b.getPlatform();try{if(\"boolean\"!=typeof g&&\"number\"!=typeof g||null==g)g=!0;if(0>g||1<g)g=!0;if(\"boolean\"!=typeof f&&\"number\"!=typeof f||null==f)f=!0;if(0>f||1<f)f=!0;if(\"number\"!=typeof p||null==p)p=0;h=b.appendTapParams(h,l,n);imIsObjValid(h)?!0==f?b.pingInWebView(h,g):b.ping(h,g):b.log(\"clickurl provided is null.\");if(imIsObjValid(m))switch(imIsObjValid(h)||\n(m=b.appendTapParams(m,l,n)),p){case 1:b.openEmbedded(m);break;case 2:\"ios\"==d?b.ios.openItunesProductView(m):this.broadcastEvent(\"error\",\"Cannot process openItunesProductView for os\"+d);break;default:b.openExternal(m,q)}else b.log(\"Landing url provided is null.\")}catch(s){}}}else b.log(\" invalid config, nothing to process .\"),this.broadcastEvent(\"error\",\"invalid config, nothing to process .\")};b.performActionClick=function(a,e){e=e||event;if(imIsObjValid(a)){var d=a.clickConfig,k=a.landingConfig;\nif(!imIsObjValid(d)&&!imIsObjValid(k))b.log(\"click/landing config are invalid, Nothing to process .\"),this.broadcastEvent(\"error\",\"click/landing config are invalid, Nothing to process .\");else{var h=null,f=null,g=null,l=null,n=null;if(imIsObjValid(e))try{l=e.changedTouches[0].pageX,n=e.changedTouches[0].pageY}catch(m){n=l=0}imIsObjValid(d)&&(h=d.url,f=d.pingWV,g=d.fr);try{if(\"boolean\"!=typeof g&&\"number\"!=typeof g||null==g)g=!0;if(0>g||1<g)g=!0;if(\"boolean\"!=typeof f&&\"number\"!=typeof f||null==f)f=\n!0;if(0>f||1<f)f=!0;h=b.appendTapParams(h,l,n);imIsObjValid(h)?!0==f?b.pingInWebView(h,g):b.ping(h,g):b.log(\"clickurl provided is null.\");b.onUserInteraction(k)}catch(q){}}}else b.log(\" invalid config, nothing to process .\"),this.broadcastEvent(\"error\",\"invalid config, nothing to process .\")};b.getVersion=function(){return\"1.0\"};b.getPlatform=a.getPlatform;b.getPlatformVersion=a.getPlatformVersion;b.log=a.log;b.openEmbedded=function(b){console.log(\"openEmbedded is deprecated, will be removed in future version\");\nmraidview.detectAndBlockFraud(\"imai.openEmbedded\")||a.openEmbedded(b)};b.openExternal=function(b,e){console.log(\"openExternal is deprecated, will be removed in future version\");mraidview.detectAndBlockFraud(\"imai.openExternal\")||a.openExternal(b,e)};b.ping=a.ping;b.pingInWebView=a.pingInWebView;b.onUserInteraction=a.onUserInteraction;b.getSdkVersion=a.getSdkVersion;b.loadSKStore=a.loadSKStore;b.showSKStore=function(b){mraidview.detectAndBlockFraud(\"imai.showSKStore\")||a.showSKStore(b)};b.ios.openItunesProductView=\nfunction(b){mraidview.detectAndBlockFraud(\"imai.ios.openItunesProductView\")||a.ios.openItunesProductView(b)};b.fireAdReady=a.fireAdReady;b.fireAdFailed=a.fireAdFailed})();";
        }
        return b;
    }
    
    public final void a() {
        this.Q = false;
        try {
            this.getClass().getMethod("setLayerType", Integer.TYPE, Paint.class).invoke(this, 1, null);
        }
        catch (NoSuchMethodException ex) {}
        catch (IllegalArgumentException ex2) {}
        catch (IllegalAccessException ex3) {}
        catch (InvocationTargetException ex4) {}
    }
    
    @TargetApi(16)
    public final boolean f(final String s) {
        switch (s) {
            case "redirectFraudDetection": {
                return false;
            }
            case "playVideo":
            case "saveContent": {
                return true;
            }
            case "inlineVideo":
            case "html5video": {
                return this.H && this.Q;
            }
            default: {
                return false;
            }
        }
    }
    
    public final boolean k() {
        final fe.i renderingConfig;
        if ((renderingConfig = this.getRenderingConfig()) == null) {
            return false;
        }
        final boolean b = this.ac != -1L && SystemClock.elapsedRealtime() - this.ac < renderingConfig.userTouchResetTime * 1000L;
        return !renderingConfig.autoRedirectionEnforcement || this.ab || b;
    }
    
    public final void a(final String s, final String str, final String str2) {
        this.a(s, str + "(" + str2 + ");");
    }
    
    public final void setCloseEndCardTracker(final String s) {
        final h referenceContainer;
        final ey ey;
        final bw bw;
        if ((referenceContainer = this.getReferenceContainer()) instanceof m && (ey = (ey)((m)referenceContainer).getVideoContainerView()) != null && (bw = (bw)ey.getVideoView().getTag()) != null && bw.b() != null && bw.b().f() != null) {
            bw.b().f().a(new bv(s, 0, "closeEndCard", null));
        }
    }
    
    public final void l() {
        if (!this.r.get()) {
            new Handler(Looper.getMainLooper()).post((Runnable)new Runnable() {
                @Override
                public final void run() {
                    com.inmobi.media.o.this.getListener().f();
                }
            });
        }
    }
    
    public final void m() {
        if (!this.r.get()) {
            new Handler(Looper.getMainLooper()).post((Runnable)new Runnable() {
                @Override
                public final void run() {
                    com.inmobi.media.o.this.getListener().g();
                }
            });
        }
    }
    
    @WorkerThread
    public final int getCurrentRenderingPodAdIndex() {
        if (this.x != null) {
            return this.x.a(this);
        }
        return 0;
    }
    
    @WorkerThread
    @NonNull
    public final JSONArray getRenderableAdIndexes() {
        if (this.x != null) {
            return this.x.c();
        }
        return new JSONArray();
    }
    
    @WorkerThread
    public final long getShowTimeStamp() {
        if (this.x != null) {
            return this.x.d();
        }
        return 0L;
    }
    
    public final void d(final boolean b) {
        this.getCurrentRenderingPodAdIndex();
        this.e("window.imraidview.broadcastEvent('adShowSuccess'," + b + ");");
    }
    
    public final void setLandingScheme(final String aw) {
        this.aw = aw;
    }
    
    public final void n() {
        this.e("window.mraidview.onUserInteraction();");
        this.getListener().h(this);
    }
    
    public final String getLandingScheme() {
        return this.aw;
    }
    
    public final k getLandingPageHandler() {
        return this.au;
    }
    
    public final void c(@Nullable String string, @Nullable final String s, @Nullable final String str) {
        this.e("window.imraid.broadcastEvent('onUserLandingCompleted');");
        if (s == null) {
            return;
        }
        string = "broadcastEvent('" + string + "Successful','" + str + "');";
        this.a(s, string);
    }
    
    static /* synthetic */ void a(final o o, final String s) {
        o.loadUrl(s);
    }
    
    static /* synthetic */ void b(final o o, final String s) {
        o.evaluateJavascript(s, (ValueCallback)null);
    }
    
    static /* synthetic */ boolean a(final o o, final JsResult jsResult) {
        final fe.i renderingConfig;
        if ((renderingConfig = o.getRenderingConfig()) != null && renderingConfig.shouldRenderPopup) {
            return true;
        }
        jsResult.cancel();
        o.e("window.mraidview.popupBlocked('popupBlocked')");
        return false;
    }
    
    static {
        a = new q() {
            @Override
            public final it c_() {
                return it.a();
            }
        };
        B = o.class.getSimpleName();
        ay = new dl.a() {
            private long a;
            
            @Override
            public final boolean a(@NonNull final View view) {
                if (!(view instanceof o)) {
                    return false;
                }
                final o o = (o)view;
                final Rect rect = new Rect();
                if (!o.getGlobalVisibleRect(rect)) {
                    return false;
                }
                if (rect.intersect(o.getAdFrameRect())) {
                    final o o2;
                    final Bitmap bitmap = Bitmap.createBitmap((o2 = o).getWidth(), o2.getHeight(), Bitmap.Config.ARGB_8888);
                    final Canvas canvas = new Canvas(bitmap);
                    canvas.drawBitmap(bitmap, 0.0f, 0.0f, new Paint());
                    o2.draw(canvas);
                    final Bitmap bitmap2;
                    final int[] array = new int[(bitmap2 = Bitmap.createBitmap(Bitmap.createScaledBitmap(bitmap, ho.b(o2.getWidth()), ho.b(o2.getHeight()), (boolean)(1 != 0)), o2.an[0], o2.an[1], o2.an[2], o2.an[3])).getWidth() * bitmap2.getHeight()];
                    bitmap2.getPixels(array, 0, bitmap2.getWidth(), 0, 0, bitmap2.getWidth(), bitmap2.getHeight());
                    int n = 0;
                    for (int length = array.length, i = 0; i < length; ++i) {
                        final int n2;
                        if ((n2 = array[i]) > -16777216 && n2 < 0 && ++n >= o.ap) {
                            return true;
                        }
                    }
                }
                return false;
            }
            
            @Override
            public final boolean a(@Nullable final View view, @Nullable final View view2, final int n, final Object o) {
                if (view2 == null || view2.getVisibility() != 0 || view == null || view.getParent() == null || !view2.isShown()) {
                    return false;
                }
                o o2 = null;
                if (view2 instanceof o) {
                    o2 = (o)view2;
                }
                if (o2 == null) {
                    return false;
                }
                if (o2.getPlacementType() != 1 && (o2.getHeight() <= 0 || o2.getWidth() <= 0)) {
                    return false;
                }
                final Rect rect = new Rect();
                if (!o2.getGlobalVisibleRect(rect)) {
                    return false;
                }
                this.a = rect.height() * (long)rect.width();
                if (o2.getPlacementType() == 1) {
                    final o o3 = o2;
                    o3.ao = o3.getWidth() * o2.getHeight();
                }
                return o2.ao > 0L && 100L * this.a >= n * o2.ao;
            }
            
            @Override
            public final boolean a(@NonNull final View view, @NonNull final View view2, final int n) {
                final ViewGroup viewGroup;
                final boolean b = (viewGroup = ((view.getParent() instanceof ViewGroup) ? view.getParent() : null)) == null || this.a((View)viewGroup, view2, n);
                if (viewGroup != null) {
                    for (int i = viewGroup.indexOfChild(view) + 1; i < viewGroup.getChildCount(); ++i) {
                        final View child = viewGroup.getChildAt(i);
                        if (0 == child.getVisibility()) {
                            final View view3 = child;
                            boolean b2;
                            if (!(view2 instanceof o)) {
                                b2 = true;
                            }
                            else {
                                final Rect rect = new Rect();
                                final Rect rect2 = new Rect();
                                view2.getGlobalVisibleRect(rect);
                                view3.getGlobalVisibleRect(rect2);
                                final boolean intersect = rect2.intersect(rect);
                                final int n2 = rect2.width() * rect2.height();
                                b2 = (intersect && Math.abs(n2 * 100 - this.a * 100L) < ((o)view2).ao * n);
                            }
                            if (b2) {
                                com.inmobi.media.o.B;
                                return false;
                            }
                        }
                    }
                }
                return b;
            }
        };
    }
}

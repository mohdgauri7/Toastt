// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.view.MotionEvent;
import java.lang.reflect.Method;
import java.util.LinkedList;
import android.text.TextUtils;
import android.os.Handler;
import java.lang.reflect.InvocationHandler;
import com.squareup.picasso.Callback;
import android.graphics.Point;
import android.widget.FrameLayout;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.annotation.TargetApi;
import android.graphics.drawable.GradientDrawable;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.Canvas;
import android.os.Build;
import java.util.Iterator;
import java.util.Stack;
import android.view.ViewGroup;
import android.annotation.SuppressLint;
import java.util.Set;
import android.widget.Button;
import android.widget.TextView;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.view.View;
import java.util.HashMap;
import com.inmobi.ads.rendering.InMobiAdActivity;
import android.content.Context;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import androidx.annotation.NonNull;
import java.util.Map;

public class ez
{
    private static final String a;
    private int b;
    @NonNull
    private static final Map<Class, Byte> c;
    @NonNull
    private Map<Byte, d> d;
    @Nullable
    private static volatile WeakReference<ez> e;
    private static WeakReference<Context> f;
    private static int g;
    private static int h;
    
    static void a(final int g) {
        ez.g = g;
    }
    
    static void b(final int h) {
        ez.h = h;
    }
    
    static int c(final int n) {
        final Context context;
        if ((context = ez.f.get()) != null && context instanceof InMobiAdActivity) {
            return n;
        }
        if (ez.g == 0) {
            return n;
        }
        return (int)(n * (ez.g * 1.0 / ez.h));
    }
    
    @SuppressLint({ "UseSparseArrays" })
    private ez(final Context referent) {
        ez.f = new WeakReference<Context>(referent);
        (this.d = new HashMap<Byte, d>()).put((Byte)0, new d() {
            @Override
            protected final View a(@NonNull final Context context) {
                return (View)new es(context.getApplicationContext());
            }
            
            @Override
            protected final void a(@NonNull final View view, @NonNull final bj bj, @NonNull final fe fe) {
                super.a(view, bj, fe);
                ez.a(view, bj.c);
            }
        });
        this.d.put((Byte)3, new d() {
            @Override
            protected final View a(@NonNull final Context context) {
                return (View)new en(context.getApplicationContext());
            }
            
            @Override
            protected final void a(@NonNull final View view, @NonNull final bj bj, @NonNull final fe fe) {
                super.a(view, bj, fe);
                ez.a(view, bj.c);
            }
        });
        this.d.put((Byte)1, new d() {
            @Override
            protected final View a(@NonNull final Context context) {
                return (View)new fc(context.getApplicationContext());
            }
            
            @Override
            protected final void a(@NonNull final View view, @NonNull final bj bj, @NonNull final fe fe) {
                super.a(view, bj, fe);
                ez.a(view, bj.c);
            }
            
            @Override
            public final boolean a(@NonNull final View view) {
                ((fc)view).a = null;
                return super.a(view);
            }
        });
        this.d.put((Byte)2, new d() {
            @Override
            protected final View a(@NonNull final Context context) {
                return (View)new fb(context.getApplicationContext());
            }
            
            @Override
            protected final void a(@NonNull final View view, @NonNull final bj bj, @NonNull final fe fe) {
                super.a(view, bj, fe);
                ez.a(view, bj.c);
            }
        });
        this.d.put((Byte)6, new d() {
            @Override
            protected final View a(@NonNull final Context context) {
                return (View)new ImageView(context.getApplicationContext());
            }
            
            @Override
            protected final void a(@NonNull final View view, @NonNull final bj bj, @NonNull final fe fe) {
                super.a(view, bj, fe);
                ez.a((ImageView)view, bj);
            }
            
            @Override
            public final boolean a(@NonNull final View view) {
                if (!(view instanceof ImageView)) {
                    return false;
                }
                ((ImageView)view).setImageDrawable((Drawable)null);
                return super.a(view);
            }
        });
        this.d.put((Byte)10, new d() {
            @Override
            protected final View a(@NonNull final Context context) {
                return (View)new el(context.getApplicationContext());
            }
            
            @Override
            protected final void a(@NonNull final View view, @NonNull final bj bj, @NonNull final fe fe) {
                super.a(view, bj, fe);
                ez.a((el)view, bj);
            }
            
            @Override
            public final boolean a(@NonNull final View view) {
                if (!(view instanceof el)) {
                    return false;
                }
                ((el)view).setGifImpl(null);
                return super.a(view);
            }
        });
        this.d.put((Byte)7, new d() {
            @Override
            protected final View a(@NonNull final Context context) {
                return (View)new ey(context.getApplicationContext());
            }
            
            @Override
            protected final void a(@NonNull final View view, @NonNull final bj bj, @NonNull final fe fe) {
                super.a(view, bj, fe);
                ez.a((ey)view, bj);
            }
            
            @Override
            public final boolean a(@NonNull final View view) {
                if (!(view instanceof ey)) {
                    return false;
                }
                ((ey)view).getProgressBar().setVisibility(8);
                ((ey)view).getPoster().setImageBitmap((Bitmap)null);
                ((ey)view).getVideoView().e();
                return super.a(view);
            }
        });
        this.d.put((Byte)4, new d() {
            @Override
            protected final View a(@NonNull final Context context) {
                return (View)new b(context.getApplicationContext());
            }
            
            @Override
            protected final void a(@NonNull final View view, @NonNull final bj bj, @NonNull final fe fe) {
                super.a(view, bj, fe);
                ez.a((TextView)view, bj);
            }
            
            @Override
            public final boolean a(@NonNull final View view) {
                if (!(view instanceof TextView)) {
                    return false;
                }
                ez.a((TextView)view);
                return super.a(view);
            }
        });
        this.d.put((Byte)5, new d() {
            @Override
            protected final View a(@NonNull final Context context) {
                return (View)new Button(context.getApplicationContext());
            }
            
            @Override
            protected final void a(@NonNull final View view, @NonNull final bj bj, @NonNull final fe fe) {
                super.a(view, bj, fe);
                ez.a((Button)view, bj);
            }
            
            @Override
            public final boolean a(@NonNull final View view) {
                if (!(view instanceof Button)) {
                    return false;
                }
                ez.a((TextView)view);
                return super.a(view);
            }
        });
        this.d.put((Byte)8, new d() {
            @Override
            protected final View a(@NonNull final Context context) {
                return new bu(context.getApplicationContext());
            }
            
            @Override
            protected final void a(@NonNull final View view, @NonNull final bj bj, @NonNull final fe fe) {
                super.a(view, bj, fe);
                ez.a(ez.this, (bu)view, bj);
            }
            
            @Override
            public final boolean a(@NonNull final View view) {
                return view instanceof bu && super.a(view);
            }
        });
        this.d.put((Byte)9, new d() {
            @Override
            protected final View a(@NonNull final Context context) {
                Object o = null;
                try {
                    ((o)(o = new o(context.getApplicationContext(), (byte)0, null, null))).setShouldFireRenderBeacon(false);
                }
                catch (Exception ex) {
                    ez.a;
                    fv.a().a(new gv(ex));
                }
                return (View)o;
            }
            
            @Override
            protected final void a(@NonNull final View view, @NonNull final bj bj, @NonNull final fe fe) {
                super.a(view, bj, fe);
                ez.a((o)view, bj, fe);
            }
            
            @Override
            public final boolean a(@NonNull final View view) {
                return view instanceof o && !((o)view).w && super.a(view);
            }
        });
    }
    
    public static ez a(final Context context) {
        ez referent;
        if ((referent = ((ez.e == null) ? null : ez.e.get())) == null) {
            synchronized (ez.class) {
                if ((referent = ((ez.e == null) ? null : ez.e.get())) == null) {
                    referent = new ez(context);
                    ez.e = new WeakReference<ez>(referent);
                }
            }
        }
        return referent;
    }
    
    @Nullable
    public final View a(@NonNull final Context context, @NonNull final bj bj, @NonNull final fe fe) {
        final byte a = a(bj);
        if (-1 == a) {
            return null;
        }
        final d d;
        if ((d = this.d.get(a)) == null) {
            return null;
        }
        return d.a(context, bj, fe);
    }
    
    public final void a(@NonNull final ViewGroup viewGroup) {
        for (int i = viewGroup.getChildCount() - 1; i >= 0; --i) {
            final View child = viewGroup.getChildAt(i);
            viewGroup.removeViewAt(i);
            this.a(child);
        }
    }
    
    public final void a(@NonNull final View view) {
        if (view instanceof es || view instanceof en) {
            final en item = (en)view;
            if (0 != item.getChildCount()) {
                final Stack<en> stack;
                (stack = new Stack<en>()).push(item);
                while (!stack.isEmpty()) {
                    en en;
                    for (int i = (en = stack.pop()).getChildCount() - 1; i >= 0; --i) {
                        final View child = en.getChildAt(i);
                        en.removeViewAt(i);
                        if (child instanceof en) {
                            stack.push((en)child);
                        }
                        else {
                            this.c(child);
                        }
                    }
                    this.c((View)en);
                }
                return;
            }
        }
        this.c(view);
    }
    
    private static byte a(final bj bj) {
        if (bj instanceof bl) {
            final bl bl;
            if ((bl = (bl)bj).a()) {
                return 0;
            }
            if (!bl.b()) {
                return 3;
            }
            switch (bl.A) {
                default: {
                    return 1;
                }
                case 1: {
                    return 2;
                }
            }
        }
        else {
            final String b = bj.b;
            switch (b) {
                case "TEXT": {
                    return 4;
                }
                case "IMAGE":
                case "ICON": {
                    return 6;
                }
                case "VIDEO": {
                    return 7;
                }
                case "CTA": {
                    return 5;
                }
                case "TIMER": {
                    return 8;
                }
                case "WEBVIEW": {
                    return 9;
                }
                case "GIF": {
                    return 10;
                }
                default: {
                    return -1;
                }
            }
        }
    }
    
    private void c(@NonNull final View view) {
        final byte byteValue = ez.c.get(view.getClass());
        if (-1 == byteValue) {
            return;
        }
        final d d;
        if ((d = this.d.get((int)byteValue)) == null) {
            return;
        }
        if (this.b >= 300) {
            this.c();
        }
        d.a(view);
    }
    
    private void c() {
        final d d;
        if ((d = this.d()) != null) {
            d.a();
        }
    }
    
    @Nullable
    private d d() {
        int size = 0;
        d d = null;
        final Iterator<Map.Entry<Byte, d>> iterator = this.d.entrySet().iterator();
        while (iterator.hasNext()) {
            final Map.Entry<Byte, d> entry;
            if ((entry = iterator.next()).getValue().b.size() > size) {
                size = (d = entry.getValue()).b.size();
            }
        }
        return d;
    }
    
    private static void b(final Context context, final ImageView imageView) {
        if (imageView.getDrawable() == null) {
            final float c = ho.a().c;
            final cf cf = new cf(context, c, (byte)0);
            final float n = c;
            final cf cf2 = cf;
            Bitmap drawingCache;
            if (Build.VERSION.SDK_INT < 28) {
                cf2.layout(0, 0, (int)(c(40) * n), (int)(c(40) * n));
                cf2.setDrawingCacheEnabled(true);
                cf2.buildDrawingCache();
                drawingCache = cf2.getDrawingCache();
            }
            else {
                cf2.layout(0, 0, (int)(c(40) * n), (int)(c(40) * n));
                final Bitmap bitmap = Bitmap.createBitmap((int)(c(40) * n), (int)(c(40) * n), Bitmap.Config.ARGB_8888);
                cf2.draw(new Canvas(bitmap));
                drawingCache = bitmap;
            }
            imageView.setImageBitmap(drawingCache);
        }
    }
    
    private static void a(@NonNull final TextView textView, final String[] array) {
        int n = 0;
        int paintFlags = textView.getPaintFlags();
        for (final String s : array) {
            switch (s) {
                case "bold": {
                    n |= 0x1;
                    break;
                }
                case "italic": {
                    n |= 0x2;
                    break;
                }
                case "strike": {
                    paintFlags |= 0x10;
                    break;
                }
                case "underline": {
                    paintFlags |= 0x8;
                    break;
                }
            }
        }
        textView.setTypeface(Typeface.DEFAULT, n);
        textView.setPaintFlags(paintFlags);
    }
    
    @TargetApi(21)
    static void a(final View view, @NonNull final bk bk) {
        int n = Color.parseColor("#00000000");
        try {
            n = Color.parseColor(bk.e());
        }
        catch (IllegalArgumentException ex) {
            fv.a().a(new gv(ex));
        }
        view.setBackgroundColor(n);
        if ("line".equals(bk.a())) {
            final GradientDrawable gradientDrawable;
            (gradientDrawable = new GradientDrawable()).setColor(n);
            if ("curved".equals(bk.b())) {
                gradientDrawable.setCornerRadius(bk.c());
            }
            int n2 = Color.parseColor("#ff000000");
            try {
                n2 = Color.parseColor(bk.d());
            }
            catch (IllegalArgumentException ex2) {
                fv.a().a(new gv(ex2));
            }
            gradientDrawable.setStroke(1, n2);
            if (Build.VERSION.SDK_INT < 16) {
                view.setBackgroundDrawable((Drawable)gradientDrawable);
                return;
            }
            view.setBackground((Drawable)gradientDrawable);
        }
    }
    
    public static ViewGroup.LayoutParams a(@NonNull final bj bj, @NonNull final ViewGroup viewGroup) {
        final Point a = bj.c.a;
        final Point c = bj.c.c;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(c(a.x), c(a.y));
        if (viewGroup instanceof en) {
            final en.a a2 = (en.a)(layoutParams = new en.a(c(a.x), c(a.y)));
            final int c2 = c(c.x);
            final int c3 = c(c.y);
            final int a3 = c2;
            final en.a a4 = a2;
            a2.a = a3;
            a4.b = c3;
        }
        else if (viewGroup instanceof LinearLayout) {
            ((LinearLayout.LayoutParams)(layoutParams = (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(c(a.x), c(a.y)))).setMargins(c(c.x), c(c.y), 0, 0);
        }
        else {
            if (viewGroup instanceof AbsListView) {
                return (ViewGroup.LayoutParams)new AbsListView.LayoutParams(c(a.x), c(a.y));
            }
            if (viewGroup instanceof FrameLayout) {
                ((FrameLayout.LayoutParams)(layoutParams = (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(c(a.x), c(a.y)))).setMargins(c(c.x), c(c.y), 0, 0);
            }
        }
        return layoutParams;
    }
    
    static /* synthetic */ void b(final View view) {
        if (Build.VERSION.SDK_INT < 16) {
            view.setBackgroundDrawable((Drawable)null);
            return;
        }
        view.setBackground((Drawable)null);
    }
    
    static /* synthetic */ void a(final ImageView imageView, final bj bj) {
        final String s;
        if ((s = (String)bj.e) != null) {
            final int c = c(bj.c.a.x);
            final int c2 = c(bj.c.a.y);
            final String f = bj.c.f();
            switch (f) {
                case "aspectFit": {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    break;
                }
                case "aspectFill": {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    break;
                }
                default: {
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    break;
                }
            }
            final Context context;
            if ((context = ez.f.get()) != null && c > 0 && c2 > 0 && s.trim().length() != 0) {
                cs.a(context).load(s).into(imageView, (Callback)cs.a(new c(context, imageView, bj)));
                if ("cross_button".equalsIgnoreCase(bj.d) && 0 == bj.r.length()) {
                    new Handler().postDelayed((Runnable)new a(context, imageView), 2000L);
                }
            }
            final bj t = bj.t;
            int n5;
            int n4;
            int n3;
            int n2 = n3 = (n4 = (n5 = 0));
            if (t != null && "line".equals(t.c.a())) {
                if (t.c.c.x == bj.c.c.x) {
                    n3 = 1;
                }
                if (c(t.c.a.x) == c(bj.c.a.x) + bj.c.c.x) {
                    n4 = 1;
                }
                if (c(t.c.c.y) == c(bj.c.c.y)) {
                    n2 = 1;
                }
                if (c(t.c.a.y) == c(bj.c.a.y) + c(bj.c.c.y)) {
                    n5 = 1;
                }
                if (c(t.c.a.x) == c(bj.c.a.x)) {
                    n4 = (n3 = 1);
                }
            }
            if (Build.VERSION.SDK_INT < 17) {
                ((View)imageView).setPadding(n3, n2, n4, n5);
            }
            else {
                ((View)imageView).setPaddingRelative(n3, n2, n4, n5);
            }
            a((View)imageView, bj.c);
        }
    }
    
    static /* synthetic */ void a(final el el, final bj bj) {
        el.setLayoutParams(new ViewGroup.LayoutParams(c(bj.c.a.x), c(bj.c.a.y)));
        el.setContentMode(bj.c.f());
        el.setGifImpl(((bo)bj).z);
        a((View)el, bj.c);
    }
    
    static /* synthetic */ void a(final ey ey, final bj bj) {
        a((View)ey, bj.c);
        if (bj.w != null) {
            ey.setPosterImage((Bitmap)bj.w);
        }
        ey.getProgressBar().setVisibility(0);
    }
    
    static /* synthetic */ void a(final TextView textView, bj textColor) {
        final br.a a = (br.a)bj.c;
        textView.setLayoutParams(new ViewGroup.LayoutParams(c(a.a.x), c(a.a.y)));
        textView.setText((CharSequence)bj.e);
        textView.setTypeface(Typeface.DEFAULT);
        switch (a.p) {
            default: {
                textView.setGravity(8388627);
                break;
            }
            case 1: {
                textView.setGravity(8388629);
                break;
            }
            case 2: {
                textView.setGravity(17);
                break;
            }
        }
        textView.setTextSize(1, (float)c(a.h()));
        textColor = (bj)Color.parseColor("#ff000000");
        try {
            textColor = (bj)Color.parseColor(a.i());
        }
        catch (IllegalArgumentException ex) {
            fv.a().a(new gv(ex));
        }
        textView.setTextColor((int)textColor);
        int backgroundColor = Color.parseColor("#00000000");
        try {
            backgroundColor = Color.parseColor(a.e());
        }
        catch (IllegalArgumentException ex2) {
            fv.a().a(new gv(ex2));
        }
        textView.setBackgroundColor(backgroundColor);
        if (Build.VERSION.SDK_INT >= 17) {
            textView.setTextAlignment(1);
        }
        a(textView, a.j());
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setHorizontallyScrolling(true);
        textView.setFocusable(true);
        textView.setFocusableInTouchMode(true);
        a((View)textView, a);
    }
    
    static /* synthetic */ void a(final TextView textView) {
        textView.setTypeface(Typeface.DEFAULT, 0);
        textView.setPaintFlags(textView.getPaintFlags() & 0xFFFFFFEF);
        textView.setPaintFlags(textView.getPaintFlags() & 0xFFFFFFF7);
    }
    
    static /* synthetic */ void a(Button textColor, bj bj) {
        final bj bj2 = bj;
        bj = (bj)bj2.c;
        button.setLayoutParams(new ViewGroup.LayoutParams(c(((bk)bj).a.x), c(((bk)bj).a.y)));
        button.setText((CharSequence)bj2.e);
        button.setTextSize(1, (float)c(((br.a)bj).h()));
        textColor = (Button)Color.parseColor("#ff000000");
        try {
            textColor = (Button)Color.parseColor(((br.a)bj).i());
        }
        catch (IllegalArgumentException ex) {
            fv.a().a(new gv(ex));
        }
        button.setTextColor((int)textColor);
        int backgroundColor = Color.parseColor("#00000000");
        try {
            backgroundColor = Color.parseColor(((br.a)bj).e());
        }
        catch (IllegalArgumentException ex2) {
            fv.a().a(new gv(ex2));
        }
        button.setBackgroundColor(backgroundColor);
        if (Build.VERSION.SDK_INT >= 17) {
            button.setTextAlignment(4);
        }
        button.setGravity(17);
        a((TextView)button, ((br.a)bj).j());
        a((View)button, (bk)bj);
    }
    
    static /* synthetic */ void a(final ez ez, final bu bu, final bj bj) {
        bu.setVisibility(4);
        final bt bt;
        final bs.a a = (bt = (bt)bj).A.a;
        final bs.a b = bt.A.b;
        try {
            long a2 = 0L;
            if (a != null) {
                a2 = a.a();
            }
            long a3 = 0L;
            if (b != null) {
                a3 = b.a();
            }
            if (a3 >= 0L) {
                bu.setTimerValue(a3);
                new Handler().postDelayed((Runnable)new Runnable() {
                    @Override
                    public final void run() {
                        if (ez.f.get() != null) {
                            if (bt.z) {
                                bu.setVisibility(0);
                            }
                            bu.a();
                        }
                    }
                }, a2 * 1000L);
            }
        }
        catch (Exception ex) {
            fv.a().a(new gv(ex));
        }
    }
    
    static /* synthetic */ void a(final o o, final bj bj, final fe fe) {
        try {
            final bx bx = (bx)bj;
            o.a(o.a, fe, false, false);
            o.i = true;
            final String s = (String)bj.e;
            final String z = bx.z;
            switch (z) {
                case "REF_HTML":
                case "HTML": {
                    o.b(s);
                }
                default: {
                    o.c(s);
                }
            }
        }
        catch (Exception ex) {
            fv.a().a(new gv(ex));
        }
    }
    
    static /* synthetic */ void a(final Context context, final ImageView imageView, final bj bj) {
        if (context != null && imageView != null) {
            final String r = bj.r;
            if ("cross_button".equalsIgnoreCase(bj.d) && 0 == r.trim().length()) {
                b(context, imageView);
            }
        }
        final HashMap<String, String> hashMap;
        (hashMap = new HashMap<String, String>()).put("[ERRORCODE]", "603");
        bj.a("error", hashMap);
    }
    
    static {
        a = ez.class.getSimpleName();
        ez.g = 1;
        ez.h = 1;
        (c = new HashMap<Class, Byte>()).put(es.class, 0);
        ez.c.put(fc.class, (Byte)1);
        ez.c.put(fb.class, (Byte)2);
        ez.c.put(en.class, (Byte)3);
        ez.c.put(ImageView.class, (Byte)6);
        ez.c.put(ey.class, (Byte)7);
        ez.c.put(b.class, (Byte)4);
        ez.c.put(Button.class, (Byte)5);
        ez.c.put(bu.class, (Byte)8);
        ez.c.put(o.class, (Byte)9);
        ez.c.put(el.class, (Byte)10);
    }
    
    abstract class d
    {
        @NonNull
        LinkedList<View> b;
        private int a;
        private int d;
        
        @Nullable
        protected abstract View a(@NonNull final Context p0);
        
        protected void a(@NonNull final View view, @NonNull final bj bj, @NonNull final fe fe) {
            view.setVisibility(bj.x);
            view.setOnClickListener((View.OnClickListener)null);
        }
        
        public d() {
            this.b = new LinkedList<View>();
            this.a = 0;
            this.d = 0;
        }
        
        public boolean a(@NonNull final View e) {
            ez.b(e);
            e.setOnClickListener((View.OnClickListener)null);
            this.b.addLast(e);
            e.setScaleX(1.0f);
            e.setScaleY(1.0f);
            ez.this.b++;
            return true;
        }
        
        public final View a(@NonNull final Context referent, final bj bj, final fe fe) {
            ez.f = (WeakReference<Context>)new WeakReference((T)referent);
            View a;
            if (this.b.isEmpty()) {
                ++this.a;
                a = this.a(referent);
            }
            else {
                ++this.d;
                a = this.b.removeFirst();
                ez.this.b--;
            }
            if (a != null) {
                this.a(a, bj, fe);
            }
            return a;
        }
        
        public final void a() {
            if (this.b.size() > 0) {
                this.b.removeFirst();
            }
        }
        
        @Override
        public String toString() {
            return "Size:" + this.b.size() + " Miss Count:" + this.a + " Hit Count:" + this.d;
        }
    }
    
    static final class c implements InvocationHandler
    {
        private WeakReference<Context> a;
        private WeakReference<ImageView> b;
        private bj c;
        
        c(final Context referent, final ImageView referent2, final bj c) {
            this.a = new WeakReference<Context>(referent);
            this.b = new WeakReference<ImageView>(referent2);
            this.c = c;
        }
        
        @Override
        public final Object invoke(final Object o, final Method method, final Object[] array) {
            ez.a;
            if (method != null && "onError".equalsIgnoreCase(method.getName())) {
                ez.a(this.a.get(), this.b.get(), this.c);
            }
            return null;
        }
    }
    
    static final class a implements Runnable
    {
        private WeakReference<Context> a;
        private WeakReference<ImageView> b;
        
        a(final Context referent, final ImageView referent2) {
            this.a = new WeakReference<Context>(referent);
            this.b = new WeakReference<ImageView>(referent2);
        }
        
        @Override
        public final void run() {
            final Context context = this.a.get();
            final ImageView imageView = this.b.get();
            if (context != null && imageView != null) {
                b(context, imageView);
            }
        }
    }
    
    @SuppressLint({ "AppCompatCustomView" })
    static final class b extends TextView
    {
        public b(final Context context) {
            super(context);
        }
        
        public final boolean onTouchEvent(final MotionEvent motionEvent) {
            return false;
        }
        
        protected final void onSizeChanged(int lines, final int n, final int n2, final int n3) {
            super.onSizeChanged(lines, n, n2, n3);
            if ((lines = ((this.getLineHeight() > 0) ? (n / this.getLineHeight()) : 0)) > 0) {
                this.setSingleLine(false);
                this.setLines(lines);
            }
            if (lines == 1) {
                this.setSingleLine();
            }
        }
    }
}

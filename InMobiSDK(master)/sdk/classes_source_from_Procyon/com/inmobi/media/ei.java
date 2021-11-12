// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.util.Iterator;
import androidx.annotation.Nullable;
import android.animation.ObjectAnimator;
import android.animation.Animator;
import android.view.ViewGroup;
import android.animation.ValueAnimator;
import java.util.LinkedList;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class ei
{
    private static final String b;
    public List<a> a;
    private boolean c;
    
    public ei() {
        this.a = new ArrayList<a>();
        this.c = false;
    }
    
    final List<a> a(final View view, final bj bj) {
        final LinkedList<a> list = new LinkedList<a>();
        try {
            final float n = (float)ez.c(bj.c.c.x);
            final float n2 = (float)ez.c(bj.c.d.x);
            if (n != n2) {
                final ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[] { (float)(int)n, (float)(int)n2 });
                ofFloat.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new ValueAnimator.AnimatorUpdateListener() {
                    final /* synthetic */ en.a a = (en.a)view.getLayoutParams();
                    
                    public final void onAnimationUpdate(final ValueAnimator valueAnimator) {
                        this.a.a = ((Float)valueAnimator.getAnimatedValue()).intValue();
                        view.setLayoutParams((ViewGroup.LayoutParams)this.a);
                        view.requestLayout();
                    }
                });
                list.add(this.a((Animator)ofFloat, bj));
            }
            final float n3 = (float)ez.c(bj.c.c.y);
            final float n4 = (float)ez.c(bj.c.d.y);
            if (n3 != n4) {
                final ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[] { (float)(int)n3, (float)(int)n4 });
                ofFloat2.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new ValueAnimator.AnimatorUpdateListener() {
                    final /* synthetic */ en.a a = (en.a)view.getLayoutParams();
                    
                    public final void onAnimationUpdate(final ValueAnimator valueAnimator) {
                        this.a.b = ((Float)valueAnimator.getAnimatedValue()).intValue();
                        view.setLayoutParams((ViewGroup.LayoutParams)this.a);
                        view.requestLayout();
                    }
                });
                list.add(this.a((Animator)ofFloat2, bj));
            }
            final float n5 = (float)ez.c(bj.c.a.x);
            final float n6 = (float)ez.c(bj.c.b.x);
            if (n5 != n6) {
                list.add(this.a(a(view, "scaleX", n5, n6), bj));
            }
            final float n7 = (float)ez.c(bj.c.a.y);
            final float n8 = (float)ez.c(bj.c.b.y);
            if (n7 != n8) {
                list.add(this.a(a(view, "scaleY", n7, n8), bj));
            }
        }
        catch (Exception ex) {}
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }
    
    private a a(final Animator animator, final bj bj) {
        b(animator, bj);
        return new a(animator);
    }
    
    private static void b(final Animator animator, final bj bj) {
        animator.setDuration(0L);
        animator.setStartDelay(0L);
        final bs g;
        if ((g = bj.c.g()) != null) {
            final bs.a a = g.a;
            final bs.a b;
            if ((b = g.b) != null) {
                animator.setDuration(b.a() * 1000L);
            }
            if (a != null) {
                animator.setStartDelay(a.a() * 1000L);
            }
        }
    }
    
    private static Animator a(final View view, final String s, float n, final float n2) {
        n = n2 / n;
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        return (Animator)ObjectAnimator.ofFloat((Object)view, s, new float[] { n });
    }
    
    public final void a() {
        if (!this.c) {
            this.c = true;
            this.a(this.a);
        }
    }
    
    public final void a(@Nullable final List<a> list) {
        if (list == null) {
            return;
        }
        final Iterator<a> iterator = list.iterator();
        while (iterator.hasNext()) {
            final a a;
            if (!(a = iterator.next()).c) {
                final ValueAnimator valueAnimator;
                (valueAnimator = (ValueAnimator)a.a).setCurrentPlayTime(a.b);
                valueAnimator.start();
            }
            if (!this.a.contains(a)) {
                this.a.add(a);
            }
        }
    }
    
    public final void b() {
        if (this.c) {
            this.c = false;
            final Iterator<a> iterator = this.a.iterator();
            while (iterator.hasNext()) {
                final a a;
                final ValueAnimator valueAnimator = (ValueAnimator)(a = iterator.next()).a;
                a.b = valueAnimator.getCurrentPlayTime();
                if (valueAnimator.getAnimatedFraction() == 1.0) {
                    a.c = true;
                }
                valueAnimator.cancel();
            }
        }
    }
    
    static {
        b = ei.class.getSimpleName();
    }
    
    public final class a
    {
        public Animator a;
        long b;
        boolean c;
        
        a(final Animator a) {
            this.a = a;
        }
    }
}

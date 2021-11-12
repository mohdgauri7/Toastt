// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.graphics.Canvas;
import android.content.Context;
import android.graphics.RectF;
import android.graphics.Path;
import android.graphics.Paint;
import android.view.View;

public class cf extends View
{
    private static final String a;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private byte g;
    private int h;
    private Paint i;
    private Path j;
    private RectF k;
    
    private cf(final Context context) {
        super(context);
    }
    
    public cf(final Context context, final float b, final byte g) {
        this(context);
        this.g = g;
        this.b = b;
        this.h = 15;
        this.i = new Paint(1);
        this.k = new RectF();
        this.j = new Path();
    }
    
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        this.i.reset();
        switch (this.g) {
            case 12: {
                this.e = 50.0f * this.b / 2.0f;
                this.c = 3.0f * this.b;
                this.d = 3.0f * this.b;
                this.i.setStyle(Paint.Style.STROKE);
                this.i.setStrokeWidth(4.0f);
                this.i.setColor(-1);
                this.j.moveTo(this.e - this.c, this.e - this.d - 5.0f * this.b);
                this.j.lineTo(this.e - this.c, this.e - this.d);
                this.j.lineTo(this.e - this.c - 5.0f * this.b, this.e - this.d);
                this.j.moveTo(this.e + this.c, this.e - this.d - 5.0f * this.b);
                this.j.lineTo(this.e + this.c, this.e - this.d);
                this.j.lineTo(this.e + this.c + 5.0f * this.b, this.e - this.d);
                this.j.moveTo(this.e - this.c, this.e + this.d + 5.0f * this.b);
                this.j.lineTo(this.e - this.c, this.e + this.d);
                this.j.lineTo(this.e - this.c - 5.0f * this.b, this.e + this.d);
                this.j.moveTo(this.e + this.c, this.e + this.d + 5.0f * this.b);
                this.j.lineTo(this.e + this.c, this.e + this.d);
                this.j.lineTo(this.e + this.c + 5.0f * this.b, this.e + this.d);
                canvas.drawPath(this.j, this.i);
            }
            case 11: {
                this.a(canvas);
                this.i.setColor(-1);
                this.i.setStrokeWidth(4.0f);
                this.i.setStyle(Paint.Style.STROKE);
                this.j.moveTo(this.e + 10.0f * this.b, this.e - this.d);
                this.j.lineTo(this.e + 18.0f * this.b, this.e + this.d);
                this.j.moveTo(this.e + 18.0f * this.b, this.e - this.d);
                this.j.lineTo(this.e + 10.0f * this.b, this.e + this.d);
                canvas.drawPath(this.j, this.i);
            }
            case 9: {
                this.a(canvas);
                final RectF rectF = new RectF(this.e - 10.0f * this.b, this.e - this.d - 2.0f * this.b, this.e + 14.0f * this.b, this.e + this.d + 2.0f * this.b);
                final RectF rectF2 = new RectF(this.e - 10.0f * this.b, this.e - this.d - 4.0f * this.b, this.e + 18.0f * this.b, this.e + this.d + 4.0f * this.b);
                this.i.setColor(-1);
                this.i.setStrokeWidth(4.0f);
                this.i.setStyle(Paint.Style.STROKE);
                canvas.drawArc(rectF, -45.0f, 90.0f, false, this.i);
                canvas.drawArc(rectF2, -45.0f, 90.0f, false, this.i);
                canvas.drawPath(this.j, this.i);
                canvas.drawPath(this.j, this.i);
            }
            case 8: {
                this.b(canvas);
                this.c = this.f / 4.0f;
                this.d = this.f / 3.0f;
                canvas.drawLine(this.e - this.c, this.e - this.d, this.e - this.c, this.e + this.d, this.i);
                canvas.drawLine(this.e + this.c, this.e - this.d, this.e + this.c, this.e + this.d, this.i);
            }
            case 7: {
                this.b(canvas);
                this.c = this.f / 3.0f;
                this.d = this.f / 3.0f;
                this.i.setStyle(Paint.Style.FILL);
                this.j.moveTo(this.e + this.c, this.e);
                this.j.lineTo(this.e - this.c, this.e - this.d);
                this.j.lineTo(this.e - this.c, this.e + this.d);
                this.j.lineTo(this.e + this.c, this.e);
                canvas.drawPath(this.j, this.i);
            }
            case 0: {
                final float n = 50.0f * this.b / 2.0f;
                final float n2 = 30.0f * this.b / 2.0f;
                final float n3 = n - n2 / 3.0f;
                final float n4 = n + n2 / 3.0f;
                this.i.setAntiAlias(true);
                this.i.setColor(-16777216);
                this.i.setStrokeWidth(3.0f);
                this.i.setStyle(Paint.Style.FILL_AND_STROKE);
                final float n5 = n;
                canvas.drawCircle(n5, n5, n2, this.i);
                this.i.setColor(-1);
                this.i.setStyle(Paint.Style.STROKE);
                final float n6 = n3;
                final float n7 = n4;
                canvas.drawLine(n6, n6, n7, n7, this.i);
                final float n8 = n3;
                final float n9 = n4;
                canvas.drawLine(n8, n9, n9, n3, this.i);
                final float n10 = n;
                canvas.drawCircle(n10, n10, n2, this.i);
            }
            case 3: {
                final float n11 = 50.0f * this.b / 2.0f;
                final float n12 = 30.0f * this.b / 2.0f;
                this.j.reset();
                this.i.setAntiAlias(true);
                this.i.setColor(-16777216);
                this.i.setStrokeWidth(3.0f);
                this.i.setStyle(Paint.Style.FILL_AND_STROKE);
                final float n13 = n11;
                canvas.drawCircle(n13, n13, n12, this.i);
                this.i.setColor(-1);
                this.i.setStyle(Paint.Style.STROKE);
                final float n14 = n11;
                canvas.drawCircle(n14, n14, n12, this.i);
                this.k.set(this.getWidth() / 2 - this.h * this.b / 2.0f, this.getHeight() / 2 - this.h * this.b / 2.0f, this.getWidth() / 2 + this.h * this.b / 2.0f, this.getHeight() / 2 + this.h * this.b / 2.0f);
                canvas.drawArc(this.k, 0.0f, 270.0f, false, this.i);
                this.j.setFillType(Path.FillType.EVEN_ODD);
                this.j.moveTo(this.getWidth() / 2 + this.h * this.b / 2.0f, this.getHeight() / 2 - 2.0f * this.b);
                this.j.lineTo(this.getWidth() / 2 + this.h * this.b / 2.0f - 2.0f * this.b, (float)(this.getHeight() / 2));
                this.j.lineTo(this.getWidth() / 2 + this.h * this.b / 2.0f + 2.0f * this.b, (float)(this.getHeight() / 2));
                this.j.lineTo(this.getWidth() / 2 + this.h * this.b / 2.0f, this.getHeight() / 2 - 2.0f * this.b);
                this.j.close();
                this.i.setStyle(Paint.Style.FILL_AND_STROKE);
                canvas.drawPath(this.j, this.i);
            }
            case 1: {
                final float n15 = 50.0f * this.b / 2.0f;
                this.i.setAntiAlias(true);
                this.i.setColor(0);
                this.i.setStrokeWidth(3.0f);
                this.i.setStyle(Paint.Style.FILL_AND_STROKE);
                final float n16 = n15;
                canvas.drawCircle(n16, n16, n15, this.i);
            }
            case 5: {
                this.j.reset();
                this.j.setFillType(Path.FillType.EVEN_ODD);
                this.j.moveTo(this.getWidth() / 2 - this.h * this.b / 2.0f, this.getHeight() / 2 - this.h * this.b / 2.0f);
                this.j.lineTo(this.getWidth() / 2 + this.h * this.b / 2.0f, (float)(this.getHeight() / 2));
                this.j.lineTo(this.getWidth() / 2 - this.h * this.b / 2.0f, this.getHeight() / 2 + this.h * this.b / 2.0f);
                this.j.lineTo(this.getWidth() / 2 - this.h * this.b / 2.0f, this.getHeight() / 2 - this.h * this.b / 2.0f);
                this.j.close();
                this.i.setAntiAlias(true);
                this.i.setColor(-16777216);
                this.i.setStrokeWidth(3.0f);
                this.i.setStyle(Paint.Style.FILL_AND_STROKE);
                canvas.drawPath(this.j, this.i);
            }
            case 6: {
                this.j.reset();
                this.j.setFillType(Path.FillType.EVEN_ODD);
                this.j.moveTo(this.getWidth() / 2 - this.h * this.b / 2.0f, this.getHeight() / 2 - this.h * this.b / 2.0f);
                this.j.lineTo(this.getWidth() / 2 + this.h * this.b / 2.0f, (float)(this.getHeight() / 2));
                this.j.lineTo(this.getWidth() / 2 - this.h * this.b / 2.0f, this.getHeight() / 2 + this.h * this.b / 2.0f);
                this.j.lineTo(this.getWidth() / 2 - this.h * this.b / 2.0f, this.getHeight() / 2 - this.h * this.b / 2.0f);
                this.j.close();
                this.i.setAntiAlias(true);
                this.i.setColor(-12303292);
                this.i.setStrokeWidth(3.0f);
                this.i.setStyle(Paint.Style.FILL_AND_STROKE);
                canvas.drawPath(this.j, this.i);
            }
            case 4: {
                this.j.reset();
                this.j.setFillType(Path.FillType.EVEN_ODD);
                this.j.moveTo(this.getWidth() / 2 - this.h * this.b / 2.0f, (float)(this.getHeight() / 2));
                this.j.lineTo(this.getWidth() / 2 + this.h * this.b / 2.0f, this.getHeight() / 2 - this.h * this.b / 2.0f);
                this.j.lineTo(this.getWidth() / 2 + this.h * this.b / 2.0f, this.getHeight() / 2 + this.h * this.b / 2.0f);
                this.j.lineTo(this.getWidth() / 2 - this.h * this.b / 2.0f, (float)(this.getHeight() / 2));
                this.j.close();
                this.i.setAntiAlias(true);
                this.i.setColor(-16777216);
                this.i.setStrokeWidth(3.0f);
                this.i.setStyle(Paint.Style.FILL_AND_STROKE);
                canvas.drawPath(this.j, this.i);
            }
            case 2: {
                this.i.setAntiAlias(true);
                this.i.setColor(-1);
                this.i.setStrokeWidth(5.0f);
                this.i.setStyle(Paint.Style.STROKE);
                canvas.drawLine(this.getWidth() / 2 - this.h * this.b / 2.0f, this.getHeight() / 2 - this.h * this.b / 2.0f, this.getWidth() / 2 + this.h * this.b / 2.0f, this.getHeight() / 2 + this.h * this.b / 2.0f, this.i);
                canvas.drawLine(this.getWidth() / 2 - this.h * this.b / 2.0f, this.getHeight() / 2 + this.h * this.b / 2.0f, this.getWidth() / 2 + this.h * this.b / 2.0f, this.getHeight() / 2 - this.h * this.b / 2.0f, this.i);
                break;
            }
        }
    }
    
    private void a(final Canvas canvas) {
        this.e = 30.0f * this.b / 2.0f - 5.0f * this.b;
        this.c = 5.0f * this.b;
        this.d = 5.0f * this.b;
        this.i.setStyle(Paint.Style.FILL);
        this.i.setColor(-1);
        this.i.setStrokeWidth(4.0f);
        this.i.setAntiAlias(true);
        this.j.moveTo(this.e - this.c, this.e - this.d);
        this.j.lineTo(this.e, this.e - this.d);
        this.j.lineTo(this.e + 6.0f * this.b, this.e - this.d - 4.0f * this.b);
        this.j.lineTo(this.e + 6.0f * this.b, this.e + this.d + 4.0f * this.b);
        this.j.lineTo(this.e, this.e + this.d);
        this.j.lineTo(this.e - this.c, this.e + this.d);
        this.j.lineTo(this.e - this.c, this.e - this.d);
        canvas.drawPath(this.j, this.i);
    }
    
    private void b(final Canvas canvas) {
        this.f = 25.0f * this.b;
        this.e = 30.0f * this.b;
        this.i.setAntiAlias(true);
        this.i.setColor(-1);
        this.i.setStrokeWidth(7.0f);
        this.i.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(this.e, this.e, this.f, this.i);
    }
    
    static {
        a = cf.class.getSimpleName();
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.graphics.Matrix;
import android.view.animation.Transformation;
import android.graphics.Camera;
import android.view.animation.Animation;

final class a
{
    static final class a extends Animation
    {
        private final float a;
        private final float b;
        private final float c;
        private final float d;
        private final float e;
        private final boolean f;
        private Camera g;
        
        a(final float c, final float d) {
            this.a = 0.0f;
            this.b = 90.0f;
            this.c = c;
            this.d = d;
            this.e = 0.0f;
            this.f = true;
        }
        
        public final void initialize(final int n, final int n2, final int n3, final int n4) {
            super.initialize(n, n2, n3, n4);
            this.g = new Camera();
        }
        
        protected final void applyTransformation(final float n, final Transformation transformation) {
            final float a = this.a;
            final float n2 = a + (this.b - a) * n;
            final float c = this.c;
            final float d = this.d;
            final Camera g = this.g;
            final Matrix matrix = transformation.getMatrix();
            g.save();
            if (this.f) {
                g.translate(0.0f, 0.0f, this.e * n);
            }
            else {
                g.translate(0.0f, 0.0f, this.e * (1.0f - n));
            }
            g.rotateX(n2);
            g.getMatrix(matrix);
            g.restore();
            matrix.preTranslate(-c, -d);
            matrix.postTranslate(c, d);
        }
    }
    
    static final class b extends Animation
    {
        private final float a;
        private final float b;
        private final float c;
        private final float d;
        private final float e;
        private final boolean f;
        private Camera g;
        
        b(final float c, final float d) {
            this.a = 0.0f;
            this.b = 90.0f;
            this.c = c;
            this.d = d;
            this.e = 0.0f;
            this.f = true;
        }
        
        public final void initialize(final int n, final int n2, final int n3, final int n4) {
            super.initialize(n, n2, n3, n4);
            this.g = new Camera();
        }
        
        protected final void applyTransformation(final float n, final Transformation transformation) {
            final float a = this.a;
            final float n2 = a + (this.b - a) * n;
            final float c = this.c;
            final float d = this.d;
            final Camera g = this.g;
            final Matrix matrix = transformation.getMatrix();
            g.save();
            if (this.f) {
                g.translate(0.0f, 0.0f, this.e * n);
            }
            else {
                g.translate(0.0f, 0.0f, this.e * (1.0f - n));
            }
            g.rotateY(n2);
            g.getMatrix(matrix);
            g.restore();
            matrix.preTranslate(-c, -d);
            matrix.postTranslate(c, d);
        }
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.media.MediaMetadataRetriever;

public final class bs
{
    public a a;
    public a b;
    
    public bs(final a a, final a b) {
        this.a = a;
        this.b = b;
    }
    
    public static final class a
    {
        private long a;
        private long b;
        private String c;
        private bn d;
        
        public a(final long a, final long b, final String c, final bn d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
        
        public final long a() {
            long a = this.a;
            final bj b;
            final String b2;
            if ((b = this.d.b(this.c)) instanceof bw && (b2 = ((bw)b).b().b()) != null) {
                final MediaMetadataRetriever mediaMetadataRetriever;
                (mediaMetadataRetriever = new MediaMetadataRetriever()).setDataSource(b2);
                a += (long)(this.b * 1.0 / 100.0 * (Integer.valueOf(mediaMetadataRetriever.extractMetadata(9)) / 1000L));
                mediaMetadataRetriever.release();
            }
            if (a >= 0L) {
                return a;
            }
            return 0L;
        }
    }
}

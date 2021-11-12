// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.WorkerThread;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.net.SocketTimeoutException;

public final class gq extends gk
{
    public gq(final gm gm) {
        super(gm);
    }
    
    @Override
    protected final gn b() {
        final gn gn = new gn();
        try {
            this.c.getResponseCode();
            try {
                gn.b = this.c.getContentLength();
            }
            finally {
                this.c.disconnect();
            }
        }
        catch (SocketTimeoutException ex) {
            gn.a = new gl(504, "HTTP_GATEWAY_TIMEOUT");
        }
        catch (IOException ex2) {
            gn.a = new gl(-2, "NETWORK_IO_ERROR");
        }
        catch (OutOfMemoryError outOfMemoryError) {
            gn.a = new gl(-3, "OUT_OF_MEMORY_ERROR");
        }
        catch (Exception ex3) {
            gn.a = new gl(-1, "UNKNOWN_ERROR");
        }
        return gn;
    }
}

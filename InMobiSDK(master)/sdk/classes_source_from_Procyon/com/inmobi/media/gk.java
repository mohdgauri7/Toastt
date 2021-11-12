// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.net.ProtocolException;
import java.util.Iterator;
import java.util.Map;
import androidx.annotation.WorkerThread;
import androidx.annotation.NonNull;
import java.io.Closeable;
import java.io.IOException;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.HttpURLConnection;

class gk
{
    protected static final String a;
    protected gm b;
    protected HttpURLConnection c;
    
    public gk(final gm b) {
        this.b = b;
    }
    
    @NonNull
    @WorkerThread
    public gn a() {
        this.b.a();
        if (!this.b.t) {
            final gn gn;
            (gn = new gn()).a = new gl(-8, "Network Request dropped as current request is not GDPR compliant.");
            return gn;
        }
        gn b;
        if (hg.a()) {
            try {
                final HttpURLConnection c = (HttpURLConnection)new URL(this.b.f()).openConnection();
                this.a(c);
                this.c = c;
                if (!this.b.o) {
                    this.c.setInstanceFollowRedirects(false);
                }
                if ("POST".equals(this.b.k)) {
                    final String g = this.b.g();
                    final String l = this.b.l;
                    final String str = g;
                    this.c.setRequestProperty("Content-Length", Integer.toString(str.length()));
                    this.c.setRequestProperty("Content-Type", l);
                    Closeable closeable = null;
                    try {
                        ((Writer)(closeable = new BufferedWriter(new OutputStreamWriter(this.c.getOutputStream())))).write(str);
                    }
                    finally {
                        hg.a(closeable);
                    }
                }
                b = this.b();
            }
            catch (IOException ex) {
                (b = new gn()).a = new gl(-2, ex.getLocalizedMessage());
            }
            catch (Exception ex2) {
                (b = new gn()).a = new gl(-1, ex2.getLocalizedMessage());
            }
        }
        else {
            (b = new gn()).a = new gl(0, "Network not reachable currently. Please try again.");
        }
        return b;
    }
    
    private void a(final HttpURLConnection httpURLConnection) throws ProtocolException {
        httpURLConnection.setConnectTimeout(this.b.m);
        httpURLConnection.setReadTimeout(this.b.n);
        httpURLConnection.setUseCaches(false);
        final Map<String, String> e;
        if ((e = this.b.e()) != null) {
            for (final String key : e.keySet()) {
                httpURLConnection.setRequestProperty(key, e.get(key));
            }
        }
        final String k = this.b.k;
        httpURLConnection.setRequestMethod(k);
        if (!"GET".equals(k)) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
        }
    }
    
    protected gn b() {
        final gn gn = new gn();
        try {
            final int responseCode;
            if ((responseCode = this.c.getResponseCode()) == 200) {
                this.a(gn, false);
            }
            else {
                int n2 = 0;
                int n;
                if (400 <= responseCode && 500 > responseCode) {
                    n = (n2 = -7);
                }
                else if (200 < responseCode && 300 > responseCode) {
                    n = (n2 = -9);
                }
                else {
                    switch (responseCode) {
                        default: {
                            n = (n2 = -1);
                            break;
                        }
                        case 0: {
                            n = (n2 = 0);
                            break;
                        }
                        case -2: {
                            n = (n2 = -2);
                            break;
                        }
                        case -3: {
                            n = (n2 = -3);
                            break;
                        }
                        case -4: {
                            n = (n2 = -4);
                            break;
                        }
                        case -5: {
                            n = (n2 = -5);
                            break;
                        }
                        case -6: {
                            n = (n2 = -6);
                            break;
                        }
                        case -7: {
                            n = (n2 = -7);
                            break;
                        }
                        case -8: {
                            n = (n2 = -8);
                            break;
                        }
                        case -9: {
                            n = (n2 = -9);
                            break;
                        }
                        case 304: {
                            n = (n2 = 304);
                            break;
                        }
                        case 303: {
                            n = (n2 = 303);
                            break;
                        }
                        case 302: {
                            n = (n2 = 302);
                            break;
                        }
                        case 500: {
                            n = (n2 = 500);
                            break;
                        }
                        case 501: {
                            n = (n2 = 501);
                            break;
                        }
                        case 502: {
                            n = (n2 = 502);
                            break;
                        }
                        case 503: {
                            n = (n2 = 503);
                            break;
                        }
                        case 504: {
                            n = (n2 = 504);
                            break;
                        }
                        case 505: {
                            n = (n2 = 505);
                            break;
                        }
                        case -10: {
                            n = (n2 = -10);
                            break;
                        }
                    }
                }
                final int n3 = n2;
                if (n == -7) {
                    this.a(gn, true);
                    gn.a = new gl(n3, a(gn.b()));
                }
                else {
                    gn.a = new gl(n3, "HTTP:".concat(String.valueOf(responseCode)));
                    gn.c = this.c.getHeaderFields();
                }
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
        finally {
            try {
                hg.a(this.c);
                this.c.disconnect();
            }
            catch (Exception ex4) {
                gn.a = new gl(-1, "UNKNOWN_ERROR");
            }
        }
        return gn;
    }
    
    private void a(final gn gn, boolean b) throws IOException {
        if (this.b.d() && this.c.getContentLength() > this.b.r) {
            gn.a = new gl(-5, "Response size greater than specified max response size");
            return;
        }
        n = (int)(b ? this.c.getErrorStream() : this.c.getInputStream());
        byte[] array;
        try {
            array = hg.a((InputStream)n);
        }
        finally {
            hg.a((Closeable)n);
        }
        final gn gn2;
        if (0 != array.length) {
            if (this.b.p && (array = this.b.a(array)) == null) {
                gn2.a = new gl(-4, "Unable to decrypt the server response.");
            }
            if (array != null && this.b.s && (array = hg.a(array)) == null) {
                gn2.a = new gl(-6, "Failed to uncompress gzip response");
            }
            if (array != null) {
                gn2.b(array);
            }
        }
        gn2.c = this.c.getHeaderFields();
    }
    
    private static String a(final String s) {
        String string = null;
        if (s != null) {
            try {
                final JSONObject jsonObject;
                if ((jsonObject = new JSONObject(s)).has("errorMessage")) {
                    string = jsonObject.getString("errorMessage");
                }
            }
            catch (JSONException ex) {}
        }
        return string;
    }
    
    static {
        a = gk.class.getSimpleName();
    }
}

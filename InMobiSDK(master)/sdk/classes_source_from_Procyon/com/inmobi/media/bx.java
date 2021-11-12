// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import androidx.annotation.NonNull;

public final class bx extends bj
{
    public String z;
    public boolean A;
    public boolean B;
    
    public bx(final String s, final String s2, final bk bk, final String e, final boolean b) {
        super(s, s2, "WEBVIEW", bk);
        this.A = false;
        this.e = e;
        this.B = b;
    }
    
    public static String c(@NonNull String trim) {
        trim = trim.trim();
        switch (trim) {
            default: {
                return "UNKNOWN";
            }
            case "url": {
                return "URL";
            }
            case "html": {
                return "HTML";
            }
            case "reference_iframe": {
                return "REF_IFRAME";
            }
            case "reference_html": {
                return "REF_HTML";
            }
        }
    }
}

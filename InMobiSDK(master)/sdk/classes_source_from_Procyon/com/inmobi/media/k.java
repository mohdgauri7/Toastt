// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.content.pm.PackageManager;
import android.content.Context;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import com.inmobi.ads.rendering.InMobiAdActivity;
import java.net.URISyntaxException;
import android.webkit.URLUtil;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import java.util.List;
import android.content.pm.ResolveInfo;
import androidx.annotation.NonNull;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;

public class k
{
    private static final String b;
    private final String c = "inmobinativebrowser";
    private final String d = "inmobideeplink";
    private final String e = "url";
    private final String f = "primaryUrl";
    private final String g = "fallbackUrl";
    private final String h = "primaryTrackingUrl";
    private final String i = "fallbackTrackingUrl";
    public final o a;
    
    public k(final o a) {
        this.a = a;
    }
    
    public final void a(@Nullable final String s, @Nullable String s2, @Nullable String s3) {
        if (TextUtils.isEmpty((CharSequence)s3)) {
            this.b(s, s2);
            return;
        }
        final Uri parse;
        if (TextUtils.isEmpty((CharSequence)(parse = Uri.parse(s3)).getScheme())) {
            this.b(s, s2);
            return;
        }
        if (parse.getScheme().equals("inmobinativebrowser")) {
            final String s4 = s2;
            final String s5 = s3;
            s3 = s4;
            s2 = s;
            final String queryParameter;
            if (!TextUtils.isEmpty((CharSequence)(queryParameter = Uri.parse(s5).getQueryParameter("url"))) && this.b(queryParameter)) {
                this.c(s2, s3, s5);
                return;
            }
            this.a.b(s3, "Invalid URL", s2);
        }
        else if (parse.getScheme().equals("inmobideeplink")) {
            final String s6 = s2;
            final String s7 = s3;
            s3 = s6;
            s2 = s;
            final Uri parse2;
            if (this.a((parse2 = Uri.parse(s7)).getQueryParameter("primaryUrl"), parse2.getQueryParameter("primaryTrackingUrl"))) {
                this.c(s2, s3, s7);
                return;
            }
            if (this.a(parse2.getQueryParameter("fallbackUrl"), parse2.getQueryParameter("fallbackTrackingUrl"))) {
                this.c(s2, s3, s7);
                return;
            }
            this.a.b(s3, "Invalid URL", s2);
        }
        else {
            if (this.c(s3)) {
                this.c(s, s2, s3);
                return;
            }
            if (hd.a(parse)) {
                final String landingScheme = this.a.getLandingScheme();
                switch (landingScheme) {
                    case "EX_NATIVE": {
                        final String s8 = s2;
                        final String s9 = s3;
                        s3 = s8;
                        s2 = s;
                        if (hd.a(this.a.getContainerContext())) {
                            hd.c(this.a.getContainerContext(), s9);
                            this.c(s2, s3, s9);
                            return;
                        }
                        this.b(s2, s3, s9);
                        return;
                    }
                    case "IN_CUSTOM": {
                        this.a(s3);
                        return;
                    }
                    default: {
                        try {
                            this.b(s, s2, s3);
                            return;
                        }
                        catch (Exception ex) {
                            this.a.b(s2, "Unexpected error", "open");
                            hf.a((byte)1, "InMobi", "Failed to open URL; SDK encountered unexpected error");
                            return;
                        }
                        break;
                    }
                }
            }
            this.b(s, s2);
        }
    }
    
    private boolean b(@NonNull final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return false;
        }
        final Uri parse = Uri.parse(s);
        final List<ResolveInfo> d;
        if (!(d = hd.d(this.a.getContainerContext(), s)).isEmpty()) {
            hd.a(this.a.getContainerContext(), parse, d.get(0));
            return true;
        }
        return this.a(parse);
    }
    
    private boolean c(@NonNull final String s) {
        boolean b = false;
        Label_0055: {
            if (!TextUtils.isEmpty((CharSequence)s)) {
                final Uri parse = Uri.parse(s);
                if ("market".equals(parse.getScheme()) || "play.google.com".equals(parse.getHost()) || "market.android.com".equals(parse.getHost())) {
                    b = true;
                    break Label_0055;
                }
            }
            b = false;
        }
        if (!b) {
            return false;
        }
        final Uri parse2 = Uri.parse(s);
        if (a(this.a.getContainerContext())) {
            try {
                final Intent intent;
                (intent = new Intent("android.intent.action.VIEW", parse2)).setPackage("com.android.vending");
                intent.addFlags(268435456);
                this.a.getContainerContext().startActivity(intent);
                return true;
            }
            catch (ActivityNotFoundException ex) {
                fv.a().a(new gv((Throwable)ex));
                return false;
            }
        }
        if (!this.b(s)) {
            return false;
        }
        return true;
    }
    
    private boolean a(@Nullable final String s, @Nullable final String s2) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return false;
        }
        if (this.b(s)) {
            d(s2);
            return true;
        }
        return false;
    }
    
    private static void d(final String s) {
        if (!TextUtils.isEmpty((CharSequence)s)) {
            ba.a().a(s, true);
        }
    }
    
    private boolean a(final Uri uri) {
        try {
            hd.a(this.a.getContainerContext(), uri, null);
            return true;
        }
        catch (ActivityNotFoundException ex) {
            return false;
        }
    }
    
    public final void b(@Nullable final String s, @Nullable final String s2, @Nullable final String s3) {
        if (s3 == null || (s3.startsWith("http") && !URLUtil.isValidUrl(s3))) {
            this.a.b(s2, "Invalid URL", s);
            return;
        }
        final String a = com.inmobi.media.g.a(this.a.getContainerContext());
        try {
            final boolean cctEnabled = this.a.getAdConfig().cctEnabled;
            if (a == null || !cctEnabled) {
                this.a(s3);
                return;
            }
            new ce(s3, this.a.getContainerContext(), this.a).b();
        }
        catch (Exception ex) {
            try {
                hd.b(this.a.getContainerContext(), s3);
                this.a.c(s, s2, s3);
                this.a.getListener().a_();
            }
            catch (URISyntaxException ex2) {}
        }
    }
    
    public final void a(final String s) {
        if (!TextUtils.isEmpty((CharSequence)s) && !this.c(s) && hd.a(Uri.parse(s))) {
            InMobiAdActivity.a(this.a);
            final Intent intent;
            (intent = new Intent(this.a.getContainerContext(), (Class)InMobiAdActivity.class)).putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 100);
            intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.IN_APP_BROWSER_URL", s);
            gz.a(this.a.getContainerContext(), intent);
            this.a.c(null, null, s);
        }
    }
    
    public final void a(@Nullable String s, @Nullable String s2, @NonNull String s3, @Nullable String s4) {
        while (true) {
            try {
                hd.b(this.a.getContainerContext(), s3);
                this.c(s, s2, s3);
            }
            catch (URISyntaxException ex) {
                this.a.b(s2, "Cannot resolve URI (" + e(s3) + ")", s);
                if (s4 != null) {
                    final k k = this;
                    final String s5 = s;
                    final String s6 = s2;
                    final String s7 = s4;
                    s4 = null;
                    s3 = s7;
                    s2 = s6;
                    s = s5;
                    this = k;
                    continue;
                }
            }
            catch (ActivityNotFoundException ex2) {
                this.a.b(s2, "Cannot resolve URI (" + e(s3) + ")", s);
                if (s4 != null) {
                    final k i = this;
                    final String s8 = s;
                    final String s9 = s2;
                    final String s10 = s4;
                    s4 = null;
                    s3 = s10;
                    s2 = s9;
                    s = s8;
                    this = i;
                    continue;
                }
            }
            catch (Exception ex3) {
                this.a.b(s2, "Unexpected error", s);
                hf.a((byte)1, k.b, "Could not open URL; SDK encountered an unexpected error");
            }
            break;
        }
    }
    
    private static String e(@NonNull final String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        }
        catch (UnsupportedEncodingException ex) {
            return s;
        }
    }
    
    private void c(@Nullable final String s, @Nullable final String s2, @NonNull final String s3) {
        this.a.getListener().a_();
        this.a.c(s, s2, s3);
    }
    
    private void b(@Nullable final String s, @Nullable final String s2) {
        this.a.b(s2, "Invalid URL", s);
    }
    
    private static boolean a(@Nullable final Context context) {
        if (context == null) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            return true;
        }
        catch (PackageManager.NameNotFoundException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    static {
        b = k.class.getSimpleName();
    }
}

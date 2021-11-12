// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.sdk;

import com.inmobi.media.iw;
import com.inmobi.media.ix;
import android.util.Base64;
import com.inmobi.media.cq;
import com.inmobi.media.id;
import com.inmobi.media.fe;
import com.inmobi.media.fs;
import com.inmobi.media.hn;
import java.util.HashMap;
import com.inmobi.media.cp;
import android.location.Location;
import java.util.Locale;
import com.inmobi.media.hs;
import com.inmobi.media.ha;
import com.inmobi.media.iu;
import java.util.Map;
import com.inmobi.media.gw;
import android.os.SystemClock;
import androidx.annotation.WorkerThread;
import com.inmobi.media.fg;
import com.inmobi.media.gz;
import com.inmobi.media.hf;
import com.inmobi.media.hh;
import com.inmobi.media.hq;
import com.inmobi.media.ir;
import com.inmobi.media.hj;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.inmobi.unification.sdk.InitializationStatus;
import org.json.JSONObject;
import androidx.annotation.Size;
import androidx.annotation.NonNull;
import android.content.Context;

public final class InMobiSdk
{
    private static final String a;
    public static final String IM_GDPR_CONSENT_AVAILABLE = "gdpr_consent_available";
    public static final String IM_GDPR_CONSENT_IAB = "gdpr_consent";
    public static final String IM_GDPR_CONSENT_GDPR_APPLIES = "gdpr";
    
    @Deprecated
    @InitializationStatus
    @UiThread
    public static String init(@NonNull final Context context, @NonNull @Size(min = 32L, max = 36L) final String s) {
        return init(context, s, null);
    }
    
    @Deprecated
    @InitializationStatus
    @UiThread
    public static String init(@NonNull final Context context, @NonNull @Size(min = 32L, max = 36L) String trim, @Nullable final JSONObject jsonObject) {
        hj.a();
        if (ir.a()) {
            return "SDK could not be initialized; Required dependency could not be found. Please check out documentation and include the required dependency.";
        }
        trim = trim.trim();
        try {
            hq.a(jsonObject);
            if (0 == trim.length()) {
                return "Account id cannot be empty. Please provide a valid account id.";
            }
            if (!hh.a(context, "android.permission.ACCESS_COARSE_LOCATION") && !hh.a(context, "android.permission.ACCESS_FINE_LOCATION")) {
                hf.a((byte)1, InMobiSdk.a, "Please grant the location permissions (ACCESS_COARSE_LOCATION or ACCESS_FINE_LOCATION, or both) for better ad targeting.");
            }
            if (trim.length() != 32 && trim.length() != 36) {
                hf.a((byte)2, InMobiSdk.a, "Invalid account id passed to init. Please provide a valid account id.");
            }
            if (gz.b()) {
                return "Success";
            }
            gz.a(context, trim);
            ir.b(context);
            gz.a(new Runnable() {
                @WorkerThread
                @Override
                public final void run() {
                    try {
                        ir.a(context);
                        gz.k();
                        gz.b(trim);
                        fg.a(trim);
                        ir.c(context);
                    }
                    catch (Exception ex) {
                        InMobiSdk.a;
                    }
                }
            });
            hf.a((byte)2, InMobiSdk.a, "InMobi SDK initialized with account id: ".concat(String.valueOf(trim)));
            b();
            return "Success";
        }
        catch (Exception ex) {
            gz.a((Context)null);
            hf.a((byte)1, InMobiSdk.a, "SDK could not be initialized; an unexpected error was encountered.");
            return "SDK could not be initialized; an unexpected error was encountered.";
        }
    }
    
    @UiThread
    public static void init(@NonNull final Context context, @NonNull @Size(min = 32L, max = 36L) String trim, @Nullable final JSONObject jsonObject, @Nullable final SdkInitializationListener sdkInitializationListener) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        hj.a();
        if (ir.a()) {
            c(sdkInitializationListener, "SDK could not be initialized; Required dependency could not be found. Please check out documentation and include the required dependency.");
            return;
        }
        trim = trim.trim();
        try {
            hq.a(jsonObject);
            if (0 == trim.length()) {
                c(sdkInitializationListener, "Account id cannot be empty. Please provide a valid account id.");
                return;
            }
            if (!hh.a(context, "android.permission.ACCESS_COARSE_LOCATION") && !hh.a(context, "android.permission.ACCESS_FINE_LOCATION")) {
                hf.a((byte)1, InMobiSdk.a, "Please grant the location permissions (ACCESS_COARSE_LOCATION or ACCESS_FINE_LOCATION, or both) for better ad targeting.");
            }
            if (gz.b()) {
                c(sdkInitializationListener, null);
                return;
            }
            gz.a(context, trim);
            ir.b(context);
            b();
            gz.a(new Runnable() {
                @WorkerThread
                @Override
                public final void run() {
                    try {
                        ir.a(context);
                        gz.k();
                        gz.b(trim);
                        fg.a(trim);
                        ir.c(context);
                        c(sdkInitializationListener, null);
                        gw.a().a("SdkInitialized", InMobiSdk.a(elapsedRealtime));
                    }
                    catch (Exception ex) {
                        InMobiSdk.a;
                        c(sdkInitializationListener, "SDK could not be initialized; an unexpected error was encountered.");
                    }
                }
            });
        }
        catch (Exception ex) {
            gz.a((Context)null);
            c(sdkInitializationListener, "SDK could not be initialized; an unexpected error was encountered.");
        }
    }
    
    private static void c(@Nullable final SdkInitializationListener sdkInitializationListener, @Nullable final String s) {
        if (sdkInitializationListener != null) {
            iu.a().a(new Runnable() {
                @Override
                public final void run() {
                    fireListener(sdkInitializationListener, s);
                }
            });
        }
        if (s == null) {
            hf.a((byte)2, InMobiSdk.a, "InMobi SDK initialized with account id: " + gz.g());
            return;
        }
        hf.a((byte)1, InMobiSdk.a, s);
    }
    
    public static void fireListener(@NonNull final SdkInitializationListener sdkInitializationListener, @Nullable final String message) {
        sdkInitializationListener.onInitializationComplete((message == null) ? null : new Error(message));
    }
    
    public static void updateGDPRConsent(final JSONObject jsonObject) {
        hq.a(jsonObject);
    }
    
    public static void setPartnerGDPRConsent(final JSONObject jsonObject) {
        hq.b(jsonObject);
    }
    
    public static void setApplicationMuted(final boolean b) {
        gz.a(b);
    }
    
    private static void b() {
        gz.a(new Runnable() {
            @WorkerThread
            @Override
            public final void run() {
                final String[] array = { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_WIFI_STATE", "android.permission.CHANGE_WIFI_STATE" };
                final StringBuilder sb = new StringBuilder("Permissions granted to SDK are :\nandroid.permission.INTERNET\nandroid.permission.ACCESS_NETWORK_STATE");
                for (int i = 0; i < 4; ++i) {
                    final String str = array[i];
                    if (hh.a(gz.c(), str)) {
                        sb.append("\n").append(str);
                    }
                }
                hf.a((byte)2, InMobiSdk.a, sb.toString());
            }
        });
    }
    
    public static String getVersion() {
        return ha.b();
    }
    
    public static void setLogLevel(final LogLevel logLevel) {
        switch (InMobiSdk$6.a[logLevel.ordinal()]) {
            case 1: {
                hf.a((byte)0);
            }
            case 2: {
                hf.a((byte)1);
            }
            default: {
                hf.a((byte)2);
            }
        }
    }
    
    public static void setAge(final int n) {
        hs.a(n);
    }
    
    public static void setAgeGroup(final AgeGroup ageGroup) {
        hs.a(ageGroup.toString().toLowerCase(Locale.ENGLISH));
    }
    
    public static void setAreaCode(final String s) {
        hs.b(s);
    }
    
    public static void setPostalCode(final String s) {
        hs.c(s);
    }
    
    public static void setLocationWithCityStateCountry(final String s, final String s2, final String s3) {
        hs.d(s);
        hs.e(s2);
        hs.f(s3);
    }
    
    public static void setYearOfBirth(final int n) {
        hs.b(n);
    }
    
    public static void setGender(final Gender gender) {
        hs.g(gender.toString().toLowerCase(Locale.ENGLISH));
    }
    
    public static void setEducation(final Education education) {
        hs.h(education.toString().toLowerCase(Locale.ENGLISH));
    }
    
    public static void setLanguage(final String s) {
        hs.i(s);
    }
    
    public static void setInterests(final String s) {
        hs.j(s);
    }
    
    public static void setLocation(final Location location) {
        hs.a(location);
    }
    
    @UiThread
    public static String getToken() {
        return getToken(null, null);
    }
    
    @UiThread
    public static String getToken(@Nullable final Map<String, String> b, @Nullable final String a) {
        cp.a();
        final long currentTimeMillis = System.currentTimeMillis();
        if (b != null) {
            ha.a(b.get("tp"));
            ha.b(b.get("tp-ver"));
        }
        final HashMap<String, String> hashMap;
        (hashMap = new HashMap<String, String>()).put("networkType", hn.b());
        hashMap.put("plType", "AB");
        gw.a().a("AdGetSignalsCalled", (Map<String, Object>)hashMap);
        if (!gz.a()) {
            hf.a((byte)1, cp.a, "InMobi SDK is not initialised. Cannot fetch a token.");
            cp.a(90, currentTimeMillis);
            return null;
        }
        if (((fs)fg.a("root", gz.f(), null)).i()) {
            cp.a(9, currentTimeMillis);
            return null;
        }
        final cq cq;
        (cq = new cq(new id(((fe)fg.a("ads", gz.f(), null)).f()))).b = b;
        cq.a = a;
        final HashMap<String, String> hashMap2;
        (hashMap2 = new HashMap<String, String>()).put("h-user-agent", gz.i());
        cq.c(hashMap2);
        cq.a();
        if (!cq.t) {
            cp.a(21, currentTimeMillis);
            return null;
        }
        final HashMap<String, String> hashMap3;
        (hashMap3 = new HashMap<String, String>()).put("latency", (String)(System.currentTimeMillis() - currentTimeMillis));
        hashMap3.put("networkType", hn.b());
        hashMap3.put("plType", "AB");
        gw.a().a("AdGetSignalsSucceeded", (Map<String, Object>)hashMap3);
        return new String(Base64.encode(cq.g().getBytes(), 8));
    }
    
    public static void setPublisherProvidedUnifiedId(@Nullable final JSONObject jsonObject) {
        gz.a(new Runnable() {
            @Override
            public final void run() {
                if (ix.b()) {
                    return;
                }
                iw.b(jsonObject);
            }
        });
    }
    
    public static boolean isSDKInitialized() {
        return gz.b();
    }
    
    static /* synthetic */ Map a(final long n) {
        final HashMap<String, String> hashMap;
        (hashMap = new HashMap<String, String>()).put("latency", (String)(SystemClock.elapsedRealtime() - n));
        hashMap.put("networkType", hn.b());
        hashMap.put("integrationType", "InMobi");
        return hashMap;
    }
    
    static {
        a = InMobiSdk.class.getSimpleName();
    }
    
    public enum LogLevel
    {
        NONE, 
        ERROR, 
        DEBUG;
    }
    
    public enum Education
    {
        HIGH_SCHOOL_OR_LESS("highschoolorless"), 
        COLLEGE_OR_GRADUATE("collegeorgraduate"), 
        POST_GRADUATE_OR_ABOVE("postgraduateorabove");
        
        private String value;
        
        private Education(final String value) {
            this.value = value;
        }
        
        @Override
        public final String toString() {
            return this.value;
        }
    }
    
    public enum Gender
    {
        FEMALE("f"), 
        MALE("m");
        
        private String value;
        
        private Gender(final String value) {
            this.value = value;
        }
        
        @Override
        public final String toString() {
            return this.value;
        }
    }
    
    public enum AgeGroup
    {
        BELOW_18("below18"), 
        BETWEEN_18_AND_24("between18and24"), 
        BETWEEN_25_AND_29("between25and29"), 
        BETWEEN_30_AND_34("between30and34"), 
        BETWEEN_35_AND_44("between35and44"), 
        BETWEEN_45_AND_54("between45and54"), 
        BETWEEN_55_AND_65("between55and65"), 
        ABOVE_65("above65");
        
        private String value;
        
        private AgeGroup(final String value) {
            this.value = value;
        }
        
        @Override
        public final String toString() {
            return this.value;
        }
    }
}

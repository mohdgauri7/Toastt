// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import java.lang.reflect.Method;
import com.inmobi.ads.controllers.PublisherCallbacks;
import com.inmobi.sdk.SdkInitializationListener;
import com.inmobi.sdk.InMobiSdk;
import com.inmobi.ads.InMobiBanner;
import com.inmobi.ads.InMobiNative;
import com.inmobi.ads.InMobiInterstitial;
import com.inmobi.ads.exceptions.InvalidPlacementIdException;
import com.inmobi.ads.exceptions.SdkNotInitializedException;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;

public class fy implements Thread.UncaughtExceptionHandler
{
    private Thread.UncaughtExceptionHandler a;
    private static final String b;
    
    @VisibleForTesting(otherwise = 3)
    public fy(final Thread.UncaughtExceptionHandler a) {
        this.a = a;
    }
    
    @Override
    public void uncaughtException(@NonNull final Thread thread, @Nullable final Throwable t) {
        try {
            boolean b = false;
            Label_0217: {
                if (t == null || t instanceof SdkNotInitializedException || t instanceof InvalidPlacementIdException) {
                    b = false;
                }
                else {
                    StackTraceElement[] stackTrace;
                    for (int length = (stackTrace = t.getStackTrace()).length, i = 0; i < length; ++i) {
                        final StackTraceElement stackTraceElement = stackTrace[i];
                        if (a(InMobiInterstitial.a.class.getSuperclass(), stackTraceElement) || a(InMobiInterstitial.a.class, stackTraceElement) || a(InMobiNative.NativeCallbacks.class, stackTraceElement) || a(InMobiBanner.a.class, stackTraceElement) || a(InMobiBanner.a.class.getSuperclass(), stackTraceElement) || (stackTraceElement.getClassName().equals(InMobiSdk.class.getName()) && stackTraceElement.getMethodName().equals(InMobiSdk.class.getDeclaredMethod("fireListener", SdkInitializationListener.class, String.class).getName())) || stackTraceElement.getClassName().contains(fy.class.getName())) {
                            b = false;
                            break Label_0217;
                        }
                        if (stackTraceElement.getClassName().contains("com.inmobi.") || stackTraceElement.getClassName().contains("com.aerserv.")) {
                            b = true;
                            break Label_0217;
                        }
                    }
                    b = false;
                }
            }
            if (b) {
                fv.a().a(new fx(thread, t));
            }
        }
        catch (Exception ex) {
            try {
                fv.a().a(new fx(thread, ex));
                fv.a().a(new fx(thread, t));
            }
            catch (Exception ex2) {}
        }
        this.a.uncaughtException(thread, t);
    }
    
    private static boolean a(final Class<?> clazz, final StackTraceElement stackTraceElement) {
        if (stackTraceElement.getClassName().equals(clazz.getName())) {
            Method[] declaredMethods;
            for (int length = (declaredMethods = PublisherCallbacks.class.getDeclaredMethods()).length, i = 0; i < length; ++i) {
                if (stackTraceElement.getMethodName().equals(declaredMethods[i].getName())) {
                    return true;
                }
            }
        }
        return false;
    }
    
    static {
        b = fy.class.getSimpleName();
    }
}

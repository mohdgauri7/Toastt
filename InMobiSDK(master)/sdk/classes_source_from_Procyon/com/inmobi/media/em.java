// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.os.Build;
import android.media.AudioManager;
import android.media.AudioFocusRequest;
import androidx.annotation.RequiresApi;
import android.media.AudioAttributes;
import android.content.Context;

public final class em
{
    private final Context b;
    private final a c;
    private boolean d;
    private final Object e;
    @RequiresApi(api = 26)
    final AudioAttributes a;
    @RequiresApi(api = 26)
    private AudioFocusRequest f;
    private AudioManager.OnAudioFocusChangeListener g;
    
    protected em(final Context b, final a c) {
        this.d = false;
        this.e = new Object();
        this.a = new AudioAttributes.Builder().setUsage(1).setContentType(2).setLegacyStreamType(3).build();
        this.b = b;
        this.c = c;
    }
    
    public final void a() {
        synchronized (this.e) {
            final AudioManager audioManager;
            if ((audioManager = (AudioManager)this.b.getSystemService("audio")) != null) {
                if (Build.VERSION.SDK_INT >= 26) {
                    if (this.f != null) {
                        audioManager.abandonAudioFocusRequest(this.f);
                    }
                }
                else if (this.g != null) {
                    audioManager.abandonAudioFocus(this.g);
                }
            }
        }
    }
    
    public final void b() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: istore_1       
        //     2: aload_0        
        //     3: getfield        com/inmobi/media/em.e:Ljava/lang/Object;
        //     6: dup            
        //     7: astore_2       
        //     8: monitorenter   
        //     9: aload_0        
        //    10: getfield        com/inmobi/media/em.b:Landroid/content/Context;
        //    13: ldc             "audio"
        //    15: invokevirtual   android/content/Context.getSystemService:(Ljava/lang/String;)Ljava/lang/Object;
        //    18: checkcast       Landroid/media/AudioManager;
        //    21: dup            
        //    22: astore_3       
        //    23: ifnull          112
        //    26: aload_0        
        //    27: getfield        com/inmobi/media/em.g:Landroid/media/AudioManager$OnAudioFocusChangeListener;
        //    30: ifnonnull       43
        //    33: aload_0        
        //    34: dup            
        //    35: invokedynamic   BootstrapMethod #0, onAudioFocusChange:(Lcom/inmobi/media/em;)Landroid/media/AudioManager$OnAudioFocusChangeListener;
        //    40: putfield        com/inmobi/media/em.g:Landroid/media/AudioManager$OnAudioFocusChangeListener;
        //    43: getstatic       android/os/Build$VERSION.SDK_INT:I
        //    46: bipush          26
        //    48: if_icmplt       101
        //    51: aload_0        
        //    52: getfield        com/inmobi/media/em.f:Landroid/media/AudioFocusRequest;
        //    55: ifnonnull       89
        //    58: aload_0        
        //    59: dup            
        //    60: astore_1       
        //    61: new             Landroid/media/AudioFocusRequest$Builder;
        //    64: dup            
        //    65: iconst_2       
        //    66: invokespecial   android/media/AudioFocusRequest$Builder.<init>:(I)V
        //    69: aload_1        
        //    70: getfield        com/inmobi/media/em.a:Landroid/media/AudioAttributes;
        //    73: invokevirtual   android/media/AudioFocusRequest$Builder.setAudioAttributes:(Landroid/media/AudioAttributes;)Landroid/media/AudioFocusRequest$Builder;
        //    76: aload_1        
        //    77: getfield        com/inmobi/media/em.g:Landroid/media/AudioManager$OnAudioFocusChangeListener;
        //    80: invokevirtual   android/media/AudioFocusRequest$Builder.setOnAudioFocusChangeListener:(Landroid/media/AudioManager$OnAudioFocusChangeListener;)Landroid/media/AudioFocusRequest$Builder;
        //    83: invokevirtual   android/media/AudioFocusRequest$Builder.build:()Landroid/media/AudioFocusRequest;
        //    86: putfield        com/inmobi/media/em.f:Landroid/media/AudioFocusRequest;
        //    89: aload_3        
        //    90: aload_0        
        //    91: getfield        com/inmobi/media/em.f:Landroid/media/AudioFocusRequest;
        //    94: invokevirtual   android/media/AudioManager.requestAudioFocus:(Landroid/media/AudioFocusRequest;)I
        //    97: istore_1       
        //    98: goto            112
        //   101: aload_3        
        //   102: aload_0        
        //   103: getfield        com/inmobi/media/em.g:Landroid/media/AudioManager$OnAudioFocusChangeListener;
        //   106: iconst_3       
        //   107: iconst_2       
        //   108: invokevirtual   android/media/AudioManager.requestAudioFocus:(Landroid/media/AudioManager$OnAudioFocusChangeListener;II)I
        //   111: istore_1       
        //   112: aload_2        
        //   113: monitorexit    
        //   114: goto            122
        //   117: astore_1       
        //   118: aload_2        
        //   119: monitorexit    
        //   120: aload_1        
        //   121: athrow         
        //   122: iload_1        
        //   123: iconst_1       
        //   124: if_icmpne       137
        //   127: aload_0        
        //   128: getfield        com/inmobi/media/em.c:Lcom/inmobi/media/em$a;
        //   131: invokeinterface com/inmobi/media/em$a.a:()V
        //   136: return         
        //   137: aload_0        
        //   138: getfield        com/inmobi/media/em.c:Lcom/inmobi/media/em$a;
        //   141: invokeinterface com/inmobi/media/em$a.b:()V
        //   146: return         
        //    StackMapTable: 00 07 FE 00 2B 00 07 00 0F 07 00 08 2D 0B FF 00 0A 00 03 07 00 0D 01 07 00 0F 00 00 FF 00 04 00 03 00 00 07 00 0F 00 01 07 00 10 FF 00 04 00 02 07 00 0D 01 00 00 FA 00 0E
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  9      114    117    122    Any
        //  117    120    117    122    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2895)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    protected final void c() {
        this.a();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f = null;
        }
        this.g = null;
    }
    
    interface a
    {
        void a();
        
        void b();
        
        void c();
        
        void d();
    }
}

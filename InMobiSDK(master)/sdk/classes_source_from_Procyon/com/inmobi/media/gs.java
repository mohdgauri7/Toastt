// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

public final class gs extends SQLiteOpenHelper
{
    public static final String a;
    
    public gs(final Context context) {
        super(context, gs.a, (SQLiteDatabase.CursorFactory)null, 1);
    }
    
    public final void onCreate(final SQLiteDatabase sqLiteDatabase) {
    }
    
    public final void onUpgrade(final SQLiteDatabase sqLiteDatabase, final int n, final int n2) {
    }
    
    static {
        a = "com.im_" + ha.b() + ".db";
    }
}

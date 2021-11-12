// 
// Decompiled by Procyon v0.5.36
// 

package com.inmobi.media;

import android.database.Cursor;
import android.database.DatabaseUtils;
import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public final class gt
{
    private static final String a;
    private static volatile gt b;
    private static final Object c;
    private static final Object d;
    private static int e;
    private SQLiteDatabase f;
    
    private gt() {
        final gs gs = new gs(gz.c());
        try {
            this.f = gs.getWritableDatabase();
            gt.b = this;
        }
        catch (Exception ex) {}
    }
    
    public static gt a() {
        synchronized (gt.d) {
            ++gt.e;
        }
        final gt b;
        if ((b = gt.b) == null) {
            synchronized (gt.c) {
                if (gt.b == null) {
                    gt.b = new gt();
                }
            }
        }
        return b;
    }
    
    public final void a(final String s, final ContentValues contentValues, final String s2, final String[] array) {
        try {
            synchronized (gt.c) {
                if (-1L == this.a(s, contentValues)) {
                    this.b(s, contentValues, s2, array);
                }
            }
        }
        catch (Exception ex) {}
    }
    
    public final long a(final String s, final ContentValues contentValues) {
        try {
            synchronized (gt.c) {
                return this.f.insertWithOnConflict(s, (String)null, contentValues, 4);
            }
        }
        catch (Exception ex) {
            return -1L;
        }
    }
    
    public final int a(final String s, final String s2, final String[] array) {
        try {
            synchronized (gt.c) {
                return this.f.delete(s, s2, array);
            }
        }
        catch (Exception ex) {
            return -1;
        }
    }
    
    public final int b(final String s, final ContentValues contentValues, final String s2, final String[] array) {
        try {
            synchronized (gt.c) {
                return this.f.updateWithOnConflict(s, contentValues, s2, array, 4);
            }
        }
        catch (Exception ex) {
            return -1;
        }
    }
    
    public final List<ContentValues> a(final String s, final String[] array, final String s2, final String[] array2, final String s3, final String s4, final String s5, final String s6) {
        final ArrayList<ContentValues> list = new ArrayList<ContentValues>();
        Cursor query = null;
        try {
            synchronized (gt.c) {
                query = this.f.query(s, array, s2, array2, s3, s4, s5, s6);
            }
            if (query.moveToFirst()) {
                do {
                    final ContentValues contentValues = new ContentValues();
                    DatabaseUtils.cursorRowToContentValues(query, contentValues);
                    list.add(contentValues);
                } while (query.moveToNext());
            }
            query.close();
        }
        catch (Exception ex) {}
        finally {
            if (query != null) {
                query.close();
            }
        }
        return list;
    }
    
    public final int a(String string) {
        Cursor rawQuery = null;
        try {
            string = "SELECT COUNT(*) FROM " + string + " ; ";
            synchronized (gt.c) {
                rawQuery = this.f.rawQuery(string, (String[])null);
            }
            rawQuery.moveToFirst();
            final int int1 = rawQuery.getInt(0);
            rawQuery.close();
            return int1;
        }
        catch (Exception ex) {
            return -1;
        }
        finally {
            if (rawQuery != null) {
                rawQuery.close();
            }
        }
    }
    
    public final int b(String string, final String str, final String[] array) {
        Cursor rawQuery = null;
        try {
            string = "SELECT COUNT(*) FROM " + string + " WHERE " + str + " ; ";
            synchronized (gt.c) {
                rawQuery = this.f.rawQuery(string, array);
            }
            rawQuery.moveToFirst();
            final int int1 = rawQuery.getInt(0);
            rawQuery.close();
            return int1;
        }
        catch (Exception ex) {
            return -1;
        }
        finally {
            if (rawQuery != null) {
                rawQuery.close();
            }
        }
    }
    
    public final void b(String string) {
        try {
            string = "DROP TABLE IF EXISTS \"" + string + "\"";
            synchronized (gt.c) {
                this.f.execSQL(string);
            }
        }
        catch (Exception ex) {}
    }
    
    public final void a(String string, final String str) {
        try {
            string = "CREATE TABLE IF NOT EXISTS " + string + str + ";";
            synchronized (gt.c) {
                this.f.execSQL(string);
            }
        }
        catch (Exception ex) {}
    }
    
    public final void b() {
        try {
            synchronized (gt.d) {
                if (--gt.e == 0) {
                    synchronized (gt.c) {
                        this.f.close();
                    }
                    gt.b = null;
                }
            }
        }
        catch (Exception ex) {}
    }
    
    static {
        a = gt.class.getSimpleName();
        c = new Object();
        d = new Object();
        gt.e = 0;
    }
}

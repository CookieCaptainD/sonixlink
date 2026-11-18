package com.mattiadoronzo.sonixlink;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.card.MaterialCardViewHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p001io.CloseableKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Library.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001e\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020 J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001e\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020 J\u0006\u0010#\u001a\u00020$J\b\u0010%\u001a\u00020$H\u0002J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018J\u0012\u0010(\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001e\u001a\u00020\u0014H\u0002J\u0006\u0010)\u001a\u00020\fJ\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018J+\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010,\u001a\u00020\u00142\u000e\b\u0002\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00140.H\u0002¢\u0006\u0002\u0010/J\u0010\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u00020\u0014H\u0002J\u001e\u00102\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001e\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020 J\u001e\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0014042\u0006\u00105\u001a\u00020\u0014H\u0002J\u0006\u00106\u001a\u00020 J\u0016\u00107\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ \u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0019092\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00140\u0018J\u0014\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010<\u001a\u00020\u0014J\u001e\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010>\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010@\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u0014\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010B\u001a\u00020\u0014J&\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010D\u001a\u00020\u00142\u0006\u00105\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0014\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u00101\u001a\u00020\u0014J \u0010F\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018*\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010G\u001a\u00020\fH\u0002R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006H"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/Library;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "databaseFile", "Ljava/io/File;", "getDatabaseFile", "()Ljava/io/File;", "db", "Landroid/database/sqlite/SQLiteDatabase;", "exists", "", "getExists", "()Z", "file", "gate", "hasAlbumKeys", "hasDisc", "inAlbum", "", "getInAlbum", "()Ljava/lang/String;", "albumArtists", "", "Lcom/mattiadoronzo/sonixlink/Row;", "sort", "Lcom/mattiadoronzo/sonixlink/SortPrefs;", "albums", "albumsMatching", "text", "limit", "", "artists", "artistsMatching", "close", "", "closeLocked", "favourites", "genres", "likeOf", "open", "playlists", "query", "sql", "args", "", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/util/List;", "quoted", "table", "search", "splitAlbum", "Lkotlin/Pair;", "value", "trackCount", "tracks", "tracksByPaths", "", "paths", "tracksOfAlbum", "album", "tracksOfAlbumArtist", "albumArtist", "tracksOfArtist", "artist", "tracksOfGenre", "genre", "tracksOfPerson", "column", "tracksOfPlaylist", "maybeReversed", "reverse", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class Library {
    private SQLiteDatabase db;
    private final File file;
    private final Object gate;
    private boolean hasAlbumKeys;
    private boolean hasDisc;

    public Library(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.file = new File(context.getFilesDir(), "library.db");
        this.gate = new Object();
    }

    /* JADX INFO: renamed from: getDatabaseFile, reason: from getter */
    public final File getFile() {
        return this.file;
    }

    public final boolean getExists() {
        return this.file.exists() && this.file.length() > 0;
    }

    public final boolean open() {
        boolean z;
        synchronized (this.gate) {
            closeLocked();
            z = false;
            if (getExists()) {
                try {
                    SQLiteDatabase database = SQLiteDatabase.openDatabase(this.file.getAbsolutePath(), null, 17);
                    HashSet columns = new HashSet();
                    Cursor cursorRawQuery = database.rawQuery("PRAGMA table_info(MEDIA_TABLE)", null);
                    try {
                        Cursor cursor = cursorRawQuery;
                        int name = cursor.getColumnIndex("name");
                        while (cursor.moveToNext()) {
                            String string = cursor.getString(name);
                            if (string == null) {
                                string = "";
                            }
                            columns.add(string);
                        }
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(cursorRawQuery, null);
                        Cursor cursorRawQuery2 = database.rawQuery("SELECT 1 FROM sqlite_master WHERE type='table' AND name='ALBUM_GROUP_TABLE'", null);
                        try {
                            Cursor it = cursorRawQuery2;
                            boolean groups = it.moveToFirst();
                            Unit unit2 = Unit.INSTANCE;
                            CloseableKt.closeFinally(cursorRawQuery2, null);
                            this.hasDisc = columns.contains("disc");
                            this.hasAlbumKeys = groups && columns.contains("album_key");
                            this.db = database;
                            z = true;
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                CloseableKt.closeFinally(cursorRawQuery2, th);
                                throw th2;
                            }
                        }
                    } catch (Throwable th3) {
                        try {
                            throw th3;
                        } catch (Throwable th4) {
                            CloseableKt.closeFinally(cursorRawQuery, th3);
                            throw th4;
                        }
                    }
                } catch (Exception e) {
                    this.db = null;
                }
            }
        }
        return z;
    }

    private final String getInAlbum() {
        return this.hasDisc ? "COALESCE(disc,1), dis_id" : "dis_id";
    }

    private final List<Row> maybeReversed(List<Row> list, boolean reverse) {
        return reverse ? CollectionsKt.asReversed(list) : list;
    }

    private final Pair<String, String> splitAlbum(String value) {
        int at = StringsKt.indexOf$default((CharSequence) value, (char) 31, 0, false, 6, (Object) null);
        if (at < 0) {
            return TuplesKt.m155to(value, null);
        }
        String strSubstring = value.substring(0, at);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        String strSubstring2 = value.substring(at + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        return TuplesKt.m155to(strSubstring, strSubstring2);
    }

    public final void close() {
        synchronized (this.gate) {
            closeLocked();
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void closeLocked() {
        try {
            SQLiteDatabase sQLiteDatabase = this.db;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
        } catch (Exception e) {
        }
        this.db = null;
    }

    private final List<Row> query(String sql, String[] args) {
        ArrayList arrayListEmptyList;
        Throwable th;
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        synchronized (this.gate) {
            SQLiteDatabase database = this.db;
            if (database == null) {
                arrayListEmptyList = CollectionsKt.emptyList();
            } else {
                ArrayList rows = new ArrayList();
                try {
                    try {
                        Cursor cursorRawQuery = database.rawQuery(sql, args);
                        try {
                            Cursor cursor = cursorRawQuery;
                            int title = cursor.getColumnIndex("row_title");
                            int subtitle = cursor.getColumnIndex("row_subtitle");
                            int path = cursor.getColumnIndex("row_path");
                            int filter = cursor.getColumnIndex("row_filter");
                            int count = cursor.getColumnIndex("row_count");
                            int album = cursor.getColumnIndex("row_album");
                            int artPath = cursor.getColumnIndex("row_art_path");
                            try {
                                int artMtime = cursor.getColumnIndex("row_art_mtime");
                                try {
                                    int artSize = cursor.getColumnIndex("row_art_size");
                                    int sortKey = cursor.getColumnIndex("row_sortkey");
                                    while (cursor.moveToNext()) {
                                        if (title < 0 || (string = cursor.getString(title)) == null) {
                                            string = "";
                                        }
                                        String str = string;
                                        if (subtitle < 0 || (string2 = cursor.getString(subtitle)) == null) {
                                            string2 = "";
                                        }
                                        String str2 = string2;
                                        if (path < 0 || (string3 = cursor.getString(path)) == null) {
                                            string3 = "";
                                        }
                                        String str3 = string3;
                                        if (filter < 0 || (string4 = cursor.getString(filter)) == null) {
                                            string4 = "";
                                        }
                                        String str4 = string4;
                                        int i = count >= 0 ? cursor.getInt(count) : 0;
                                        if (album < 0 || (string5 = cursor.getString(album)) == null) {
                                            string5 = "";
                                        }
                                        String str5 = string5;
                                        if (artPath < 0 || (string6 = cursor.getString(artPath)) == null) {
                                            string6 = "";
                                        }
                                        String str6 = string6;
                                        long j = artMtime >= 0 ? cursor.getLong(artMtime) : 0L;
                                        long j2 = artSize >= 0 ? cursor.getLong(artSize) : 0L;
                                        if (sortKey < 0 || (string7 = cursor.getString(sortKey)) == null) {
                                            string7 = "";
                                        }
                                        rows.add(new Row(str, str2, str3, str4, i, str5, str6, j, j2, null, string7, 0, 2560, null));
                                    }
                                    Unit unit = Unit.INSTANCE;
                                    CloseableKt.closeFinally(cursorRawQuery, null);
                                    arrayListEmptyList = rows;
                                } catch (Throwable th2) {
                                    th = th2;
                                    try {
                                        throw th;
                                    } catch (Throwable th3) {
                                        CloseableKt.closeFinally(cursorRawQuery, th);
                                        throw th3;
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    } catch (Exception e) {
                        arrayListEmptyList = CollectionsKt.emptyList();
                    }
                } catch (Exception e2) {
                    arrayListEmptyList = CollectionsKt.emptyList();
                }
            }
        }
        return arrayListEmptyList;
    }

    static /* synthetic */ List query$default(Library library, String str, String[] strArr, int i, Object obj) {
        if ((i & 2) != 0) {
            strArr = new String[0];
        }
        return library.query(str, strArr);
    }

    public final int trackCount() {
        int i;
        synchronized (this.gate) {
            SQLiteDatabase database = this.db;
            i = 0;
            if (database != null) {
                try {
                    Cursor cursorRawQuery = database.rawQuery("SELECT COUNT(*) FROM MEDIA_TABLE", null);
                    try {
                        Cursor it = cursorRawQuery;
                        int i2 = it.moveToFirst() ? it.getInt(0) : 0;
                        CloseableKt.closeFinally(cursorRawQuery, null);
                        i = i2;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(cursorRawQuery, th);
                            throw th2;
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
        return i;
    }

    public static /* synthetic */ List tracks$default(Library library, SortPrefs sortPrefs, int i, Object obj) {
        if ((i & 1) != 0) {
            sortPrefs = Session.INSTANCE.getSort();
        }
        return library.tracks(sortPrefs);
    }

    public final List<Row> tracks(SortPrefs sort) {
        Intrinsics.checkNotNullParameter(sort, "sort");
        String order = sort.byDate(0) ? "ctime, sortkey, rowid" : "sortkey, rowid";
        return maybeReversed(query$default(this, "SELECT name AS row_title, artist AS row_subtitle, path AS row_path, album AS row_album,\n                      path AS row_art_path, mtime AS row_art_mtime, size AS row_art_size,\n                      SUBSTR(sortkey, 1, 2) AS row_sortkey\n               FROM MEDIA_TABLE WHERE path <> '' ORDER BY " + order, null, 2, null), sort.reversed(0));
    }

    public static /* synthetic */ List albums$default(Library library, SortPrefs sortPrefs, int i, Object obj) {
        if ((i & 1) != 0) {
            sortPrefs = Session.INSTANCE.getSort();
        }
        return library.albums(sortPrefs);
    }

    public final List<Row> albums(SortPrefs sort) {
        List<Row> listQuery$default;
        Intrinsics.checkNotNullParameter(sort, "sort");
        boolean byDate = sort.byDate(1);
        if (this.hasAlbumKeys) {
            String order = byDate ? "(SELECT MAX(m.ctime) FROM MEDIA_TABLE m WHERE m.album = g.album AND m.album_key = g.album_key), sortkey" : "sortkey";
            listQuery$default = query$default(this, "SELECT album AS row_title, '' AS row_subtitle, album || char(31) || album_key AS row_filter,\n                          (SELECT COUNT(*) FROM MEDIA_TABLE m\n                            WHERE m.album = g.album AND m.album_key = g.album_key AND m.path <> '') AS row_count,\n                          album AS row_album, SUBSTR(sortkey, 1, 2) AS row_sortkey\n                   FROM ALBUM_GROUP_TABLE g WHERE album <> '' ORDER BY " + order + ", album, album_key", null, 2, null);
        } else {
            String order2 = byDate ? "(SELECT MAX(m.ctime) FROM MEDIA_TABLE m WHERE m.album = t.album), sortkey" : "sortkey";
            listQuery$default = query$default(this, "SELECT album AS row_title, '' AS row_subtitle, album AS row_filter,\n                          (SELECT COUNT(*) FROM MEDIA_TABLE m WHERE m.album = t.album AND m.path <> '') AS row_count,\n                          album AS row_album, SUBSTR(sortkey, 1, 2) AS row_sortkey\n                   FROM ALBUM_TABLE t WHERE album <> '' ORDER BY " + order2 + ", album", null, 2, null);
        }
        return maybeReversed(listQuery$default, sort.reversed(1));
    }

    public static /* synthetic */ List artists$default(Library library, SortPrefs sortPrefs, int i, Object obj) {
        if ((i & 1) != 0) {
            sortPrefs = Session.INSTANCE.getSort();
        }
        return library.artists(sortPrefs);
    }

    public final List<Row> artists(SortPrefs sort) {
        String order;
        Intrinsics.checkNotNullParameter(sort, "sort");
        if (sort.byDate(2)) {
            order = "(SELECT MAX(m.ctime) FROM MEDIA_TABLE m WHERE m.artist = t.artist), sortkey";
        } else {
            order = "sortkey";
        }
        return maybeReversed(query$default(this, "SELECT artist AS row_title, '' AS row_subtitle, artist AS row_filter,\n                      (SELECT COUNT(*) FROM MEDIA_TABLE m WHERE m.artist = t.artist AND m.path <> '') AS row_count,\n                      SUBSTR(sortkey, 1, 2) AS row_sortkey\n               FROM ARTIST_TABLE t WHERE artist <> '' ORDER BY " + order + ", artist", null, 2, null), sort.reversed(2));
    }

    public static /* synthetic */ List albumArtists$default(Library library, SortPrefs sortPrefs, int i, Object obj) {
        if ((i & 1) != 0) {
            sortPrefs = Session.INSTANCE.getSort();
        }
        return library.albumArtists(sortPrefs);
    }

    public final List<Row> albumArtists(SortPrefs sort) {
        String order;
        Intrinsics.checkNotNullParameter(sort, "sort");
        if (sort.byDate(3)) {
            order = "(SELECT MAX(m.ctime) FROM MEDIA_TABLE m WHERE m.album_artist = t.album_artist), sortkey";
        } else {
            order = "sortkey";
        }
        return maybeReversed(query$default(this, "SELECT album_artist AS row_title, '' AS row_subtitle, album_artist AS row_filter,\n                      (SELECT COUNT(*) FROM MEDIA_TABLE m WHERE m.album_artist = t.album_artist AND m.path <> '') AS row_count,\n                      SUBSTR(sortkey, 1, 2) AS row_sortkey\n               FROM ALBUM_ARTIST_TABLE t WHERE album_artist <> '' ORDER BY " + order + ", album_artist", null, 2, null), sort.reversed(3));
    }

    public final List<Row> genres() {
        return query$default(this, "SELECT genre AS row_title, '' AS row_subtitle, genre AS row_filter,\n                  (SELECT COUNT(*) FROM MEDIA_TABLE m WHERE m.genre = t.genre AND m.path <> '') AS row_count\n           FROM GENRE_TABLE t WHERE genre <> '' ORDER BY sortkey, genre", null, 2, null);
    }

    public static /* synthetic */ List favourites$default(Library library, SortPrefs sortPrefs, int i, Object obj) {
        if ((i & 1) != 0) {
            sortPrefs = Session.INSTANCE.getSort();
        }
        return library.favourites(sortPrefs);
    }

    public final List<Row> favourites(SortPrefs sort) {
        Intrinsics.checkNotNullParameter(sort, "sort");
        return maybeReversed(query$default(this, "SELECT f.name AS row_title, f.artist AS row_subtitle, f.path AS row_path,\n                  f.path AS row_art_path,\n                  (SELECT m.mtime FROM MEDIA_TABLE m WHERE m.path = f.path) AS row_art_mtime,\n                  (SELECT m.size FROM MEDIA_TABLE m WHERE m.path = f.path) AS row_art_size\n           FROM FAVOURITES f ORDER BY f.added_at, f.rowid", null, 2, null), sort.getFavouritesReversed());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.String[], java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v7 */
    public final List<Row> playlists() {
        ArrayList arrayListEmptyList;
        synchronized (this.gate) {
            try {
                SQLiteDatabase sQLiteDatabase = this.db;
                if (sQLiteDatabase == 0) {
                    arrayListEmptyList = CollectionsKt.emptyList();
                } else {
                    ArrayList rows = new ArrayList();
                    try {
                        ?? r6 = 0;
                        Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name LIKE 'M3U\\_%' ESCAPE '\\' ORDER BY name", null);
                        try {
                            Cursor cursor = cursorRawQuery;
                            while (cursor.moveToNext()) {
                                String table = cursor.getString(0);
                                if (table != null) {
                                    Intrinsics.checkNotNull(table);
                                    String label = StringsKt.removePrefix(table, (CharSequence) "M3U_");
                                    int count = 0;
                                    try {
                                        Cursor cursorRawQuery2 = sQLiteDatabase.rawQuery("SELECT COUNT(*) FROM " + quoted(table), r6);
                                        try {
                                            Cursor it = cursorRawQuery2;
                                            if (it.moveToFirst()) {
                                                count = it.getInt(0);
                                            }
                                            Unit unit = Unit.INSTANCE;
                                            CloseableKt.closeFinally(cursorRawQuery2, r6);
                                        } catch (Throwable th) {
                                            try {
                                                throw th;
                                            } catch (Throwable th2) {
                                                CloseableKt.closeFinally(cursorRawQuery2, th);
                                                throw th2;
                                            }
                                        }
                                    } catch (Exception e) {
                                    }
                                    rows.add(new Row(label, "", null, table, count, null, null, 0L, 0L, null, null, 0, 4068, null));
                                    r6 = 0;
                                }
                            }
                            Unit unit2 = Unit.INSTANCE;
                            CloseableKt.closeFinally(cursorRawQuery, null);
                            arrayListEmptyList = rows;
                        } catch (Throwable th3) {
                            try {
                                throw th3;
                            } catch (Throwable th4) {
                                CloseableKt.closeFinally(cursorRawQuery, th3);
                                throw th4;
                            }
                        }
                    } catch (Exception e2) {
                        arrayListEmptyList = CollectionsKt.emptyList();
                    }
                }
            } catch (Throwable th5) {
                throw th5;
            }
        }
        return arrayListEmptyList;
    }

    public final List<Row> tracksOfAlbum(String album) {
        Intrinsics.checkNotNullParameter(album, "album");
        Pair<String, String> pairSplitAlbum = splitAlbum(album);
        String name = pairSplitAlbum.component1();
        String key = pairSplitAlbum.component2();
        return (key == null || !this.hasAlbumKeys) ? query("SELECT name AS row_title, artist AS row_subtitle, path AS row_path, album AS row_album,\n                               path AS row_art_path, mtime AS row_art_mtime, size AS row_art_size\n                        FROM MEDIA_TABLE WHERE album = ? AND path <> '' ORDER BY " + getInAlbum() + ", sortkey, rowid", new String[]{name}) : query("SELECT name AS row_title, artist AS row_subtitle, path AS row_path, album AS row_album,\n                               path AS row_art_path, mtime AS row_art_mtime, size AS row_art_size\n                        FROM MEDIA_TABLE WHERE album = ? AND album_key = ? AND path <> '' ORDER BY " + getInAlbum() + ", sortkey, rowid", new String[]{name, key});
    }

    private final List<Row> tracksOfPerson(String column, String value, SortPrefs sort) {
        String order = sort.getArtistByAlbum() ? "(SELECT a.sortkey FROM ALBUM_TABLE a WHERE a.album = m.album), album, " + getInAlbum() + ", sortkey, rowid" : "sortkey, rowid";
        return query("SELECT name AS row_title, album AS row_subtitle, path AS row_path, album AS row_album,\n                      path AS row_art_path, mtime AS row_art_mtime, size AS row_art_size\n               FROM MEDIA_TABLE m WHERE " + column + " = ? AND path <> '' ORDER BY " + order, new String[]{value});
    }

    public static /* synthetic */ List tracksOfArtist$default(Library library, String str, SortPrefs sortPrefs, int i, Object obj) {
        if ((i & 2) != 0) {
            sortPrefs = Session.INSTANCE.getSort();
        }
        return library.tracksOfArtist(str, sortPrefs);
    }

    public final List<Row> tracksOfArtist(String artist, SortPrefs sort) {
        Intrinsics.checkNotNullParameter(artist, "artist");
        Intrinsics.checkNotNullParameter(sort, "sort");
        return tracksOfPerson("artist", artist, sort);
    }

    public static /* synthetic */ List tracksOfAlbumArtist$default(Library library, String str, SortPrefs sortPrefs, int i, Object obj) {
        if ((i & 2) != 0) {
            sortPrefs = Session.INSTANCE.getSort();
        }
        return library.tracksOfAlbumArtist(str, sortPrefs);
    }

    public final List<Row> tracksOfAlbumArtist(String albumArtist, SortPrefs sort) {
        Intrinsics.checkNotNullParameter(albumArtist, "albumArtist");
        Intrinsics.checkNotNullParameter(sort, "sort");
        return tracksOfPerson("album_artist", albumArtist, sort);
    }

    public final List<Row> tracksOfGenre(String genre) {
        Intrinsics.checkNotNullParameter(genre, "genre");
        return query("SELECT name AS row_title, artist AS row_subtitle, path AS row_path, album AS row_album,\n                  path AS row_art_path, mtime AS row_art_mtime, size AS row_art_size\n           FROM MEDIA_TABLE WHERE genre = ? AND path <> '' ORDER BY sortkey, rowid", new String[]{genre});
    }

    public final List<Row> tracksOfPlaylist(String table) {
        Intrinsics.checkNotNullParameter(table, "table");
        if (!StringsKt.startsWith$default(table, "M3U_", false, 2, (Object) null)) {
            return CollectionsKt.emptyList();
        }
        return query$default(this, "SELECT p.title AS row_title, p.artist AS row_subtitle, p.path AS row_path,\n                      p.path AS row_art_path,\n                      (SELECT m.mtime FROM MEDIA_TABLE m WHERE m.path = p.path) AS row_art_mtime,\n                      (SELECT m.size FROM MEDIA_TABLE m WHERE m.path = p.path) AS row_art_size\n               FROM " + quoted(table) + " p WHERE p.path <> '' ORDER BY p.idx", null, 2, null);
    }

    private final String quoted(String table) {
        return "\"" + StringsKt.replace$default(table, "\"", "\"\"", false, 4, (Object) null) + "\"";
    }

    public final Map<String, Row> tracksByPaths(List<String> paths) {
        int i;
        Intrinsics.checkNotNullParameter(paths, "paths");
        List<String> $this$filter$iv = paths;
        Collection destination$iv$iv = new ArrayList();
        Iterator it = $this$filter$iv.iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            Object element$iv$iv = it.next();
            if ((((String) element$iv$iv).length() > 0 ? 1 : 0) != 0) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        List wanted = CollectionsKt.distinct((List) destination$iv$iv);
        if (wanted.isEmpty()) {
            return MapsKt.emptyMap();
        }
        HashMap out = new HashMap(wanted.size());
        Iterable $this$forEach$iv = CollectionsKt.chunked(wanted, 400);
        for (Object element$iv : $this$forEach$iv) {
            Collection chunk = (List) element$iv;
            String holes = CollectionsKt.joinToString$default(chunk, ",", null, null, 0, null, new Function1<String, CharSequence>() { // from class: com.mattiadoronzo.sonixlink.Library$tracksByPaths$1$holes$1
                @Override // kotlin.jvm.functions.Function1
                public final CharSequence invoke(String it2) {
                    Intrinsics.checkNotNullParameter(it2, "it");
                    return "?";
                }
            }, 30, null);
            Collection $this$toTypedArray$iv = chunk;
            Iterable $this$forEach$iv2 = query("SELECT name AS row_title, artist AS row_subtitle, path AS row_path, album AS row_album,\n                          path AS row_art_path, mtime AS row_art_mtime, size AS row_art_size\n                   FROM MEDIA_TABLE WHERE path IN (" + holes + ")", (String[]) $this$toTypedArray$iv.toArray(new String[i]));
            for (Object element$iv2 : $this$forEach$iv2) {
                Row it2 = (Row) element$iv2;
                out.put(it2.getPath(), it2);
                wanted = wanted;
            }
            i = 0;
        }
        return out;
    }

    public static /* synthetic */ List albumsMatching$default(Library library, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 30;
        }
        return library.albumsMatching(str, i);
    }

    public final List<Row> albumsMatching(String text, int limit) {
        Intrinsics.checkNotNullParameter(text, "text");
        String like = likeOf(text);
        if (like == null) {
            return CollectionsKt.emptyList();
        }
        if (this.hasAlbumKeys) {
            return query("SELECT album AS row_title, '' AS row_subtitle, album || char(31) || album_key AS row_filter,\n                          (SELECT COUNT(*) FROM MEDIA_TABLE m\n                            WHERE m.album = g.album AND m.album_key = g.album_key AND m.path <> '') AS row_count,\n                          album AS row_album\n                   FROM ALBUM_GROUP_TABLE g WHERE album LIKE ? ESCAPE '\\'\n                   ORDER BY sortkey, album, album_key LIMIT " + limit, new String[]{like});
        }
        return query("SELECT album AS row_title, '' AS row_subtitle, album AS row_filter,\n                      (SELECT COUNT(*) FROM MEDIA_TABLE m WHERE m.album = t.album AND m.path <> '') AS row_count,\n                      album AS row_album\n               FROM ALBUM_TABLE t WHERE album LIKE ? ESCAPE '\\'\n               ORDER BY sortkey, album LIMIT " + limit, new String[]{like});
    }

    public static /* synthetic */ List artistsMatching$default(Library library, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 30;
        }
        return library.artistsMatching(str, i);
    }

    public final List<Row> artistsMatching(String text, int limit) {
        Intrinsics.checkNotNullParameter(text, "text");
        String like = likeOf(text);
        return like == null ? CollectionsKt.emptyList() : query("SELECT artist AS row_title, '' AS row_subtitle, artist AS row_filter,\n                      (SELECT COUNT(*) FROM MEDIA_TABLE m WHERE m.artist = t.artist AND m.path <> '') AS row_count\n               FROM ARTIST_TABLE t WHERE artist LIKE ? ESCAPE '\\'\n               ORDER BY sortkey, artist LIMIT " + limit, new String[]{like});
    }

    private final String likeOf(String text) {
        String clean = StringsKt.trim((CharSequence) text).toString();
        if (clean.length() == 0) {
            return null;
        }
        return "%" + StringsKt.replace$default(StringsKt.replace$default(clean, "%", "\\%", false, 4, (Object) null), "_", "\\_", false, 4, (Object) null) + "%";
    }

    public static /* synthetic */ List search$default(Library library, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = MaterialCardViewHelper.DEFAULT_FADE_ANIM_DURATION;
        }
        return library.search(str, i);
    }

    public final List<Row> search(String text, int limit) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (StringsKt.isBlank(text)) {
            return CollectionsKt.emptyList();
        }
        String like = "%" + StringsKt.replace$default(StringsKt.replace$default(StringsKt.trim((CharSequence) text).toString(), "%", "\\%", false, 4, (Object) null), "_", "\\_", false, 4, (Object) null) + "%";
        return query("SELECT name AS row_title, artist AS row_subtitle, path AS row_path, album AS row_album,\n                      path AS row_art_path, mtime AS row_art_mtime, size AS row_art_size\n               FROM MEDIA_TABLE\n               WHERE path <> '' AND (name LIKE ? ESCAPE '\\' OR artist LIKE ? ESCAPE '\\'\n                                     OR album LIKE ? ESCAPE '\\')\n               ORDER BY sortkey, name LIMIT " + limit, new String[]{like, like, like});
    }
}

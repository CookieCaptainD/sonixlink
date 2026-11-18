package com.mattiadoronzo.sonixlink;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.LruCache;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.CoroutineLiveDataKt;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.p001io.CloseableKt;
import kotlin.p001io.FilesKt;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: Covers.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000\u009d\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\t\u0018\u0000 P2\u00020\u0001:\u0001PB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002022\b\u00104\u001a\u0004\u0018\u000105H\u0002J\u0006\u00106\u001a\u000207J\u0006\u00108\u001a\u000207J\b\u00109\u001a\u000207H\u0002J\b\u0010:\u001a\u000207H\u0002J\u0010\u0010;\u001a\u0004\u0018\u0001002\u0006\u0010<\u001a\u00020\u0007J\u0012\u0010=\u001a\u0004\u0018\u0001002\u0006\u0010>\u001a\u00020\u0007H\u0002J \u0010?\u001a\u0004\u0018\u0001002\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020BJ\u0014\u0010D\u001a\u0002072\f\u0010E\u001a\b\u0012\u0004\u0012\u00020F0%J\u0006\u0010G\u001a\u00020\u001dJ\u000e\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00070\u001bH\u0002J\u0010\u0010I\u001a\u0002072\u0006\u0010>\u001a\u00020\u0007H\u0002J\u0006\u0010J\u001a\u00020\u001dJ\u0014\u0010K\u001a\u0002072\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00070\u001bJ\u0016\u0010M\u001a\u0002072\f\u0010N\u001a\b\u0012\u0004\u0012\u00020&0%H\u0002J\u0010\u0010O\u001a\u0002072\u0006\u0010>\u001a\u00020\u0007H\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0016j\b\u0012\u0004\u0012\u00020\u0007`\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0016j\b\u0012\u0004\u0012\u00020\u0007`\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R4\u0010\"\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070$\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u00070-j\b\u0012\u0004\u0012\u00020\u0007`.X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Q"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/Covers;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "albumKeys", "", "", "cache", "com/mattiadoronzo/sonixlink/Covers$cache$1", "Lcom/mattiadoronzo/sonixlink/Covers$cache$1;", "databaseFile", "Ljava/io/File;", "getDatabaseFile", "()Ljava/io/File;", "db", "Landroid/database/sqlite/SQLiteDatabase;", "fetcher", "Ljava/lang/Thread;", "file", "gate", "inFlight", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "keysFile", "misses", "remote", "", "slowLink", "", "getSlowLink", "()Z", "setSlowLink", "(Z)V", "source", "Lkotlin/Function1;", "", "", "Lcom/mattiadoronzo/sonixlink/Thumb;", "getSource", "()Lkotlin/jvm/functions/Function1;", "setSource", "(Lkotlin/jvm/functions/Function1;)V", "stopped", "wanted", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "bitmapOf", "Landroid/graphics/Bitmap;", "w", "", "h", "pixels", "", "clearRemoteKeys", "", "close", "closeLocked", "fetchLoop", "forAlbum", "album", "forKey", "key", "forTrack", "path", "mtime", "", "size", "indexAlbums", "rows", "Lcom/mattiadoronzo/sonixlink/Row;", "loadRemoteKeys", "localKeys", "miss", "open", "setRemoteKeys", "keys", "store", "thumbs", "want", "Companion", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class Covers {
    private static final long BACKOFF_MS = 3000;
    public static final int BOX = 72;
    private static final int PER_ASK = 32;
    private static final int PER_ASK_SLOW = 8;
    private static final long SLOW_PAUSE_MS = 150;
    private static final int WANTED_MAX = 160;
    private Map<String, String> albumKeys;
    private final Covers$cache$1 cache;
    private SQLiteDatabase db;
    private Thread fetcher;
    private final File file;
    private final Object gate;
    private final HashSet<String> inFlight;
    private final File keysFile;
    private final HashSet<String> misses;
    private Set<String> remote;
    private volatile boolean slowLink;
    private volatile Function1<? super Collection<String>, ? extends List<Thumb>> source;
    private boolean stopped;
    private final LinkedHashSet<String> wanted;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Handler main = new Handler(Looper.getMainLooper());
    private static final LinkedHashSet<Function0<Unit>> watchers = new LinkedHashSet<>();

    /* JADX WARN: Type inference failed for: r0v4, types: [com.mattiadoronzo.sonixlink.Covers$cache$1] */
    public Covers(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.file = new File(context.getFilesDir(), "thumbnails.db");
        this.keysFile = new File(context.getFilesDir(), "thumbkeys.txt");
        this.gate = new Object();
        this.cache = new LruCache<String, Bitmap>() { // from class: com.mattiadoronzo.sonixlink.Covers$cache$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            public int sizeOf(String key, Bitmap value) {
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(value, "value");
                return 1;
            }
        };
        this.misses = new HashSet<>();
        this.wanted = new LinkedHashSet<>();
        this.inFlight = new HashSet<>();
        this.albumKeys = MapsKt.emptyMap();
    }

    /* JADX INFO: compiled from: Covers.kt */
    @Metadata(m147d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0002J2\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u001aJ\u0014\u0010\u001b\u001a\u00020\u00102\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0014\u0010\u001d\u001a\u00020\u00102\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000ej\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f`\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/Covers$Companion;", "", "()V", "BACKOFF_MS", "", "BOX", "", "PER_ASK", "PER_ASK_SLOW", "SLOW_PAUSE_MS", "WANTED_MAX", "main", "Landroid/os/Handler;", "watchers", "Ljava/util/LinkedHashSet;", "Lkotlin/Function0;", "", "Lkotlin/collections/LinkedHashSet;", "announce", "key", "", "path", "mtime", "size", "box", "isDir", "", "unwatch", "watcher", "watch", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ String key$default(Companion companion, String str, long j, long j2, int i, boolean z, int i2, Object obj) {
            return companion.key(str, j, j2, (i2 & 8) != 0 ? 72 : i, (i2 & 16) != 0 ? false : z);
        }

        public final String key(String path, long mtime, long size, int box, boolean isDir) {
            Intrinsics.checkNotNullParameter(path, "path");
            String material = path + "|" + box + "|" + (isDir ? 'd' : 'f') + "|" + mtime + "|" + size;
            long h = 1469598103934665603L;
            byte[] bytes = material.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            for (byte b : bytes) {
                h = (h ^ (((long) b) & 255)) * 1099511628211L;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(Locale.US, "%016x", Arrays.copyOf(new Object[]{Long.valueOf(h)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }

        public final void watch(Function0<Unit> watcher) {
            Intrinsics.checkNotNullParameter(watcher, "watcher");
            Covers.watchers.add(watcher);
        }

        public final void unwatch(Function0<Unit> watcher) {
            Intrinsics.checkNotNullParameter(watcher, "watcher");
            Covers.watchers.remove(watcher);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void announce() {
            Covers.main.post(new Runnable() { // from class: com.mattiadoronzo.sonixlink.Covers$Companion$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    Covers.Companion.announce$lambda$1();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void announce$lambda$1() {
            Iterable $this$forEach$iv = CollectionsKt.toList(Covers.watchers);
            for (Object element$iv : $this$forEach$iv) {
                Function0 it = (Function0) element$iv;
                it.invoke();
            }
        }
    }

    public final Function1<Collection<String>, List<Thumb>> getSource() {
        return this.source;
    }

    public final void setSource(Function1<? super Collection<String>, ? extends List<Thumb>> function1) {
        this.source = function1;
    }

    public final boolean getSlowLink() {
        return this.slowLink;
    }

    public final void setSlowLink(boolean z) {
        this.slowLink = z;
    }

    /* JADX INFO: renamed from: getDatabaseFile, reason: from getter */
    public final File getFile() {
        return this.file;
    }

    public final boolean open() {
        boolean z;
        synchronized (this.gate) {
            closeLocked();
            z = false;
            try {
                SQLiteDatabase database = SQLiteDatabase.openDatabase(this.file.getAbsolutePath(), null, 268435472);
                database.execSQL("CREATE TABLE IF NOT EXISTS thumbs(key TEXT PRIMARY KEY, w INTEGER NOT NULL, h INTEGER NOT NULL, pixels BLOB)");
                this.db = database;
                this.stopped = false;
                z = true;
            } catch (Exception e) {
                this.db = null;
            }
        }
        return z;
    }

    public final void close() {
        synchronized (this.gate) {
            this.stopped = true;
            this.wanted.clear();
            Object obj = this.gate;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Object");
            obj.notifyAll();
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
        evictAll();
        this.misses.clear();
        this.albumKeys = MapsKt.emptyMap();
    }

    public final boolean loadRemoteKeys() {
        try {
            if (!this.keysFile.exists()) {
                return false;
            }
            Iterable $this$filter$iv = FilesKt.readLines$default(this.keysFile, null, 1, null);
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                String it = (String) element$iv$iv;
                if (it.length() == 16) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            HashSet keys = CollectionsKt.toHashSet((List) destination$iv$iv);
            synchronized (this.gate) {
                this.remote = keys;
                this.misses.clear();
                Unit unit = Unit.INSTANCE;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public final void setRemoteKeys(Set<String> keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        try {
            File temporary = new File(this.keysFile.getParentFile(), this.keysFile.getName() + ".part");
            FilesKt.writeText$default(temporary, CollectionsKt.joinToString$default(keys, "\n", null, null, 0, null, null, 62, null), null, 2, null);
            if (!temporary.renameTo(this.keysFile)) {
                temporary.delete();
            }
        } catch (Exception e) {
        }
        synchronized (this.gate) {
            this.remote = keys;
            this.misses.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void clearRemoteKeys() {
        synchronized (this.gate) {
            this.remote = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void indexAlbums(List<Row> rows) {
        Intrinsics.checkNotNullParameter(rows, "rows");
        HashSet present = new HashSet(localKeys());
        synchronized (this.gate) {
            Set<String> set = this.remote;
            if (set != null) {
                Boolean.valueOf(present.addAll(set));
            }
        }
        if (present.isEmpty()) {
            synchronized (this.gate) {
                this.albumKeys = MapsKt.emptyMap();
                Unit unit = Unit.INSTANCE;
            }
            return;
        }
        HashMap map = new HashMap();
        for (Row row : rows) {
            if (!(row.getAlbum().length() == 0) && !map.containsKey(row.getAlbum())) {
                if (!(row.getArtPath().length() == 0) && row.getArtMtime() > 0 && row.getArtSize() > 0) {
                    String k = Companion.key$default(INSTANCE, row.getArtPath(), row.getArtMtime(), row.getArtSize(), 0, false, 24, null);
                    if (present.contains(k)) {
                        map.put(row.getAlbum(), k);
                    }
                }
            }
        }
        synchronized (this.gate) {
            this.albumKeys = map;
            Unit unit2 = Unit.INSTANCE;
        }
    }

    private final Set<String> localKeys() {
        Set<String> setEmptySet;
        synchronized (this.gate) {
            SQLiteDatabase database = this.db;
            if (database == null) {
                setEmptySet = SetsKt.emptySet();
            } else {
                HashSet out = new HashSet();
                try {
                    Cursor cursorRawQuery = database.rawQuery("SELECT key FROM thumbs WHERE w > 0 AND h > 0", null);
                    try {
                        Cursor cursor = cursorRawQuery;
                        while (cursor.moveToNext()) {
                            String string = cursor.getString(0);
                            if (string != null) {
                                Intrinsics.checkNotNull(string);
                                out.add(string);
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(cursorRawQuery, null);
                        setEmptySet = out;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(cursorRawQuery, th);
                            throw th2;
                        }
                    }
                } catch (Exception e) {
                    setEmptySet = SetsKt.emptySet();
                }
            }
        }
        return setEmptySet;
    }

    public final Bitmap forAlbum(String album) {
        String key;
        Intrinsics.checkNotNullParameter(album, "album");
        if (album.length() == 0) {
            return null;
        }
        synchronized (this.gate) {
            key = this.albumKeys.get(album);
        }
        if (key == null) {
            return null;
        }
        return forKey(key);
    }

    public final Bitmap forTrack(String path, long mtime, long size) {
        Intrinsics.checkNotNullParameter(path, "path");
        if ((path.length() == 0) || mtime <= 0) {
            return null;
        }
        if (size <= 0) {
            return null;
        }
        return forKey(Companion.key$default(INSTANCE, path, mtime, size, 0, false, 24, null));
    }

    /* JADX WARN: Code duplicated, block: B:32:0x007a A[Catch: all -> 0x008c, TRY_LEAVE, TryCatch #2 {, blocks: (B:5:0x0008, B:7:0x0013, B:10:0x001f, B:14:0x002a, B:19:0x0059, B:22:0x0060, B:24:0x0068, B:26:0x006c, B:31:0x0076, B:32:0x007a, B:39:0x0084, B:40:0x0087), top: B:51:0x0008 }] */
    private final Bitmap forKey(String key) {
        Bitmap cached;
        SQLiteDatabase database;
        synchronized (this.gate) {
            cached = get(key);
            if (cached == null) {
                if (this.misses.contains(key) || (database = this.db) == null) {
                    cached = null;
                } else {
                    Bitmap bitmapBitmapOf = null;
                    boolean stored = false;
                    try {
                        boolean z = true;
                        Cursor cursorRawQuery = database.rawQuery("SELECT w,h,pixels FROM thumbs WHERE key=? LIMIT 1", new String[]{key});
                        try {
                            Cursor cursor = cursorRawQuery;
                            if (cursor.moveToFirst()) {
                                stored = true;
                                bitmapBitmapOf = bitmapOf(cursor.getInt(0), cursor.getInt(1), cursor.getBlob(2));
                            }
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(cursorRawQuery, null);
                            Bitmap bitmap = bitmapBitmapOf;
                            if (bitmap != null) {
                                put(key, bitmap);
                            } else if (!stored) {
                                Set<String> set = this.remote;
                                if (set == null || !set.contains(key)) {
                                    z = false;
                                }
                                if (z) {
                                    want(key);
                                } else {
                                    miss(key);
                                }
                            } else {
                                miss(key);
                            }
                            cached = bitmap;
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                CloseableKt.closeFinally(cursorRawQuery, th);
                                throw th2;
                            }
                        }
                    } catch (Exception e) {
                        cached = null;
                    }
                }
            }
        }
        return cached;
    }

    private final Bitmap bitmapOf(int w, int h, byte[] pixels) {
        if (w <= 0 || h <= 0 || pixels == null || pixels.length < w * h * 2) {
            return null;
        }
        Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.RGB_565);
        Intrinsics.checkNotNullExpressionValue(bitmap, "createBitmap(...)");
        bitmap.copyPixelsFromBuffer(ByteBuffer.wrap(pixels, 0, w * h * 2));
        return bitmap;
    }

    private final void miss(String key) {
        if (this.misses.size() > 4000) {
            this.misses.clear();
        }
        this.misses.add(key);
    }

    private final void want(String key) {
        if (this.stopped || this.inFlight.contains(key)) {
            return;
        }
        this.wanted.remove(key);
        this.wanted.add(key);
        while (this.wanted.size() > WANTED_MAX) {
            this.wanted.remove(CollectionsKt.first(this.wanted));
        }
        if (this.fetcher == null) {
            Thread $this$want_u24lambda_u2416 = new Thread(new Runnable() { // from class: com.mattiadoronzo.sonixlink.Covers$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() throws InterruptedException {
                    Covers.want$lambda$15(this.f$0);
                }
            }, "thumbnails");
            $this$want_u24lambda_u2416.setDaemon(true);
            $this$want_u24lambda_u2416.start();
            this.fetcher = $this$want_u24lambda_u2416;
        }
        Object obj = this.gate;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Object");
        obj.notifyAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void want$lambda$15(Covers this$0) throws InterruptedException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.fetchLoop();
    }

    private final void fetchLoop() throws InterruptedException {
        List<Thumb> listInvoke;
        Iterable newest;
        while (true) {
            synchronized (this.gate) {
                while (true) {
                    listInvoke = null;
                    if (this.stopped || !(this.wanted.isEmpty() || this.source == null)) {
                        break;
                    }
                    try {
                        Object obj = this.gate;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Object");
                        obj.wait(CoroutineLiveDataKt.DEFAULT_TIMEOUT);
                    } catch (InterruptedException e) {
                        this.fetcher = null;
                        return;
                    }
                }
                if (this.stopped) {
                    this.fetcher = null;
                    return;
                } else {
                    newest = CollectionsKt.takeLast(CollectionsKt.toList(this.wanted), this.slowLink ? 8 : 32);
                    this.wanted.removeAll(CollectionsKt.toSet(newest));
                    this.inFlight.addAll((Collection) newest);
                }
            }
            Function1<? super Collection<String>, ? extends List<Thumb>> function1 = this.source;
            if (function1 != null) {
                try {
                    listInvoke = function1.invoke(newest);
                } catch (Exception e2) {
                }
            }
            synchronized (this.gate) {
                this.inFlight.removeAll(CollectionsKt.toSet(newest));
                if (listInvoke != null) {
                    store(listInvoke);
                    Iterable $this$mapTo$iv = listInvoke;
                    Collection destination$iv = new HashSet();
                    for (Object item$iv : $this$mapTo$iv) {
                        Thumb it = (Thumb) item$iv;
                        destination$iv.add(it.getKey());
                    }
                    HashSet answered = (HashSet) destination$iv;
                    Iterable $this$filter$iv = newest;
                    Collection destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv : $this$filter$iv) {
                        String it2 = (String) element$iv$iv;
                        if (!answered.contains(it2)) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                    }
                    Iterable $this$forEach$iv = (List) destination$iv$iv;
                    for (Object element$iv : $this$forEach$iv) {
                        String it3 = (String) element$iv;
                        miss(it3);
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
            if (listInvoke == null) {
                Thread.sleep(BACKOFF_MS);
            } else {
                if (!listInvoke.isEmpty()) {
                    INSTANCE.announce();
                }
                if (this.slowLink) {
                    Thread.sleep(150L);
                }
            }
        }
    }

    private final void store(List<Thumb> thumbs) {
        SQLiteDatabase database = this.db;
        if (database == null) {
            return;
        }
        try {
            database.beginTransaction();
            try {
                for (Thumb thumb : thumbs) {
                    ContentValues values = new ContentValues();
                    values.put("key", thumb.getKey());
                    values.put("w", Integer.valueOf(thumb.getW()));
                    values.put("h", Integer.valueOf(thumb.getH()));
                    values.put("pixels", thumb.getPixels());
                    database.insertWithOnConflict("thumbs", null, values, 5);
                }
                database.setTransactionSuccessful();
                database.endTransaction();
            } catch (Throwable th) {
                database.endTransaction();
                throw th;
            }
        } catch (Exception e) {
        }
        for (Thumb thumb2 : thumbs) {
            Bitmap bitmap = bitmapOf(thumb2.getW(), thumb2.getH(), thumb2.getPixels());
            if (bitmap != null) {
                put(thumb2.getKey(), bitmap);
                this.misses.remove(thumb2.getKey());
            } else {
                miss(thumb2.getKey());
            }
        }
    }
}

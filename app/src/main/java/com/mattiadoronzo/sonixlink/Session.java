package com.mattiadoronzo.sonixlink;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Session.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010<\u001a\u00020\rH\u0002J\u0006\u0010=\u001a\u00020\rJ\u000e\u0010>\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u001eJ\u0014\u0010@\u001a\u00020\r2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0014\u0010B\u001a\u00020\r2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\r0\fR$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR#\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001d0\u001c¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u001c¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00102\u001a\u0002012\u0006\u0010\u0003\u001a\u000201@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u00109\u001a\u0002082\u0006\u00107\u001a\u000208@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;¨\u0006C"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/Session;", "", "()V", "value", "", "accent", "getAccent", "()I", "setAccent", "(I)V", "accentWatchers", "Ljava/util/LinkedHashSet;", "Lkotlin/Function0;", "", "Lkotlin/collections/LinkedHashSet;", "client", "Lcom/mattiadoronzo/sonixlink/PlayerClient;", "getClient", "()Lcom/mattiadoronzo/sonixlink/PlayerClient;", "setClient", "(Lcom/mattiadoronzo/sonixlink/PlayerClient;)V", "covers", "Lcom/mattiadoronzo/sonixlink/Covers;", "getCovers", "()Lcom/mattiadoronzo/sonixlink/Covers;", "setCovers", "(Lcom/mattiadoronzo/sonixlink/Covers;)V", "heldFavourite", "Lcom/mattiadoronzo/sonixlink/Held;", "Lkotlin/Pair;", "", "", "getHeldFavourite", "()Lcom/mattiadoronzo/sonixlink/Held;", "heldMode", "Lcom/mattiadoronzo/sonixlink/PlayMode;", "getHeldMode", "library", "Lcom/mattiadoronzo/sonixlink/Library;", "getLibrary", "()Lcom/mattiadoronzo/sonixlink/Library;", "setLibrary", "(Lcom/mattiadoronzo/sonixlink/Library;)V", "sort", "Lcom/mattiadoronzo/sonixlink/SortPrefs;", "getSort", "()Lcom/mattiadoronzo/sonixlink/SortPrefs;", "setSort", "(Lcom/mattiadoronzo/sonixlink/SortPrefs;)V", "Lcom/mattiadoronzo/sonixlink/PlayerState;", "state", "getState", "()Lcom/mattiadoronzo/sonixlink/PlayerState;", "setState", "(Lcom/mattiadoronzo/sonixlink/PlayerState;)V", "<set-?>", "", "stateAt", "getStateAt", "()J", "announceAccent", "clear", "parseAccent", "text", "unwatchAccent", "watcher", "watchAccent", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class Session {
    private static volatile PlayerClient client;
    private static volatile Covers covers;
    private static volatile Library library;
    private static volatile long stateAt;
    public static final Session INSTANCE = new Session();
    private static volatile PlayerState state = PlayerState.INSTANCE.getEMPTY();
    private static volatile SortPrefs sort = new SortPrefs(0, 0, false, false, 15, null);
    private static final Held<PlayMode> heldMode = new Held<>(0, 1, null);
    private static final Held<Pair<String, Boolean>> heldFavourite = new Held<>(0, 1, null);
    private static int accent = -13269788;
    private static final LinkedHashSet<Function0<Unit>> accentWatchers = new LinkedHashSet<>();

    private Session() {
    }

    public final PlayerClient getClient() {
        return client;
    }

    public final void setClient(PlayerClient playerClient) {
        client = playerClient;
    }

    public final Library getLibrary() {
        return library;
    }

    public final void setLibrary(Library library2) {
        library = library2;
    }

    public final Covers getCovers() {
        return covers;
    }

    public final void setCovers(Covers covers2) {
        covers = covers2;
    }

    public final PlayerState getState() {
        return state;
    }

    public final void setState(PlayerState value) {
        Intrinsics.checkNotNullParameter(value, "value");
        state = value;
        stateAt = SystemClock.elapsedRealtime();
    }

    public final long getStateAt() {
        return stateAt;
    }

    public final SortPrefs getSort() {
        return sort;
    }

    public final void setSort(SortPrefs sortPrefs) {
        Intrinsics.checkNotNullParameter(sortPrefs, "<set-?>");
        sort = sortPrefs;
    }

    public final Held<PlayMode> getHeldMode() {
        return heldMode;
    }

    public final Held<Pair<String, Boolean>> getHeldFavourite() {
        return heldFavourite;
    }

    public final int getAccent() {
        return accent;
    }

    public final void setAccent(int value) {
        if (accent == value) {
            return;
        }
        accent = value;
        announceAccent();
    }

    public final void watchAccent(Function0<Unit> watcher) {
        Intrinsics.checkNotNullParameter(watcher, "watcher");
        accentWatchers.add(watcher);
    }

    public final void unwatchAccent(Function0<Unit> watcher) {
        Intrinsics.checkNotNullParameter(watcher, "watcher");
        accentWatchers.remove(watcher);
    }

    private final void announceAccent() {
        Looper main = Looper.getMainLooper();
        if (Intrinsics.areEqual(Looper.myLooper(), main)) {
            Iterable $this$forEach$iv = CollectionsKt.toList(accentWatchers);
            for (Object element$iv : $this$forEach$iv) {
                Function0 it = (Function0) element$iv;
                it.invoke();
            }
            return;
        }
        new Handler(main).post(new Runnable() { // from class: com.mattiadoronzo.sonixlink.Session$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Session.announceAccent$lambda$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void announceAccent$lambda$2() {
        Iterable $this$forEach$iv = CollectionsKt.toList(accentWatchers);
        for (Object element$iv : $this$forEach$iv) {
            Function0 it = (Function0) element$iv;
            it.invoke();
        }
    }

    public final int parseAccent(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        String hex = StringsKt.removePrefix(StringsKt.trim((CharSequence) text).toString(), (CharSequence) "#");
        if (hex.length() != 6) {
            return accent;
        }
        try {
            return Integer.parseInt(hex, CharsKt.checkRadix(16)) | ViewCompat.MEASURED_STATE_MASK;
        } catch (NumberFormatException e) {
            return accent;
        }
    }

    public final void clear() {
        Library library2 = library;
        if (library2 != null) {
            library2.close();
        }
        library = null;
        Covers covers2 = covers;
        if (covers2 != null) {
            covers2.close();
        }
        covers = null;
        client = null;
        setState(PlayerState.INSTANCE.getEMPTY());
        Artwork.INSTANCE.clear();
    }
}

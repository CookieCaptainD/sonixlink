package com.mattiadoronzo.sonixlink;

import android.os.SystemClock;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: Artwork.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u0014J&\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000e2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\rj\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/Artwork;", "", "()V", "BLUETOOTH_SIDE", "", "KEEP", "PENDING_GIVE_UP_MS", "", "PENDING_RETRY_MS", "WIFI_SIDE", "fetching", "", "kept", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/collections/LinkedHashMap;", "lock", "Ljava/lang/Object;", "clear", "", "get", "client", "Lcom/mattiadoronzo/sonixlink/PlayerClient;", "path", "stillWanted", "Lkotlin/Function0;", "Stale", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class Artwork {
    public static final int BLUETOOTH_SIDE = 640;
    private static final int KEEP = 4;
    private static final long PENDING_GIVE_UP_MS = 15000;
    private static final long PENDING_RETRY_MS = 200;
    public static final int WIFI_SIDE = 1080;
    private static boolean fetching;
    public static final Artwork INSTANCE = new Artwork();
    private static final Object lock = new Object();
    private static final LinkedHashMap<String, byte[]> kept = new LinkedHashMap<>();

    private Artwork() {
    }

    /* JADX INFO: compiled from: Artwork.kt */
    @Metadata(m147d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/Artwork$Stale;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "()V", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Stale extends Exception {
        public Stale() {
            super("the track has changed");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [T, byte[]] */
    public final byte[] get(PlayerClient client, String path, Function0<Boolean> stillWanted) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(stillWanted, "stillWanted");
        synchronized (lock) {
            while (!kept.containsKey(path)) {
                if (!stillWanted.invoke().booleanValue()) {
                    throw new Stale();
                }
                if (fetching) {
                    Object obj = lock;
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Object");
                    obj.wait(250L);
                } else {
                    fetching = true;
                    Unit unit = Unit.INSTANCE;
                    try {
                        int side = client.isBluetooth() ? BLUETOOTH_SIDE : WIFI_SIDE;
                        long started = SystemClock.uptimeMillis();
                        Ref.ObjectRef bytes = new Ref.ObjectRef();
                        while (true) {
                            try {
                                bytes.element = client.artwork(path, side);
                                synchronized (lock) {
                                    kept.put(path, bytes.element);
                                    while (kept.size() > 4) {
                                        LinkedHashMap<String, byte[]> linkedHashMap = kept;
                                        Set<String> setKeySet = kept.keySet();
                                        Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
                                        linkedHashMap.remove(CollectionsKt.first(setKeySet));
                                    }
                                    Unit unit2 = Unit.INSTANCE;
                                }
                                byte[] bArr = (byte[]) bytes.element;
                                synchronized (lock) {
                                    fetching = false;
                                    Object obj2 = lock;
                                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type java.lang.Object");
                                    obj2.notifyAll();
                                    Unit unit3 = Unit.INSTANCE;
                                }
                                return bArr;
                            } catch (ArtPending e) {
                                if (!stillWanted.invoke().booleanValue()) {
                                    throw new Stale();
                                }
                                if (SystemClock.uptimeMillis() - started > PENDING_GIVE_UP_MS) {
                                    throw e;
                                }
                                Thread.sleep(PENDING_RETRY_MS);
                            }
                        }
                    } catch (Throwable th) {
                        synchronized (lock) {
                            fetching = false;
                            Object obj3 = lock;
                            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type java.lang.Object");
                            obj3.notifyAll();
                            Unit unit4 = Unit.INSTANCE;
                            throw th;
                        }
                    }
                }
            }
            byte[] bytes2 = kept.remove(path);
            kept.put(path, bytes2);
            return bytes2;
        }
    }

    public final void clear() {
        synchronized (lock) {
            kept.clear();
            Unit unit = Unit.INSTANCE;
        }
    }
}

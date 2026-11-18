package com.mattiadoronzo.sonixlink;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Models.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\r\u001a\u00020\u0000R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/PlayMode;", "", "wire", "", "label", "", "icon", "(Ljava/lang/String;ILjava/lang/String;II)V", "getIcon", "()I", "getLabel", "getWire", "()Ljava/lang/String;", "next", "NORMAL", "REPEAT_ALL", "REPEAT_ONE", "SHUFFLE", "SHUFFLE_REPEAT", "Companion", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public enum PlayMode {
    NORMAL("normal", C1020R.string.mode_normal, C1020R.drawable.ic_repeat_off),
    REPEAT_ALL("repeat_all", C1020R.string.mode_repeat_all, C1020R.drawable.ic_repeat),
    REPEAT_ONE("repeat_one", C1020R.string.mode_repeat_one, C1020R.drawable.ic_repeat_one),
    SHUFFLE("shuffle", C1020R.string.mode_shuffle, C1020R.drawable.ic_shuffle),
    SHUFFLE_REPEAT("shuffle_repeat", C1020R.string.mode_shuffle_repeat, C1020R.drawable.ic_shuffle_repeat);

    private final int icon;
    private final int label;
    private final String wire;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public static EnumEntries<PlayMode> getEntries() {
        return $ENTRIES;
    }

    PlayMode(String wire, int label, int icon) {
        this.wire = wire;
        this.label = label;
        this.icon = icon;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final int getLabel() {
        return this.label;
    }

    public final String getWire() {
        return this.wire;
    }

    public final PlayMode next() {
        return getEntries().get((ordinal() + 1) % getEntries().size());
    }

    /* JADX INFO: compiled from: Models.kt */
    @Metadata(m147d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/PlayMode$Companion;", "", "()V", "fromWire", "Lcom/mattiadoronzo/sonixlink/PlayMode;", "value", "", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PlayMode fromWire(String value) {
            Object element$iv;
            PlayMode it;
            Intrinsics.checkNotNullParameter(value, "value");
            Iterable $this$firstOrNull$iv = PlayMode.getEntries();
            Iterator<PlayMode> it2 = $this$firstOrNull$iv.iterator();
            do {
                if (!it2.hasNext()) {
                    element$iv = null;
                    break;
                }
                element$iv = it2.next();
                it = (PlayMode) element$iv;
            } while (!Intrinsics.areEqual(it.getWire(), value));
            PlayMode playMode = (PlayMode) element$iv;
            return playMode == null ? PlayMode.NORMAL : playMode;
        }
    }
}

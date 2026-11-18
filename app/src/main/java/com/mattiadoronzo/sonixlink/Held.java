package com.mattiadoronzo.sonixlink;

import android.os.SystemClock;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Held.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0010"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/Held;", "T", "", "holdMs", "", "(J)V", "until", "value", "Ljava/lang/Object;", "resolve", "fromPlayer", "(Ljava/lang/Object;)Ljava/lang/Object;", "set", "", "wanted", "(Ljava/lang/Object;)V", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class Held<T> {
    private final long holdMs;
    private long until;
    private T value;

    public Held() {
        this(0L, 1, null);
    }

    public Held(long holdMs) {
        this.holdMs = holdMs;
    }

    public /* synthetic */ Held(long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 3000L : j);
    }

    public final void set(T wanted) {
        this.value = wanted;
        this.until = SystemClock.uptimeMillis() + this.holdMs;
    }

    public final T resolve(T fromPlayer) {
        T t = this.value;
        if (t == null) {
            return fromPlayer;
        }
        if (Intrinsics.areEqual(t, fromPlayer) || SystemClock.uptimeMillis() > this.until) {
            this.value = null;
            return fromPlayer;
        }
        return t;
    }
}

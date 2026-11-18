package com.mattiadoronzo.sonixlink;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlayerClient.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003J\t\u0010\u001d\u001a\u00020\fHÆ\u0003JK\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006#"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/QueueWindow;", "", "count", "", "position", "first", "paths", "", "", "revision", "", "pending", "", "(IIILjava/util/List;JZ)V", "getCount", "()I", "getFirst", "getPaths", "()Ljava/util/List;", "getPending", "()Z", "getPosition", "getRevision", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class QueueWindow {
    private final int count;
    private final int first;
    private final List<String> paths;
    private final boolean pending;
    private final int position;
    private final long revision;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QueueWindow copy$default(QueueWindow queueWindow, int i, int i2, int i3, List list, long j, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = queueWindow.count;
        }
        if ((i4 & 2) != 0) {
            i2 = queueWindow.position;
        }
        int i5 = i2;
        if ((i4 & 4) != 0) {
            i3 = queueWindow.first;
        }
        int i6 = i3;
        if ((i4 & 8) != 0) {
            list = queueWindow.paths;
        }
        List list2 = list;
        if ((i4 & 16) != 0) {
            j = queueWindow.revision;
        }
        long j2 = j;
        if ((i4 & 32) != 0) {
            z = queueWindow.pending;
        }
        return queueWindow.copy(i, i5, i6, list2, j2, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getFirst() {
        return this.first;
    }

    public final List<String> component4() {
        return this.paths;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getRevision() {
        return this.revision;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getPending() {
        return this.pending;
    }

    public final QueueWindow copy(int count, int position, int first, List<String> paths, long revision, boolean pending) {
        Intrinsics.checkNotNullParameter(paths, "paths");
        return new QueueWindow(count, position, first, paths, revision, pending);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QueueWindow)) {
            return false;
        }
        QueueWindow queueWindow = (QueueWindow) other;
        return this.count == queueWindow.count && this.position == queueWindow.position && this.first == queueWindow.first && Intrinsics.areEqual(this.paths, queueWindow.paths) && this.revision == queueWindow.revision && this.pending == queueWindow.pending;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.count) * 31) + Integer.hashCode(this.position)) * 31) + Integer.hashCode(this.first)) * 31) + this.paths.hashCode()) * 31) + Long.hashCode(this.revision)) * 31) + Boolean.hashCode(this.pending);
    }

    public String toString() {
        return "QueueWindow(count=" + this.count + ", position=" + this.position + ", first=" + this.first + ", paths=" + this.paths + ", revision=" + this.revision + ", pending=" + this.pending + ")";
    }

    public QueueWindow(int count, int position, int first, List<String> paths, long revision, boolean pending) {
        Intrinsics.checkNotNullParameter(paths, "paths");
        this.count = count;
        this.position = position;
        this.first = first;
        this.paths = paths;
        this.revision = revision;
        this.pending = pending;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ QueueWindow(int i, int i2, int i3, List list, long j, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        long j2;
        boolean z2;
        if ((i4 & 16) == 0) {
            j2 = j;
        } else {
            j2 = -1;
        }
        if ((i4 & 32) == 0) {
            z2 = z;
        } else {
            z2 = false;
        }
        this(i, i2, i3, list, j2, z2);
    }

    public final int getCount() {
        return this.count;
    }

    public final int getPosition() {
        return this.position;
    }

    public final int getFirst() {
        return this.first;
    }

    public final List<String> getPaths() {
        return this.paths;
    }

    public final long getRevision() {
        return this.revision;
    }

    public final boolean getPending() {
        return this.pending;
    }
}

package com.mattiadoronzo.sonixlink;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Models.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001:\u00017By\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b¢\u0006\u0002\u0010\u0012J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u000fHÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\bHÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\fHÆ\u0003J\t\u00101\u001a\u00020\fHÆ\u0003J\u0081\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\bHÆ\u0001J\u0013\u00103\u001a\u00020\u001e2\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u00020\bHÖ\u0001J\t\u00106\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u0011\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\u001d\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001fR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0014¨\u00068"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/Row;", "", "title", "", "subtitle", "path", "filter", "count", "", "album", "artPath", "artMtime", "", "artSize", "kind", "Lcom/mattiadoronzo/sonixlink/Row$Kind;", "sortKey", "iconRes", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;JJLcom/mattiadoronzo/sonixlink/Row$Kind;Ljava/lang/String;I)V", "getAlbum", "()Ljava/lang/String;", "getArtMtime", "()J", "getArtPath", "getArtSize", "getCount", "()I", "getFilter", "getIconRes", "isTrack", "", "()Z", "getKind", "()Lcom/mattiadoronzo/sonixlink/Row$Kind;", "getPath", "getSortKey", "getSubtitle", "getTitle", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "Kind", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class Row {
    private final String album;
    private final long artMtime;
    private final String artPath;
    private final long artSize;
    private final int count;
    private final String filter;
    private final int iconRes;
    private final Kind kind;
    private final String path;
    private final String sortKey;
    private final String subtitle;
    private final String title;

    /* JADX INFO: compiled from: Models.kt */
    @Metadata(m147d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/Row$Kind;", "", "(Ljava/lang/String;I)V", "ROW", "HEADER", "PENDING", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public enum Kind {
        ROW,
        HEADER,
        PENDING;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<Kind> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Kind getKind() {
        return this.kind;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getSortKey() {
        return this.sortKey;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final int getIconRes() {
        return this.iconRes;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSubtitle() {
        return this.subtitle;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getFilter() {
        return this.filter;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getAlbum() {
        return this.album;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getArtPath() {
        return this.artPath;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final long getArtMtime() {
        return this.artMtime;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final long getArtSize() {
        return this.artSize;
    }

    public final Row copy(String title, String subtitle, String path, String filter, int count, String album, String artPath, long artMtime, long artSize, Kind kind, String sortKey, int iconRes) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(filter, "filter");
        Intrinsics.checkNotNullParameter(album, "album");
        Intrinsics.checkNotNullParameter(artPath, "artPath");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(sortKey, "sortKey");
        return new Row(title, subtitle, path, filter, count, album, artPath, artMtime, artSize, kind, sortKey, iconRes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Row)) {
            return false;
        }
        Row row = (Row) other;
        return Intrinsics.areEqual(this.title, row.title) && Intrinsics.areEqual(this.subtitle, row.subtitle) && Intrinsics.areEqual(this.path, row.path) && Intrinsics.areEqual(this.filter, row.filter) && this.count == row.count && Intrinsics.areEqual(this.album, row.album) && Intrinsics.areEqual(this.artPath, row.artPath) && this.artMtime == row.artMtime && this.artSize == row.artSize && this.kind == row.kind && Intrinsics.areEqual(this.sortKey, row.sortKey) && this.iconRes == row.iconRes;
    }

    public int hashCode() {
        return (((((((((((((((((((((this.title.hashCode() * 31) + this.subtitle.hashCode()) * 31) + this.path.hashCode()) * 31) + this.filter.hashCode()) * 31) + Integer.hashCode(this.count)) * 31) + this.album.hashCode()) * 31) + this.artPath.hashCode()) * 31) + Long.hashCode(this.artMtime)) * 31) + Long.hashCode(this.artSize)) * 31) + this.kind.hashCode()) * 31) + this.sortKey.hashCode()) * 31) + Integer.hashCode(this.iconRes);
    }

    public String toString() {
        return "Row(title=" + this.title + ", subtitle=" + this.subtitle + ", path=" + this.path + ", filter=" + this.filter + ", count=" + this.count + ", album=" + this.album + ", artPath=" + this.artPath + ", artMtime=" + this.artMtime + ", artSize=" + this.artSize + ", kind=" + this.kind + ", sortKey=" + this.sortKey + ", iconRes=" + this.iconRes + ")";
    }

    public Row(String title, String subtitle, String path, String filter, int count, String album, String artPath, long artMtime, long artSize, Kind kind, String sortKey, int iconRes) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(filter, "filter");
        Intrinsics.checkNotNullParameter(album, "album");
        Intrinsics.checkNotNullParameter(artPath, "artPath");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(sortKey, "sortKey");
        this.title = title;
        this.subtitle = subtitle;
        this.path = path;
        this.filter = filter;
        this.count = count;
        this.album = album;
        this.artPath = artPath;
        this.artMtime = artMtime;
        this.artSize = artSize;
        this.kind = kind;
        this.sortKey = sortKey;
        this.iconRes = iconRes;
    }

    public /* synthetic */ Row(String str, String str2, String str3, String str4, int i, String str5, String str6, long j, long j2, Kind kind, String str7, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? 0 : i, (i3 & 32) != 0 ? "" : str5, (i3 & 64) != 0 ? "" : str6, (i3 & 128) != 0 ? 0L : j, (i3 & 256) != 0 ? 0L : j2, (i3 & 512) != 0 ? Kind.ROW : kind, (i3 & 1024) != 0 ? "" : str7, (i3 & 2048) != 0 ? 0 : i2);
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getFilter() {
        return this.filter;
    }

    public final int getCount() {
        return this.count;
    }

    public final String getAlbum() {
        return this.album;
    }

    public final String getArtPath() {
        return this.artPath;
    }

    public final long getArtMtime() {
        return this.artMtime;
    }

    public final long getArtSize() {
        return this.artSize;
    }

    public final Kind getKind() {
        return this.kind;
    }

    public final String getSortKey() {
        return this.sortKey;
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    public final boolean isTrack() {
        return this.path.length() > 0;
    }
}

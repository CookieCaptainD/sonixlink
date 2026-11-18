package com.mattiadoronzo.sonixlink;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* JADX INFO: compiled from: Models.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001d"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/SortPrefs;", "", "desc", "", "added", "artistByAlbum", "", "favouritesReversed", "(IIZZ)V", "getAdded", "()I", "getArtistByAlbum", "()Z", "getDesc", "getFavouritesReversed", "byDate", "kind", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "reversed", "toString", "", "Companion", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class SortPrefs {
    public static final int ALBUMS = 1;
    public static final int ALBUM_ARTISTS = 3;
    public static final int ARTISTS = 2;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int TRACKS = 0;
    private final int added;
    private final boolean artistByAlbum;
    private final int desc;
    private final boolean favouritesReversed;

    public SortPrefs() {
        this(0, 0, false, false, 15, null);
    }

    public static /* synthetic */ SortPrefs copy$default(SortPrefs sortPrefs, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = sortPrefs.desc;
        }
        if ((i3 & 2) != 0) {
            i2 = sortPrefs.added;
        }
        if ((i3 & 4) != 0) {
            z = sortPrefs.artistByAlbum;
        }
        if ((i3 & 8) != 0) {
            z2 = sortPrefs.favouritesReversed;
        }
        return sortPrefs.copy(i, i2, z, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getDesc() {
        return this.desc;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getAdded() {
        return this.added;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getArtistByAlbum() {
        return this.artistByAlbum;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getFavouritesReversed() {
        return this.favouritesReversed;
    }

    public final SortPrefs copy(int desc, int added, boolean artistByAlbum, boolean favouritesReversed) {
        return new SortPrefs(desc, added, artistByAlbum, favouritesReversed);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SortPrefs)) {
            return false;
        }
        SortPrefs sortPrefs = (SortPrefs) other;
        return this.desc == sortPrefs.desc && this.added == sortPrefs.added && this.artistByAlbum == sortPrefs.artistByAlbum && this.favouritesReversed == sortPrefs.favouritesReversed;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.desc) * 31) + Integer.hashCode(this.added)) * 31) + Boolean.hashCode(this.artistByAlbum)) * 31) + Boolean.hashCode(this.favouritesReversed);
    }

    public String toString() {
        return "SortPrefs(desc=" + this.desc + ", added=" + this.added + ", artistByAlbum=" + this.artistByAlbum + ", favouritesReversed=" + this.favouritesReversed + ")";
    }

    public SortPrefs(int desc, int added, boolean artistByAlbum, boolean favouritesReversed) {
        this.desc = desc;
        this.added = added;
        this.artistByAlbum = artistByAlbum;
        this.favouritesReversed = favouritesReversed;
    }

    public /* synthetic */ SortPrefs(int i, int i2, boolean z, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? false : z, (i3 & 8) != 0 ? false : z2);
    }

    public final int getDesc() {
        return this.desc;
    }

    public final int getAdded() {
        return this.added;
    }

    public final boolean getArtistByAlbum() {
        return this.artistByAlbum;
    }

    public final boolean getFavouritesReversed() {
        return this.favouritesReversed;
    }

    public final boolean reversed(int kind) {
        return (this.desc & (1 << kind)) != 0;
    }

    public final boolean byDate(int kind) {
        return (this.added & (1 << kind)) != 0;
    }

    /* JADX INFO: compiled from: Models.kt */
    @Metadata(m147d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/SortPrefs$Companion;", "", "()V", "ALBUMS", "", "ALBUM_ARTISTS", "ARTISTS", "TRACKS", "fromJson", "Lcom/mattiadoronzo/sonixlink/SortPrefs;", "json", "Lorg/json/JSONObject;", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SortPrefs fromJson(JSONObject json) {
            if (json == null) {
                return null;
            }
            return new SortPrefs(json.optInt("desc", 0), json.optInt("added", 0), json.optBoolean("artist_by_album", false), json.optBoolean("favourites_reversed", false));
        }
    }
}

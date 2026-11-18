package com.mattiadoronzo.sonixlink;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: Models.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/Section;", "", "titleRes", "", "icon", "(Ljava/lang/String;III)V", "getIcon", "()I", "getTitleRes", "TRACKS", "ALBUMS", "ARTISTS", "ALBUM_ARTISTS", "PLAYLISTS", "FAVOURITES", "FOLDERS", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public enum Section {
    TRACKS(C1020R.string.tab_tracks, C1020R.drawable.ic_track),
    ALBUMS(C1020R.string.tab_albums, C1020R.drawable.ic_album),
    ARTISTS(C1020R.string.tab_artists, C1020R.drawable.ic_artist),
    ALBUM_ARTISTS(C1020R.string.tab_album_artists, C1020R.drawable.ic_album_artist),
    PLAYLISTS(C1020R.string.tab_playlists, C1020R.drawable.ic_playlist),
    FAVOURITES(C1020R.string.tab_favourites, C1020R.drawable.ic_favourite),
    FOLDERS(C1020R.string.tab_folders, C1020R.drawable.ic_folder);

    private final int icon;
    private final int titleRes;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<Section> getEntries() {
        return $ENTRIES;
    }

    Section(int titleRes, int icon) {
        this.titleRes = titleRes;
        this.icon = icon;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final int getTitleRes() {
        return this.titleRes;
    }
}

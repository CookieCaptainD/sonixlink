package com.mattiadoronzo.sonixlink;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: LiveLists.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¨\u0006\u000e"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/LiveLists;", "", "()V", "favourites", "", "Lcom/mattiadoronzo/sonixlink/Row;", "library", "Lcom/mattiadoronzo/sonixlink/Library;", "playlistTracks", "table", "", "playlists", "withIndex", "rows", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class LiveLists {
    public static final LiveLists INSTANCE = new LiveLists();

    private LiveLists() {
    }

    public final List<Row> favourites(Library library) {
        List<Row> listFavourites;
        Intrinsics.checkNotNullParameter(library, "library");
        try {
            PlayerClient client = Session.INSTANCE.getClient();
            listFavourites = client != null ? client.favourites() : null;
        } catch (Exception e) {
            listFavourites = null;
        }
        if (listFavourites != null) {
            List<Row> list = listFavourites;
            return withIndex(library, Session.INSTANCE.getSort().getFavouritesReversed() ? list : CollectionsKt.asReversed(list));
        }
        return Library.favourites$default(library, null, 1, null);
    }

    public final List<Row> playlists(Library library) {
        List<Row> listPlaylists;
        try {
            PlayerClient client = Session.INSTANCE.getClient();
            listPlaylists = client != null ? client.playlists() : null;
        } catch (Exception e) {
            listPlaylists = null;
        }
        if (listPlaylists != null) {
            List<Row> list = listPlaylists;
            final Collator $this$playlists_u24lambda_u240 = Collator.getInstance();
            $this$playlists_u24lambda_u240.setStrength(0);
            final Function2<Row, Row, Integer> function2 = new Function2<Row, Row, Integer>() { // from class: com.mattiadoronzo.sonixlink.LiveLists.playlists.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Integer invoke(Row a, Row b) {
                    return Integer.valueOf($this$playlists_u24lambda_u240.compare(a.getTitle(), b.getTitle()));
                }
            };
            return CollectionsKt.sortedWith(list, new Comparator() { // from class: com.mattiadoronzo.sonixlink.LiveLists$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return LiveLists.playlists$lambda$1(function2, obj, obj2);
                }
            });
        }
        List<Row> listPlaylists2 = library != null ? library.playlists() : null;
        return listPlaylists2 == null ? CollectionsKt.emptyList() : listPlaylists2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int playlists$lambda$1(Function2 tmp0, Object p0, Object p1) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(p0, p1)).intValue();
    }

    public final List<Row> playlistTracks(Library library, String table) {
        List<Row> listPlaylistTracks;
        Intrinsics.checkNotNullParameter(table, "table");
        try {
            PlayerClient client = Session.INSTANCE.getClient();
            listPlaylistTracks = client != null ? client.playlistTracks(StringsKt.removePrefix(table, (CharSequence) "M3U_")) : null;
        } catch (Exception e) {
            listPlaylistTracks = null;
        }
        if (listPlaylistTracks != null) {
            List<Row> list = listPlaylistTracks;
            return library == null ? list : withIndex(library, list);
        }
        List<Row> listTracksOfPlaylist = library != null ? library.tracksOfPlaylist(table) : null;
        return listTracksOfPlaylist == null ? CollectionsKt.emptyList() : listTracksOfPlaylist;
    }

    private final List<Row> withIndex(Library library, List<Row> rows) {
        Row rowCopy;
        List<Row> $this$map$iv = rows;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Row it = (Row) item$iv$iv;
            destination$iv$iv.add(it.getPath());
        }
        Map<String, Row> mapTracksByPaths = library.tracksByPaths((List) destination$iv$iv);
        List<Row> $this$map$iv2 = rows;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            Row row = (Row) item$iv$iv2;
            Row indexed = mapTracksByPaths.get(row.getPath());
            if (indexed == null) {
                rowCopy = row;
            } else {
                rowCopy = row.copy((3615 & 1) != 0 ? row.title : null, (3615 & 2) != 0 ? row.subtitle : null, (3615 & 4) != 0 ? row.path : null, (3615 & 8) != 0 ? row.filter : null, (3615 & 16) != 0 ? row.count : 0, (3615 & 32) != 0 ? row.album : indexed.getAlbum(), (3615 & 64) != 0 ? row.artPath : indexed.getArtPath(), (3615 & 128) != 0 ? row.artMtime : indexed.getArtMtime(), (3615 & 256) != 0 ? row.artSize : indexed.getArtSize(), (3615 & 512) != 0 ? row.kind : null, (3615 & 1024) != 0 ? row.sortKey : null, (3615 & 2048) != 0 ? row.iconRes : 0);
            }
            destination$iv$iv2.add(rowCopy);
        }
        return (List) destination$iv$iv2;
    }
}

package com.mattiadoronzo.sonixlink;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Playmark.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\"\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f¨\u0006\u0010"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/Playmark;", "", "()V", "album", "", "row", "Lcom/mattiadoronzo/sonixlink/Row;", "state", "Lcom/mattiadoronzo/sonixlink/PlayerState;", "albumArtist", "artist", "byIcon", "forSection", "Lkotlin/Function2;", "section", "Lcom/mattiadoronzo/sonixlink/Section;", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class Playmark {
    public static final Playmark INSTANCE = new Playmark();

    /* JADX INFO: compiled from: Playmark.kt */
    @Metadata(m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Section.values().length];
            try {
                iArr[Section.ALBUMS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Section.ARTISTS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Section.ALBUM_ARTISTS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private Playmark() {
    }

    public final boolean album(Row row, PlayerState state) {
        Intrinsics.checkNotNullParameter(row, "row");
        Intrinsics.checkNotNullParameter(state, "state");
        if (state.getAlbum().length() > 0) {
            String album = row.getAlbum();
            if (album.length() == 0) {
                album = row.getTitle();
            }
            if (Intrinsics.areEqual(album, state.getAlbum())) {
                return true;
            }
        }
        return false;
    }

    public final boolean artist(Row row, PlayerState state) {
        Intrinsics.checkNotNullParameter(row, "row");
        Intrinsics.checkNotNullParameter(state, "state");
        return (state.getArtist().length() > 0) && Intrinsics.areEqual(row.getFilter(), state.getArtist());
    }

    public final boolean albumArtist(Row row, PlayerState state) {
        Intrinsics.checkNotNullParameter(row, "row");
        Intrinsics.checkNotNullParameter(state, "state");
        String albumArtist = state.getAlbumArtist();
        if (albumArtist.length() == 0) {
            albumArtist = state.getArtist();
        }
        String credited = albumArtist;
        return (credited.length() > 0) && Intrinsics.areEqual(row.getFilter(), credited);
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.Playmark$forSection$1 */
    /* JADX INFO: compiled from: Playmark.kt */
    @Metadata(m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* synthetic */ class C09971 extends FunctionReferenceImpl implements Function2<Row, PlayerState, Boolean> {
        C09971(Object obj) {
            super(2, obj, Playmark.class, "album", "album(Lcom/mattiadoronzo/sonixlink/Row;Lcom/mattiadoronzo/sonixlink/PlayerState;)Z", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Boolean invoke(Row p0, PlayerState p1) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            return Boolean.valueOf(((Playmark) this.receiver).album(p0, p1));
        }
    }

    public final Function2<Row, PlayerState, Boolean> forSection(Section section) {
        Intrinsics.checkNotNullParameter(section, "section");
        switch (WhenMappings.$EnumSwitchMapping$0[section.ordinal()]) {
            case 1:
                return new C09971(this);
            case 2:
                return new C09982(this);
            case 3:
                return new C09993(this);
            default:
                return null;
        }
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.Playmark$forSection$2 */
    /* JADX INFO: compiled from: Playmark.kt */
    @Metadata(m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* synthetic */ class C09982 extends FunctionReferenceImpl implements Function2<Row, PlayerState, Boolean> {
        C09982(Object obj) {
            super(2, obj, Playmark.class, "artist", "artist(Lcom/mattiadoronzo/sonixlink/Row;Lcom/mattiadoronzo/sonixlink/PlayerState;)Z", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Boolean invoke(Row p0, PlayerState p1) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            return Boolean.valueOf(((Playmark) this.receiver).artist(p0, p1));
        }
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.Playmark$forSection$3 */
    /* JADX INFO: compiled from: Playmark.kt */
    @Metadata(m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* synthetic */ class C09993 extends FunctionReferenceImpl implements Function2<Row, PlayerState, Boolean> {
        C09993(Object obj) {
            super(2, obj, Playmark.class, "albumArtist", "albumArtist(Lcom/mattiadoronzo/sonixlink/Row;Lcom/mattiadoronzo/sonixlink/PlayerState;)Z", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Boolean invoke(Row p0, PlayerState p1) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            return Boolean.valueOf(((Playmark) this.receiver).albumArtist(p0, p1));
        }
    }

    public final boolean byIcon(Row row, PlayerState state) {
        Intrinsics.checkNotNullParameter(row, "row");
        Intrinsics.checkNotNullParameter(state, "state");
        int iconRes = row.getIconRes();
        if (iconRes == C1020R.drawable.ic_album) {
            return album(row, state);
        }
        if (iconRes == C1020R.drawable.ic_artist) {
            return artist(row, state);
        }
        return false;
    }
}

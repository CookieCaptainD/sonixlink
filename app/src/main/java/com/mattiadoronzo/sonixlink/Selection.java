package com.mattiadoronzo.sonixlink;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: Selection.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\bH\u0002J0\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u000b2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\bJ*\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\b¨\u0006\u0014"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/Selection;", "", "()V", "askPlaylistName", "", "context", "Landroid/content/Context;", "chosen", "Lkotlin/Function1;", "", "paths", "", "rows", "Lcom/mattiadoronzo/sonixlink/Row;", "kindOf", "Lcom/mattiadoronzo/sonixlink/Section;", "pickPlaylist", "scope", "Lkotlinx/coroutines/CoroutineScope;", "Action", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class Selection {
    public static final Selection INSTANCE = new Selection();

    /* JADX INFO: compiled from: Selection.kt */
    @Metadata(m147d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/Selection$Action;", "", "(Ljava/lang/String;I)V", "QUEUE", "FAVOURITES_ADD", "FAVOURITES_REMOVE", "PLAYLIST_ADD", "PLAYLIST_REMOVE", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public enum Action {
        QUEUE,
        FAVOURITES_ADD,
        FAVOURITES_REMOVE,
        PLAYLIST_ADD,
        PLAYLIST_REMOVE;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<Action> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: Selection.kt */
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
            try {
                iArr[Section.PLAYLISTS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private Selection() {
    }

    public final List<String> paths(List<Row> rows, Function1<? super Row, ? extends Section> kindOf) {
        Intrinsics.checkNotNullParameter(rows, "rows");
        Intrinsics.checkNotNullParameter(kindOf, "kindOf");
        Library library = Session.INSTANCE.getLibrary();
        LinkedHashSet out = new LinkedHashSet();
        for (Row row : rows) {
            if (row.isTrack()) {
                out.add(row.getPath());
            } else if (!(row.getFilter().length() == 0)) {
                Section sectionInvoke = kindOf.invoke(row);
                Iterable iterableTracksOfAlbum = null;
                switch (sectionInvoke == null ? -1 : WhenMappings.$EnumSwitchMapping$0[sectionInvoke.ordinal()]) {
                    case 1:
                        if (library != null) {
                            iterableTracksOfAlbum = library.tracksOfAlbum(row.getFilter());
                        }
                        break;
                    case 2:
                        if (library != null) {
                            iterableTracksOfAlbum = Library.tracksOfArtist$default(library, row.getFilter(), null, 2, null);
                        }
                        break;
                    case 3:
                        if (library != null) {
                            iterableTracksOfAlbum = Library.tracksOfAlbumArtist$default(library, row.getFilter(), null, 2, null);
                        }
                        break;
                    case 4:
                        iterableTracksOfAlbum = LiveLists.INSTANCE.playlistTracks(library, row.getFilter());
                        break;
                }
                Iterable iterable = iterableTracksOfAlbum;
                if (iterable != null) {
                    Iterable $this$forEach$iv = iterable;
                    for (Object element$iv : $this$forEach$iv) {
                        Row it = (Row) element$iv;
                        if (it.getPath().length() > 0) {
                            out.add(it.getPath());
                        }
                    }
                }
            }
        }
        return CollectionsKt.toList(out);
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.Selection$pickPlaylist$1 */
    /* JADX INFO: compiled from: Selection.kt */
    @Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.Selection$pickPlaylist$1", m164f = "Selection.kt", m165i = {}, m166l = {50}, m167m = "invokeSuspend", m168n = {}, m169s = {})
    static final class C10341 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<String, Unit> $chosen;
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C10341(Context context, Function1<? super String, Unit> function1, Continuation<? super C10341> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$chosen = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C10341(this.$context, this.$chosen, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10341) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            C10341 c10341;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c10341 = this;
                    c10341.label = 1;
                    Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new Selection$pickPlaylist$1$names$1(null), c10341);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = objWithContext;
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    c10341 = this;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            final List names = (List) $result;
            Collection $this$toTypedArray$iv = CollectionsKt.plus((Collection) CollectionsKt.listOf(c10341.$context.getString(C1020R.string.playlist_new)), (Iterable) names);
            String[] items = (String[]) $this$toTypedArray$iv.toArray(new String[0]);
            final Context context = c10341.$context;
            final Function1<String, Unit> function1 = c10341.$chosen;
            new AlertDialog.Builder(c10341.$context).setTitle(C1020R.string.sel_playlist_add).setItems(items, new DialogInterface.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.Selection$pickPlaylist$1$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Selection.C10341.invokeSuspend$lambda$0(context, function1, names, dialogInterface, i);
                }
            }).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).show();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(Context $context, Function1 $chosen, List $names, DialogInterface dialogInterface, int which) {
            if (which == 0) {
                Selection.INSTANCE.askPlaylistName($context, $chosen);
            } else {
                $chosen.invoke($names.get(which - 1));
            }
        }
    }

    public final void pickPlaylist(Context context, CoroutineScope scope, Function1<? super String, Unit> chosen) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(chosen, "chosen");
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C10341(context, chosen, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void askPlaylistName(Context context, final Function1<? super String, Unit> chosen) {
        final EditText $this$askPlaylistName_u24lambda_u241 = new EditText(context);
        $this$askPlaylistName_u24lambda_u241.setHint(C1020R.string.playlist_name_hint);
        $this$askPlaylistName_u24lambda_u241.setSingleLine(true);
        FrameLayout $this$askPlaylistName_u24lambda_u242 = new FrameLayout(context);
        int side = (int) (20 * context.getResources().getDisplayMetrics().density);
        $this$askPlaylistName_u24lambda_u242.setPadding(side, side / 2, side, 0);
        $this$askPlaylistName_u24lambda_u242.addView($this$askPlaylistName_u24lambda_u241);
        new AlertDialog.Builder(context).setTitle(C1020R.string.playlist_new).setView($this$askPlaylistName_u24lambda_u242).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: com.mattiadoronzo.sonixlink.Selection$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                Selection.askPlaylistName$lambda$3($this$askPlaylistName_u24lambda_u241, chosen, dialogInterface, i);
            }
        }).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void askPlaylistName$lambda$3(EditText field, Function1 chosen, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(field, "$field");
        Intrinsics.checkNotNullParameter(chosen, "$chosen");
        String name = new Regex("[/\\\\:*?\"<>|]").replace(StringsKt.trim((CharSequence) field.getText().toString()).toString(), "");
        if (name.length() > 0) {
            chosen.invoke(name);
        }
    }
}

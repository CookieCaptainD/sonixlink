package com.mattiadoronzo.sonixlink;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SearchActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003*\u00020\u0004H\u008a@"}, m148d2 = {"<anonymous>", "Ljava/util/ArrayList;", "Lcom/mattiadoronzo/sonixlink/Row;", "Lkotlin/collections/ArrayList;", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.SearchActivity$search$1$rows$1", m164f = "SearchActivity.kt", m165i = {}, m166l = {}, m167m = "invokeSuspend", m168n = {}, m169s = {})
final class SearchActivity$search$1$rows$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArrayList<Row>>, Object> {
    final /* synthetic */ Library $library;
    final /* synthetic */ String $text;
    int label;
    final /* synthetic */ SearchActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SearchActivity$search$1$rows$1(Library library, String str, SearchActivity searchActivity, Continuation<? super SearchActivity$search$1$rows$1> continuation) {
        super(2, continuation);
        this.$library = library;
        this.$text = str;
        this.this$0 = searchActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SearchActivity$search$1$rows$1(this.$library, this.$text, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ArrayList<Row>> continuation) {
        return ((SearchActivity$search$1$rows$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                ArrayList out = new ArrayList();
                List<Row> listSearch = this.$library.search(this.$text, 12);
                if (!listSearch.isEmpty()) {
                    SearchActivity searchActivity = this.this$0;
                    String string = this.this$0.getString(C1020R.string.tab_tracks);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    out.add(searchActivity.header(string));
                    out.addAll(listSearch);
                }
                Iterable iterableAlbumsMatching = this.$library.albumsMatching(this.$text, 12);
                if (!((Collection) iterableAlbumsMatching).isEmpty()) {
                    SearchActivity searchActivity2 = this.this$0;
                    String string2 = this.this$0.getString(C1020R.string.tab_albums);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    out.add(searchActivity2.header(string2));
                    Iterable $this$map$iv = iterableAlbumsMatching;
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        Row it = (Row) item$iv$iv;
                        destination$iv$iv.add(it.copy((3615 & 1) != 0 ? it.title : null, (3615 & 2) != 0 ? it.subtitle : null, (3615 & 4) != 0 ? it.path : null, (3615 & 8) != 0 ? it.filter : null, (3615 & 16) != 0 ? it.count : 0, (3615 & 32) != 0 ? it.album : null, (3615 & 64) != 0 ? it.artPath : null, (3615 & 128) != 0 ? it.artMtime : 0L, (3615 & 256) != 0 ? it.artSize : 0L, (3615 & 512) != 0 ? it.kind : null, (3615 & 1024) != 0 ? it.sortKey : null, (3615 & 2048) != 0 ? it.iconRes : C1020R.drawable.ic_album));
                    }
                    out.addAll((List) destination$iv$iv);
                }
                Iterable iterableArtistsMatching = this.$library.artistsMatching(this.$text, 12);
                if (!((Collection) iterableArtistsMatching).isEmpty()) {
                    SearchActivity searchActivity3 = this.this$0;
                    String string3 = this.this$0.getString(C1020R.string.tab_artists);
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    out.add(searchActivity3.header(string3));
                    Iterable $this$map$iv2 = iterableArtistsMatching;
                    Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    for (Object item$iv$iv2 : $this$map$iv2) {
                        Row it2 = (Row) item$iv$iv2;
                        destination$iv$iv2.add(it2.copy((3615 & 1) != 0 ? it2.title : null, (3615 & 2) != 0 ? it2.subtitle : null, (3615 & 4) != 0 ? it2.path : null, (3615 & 8) != 0 ? it2.filter : null, (3615 & 16) != 0 ? it2.count : 0, (3615 & 32) != 0 ? it2.album : null, (3615 & 64) != 0 ? it2.artPath : null, (3615 & 128) != 0 ? it2.artMtime : 0L, (3615 & 256) != 0 ? it2.artSize : 0L, (3615 & 512) != 0 ? it2.kind : null, (3615 & 1024) != 0 ? it2.sortKey : null, (3615 & 2048) != 0 ? it2.iconRes : C1020R.drawable.ic_artist));
                    }
                    out.addAll((List) destination$iv$iv2);
                }
                return out;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}

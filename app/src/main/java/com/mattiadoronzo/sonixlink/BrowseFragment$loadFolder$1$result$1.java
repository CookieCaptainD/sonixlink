package com.mattiadoronzo.sonixlink;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: BrowseFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0001*\u00020\u0005H\u008a@"}, m148d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/mattiadoronzo/sonixlink/Folder;", "", "Lcom/mattiadoronzo/sonixlink/Row;", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.BrowseFragment$loadFolder$1$result$1", m164f = "BrowseFragment.kt", m165i = {}, m166l = {}, m167m = "invokeSuspend", m168n = {}, m169s = {})
final class BrowseFragment$loadFolder$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends Folder, ? extends List<? extends Row>>>, Object> {
    final /* synthetic */ PlayerClient $client;
    final /* synthetic */ String $path;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BrowseFragment$loadFolder$1$result$1(PlayerClient playerClient, String str, Continuation<? super BrowseFragment$loadFolder$1$result$1> continuation) {
        super(2, continuation);
        this.$client = playerClient;
        this.$path = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BrowseFragment$loadFolder$1$result$1(this.$client, this.$path, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends Folder, ? extends List<? extends Row>>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Pair<Folder, ? extends List<Row>>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Pair<Folder, ? extends List<Row>>> continuation) {
        return ((BrowseFragment$loadFolder$1$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Row row;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                try {
                    Folder folder = this.$client.browse(this.$path);
                    Iterable $this$filterTo$iv$iv = folder.getEntries();
                    Collection destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv : $this$filterTo$iv$iv) {
                        FolderEntry it = (FolderEntry) element$iv$iv;
                        if (!it.isFolder()) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                    }
                    Iterable $this$map$iv = (List) destination$iv$iv;
                    Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        FolderEntry it2 = (FolderEntry) item$iv$iv;
                        destination$iv$iv2.add(it2.getPath());
                    }
                    List files = (List) destination$iv$iv2;
                    Library library = Session.INSTANCE.getLibrary();
                    Map<String, Row> mapTracksByPaths = library != null ? library.tracksByPaths(files) : null;
                    if (mapTracksByPaths == null) {
                        mapTracksByPaths = MapsKt.emptyMap();
                    }
                    Map<String, Row> map = mapTracksByPaths;
                    Iterable $this$map$iv2 = folder.getEntries();
                    Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    for (Object item$iv$iv2 : $this$map$iv2) {
                        FolderEntry entry = (FolderEntry) item$iv$iv2;
                        if (entry.isFolder()) {
                            row = new Row(entry.getName(), "", null, entry.getPath(), 0, null, null, 0L, 0L, null, null, C1020R.drawable.ic_folder, 2036, null);
                        } else {
                            Row indexed = map.get(entry.getPath());
                            String name = entry.getName();
                            String path = entry.getPath();
                            String album = indexed != null ? indexed.getAlbum() : null;
                            String str = album == null ? "" : album;
                            String artPath = indexed != null ? indexed.getArtPath() : null;
                            row = new Row(name, "", path, null, 0, str, artPath == null ? "" : artPath, indexed != null ? indexed.getArtMtime() : 0L, indexed != null ? indexed.getArtSize() : 0L, null, null, C1020R.drawable.ic_track, 1560, null);
                        }
                        destination$iv$iv3.add(row);
                    }
                    return TuplesKt.m155to(folder, (List) destination$iv$iv3);
                } catch (Exception e) {
                    return null;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}

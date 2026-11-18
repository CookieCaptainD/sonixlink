package com.mattiadoronzo.sonixlink;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: QueueActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, m148d2 = {"<anonymous>", "", "Lcom/mattiadoronzo/sonixlink/Row;", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.QueueActivity$fetchPage$1$rows$1", m164f = "QueueActivity.kt", m165i = {}, m166l = {}, m167m = "invokeSuspend", m168n = {}, m169s = {})
final class QueueActivity$fetchPage$1$rows$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Row>>, Object> {
    final /* synthetic */ QueueWindow $page;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    QueueActivity$fetchPage$1$rows$1(QueueWindow queueWindow, Continuation<? super QueueActivity$fetchPage$1$rows$1> continuation) {
        super(2, continuation);
        this.$page = queueWindow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QueueActivity$fetchPage$1$rows$1(this.$page, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Row>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<Row>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<Row>> continuation) {
        return ((QueueActivity$fetchPage$1$rows$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                Library library = Session.INSTANCE.getLibrary();
                Map<String, Row> mapTracksByPaths = library != null ? library.tracksByPaths(this.$page.getPaths()) : null;
                if (mapTracksByPaths == null) {
                    mapTracksByPaths = MapsKt.emptyMap();
                }
                Iterable $this$map$iv = this.$page.getPaths();
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    String path = (String) item$iv$iv;
                    Row row = mapTracksByPaths.get(path);
                    if (row == null) {
                        row = new Row(StringsKt.substringAfterLast$default(path, '/', (String) null, 2, (Object) null), "", path, null, 0, null, null, 0L, 0L, null, null, 0, 4088, null);
                    }
                    destination$iv$iv.add(row);
                }
                return (List) destination$iv$iv;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}

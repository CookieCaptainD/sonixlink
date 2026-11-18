package com.mattiadoronzo.sonixlink;

import androidx.constraintlayout.widget.ConstraintLayout;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: QueueActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\u008a@"}, m148d2 = {"<anonymous>", "", "Lcom/mattiadoronzo/sonixlink/HistoryEntry;", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.QueueActivity$loadHistory$entries$1", m164f = "QueueActivity.kt", m165i = {}, m166l = {}, m167m = "invokeSuspend", m168n = {}, m169s = {})
final class QueueActivity$loadHistory$entries$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends HistoryEntry>>, Object> {
    final /* synthetic */ PlayerClient $client;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    QueueActivity$loadHistory$entries$1(PlayerClient playerClient, Continuation<? super QueueActivity$loadHistory$entries$1> continuation) {
        super(2, continuation);
        this.$client = playerClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QueueActivity$loadHistory$entries$1(this.$client, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends HistoryEntry>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<HistoryEntry>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<HistoryEntry>> continuation) {
        return ((QueueActivity$loadHistory$entries$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                try {
                    return this.$client.history(200);
                } catch (PlayerException e) {
                    String message = e.getMessage();
                    boolean z = false;
                    if (message != null && StringsKt.startsWith$default(message, "404", false, 2, (Object) null)) {
                        z = true;
                    }
                    if (z) {
                        return CollectionsKt.emptyList();
                    }
                    return null;
                } catch (Exception e2) {
                    return null;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}

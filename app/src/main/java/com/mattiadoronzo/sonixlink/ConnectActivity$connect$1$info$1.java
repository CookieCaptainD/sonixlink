package com.mattiadoronzo.sonixlink;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ConnectActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "Lcom/mattiadoronzo/sonixlink/PlayerInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.ConnectActivity$connect$1$info$1", m164f = "ConnectActivity.kt", m165i = {}, m166l = {}, m167m = "invokeSuspend", m168n = {}, m169s = {})
final class ConnectActivity$connect$1$info$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PlayerInfo>, Object> {
    final /* synthetic */ String $host;
    final /* synthetic */ int $port;
    final /* synthetic */ Ref.ObjectRef<String> $why;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ConnectActivity$connect$1$info$1(String str, int i, Ref.ObjectRef<String> objectRef, Continuation<? super ConnectActivity$connect$1$info$1> continuation) {
        super(2, continuation);
        this.$host = str;
        this.$port = i;
        this.$why = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConnectActivity$connect$1$info$1(this.$host, this.$port, this.$why, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PlayerInfo> continuation) {
        return ((ConnectActivity$connect$1$info$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                try {
                    return new PlayerClient(this.$host, this.$port).info();
                } catch (Exception e) {
                    Ref.ObjectRef<String> objectRef = this.$why;
                    String message = e.getMessage();
                    T t = message;
                    if (message == null) {
                        t = "";
                    }
                    objectRef.element = t;
                    return null;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}

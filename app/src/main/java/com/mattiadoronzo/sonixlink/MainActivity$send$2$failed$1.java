package com.mattiadoronzo.sonixlink;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.MainActivity$send$2$failed$1", m164f = "MainActivity.kt", m165i = {}, m166l = {}, m167m = "invokeSuspend", m168n = {}, m169s = {})
final class MainActivity$send$2$failed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Function1<PlayerClient, Unit> $action;
    int label;
    final /* synthetic */ MainActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    MainActivity$send$2$failed$1(Function1<? super PlayerClient, Unit> function1, MainActivity mainActivity, Continuation<? super MainActivity$send$2$failed$1> continuation) {
        super(2, continuation);
        this.$action = function1;
        this.this$0 = mainActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivity$send$2$failed$1(this.$action, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((MainActivity$send$2$failed$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                try {
                    Function1<PlayerClient, Unit> function1 = this.$action;
                    PlayerClient playerClient = this.this$0.client;
                    if (playerClient == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("client");
                        playerClient = null;
                    }
                    function1.invoke(playerClient);
                    z = false;
                } catch (Exception e) {
                    z = true;
                }
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}

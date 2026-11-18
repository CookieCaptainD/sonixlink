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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SyncActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.SyncActivity$syncLibrary$ok$1", m164f = "SyncActivity.kt", m165i = {}, m166l = {}, m167m = "invokeSuspend", m168n = {}, m169s = {})
final class SyncActivity$syncLibrary$ok$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ PlayerInfo $info;
    final /* synthetic */ Library $library;
    int label;
    final /* synthetic */ SyncActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SyncActivity$syncLibrary$ok$1(Library library, SyncActivity syncActivity, PlayerInfo playerInfo, Continuation<? super SyncActivity$syncLibrary$ok$1> continuation) {
        super(2, continuation);
        this.$library = library;
        this.this$0 = syncActivity;
        this.$info = playerInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SyncActivity$syncLibrary$ok$1(this.$library, this.this$0, this.$info, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((SyncActivity$syncLibrary$ok$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                try {
                    this.$library.close();
                    PlayerClient playerClient = this.this$0.client;
                    if (playerClient == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("client");
                        playerClient = null;
                    }
                    playerClient.downloadDatabase(this.$library.getFile(), new C10461(this.$info, this.this$0));
                    z = true;
                } catch (Exception e) {
                    z = false;
                }
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.mattiadoronzo.sonixlink.SyncActivity$syncLibrary$ok$1$1 */
    /* JADX INFO: compiled from: SyncActivity.kt */
    @Metadata(m147d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, m148d2 = {"<anonymous>", "", "done", "", "total", "invoke"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    static final class C10461 extends Lambda implements Function2<Long, Long, Unit> {
        final /* synthetic */ PlayerInfo $info;
        final /* synthetic */ SyncActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10461(PlayerInfo playerInfo, SyncActivity syncActivity) {
            super(2);
            this.$info = playerInfo;
            this.this$0 = syncActivity;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2) {
            invoke(l.longValue(), l2.longValue());
            return Unit.INSTANCE;
        }

        public final void invoke(final long done, long total) {
            final long size = total > 0 ? total : this.$info.getDbSize();
            SyncActivity syncActivity = this.this$0;
            final SyncActivity syncActivity2 = this.this$0;
            syncActivity.runOnUiThread(new Runnable() { // from class: com.mattiadoronzo.sonixlink.SyncActivity$syncLibrary$ok$1$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    SyncActivity$syncLibrary$ok$1.C10461.invoke$lambda$0(syncActivity2, done, size);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0(SyncActivity this$0, long $done, long $size) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.showAmount($done, $size);
        }
    }
}

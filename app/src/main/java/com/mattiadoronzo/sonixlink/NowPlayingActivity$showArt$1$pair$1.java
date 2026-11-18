package com.mattiadoronzo.sonixlink;

import android.graphics.Bitmap;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: NowPlayingActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\u008a@"}, m148d2 = {"<anonymous>", "Lkotlin/Pair;", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.NowPlayingActivity$showArt$1$pair$1", m164f = "NowPlayingActivity.kt", m165i = {}, m166l = {}, m167m = "invokeSuspend", m168n = {}, m169s = {})
final class NowPlayingActivity$showArt$1$pair$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends Bitmap, ? extends Bitmap>>, Object> {
    final /* synthetic */ PlayerClient $client;
    final /* synthetic */ Ref.BooleanRef $failed;
    final /* synthetic */ String $path;
    int label;
    final /* synthetic */ NowPlayingActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NowPlayingActivity$showArt$1$pair$1(PlayerClient playerClient, String str, NowPlayingActivity nowPlayingActivity, Ref.BooleanRef booleanRef, Continuation<? super NowPlayingActivity$showArt$1$pair$1> continuation) {
        super(2, continuation);
        this.$client = playerClient;
        this.$path = str;
        this.this$0 = nowPlayingActivity;
        this.$failed = booleanRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NowPlayingActivity$showArt$1$pair$1(this.$client, this.$path, this.this$0, this.$failed, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends Bitmap, ? extends Bitmap>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Pair<Bitmap, Bitmap>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Pair<Bitmap, Bitmap>> continuation) {
        return ((NowPlayingActivity$showArt$1$pair$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Bitmap full;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                try {
                    Artwork artwork = Artwork.INSTANCE;
                    PlayerClient playerClient = this.$client;
                    String str = this.$path;
                    final String str2 = this.$path;
                    byte[] bytes = artwork.get(playerClient, str, new Function0<Boolean>() { // from class: com.mattiadoronzo.sonixlink.NowPlayingActivity$showArt$1$pair$1$bytes$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            return Boolean.valueOf(Intrinsics.areEqual(Session.INSTANCE.getState().getPath(), str2));
                        }
                    });
                    if (bytes != null && (full = this.this$0.decode(bytes)) != null) {
                        return TuplesKt.m155to(full, this.this$0.blur(full));
                    }
                    return null;
                } catch (Exception e) {
                    this.$failed.element = true;
                    return null;
                } catch (OutOfMemoryError e2) {
                    return null;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}

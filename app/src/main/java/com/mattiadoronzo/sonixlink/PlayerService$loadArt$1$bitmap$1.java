package com.mattiadoronzo.sonixlink;

import android.graphics.Bitmap;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PlayerService.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.PlayerService$loadArt$1$bitmap$1", m164f = "PlayerService.kt", m165i = {}, m166l = {}, m167m = "invokeSuspend", m168n = {}, m169s = {})
final class PlayerService$loadArt$1$bitmap$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ PlayerClient $current;
    final /* synthetic */ String $path;
    int label;
    final /* synthetic */ PlayerService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PlayerService$loadArt$1$bitmap$1(PlayerClient playerClient, String str, PlayerService playerService, Continuation<? super PlayerService$loadArt$1$bitmap$1> continuation) {
        super(2, continuation);
        this.$current = playerClient;
        this.$path = str;
        this.this$0 = playerService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlayerService$loadArt$1$bitmap$1(this.$current, this.$path, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
        return ((PlayerService$loadArt$1$bitmap$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Bitmap bitmapDecode;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                try {
                    Artwork artwork = Artwork.INSTANCE;
                    PlayerClient playerClient = this.$current;
                    String str = this.$path;
                    final PlayerService playerService = this.this$0;
                    final String str2 = this.$path;
                    byte[] it = artwork.get(playerClient, str, new Function0<Boolean>() { // from class: com.mattiadoronzo.sonixlink.PlayerService$loadArt$1$bitmap$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            return Boolean.valueOf(Intrinsics.areEqual(playerService.artPath, str2));
                        }
                    });
                    if (it == null || (bitmapDecode = this.this$0.decode(it)) == null) {
                        return this.this$0.thumbnail(this.$path);
                    }
                    return bitmapDecode;
                } catch (Artwork.Stale e) {
                    return null;
                } catch (Exception e2) {
                    return this.this$0.thumbnail(this.$path);
                } catch (OutOfMemoryError e3) {
                    return this.this$0.thumbnail(this.$path);
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}

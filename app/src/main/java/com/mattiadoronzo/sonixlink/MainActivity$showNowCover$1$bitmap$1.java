package com.mattiadoronzo.sonixlink;

import android.graphics.Bitmap;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m148d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, m149k = 3, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m163c = "com.mattiadoronzo.sonixlink.MainActivity$showNowCover$1$bitmap$1", m164f = "MainActivity.kt", m165i = {}, m166l = {}, m167m = "invokeSuspend", m168n = {}, m169s = {})
final class MainActivity$showNowCover$1$bitmap$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ String $path;
    final /* synthetic */ int $side;
    int label;
    final /* synthetic */ MainActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MainActivity$showNowCover$1$bitmap$1(String str, MainActivity mainActivity, int i, Continuation<? super MainActivity$showNowCover$1$bitmap$1> continuation) {
        super(2, continuation);
        this.$path = str;
        this.this$0 = mainActivity;
        this.$side = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivity$showNowCover$1$bitmap$1(this.$path, this.this$0, this.$side, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
        return ((MainActivity$showNowCover$1$bitmap$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Bitmap bitmapForTrack;
        Map<String, Row> mapTracksByPaths;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                Library library = Session.INSTANCE.getLibrary();
                Bitmap bitmapForAlbum = null;
                Row row = (library == null || (mapTracksByPaths = library.tracksByPaths(CollectionsKt.listOf(this.$path))) == null) ? null : mapTracksByPaths.get(this.$path);
                if (row != null) {
                    Covers covers = Session.INSTANCE.getCovers();
                    if (covers == null || (bitmapForTrack = covers.forTrack(row.getArtPath(), row.getArtMtime(), row.getArtSize())) == null) {
                        Covers covers2 = Session.INSTANCE.getCovers();
                        if (covers2 != null) {
                            bitmapForAlbum = covers2.forAlbum(row.getAlbum());
                        }
                    } else {
                        bitmapForAlbum = bitmapForTrack;
                    }
                }
                Bitmap thumb = bitmapForAlbum;
                return thumb == null ? this.this$0.smallArtwork(this.$path, this.$side) : thumb;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}

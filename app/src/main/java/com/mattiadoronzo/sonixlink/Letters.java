package com.mattiadoronzo.sonixlink;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Letters.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/Letters;", "", "()V", "LATIN_GROUP", "", "PAST_Z", "", "ofSortKey", "key", "", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class Letters {
    public static final Letters INSTANCE = new Letters();
    private static final int LATIN_GROUP = 3;
    public static final char PAST_Z = '~';

    private Letters() {
    }

    public final char ofSortKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (key.length() == 0) {
            return '#';
        }
        int group = key.charAt(0) - '0';
        if (group > 3) {
            return PAST_Z;
        }
        if (group != 3 || key.length() < 2) {
            return '#';
        }
        char folded = key.charAt(1);
        return 'a' <= folded && folded < '{' ? Character.toUpperCase(folded) : PAST_Z;
    }
}

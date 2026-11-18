package com.mattiadoronzo.sonixlink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.mattiadoronzo.sonixlink.C1020R;

/* JADX INFO: loaded from: classes3.dex */
public final class RowHeaderBinding implements ViewBinding {
    public final TextView headerLabel;
    private final TextView rootView;

    private RowHeaderBinding(TextView rootView, TextView headerLabel) {
        this.rootView = rootView;
        this.headerLabel = headerLabel;
    }

    @Override // androidx.viewbinding.ViewBinding
    public TextView getRoot() {
        return this.rootView;
    }

    public static RowHeaderBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowHeaderBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C1020R.layout.row_header, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static RowHeaderBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        TextView headerLabel = (TextView) rootView;
        return new RowHeaderBinding((TextView) rootView, headerLabel);
    }
}

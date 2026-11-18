package com.mattiadoronzo.sonixlink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.mattiadoronzo.sonixlink.C1020R;

/* JADX INFO: loaded from: classes3.dex */
public final class RowFoundBinding implements ViewBinding {
    public final TextView address;
    public final TextView name;
    private final LinearLayout rootView;

    private RowFoundBinding(LinearLayout rootView, TextView address, TextView name) {
        this.rootView = rootView;
        this.address = address;
        this.name = name;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowFoundBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowFoundBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C1020R.layout.row_found, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static RowFoundBinding bind(View rootView) {
        int id = C1020R.id.address;
        TextView address = (TextView) ViewBindings.findChildViewById(rootView, id);
        if (address != null) {
            id = C1020R.id.name;
            TextView name = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (name != null) {
                return new RowFoundBinding((LinearLayout) rootView, address, name);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

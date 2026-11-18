package com.mattiadoronzo.sonixlink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.mattiadoronzo.sonixlink.C1020R;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityConnectBinding implements ViewBinding {
    public final Button bluetoothButton;
    public final RecyclerView foundList;
    public final TextView hintText;
    public final LinearLayout nothingFound;
    public final ProgressBar progress;
    public final Button rescanButton;
    private final LinearLayout rootView;
    public final TextView statusText;

    private ActivityConnectBinding(LinearLayout rootView, Button bluetoothButton, RecyclerView foundList, TextView hintText, LinearLayout nothingFound, ProgressBar progress, Button rescanButton, TextView statusText) {
        this.rootView = rootView;
        this.bluetoothButton = bluetoothButton;
        this.foundList = foundList;
        this.hintText = hintText;
        this.nothingFound = nothingFound;
        this.progress = progress;
        this.rescanButton = rescanButton;
        this.statusText = statusText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityConnectBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityConnectBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C1020R.layout.activity_connect, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityConnectBinding bind(View rootView) {
        int id = C1020R.id.bluetoothButton;
        Button bluetoothButton = (Button) ViewBindings.findChildViewById(rootView, id);
        if (bluetoothButton != null) {
            id = C1020R.id.foundList;
            RecyclerView foundList = (RecyclerView) ViewBindings.findChildViewById(rootView, id);
            if (foundList != null) {
                id = C1020R.id.hintText;
                TextView hintText = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (hintText != null) {
                    id = C1020R.id.nothingFound;
                    LinearLayout nothingFound = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                    if (nothingFound != null) {
                        id = C1020R.id.progress;
                        ProgressBar progress = (ProgressBar) ViewBindings.findChildViewById(rootView, id);
                        if (progress != null) {
                            id = C1020R.id.rescanButton;
                            Button rescanButton = (Button) ViewBindings.findChildViewById(rootView, id);
                            if (rescanButton != null) {
                                id = C1020R.id.statusText;
                                TextView statusText = (TextView) ViewBindings.findChildViewById(rootView, id);
                                if (statusText != null) {
                                    return new ActivityConnectBinding((LinearLayout) rootView, bluetoothButton, foundList, hintText, nothingFound, progress, rescanButton, statusText);
                                }
                            }
                        }
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

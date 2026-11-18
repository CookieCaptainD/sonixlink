package com.mattiadoronzo.sonixlink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.mattiadoronzo.sonixlink.C1020R;

/* JADX INFO: loaded from: classes3.dex */
public final class VolumePillBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final ImageView volumeIcon;
    public final SeekBar volumeSeek;
    public final TextView volumeText;

    private VolumePillBinding(FrameLayout rootView, ImageView volumeIcon, SeekBar volumeSeek, TextView volumeText) {
        this.rootView = rootView;
        this.volumeIcon = volumeIcon;
        this.volumeSeek = volumeSeek;
        this.volumeText = volumeText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static VolumePillBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static VolumePillBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C1020R.layout.volume_pill, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static VolumePillBinding bind(View rootView) {
        int id = C1020R.id.volumeIcon;
        ImageView volumeIcon = (ImageView) ViewBindings.findChildViewById(rootView, id);
        if (volumeIcon != null) {
            id = C1020R.id.volumeSeek;
            SeekBar volumeSeek = (SeekBar) ViewBindings.findChildViewById(rootView, id);
            if (volumeSeek != null) {
                id = C1020R.id.volumeText;
                TextView volumeText = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (volumeText != null) {
                    return new VolumePillBinding((FrameLayout) rootView, volumeIcon, volumeSeek, volumeText);
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

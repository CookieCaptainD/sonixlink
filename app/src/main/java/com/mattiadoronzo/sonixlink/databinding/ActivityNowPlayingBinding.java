package com.mattiadoronzo.sonixlink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.mattiadoronzo.sonixlink.C1020R;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityNowPlayingBinding implements ViewBinding {
    public final ImageView backdrop;
    public final ImageView cover;
    public final ImageView coverPlaceholder;
    public final TextView elapsed;
    public final ImageButton favouriteButton;
    public final View handle;
    public final ImageButton modeButton;
    public final ImageButton nextButton;
    public final ImageButton playButton;
    public final ImageButton prevButton;
    public final SeekBar progressSeek;
    public final ImageButton queueButton;
    public final TextView queuePosition;
    private final FrameLayout rootView;
    public final FrameLayout sheet;
    public final TextView total;
    public final TextView trackArtist;
    public final TextView trackTitle;
    public final VolumePillBinding volume;

    private ActivityNowPlayingBinding(FrameLayout rootView, ImageView backdrop, ImageView cover, ImageView coverPlaceholder, TextView elapsed, ImageButton favouriteButton, View handle, ImageButton modeButton, ImageButton nextButton, ImageButton playButton, ImageButton prevButton, SeekBar progressSeek, ImageButton queueButton, TextView queuePosition, FrameLayout sheet, TextView total, TextView trackArtist, TextView trackTitle, VolumePillBinding volume) {
        this.rootView = rootView;
        this.backdrop = backdrop;
        this.cover = cover;
        this.coverPlaceholder = coverPlaceholder;
        this.elapsed = elapsed;
        this.favouriteButton = favouriteButton;
        this.handle = handle;
        this.modeButton = modeButton;
        this.nextButton = nextButton;
        this.playButton = playButton;
        this.prevButton = prevButton;
        this.progressSeek = progressSeek;
        this.queueButton = queueButton;
        this.queuePosition = queuePosition;
        this.sheet = sheet;
        this.total = total;
        this.trackArtist = trackArtist;
        this.trackTitle = trackTitle;
        this.volume = volume;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ActivityNowPlayingBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityNowPlayingBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C1020R.layout.activity_now_playing, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityNowPlayingBinding bind(View rootView) {
        View handle;
        View volume;
        int id = C1020R.id.backdrop;
        ImageView backdrop = (ImageView) ViewBindings.findChildViewById(rootView, id);
        if (backdrop != null) {
            id = C1020R.id.cover;
            ImageView cover = (ImageView) ViewBindings.findChildViewById(rootView, id);
            if (cover != null) {
                id = C1020R.id.coverPlaceholder;
                ImageView coverPlaceholder = (ImageView) ViewBindings.findChildViewById(rootView, id);
                if (coverPlaceholder != null) {
                    id = C1020R.id.elapsed;
                    TextView elapsed = (TextView) ViewBindings.findChildViewById(rootView, id);
                    if (elapsed != null) {
                        id = C1020R.id.favouriteButton;
                        ImageButton favouriteButton = (ImageButton) ViewBindings.findChildViewById(rootView, id);
                        if (favouriteButton != null && (handle = ViewBindings.findChildViewById(rootView, (id = C1020R.id.handle))) != null) {
                            id = C1020R.id.modeButton;
                            ImageButton modeButton = (ImageButton) ViewBindings.findChildViewById(rootView, id);
                            if (modeButton != null) {
                                id = C1020R.id.nextButton;
                                ImageButton nextButton = (ImageButton) ViewBindings.findChildViewById(rootView, id);
                                if (nextButton != null) {
                                    id = C1020R.id.playButton;
                                    ImageButton playButton = (ImageButton) ViewBindings.findChildViewById(rootView, id);
                                    if (playButton != null) {
                                        id = C1020R.id.prevButton;
                                        ImageButton prevButton = (ImageButton) ViewBindings.findChildViewById(rootView, id);
                                        if (prevButton != null) {
                                            id = C1020R.id.progressSeek;
                                            SeekBar progressSeek = (SeekBar) ViewBindings.findChildViewById(rootView, id);
                                            if (progressSeek != null) {
                                                id = C1020R.id.queueButton;
                                                ImageButton queueButton = (ImageButton) ViewBindings.findChildViewById(rootView, id);
                                                if (queueButton != null) {
                                                    id = C1020R.id.queuePosition;
                                                    TextView queuePosition = (TextView) ViewBindings.findChildViewById(rootView, id);
                                                    if (queuePosition != null) {
                                                        id = C1020R.id.sheet;
                                                        FrameLayout sheet = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
                                                        if (sheet != null) {
                                                            id = C1020R.id.total;
                                                            TextView total = (TextView) ViewBindings.findChildViewById(rootView, id);
                                                            if (total != null) {
                                                                id = C1020R.id.trackArtist;
                                                                TextView trackArtist = (TextView) ViewBindings.findChildViewById(rootView, id);
                                                                if (trackArtist != null) {
                                                                    id = C1020R.id.trackTitle;
                                                                    TextView trackTitle = (TextView) ViewBindings.findChildViewById(rootView, id);
                                                                    if (trackTitle != null && (volume = ViewBindings.findChildViewById(rootView, (id = C1020R.id.volume))) != null) {
                                                                        VolumePillBinding binding_volume = VolumePillBinding.bind(volume);
                                                                        return new ActivityNowPlayingBinding((FrameLayout) rootView, backdrop, cover, coverPlaceholder, elapsed, favouriteButton, handle, modeButton, nextButton, playButton, prevButton, progressSeek, queueButton, queuePosition, sheet, total, trackArtist, trackTitle, binding_volume);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
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

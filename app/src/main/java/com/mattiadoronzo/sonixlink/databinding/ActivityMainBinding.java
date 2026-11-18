package com.mattiadoronzo.sonixlink.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.mattiadoronzo.sonixlink.C1020R;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityMainBinding implements ViewBinding {
    public final ImageButton favouriteButton;
    public final ImageButton modeButton;
    public final ImageButton nextButton;
    public final ImageView nowCover;
    public final LinearLayout nowDetails;
    public final LinearLayout nowPlaying;
    public final ViewPager2 pager;
    public final ImageButton playButton;
    public final ImageButton prevButton;
    public final ProgressBar progressTrack;
    public final ImageButton queueButton;
    private final FrameLayout rootView;
    public final TabLayout tabs;
    public final Toolbar toolbar;
    public final TextView trackArtist;
    public final TextView trackTitle;
    public final VolumePillBinding volume;

    private ActivityMainBinding(FrameLayout rootView, ImageButton favouriteButton, ImageButton modeButton, ImageButton nextButton, ImageView nowCover, LinearLayout nowDetails, LinearLayout nowPlaying, ViewPager2 pager, ImageButton playButton, ImageButton prevButton, ProgressBar progressTrack, ImageButton queueButton, TabLayout tabs, Toolbar toolbar, TextView trackArtist, TextView trackTitle, VolumePillBinding volume) {
        this.rootView = rootView;
        this.favouriteButton = favouriteButton;
        this.modeButton = modeButton;
        this.nextButton = nextButton;
        this.nowCover = nowCover;
        this.nowDetails = nowDetails;
        this.nowPlaying = nowPlaying;
        this.pager = pager;
        this.playButton = playButton;
        this.prevButton = prevButton;
        this.progressTrack = progressTrack;
        this.queueButton = queueButton;
        this.tabs = tabs;
        this.toolbar = toolbar;
        this.trackArtist = trackArtist;
        this.trackTitle = trackTitle;
        this.volume = volume;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityMainBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(C1020R.layout.activity_main, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityMainBinding bind(View rootView) {
        View volume;
        int id = C1020R.id.favouriteButton;
        ImageButton favouriteButton = (ImageButton) ViewBindings.findChildViewById(rootView, id);
        if (favouriteButton != null) {
            id = C1020R.id.modeButton;
            ImageButton modeButton = (ImageButton) ViewBindings.findChildViewById(rootView, id);
            if (modeButton != null) {
                id = C1020R.id.nextButton;
                ImageButton nextButton = (ImageButton) ViewBindings.findChildViewById(rootView, id);
                if (nextButton != null) {
                    id = C1020R.id.nowCover;
                    ImageView nowCover = (ImageView) ViewBindings.findChildViewById(rootView, id);
                    if (nowCover != null) {
                        id = C1020R.id.nowDetails;
                        LinearLayout nowDetails = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                        if (nowDetails != null) {
                            id = C1020R.id.nowPlaying;
                            LinearLayout nowPlaying = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                            if (nowPlaying != null) {
                                id = C1020R.id.pager;
                                ViewPager2 pager = (ViewPager2) ViewBindings.findChildViewById(rootView, id);
                                if (pager != null) {
                                    id = C1020R.id.playButton;
                                    ImageButton playButton = (ImageButton) ViewBindings.findChildViewById(rootView, id);
                                    if (playButton != null) {
                                        id = C1020R.id.prevButton;
                                        ImageButton prevButton = (ImageButton) ViewBindings.findChildViewById(rootView, id);
                                        if (prevButton != null) {
                                            id = C1020R.id.progressTrack;
                                            ProgressBar progressTrack = (ProgressBar) ViewBindings.findChildViewById(rootView, id);
                                            if (progressTrack != null) {
                                                id = C1020R.id.queueButton;
                                                ImageButton queueButton = (ImageButton) ViewBindings.findChildViewById(rootView, id);
                                                if (queueButton != null) {
                                                    id = C1020R.id.tabs;
                                                    TabLayout tabs = (TabLayout) ViewBindings.findChildViewById(rootView, id);
                                                    if (tabs != null) {
                                                        id = C1020R.id.toolbar;
                                                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, id);
                                                        if (toolbar != null) {
                                                            id = C1020R.id.trackArtist;
                                                            TextView trackArtist = (TextView) ViewBindings.findChildViewById(rootView, id);
                                                            if (trackArtist != null) {
                                                                id = C1020R.id.trackTitle;
                                                                TextView trackTitle = (TextView) ViewBindings.findChildViewById(rootView, id);
                                                                if (trackTitle != null && (volume = ViewBindings.findChildViewById(rootView, (id = C1020R.id.volume))) != null) {
                                                                    VolumePillBinding binding_volume = VolumePillBinding.bind(volume);
                                                                    return new ActivityMainBinding((FrameLayout) rootView, favouriteButton, modeButton, nextButton, nowCover, nowDetails, nowPlaying, pager, playButton, prevButton, progressTrack, queueButton, tabs, toolbar, trackArtist, trackTitle, binding_volume);
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

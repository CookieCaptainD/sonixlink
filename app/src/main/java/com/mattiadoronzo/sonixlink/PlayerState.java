package com.mattiadoronzo.sonixlink;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Models.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bS\b\u0086\b\u0018\u0000 q2\u00020\u0001:\u0001qB\u0085\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0016\u001a\u00020\n\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u0012\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010 \u001a\u00020\u0003\u0012\b\b\u0002\u0010!\u001a\u00020\u0003\u0012\b\b\u0002\u0010\"\u001a\u00020\n\u0012\b\b\u0002\u0010#\u001a\u00020\u001a\u0012\b\b\u0002\u0010$\u001a\u00020\u001a\u0012\b\b\u0002\u0010%\u001a\u00020\u001a¢\u0006\u0002\u0010&J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0012HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0012HÆ\u0003J\t\u0010U\u001a\u00020\u0012HÆ\u0003J\t\u0010V\u001a\u00020\nHÆ\u0003J\t\u0010W\u001a\u00020\u0003HÆ\u0003J\t\u0010X\u001a\u00020\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\u0005HÆ\u0003J\t\u0010Z\u001a\u00020\u001aHÆ\u0003J\t\u0010[\u001a\u00020\u0012HÆ\u0003J\t\u0010\\\u001a\u00020\u0003HÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\t\u0010_\u001a\u00020\u0003HÆ\u0003J\t\u0010`\u001a\u00020\u0003HÆ\u0003J\t\u0010a\u001a\u00020\nHÆ\u0003J\t\u0010b\u001a\u00020\u001aHÆ\u0003J\t\u0010c\u001a\u00020\u001aHÆ\u0003J\t\u0010d\u001a\u00020\u0003HÆ\u0003J\t\u0010e\u001a\u00020\u001aHÆ\u0003J\t\u0010f\u001a\u00020\u0003HÆ\u0003J\t\u0010g\u001a\u00020\u0003HÆ\u0003J\t\u0010h\u001a\u00020\nHÆ\u0003J\t\u0010i\u001a\u00020\nHÆ\u0003J\t\u0010j\u001a\u00020\nHÆ\u0003J\t\u0010k\u001a\u00020\nHÆ\u0003J·\u0002\u0010l\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00122\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\n2\b\b\u0002\u0010#\u001a\u00020\u001a2\b\b\u0002\u0010$\u001a\u00020\u001a2\b\b\u0002\u0010%\u001a\u00020\u001aHÆ\u0001J\u0013\u0010m\u001a\u00020\u00122\b\u0010n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010o\u001a\u00020\u0003HÖ\u0001J\t\u0010p\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0016\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b)\u0010(R\u0011\u0010\"\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b*\u0010(R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b+\u0010(R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010-R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010-R\u0011\u0010\u0014\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010!\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010-R\u0011\u0010 \u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010-R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010-R\u0011\u0010\u0015\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b5\u00101R\u0011\u0010#\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u00108\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b9\u00101R\u0011\u0010%\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b:\u00107R\u0011\u0010;\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b;\u00101R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b<\u00101R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b?\u0010(R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010-R\u0011\u0010$\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\bA\u00107R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bB\u0010-R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u0010-R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u0010-R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\bE\u00107R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u0010-R\u0011\u0010\u001c\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u0010-R\u0011\u0010\u001b\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\bH\u00101R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bK\u0010(R\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bL\u0010-R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bM\u0010-¨\u0006r"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/PlayerState;", "", "playState", "", "mode", "Lcom/mattiadoronzo/sonixlink/PlayMode;", "volume", "position", "duration", "title", "", "artist", "album", "path", "sampleRate", "bits", "bitrate", "lossless", "", "battery", "charging", "favourite", "accent", "queuePosition", "queueCount", "queueRevision", "", "scanning", "scanCount", "tracks", "sort", "Lcom/mattiadoronzo/sonixlink/SortPrefs;", "displayPosition", "displayCount", "albumArtist", "favouritesRevision", "playlistsRevision", "historyRevision", "(ILcom/mattiadoronzo/sonixlink/PlayMode;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIZIZZLjava/lang/String;IIJZIILcom/mattiadoronzo/sonixlink/SortPrefs;IILjava/lang/String;JJJ)V", "getAccent", "()Ljava/lang/String;", "getAlbum", "getAlbumArtist", "getArtist", "getBattery", "()I", "getBitrate", "getBits", "getCharging", "()Z", "getDisplayCount", "getDisplayPosition", "getDuration", "getFavourite", "getFavouritesRevision", "()J", "hasTrack", "getHasTrack", "getHistoryRevision", "isPlaying", "getLossless", "getMode", "()Lcom/mattiadoronzo/sonixlink/PlayMode;", "getPath", "getPlayState", "getPlaylistsRevision", "getPosition", "getQueueCount", "getQueuePosition", "getQueueRevision", "getSampleRate", "getScanCount", "getScanning", "getSort", "()Lcom/mattiadoronzo/sonixlink/SortPrefs;", "getTitle", "getTracks", "getVolume", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "Companion", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class PlayerState {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final PlayerState EMPTY = new PlayerState(0, PlayMode.NORMAL, 0, 0, 0, "", "", "", "", 0, 0, 0, false, -1, false, false, "", -1, 0, -1, false, 0, 0, null, 0, 0, null, 0, 0, 0, 1065353216, null);
    private final String accent;
    private final String album;
    private final String albumArtist;
    private final String artist;
    private final int battery;
    private final int bitrate;
    private final int bits;
    private final boolean charging;
    private final int displayCount;
    private final int displayPosition;
    private final int duration;
    private final boolean favourite;
    private final long favouritesRevision;
    private final long historyRevision;
    private final boolean lossless;
    private final PlayMode mode;
    private final String path;
    private final int playState;
    private final long playlistsRevision;
    private final int position;
    private final int queueCount;
    private final int queuePosition;
    private final long queueRevision;
    private final int sampleRate;
    private final int scanCount;
    private final boolean scanning;
    private final SortPrefs sort;
    private final String title;
    private final int tracks;
    private final int volume;

    public static /* synthetic */ PlayerState copy$default(PlayerState playerState, int i, PlayMode playMode, int i2, int i3, int i4, String str, String str2, String str3, String str4, int i5, int i6, int i7, boolean z, int i8, boolean z2, boolean z3, String str5, int i9, int i10, long j, boolean z4, int i11, int i12, SortPrefs sortPrefs, int i13, int i14, String str6, long j2, long j3, long j4, int i15, Object obj) {
        int i16 = (i15 & 1) != 0 ? playerState.playState : i;
        PlayMode playMode2 = (i15 & 2) != 0 ? playerState.mode : playMode;
        int i17 = (i15 & 4) != 0 ? playerState.volume : i2;
        int i18 = (i15 & 8) != 0 ? playerState.position : i3;
        int i19 = (i15 & 16) != 0 ? playerState.duration : i4;
        String str7 = (i15 & 32) != 0 ? playerState.title : str;
        String str8 = (i15 & 64) != 0 ? playerState.artist : str2;
        String str9 = (i15 & 128) != 0 ? playerState.album : str3;
        String str10 = (i15 & 256) != 0 ? playerState.path : str4;
        int i20 = (i15 & 512) != 0 ? playerState.sampleRate : i5;
        int i21 = (i15 & 1024) != 0 ? playerState.bits : i6;
        int i22 = (i15 & 2048) != 0 ? playerState.bitrate : i7;
        boolean z5 = (i15 & 4096) != 0 ? playerState.lossless : z;
        return playerState.copy(i16, playMode2, i17, i18, i19, str7, str8, str9, str10, i20, i21, i22, z5, (i15 & 8192) != 0 ? playerState.battery : i8, (i15 & 16384) != 0 ? playerState.charging : z2, (i15 & 32768) != 0 ? playerState.favourite : z3, (i15 & 65536) != 0 ? playerState.accent : str5, (i15 & 131072) != 0 ? playerState.queuePosition : i9, (i15 & 262144) != 0 ? playerState.queueCount : i10, (i15 & 524288) != 0 ? playerState.queueRevision : j, (i15 & 1048576) != 0 ? playerState.scanning : z4, (2097152 & i15) != 0 ? playerState.scanCount : i11, (i15 & 4194304) != 0 ? playerState.tracks : i12, (i15 & 8388608) != 0 ? playerState.sort : sortPrefs, (i15 & 16777216) != 0 ? playerState.displayPosition : i13, (i15 & 33554432) != 0 ? playerState.displayCount : i14, (i15 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? playerState.albumArtist : str6, (i15 & 134217728) != 0 ? playerState.favouritesRevision : j2, (i15 & 268435456) != 0 ? playerState.playlistsRevision : j3, (i15 & 536870912) != 0 ? playerState.historyRevision : j4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getPlayState() {
        return this.playState;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getSampleRate() {
        return this.sampleRate;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getBits() {
        return this.bits;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final int getBitrate() {
        return this.bitrate;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getLossless() {
        return this.lossless;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final int getBattery() {
        return this.battery;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final boolean getCharging() {
        return this.charging;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final boolean getFavourite() {
        return this.favourite;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getAccent() {
        return this.accent;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final int getQueuePosition() {
        return this.queuePosition;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final int getQueueCount() {
        return this.queueCount;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PlayMode getMode() {
        return this.mode;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final long getQueueRevision() {
        return this.queueRevision;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final boolean getScanning() {
        return this.scanning;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final int getScanCount() {
        return this.scanCount;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final int getTracks() {
        return this.tracks;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final SortPrefs getSort() {
        return this.sort;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final int getDisplayPosition() {
        return this.displayPosition;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final int getDisplayCount() {
        return this.displayCount;
    }

    /* JADX INFO: renamed from: component27, reason: from getter */
    public final String getAlbumArtist() {
        return this.albumArtist;
    }

    /* JADX INFO: renamed from: component28, reason: from getter */
    public final long getFavouritesRevision() {
        return this.favouritesRevision;
    }

    /* JADX INFO: renamed from: component29, reason: from getter */
    public final long getPlaylistsRevision() {
        return this.playlistsRevision;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getVolume() {
        return this.volume;
    }

    /* JADX INFO: renamed from: component30, reason: from getter */
    public final long getHistoryRevision() {
        return this.historyRevision;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getArtist() {
        return this.artist;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getAlbum() {
        return this.album;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    public final PlayerState copy(int playState, PlayMode mode, int volume, int position, int duration, String title, String artist, String album, String path, int sampleRate, int bits, int bitrate, boolean lossless, int battery, boolean charging, boolean favourite, String accent, int queuePosition, int queueCount, long queueRevision, boolean scanning, int scanCount, int tracks, SortPrefs sort, int displayPosition, int displayCount, String albumArtist, long favouritesRevision, long playlistsRevision, long historyRevision) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(artist, "artist");
        Intrinsics.checkNotNullParameter(album, "album");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(accent, "accent");
        Intrinsics.checkNotNullParameter(albumArtist, "albumArtist");
        return new PlayerState(playState, mode, volume, position, duration, title, artist, album, path, sampleRate, bits, bitrate, lossless, battery, charging, favourite, accent, queuePosition, queueCount, queueRevision, scanning, scanCount, tracks, sort, displayPosition, displayCount, albumArtist, favouritesRevision, playlistsRevision, historyRevision);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayerState)) {
            return false;
        }
        PlayerState playerState = (PlayerState) other;
        return this.playState == playerState.playState && this.mode == playerState.mode && this.volume == playerState.volume && this.position == playerState.position && this.duration == playerState.duration && Intrinsics.areEqual(this.title, playerState.title) && Intrinsics.areEqual(this.artist, playerState.artist) && Intrinsics.areEqual(this.album, playerState.album) && Intrinsics.areEqual(this.path, playerState.path) && this.sampleRate == playerState.sampleRate && this.bits == playerState.bits && this.bitrate == playerState.bitrate && this.lossless == playerState.lossless && this.battery == playerState.battery && this.charging == playerState.charging && this.favourite == playerState.favourite && Intrinsics.areEqual(this.accent, playerState.accent) && this.queuePosition == playerState.queuePosition && this.queueCount == playerState.queueCount && this.queueRevision == playerState.queueRevision && this.scanning == playerState.scanning && this.scanCount == playerState.scanCount && this.tracks == playerState.tracks && Intrinsics.areEqual(this.sort, playerState.sort) && this.displayPosition == playerState.displayPosition && this.displayCount == playerState.displayCount && Intrinsics.areEqual(this.albumArtist, playerState.albumArtist) && this.favouritesRevision == playerState.favouritesRevision && this.playlistsRevision == playerState.playlistsRevision && this.historyRevision == playerState.historyRevision;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((Integer.hashCode(this.playState) * 31) + this.mode.hashCode()) * 31) + Integer.hashCode(this.volume)) * 31) + Integer.hashCode(this.position)) * 31) + Integer.hashCode(this.duration)) * 31) + this.title.hashCode()) * 31) + this.artist.hashCode()) * 31) + this.album.hashCode()) * 31) + this.path.hashCode()) * 31) + Integer.hashCode(this.sampleRate)) * 31) + Integer.hashCode(this.bits)) * 31) + Integer.hashCode(this.bitrate)) * 31) + Boolean.hashCode(this.lossless)) * 31) + Integer.hashCode(this.battery)) * 31) + Boolean.hashCode(this.charging)) * 31) + Boolean.hashCode(this.favourite)) * 31) + this.accent.hashCode()) * 31) + Integer.hashCode(this.queuePosition)) * 31) + Integer.hashCode(this.queueCount)) * 31) + Long.hashCode(this.queueRevision)) * 31) + Boolean.hashCode(this.scanning)) * 31) + Integer.hashCode(this.scanCount)) * 31) + Integer.hashCode(this.tracks)) * 31) + (this.sort == null ? 0 : this.sort.hashCode())) * 31) + Integer.hashCode(this.displayPosition)) * 31) + Integer.hashCode(this.displayCount)) * 31) + this.albumArtist.hashCode()) * 31) + Long.hashCode(this.favouritesRevision)) * 31) + Long.hashCode(this.playlistsRevision)) * 31) + Long.hashCode(this.historyRevision);
    }

    public String toString() {
        return "PlayerState(playState=" + this.playState + ", mode=" + this.mode + ", volume=" + this.volume + ", position=" + this.position + ", duration=" + this.duration + ", title=" + this.title + ", artist=" + this.artist + ", album=" + this.album + ", path=" + this.path + ", sampleRate=" + this.sampleRate + ", bits=" + this.bits + ", bitrate=" + this.bitrate + ", lossless=" + this.lossless + ", battery=" + this.battery + ", charging=" + this.charging + ", favourite=" + this.favourite + ", accent=" + this.accent + ", queuePosition=" + this.queuePosition + ", queueCount=" + this.queueCount + ", queueRevision=" + this.queueRevision + ", scanning=" + this.scanning + ", scanCount=" + this.scanCount + ", tracks=" + this.tracks + ", sort=" + this.sort + ", displayPosition=" + this.displayPosition + ", displayCount=" + this.displayCount + ", albumArtist=" + this.albumArtist + ", favouritesRevision=" + this.favouritesRevision + ", playlistsRevision=" + this.playlistsRevision + ", historyRevision=" + this.historyRevision + ")";
    }

    public PlayerState(int playState, PlayMode mode, int volume, int position, int duration, String title, String artist, String album, String path, int sampleRate, int bits, int bitrate, boolean lossless, int battery, boolean charging, boolean favourite, String accent, int queuePosition, int queueCount, long queueRevision, boolean scanning, int scanCount, int tracks, SortPrefs sort, int displayPosition, int displayCount, String albumArtist, long favouritesRevision, long playlistsRevision, long historyRevision) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(artist, "artist");
        Intrinsics.checkNotNullParameter(album, "album");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(accent, "accent");
        Intrinsics.checkNotNullParameter(albumArtist, "albumArtist");
        this.playState = playState;
        this.mode = mode;
        this.volume = volume;
        this.position = position;
        this.duration = duration;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.path = path;
        this.sampleRate = sampleRate;
        this.bits = bits;
        this.bitrate = bitrate;
        this.lossless = lossless;
        this.battery = battery;
        this.charging = charging;
        this.favourite = favourite;
        this.accent = accent;
        this.queuePosition = queuePosition;
        this.queueCount = queueCount;
        this.queueRevision = queueRevision;
        this.scanning = scanning;
        this.scanCount = scanCount;
        this.tracks = tracks;
        this.sort = sort;
        this.displayPosition = displayPosition;
        this.displayCount = displayCount;
        this.albumArtist = albumArtist;
        this.favouritesRevision = favouritesRevision;
        this.playlistsRevision = playlistsRevision;
        this.historyRevision = historyRevision;
    }

    public /* synthetic */ PlayerState(int i, PlayMode playMode, int i2, int i3, int i4, String str, String str2, String str3, String str4, int i5, int i6, int i7, boolean z, int i8, boolean z2, boolean z3, String str5, int i9, int i10, long j, boolean z4, int i11, int i12, SortPrefs sortPrefs, int i13, int i14, String str6, long j2, long j3, long j4, int i15, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, playMode, i2, i3, i4, str, str2, str3, str4, i5, i6, i7, z, i8, z2, z3, str5, i9, i10, j, z4, i11, i12, (i15 & 8388608) != 0 ? null : sortPrefs, (i15 & 16777216) != 0 ? -1 : i13, (i15 & 33554432) != 0 ? -1 : i14, (i15 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? "" : str6, (i15 & 134217728) != 0 ? -1L : j2, (i15 & 268435456) != 0 ? -1L : j3, (i15 & 536870912) != 0 ? -1L : j4);
    }

    public final int getPlayState() {
        return this.playState;
    }

    public final PlayMode getMode() {
        return this.mode;
    }

    public final int getVolume() {
        return this.volume;
    }

    public final int getPosition() {
        return this.position;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getArtist() {
        return this.artist;
    }

    public final String getAlbum() {
        return this.album;
    }

    public final String getPath() {
        return this.path;
    }

    public final int getSampleRate() {
        return this.sampleRate;
    }

    public final int getBits() {
        return this.bits;
    }

    public final int getBitrate() {
        return this.bitrate;
    }

    public final boolean getLossless() {
        return this.lossless;
    }

    public final int getBattery() {
        return this.battery;
    }

    public final boolean getCharging() {
        return this.charging;
    }

    public final boolean getFavourite() {
        return this.favourite;
    }

    public final String getAccent() {
        return this.accent;
    }

    public final int getQueuePosition() {
        return this.queuePosition;
    }

    public final int getQueueCount() {
        return this.queueCount;
    }

    public final long getQueueRevision() {
        return this.queueRevision;
    }

    public final boolean getScanning() {
        return this.scanning;
    }

    public final int getScanCount() {
        return this.scanCount;
    }

    public final int getTracks() {
        return this.tracks;
    }

    public final SortPrefs getSort() {
        return this.sort;
    }

    public final int getDisplayPosition() {
        return this.displayPosition;
    }

    public final int getDisplayCount() {
        return this.displayCount;
    }

    public final String getAlbumArtist() {
        return this.albumArtist;
    }

    public final long getFavouritesRevision() {
        return this.favouritesRevision;
    }

    public final long getPlaylistsRevision() {
        return this.playlistsRevision;
    }

    public final long getHistoryRevision() {
        return this.historyRevision;
    }

    public final boolean isPlaying() {
        return this.playState == 1;
    }

    public final boolean getHasTrack() {
        if (this.title.length() > 0) {
            return true;
        }
        return this.path.length() > 0;
    }

    /* JADX INFO: compiled from: Models.kt */
    @Metadata(m147d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/PlayerState$Companion;", "", "()V", "EMPTY", "Lcom/mattiadoronzo/sonixlink/PlayerState;", "getEMPTY", "()Lcom/mattiadoronzo/sonixlink/PlayerState;", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PlayerState getEMPTY() {
            return PlayerState.EMPTY;
        }
    }
}

package com.mattiadoronzo.sonixlink;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Models.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b2\b\u0086\b\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\fHÆ\u0003J\t\u00103\u001a\u00020\fHÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0007HÆ\u0003J\t\u0010<\u001a\u00020\tHÆ\u0003J\t\u0010=\u001a\u00020\tHÆ\u0003J\t\u0010>\u001a\u00020\fHÆ\u0003J\t\u0010?\u001a\u00020\fHÆ\u0003J\t\u0010@\u001a\u00020\tHÆ\u0003J«\u0001\u0010A\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÆ\u0001J\u0013\u0010B\u001a\u00020\t2\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010D\u001a\u00020\u0007HÖ\u0001J\u000e\u0010E\u001a\u00020\u00032\u0006\u0010F\u001a\u00020\u0003J\t\u0010G\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\u0010\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010 \u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b!\u0010\u0019R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001eR\u0011\u0010&\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b'\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0019R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001bR\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0019R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b/\u00100¨\u0006H"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/PlayerInfo;", "", "name", "", "model", "firmware", "tracks", "", "scanning", "", "dbAvailable", "dbSize", "", "dbMtime", "coversAvailable", "coversSize", "coversMtime", "accent", "serial", "dbHash", "coversHash", "sort", "Lcom/mattiadoronzo/sonixlink/SortPrefs;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZZJJZJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/mattiadoronzo/sonixlink/SortPrefs;)V", "getAccent", "()Ljava/lang/String;", "getCoversAvailable", "()Z", "getCoversHash", "getCoversMtime", "()J", "getCoversSize", "coversVersion", "getCoversVersion", "getDbAvailable", "getDbHash", "getDbMtime", "getDbSize", "dbVersion", "getDbVersion", "getFirmware", "getModel", "getName", "getScanning", "getSerial", "getSort", "()Lcom/mattiadoronzo/sonixlink/SortPrefs;", "getTracks", "()I", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "identity", "host", "toString", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class PlayerInfo {
    private final String accent;
    private final boolean coversAvailable;
    private final String coversHash;
    private final long coversMtime;
    private final long coversSize;
    private final boolean dbAvailable;
    private final String dbHash;
    private final long dbMtime;
    private final long dbSize;
    private final String firmware;
    private final String model;
    private final String name;
    private final boolean scanning;
    private final String serial;
    private final SortPrefs sort;
    private final int tracks;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final long getCoversSize() {
        return this.coversSize;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final long getCoversMtime() {
        return this.coversMtime;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getAccent() {
        return this.accent;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getSerial() {
        return this.serial;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getDbHash() {
        return this.dbHash;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getCoversHash() {
        return this.coversHash;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final SortPrefs getSort() {
        return this.sort;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getModel() {
        return this.model;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFirmware() {
        return this.firmware;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getTracks() {
        return this.tracks;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getScanning() {
        return this.scanning;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getDbAvailable() {
        return this.dbAvailable;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getDbSize() {
        return this.dbSize;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final long getDbMtime() {
        return this.dbMtime;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getCoversAvailable() {
        return this.coversAvailable;
    }

    public final PlayerInfo copy(String name, String model, String firmware, int tracks, boolean scanning, boolean dbAvailable, long dbSize, long dbMtime, boolean coversAvailable, long coversSize, long coversMtime, String accent, String serial, String dbHash, String coversHash, SortPrefs sort) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(firmware, "firmware");
        Intrinsics.checkNotNullParameter(accent, "accent");
        Intrinsics.checkNotNullParameter(serial, "serial");
        Intrinsics.checkNotNullParameter(dbHash, "dbHash");
        Intrinsics.checkNotNullParameter(coversHash, "coversHash");
        return new PlayerInfo(name, model, firmware, tracks, scanning, dbAvailable, dbSize, dbMtime, coversAvailable, coversSize, coversMtime, accent, serial, dbHash, coversHash, sort);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayerInfo)) {
            return false;
        }
        PlayerInfo playerInfo = (PlayerInfo) other;
        return Intrinsics.areEqual(this.name, playerInfo.name) && Intrinsics.areEqual(this.model, playerInfo.model) && Intrinsics.areEqual(this.firmware, playerInfo.firmware) && this.tracks == playerInfo.tracks && this.scanning == playerInfo.scanning && this.dbAvailable == playerInfo.dbAvailable && this.dbSize == playerInfo.dbSize && this.dbMtime == playerInfo.dbMtime && this.coversAvailable == playerInfo.coversAvailable && this.coversSize == playerInfo.coversSize && this.coversMtime == playerInfo.coversMtime && Intrinsics.areEqual(this.accent, playerInfo.accent) && Intrinsics.areEqual(this.serial, playerInfo.serial) && Intrinsics.areEqual(this.dbHash, playerInfo.dbHash) && Intrinsics.areEqual(this.coversHash, playerInfo.coversHash) && Intrinsics.areEqual(this.sort, playerInfo.sort);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((this.name.hashCode() * 31) + this.model.hashCode()) * 31) + this.firmware.hashCode()) * 31) + Integer.hashCode(this.tracks)) * 31) + Boolean.hashCode(this.scanning)) * 31) + Boolean.hashCode(this.dbAvailable)) * 31) + Long.hashCode(this.dbSize)) * 31) + Long.hashCode(this.dbMtime)) * 31) + Boolean.hashCode(this.coversAvailable)) * 31) + Long.hashCode(this.coversSize)) * 31) + Long.hashCode(this.coversMtime)) * 31) + this.accent.hashCode()) * 31) + this.serial.hashCode()) * 31) + this.dbHash.hashCode()) * 31) + this.coversHash.hashCode()) * 31) + (this.sort == null ? 0 : this.sort.hashCode());
    }

    public String toString() {
        return "PlayerInfo(name=" + this.name + ", model=" + this.model + ", firmware=" + this.firmware + ", tracks=" + this.tracks + ", scanning=" + this.scanning + ", dbAvailable=" + this.dbAvailable + ", dbSize=" + this.dbSize + ", dbMtime=" + this.dbMtime + ", coversAvailable=" + this.coversAvailable + ", coversSize=" + this.coversSize + ", coversMtime=" + this.coversMtime + ", accent=" + this.accent + ", serial=" + this.serial + ", dbHash=" + this.dbHash + ", coversHash=" + this.coversHash + ", sort=" + this.sort + ")";
    }

    public PlayerInfo(String name, String model, String firmware, int tracks, boolean scanning, boolean dbAvailable, long dbSize, long dbMtime, boolean coversAvailable, long coversSize, long coversMtime, String accent, String serial, String dbHash, String coversHash, SortPrefs sort) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(firmware, "firmware");
        Intrinsics.checkNotNullParameter(accent, "accent");
        Intrinsics.checkNotNullParameter(serial, "serial");
        Intrinsics.checkNotNullParameter(dbHash, "dbHash");
        Intrinsics.checkNotNullParameter(coversHash, "coversHash");
        this.name = name;
        this.model = model;
        this.firmware = firmware;
        this.tracks = tracks;
        this.scanning = scanning;
        this.dbAvailable = dbAvailable;
        this.dbSize = dbSize;
        this.dbMtime = dbMtime;
        this.coversAvailable = coversAvailable;
        this.coversSize = coversSize;
        this.coversMtime = coversMtime;
        this.accent = accent;
        this.serial = serial;
        this.dbHash = dbHash;
        this.coversHash = coversHash;
        this.sort = sort;
    }

    public /* synthetic */ PlayerInfo(String str, String str2, String str3, int i, boolean z, boolean z2, long j, long j2, boolean z3, long j3, long j4, String str4, String str5, String str6, String str7, SortPrefs sortPrefs, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, i, z, z2, j, j2, z3, j3, j4, str4, (i2 & 4096) != 0 ? "" : str5, (i2 & 8192) != 0 ? "" : str6, (i2 & 16384) != 0 ? "" : str7, (i2 & 32768) != 0 ? null : sortPrefs);
    }

    public final String getName() {
        return this.name;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getFirmware() {
        return this.firmware;
    }

    public final int getTracks() {
        return this.tracks;
    }

    public final boolean getScanning() {
        return this.scanning;
    }

    public final boolean getDbAvailable() {
        return this.dbAvailable;
    }

    public final long getDbSize() {
        return this.dbSize;
    }

    public final long getDbMtime() {
        return this.dbMtime;
    }

    public final boolean getCoversAvailable() {
        return this.coversAvailable;
    }

    public final long getCoversSize() {
        return this.coversSize;
    }

    public final long getCoversMtime() {
        return this.coversMtime;
    }

    public final String getAccent() {
        return this.accent;
    }

    public final String getSerial() {
        return this.serial;
    }

    public final String getDbHash() {
        return this.dbHash;
    }

    public final String getCoversHash() {
        return this.coversHash;
    }

    public final SortPrefs getSort() {
        return this.sort;
    }

    public final String identity(String host) {
        Intrinsics.checkNotNullParameter(host, "host");
        String str = this.serial;
        if (str.length() == 0) {
            str = host;
        }
        return str;
    }

    public final String getDbVersion() {
        String strValueOf = this.dbHash;
        if (strValueOf.length() == 0) {
            strValueOf = String.valueOf(this.dbMtime);
        }
        return strValueOf;
    }

    public final String getCoversVersion() {
        String strValueOf = this.coversHash;
        if (strValueOf.length() == 0) {
            strValueOf = String.valueOf(this.coversMtime);
        }
        return strValueOf;
    }
}

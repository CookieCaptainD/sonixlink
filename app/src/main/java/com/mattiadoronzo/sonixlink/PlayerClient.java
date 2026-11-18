package com.mattiadoronzo.sonixlink;

import android.os.SystemClock;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.p001io.ByteStreamsKt;
import kotlin.p001io.CloseableKt;
import kotlin.p001io.TextStreamsKt;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: PlayerClient.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m147d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0003\u0018\u0000 j2\u00020\u0001:\u0001jB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u0005J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0003J\u0006\u0010\u0018\u001a\u00020\u0019J9\u0010\u001a\u001a\u00020\u00192*\u0010\u001b\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001d0\u001c\"\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001dH\u0002¢\u0006\u0002\u0010\u001eJ*\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u001a\b\u0002\u0010#\u001a\u0014\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00190$J4\u0010%\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"2\u001a\b\u0002\u0010#\u001a\u0014\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00190$H\u0002J\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'J\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020*0'2\b\b\u0002\u0010+\u001a\u00020\u0005J\u001e\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020 J\u000e\u00100\u001a\u00020\u00192\u0006\u0010-\u001a\u00020 J\u0006\u00101\u001a\u000202J\u0006\u00103\u001a\u00020\u0019J\u0010\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0002J\u0006\u00108\u001a\u00020\u0019J\u0006\u00109\u001a\u00020\u0019J\u0006\u0010:\u001a\u00020\u0019J\u001e\u0010;\u001a\u00020\u00192\u0006\u0010<\u001a\u00020\u00032\u0006\u0010=\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u0003J\"\u0010?\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010<\u001a\u00020\u00032\b\b\u0002\u0010=\u001a\u00020\u0003J\u000e\u0010@\u001a\u00020\u00192\u0006\u0010A\u001a\u00020\u0005J\u0014\u0010B\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010C\u001a\u00020\u0003J\f\u0010D\u001a\b\u0012\u0004\u0012\u00020(0'J\u0006\u0010E\u001a\u00020\u0019J\u0006\u0010F\u001a\u000205J\u001e\u0010G\u001a\u00020\u00192\u0006\u0010H\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\u00052\u0006\u0010/\u001a\u00020 J\u000e\u0010J\u001a\u0002052\u0006\u0010H\u001a\u00020\u0005J\u001c\u0010K\u001a\u00020\u00192\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00050'2\u0006\u0010/\u001a\u00020 J\u0006\u0010M\u001a\u00020\nJ0\u0010N\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010O\u001a\u00020\u00032\b\b\u0002\u0010P\u001a\u00020\u00052\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u0013H\u0002J\u000e\u0010R\u001a\u00020\u00192\u0006\u0010S\u001a\u00020\u0005J&\u0010T\u001a\u00020\u00192\u0006\u0010U\u001a\u00020\u00032\f\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00030'2\b\b\u0002\u0010W\u001a\u00020\u0003J\u001f\u0010X\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00032\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010ZJ\u000e\u0010[\u001a\u00020\u00192\u0006\u0010\\\u001a\u00020]J\u000e\u0010^\u001a\u00020\u00192\u0006\u0010_\u001a\u00020\u0005J\u0006\u0010`\u001a\u00020\u0019J\u0006\u0010a\u001a\u00020bJ\f\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00030dJ\u001a\u0010e\u001a\b\u0012\u0004\u0012\u00020f0'2\f\u0010g\u001a\b\u0012\u0004\u0012\u00020\u00030hJ\u0006\u0010i\u001a\u00020\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0011\u0010\f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\r\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006k"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/PlayerClient;", "", "host", "", "port", "", "(Ljava/lang/String;I)V", "getHost", "()Ljava/lang/String;", "isBluetooth", "", "()Z", "label", "getLabel", "getPort", "()I", NotificationCompat.CATEGORY_TRANSPORT, "Lcom/mattiadoronzo/sonixlink/Transport;", "artwork", "", "path", "maxSide", "browse", "Lcom/mattiadoronzo/sonixlink/Folder;", "bye", "", "command", "params", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)V", "downloadDatabase", "", "destination", "Ljava/io/File;", NotificationCompat.CATEGORY_PROGRESS, "Lkotlin/Function2;", "downloadFile", "favourites", "", "Lcom/mattiadoronzo/sonixlink/Row;", "history", "Lcom/mattiadoronzo/sonixlink/HistoryEntry;", "limit", "historyInsert", "id", "slot", "revision", "historyPlay", "info", "Lcom/mattiadoronzo/sonixlink/PlayerInfo;", "next", "parseQueue", "Lcom/mattiadoronzo/sonixlink/QueueWindow;", "json", "Lorg/json/JSONObject;", "pause", "ping", "play", "playAll", "list", "value", "how", "playPath", "playQueueIndex", "index", "playlistTracks", "name", "playlists", "previous", "queue", "queueMove", "from", "to", "queuePage", "queueRemove", "indices", "reachable", "request", "method", "readTimeout", "body", "seek", "seconds", "selection", "action", "paths", "playlist", "setFavourite", "starred", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "setMode", "mode", "Lcom/mattiadoronzo/sonixlink/PlayMode;", "setVolume", "percent", "startScan", "state", "Lcom/mattiadoronzo/sonixlink/PlayerState;", "thumbKeys", "", "thumbs", "Lcom/mattiadoronzo/sonixlink/Thumb;", "keys", "", "toggle", "Companion", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PlayerClient {
    public static final int DEFAULT_PORT = 7800;
    private static final int DOWNLOAD_TIMEOUT = 60000;
    private static final String TAG = "SonixLink";
    private final String host;
    private final int port;
    private final Transport transport;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final HashMap<String, Transport> transports = new HashMap<>();

    public PlayerClient(String host, int port) {
        Intrinsics.checkNotNullParameter(host, "host");
        this.host = host;
        this.port = port;
        this.transport = INSTANCE.transportFor(this.host, this.port);
    }

    public /* synthetic */ PlayerClient(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? DEFAULT_PORT : i);
    }

    public final String getHost() {
        return this.host;
    }

    public final int getPort() {
        return this.port;
    }

    /* JADX INFO: compiled from: PlayerClient.kt */
    @Metadata(m147d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0004J\u0016\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m148d2 = {"Lcom/mattiadoronzo/sonixlink/PlayerClient$Companion;", "", "()V", "DEFAULT_PORT", "", "DOWNLOAD_TIMEOUT", "TAG", "", "transports", "Ljava/util/HashMap;", "Lcom/mattiadoronzo/sonixlink/Transport;", "Lkotlin/collections/HashMap;", "release", "", "host", "port", "transportFor", "app_debug"}, m149k = 1, m150mv = {1, 9, 0}, m152xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Transport transportFor(String host, int port) {
            Object obj;
            Transport transport;
            HttpTransport httpTransport;
            Intrinsics.checkNotNullParameter(host, "host");
            synchronized (PlayerClient.transports) {
                HashMap map = PlayerClient.transports;
                String str = host + ":" + port;
                Object obj2 = map.get(str);
                if (obj2 == null) {
                    if (BluetoothTransport.INSTANCE.isBluetooth(host)) {
                        httpTransport = new BluetoothTransport(BluetoothTransport.INSTANCE.addressOf(host), null, 2, 0 == true ? 1 : 0);
                    } else {
                        httpTransport = new HttpTransport(host, port);
                    }
                    obj = httpTransport;
                    map.put(str, obj);
                } else {
                    obj = obj2;
                }
                transport = (Transport) obj;
            }
            return transport;
        }

        public final void release(String host, int port) {
            Transport transport;
            Intrinsics.checkNotNullParameter(host, "host");
            synchronized (PlayerClient.transports) {
                transport = (Transport) PlayerClient.transports.remove(host + ":" + port);
            }
            if (transport != null) {
                transport.close();
            }
        }
    }

    public final boolean isBluetooth() {
        return BluetoothTransport.INSTANCE.isBluetooth(this.host);
    }

    public final String getLabel() {
        return this.transport.getLabel();
    }

    static /* synthetic */ String request$default(PlayerClient playerClient, String str, String str2, int i, byte[] bArr, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = "GET";
        }
        if ((i2 & 4) != 0) {
            i = 4000;
        }
        if ((i2 & 8) != 0) {
            bArr = null;
        }
        return playerClient.request(str, str2, i, bArr);
    }

    private final String request(String path, String method, int readTimeout, byte[] body) throws Exception {
        Response responseExchange$default = Transport.DefaultImpls.exchange$default(this.transport, path, method, readTimeout, false, body, 8, null);
        try {
            Response response = responseExchange$default;
            Reader inputStreamReader = new InputStreamReader(response.getBody(), Charsets.UTF_8);
            String body2 = TextStreamsKt.readText(inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192));
            int code = response.getCode();
            boolean z = false;
            if (200 <= code && code < 300) {
                z = true;
            }
            if (z) {
                AutoCloseableKt.closeFinally(responseExchange$default, null);
                return body2;
            }
            throw new PlayerException(response.getCode() + " " + StringsKt.take(body2, 120));
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(responseExchange$default, th);
                throw th2;
            }
        }
    }

    public final PlayerInfo info() {
        JSONObject json = new JSONObject(request$default(this, "/api/info", null, 0, null, 14, null));
        String strOptString = json.optString("name", this.host);
        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
        String strOptString2 = json.optString("model", "");
        Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
        String strOptString3 = json.optString("firmware", "");
        Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
        int iOptInt = json.optInt("tracks", 0);
        boolean zOptBoolean = json.optBoolean("scanning", false);
        boolean zOptBoolean2 = json.optBoolean("db_available", false);
        long jOptLong = json.optLong("db_size", 0L);
        long jOptLong2 = json.optLong("db_mtime", 0L);
        boolean zOptBoolean3 = json.optBoolean("covers_available", false);
        long jOptLong3 = json.optLong("covers_size", 0L);
        long jOptLong4 = json.optLong("covers_mtime", 0L);
        String strOptString4 = json.optString("accent", "");
        Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
        String strOptString5 = json.optString("serial", "");
        Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
        String strOptString6 = json.optString("db_hash", "");
        Intrinsics.checkNotNullExpressionValue(strOptString6, "optString(...)");
        String strOptString7 = json.optString("covers_hash", "");
        Intrinsics.checkNotNullExpressionValue(strOptString7, "optString(...)");
        return new PlayerInfo(strOptString, strOptString2, strOptString3, iOptInt, zOptBoolean, zOptBoolean2, jOptLong, jOptLong2, zOptBoolean3, jOptLong3, jOptLong4, strOptString4, strOptString5, strOptString6, strOptString7, SortPrefs.INSTANCE.fromJson(json.optJSONObject("sort")));
    }

    public final PlayerState state() {
        JSONObject json = new JSONObject(request$default(this, "/api/state", null, 0, null, 14, null));
        int iOptInt = json.optInt("state", 0);
        PlayMode.Companion companion = PlayMode.INSTANCE;
        String strOptString = json.optString("mode", "normal");
        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
        PlayMode playModeFromWire = companion.fromWire(strOptString);
        int iOptInt2 = json.optInt("volume", 0);
        int iOptInt3 = json.optInt("position", 0);
        int iOptInt4 = json.optInt("duration", 0);
        String strOptString2 = json.optString("title", "");
        String strOptString3 = json.optString("artist", "");
        String strOptString4 = json.optString("album", "");
        String strOptString5 = json.optString("path", "");
        int iOptInt5 = json.optInt("sample_rate", 0);
        int iOptInt6 = json.optInt("bits", 0);
        int iOptInt7 = json.optInt("bitrate", 0);
        boolean zOptBoolean = json.optBoolean("lossless", false);
        int iOptInt8 = json.optInt("battery", -1);
        boolean zOptBoolean2 = json.optBoolean("charging", false);
        boolean zOptBoolean3 = json.optBoolean("favourite", false);
        String strOptString6 = json.optString("accent", "");
        int iOptInt9 = json.optInt("queue_position", -1);
        int iOptInt10 = json.optInt("queue_count", 0);
        long jOptLong = json.optLong("queue_revision", -1L);
        int iOptInt11 = json.optInt("display_position", -1);
        int iOptInt12 = json.optInt("display_count", -1);
        boolean zOptBoolean4 = json.optBoolean("scanning", false);
        int iOptInt13 = json.optInt("scan_count", 0);
        int iOptInt14 = json.optInt("tracks", 0);
        SortPrefs sortPrefsFromJson = SortPrefs.INSTANCE.fromJson(json.optJSONObject("sort"));
        String strOptString7 = json.optString("album_artist", "");
        long jOptLong2 = json.optLong("favourites_revision", -1L);
        long jOptLong3 = json.optLong("playlists_revision", -1L);
        long jOptLong4 = json.optLong("history_revision", -1L);
        Intrinsics.checkNotNull(strOptString2);
        Intrinsics.checkNotNull(strOptString3);
        Intrinsics.checkNotNull(strOptString4);
        Intrinsics.checkNotNull(strOptString5);
        Intrinsics.checkNotNull(strOptString6);
        Intrinsics.checkNotNull(strOptString7);
        return new PlayerState(iOptInt, playModeFromWire, iOptInt2, iOptInt3, iOptInt4, strOptString2, strOptString3, strOptString4, strOptString5, iOptInt5, iOptInt6, iOptInt7, zOptBoolean, iOptInt8, zOptBoolean2, zOptBoolean3, strOptString6, iOptInt9, iOptInt10, jOptLong, zOptBoolean4, iOptInt13, iOptInt14, sortPrefsFromJson, iOptInt11, iOptInt12, strOptString7, jOptLong2, jOptLong3, jOptLong4);
    }

    private final void command(Pair<String, String>... params) {
        String query = ArraysKt.joinToString$default(params, "&", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1<Pair<? extends String, ? extends String>, CharSequence>() { // from class: com.mattiadoronzo.sonixlink.PlayerClient$command$query$1
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final CharSequence invoke2(Pair<String, String> pair) throws UnsupportedEncodingException {
                Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
                String k = pair.component1();
                String v = pair.component2();
                return k + "=" + URLEncoder.encode(v, "UTF-8");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Pair<? extends String, ? extends String> pair) {
                return invoke2((Pair<String, String>) pair);
            }
        }, 30, (Object) null);
        request$default(this, "/api/command?" + query, "POST", 0, null, 12, null);
    }

    public final void play() {
        command(TuplesKt.m155to("do", "play"));
    }

    public final void pause() {
        command(TuplesKt.m155to("do", "pause"));
    }

    public final void toggle() {
        command(TuplesKt.m155to("do", "toggle"));
    }

    public final void next() {
        command(TuplesKt.m155to("do", "next"));
    }

    public final void previous() {
        command(TuplesKt.m155to("do", "prev"));
    }

    public final void seek(int seconds) {
        command(TuplesKt.m155to("do", "seek"), TuplesKt.m155to("value", String.valueOf(seconds)));
    }

    public final void setVolume(int percent) {
        command(TuplesKt.m155to("do", "volume"), TuplesKt.m155to("value", String.valueOf(RangesKt.coerceIn(percent, 0, 100))));
    }

    public final void setMode(PlayMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        command(TuplesKt.m155to("do", "mode"), TuplesKt.m155to("value", mode.getWire()));
    }

    public static /* synthetic */ void playPath$default(PlayerClient playerClient, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "all";
        }
        if ((i & 4) != 0) {
            str3 = "";
        }
        playerClient.playPath(str, str2, str3);
    }

    public final void playPath(String path, String list, String value) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(value, "value");
        command(TuplesKt.m155to("do", "play_path"), TuplesKt.m155to("path", path), TuplesKt.m155to("list", list), TuplesKt.m155to("value", value));
    }

    public final void startScan() {
        command(TuplesKt.m155to("do", "scan"));
    }

    public final void playQueueIndex(int index) {
        command(TuplesKt.m155to("do", "queue_index"), TuplesKt.m155to("value", String.valueOf(index)));
    }

    public final void queueRemove(List<Integer> indices, long revision) {
        Intrinsics.checkNotNullParameter(indices, "indices");
        if (indices.isEmpty()) {
            return;
        }
        byte[] bytes = CollectionsKt.joinToString$default(indices, "\n", null, null, 0, null, null, 62, null).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        request$default(this, "/api/command?do=queue_remove&rev=" + revision, "POST", 0, bytes, 4, null);
    }

    public final void queueMove(int from, int to, long revision) {
        command(TuplesKt.m155to("do", "queue_move"), TuplesKt.m155to("from", String.valueOf(from)), TuplesKt.m155to("to", String.valueOf(to)), TuplesKt.m155to("rev", String.valueOf(revision)));
    }

    public final void historyPlay(long id) {
        command(TuplesKt.m155to("do", "history_play"), TuplesKt.m155to("id", String.valueOf(id)));
    }

    public final void historyInsert(long id, int slot, long revision) {
        command(TuplesKt.m155to("do", "history_insert"), TuplesKt.m155to("id", String.valueOf(id)), TuplesKt.m155to("at", String.valueOf(slot)), TuplesKt.m155to("rev", String.valueOf(revision)));
    }

    public static /* synthetic */ List history$default(PlayerClient playerClient, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 200;
        }
        return playerClient.history(i);
    }

    public final List<HistoryEntry> history(int limit) {
        JSONObject json = new JSONObject(request$default(this, "/api/history?limit=" + limit, null, 0, null, 14, null));
        JSONArray array = json.optJSONArray("items");
        if (array == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList out = new ArrayList(array.length());
        int length = array.length();
        for (int i = 0; i < length; i++) {
            JSONObject item = array.optJSONObject(i);
            if (item != null) {
                String path = item.optString("path", "");
                Intrinsics.checkNotNull(path);
                if (!(path.length() == 0)) {
                    long jOptLong = item.optLong("id", 0L);
                    String strOptString = item.optString("title", "");
                    Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                    String strOptString2 = item.optString("artist", "");
                    Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                    out.add(new HistoryEntry(jOptLong, path, strOptString, strOptString2, item.optLong("played_at", 0L)));
                }
            }
        }
        return out;
    }

    public final void playAll(String list, String value, String how) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(how, "how");
        command(TuplesKt.m155to("do", "play_all"), TuplesKt.m155to("list", list), TuplesKt.m155to("value", value), TuplesKt.m155to("how", how));
    }

    public static /* synthetic */ void selection$default(PlayerClient playerClient, String str, List list, String str2, int i, Object obj) throws Exception {
        if ((i & 4) != 0) {
            str2 = "";
        }
        playerClient.selection(str, list, str2);
    }

    public final void selection(String action, List<String> paths, String playlist) throws Exception {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(paths, "paths");
        Intrinsics.checkNotNullParameter(playlist, "playlist");
        if (paths.isEmpty()) {
            return;
        }
        String target = "/api/command?do=" + URLEncoder.encode(action, "UTF-8");
        if (playlist.length() > 0) {
            target = target + "&value=" + URLEncoder.encode(playlist, "UTF-8");
        }
        byte[] bytes = CollectionsKt.joinToString$default(paths, "\n", null, null, 0, null, null, 62, null).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        request(target, "POST", 8000, bytes);
    }

    public static /* synthetic */ void setFavourite$default(PlayerClient playerClient, String str, Boolean bool, int i, Object obj) {
        if ((i & 2) != 0) {
            bool = null;
        }
        playerClient.setFavourite(str, bool);
    }

    public final void setFavourite(String path, Boolean starred) {
        String str;
        Intrinsics.checkNotNullParameter(path, "path");
        Pair<String, String>[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.m155to("do", "favourite");
        pairArr[1] = TuplesKt.m155to("path", path);
        if (Intrinsics.areEqual((Object) starred, (Object) true)) {
            str = "1";
        } else if (Intrinsics.areEqual((Object) starred, (Object) false)) {
            str = "0";
        } else {
            if (starred != null) {
                throw new NoWhenBranchMatchedException();
            }
            str = "";
        }
        pairArr[2] = TuplesKt.m155to("value", str);
        command(pairArr);
    }

    public final List<Row> favourites() {
        JSONObject json = new JSONObject(request$default(this, "/api/favourites", null, 0, null, 14, null));
        JSONArray array = json.optJSONArray("favourites");
        if (array == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList out = new ArrayList(array.length());
        int length = array.length();
        for (int i = 0; i < length; i++) {
            JSONObject item = array.optJSONObject(i);
            if (item != null) {
                String path = item.optString("path", "");
                Intrinsics.checkNotNull(path);
                if (!(path.length() == 0)) {
                    String strOptString = item.optString("name", "");
                    if (strOptString.length() == 0) {
                        strOptString = StringsKt.substringAfterLast$default(path, '/', (String) null, 2, (Object) null);
                    }
                    Intrinsics.checkNotNullExpressionValue(strOptString, "ifEmpty(...)");
                    String strOptString2 = item.optString("artist", "");
                    Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                    out.add(new Row(strOptString, strOptString2, path, null, 0, null, null, 0L, 0L, null, null, 0, 4088, null));
                }
            }
        }
        return out;
    }

    public final List<Row> playlists() {
        JSONObject json = new JSONObject(request$default(this, "/api/playlists", null, 0, null, 14, null));
        JSONArray array = json.optJSONArray("playlists");
        if (array == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList out = new ArrayList(array.length());
        int length = array.length();
        for (int i = 0; i < length; i++) {
            JSONObject item = array.optJSONObject(i);
            if (item != null) {
                String name = item.optString("name", "");
                Intrinsics.checkNotNull(name);
                if (!(name.length() == 0)) {
                    out.add(new Row(name, "", null, "M3U_" + name, item.optInt("count", 0), null, null, 0L, 0L, null, null, 0, 4068, null));
                }
            }
        }
        return out;
    }

    public final List<Row> playlistTracks(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        JSONObject json = new JSONObject(request$default(this, "/api/playlist?name=" + URLEncoder.encode(name, "UTF-8"), null, 0, null, 14, null));
        JSONArray array = json.optJSONArray("tracks");
        if (array == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList out = new ArrayList(array.length());
        int length = array.length();
        for (int i = 0; i < length; i++) {
            JSONObject item = array.optJSONObject(i);
            if (item != null) {
                String path = item.optString("path", "");
                Intrinsics.checkNotNull(path);
                if (!(path.length() == 0)) {
                    String strOptString = item.optString("title", "");
                    if (strOptString.length() == 0) {
                        strOptString = StringsKt.substringAfterLast$default(path, '/', (String) null, 2, (Object) null);
                    }
                    Intrinsics.checkNotNullExpressionValue(strOptString, "ifEmpty(...)");
                    String strOptString2 = item.optString("artist", "");
                    Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                    out.add(new Row(strOptString, strOptString2, path, null, 0, null, null, 0L, 0L, null, null, 0, 4088, null));
                }
            }
        }
        return out;
    }

    public final QueueWindow queue() {
        return parseQueue(new JSONObject(request$default(this, "/api/queue", null, 0, null, 14, null)));
    }

    public final QueueWindow queuePage(int from) throws InterruptedException, PlayerException {
        for (int i = 0; i < 20; i++) {
            QueueWindow page = parseQueue(new JSONObject(request$default(this, "/api/queue?from=" + from, null, 0, null, 14, null)));
            if (!page.getPending()) {
                return page;
            }
            Thread.sleep(150L);
        }
        throw new PlayerException("the queue did not arrive");
    }

    private final QueueWindow parseQueue(JSONObject json) {
        JSONArray array = json.optJSONArray("paths");
        ArrayList paths = new ArrayList(array != null ? array.length() : 0);
        int length = array != null ? array.length() : 0;
        for (int i = 0; i < length; i++) {
            Intrinsics.checkNotNull(array);
            paths.add(array.optString(i, ""));
        }
        return new QueueWindow(json.optInt("count", 0), json.optInt("position", -1), json.optInt("first", 0), paths, json.optLong("revision", -1L), json.optBoolean("pending", false));
    }

    public final Folder browse(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        String query = path.length() == 0 ? "" : "?path=" + URLEncoder.encode(path, "UTF-8");
        JSONObject json = new JSONObject(request$default(this, "/api/browse" + query, null, 0, null, 14, null));
        JSONArray array = json.optJSONArray("entries");
        ArrayList entries = new ArrayList(array != null ? array.length() : 0);
        int length = array != null ? array.length() : 0;
        for (int i = 0; i < length; i++) {
            Intrinsics.checkNotNull(array);
            JSONObject item = array.optJSONObject(i);
            if (item != null) {
                String strOptString = item.optString("name", "");
                Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                String strOptString2 = item.optString("path", "");
                Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                entries.add(new FolderEntry(strOptString, strOptString2, item.optBoolean("dir", false)));
            }
        }
        String strOptString3 = json.optString("path", "");
        Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
        String strOptString4 = json.optString("root", "");
        Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
        String strOptString5 = json.optString("parent", "");
        Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
        return new Folder(strOptString3, strOptString4, strOptString5, entries);
    }

    public final void ping() {
        request$default(this, "/api/ping", null, 0, null, 14, null);
    }

    public final void bye() {
        request$default(this, "/api/bye", null, 1500, null, 10, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ long downloadDatabase$default(PlayerClient playerClient, File file, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = new Function2<Long, Long, Unit>() { // from class: com.mattiadoronzo.sonixlink.PlayerClient.downloadDatabase.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2) {
                    invoke(l.longValue(), l2.longValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(long j, long j2) {
                }
            };
        }
        return playerClient.downloadDatabase(file, function2);
    }

    public final long downloadDatabase(File destination, Function2<? super Long, ? super Long, Unit> progress) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(progress, "progress");
        return downloadFile("/api/db", destination, progress);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ long downloadFile$default(PlayerClient playerClient, String str, File file, Function2 function2, int i, Object obj) {
        if ((i & 4) != 0) {
            function2 = new Function2<Long, Long, Unit>() { // from class: com.mattiadoronzo.sonixlink.PlayerClient.downloadFile.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2) {
                    invoke(l.longValue(), l2.longValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(long j, long j2) {
                }
            };
        }
        return playerClient.downloadFile(str, file, function2);
    }

    private final long downloadFile(String path, File destination, Function2<? super Long, ? super Long, Unit> progress) throws Exception {
        Throwable th;
        Response responseExchange$default = Transport.DefaultImpls.exchange$default(this.transport, path, "GET", DOWNLOAD_TIMEOUT, true, null, 16, null);
        try {
            Response response = responseExchange$default;
            int i = 0;
            int code = response.getCode();
            try {
                if (code == 503) {
                    throw new ScanningException();
                }
                if (code == 404) {
                    throw new MissingException();
                }
                if (!(200 <= code && code < 300)) {
                    throw new PlayerException(String.valueOf(code));
                }
                long total = response.getLength();
                File temporary = new File(destination.getParentFile(), destination.getName() + ".part");
                long written = 0;
                InputStream input = response.getBody();
                FileOutputStream fileOutputStream = new FileOutputStream(temporary);
                try {
                    FileOutputStream output = fileOutputStream;
                    byte[] chunk = new byte[65536];
                    long told = 0;
                    try {
                        progress.invoke(0L, Long.valueOf(total));
                        while (true) {
                            int read = input.read(chunk);
                            if (read <= 0) {
                                break;
                            }
                            try {
                                output.write(chunk, 0, read);
                                i = i;
                                written += (long) read;
                                try {
                                    long now = SystemClock.uptimeMillis();
                                    if (now - told >= 200) {
                                        told = now;
                                        progress.invoke(Long.valueOf(written), Long.valueOf(total));
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                th = th;
                                throw th;
                            }
                            th = th2;
                            try {
                                throw th;
                            } catch (Throwable th4) {
                                CloseableKt.closeFinally(fileOutputStream, th);
                                throw th4;
                            }
                        }
                        progress.invoke(Long.valueOf(written), Long.valueOf(total));
                        output.getFD().sync();
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(fileOutputStream, null);
                        if (total > 0 && written != total) {
                            temporary.delete();
                            throw new PlayerException("got " + written + " bytes of " + total);
                        }
                        if (destination.exists() && !destination.delete()) {
                            Log.w(TAG, "cannot remove the old index");
                        }
                        if (temporary.renameTo(destination)) {
                            AutoCloseableKt.closeFinally(responseExchange$default, null);
                            return written;
                        }
                        temporary.delete();
                        throw new PlayerException("cannot move the index into place");
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Throwable th7) {
                th = th7;
                Throwable th8 = th;
                try {
                    throw th8;
                } catch (Throwable th9) {
                    AutoCloseableKt.closeFinally(responseExchange$default, th8);
                    throw th9;
                }
            }
        } catch (Throwable th10) {
            th = th10;
        }
    }

    public final Set<String> thumbKeys() throws Exception {
        Response responseExchange$default = Transport.DefaultImpls.exchange$default(this.transport, "/api/thumbkeys", "GET", DOWNLOAD_TIMEOUT, true, null, 16, null);
        try {
            Response response = responseExchange$default;
            if (response.getCode() == 404) {
                throw new MissingException();
            }
            int code = response.getCode();
            boolean z = false;
            if (200 <= code && code < 300) {
                z = true;
            }
            if (!z) {
                throw new PlayerException(String.valueOf(response.getCode()));
            }
            byte[] bytes = ByteStreamsKt.readBytes(response.getBody());
            HashSet out = new HashSet((bytes.length / 8) * 2);
            for (int at = 0; at + 8 <= bytes.length; at += 8) {
                long v = 0;
                for (int i = 7; -1 < i; i--) {
                    v = (v << 8) | (((long) bytes[at + i]) & 255);
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = String.format(Locale.US, "%016x", Arrays.copyOf(new Object[]{Long.valueOf(v)}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                out.add(str);
            }
            HashSet hashSet = out;
            AutoCloseableKt.closeFinally(responseExchange$default, null);
            return hashSet;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(responseExchange$default, th);
                throw th2;
            }
        }
    }

    public final List<Thumb> thumbs(Collection<String> keys) throws Exception {
        int n;
        Intrinsics.checkNotNullParameter(keys, "keys");
        if (keys.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        String query = CollectionsKt.joinToString$default(keys, ",", null, null, 0, null, null, 62, null);
        Response responseExchange$default = Transport.DefaultImpls.exchange$default(this.transport, "/api/thumbs?keys=" + query, "GET", DOWNLOAD_TIMEOUT, true, null, 16, null);
        try {
            Response response = responseExchange$default;
            if (response.getCode() == 404) {
                throw new MissingException();
            }
            int code = response.getCode();
            int h = 1;
            int n2 = 0;
            if (!(200 <= code && code < 300)) {
                throw new PlayerException(String.valueOf(response.getCode()));
            }
            DataInputStream input = new DataInputStream(new BufferedInputStream(response.getBody()));
            ArrayList out = new ArrayList(keys.size());
            int i = 16;
            byte[] keyBytes = new byte[16];
            int i2 = 8;
            byte[] head = new byte[8];
            while (true) {
                try {
                    input.readFully(keyBytes);
                    input.readFully(head);
                    int w = (head[n2] & 255) | ((head[h] & 255) << i2);
                    int h2 = ((head[3] & 255) << i2) | (head[2] & 255);
                    n = ((head[5] & 255) << i2) | (head[4] & 255) | ((head[6] & 255) << i) | ((head[7] & 255) << 24);
                    if (n < 0 || n > 4194304) {
                        break;
                    }
                    byte[] pixels = new byte[n];
                    input.readFully(pixels);
                    out.add(new Thumb(new String(keyBytes, Charsets.US_ASCII), w, h2, pixels));
                    i = 16;
                    h = 1;
                    n2 = 0;
                    i2 = 8;
                } catch (EOFException e) {
                    ArrayList arrayList = out;
                    AutoCloseableKt.closeFinally(responseExchange$default, null);
                    return arrayList;
                }
            }
            throw new PlayerException("bad thumbnail length " + n);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(responseExchange$default, th);
                throw th2;
            }
        }
    }

    public static /* synthetic */ byte[] artwork$default(PlayerClient playerClient, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return playerClient.artwork(str, i);
    }

    public final byte[] artwork(String path, int maxSide) throws Exception {
        int read;
        Intrinsics.checkNotNullParameter(path, "path");
        String target = "/api/art?path=" + URLEncoder.encode(path, "UTF-8");
        if (maxSide > 0) {
            target = target + "&max=" + maxSide;
        }
        Response responseExchange$default = Transport.DefaultImpls.exchange$default(this.transport, target, "GET", DOWNLOAD_TIMEOUT, true, null, 16, null);
        try {
            Response response = responseExchange$default;
            if (response.getCode() == 404) {
                AutoCloseableKt.closeFinally(responseExchange$default, null);
                return null;
            }
            if (response.getCode() == 202) {
                throw new ArtPending();
            }
            if (response.getCode() != 200) {
                throw new PlayerException(String.valueOf(response.getCode()));
            }
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] chunk = new byte[65536];
            while (out.size() < 8388608 && (read = response.getBody().read(chunk)) > 0) {
                out.write(chunk, 0, read);
            }
            byte[] byteArray = out.size() > 0 ? out.toByteArray() : null;
            AutoCloseableKt.closeFinally(responseExchange$default, null);
            return byteArray;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(responseExchange$default, th);
                throw th2;
            }
        }
    }

    public final boolean reachable() {
        try {
            info();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

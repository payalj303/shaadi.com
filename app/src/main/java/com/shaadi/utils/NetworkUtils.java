package com.shaadi.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @author Payal Jian
 * @version 1.0
 * @since 14/Feb/21
 */
public final class NetworkUtils {

    private NetworkUtils() {
        // This class is not publicly instantiable
    }

    /**
     * @param context of an application
     * @return network is connected or not
     */
    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        }
        return false;
    }
}

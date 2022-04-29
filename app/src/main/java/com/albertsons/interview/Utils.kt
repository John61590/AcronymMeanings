package com.albertsons.interview

import android.content.Context
import android.net.ConnectivityManager
import android.os.Build


object Utils {
    fun isInternetConnected(getApplicationContext: Context): Boolean {
        val cm = getApplicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (cm.activeNetwork != null && cm.getNetworkCapabilities(cm.activeNetwork) != null) {
            return true
        }
        return false
    }
}
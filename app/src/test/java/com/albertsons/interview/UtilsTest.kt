package com.albertsons.interview


import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import org.robolectric.shadows.ShadowNetworkCapabilities

@RunWith(RobolectricTestRunner::class)
class UtilsTest {

    @Test
    fun `Given an active network and WiFi capability, when checking internet connection, then return true`() {
        //Given
        val connectivityManager = getApplicationContext<Context>().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkCapabilities = ShadowNetworkCapabilities.newInstance()
        shadowOf(networkCapabilities).addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
        shadowOf(connectivityManager).setNetworkCapabilities(connectivityManager.activeNetwork, networkCapabilities)
        //When
        val result = Utils.isInternetConnected(getApplicationContext())
        //Then
        assertThat(result, IsEqual(true))
    }

    @Test
    fun `Given an null active network and WiFi capability, when checking internet connection, then return false`() {
        //Given
        val connectivityManager = getApplicationContext<Context>().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkCapabilities = ShadowNetworkCapabilities.newInstance()
        shadowOf(networkCapabilities).addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
        shadowOf(connectivityManager).setNetworkCapabilities(connectivityManager.activeNetwork, null)

        //When
        val result = Utils.isInternetConnected(getApplicationContext())

        //Then
        assertThat(result, IsEqual(false))
    }
}
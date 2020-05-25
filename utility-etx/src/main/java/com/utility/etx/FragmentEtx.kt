package com.utility.etx

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


inline fun <reified T : AppCompatActivity> Fragment.startActivityEtx(
    packageContext: Context
) =
    Intent(packageContext, T::class.java).apply { startActivity(this) }

inline fun <reified T : AppCompatActivity> Fragment.startActivityEtx(
    packageContext: Context,
    requestCode: Int
) =
    Intent(packageContext, T::class.java).apply { startActivityForResult(this, requestCode) }

@SuppressLint("MissingPermission")
fun Fragment.hasNetwork(): Boolean {
    val connectivityManager =
        activity?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
        return when {
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    } else {
        connectivityManager.activeNetworkInfo?.run {
            return when (type) {
                ConnectivityManager.TYPE_WIFI -> true
                ConnectivityManager.TYPE_MOBILE -> true
                ConnectivityManager.TYPE_ETHERNET -> true
                else -> false
            }
        }
    }
    return false
}
package com.utility.etx

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

inline fun <reified A : AppCompatActivity> Activity.startActivityEtx(configIntent: Intent.() -> Unit = {}) {
    startActivity(Intent(this, A::class.java).apply(configIntent))
}

inline fun <reified T : AppCompatActivity> Activity.startActivityEtx() = Intent(this, T::class.java)
    .apply { startActivity(this) }

inline fun <reified T : AppCompatActivity> Activity.startActivityEtx(requestCode: Int) =
    Intent(this, T::class.java).apply { startActivityForResult(this, requestCode) }

fun Activity.getProgressDialog(): ProgressDialog {
    return ProgressDialog(this).apply {
        setCancelable(false)
        setMessage("Please Wait...")
    }
}

fun Activity.getDrawableEtx(@DrawableRes drawableResource: Int): Drawable? =
    ContextCompat.getDrawable(this, drawableResource)

fun Activity.getColorEtx(@ColorRes color: Int) = ContextCompat.getColor(this, color)

@SuppressLint("MissingPermission")
fun AppCompatActivity.hasNetwork(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
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

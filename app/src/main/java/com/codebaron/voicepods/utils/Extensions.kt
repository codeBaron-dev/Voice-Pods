package com.codebaron.voicepods.utils

import android.content.Context
import android.net.ConnectivityManager

/**
 * @author Anyanwu Nicholas
 * @since Jul 23 - 2022
 * @NoteToFutureMe This file will and contains shared functions used across this app,
 * only add dynamic functions
 */
fun isNetworkAvailable(context: Context): Boolean {
    val connectMgr: ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetworkInfo = connectMgr.activeNetworkInfo
    return activeNetworkInfo != null && activeNetworkInfo.isConnected
}
package com.codebaron.voicepods.utils

import android.content.Context
import android.net.ConnectivityManager
import com.codebaron.voicepods.repository.BASE_URL_HEADER_1
import com.codebaron.voicepods.repository.BASE_URL_HEADER_1_KEY
import com.codebaron.voicepods.repository.BASE_URL_HEADER_2
import com.codebaron.voicepods.repository.BASE_URL_HEADER_2_KEY

/**
 * @author Anyanwu Nicholas
 * @since Jul 23 - 2022
 * @NoteToFutureMe This file will and contains shared functions used across this app,
 * only add dynamic functions and ensure each functions are well documented
 */

/**
 * @param context
 * @return checks if network is available and returns a true or false value
 */
fun isNetworkAvailable(context: Context): Boolean {
    val connectMgr: ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetworkInfo = connectMgr.activeNetworkInfo
    return activeNetworkInfo != null && activeNetworkInfo.isConnected
}

/**
 * @return this function returns authorization headers used during api request
 */
fun getHeaderMap(): Map<String, String> {
    val headerMap = mutableMapOf<String, String>()
    headerMap[BASE_URL_HEADER_1] = BASE_URL_HEADER_1_KEY
    headerMap[BASE_URL_HEADER_2] = BASE_URL_HEADER_2_KEY
    return headerMap
}
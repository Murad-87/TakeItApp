package com.example.takeitapp.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi
import retrofit2.HttpException
import retrofit2.Response
import javax.inject.Inject

class ApiHelper(private val context: Context) {

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false

        return when {
            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }

    suspend fun <T> apiResponsesHandler(apiCall: suspend () -> Response<T>): T {
        if (!isNetworkAvailable()) {
            throw Exception("No internet connection")
        }

        val result: Response<T>
        try {
            result = apiCall()
        } catch (throwable: Throwable) {
            when (throwable) {
                is HttpException -> throw Exception("Error ${throwable.code()}: ${throwable.message()}")
                else -> throw throwable
            }
        }

        if (result.isSuccessful && result.body() != null) {
            return result.body()!!
        } else {
            throw Exception("Error ${result.code()}: ${result.message()}")
        }
    }
}
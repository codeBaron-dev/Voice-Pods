package com.codebaron.voicepods.repository.manager

import coil.network.HttpException
import okhttp3.ResponseBody
import retrofit2.Response

/**
 * @author Anyanwu Nicholas(codeBaron)
 * @since Jul 23 - 2022
 */
abstract class BaseServices {

    /**
     * @param message
     */
    protected abstract fun parseCustomErrorMessage(message: ResponseBody?): HttpException

    /**
     * @return NullPointerException
     */
    protected abstract fun nullResponseBody(): NullPointerException

    /**
     * @param call
     * @return Result<T?>
     */
    protected suspend fun <T: Any> apiCall(call: suspend () -> Response<T>): ResponseResult<T> {
        val response: Response<T>
        try {
            response = call.invoke()
        } catch (throwable: Throwable) {
            return ResponseResult.ThrowableException(throwable)
        }
        return if (!response.isSuccessful) {
            val errorBody = response.errorBody()
            ResponseResult.Error(parseCustomErrorMessage(errorBody))
        } else {
            return if (response.body() == null) {
                ResponseResult.NullException(nullResponseBody())
            } else {
                ResponseResult.Success(response.body())
            }
        }
    }
}
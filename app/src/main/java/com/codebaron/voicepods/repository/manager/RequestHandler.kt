package com.codebaron.voicepods.repository.manager

import retrofit2.Response

/**
 * @author Anyanwu Nicholas(codeBaron)
 * @since Jul 23 - 2022
 */
class RequestHandler {
    /**
     * @param call
     * @return [ResponseResult]<T>
     * @NoteToFutureMes this file handles all retrofit network calls and returns the
     * request responseBody
     */
    suspend fun <T : Any> apiCall(call: suspend () -> Response<T>): ResponseResult<T> {
        val response: Response<T>
        try {
            response = call.invoke()
        } catch (throwable: Throwable) {
            return ResponseResult.ThrowableException(throwable)
        }
        return if (!response.isSuccessful) {
            val errorBody = response.errorBody()
            //TODO: create a custom object to map errorBody
            ResponseResult.Error(Exception())
        } else {
            return if (response.body() == null) {
                ResponseResult.NullException(NullPointerException())
            } else {
                ResponseResult.Success(response.body())
            }
        }
    }
}
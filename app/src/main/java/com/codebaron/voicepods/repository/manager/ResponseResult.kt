package com.codebaron.voicepods.repository.manager

import coil.network.HttpException

/**
 * @author Anyanwu Nicholas(codeBaron)
 * @since Jul 23 - 2022
 */
sealed class ResponseResult<out T: Any> {
    /**
     * @param data
     * @return ResponseResult<Nothing>
     */
    data class Success<out T : Any>(val data: T?) : ResponseResult<T>()

    /**
     * @param exception
     * @return ResponseResult<Nothing>
     */
    data class Error(val exception: HttpException) : ResponseResult<Nothing>()

    /**
     * @param nullPointerException
     * @return ResponseResult<Nothing>
     */
    data class NullException(val nullPointerException: NullPointerException): ResponseResult<Nothing>()

    /**
     * @param throwable
     * @return ResponseResult<Nothing>
     */
    data class ThrowableException(val throwable: Throwable): ResponseResult<Nothing>()
}
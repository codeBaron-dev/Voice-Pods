package com.codebaron.voicepods.repository.manager

/**
 * @author Anyanwu Nicholas(codeBaron)
 * @since Jul 23 - 2022
 */
sealed class ResponseResult<out T> {
    /**
     * @param data
     * @return [ResponseResult]<Nothing>
     */
    data class Success<out T>(val data: T?) : ResponseResult<T>()

    /**
     * @param exception
     * @return [ResponseResult]<Nothing>
     */
    data class Error(val exception: Exception) : ResponseResult<Nothing>()

    /**
     * @param nullPointerException
     * @return [ResponseResult]<Nothing>
     */
    data class NullException(val nullPointerException: NullPointerException): ResponseResult<Nothing>()

    /**
     * @param throwable
     * @return [ResponseResult]<Nothing>
     */
    data class ThrowableException(val throwable: Throwable): ResponseResult<Nothing>()
}
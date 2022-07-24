package com.codebaron.voicepods.mvvm

import android.content.Context
import com.codebaron.voicepods.models.genre.PodcastGenres
import com.codebaron.voicepods.models.podx.Result
import com.codebaron.voicepods.repository.ApiEndPoint
import com.codebaron.voicepods.repository.Repositories
import com.codebaron.voicepods.repository.manager.RequestHandler
import com.codebaron.voicepods.repository.manager.ResponseResult
import com.codebaron.voicepods.utils.getHeaderMap
import javax.inject.Inject

/**
 * @author Anyanwu Nicholas
 * @since Jul 23 - 2022
 */

/**
 * @param apiEndPoint
 * @param requestHandler
 * @return [Repositories]
 */
class RequestRepositories @Inject constructor(
    private val apiEndPoint: ApiEndPoint,
    private val requestHandler: RequestHandler
) : Repositories {

    /**
     * @param searchParam
     * @param language
     * @param safeMode
     * @param context
     * @return List<[Result]>?
     */
    override suspend fun searchPodcast(
        searchParam: String,
        language: String,
        safeMode: String
    ): List<Result>? {
        val request = requestHandler.apiCall {
            apiEndPoint.searchPodcast(
                getHeaderMap(),
                searchParam,
                language,
                safeMode
            )
        }
        return when (request) {
            is ResponseResult.Success -> request.data?.results
            is ResponseResult.Error -> throw request.exception
            else -> emptyList()
        }
    }

    /**
     * @return [PodcastGenres]
     */
    override suspend fun getPodcastGenre(): PodcastGenres? {
        TODO("Not yet implemented")
    }
}
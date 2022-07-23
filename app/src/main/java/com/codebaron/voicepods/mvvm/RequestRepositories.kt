package com.codebaron.voicepods.mvvm

import android.content.Context
import com.codebaron.voicepods.models.genre.PodcastGenres
import com.codebaron.voicepods.models.podx.Result
import com.codebaron.voicepods.repository.ApiEndPoint
import com.codebaron.voicepods.repository.Repositories
import javax.inject.Inject

/**
 * @author Anyanwu Nicholas
 * @since Jul 23 - 2022
 */

/**
 * @param apiEndPoint
 * @return Repositories
 */
class RequestRepositories @Inject constructor(private val apiEndPoint: ApiEndPoint):
    Repositories {

    /**
     * @param searchParam
     * @param language
     * @param safeMode
     * @param context
     * @return List<Result>
     */
    override suspend fun searchPodcast(
        searchParam: String,
        language: String,
        safeMode: String,
        context: Context
    ): List<Result>? {
        TODO("Not yet implemented")
    }

    /**
     * @return PodcastGenres
     */
    override suspend fun getPodcastGenre(): PodcastGenres? {
        TODO("Not yet implemented")
    }
}
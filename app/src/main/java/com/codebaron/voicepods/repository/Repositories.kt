package com.codebaron.voicepods.repository

import android.content.Context
import com.codebaron.voicepods.models.genre.PodcastGenres
import com.codebaron.voicepods.models.podx.Result

interface Repositories {
    /**
     * @param searchParam
     * @param language
     * @param safeMode
     * @param context
     * @return List<Result>
     */
    suspend fun searchPodcast(searchParam: String, language: String, safeMode: String, context: Context): List<Result>?
    /**
     * @return PodcastGenres
     */
    suspend fun getPodcastGenre(): PodcastGenres?
}
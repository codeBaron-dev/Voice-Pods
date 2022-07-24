package com.codebaron.voicepods.repository

import com.codebaron.voicepods.models.genre.PodcastGenres
import com.codebaron.voicepods.models.podx.Result

/**
 * @author Anyanwu Nicholas(codeBaron)
 * @since Jul 23 - 2022
 */
interface Repositories {

    /**
     * @param searchParam
     * @param language
     * @param safeMode
     * @param context
     * @return List<[Result]>
     */
    suspend fun searchPodcast(searchParam: String, language: String, safeMode: String): List<Result>?
    /**
     * @return [PodcastGenres]
     */
    suspend fun getPodcastGenre(): PodcastGenres?
}
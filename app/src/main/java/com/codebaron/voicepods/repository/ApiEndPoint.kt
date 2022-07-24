package com.codebaron.voicepods.repository

import com.codebaron.voicepods.models.genre.PodcastGenres
import com.codebaron.voicepods.models.podx.Podcasts
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Query

/**
 * @author Anyanwu Nicholas(codeBaron)
 * @since Jul 23 - 2022
 */
interface ApiEndPoint {

    /**
     * @param headers
     * @param searchContent
     * @param language
     * @param safetyMode
     * @return Response<[Podcasts]>
     */
    @GET(FULL_TEXT_SEARCH)
    suspend fun searchPodcast(
        @HeaderMap headers: Map<String, String>,
        @Query("q", encoded = true) searchContent: String,
        @Query("language", encoded = true) language: String,
        @Query("safe_mode", encoded = true) safetyMode: String,
    ): Response<Podcasts>

    /**
     * @param headers
     * @return Response<[PodcastGenres]>
     */
    @GET(GENRES)
    suspend fun getPodcastGenre(@HeaderMap headers: Map<String, String>): Response<PodcastGenres>
}
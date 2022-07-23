package com.codebaron.voicepods.models.genre

/**
 * @author Anyanwu Nicholas(codeBaron)
 * @since Jul 23 - 2022
 */
data class PodcastGenres(
    val genres: List<Genre>
)

val dummyPodcastGenres = PodcastGenres(dummyGenres)
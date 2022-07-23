package com.codebaron.voicepods.hiltinjection

import com.codebaron.voicepods.repository.ApiEndPoint
import com.codebaron.voicepods.repository.LISTEN_NOTE_BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

/**
 * @author Anyanwu Nicholas(codeBaron)
 * @since Jul 23 - 2022
 */
@Module @InstallIn(SingletonComponent::class)
class ProviderModule {

    /**
     * @return LISTEN_NOTE_BASE_URL
     */
    @Provides
    @Named("BaseUrl")
    fun provideBaseUrl() = LISTEN_NOTE_BASE_URL.toHttpUrl()

    /**
     * @param baseUrl
     * @return Retrofit
     */
    @Singleton
    @Provides
    fun provideRetrofit(@Named("BaseUrl") baseUrl: HttpUrl): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    /**
     * @param retrofit
     * @return ApiEndPoint
     */
    @Provides
    @Singleton
    fun providerNewsProvider(retrofit: Retrofit): ApiEndPoint =
        retrofit.create(ApiEndPoint::class.java)
}
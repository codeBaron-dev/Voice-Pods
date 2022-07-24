package com.codebaron.voicepods.hiltinjection

import com.codebaron.voicepods.mvvm.RequestRepositories
import com.codebaron.voicepods.repository.ApiEndPoint
import com.codebaron.voicepods.repository.Repositories
import com.codebaron.voicepods.repository.manager.RequestHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author Anyanwu Nicholas(codeBaron)
 * @since Jul 23 - 2022
 */
@Module @InstallIn(SingletonComponent::class)
class RepositoryModule {

    /**
     * @param provider
     * @return [Repositories]
     */
    @Provides
    @Singleton
    fun providerPodsRepository(provider: ApiEndPoint, requestHandler: RequestHandler): Repositories =
        RequestRepositories(provider, requestHandler)
}
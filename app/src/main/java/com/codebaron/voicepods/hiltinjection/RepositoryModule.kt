package com.codebaron.voicepods.hiltinjection

import com.codebaron.voicepods.repository.ApiEndPoint
import com.codebaron.voicepods.repository.Repositories
import com.codebaron.voicepods.repository.RepositoriesImplementation
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
     * @return Repositories
     */
    @Provides
    @Singleton
    fun providerNewsRepository(provider: ApiEndPoint): Repositories =
        RepositoriesImplementation(provider)
}
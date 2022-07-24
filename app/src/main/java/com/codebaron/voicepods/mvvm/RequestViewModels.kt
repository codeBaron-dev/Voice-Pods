package com.codebaron.voicepods.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codebaron.voicepods.models.podx.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author Anyanwu Nicholas(codeBaron)
 * @since Jul 23 - 2022
 */

/**
 * @param requestRepositories
 * @return [ViewModel]
 */
@HiltViewModel
class RequestViewModels @Inject constructor(private val requestRepositories: RequestRepositories) :
    ViewModel() {
    private var podcasts = MutableLiveData<List<Result>?>()

    /**
     * @param searchParam
     * @param language
     * @param safeMode
     * @return LiveData<List<[Result]>?>
     */
    fun searchedPodcastResult(
        searchParam: String,
        language: String,
        safeMode: String
    ): LiveData<List<Result>?> {
        viewModelScope.launch {
            podcasts.postValue(requestRepositories.searchPodcast(searchParam, language, safeMode))
        }
        return podcasts
    }
}
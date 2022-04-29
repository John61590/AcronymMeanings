package com.albertsons.interview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.albertsons.interview.network.model.Abbreviation
import com.albertsons.interview.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val apiRepository: ApiRepository
): ViewModel() {

    fun getAcronymResponse(shortForm: String) : MutableLiveData<List<Abbreviation>> {
        return apiRepository.getAcronymResponse(shortForm)
    }
}
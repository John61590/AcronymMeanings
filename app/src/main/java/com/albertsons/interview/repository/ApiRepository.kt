package com.albertsons.interview.repository

import androidx.lifecycle.MutableLiveData
import com.albertsons.interview.network.AcronymService
import com.albertsons.interview.network.model.Abbreviation
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiRepository @Inject constructor(private val acronymService: AcronymService) {
    fun getAcronymResponse(acronym: String) : MutableLiveData<List<Abbreviation>> {
        val listData = MutableLiveData<List<Abbreviation>>()
        acronymService.getMeaningList(acronym)
            .enqueue(object: Callback<List<Abbreviation>> {
                override fun onResponse(
                    call: Call<List<Abbreviation>>,
                    response: Response<List<Abbreviation>>
                ) {
                    if (response.isSuccessful) {
                        listData.value = response.body()
                    }
                }

                override fun onFailure(call: Call<List<Abbreviation>>, t: Throwable) {
                    listData.value = null
                    t.printStackTrace()
                }
            })
        return listData
    }
}
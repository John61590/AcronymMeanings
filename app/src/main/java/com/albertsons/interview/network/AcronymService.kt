package com.albertsons.interview.network

import com.albertsons.interview.network.model.Abbreviation
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AcronymService {
    @GET("software/acromine/dictionary.py")
    fun getMeaningList(@Query("sf") acronym: String): Call<List<Abbreviation>>
}
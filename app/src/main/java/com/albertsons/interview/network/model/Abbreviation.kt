package com.albertsons.interview.network.model

import com.google.gson.annotations.SerializedName

data class Abbreviation (
    @SerializedName("sf")
    val abbreviation: String,
    @SerializedName("lfs")
    val longForms: List<LongForm>
)
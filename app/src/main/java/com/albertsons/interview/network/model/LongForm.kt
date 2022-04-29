package com.albertsons.interview.network.model

import com.google.gson.annotations.SerializedName

data class LongForm(
    @SerializedName("lf")
    val meaning: String,
    @SerializedName("vars")
    val variations: List<LongForm>
)

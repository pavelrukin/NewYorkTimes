package com.pavelrukin.newyorktimes.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

data class TopStoriesResponse(
    @SerializedName("results")
    var topStoriesResults: MutableList<TopStoriesResult>,
) {
    @Parcelize
    data class TopStoriesResult(
        @SerializedName("title")
        var title: String, // Marvel’s Latest Frontier? In ‘WandaVision,’ It’s the Suburbs
        @SerializedName("url")
        var url: String, // https://www.nytimes.com/2021/01/08/arts/television/wandavision-elizabeth-olsen-paul-bettany.html
        @SerializedName("multimedia")
        var multimedia: @RawValue List<Multimedia>,
    ):Parcelable

    data class Multimedia(
        @SerializedName("url")
        var url: String, // https://static01.nyt.com/images/2021/01/10/arts/10wandavision-1/merlin_181107681_a6f9c562-6a6d-42d4-ae18-02a4d773ecea-superJumbo.jpg
    )
}




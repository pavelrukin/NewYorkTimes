package com.pavelrukin.newyorktimes.model


import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class TopStoriesResponse(
    @SerializedName("status")
    var status: String, // OK
    @SerializedName("copyright")
    var copyright: String, // Copyright (c) 2021 The New York Times Company. All Rights Reserved.
    @SerializedName("section")
    var section: String, // Arts
    @SerializedName("last_updated")
    var lastUpdated: String, // 2021-01-08T18:20:46-05:00
    @SerializedName("num_results")
    var numResults: Int, // 34
    @SerializedName("results")
    var topStoriesResults: MutableList<TopStoriesResult>,
) {

    @Entity(tableName = "topStoriesResult")
    data class TopStoriesResult(
        @SerializedName("section")
        var section: String, // arts
        @SerializedName("subsection")
        var subsection: String, // television
        @SerializedName("title")
        var title: String, // Marvel’s Latest Frontier? In ‘WandaVision,’ It’s the Suburbs
        @SerializedName("abstract")
        var abstract: String, // Marvel’s first series for Disney+ is part drama, part homage to vintage sitcoms, following the misfit heroes played by Elizabeth Olsen and Paul Bettany to some weird places.
        @PrimaryKey
        @SerializedName("url")
        var url: String, // https://www.nytimes.com/2021/01/08/arts/television/wandavision-elizabeth-olsen-paul-bettany.html
        @SerializedName("uri")
        var uri: String, // nyt://article/1d13fe1b-9981-5c21-b891-64aed45c141b
        @SerializedName("byline")
        var byline: String, // By Dave Itzkoff
        @SerializedName("item_type")
        var itemType: String, // Article
        @SerializedName("updated_date")
        var updatedDate: String, // 2021-01-08T18:52:15-05:00
        @SerializedName("created_date")
        var createdDate: String, // 2021-01-08T10:00:11-05:00
        @SerializedName("published_date")
        var publishedDate: String, // 2021-01-08T10:00:11-05:00
        @SerializedName("material_type_facet")
        var materialTypeFacet: String,
        @SerializedName("kicker")
        var kicker: String,
        /*       @SerializedName("des_facet")
               var desFacet: List<String>,
               @SerializedName("org_facet")
               var orgFacet: List<String>,
               @SerializedName("per_facet")
               var perFacet: List<String>,
               @SerializedName("geo_facet")
               var geoFacet: List<String>,*/
        @Ignore
        @SerializedName("multimedia")
        var multimedia: List<Multimedia>,
        @SerializedName("short_url")
        var shortUrl: String, // https://nyti.ms/3blAr92
    ) {
        constructor() : this(
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            listOf(),
            ""
        )
        
        data class Multimedia(
            @SerializedName("url")
            var url: String, // https://static01.nyt.com/images/2021/01/10/arts/10wandavision-1/merlin_181107681_a6f9c562-6a6d-42d4-ae18-02a4d773ecea-superJumbo.jpg
            @SerializedName("format")
            var format: String, // superJumbo
            @SerializedName("height")
            var height: Int, // 1152
            @SerializedName("width")
            var width: Int, // 2048
            @SerializedName("type")
            var type: String, // image
            @SerializedName("subtype")
            var subtype: String, // photo
            @SerializedName("caption")
            var caption: String, // Thanks to pandemic-related schedule changes, &ldquo;WandaVision,&ldquo; with Elizabeth Olsen and Paul Bettany, will be the first Marvel series to come out on Disney+.
            @SerializedName("copyright")
            var copyright: String, // Disney+
        )
    }
}


@Entity(tableName = "topStoriesKeys")
data class TopStoriesKeys(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    /*   val after: String?,
       val before: String?*/
) {
    constructor() : this(id = 0)
}
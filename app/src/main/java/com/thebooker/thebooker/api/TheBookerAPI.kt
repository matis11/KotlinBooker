package com.thebooker.thebooker.api

import com.thebooker.thebooker.model.Match
import retrofit2.http.GET
import rx.Observable

interface TheBookerAPI {
    @GET("matches/1")
    fun getMatches(): Observable<List<Match>>
}
package com.uziasferreira.randomuser.users.data.repository.datasource.networking

import com.uziasferreira.randomuser.users.data.repository.datasource.networking.json.JsonUser
import io.reactivex.Flowable
import retrofit2.http.GET

interface UsersApi {

    @GET("results=20")
    fun getUsers(): Flowable<List<JsonUser>>

}
package com.uziasferreira.randomuser.users.data.repository.datasource.networking

import com.uziasferreira.randomuser.users.data.repository.datasource.networking.json.JsonUserBody
import io.reactivex.Flowable
import retrofit2.http.GET

interface UsersApi {

    @GET("?results=80")
    fun getUsers(): Flowable<JsonUserBody>

}
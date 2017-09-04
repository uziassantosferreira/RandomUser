package com.uziasferreira.randomuser.users.data.repository.datasource

import com.uziasferreira.randomuser.users.domain.model.User
import io.reactivex.Flowable

interface NetworkingDatasource {
    fun getUsers(): Flowable<List<User>>
}
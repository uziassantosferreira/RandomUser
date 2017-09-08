package com.uziasferreira.randomuser.users.data.repository.datasource.networking

import com.uziasferreira.randomuser.users.data.repository.datasource.NetworkingDatasource
import com.uziasferreira.randomuser.users.domain.model.User
import io.reactivex.Flowable

class NetworkingDatasourceImpl(private val usersApi: UsersApi): NetworkingDatasource {

    override fun getUsers(): Flowable<List<User>> = Flowable.just(listOf())
}
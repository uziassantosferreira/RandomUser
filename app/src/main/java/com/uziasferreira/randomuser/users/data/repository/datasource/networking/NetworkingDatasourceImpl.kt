package com.uziasferreira.randomuser.users.data.repository.datasource.networking

import com.uziasferreira.randomuser.users.data.repository.datasource.NetworkingDatasource
import com.uziasferreira.randomuser.users.domain.model.User
import io.reactivex.Flowable

class NetworkingDatasourceImpl: NetworkingDatasource {

    override fun getUsers(): Flowable<List<User>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
package com.uziasferreira.randomuser.users.data.repository

import com.uziasferreira.randomuser.core.networking.errors.DeserializationIssuesHandler
import com.uziasferreira.randomuser.core.networking.errors.NetworkingErrorHandler
import com.uziasferreira.randomuser.core.networking.errors.RestErrorsHandler
import com.uziasferreira.randomuser.users.data.repository.datasource.NetworkingDatasource
import com.uziasferreira.randomuser.users.domain.model.User
import com.uziasferreira.randomuser.users.domain.repository.UsersRepository
import io.reactivex.Flowable

class UsersRepositoryImpl(private val networkingDatasource: NetworkingDatasource) : UsersRepository {
    override fun getUsers(): Flowable<List<User>> = networkingDatasource.getUsers()
            .compose(NetworkingErrorHandler<List<User>>())
            .compose(RestErrorsHandler<List<User>>())
            .compose(DeserializationIssuesHandler<List<User>>())
}
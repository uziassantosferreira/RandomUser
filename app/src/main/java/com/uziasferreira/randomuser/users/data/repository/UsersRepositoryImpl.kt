package com.uziasferreira.randomuser.users.data.repository

import com.uziasferreira.randomuser.users.domain.model.User
import com.uziasferreira.randomuser.users.domain.repository.UsersRepository
import io.reactivex.Flowable
import java.util.concurrent.TimeUnit

class UsersRepositoryImpl : UsersRepository {
    override fun getUsers(): Flowable<List<User>>
            = Flowable.just<List<User>>(listOf()).delay(1000, TimeUnit.MILLISECONDS)
}
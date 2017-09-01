package com.uziasferreira.randomuser.users.data.repository

import com.uziasferreira.randomuser.core.errors.ContentNotFoundError
import com.uziasferreira.randomuser.users.domain.model.User
import com.uziasferreira.randomuser.users.domain.repository.UsersRepository
import io.reactivex.Flowable
import java.util.*

class UsersRepositoryImpl : UsersRepository {
    override fun getUsers(): Flowable<List<User>> =
            if (Random().nextBoolean()) Flowable.empty<List<User>>()
            else Flowable.error(ContentNotFoundError())
}
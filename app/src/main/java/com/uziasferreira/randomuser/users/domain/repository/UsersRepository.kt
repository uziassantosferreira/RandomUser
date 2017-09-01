package com.uziasferreira.randomuser.users.domain.repository

import com.uziasferreira.randomuser.users.domain.model.User
import io.reactivex.Flowable

interface UsersRepository {
    fun getUsers() : Flowable<List<User>>
}
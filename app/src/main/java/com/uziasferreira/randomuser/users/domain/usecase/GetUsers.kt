package com.uziasferreira.randomuser.users.domain.usecase

import com.uziasferreira.randomuser.core.domain.UseCase
import com.uziasferreira.randomuser.users.domain.model.User
import com.uziasferreira.randomuser.users.domain.repository.UsersRepository
import io.reactivex.Flowable

interface GetUsers: UseCase<Flowable<List<User>>>

class GetUsersImpl(private val usersRepository: UsersRepository): GetUsers {
    override fun run(): Flowable<List<User>> = usersRepository.getUsers()
}
package com.uziasferreira.randomuser.users.presentation.presenter

import com.uziasferreira.randomuser.core.behaviours.BehavioursCoordinator
import com.uziasferreira.randomuser.core.presentation.BasePresenter
import com.uziasferreira.randomuser.core.presentation.lifecycles.LifecycleStrategist
import com.uziasferreira.randomuser.users.domain.model.User
import com.uziasferreira.randomuser.users.domain.usecase.GetUsers
import com.uziasferreira.randomuser.users.presentation.adapter.UserAdapterImpl
import com.uziasferreira.randomuser.users.presentation.model.PresentationUser
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy

interface UsersPresenter: BasePresenter {
    fun getUsers()
}

class UsersPresenterImpl(private val getUsers: GetUsers,
                         private val coordinator: BehavioursCoordinator<Any>,
                         private val strategist: LifecycleStrategist,
                         private val usersAdapter: UserAdapterImpl): UsersPresenter {
    override fun getUsers() {
        val disposableGetUsers = getUsers.run()
                .compose(coordinator)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onError = {},
                        onNext = {usersAdapter.setUsers(listOf(PresentationUser(name = "TESTE"),
                                PresentationUser(name = "TESTE"),
                                PresentationUser(name = "TESTE"),
                                PresentationUser(name = "TESTE"),
                                PresentationUser(name = "TESTE"),
                                PresentationUser(name = "TESTE"),
                                PresentationUser(name = "TESTE"),
                                PresentationUser(name = "TESTE"),
                                PresentationUser(name = "TESTE"),
                                PresentationUser(name = "TESTE")))},
                        onComplete = {}
                )
        strategist.applyStrategy(disposableGetUsers)
    }
}
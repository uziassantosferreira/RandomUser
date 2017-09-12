package com.uziasferreira.randomuser.users.presentation.presenter

import com.uziasferreira.randomuser.core.behaviours.BehavioursCoordinator
import com.uziasferreira.randomuser.core.presentation.BasePresenter
import com.uziasferreira.randomuser.core.presentation.lifecycles.LifecycleStrategist
import com.uziasferreira.randomuser.users.domain.model.User
import com.uziasferreira.randomuser.users.domain.usecase.GetUsers
import com.uziasferreira.randomuser.users.presentation.mapper.UserPresentationMapper
import com.uziasferreira.randomuser.users.presentation.model.PresentationUser
import com.uziasferreira.randomuser.users.presentation.view.UsersView
import io.reactivex.Scheduler

interface UsersPresenter: BasePresenter {
    fun getUsers()
}

class UsersPresenterImpl(private val getUsers: GetUsers,
                         private val coordinator: BehavioursCoordinator<List<User>>,
                         private val strategist: LifecycleStrategist,
                         private val usersView: UsersView,
                         private val ioScheduler: Scheduler): UsersPresenter {
    override fun getUsers() {
        val getUsers = getUsers.run()
                .compose(coordinator)
                .subscribeOn(ioScheduler)
                .map(UserPresentationMapper::transformToList)
        val disposable = usersView.subscribeInto(getUsers)
        strategist.applyStrategy(disposable)
    }
}
package com.uziasferreira.randomuser.users.presentation.presenter

import com.uziasferreira.randomuser.core.behaviours.BehavioursCoordinator
import com.uziasferreira.randomuser.core.presentation.BasePresenter
import com.uziasferreira.randomuser.core.presentation.lifecycles.LifecycleStrategist
import com.uziasferreira.randomuser.users.domain.model.User
import com.uziasferreira.randomuser.users.domain.usecase.GetUsers
import io.reactivex.android.schedulers.AndroidSchedulers

interface UsersPresenter: BasePresenter {
    fun getUsers()
}

class UsersPresenterImpl(private val getUsers: GetUsers,
                         private val coordinator: BehavioursCoordinator<List<User>>,
                         private val strategist: LifecycleStrategist): UsersPresenter {
    override fun getUsers() {
        strategist.applyStrategy(getUsers.run()
                .compose(coordinator)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({}, {}, {}))
    }
}
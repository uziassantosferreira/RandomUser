package com.uziasferreira.randomuser.users.di

import android.arch.lifecycle.LifecycleOwner
import com.uziasferreira.randomuser.core.behaviours.BehavioursCoordinator
import com.uziasferreira.randomuser.core.behaviours.di.BehavioursModule
import com.uziasferreira.randomuser.core.presentation.EmptyStateView
import com.uziasferreira.randomuser.core.presentation.lifecycles.LifecycleStrategist
import com.uziasferreira.randomuser.core.presentation.lifecycles.di.LifecycleStrategistModule
import com.uziasferreira.randomuser.users.data.repository.UsersRepositoryImpl
import com.uziasferreira.randomuser.users.domain.model.User
import com.uziasferreira.randomuser.users.domain.repository.UsersRepository
import com.uziasferreira.randomuser.users.domain.usecase.GetUsers
import com.uziasferreira.randomuser.users.domain.usecase.GetUsersImpl
import com.uziasferreira.randomuser.users.presentation.presenter.UsersPresenter
import com.uziasferreira.randomuser.users.presentation.presenter.UsersPresenterImpl
import com.uziasferreira.randomuser.users.presentation.view.UsersActivity
import dagger.Module
import dagger.Provides

@Module(includes = arrayOf(BehavioursModule::class, LifecycleStrategistModule::class))
class UsersModule {

    @Provides fun providesUsersPresenter(getUsers: GetUsers, coordinator: BehavioursCoordinator<List<User>>, strategist: LifecycleStrategist)
            : UsersPresenter = UsersPresenterImpl(getUsers = getUsers, coordinator = coordinator, strategist = strategist)

    @Provides fun providesGetUsers(usersRepository: UsersRepository)
            : GetUsers = GetUsersImpl(usersRepository = usersRepository)

    @Provides fun providesUsersRepository()
            : UsersRepository = UsersRepositoryImpl()

    @Provides fun emptyStateView(activity: UsersActivity): EmptyStateView {
        return activity
    }

    @Provides fun strategist(activity: UsersActivity): LifecycleOwner {
        return activity
    }
}
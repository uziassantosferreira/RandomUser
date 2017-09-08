package com.uziasferreira.randomuser.users.di

import android.arch.lifecycle.LifecycleOwner
import com.uziasferreira.randomuser.core.behaviours.BehavioursCoordinator
import com.uziasferreira.randomuser.core.behaviours.di.BehavioursModule
import com.uziasferreira.randomuser.core.presentation.EmptyStateView
import com.uziasferreira.randomuser.core.presentation.LoadingView
import com.uziasferreira.randomuser.core.presentation.PlaceholderViewsManager
import com.uziasferreira.randomuser.core.presentation.lifecycles.LifecycleStrategist
import com.uziasferreira.randomuser.core.presentation.lifecycles.di.LifecycleStrategistModule
import com.uziasferreira.randomuser.users.data.repository.UsersRepositoryImpl
import com.uziasferreira.randomuser.users.domain.repository.UsersRepository
import com.uziasferreira.randomuser.users.domain.usecase.GetUsers
import com.uziasferreira.randomuser.users.domain.usecase.GetUsersImpl
import com.uziasferreira.randomuser.users.presentation.adapter.UserAdapterImpl
import com.uziasferreira.randomuser.users.presentation.adapter.UsersAdapter
import com.uziasferreira.randomuser.users.presentation.presenter.UsersPresenter
import com.uziasferreira.randomuser.users.presentation.presenter.UsersPresenterImpl
import com.uziasferreira.randomuser.users.presentation.view.UsersActivity
import dagger.Module
import dagger.Provides
import kotlinx.android.synthetic.main.state_view_empty.*
import kotlinx.android.synthetic.main.state_view_error.*
import kotlinx.android.synthetic.main.state_view_loading.*

@Module(includes = arrayOf(BehavioursModule::class, LifecycleStrategistModule::class))
class UsersModule {

    @Provides fun providesUsersPresenter(getUsers: GetUsers, coordinator: BehavioursCoordinator<Any>,
                                         strategist: LifecycleStrategist, usersAdapter: UserAdapterImpl)
            : UsersPresenter = UsersPresenterImpl(getUsers = getUsers, coordinator = coordinator,
            strategist = strategist, usersAdapter = usersAdapter)

    @Provides fun providesGetUsers(usersRepository: UsersRepository)
            : GetUsers = GetUsersImpl(usersRepository = usersRepository)

    @Provides fun providesUsersRepository()
            : UsersRepository = UsersRepositoryImpl()

    @Provides fun emptyStateView(activity: UsersActivity): EmptyStateView {
        return activity
    }

    @Provides fun loadingView(activity: UsersActivity): LoadingView {
        return activity
    }

    @Provides fun strategist(activity: UsersActivity): LifecycleOwner {
        return activity
    }

    @Provides fun userAdapter(activity: UsersActivity): UserAdapterImpl {
        return UserAdapterImpl()
    }

    @Provides fun placeHolder(activity: UsersActivity): PlaceholderViewsManager {
        return PlaceholderViewsManager(loadingViewStub = activity.state_view_loading,
                errorViewStub = activity.state_view_error, emptyViewStub = activity.state_view_empty)
    }
}
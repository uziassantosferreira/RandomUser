package com.uziasferreira.randomuser.users.di

import android.arch.lifecycle.LifecycleOwner
import com.uziasferreira.randomuser.core.application.di.IOScheduler
import com.uziasferreira.randomuser.core.behaviours.BehavioursCoordinator
import com.uziasferreira.randomuser.core.presentation.*
import com.uziasferreira.randomuser.core.presentation.lifecycles.LifecycleStrategist
import com.uziasferreira.randomuser.core.presentation.lifecycles.di.LifecycleStrategistModule
import com.uziasferreira.randomuser.users.data.repository.UsersRepositoryImpl
import com.uziasferreira.randomuser.users.data.repository.datasource.NetworkingDatasource
import com.uziasferreira.randomuser.users.data.repository.datasource.networking.NetworkingDatasourceImpl
import com.uziasferreira.randomuser.users.data.repository.datasource.networking.UsersApi
import com.uziasferreira.randomuser.users.domain.model.User
import com.uziasferreira.randomuser.users.domain.repository.UsersRepository
import com.uziasferreira.randomuser.users.domain.usecase.GetUsers
import com.uziasferreira.randomuser.users.domain.usecase.GetUsersImpl
import com.uziasferreira.randomuser.users.presentation.adapter.UserAdapterImpl
import com.uziasferreira.randomuser.users.presentation.presenter.UsersPresenter
import com.uziasferreira.randomuser.users.presentation.presenter.UsersPresenterImpl
import com.uziasferreira.randomuser.users.presentation.view.UsersActivity
import com.uziasferreira.randomuser.users.presentation.view.UsersView
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.state_view_empty.*
import kotlinx.android.synthetic.main.state_view_error.*
import kotlinx.android.synthetic.main.state_view_loading.*
import retrofit2.Retrofit

@Module(includes = arrayOf(UsersBehavioursModule::class, LifecycleStrategistModule::class))
class UsersModule {

    @Provides fun providesUsersPresenter(getUsers: GetUsers, coordinator: BehavioursCoordinator<List<User>>,
                                         strategist: LifecycleStrategist, usersView: UsersView,
                                         @IOScheduler scheduler: Scheduler)
            : UsersPresenter = UsersPresenterImpl(getUsers = getUsers, coordinator = coordinator,
            strategist = strategist, usersView = usersView, ioScheduler = scheduler)

    @Provides fun providesGetUsers(usersRepository: UsersRepository)
            : GetUsers = GetUsersImpl(usersRepository = usersRepository)

    @Provides fun providesUsersRepository(networkingDatasource: NetworkingDatasource)
            : UsersRepository = UsersRepositoryImpl(networkingDatasource = networkingDatasource)

    @Provides fun providesNetworkingDatasource(usersApi: UsersApi)
            : NetworkingDatasource = NetworkingDatasourceImpl(usersApi = usersApi)

    @Provides fun providesUsersApi(retrofit: Retrofit)
            : UsersApi = retrofit.create(UsersApi::class.java)

    @Provides fun providesEmptyStateView(activity: UsersActivity): EmptyStateView {
        return activity
    }

    @Provides fun providesLoadingView(activity: UsersActivity): LoadingView {
        return activity
    }

    @Provides fun providesErrorView(activity: UsersActivity): ErrorStateView {
        return activity
    }

    @Provides fun providesStrategist(activity: UsersActivity): LifecycleOwner {
        return activity
    }

    @Provides fun providesUserAdapter(): UserAdapterImpl {
        return UserAdapterImpl()
    }

    @Provides fun providesUsersView(activity: UsersActivity): UsersView {
        return activity
    }

    @Provides fun providesToogleRefreshView(activity: UsersActivity): ToogleRefreshView {
        return activity
    }

    @Provides fun providesPlaceHolder(activity: UsersActivity): PlaceholderViewsManager {
        return PlaceholderViewsManager(loadingViewStub = activity.state_view_loading,
                errorViewStub = activity.state_view_error,
                emptyViewStub = activity.state_view_empty,
                containerView = activity.swiperefreshlayout)
    }
}
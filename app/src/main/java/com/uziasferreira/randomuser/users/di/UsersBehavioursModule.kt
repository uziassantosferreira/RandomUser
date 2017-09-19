package com.uziasferreira.randomuser.users.di

import com.uziasferreira.randomuser.core.application.di.UIScheduler
import com.uziasferreira.randomuser.core.behaviours.BehavioursCoordinator
import com.uziasferreira.randomuser.core.behaviours.emptystate.AssignEmptyCoordination
import com.uziasferreira.randomuser.core.behaviours.errornetworkingstate.NetworkingErrorCoordination
import com.uziasferreira.randomuser.core.behaviours.errorstate.AssignErrorCoordination
import com.uziasferreira.randomuser.core.behaviours.loadingstate.LoadingCoordination
import com.uziasferreira.randomuser.core.behaviours.refreshtooglestate.RefreshToogleCoordination
import com.uziasferreira.randomuser.core.presentation.*
import com.uziasferreira.randomuser.users.domain.model.User
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler

@Module
class UsersBehavioursModule {

    @Provides
    fun providesBehavioursCoordinator(assignEmptyState: AssignEmptyCoordination<List<User>>,
                                      loadingCoordination: LoadingCoordination<List<User>>,
                                      errorCoordination: AssignErrorCoordination<List<User>>,
                                      refreshToogleCoordination: RefreshToogleCoordination<List<User>>,
                                      networkingErrorCoordination: NetworkingErrorCoordination<List<User>>)
            : BehavioursCoordinator<List<User>> {
        return BehavioursCoordinator(assignEmptyState, loadingCoordination, errorCoordination,
                networkingErrorCoordination, refreshToogleCoordination)
    }

    @Provides
    fun providesEmptyCoordination(view: EmptyStateView, @UIScheduler scheduler: Scheduler): AssignEmptyCoordination<List<User>> {
        return AssignEmptyCoordination(view, scheduler)
    }

    @Provides
    fun providesLoadingCoordination(view: LoadingView, @UIScheduler scheduler: Scheduler): LoadingCoordination<List<User>> {
        return LoadingCoordination(view, scheduler)
    }

    @Provides
    fun providesAssignErrorCoordination(view: ErrorStateView, @UIScheduler scheduler: Scheduler): AssignErrorCoordination<List<User>> {
        return AssignErrorCoordination(view, scheduler)
    }

    @Provides
    fun providesRefreshToogleCoordination(view: ToogleRefreshView, @UIScheduler scheduler: Scheduler): RefreshToogleCoordination<List<User>> {
        return RefreshToogleCoordination(view, scheduler)
    }

    @Provides
    fun providesNetworkingErrorCoordination(view: NetworkingView, @UIScheduler scheduler: Scheduler): NetworkingErrorCoordination<List<User>> {
        return NetworkingErrorCoordination(view, scheduler)
    }

}

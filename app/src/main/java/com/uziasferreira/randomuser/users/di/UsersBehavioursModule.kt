package com.uziasferreira.randomuser.users.di

import com.uziasferreira.randomuser.core.application.di.UIScheduler
import com.uziasferreira.randomuser.core.behaviours.BehavioursCoordinator
import com.uziasferreira.randomuser.core.behaviours.emptystate.AssignEmptyCoordination
import com.uziasferreira.randomuser.core.behaviours.errorstate.AssignErrorCoordination
import com.uziasferreira.randomuser.core.behaviours.loadingstate.LoadingCoordination
import com.uziasferreira.randomuser.core.presentation.EmptyStateView
import com.uziasferreira.randomuser.core.presentation.ErrorStateView
import com.uziasferreira.randomuser.core.presentation.LoadingView
import com.uziasferreira.randomuser.users.domain.model.User
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler

@Module
class UsersBehavioursModule {

    @Provides
    fun providesBehavioursCoordinator(assignEmptyState: AssignEmptyCoordination<List<User>>,
                                      loadingCoordination: LoadingCoordination<List<User>>,
                                      errorCoordination: AssignErrorCoordination<List<User>>): BehavioursCoordinator<List<User>> {
        return BehavioursCoordinator(assignEmptyState, loadingCoordination, errorCoordination)
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
}

package com.uziasferreira.randomuser.core.behaviours.di

import com.uziasferreira.randomuser.core.application.di.UIScheduler
import com.uziasferreira.randomuser.core.behaviours.BehavioursCoordinator
import com.uziasferreira.randomuser.core.behaviours.emptystate.AssignEmptyState
import com.uziasferreira.randomuser.core.presentation.EmptyStateView
import com.uziasferreira.randomuser.users.domain.model.User
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler

@Module
class BehavioursModule {

    @Provides
    fun providesBehavioursCoordinator(assignEmptyState: AssignEmptyState<List<User>>): BehavioursCoordinator<List<User>> {
        return BehavioursCoordinator(assignEmptyState)
    }

    @Provides
    fun providesEmptyState(view: EmptyStateView, @UIScheduler scheduler: Scheduler): AssignEmptyState<List<User>> {
        return AssignEmptyState(view, scheduler)
    }

}

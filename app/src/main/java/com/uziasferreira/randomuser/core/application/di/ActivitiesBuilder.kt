package com.uziasferreira.randomuser.core.application.di

import com.uziasferreira.randomuser.users.di.UsersModule
import com.uziasferreira.randomuser.users.presentation.view.UsersActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesBuilder {

    @ContributesAndroidInjector(modules = arrayOf(UsersModule::class))
    abstract fun usersActivity(): UsersActivity

}

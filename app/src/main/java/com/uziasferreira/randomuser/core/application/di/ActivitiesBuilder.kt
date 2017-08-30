package com.uziasferreira.randomuser.core.application.di

import com.uziasferreira.randomuser.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesBuilder {

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

}

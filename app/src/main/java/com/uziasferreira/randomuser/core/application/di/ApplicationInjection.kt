package com.uziasferreira.randomuser.core.application.di

import android.app.Application
import android.content.Context
import com.uziasferreira.randomuser.core.application.RandomUserApplication
import com.uziasferreira.randomuser.core.networking.di.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class, ApplicationModule::class, NetworkModule::class, ActivitiesBuilder::class))
interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent

    }

    fun inject(target: RandomUserApplication)

}

@Module
class ApplicationModule {

    @Provides
    fun providesContext(application: Application): Context = application

    @Provides
    @UIScheduler
    fun providesUiScheduler(): Scheduler = AndroidSchedulers.mainThread()

    @Provides
    @IOScheduler
    fun providesIoScheduler(): Scheduler = Schedulers.io()

}

package com.uziasferreira.randomuser.core.application

import android.app.Activity
import android.app.Application
import com.uziasferreira.randomuser.core.application.di.DaggerApplicationComponent
import com.uziasferreira.randomuser.core.database.RealmDatabase
import dagger.android.AndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

class RandomUserApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
        RealmDatabase.configure(this)
    }

    private fun injectDependencies() {
        DaggerApplicationComponent
                .builder()
                .application(this)
                .build()
                .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityDispatchingAndroidInjector

}
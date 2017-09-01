package com.uziasferreira.randomuser.core.presentation.lifecycles

import android.arch.lifecycle.LifecycleOwner
import io.reactivex.disposables.Disposable

class LifecycleStrategist(owner: LifecycleOwner, private val strategy: DisposeStrategy) {
    init {
        owner.lifecycle.addObserver(strategy)
    }

    fun applyStrategy(toDispose: Disposable) {
        strategy.addDisposable(toDispose)
    }
}

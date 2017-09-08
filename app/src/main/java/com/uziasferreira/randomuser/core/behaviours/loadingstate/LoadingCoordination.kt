package com.uziasferreira.randomuser.core.behaviours.loadingstate

import com.uziasferreira.randomuser.core.behaviours.ShowAtStartHideWhenDone
import com.uziasferreira.randomuser.core.presentation.LoadingView
import io.reactivex.Flowable
import io.reactivex.FlowableTransformer
import io.reactivex.Scheduler
import org.reactivestreams.Publisher

class LoadingCoordination<Any>(private val view: LoadingView,
                             private val uiScheduler: Scheduler) : FlowableTransformer<Any, Any> {

    override fun apply(upstream: Flowable<Any>): Publisher<Any> {

        val delegate = ShowAtStartHideWhenDone<Any>(
                view.showLoading(),
                view.hideLoading(),
                uiScheduler
        )

        return upstream.compose(delegate)
    }

}

package com.uziasferreira.randomuser.core.behaviours

import com.uziasferreira.randomuser.core.behaviours.emptystate.AssignEmptyCoordination
import com.uziasferreira.randomuser.core.behaviours.loadingstate.LoadingCoordination
import io.reactivex.Flowable
import io.reactivex.FlowableTransformer
import org.reactivestreams.Publisher

class BehavioursCoordinator<T>(private val dealWithEmptyState: AssignEmptyCoordination<T>,
                               private val loadingCoordination: LoadingCoordination<T>):
        FlowableTransformer<T, T> {

    override fun apply(upstream: Flowable<T>): Publisher<T> {
        return upstream
                .compose(dealWithEmptyState)
                .compose(loadingCoordination)
    }
}

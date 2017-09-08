package com.uziasferreira.randomuser.core.behaviours

import com.uziasferreira.randomuser.core.behaviours.emptystate.AssignEmptyCoordination
import com.uziasferreira.randomuser.core.behaviours.loadingstate.LoadingCoordination
import io.reactivex.Flowable
import io.reactivex.FlowableTransformer
import org.reactivestreams.Publisher

class BehavioursCoordinator<Any>(private val dealWithEmptyState: AssignEmptyCoordination<Any>,
                               private val loadingCoordination: LoadingCoordination<Any>):
        FlowableTransformer<Any, Any> {

    override fun apply(upstream: Flowable<Any>): Publisher<Any> {
        return upstream
                .compose(dealWithEmptyState)
                .compose(loadingCoordination)
    }
}

package com.uziasferreira.randomuser.core.behaviours

import com.uziasferreira.randomuser.core.behaviours.emptystate.AssignEmptyCoordination
import com.uziasferreira.randomuser.core.behaviours.errornetworkingstate.NetworkingErrorCoordination
import com.uziasferreira.randomuser.core.behaviours.errorstate.AssignErrorCoordination
import com.uziasferreira.randomuser.core.behaviours.loadingstate.LoadingCoordination
import com.uziasferreira.randomuser.core.behaviours.refreshtooglestate.RefreshToogleCoordination
import io.reactivex.*
import org.reactivestreams.Publisher

class BehavioursCoordinator<T>(private val dealWithEmptyState: AssignEmptyCoordination<T>,
                               private val loadingCoordination: LoadingCoordination<T>,
                               private val errorCoordination: AssignErrorCoordination<T>,
                               private val networkingCoordination: NetworkingErrorCoordination<T>,
                               private val toogleCoordination: RefreshToogleCoordination<T>):
        FlowableTransformer<T, T>{

    override fun apply(upstream: Flowable<T>): Publisher<T> {
        return upstream
                .compose(dealWithEmptyState)
                .compose(loadingCoordination)
                .compose(errorCoordination)
                .compose(networkingCoordination)
                .compose(toogleCoordination)
    }

}

package com.uziasferreira.randomuser.core.behaviours.emptystate

import com.uziasferreira.randomuser.core.behaviours.HideAtStartShowAtError
import com.uziasferreira.randomuser.core.errors.ContentNotFoundError
import com.uziasferreira.randomuser.core.presentation.EmptyStateView
import com.uziasferreira.randomuser.util.ErrorPredicate
import io.reactivex.Flowable
import io.reactivex.FlowableTransformer
import io.reactivex.Scheduler
import org.reactivestreams.Publisher

open class AssignEmptyCoordination<Any>(private val view: EmptyStateView, private val uiScheduler: Scheduler):
        FlowableTransformer<Any, Any> {

    override fun apply(upstream: Flowable<Any>): Publisher<Any> {

        val delegate = HideAtStartShowAtError<Any>(
                whenStart = view.hideEmptyState(),
                atError = view.showEmptyState(),
                errorPredicate = object : ErrorPredicate {
                    override fun evaluate(error: Throwable): Boolean = error is ContentNotFoundError
                },
                targetScheduler = uiScheduler
        )

        return upstream.compose(delegate)
    }

}

package com.uziasferreira.randomuser.core.domain

interface UseCase<T> {
    fun run(): T
}
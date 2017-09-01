package com.uziasferreira.randomuser.core.errors

class ContentNotFoundError : RuntimeException() {
    override val message: String?
        get() = "No content available"
}

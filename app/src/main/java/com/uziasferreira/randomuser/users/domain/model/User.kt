package com.uziasferreira.randomuser.users.domain.model

import com.uziasferreira.randomuser.core.domain.InvalidData

data class User(val fullName: String = InvalidData.UNINITIALIZED.getString(),
                val pictureUrl: String = InvalidData.UNINITIALIZED.getString(),
                val email: String = InvalidData.UNINITIALIZED.getString())
package com.uziasferreira.randomuser.users.presentation.model

import com.uziasferreira.randomuser.core.domain.InvalidData

data class PresentationUser(val name: String = InvalidData.UNINITIALIZED.getString(),
                            val avatarUrl: String = InvalidData.UNINITIALIZED.getString())
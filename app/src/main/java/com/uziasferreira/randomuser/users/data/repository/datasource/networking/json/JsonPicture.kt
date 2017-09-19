package com.uziasferreira.randomuser.users.data.repository.datasource.networking.json

import com.uziasferreira.randomuser.core.domain.InvalidData

data class JsonPicture(var large: String = InvalidData.UNINITIALIZED.getString(),
                       var medium: String = InvalidData.UNINITIALIZED.getString(),
                       var thumbnail: String = InvalidData.UNINITIALIZED.getString())
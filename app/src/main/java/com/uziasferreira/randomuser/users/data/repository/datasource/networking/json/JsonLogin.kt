package com.uziasferreira.randomuser.users.data.repository.datasource.networking.json

import com.uziasferreira.randomuser.core.domain.InvalidData

data class JsonLogin(var username: String = InvalidData.UNINITIALIZED.getString(),
                     var password: String = InvalidData.UNINITIALIZED.getString(),
                     var salt: String = InvalidData.UNINITIALIZED.getString(),
                     var md5: String = InvalidData.UNINITIALIZED.getString(),
                     var sha1: String = InvalidData.UNINITIALIZED.getString(),
                     var sha256: String = InvalidData.UNINITIALIZED.getString())
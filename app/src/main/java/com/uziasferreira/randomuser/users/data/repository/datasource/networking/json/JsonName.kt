package com.uziasferreira.randomuser.users.data.repository.datasource.networking.json

import com.uziasferreira.randomuser.core.domain.InvalidData

data class JsonName(var title: String = InvalidData.UNINITIALIZED.getString(),
                    var first: String = InvalidData.UNINITIALIZED.getString(),
                    var last: String = InvalidData.UNINITIALIZED.getString())
package com.uziasferreira.randomuser.users.data.repository.datasource.networking.json

import com.uziasferreira.randomuser.core.domain.InvalidData

data class JsonId(var name: String = InvalidData.UNINITIALIZED.getString(),
                  var value: String = InvalidData.UNINITIALIZED.getString())
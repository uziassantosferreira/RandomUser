package com.uziasferreira.randomuser.users.data.repository.datasource.networking.json

import com.uziasferreira.randomuser.core.domain.InvalidData

data class JsonLocation(var street: String = InvalidData.UNINITIALIZED.getString(),
                        var city: String = InvalidData.UNINITIALIZED.getString(),
                        var state: String = InvalidData.UNINITIALIZED.getString(),
                        var postcode: String = InvalidData.UNINITIALIZED.getString())
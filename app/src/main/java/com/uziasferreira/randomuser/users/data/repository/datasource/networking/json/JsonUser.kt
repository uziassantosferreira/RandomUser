package com.uziasferreira.randomuser.users.data.repository.datasource.networking.json

import com.uziasferreira.randomuser.core.domain.InvalidData
import java.util.*

data class JsonUser(var gender: String = InvalidData.UNINITIALIZED.getString(),
                    var name: JsonName = JsonName(),
                    var location: JsonLocation = JsonLocation(),
                    var email: String = InvalidData.UNINITIALIZED.getString(),
                    var login: JsonLogin = JsonLogin(),
                    var dob: Date = Date(),
                    var registered: Date = Date(),
                    var phone: String = InvalidData.UNINITIALIZED.getString(),
                    var cell: String = InvalidData.UNINITIALIZED.getString(),
                    var id: JsonId = JsonId(),
                    var picture: JsonPicture = JsonPicture(),
                    var nat: String = InvalidData.UNINITIALIZED.getString())

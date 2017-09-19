package com.uziasferreira.randomuser.users.data.repository.datasource.networking.mapper

import com.uziasferreira.randomuser.core.mapper.BaseMapper
import com.uziasferreira.randomuser.users.data.repository.datasource.networking.json.JsonUser
import com.uziasferreira.randomuser.users.domain.model.User

object JsonUserMapper : BaseMapper<JsonUser, User>() {
    override fun transformFrom(source: User): JsonUser {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun transformTo(source: JsonUser): User = User(fullName = source.name.fullName(),
            pictureUrl = source.picture.large,
            email = source.email)

}
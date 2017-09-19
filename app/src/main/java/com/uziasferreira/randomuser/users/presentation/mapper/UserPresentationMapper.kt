package com.uziasferreira.randomuser.users.presentation.mapper

import com.uziasferreira.randomuser.core.mapper.BaseMapper
import com.uziasferreira.randomuser.users.domain.model.User
import com.uziasferreira.randomuser.users.presentation.model.PresentationUser

object UserPresentationMapper : BaseMapper<User, PresentationUser>() {

    override fun transformTo(source: User): PresentationUser = PresentationUser(
            fullName = source.fullName,
            avatarUrl = source.pictureUrl,
            email = source.email)

    override fun transformFrom(source: PresentationUser): User {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
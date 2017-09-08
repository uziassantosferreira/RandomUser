package com.uziasferreira.randomuser.users.data.repository.datasource.networking.json

import com.google.gson.annotations.SerializedName

data class JsonUserBody(@SerializedName("results") var users: List<JsonUser>)
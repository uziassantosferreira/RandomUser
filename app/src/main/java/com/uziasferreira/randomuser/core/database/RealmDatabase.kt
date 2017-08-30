package com.uziasferreira.randomuser.core.database

import android.content.Context
import com.uziasferreira.randomuser.R
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by uzias on 30/08/17.
 */
object RealmDatabase {

    private val TYPE_FILE = ".realm"

    fun configure(context: Context){
        Realm.init(context)
        val realmConfiguration = RealmConfiguration.Builder()
                .name(nameFile(context))
                .build()
        Realm.setDefaultConfiguration(realmConfiguration)
    }

    private fun nameFile(context: Context): String = "%s$TYPE_FILE"
            .format(context.getString(R.string.app_name))

}
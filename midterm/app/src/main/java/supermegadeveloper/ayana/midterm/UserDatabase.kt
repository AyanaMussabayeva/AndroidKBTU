package supermegadeveloper.ayana.midterm

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(User::class), version = 1)

abstract class UserDatabase : RoomDatabase() {
    abstract fun newsDao():UserDAO

    companion object {
        private var INSTANCE : UserDatabase? = null

        fun getInstance(context: Context):UserDatabase? {

            if(INSTANCE == null){
                synchronized(UserDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, UserDatabase::class.java, "users.db").build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }


    }
}
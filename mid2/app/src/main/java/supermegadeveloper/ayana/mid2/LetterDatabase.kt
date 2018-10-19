package supermegadeveloper.ayana.mid2

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(Letter::class), version = 1)
abstract class LetterDatabase : RoomDatabase()  {
    abstract fun letterDao():LetterDAO

    companion object {
        private var INSTANCE : LetterDatabase? = null

        fun getInstance(context: Context): LetterDatabase? {

            if(INSTANCE == null){
                synchronized(LetterDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, LetterDatabase::class.java, "letter.db").build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }


    }
}
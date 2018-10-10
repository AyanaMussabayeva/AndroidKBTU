package supermegadeveloper.ayana.lab4

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(News::class), version = 1)
abstract class NewsDatabase : RoomDatabase() {

    abstract fun newsDao():NewsDAO

    companion object {
        private var INSTANCE : NewsDatabase? = null

        fun getInstance(context: Context):NewsDatabase? {

           if(INSTANCE == null){
               synchronized(NewsDatabase::class){
                   INSTANCE = Room.databaseBuilder(context.applicationContext, NewsDatabase::class.java, "news.db").build()
               }
           }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }


    }

}
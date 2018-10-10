package supermegadeveloper.ayana.lab4

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface NewsDAO {
    @Query("SELECT * FROM news")
    fun getAll(): List<News>

    @Insert
    fun insert(news:News)

}
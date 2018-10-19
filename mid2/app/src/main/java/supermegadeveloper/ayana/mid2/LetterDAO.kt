package supermegadeveloper.ayana.mid2

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface LetterDAO {
    @Query("SELECT * FROM letter")
    fun getAll(): List<Letter>

    @Query("SELECT * FROM letter WHERE id = :id")
    fun getById(id: Int): List<Letter>

    @Insert
    fun insert(letter:Letter)


}
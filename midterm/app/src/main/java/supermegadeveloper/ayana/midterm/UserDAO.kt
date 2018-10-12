package supermegadeveloper.ayana.midterm

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query


interface UserDAO {

    @Query("SELECT * FROM users")
    fun getAll(): List<User>

    @Insert
    fun insert(user:User)
}
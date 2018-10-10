package supermegadeveloper.ayana.lab4

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "news")


data class News(@PrimaryKey var id : Int, var title: String, var date: String, var description: String) {


}
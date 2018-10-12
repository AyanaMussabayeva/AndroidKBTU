package supermegadeveloper.ayana.midterm

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "users")

data class User(@PrimaryKey var id : Int, var login: String, var password: String, var usertodo: ArrayList<String> ?) {

}
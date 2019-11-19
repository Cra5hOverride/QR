package buu.informatics.s59160965.qrcodescanner.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface HistoryDatabaseDao {
    @Insert
    fun insert(history: History)

    @Update
    fun update(history: History)


    @Query("SELECT * FROM history_table ORDER BY time DESC")
    fun getHistory(): LiveData<List<History>>

    @Query("DELETE FROM history_table")
    fun clear()



}
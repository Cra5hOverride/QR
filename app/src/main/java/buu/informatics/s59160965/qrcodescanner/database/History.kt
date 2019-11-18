package buu.informatics.s59160965.qrcodescanner.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history_table")
data class History (
    @PrimaryKey(autoGenerate = true)
    var historyId: Long = 0L,

    @ColumnInfo(name = "datadecode")
    var datadecode: String = "",

    @ColumnInfo(name = "time")
    var time: String = ""
)
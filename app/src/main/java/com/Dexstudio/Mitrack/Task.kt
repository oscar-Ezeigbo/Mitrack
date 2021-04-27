package com.Dexstudio.Mitrack

import android.R.string
import androidx.room.Entity
import java.util.*


@Entity(tableName = "task_table") /* class for task object, allows user to name
task and set start and end date  */
class Task {
    var taskId: Long = 0
    var taskName: String = ""
    lateinit var isDue: Date
    var isDone = false
}
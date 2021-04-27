package com.Dexstudio.Mitrack

import androidx.lifecycle.ViewModel

class TaskListViewModel : ViewModel(){

    val tasks = mutableListOf<Task>()

    init{
        for (i in 0 until 9){
            val task = Task()
            task.taskName = "Task #$i"
            task.isDone = i % 2 == 0
            tasks += task
        }
    }
}
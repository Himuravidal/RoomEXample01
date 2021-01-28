package com.crisspian.shared

import android.app.Application
import com.crisspian.shared.model.TaskDataBase
import com.crisspian.shared.model.TaskRepository

class AppTask : Application() {

    val dataBase by lazy { TaskDataBase.getDataBase(this) }
    val repository by lazy { TaskRepository(dataBase.getTaskDao()) }

}
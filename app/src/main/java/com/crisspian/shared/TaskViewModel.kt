package com.crisspian.shared

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.crisspian.shared.model.Task
import com.crisspian.shared.model.TaskRepository
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class TaskViewModel(private val repository: TaskRepository) : ViewModel() {

    //LiveData de tareas
    val allTask : LiveData<List<Task>> = repository.listAllTask


    fun insertTask(task: Task) = viewModelScope.launch {
        repository.insertTask(task)
    }

    fun deleteAllTask() = viewModelScope.launch {
        repository.deleteAllTask()
    }

}

class TaskViewModelFactory(private val repository: TaskRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       if (modelClass.isAssignableFrom(TaskViewModel::class.java)) {
           @Suppress("UNCHECKED_CAST")
           return TaskViewModel(repository) as T
       }
        throw  IllegalArgumentException("Unknow viewmodel class")
    }
}
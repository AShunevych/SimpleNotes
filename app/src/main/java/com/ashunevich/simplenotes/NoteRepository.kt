package com.ashunevich.simplenotes

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

@WorkerThread
class NoteRepository(private val noteDao: NoteDao) {

    val allNotes: LiveData<List<NoteEntity>> = noteDao.getAll()

    fun insert(noteEntity: NoteEntity) {
        noteDao.insert(noteEntity)
    }

    fun delete(noteEntity: NoteEntity){
        noteDao.delete(noteEntity)
    }

    fun update(noteEntity: NoteEntity){
        noteDao.update(noteEntity)
    }



}
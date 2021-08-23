package com.ashunevich.simplenotes

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

@WorkerThread
@Suppress("RedundantSuspendModifier")
class NoteRepository(private val noteDao: NoteDao) {

    val allNotes: LiveData<List<NoteEntity>> = noteDao.getAll()

    suspend fun insert(noteEntity: NoteEntity) {
        noteDao.insert(noteEntity)
    }

    suspend fun delete(noteEntity: NoteEntity){
        noteDao.delete(noteEntity)
    }

    suspend fun update(noteEntity: NoteEntity){
        noteDao.update(noteEntity)
    }



}
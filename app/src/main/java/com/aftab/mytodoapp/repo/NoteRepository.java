package com.aftab.mytodoapp.repo;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.aftab.mytodoapp.asynctask.DeleteNoteAsyncTask;
import com.aftab.mytodoapp.asynctask.InsertNoteAsyncTask;
import com.aftab.mytodoapp.asynctask.UpdateNoteAsyncTask;
import com.aftab.mytodoapp.dao.NoteDao;
import com.aftab.mytodoapp.db.NoteDatabase;
import com.aftab.mytodoapp.entity.Note;

import java.util.List;

public class NoteRepository {

    private NoteDao noteDao;
    private LiveData<List<Note>> allNotes;

    public NoteRepository(Application application) {
        NoteDatabase database = NoteDatabase.getInstance(application);
        noteDao = database.noteDao();
        allNotes = noteDao.getAllNotes();
    }

    public void insert(Note note) {
        new InsertNoteAsyncTask(noteDao).execute(note);
    }

    public void update(Note note) {
        new UpdateNoteAsyncTask(noteDao).execute(note);
    }

    public void delete(Note note) {
        new DeleteNoteAsyncTask(noteDao).execute(note);
    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }

    // AsyncTask classes for database operations
}

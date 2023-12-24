package com.aftab.mytodoapp.asynctask;

import android.os.AsyncTask;

import com.aftab.mytodoapp.dao.NoteDao;
import com.aftab.mytodoapp.entity.Note;

public class InsertNoteAsyncTask extends AsyncTask<Note, Void, Void> {
    private NoteDao noteDao;

    public InsertNoteAsyncTask(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    @Override
    protected Void doInBackground(Note... notes) {
        noteDao.insert(notes[0]);
        return null;
    }
}

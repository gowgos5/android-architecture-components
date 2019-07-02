package com.gowgos5.architecturecomponents;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

// By using the @Dao annotation, Room knows that it should provide the implementation for our interface
// by generating code for the defined methods. In this interface, we could define the CRUD operations for our entity.
@Dao
public interface NoteDao {
    @Insert
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);

    // Run SQL query
    // SQL DELETE statement - "DELETE FROM table_name WHERE condition"
    @Query("DELETE FROM note_table")
    void deleteAllNotes();

    // SQL SELECT statement - "SELECT column1, column2, ... FROM table_name"
    @Query("SELECT * FROM note_table ORDER BY priority DESC")
    LiveData<List<Note>> getAllNotes();
}

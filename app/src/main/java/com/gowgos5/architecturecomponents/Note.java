package com.gowgos5.architecturecomponents;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

// By using the @Entity annotation, Room will know that this class will be a table in the database and the tableName will define the name of the table
@Entity(tableName = "note_table")
public class Note {

    // A primary key is a field in a table which uniquely identifies each row/record in a database table.
    // Set autoGenerate to true to let SQLite generate the unique id.
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;
    private String description;
    private int priority;

    // Constructor
    public Note(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
}

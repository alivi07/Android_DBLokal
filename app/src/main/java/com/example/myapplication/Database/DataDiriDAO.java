package com.example.myapplication.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface DataDiriDAO {
    @Insert
    long insertData(DataDiri dataDiri);

    @Query("SELECT * FROM datadiri_db")
    DataDiri[] getData();

    @Update
    int updateData(DataDiri item);

    @Delete
    void deleteData (DataDiri item);
}

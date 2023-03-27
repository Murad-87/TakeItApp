package com.example.takeitapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.takeitapp.data.local.model.TakeItDbModel

@Dao
interface TakeItDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPublication(publication: TakeItDbModel)

    @Query("SELECT * FROM table_publication")
    suspend fun getAllPublication() : List<TakeItDbModel>

}
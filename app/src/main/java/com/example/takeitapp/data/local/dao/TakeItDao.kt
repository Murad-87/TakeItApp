package com.example.takeitapp.data.local.dao

import androidx.room.*
import com.example.takeitapp.data.local.model.TakeItDbModel
import kotlinx.coroutines.flow.Flow

@Dao
interface TakeItDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPublication(publication: TakeItDbModel)

    @Query("SELECT * FROM table_publication")
    fun getAllPublication() : Flow<List<TakeItDbModel>>

    @Delete
    suspend fun deletePublicationUser(item : TakeItDbModel)

}
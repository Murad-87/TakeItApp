package com.mytakeitapp.core_database.dao

import androidx.room.*
import com.mytakeitapp.core_database.model.TakeItDbModel
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
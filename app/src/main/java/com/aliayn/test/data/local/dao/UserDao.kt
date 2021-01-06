package com.aliayn.test.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.aliayn.test.data.local.entity.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(user: User)

    @Delete
    suspend fun delete(user: User)

    @Query("SELECT * FROM user_table")
    fun getAllUsers(): LiveData<List<User>>

    @Query("SELECT EXISTS (SELECT * FROM user_table WHERE userName = :userName AND passWord = :passWord)")
    suspend fun isExists(userName: String, passWord: String): Boolean

    @Query(" SELECT * FROM user_table WHERE userName = :userName AND passWord = :passWord")
    suspend fun getCertainUser(userName: String, passWord: String): User

}
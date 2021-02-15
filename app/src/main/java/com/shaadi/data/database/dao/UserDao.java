package com.shaadi.data.database.dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.shaadi.data.model.User;

import java.util.List;

/**
 * @author Payal Jian
 * @version 1.0
 * @since 14/Feb/21
 */

@SuppressWarnings("unused")
@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);

    @Query("SELECT * FROM user")
    List<User> loadAllUser();

    @Query("UPDATE user SET accept=:status WHERE _id = :id")
    void update(boolean status, String id);

    @Query("UPDATE user SET decline=:status WHERE _id = :id")
    void updateDeclineStatus(boolean status, String id);

    @Query("SELECT * FROM user where _id = :id")
    User getUserById(String id);
}

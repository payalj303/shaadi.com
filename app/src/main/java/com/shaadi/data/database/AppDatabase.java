package com.shaadi.data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.shaadi.data.database.dao.UserDao;
import com.shaadi.data.model.User;


/**
 * @author Payal Jian
 * @version 1.0
 * @since 14/Feb/21
 */
@Database(entities = {User.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();


    @Override
    public void clearAllTables() {

    }

}

package com.example.app.roomDatabases;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.app.DAOs.RecenzieDAO;
import com.example.app.DAOs.UtilizatorDAO;
import com.example.app.models.Recenzie;
import com.example.app.models.Utilizator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Utilizator.class, Recenzie.class},version = 1,exportSchema = false)
public abstract class AppRoomDB extends RoomDatabase {
    private static AppRoomDB instance;
    private static final String databaseName = "toplist.db";

    private static final ExecutorService databaseWriteExecutor = Executors.newSingleThreadExecutor();

    public static AppRoomDB getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, AppRoomDB.class, databaseName)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .addCallback(prepopulateCallback)
                    .build();
        }
        return instance;
    }

    private static final RoomDatabase.Callback prepopulateCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {
                UtilizatorDAO utilizatorDAO = instance.getUtilizatorDAO();
                Utilizator defaultUser = new Utilizator("Magu","Stefan","Parola");
                utilizatorDAO.insertUtilizator(defaultUser);
            });
        }
    };

    public abstract UtilizatorDAO getUtilizatorDAO();
    public abstract RecenzieDAO getRecenzieDAO();
}
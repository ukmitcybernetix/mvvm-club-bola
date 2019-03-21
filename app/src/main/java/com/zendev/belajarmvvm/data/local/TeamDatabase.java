package com.zendev.belajarmvvm.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.zendev.belajarmvvm.model.TeamDetail;

@Database(entities = {TeamDetail.class}, version = 1)
public abstract class TeamDatabase extends RoomDatabase {

    private static TeamDatabase INSTANCE;
    public abstract TeamDao teamDao();
    private static final Object sLock = new Object();

    public static TeamDatabase getInstance(Context context){
        synchronized (sLock){
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        TeamDatabase.class, "Team.db")
                        .build();
            }
            return INSTANCE;
        }
    }
}

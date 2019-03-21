package com.zendev.belajarmvvm;

import android.content.Context;

import com.zendev.belajarmvvm.data.TeamRepository;
import com.zendev.belajarmvvm.data.local.TeamLocalDataSource;
import com.zendev.belajarmvvm.data.remote.TeamRemoteDataSource;

public class Injection {

    public static TeamRepository provideTeamRepository(Context context){
        return new TeamRepository(new TeamRemoteDataSource(),
                new TeamLocalDataSource(context));
    }
}

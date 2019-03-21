package com.zendev.belajarmvvm.data;

import com.zendev.belajarmvvm.model.Team;

public interface TeamDataSource {

    void getListTeams(GetTeamCallback callback);

    interface GetTeamCallback{
        void onTeamLoaded(Team data);
        void onDataNotAvailable(String errorMessage);
    }
}

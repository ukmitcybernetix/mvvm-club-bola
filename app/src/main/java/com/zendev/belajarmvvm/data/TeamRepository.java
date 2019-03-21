package com.zendev.belajarmvvm.data;

import android.support.annotation.Nullable;

import com.zendev.belajarmvvm.data.local.TeamLocalDataSource;
import com.zendev.belajarmvvm.data.remote.TeamRemoteDataSource;
import com.zendev.belajarmvvm.model.Team;

public class TeamRepository implements TeamDataSource {

    private TeamRemoteDataSource teamRemoteDataSource;
    private TeamLocalDataSource teamLocalDataSource;

    public TeamRepository(TeamRemoteDataSource teamRemoteDataSource, TeamLocalDataSource teamLocalDataSource){
        this.teamRemoteDataSource = teamRemoteDataSource;
        this.teamLocalDataSource = teamLocalDataSource;
    }

    @Override
    public void getListTeams(final GetTeamCallback callback) {
        teamLocalDataSource.getListTeams(new GetTeamCallback() {
            @Override
            public void onTeamLoaded(Team data) {
                callback.onTeamLoaded(data);
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                getTeamsfromRemoteDataSource(callback);
            }
        });
    }

    private void getTeamsfromRemoteDataSource(@Nullable final GetTeamCallback callback){
        teamRemoteDataSource.getListTeams(new GetTeamCallback() {
            @Override
            public void onTeamLoaded(Team data) {
                teamLocalDataSource.saveDataTeam(data.getTeams());
                callback.onTeamLoaded(data);
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                callback.onDataNotAvailable(errorMessage);
            }
        });
    }
}

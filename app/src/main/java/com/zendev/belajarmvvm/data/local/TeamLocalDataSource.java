package com.zendev.belajarmvvm.data.local;

import android.content.Context;

import com.zendev.belajarmvvm.data.TeamDataSource;
import com.zendev.belajarmvvm.model.Team;
import com.zendev.belajarmvvm.model.TeamDetail;

import java.util.List;

public class TeamLocalDataSource implements TeamDataSource {

    private Context context;
    private TeamDao teamDao;

    public TeamLocalDataSource(Context context) {
        this.context = context;
        teamDao = TeamDatabase.getInstance(context).teamDao();
    }

    @Override
    public void getListTeams(final GetTeamCallback callback) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final List<TeamDetail> team = teamDao.getTeams();
                if(team.isEmpty()){
                    callback.onDataNotAvailable("Data Di Database SQLite Kosong");
                }else{
                    Team teams = new Team(team);
                    callback.onTeamLoaded(teams);
                }
            }
        };

        new Thread(runnable).start();
    }

    public void saveDataTeam(final List<TeamDetail> teamDetail) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                teamDao.insertTeam(teamDetail);
            }
        };
        new Thread(runnable).start();

    }
}

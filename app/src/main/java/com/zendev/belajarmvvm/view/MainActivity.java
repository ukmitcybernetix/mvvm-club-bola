package com.zendev.belajarmvvm.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.zendev.belajarmvvm.Injection;
import com.zendev.belajarmvvm.R;
import com.zendev.belajarmvvm.adapter.TeamBolaAdapter;
import com.zendev.belajarmvvm.model.TeamDetail;
import com.zendev.belajarmvvm.navigator.TeamNavigator;
import com.zendev.belajarmvvm.viewmodel.TeamViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TeamNavigator {

    private TeamViewModel mTeamViewModel;
    private RecyclerView recTeam;

    private TeamBolaAdapter adapter;
    private List<TeamDetail> dataListTeamBola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recTeam = findViewById(R.id.recyclerTeamBola);
        mTeamViewModel = new TeamViewModel(Injection.provideTeamRepository(this), this);
        dataListTeamBola = new ArrayList<>();
        mTeamViewModel.setmNavigator(this);
        mTeamViewModel.getListTeam();

        initAdapter();

    }

    @Override
    public void loadListTeam(List<TeamDetail> listTeam) {
        dataListTeamBola.addAll(listTeam);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void errorLoadListTeam(String message) {
        Log.e("ERROR", message);
    }

    private void initAdapter() {
        adapter = new TeamBolaAdapter(dataListTeamBola);
        recTeam.setLayoutManager(new LinearLayoutManager(this));
        recTeam.addItemDecoration(new DividerItemDecoration(this,   DividerItemDecoration.VERTICAL));
        recTeam.setAdapter(adapter);
    }
}

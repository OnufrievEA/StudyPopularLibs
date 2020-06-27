package com.example.studypopularlibs.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studypopularlibs.R;
import com.example.studypopularlibs.presenter.Presenter;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class MainActivity extends MvpAppCompatActivity implements IView{

    @InjectPresenter
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView myRecycler = findViewById(R.id.data_recycler_view);
        myRecycler.setHasFixedSize(true);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        myRecycler.setLayoutManager(layoutManager);

        DataAdapter adapter = new DataAdapter();
        myRecycler.setAdapter(adapter);
        adapter.setListener(new DataAdapter.Listener() {
            @Override
            public void onClick(int position) {
                presenter.onCardClicked();
            }
        });
    }

    @Override
    public void increaseCounter(int counter) {
        Toast.makeText(this, "Counter value: " + counter, Toast.LENGTH_SHORT).show();
    }
}
package joefakri.com.pembelajarananakpaud;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import joefakri.com.pembelajarananakpaud.realm.RealmController;
import joefakri.com.pembelajarananakpaud.realm.ScoreModel;
import joefakri.com.pembelajarananakpaud.realm.table.User;
import joefakri.com.pembelajarananakpaud.util.ScoreAdapter;

/**
 * Created by dev_deny on 4/11/17.
 */

public class ScoreActivity extends AppCompatActivity {

    ImageButton btnBack;
    RecyclerView rvScore;
    ScoreAdapter adapter;
    Realm realm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        realm = RealmController.with(ScoreActivity.this).getRealm();

        btnBack = (ImageButton) findViewById(R.id.btnBack);
        rvScore = (RecyclerView) findViewById(R.id.rvHighScore);
        rvScore.setLayoutManager(new LinearLayoutManager(this));
        rvScore.setHasFixedSize(true);
        rvScore.setNestedScrollingEnabled(false);
        rvScore.setAdapter(adapter = new ScoreAdapter(this));

        initData();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void initData(){
        ArrayList<ScoreModel> scoreModels = new ArrayList<>();
        RealmResults<User> users = RealmController.with(this).getAllUser();
        for (int i = 0; i < users.size(); i++) {
            Log.e("data", users.get(i).getName() + "/" + users.get(i).getScore());
            ScoreModel scoreModel = new ScoreModel();
            scoreModel.setName(users.get(i).getName());
            scoreModel.setScore(users.get(i).getScore());
            scoreModels.add(scoreModel);
        }

        adapter.update(scoreModels);
    }
}

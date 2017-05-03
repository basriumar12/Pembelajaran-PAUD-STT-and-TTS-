package joefakri.com.pembelajarananakpaud;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

import io.realm.RealmResults;
import joefakri.com.pembelajarananakpaud.realm.RealmController;
import joefakri.com.pembelajarananakpaud.realm.PembelajaranModel;
import joefakri.com.pembelajarananakpaud.realm.table.Pembelajaran;
import joefakri.com.pembelajarananakpaud.realm.table.Value;
import joefakri.com.pembelajarananakpaud.util.PembelajaranAdapter;

/**
 * Created by dev_deny on 4/19/17.
 */

public class PembelajaranActivity extends AppCompatActivity implements PembelajaranAdapter.ItemListener{

    RecyclerView recyclerView;
    PembelajaranAdapter wordAdapter;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembelajaran);

        recyclerView = (RecyclerView) findViewById(R.id.rvPembelajaran);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(wordAdapter = new PembelajaranAdapter(this));

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(new Locale("id","ID"));
                }
            }
        });

        initData(getIntent().getStringExtra("type"));
    }

    public void initData(String data){

        RealmResults<Pembelajaran> pembelajaran = RealmController.with(this).getPembelajaran(data);
        ArrayList<PembelajaranModel> pembelajaranModels = new ArrayList<>();
        for (int i = 0; i < pembelajaran.size(); i++) {
            PembelajaranModel pembelajaranModel = new PembelajaranModel();
            pembelajaranModel.setImage(pembelajaran.get(i).getImage());
            pembelajaranModel.setWord(pembelajaran.get(i).getWord());
            pembelajaranModels.add(pembelajaranModel);
        }
        wordAdapter.setOnclickListener(this);
        wordAdapter.update(pembelajaranModels);
    }

    @Override
    protected void onPause() {
        if(textToSpeech !=null){
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onPause();
    }

    @Override
    public void onClick(PembelajaranModel pembelajaranModel) {
        textToSpeech.speak(pembelajaranModel.getWord(), TextToSpeech.QUEUE_FLUSH, null);
    }
}

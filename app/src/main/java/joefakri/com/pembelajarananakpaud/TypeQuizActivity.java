package joefakri.com.pembelajarananakpaud;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import joefakri.com.pembelajarananakpaud.realm.DataPembelajaran;
import joefakri.com.pembelajarananakpaud.realm.DataValue;
import joefakri.com.pembelajarananakpaud.util.UserPreference;

/**
 * Created by dev_deny on 4/24/17.
 */

public class TypeQuizActivity extends AppCompatActivity {

    Button btnHuruf;
    Button btnAngka;
    Button btnWarna;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_quiz);

        btnHuruf = (Button) findViewById(R.id.btnHuruf);
        btnAngka = (Button) findViewById(R.id.btnAngka);
        btnWarna = (Button) findViewById(R.id.btnWarna);


        btnHuruf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new DataValue(TypeQuizActivity.this, 3);
                Intent intent = new Intent(TypeQuizActivity.this, QuizActivity.class);
                intent.putExtra("type", "kata");
                startActivity(intent);
            }
        });

        btnAngka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new DataValue(TypeQuizActivity.this, 1);
                Intent intent = new Intent(TypeQuizActivity.this, QuizActivity.class);
                intent.putExtra("type", "angka");
                startActivity(intent);
            }
        });

        btnWarna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new DataValue(TypeQuizActivity.this, 2);
                Intent intent = new Intent(TypeQuizActivity.this, QuizActivity.class);
                intent.putExtra("type", "warna");
                startActivity(intent);
            }
        });
    }
}

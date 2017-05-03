package joefakri.com.pembelajarananakpaud;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Random;

import io.realm.Realm;
import io.realm.RealmResults;
import joefakri.com.pembelajarananakpaud.realm.RealmController;
import joefakri.com.pembelajarananakpaud.realm.table.User;
import joefakri.com.pembelajarananakpaud.realm.table.Value;
import joefakri.com.pembelajarananakpaud.util.ConfirmDialog;
import joefakri.com.pembelajarananakpaud.util.DialogUtil;
import joefakri.com.pembelajarananakpaud.util.UserPreference;

/**
 * Created by dev_deny on 4/7/17.
 */

public class QuizActivity extends AppCompatActivity implements ConfirmDialog.OnListener{

    ImageView itemLiveOne;
    ImageView itemLiveTwo;
    ImageView itemLiveThree;
    ImageView itemLiveFour;
    ImageView itemLiveFive;
    ImageView btnSpech;
    ImageView quizItem;
    TextView txtResult;
    TextView txtScore;
    Realm realm;

    String item_value = "";

    UserPreference userPreference;

    protected static final int RESULT_SPEECH = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spech);
        realm = RealmController.with(QuizActivity.this).getRealm();
        userPreference = UserPreference.getInstance(this);

        itemLiveOne = (ImageView) findViewById(R.id.itemLiveOne);
        itemLiveTwo = (ImageView) findViewById(R.id.itemLiveTwo);
        itemLiveThree = (ImageView) findViewById(R.id.itemLiveThree);
        itemLiveFour = (ImageView) findViewById(R.id.itemLiveFour);
        itemLiveFive = (ImageView) findViewById(R.id.itemLiveFive);
        btnSpech = (ImageView) findViewById(R.id.btnSpech);
        quizItem = (ImageView) findViewById(R.id.quizItem);
        txtResult = (TextView) findViewById(R.id.txtResult);
        txtScore = (TextView) findViewById(R.id.txtScore);

        RealmResults<Value> values = RealmController.with(QuizActivity.this).getAllValueOnce();
        for (int i = 0; i < values.size(); i++) {
            Log.e("value/id/once", values.get(i).getValue()+"/"+values.get(i).getId()+"/"+values.get(i).getOnce());
            Log.e("image", ""+values.get(i).getImage());
        }
        valueS(values);

        btnSpech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //DialogUtil.confirmDialog(getSupportFragmentManager(), "1").setOnListener(QuizActivity.this);
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "id-ID");
                intent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS, 500);

                try {
                    startActivityForResult(intent, RESULT_SPEECH);
                } catch (ActivityNotFoundException a) {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Opps! Your device doesn't support Speech to Text",
                            Toast.LENGTH_SHORT);
                    t.show();
                }
            }
        });

    }

    public void valueS(RealmResults<Value> values){
        initPanelTop(values);
        Random r = new Random(System.nanoTime());
        if (values.size() != 0){
            int firstRandomNumber = r.nextInt(values.size());
            Value value = values.get(firstRandomNumber);

            RealmController.with(QuizActivity.this).editValueOnce(value.getValue());
            Log.e("image/values", ""+value.getImage()+"/"+value.getValue());

            Glide.with(QuizActivity.this).load(value.getImage()).into(quizItem);
            //quizItem.setImageResource(value.getImage());
            item_value = value.getValue();
            txtResult.setText(value.getValue());
            txtResult.setVisibility(View.INVISIBLE);
        } else {
            Toast.makeText(getApplicationContext(), "Game Selesai", Toast.LENGTH_SHORT);
            DialogUtil.confirmDialog(getSupportFragmentManager(), "2").setOnListener(this);
        }
    }

    public void initPanelTop(RealmResults<Value> values){
        User user = RealmController.with(this).getItemUser(userPreference.getUsername());
        txtScore.setText(""+user.getScore());
        if (user.getSoul() == 5){
            itemLiveOne.setImageResource(R.drawable.img_hearth_fill);
            itemLiveTwo.setImageResource(R.drawable.img_hearth_fill);
            itemLiveThree.setImageResource(R.drawable.img_hearth_fill);
            itemLiveFour.setImageResource(R.drawable.img_hearth_fill);
            itemLiveFive.setImageResource(R.drawable.img_hearth_fill);
            if (values == null || values.size() == 0){
                Toast.makeText(getApplicationContext(), "Game Selesai", Toast.LENGTH_SHORT);
                DialogUtil.confirmDialog(getSupportFragmentManager(), "2").setOnListener(this);
            }
        } else if (user.getSoul() == 4){
            itemLiveOne.setImageResource(R.drawable.img_hearth);
            itemLiveTwo.setImageResource(R.drawable.img_hearth_fill);
            itemLiveThree.setImageResource(R.drawable.img_hearth_fill);
            itemLiveFour.setImageResource(R.drawable.img_hearth_fill);
            itemLiveFive.setImageResource(R.drawable.img_hearth_fill);
            if (values == null || values.size() == 0){
                Toast.makeText(getApplicationContext(), "Game Selesai", Toast.LENGTH_SHORT);
                DialogUtil.confirmDialog(getSupportFragmentManager(), "2").setOnListener(this);
            }
        } else if (user.getSoul() == 3){
            itemLiveOne.setImageResource(R.drawable.img_hearth);
            itemLiveTwo.setImageResource(R.drawable.img_hearth);
            itemLiveThree.setImageResource(R.drawable.img_hearth_fill);
            itemLiveFour.setImageResource(R.drawable.img_hearth_fill);
            itemLiveFive.setImageResource(R.drawable.img_hearth_fill);
            if (values == null || values.size() == 0){
                Toast.makeText(getApplicationContext(), "Game Selesai", Toast.LENGTH_SHORT);
                DialogUtil.confirmDialog(getSupportFragmentManager(), "2").setOnListener(this);
            }
        } else if (user.getSoul() == 2){
            itemLiveOne.setImageResource(R.drawable.img_hearth);
            itemLiveTwo.setImageResource(R.drawable.img_hearth);
            itemLiveThree.setImageResource(R.drawable.img_hearth);
            itemLiveFour.setImageResource(R.drawable.img_hearth_fill);
            itemLiveFive.setImageResource(R.drawable.img_hearth_fill);
            if (values == null || values.size() == 0){
                Toast.makeText(getApplicationContext(), "Game Selesai", Toast.LENGTH_SHORT);
                DialogUtil.confirmDialog(getSupportFragmentManager(), "2").setOnListener(this);
            }
        } else if (user.getSoul() == 1){
            itemLiveOne.setImageResource(R.drawable.img_hearth);
            itemLiveTwo.setImageResource(R.drawable.img_hearth);
            itemLiveThree.setImageResource(R.drawable.img_hearth);
            itemLiveFour.setImageResource(R.drawable.img_hearth);
            itemLiveFive.setImageResource(R.drawable.img_hearth_fill);
            if (values == null || values.size() == 0){
                Toast.makeText(getApplicationContext(), "Game Selesai", Toast.LENGTH_SHORT);
                DialogUtil.confirmDialog(getSupportFragmentManager(), "2").setOnListener(this);
            }
        } else {
            itemLiveOne.setImageResource(R.drawable.img_hearth);
            itemLiveTwo.setImageResource(R.drawable.img_hearth);
            itemLiveThree.setImageResource(R.drawable.img_hearth);
            itemLiveFour.setImageResource(R.drawable.img_hearth);
            itemLiveFive.setImageResource(R.drawable.img_hearth);
            Toast.makeText(getApplicationContext(), "Game Selesai", Toast.LENGTH_SHORT);
            DialogUtil.confirmDialog(getSupportFragmentManager(), "22").setOnListener(this);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case RESULT_SPEECH: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> text = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    Value value = RealmController.with(this).getValue(item_value);
                    Log.e("result", text.get(0));
                    if (!text.get(0).equalsIgnoreCase(value.getValue())){
                        if (value.getBackup_value().contains(",")){
                            String[] word = value.getBackup_value().split(",");
                            for (int i = 0; i < word.length; i++) {
                                if (text.get(0).equalsIgnoreCase(word[i])){
                                    Log.e("looping benar", word[i]);
                                    DialogUtil.confirmDialog(getSupportFragmentManager(), "1").setOnListener(this);
                                    return;
                                } else if (i == word.length - 1){
                                    Log.e("looping salah", word[i]);
                                    DialogUtil.confirmDialog(getSupportFragmentManager(), "0").setOnListener(this);
                                    return;
                                }
                            }
                            //DialogUtil.confirmDialog(getSupportFragmentManager(), "1").setOnListener(this);
                        } else {
                            DialogUtil.confirmDialog(getSupportFragmentManager(), "0").setOnListener(this);
                        }
                    } else if (text.get(0).equalsIgnoreCase(value.getValue())){
                        DialogUtil.confirmDialog(getSupportFragmentManager(), "1").setOnListener(this);
                    }
                }
                break;
            }

        }
    }

    @Override
    public void onClick(String type) {
        //Log.e("type", type);
        RealmResults<Value> values = RealmController.with(QuizActivity.this).getAllValueOnce();
        if (type.equals("1")){
            User user = RealmController.with(this).getItemUser(userPreference.getUsername());
            RealmController.with(this).editUserScore(userPreference.getUsername(), user.getScore() + 10);
            valueS(values);
        } else if (type.equals("2") || type.equals("22")) {
            RealmController.with(QuizActivity.this).editAllValueOnce();
            startActivity(new Intent(QuizActivity.this, ScoreActivity.class));
            finish();
        } else {
            RealmController.with(QuizActivity.this).editUserSoul(userPreference.getUsername());
            initPanelTop(values);
            //valueS(values);
        }

    }

    @Override
    public void finish() {
        super.finish();
        RealmController.with(QuizActivity.this).editAllValueOnce();
    }
}

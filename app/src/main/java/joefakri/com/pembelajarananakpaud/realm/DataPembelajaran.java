package joefakri.com.pembelajarananakpaud.realm;

import android.app.Activity;

import io.realm.Realm;
import joefakri.com.pembelajarananakpaud.R;

/**
 * Created by dev_deny on 4/8/17.
 */

public class DataPembelajaran {

    Realm realm;

    public DataPembelajaran(Activity act) {
        realm = RealmController.with(act).getRealm();
        RealmController.with(act).clearDataPembelajaran();

        RealmController.with(act).insertPembelajaranWarna("abu abu", R.drawable.color_abu_abu);
        RealmController.with(act).insertPembelajaranWarna("biru", R.drawable.color_biru);
        RealmController.with(act).insertPembelajaranWarna("cokelat", R.drawable.color_cokelat);
        RealmController.with(act).insertPembelajaranWarna("hijau", R.drawable.color_hijau);
        RealmController.with(act).insertPembelajaranWarna("hitam", R.drawable.color_hitam);
        RealmController.with(act).insertPembelajaranWarna("kuning", R.drawable.color_kuning);
        RealmController.with(act).insertPembelajaranWarna("merah", R.drawable.color_merah);
        RealmController.with(act).insertPembelajaranWarna("oranye", R.drawable.color_oranye);
        RealmController.with(act).insertPembelajaranWarna("putih", R.drawable.color_putih);
        RealmController.with(act).insertPembelajaranWarna("ungu", R.drawable.color_ungu);


        RealmController.with(act).insertPembelajaranAngka("satu", R.drawable.number_1);
        RealmController.with(act).insertPembelajaranAngka("dua", R.drawable.number_2);
        RealmController.with(act).insertPembelajaranAngka("tiga", R.drawable.number_3);
        RealmController.with(act).insertPembelajaranAngka("empat", R.drawable.number_4);
        RealmController.with(act).insertPembelajaranAngka("lima", R.drawable.number_5);
        RealmController.with(act).insertPembelajaranAngka("enam", R.drawable.number_6);
        RealmController.with(act).insertPembelajaranAngka("tujuh", R.drawable.number_7);
        RealmController.with(act).insertPembelajaranAngka("delapan", R.drawable.number_8);
        RealmController.with(act).insertPembelajaranAngka("sembilan", R.drawable.number_9);
        RealmController.with(act).insertPembelajaranAngka("sepuluh", R.drawable.number_10);
        RealmController.with(act).insertPembelajaranAngka("sebelas", R.drawable.number_11);
        RealmController.with(act).insertPembelajaranAngka("dua belas", R.drawable.number_12);
        RealmController.with(act).insertPembelajaranAngka("tiga belas", R.drawable.number_13);
        RealmController.with(act).insertPembelajaranAngka("empat belas", R.drawable.number_14);
        RealmController.with(act).insertPembelajaranAngka("lima belas", R.drawable.number_15);
        RealmController.with(act).insertPembelajaranAngka("enam belas", R.drawable.number_16);
        RealmController.with(act).insertPembelajaranAngka("tujuh belas", R.drawable.number_17);
        RealmController.with(act).insertPembelajaranAngka("delapan belas", R.drawable.number_18);
        RealmController.with(act).insertPembelajaranAngka("sembilan belas", R.drawable.number_19);
        RealmController.with(act).insertPembelajaranAngka("dua puluh", R.drawable.number_20);
        RealmController.with(act).insertPembelajaranAngka("dua puluh satu", R.drawable.number_21);
        RealmController.with(act).insertPembelajaranAngka("dua puluh dua", R.drawable.number_22);
        RealmController.with(act).insertPembelajaranAngka("dua puluh tiga", R.drawable.number_23);
        RealmController.with(act).insertPembelajaranAngka("dua puluh empat", R.drawable.number_24);
        RealmController.with(act).insertPembelajaranAngka("dua puluh lima", R.drawable.number_25);
        RealmController.with(act).insertPembelajaranAngka("dua puluh enam", R.drawable.number_26);
        RealmController.with(act).insertPembelajaranAngka("dua puluh tujuh", R.drawable.number_27);
        RealmController.with(act).insertPembelajaranAngka("dua puluh delapan", R.drawable.number_28);
        RealmController.with(act).insertPembelajaranAngka("dua puluh sembilan", R.drawable.number_29);
        RealmController.with(act).insertPembelajaranAngka("tiga puluh", R.drawable.number_30);

        RealmController.with(act).insertPembelajaranKata("a", R.drawable.word_a);
        RealmController.with(act).insertPembelajaranKata("b", R.drawable.word_b);
        RealmController.with(act).insertPembelajaranKata("c", R.drawable.word_c);
        RealmController.with(act).insertPembelajaranKata("d", R.drawable.word_d);
        RealmController.with(act).insertPembelajaranKata("e", R.drawable.word_e);
        RealmController.with(act).insertPembelajaranKata("f", R.drawable.word_f);
        RealmController.with(act).insertPembelajaranKata("g", R.drawable.word_g);
        RealmController.with(act).insertPembelajaranKata("h", R.drawable.word_h);
        RealmController.with(act).insertPembelajaranKata("i", R.drawable.word_i);
        RealmController.with(act).insertPembelajaranKata("j", R.drawable.word_j);
        RealmController.with(act).insertPembelajaranKata("k", R.drawable.word_k);
        RealmController.with(act).insertPembelajaranKata("l", R.drawable.word_l);
        RealmController.with(act).insertPembelajaranKata("m", R.drawable.word_m);
        RealmController.with(act).insertPembelajaranKata("n", R.drawable.word_n);
        RealmController.with(act).insertPembelajaranKata("o", R.drawable.word_o);
        RealmController.with(act).insertPembelajaranKata("p", R.drawable.word_p);
        RealmController.with(act).insertPembelajaranKata("q", R.drawable.word_q);
        RealmController.with(act).insertPembelajaranKata("r", R.drawable.word_r);
        RealmController.with(act).insertPembelajaranKata("s", R.drawable.word_s);
        RealmController.with(act).insertPembelajaranKata("t", R.drawable.word_t);
        RealmController.with(act).insertPembelajaranKata("u", R.drawable.word_u);
        RealmController.with(act).insertPembelajaranKata("v", R.drawable.word_v);
        RealmController.with(act).insertPembelajaranKata("w", R.drawable.word_w);
        RealmController.with(act).insertPembelajaranKata("x", R.drawable.word_x);
        RealmController.with(act).insertPembelajaranKata("y", R.drawable.word_y);
        RealmController.with(act).insertPembelajaranKata("z", R.drawable.word_z);


    }
}

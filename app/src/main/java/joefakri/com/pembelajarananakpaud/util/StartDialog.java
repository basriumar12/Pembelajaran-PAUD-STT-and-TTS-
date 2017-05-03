package joefakri.com.pembelajarananakpaud.util;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import io.realm.Realm;
import joefakri.com.pembelajarananakpaud.R;
import joefakri.com.pembelajarananakpaud.realm.RealmController;
import joefakri.com.pembelajarananakpaud.realm.table.User;


/**
 * Created by dev_deny on 10/14/16.
 */
public class StartDialog extends DialogFragment {

    OnListener onListener;
    Realm realm;

    public static StartDialog newIntance() {
        StartDialog messageDialog = new StartDialog();
        Bundle bundle = new Bundle();
        bundle.putString("message", "");
        messageDialog.setArguments(bundle);
        return messageDialog;
    }

    public void setOnListener(OnListener onListener){
        this.onListener = onListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_start, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.CustomDialog);
    }

    @Override
    public void onViewCreated(View v, @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        setStyle(STYLE_NO_FRAME, 0);
        realm = RealmController.with(getActivity()).getRealm();

        final EditText edName = (EditText) v.findViewById(R.id.edName);
        Button btnStart = (Button) v.findViewById(R.id.btnStart);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edName.getText().toString().isEmpty()){
                    User user = RealmController.with(getActivity()).getItemUser(edName.getText().toString());
                    if (user == null){
                        RealmController.with(getActivity()).insertUser(edName.getText().toString());
                    } else {
                        realm.beginTransaction();
                        user.deleteFromRealm();
                        realm.commitTransaction();
                        RealmController.with(getActivity()).insertUser(edName.getText().toString());
                    }
                    RealmController.with(getActivity()).editAllValueOnce();
                    onListener.onClick(edName.getText().toString());
                    dismiss();
                    edName.setText("");
                }
            }
        });
    }

    public interface OnListener {
        public void onClick(String name);
    }

}
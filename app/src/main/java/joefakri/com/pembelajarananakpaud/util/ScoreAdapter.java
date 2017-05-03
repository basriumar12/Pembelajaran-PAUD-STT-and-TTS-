package joefakri.com.pembelajarananakpaud.util;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import joefakri.com.pembelajarananakpaud.R;
import joefakri.com.pembelajarananakpaud.realm.ScoreModel;

/**
 * Created by dev_deny on 1/25/17.
 */

public class ScoreAdapter extends RecyclerView.Adapter {

    private ArrayList<ScoreModel> scoreModels;
    ItemListener itemListener;
    private Context context;

    public ScoreAdapter(Context context) {
        this.context = context;
        scoreModels = new ArrayList<>();
    }

    public void update(ArrayList<ScoreModel> scoreModels) {
        this.scoreModels = scoreModels;
        notifyDataSetChanged();
    }

    public void setOnclickListener(ItemListener itemlistener){
        this.itemListener = itemlistener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_score, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((Holder) holder).setValue(scoreModels.get(position));
    }

    @Override
    public int getItemCount() {
        return scoreModels.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        View dividerHeader;
        View dividerBottom;
        View viewHeader;
        TextView txtNama;
        TextView txtNilai;

        Holder(View itemView) {
            super(itemView);
            dividerHeader = (View) itemView.findViewById(R.id.dividerHeader);
            dividerBottom = (View) itemView.findViewById(R.id.dividerBottom);
            viewHeader = (View) itemView.findViewById(R.id.viewHeader);
            txtNama = (TextView) itemView.findViewById(R.id.txtNama);
            txtNilai = (TextView) itemView.findViewById(R.id.txtNilai);
        }

        private void setValue(final ScoreModel scoreModel) {
            if (getAdapterPosition() == 0){
                dividerHeader.setVisibility(View.VISIBLE);
                viewHeader.setVisibility(View.VISIBLE);
                dividerBottom.setVisibility(View.VISIBLE);
            } else if (getAdapterPosition() == getItemCount() - 1){
                dividerHeader.setVisibility(View.GONE);
                viewHeader.setVisibility(View.GONE);
                dividerBottom.setVisibility(View.VISIBLE);
            } else {
                dividerHeader.setVisibility(View.GONE);
                viewHeader.setVisibility(View.GONE);
                dividerBottom.setVisibility(View.GONE);
            }

            txtNama.setText(scoreModel.getName());
            txtNilai.setText(""+scoreModel.getScore());

        }
    }

    public interface ItemListener{
        void onClick(ScoreModel scoreModel);
    }

}

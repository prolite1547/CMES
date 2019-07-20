package cmesapp.cmes_app;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ASUS on 3/10/2018.
 */

public class topscore_Adapter extends RecyclerView.Adapter<topscore_Adapter.ViewHolder>{

    private List<String> list_no, list_user, list_score;
    private Context context;

    private SoundPlayer soundPlayer;

    public topscore_Adapter(Context context ,List<String> list_no ,List<String> list_user ,List<String> list_score) {
        this.context = context;
        this.list_no = list_no;
        this.list_user = list_user;
        this.list_score = list_score;
        soundPlayer = new SoundPlayer(context);
    }




    @Override
    public topscore_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.score_row,parent,false);
        return new topscore_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(topscore_Adapter.ViewHolder holder, int position) {
        holder.no.setText(list_no.get(position));
        holder.user.setText(list_user.get(position));
        holder.score.setText(list_score.get(position));
    }

    @Override
    public int getItemCount() {
        return list_no.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView no, user, score;

        public ViewHolder(View itemView) {
            super(itemView);
            no = (TextView) itemView.findViewById(R.id.id_no_scorerow);
            user = (TextView) itemView.findViewById(R.id.id_user_scorerow);
            score = (TextView) itemView.findViewById(R.id.id_score_scorerow);
        }
    }
}

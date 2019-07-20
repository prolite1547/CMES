package cmesapp.cmes_app;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by ASUS on 3/8/2018.
 */

public class TopicsAdapter extends RecyclerView.Adapter<TopicsAdapter.ViewHolder>{

    MyAccount myAccount = new MyAccount();

    Toast toast;

    private List<String> list;
    private int[] myImage;
    private String subject_selected;
    private Context context;

    private SoundPlayer soundPlayer;

    public TopicsAdapter(Context context ,int[] myImage ,List list, String subject_selected) {
        this.context = context;
        this.myImage = myImage;
        this.list = list;
        this.subject_selected = subject_selected;
        soundPlayer = new SoundPlayer(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

//        final MyAccount myAccount = new MyAccount();

        boolean is_required = new Database_Helper(context).check_topic(myAccount.getUser(), subject_selected,list.get(position),"YES");

        holder.image.setImageResource(myImage[position]);
        holder.desc.setText(list.get(position));


        if (is_required) {
            holder.tvlevel.setText("Lv " + "" + position);
            holder.btnLock.setVisibility(View.VISIBLE);
            holder.btnCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    show("Unable to learn. Please try again.");
//                    new Database_Helper(context).updateTopic(myAccount.getUser(),subject_selected,holder.desc.getText().toString(),"NO");


//                    new Database_Helper(context).updateLevel(myAccount.getUser(),subject_selected,"2");
//                    new Database_Helper(context).check_level(myAccount.getUser(),subject_selected);
//                    Toast.makeText(context,"Level is: "  + myAccount.getLevel(),Toast.LENGTH_LONG).show();
                }
            });
        }
        else{
            holder.btnCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MyList myList = new MyList();

                    Intent intent = new Intent(context,MyWebView.class);
                    if (subject_selected.equals("SCIENCE")){
                        soundPlayer.playPopNext();
//                    intent.putExtra("main_color",R.color.blue);
                        intent.putExtra("title",myList.science_topics[position]);
                        intent.putExtra("url",myList.science_topics_web[position]);
                    }else if (subject_selected.equals("ENGLISH")) {
                        soundPlayer.playPopNext();
//                    intent.putExtra("main_color",R.color.yellow);
                        intent.putExtra("title",myList.english_topics[position]);
                        intent.putExtra("url",myList.english_topics_web[position]);
                    }else if (subject_selected.equals("FILIPINO")) {
                        soundPlayer.playPopNext();
//                    intent.putExtra("main_color",R.color.red);
                        intent.putExtra("title",myList.filipino_topics[position]);
                        intent.putExtra("url",myList.filipino_topics_web[position]);
                    }
                    context.startActivity(intent);
                }
            });
        }





    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView image;
        public TextView desc, tvlevel;
        public RelativeLayout btnCard;
        public LinearLayout btnLock;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.id_image_card);
            desc = (TextView) itemView.findViewById(R.id.id_dese_card);
            tvlevel = (TextView) itemView.findViewById(R.id.id_level_card);
            btnCard = (RelativeLayout) itemView.findViewById(R.id.id_card);
            btnLock = (LinearLayout) itemView.findViewById(R.id.id_lock_card);
        }
    }

    public void show(String msg) {
        if (toast != null)
            toast.cancel();
        toast = Toast.makeText(context,msg,Toast.LENGTH_LONG  );
        toast.show();
    }
}

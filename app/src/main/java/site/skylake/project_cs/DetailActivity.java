package site.skylake.project_cs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static site.skylake.project_cs.SendFragment.Extra_idimg;
import static site.skylake.project_cs.SendFragment.EXtra_img;
import static site.skylake.project_cs.SendFragment.EXtra_name;
import static site.skylake.project_cs.SendFragment.EXtra_score;

public class DetailActivity extends AppCompatActivity {

    Button revice;
    String score;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        final Intent intent = getIntent();
        String imageUrl = intent.getStringExtra(EXtra_img);
        String name = intent.getStringExtra(EXtra_name);
        score = intent.getStringExtra(EXtra_score);
        id = intent.getStringExtra(Extra_idimg);

        ImageView imageView = findViewById(R.id.image_detail);
        TextView textViewname = findViewById(R.id.name_detail);
        TextView textViewscore = findViewById(R.id.score_detail);

        Picasso.get().load(imageUrl).fit().centerInside().into(imageView);
        textViewname.setText(name);
        textViewscore.setText("Score : " + score);

        revice = findViewById(R.id.reciveadd);

        revice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inrev = new Intent(getApplicationContext(), SentActivity.class);
                inrev.putExtra("id", id);
                startActivity(inrev);


            }
        });
    }
}

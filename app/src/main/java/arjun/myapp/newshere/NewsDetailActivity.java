package arjun.myapp.newshere;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NewsDetailActivity extends AppCompatActivity {

    String title,content,desc,imageURL,url;
    private TextView titleTV,contentTV,subDescTV;
    private ImageView newsIV;
    private Button readNewsBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        title=getIntent().getStringExtra("title");
        content=getIntent().getStringExtra("content");
        desc=getIntent().getStringExtra("description");
        imageURL=getIntent().getStringExtra("urlToImage");
        url=getIntent().getStringExtra("url");
        titleTV=findViewById(R.id.idTVTitle);
        contentTV=findViewById(R.id.idTVContent);
        subDescTV=findViewById(R.id.idTVSubDesc);
        newsIV=findViewById(R.id.idIVNews);
        readNewsBtn=findViewById(R.id.idBtnReadNews);
        titleTV.setText(title);
        subDescTV.setText(desc);
        contentTV.setText(content);
        Picasso.get().load(imageURL).into(newsIV);
        readNewsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}
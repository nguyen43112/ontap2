package com.example.ontap2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class SeconActivity extends AppCompatActivity {
    TextView tvinfopostid ,tvinfoid,tvinfoname, tvinfoemail,tvinfobody;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_activity);
        tvinfopostid = findViewById(R.id.infopostId);
        tvinfoid= findViewById(R.id.infoid);
        tvinfoname = findViewById(R.id.infoname);
        tvinfoemail = findViewById(R.id.infoemail);
        tvinfobody= findViewById(R.id.infobody);
        Intent intent = getIntent();
        //Lay Thong tin trong List Ve
        String mpost = intent.getStringExtra("postId");
        String mid = intent.getStringExtra("id");
        String mname = intent.getStringExtra("name");
        String memail = intent.getStringExtra("email");
        String mbody = intent.getStringExtra("body");
        //Ttruyen vao
        tvinfopostid.setText(mpost);
        tvinfoid.setText(mid);
        tvinfoname.setText(mname);
        tvinfoemail.setText(memail);
        tvinfobody.setText(mbody);
    }
}

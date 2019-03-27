package demo.report.com.gramnardemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import demo.report.com.gramnardemo.aidl.AidlActivity;
import demo.report.com.gramnardemo.kottlin.KottlinDemoActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){

        if(view.getId() == R.id.aidl_demo){
            //aidl
            Intent intent = new Intent(this, AidlActivity.class);
            startActivity(intent);
        }else if(view.getId() == R.id.kottlin_demo){

            Intent intent = new Intent(this, KottlinDemoActivity.class);
            startActivity(intent);
        }
    }
}

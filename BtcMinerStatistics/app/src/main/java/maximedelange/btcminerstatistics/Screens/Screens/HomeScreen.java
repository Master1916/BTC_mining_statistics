package maximedelange.btcminerstatistics.Screens.Screens;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;

import maximedelange.btcminerstatistics.R;

public class HomeScreen extends AppCompatActivity {

    // Fields
    private ImageButton gotoUserScreen = null;
    private ImageButton gotoPoolScreen = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigateToUserScreen();
        navigateToPoolScreen();
        changeNavigationBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void navigateToUserScreen(){
        gotoUserScreen = (ImageButton) findViewById(R.id.btnUserScreen);
        gotoUserScreen.setImageResource(R.mipmap.accountavatar);
        gotoUserScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userScreen = new Intent(view.getContext(), UserScreen.class);
                startActivity(userScreen);
            }
        });
    }

    public void navigateToPoolScreen(){
        gotoPoolScreen = (ImageButton) findViewById(R.id.btnPoolScreen);
        gotoPoolScreen.setImageResource(R.mipmap.pooldata);
        gotoPoolScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent poolScreen = new Intent(view.getContext(), PoolScreen.class);
                startActivity(poolScreen);
            }
        });
    }

    public void changeNavigationBar(){
        setTitle("Mining statistics");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#071e22")));
    }
}

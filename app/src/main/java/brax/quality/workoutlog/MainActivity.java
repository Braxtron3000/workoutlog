package brax.quality.workoutlog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;

import javax.sql.DataSource;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Workout_list workout_list = Workout_list.newInstance("", "");
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frameLayout, workout_list)
                .commit();*/


        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.actionItem_createWorkout) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragmentContainerView, Playlist.newInstance("", ""))
                            .addToBackStack(null)
                            .commit();
                    Toast.makeText(MainActivity.this, "yo. it worked.", Toast.LENGTH_SHORT).show();
                    return true;
                } else {
                    Toast.makeText(MainActivity.this, "else statement", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }
        });
    }




}



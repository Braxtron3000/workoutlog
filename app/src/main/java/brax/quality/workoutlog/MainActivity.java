package brax.quality.workoutlog;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

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


        ((Toolbar)findViewById(R.id.topAppBar)).setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.actionItem_createWorkout) {
                    Navigation.findNavController(findViewById(R.id.fragmentContainerView)).navigate(R.id.action_workout_list_to_playlist);
                    /*getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragmentContainerView, Playlist.newInstance("", ""))
                            .addToBackStack(null)
                            .commit();*/
                    return true;
                } else {
                    Toast.makeText(MainActivity.this, "there was an issue", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }
        });
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);

        NavController navController = Navigation.findNavController(this,R.id.fragmentContainerView);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();

        MaterialToolbar toolbar = findViewById(R.id.topAppBar);

        NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration);
        NavigationUI.setupWithNavController(toolbar,navController,appBarConfiguration);

    }
}



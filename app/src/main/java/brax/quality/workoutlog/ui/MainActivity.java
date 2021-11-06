package brax.quality.workoutlog.ui;


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
import com.google.android.material.snackbar.Snackbar;

import javax.sql.DataSource;

import brax.quality.workoutlog.R;

public class MainActivity extends AppCompatActivity {

    AppBarConfiguration appBarConfiguration;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }



    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this,R.id.fragmentContainerView);
        return NavigationUI.navigateUp(navController,appBarConfiguration)
        || super.onSupportNavigateUp();
    }
}



package CaoQuyetChien.lap3_18520526.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import CaoQuyetChien.lap3_18520526.Fragment.News_Fragment;
import CaoQuyetChien.lap3_18520526.Fragment.Search_Fragment;
import CaoQuyetChien.lap3_18520526.Fragment.Setting_Fragment;
import CaoQuyetChien.lap3_18520526.Fragment.TurnIn_Fragment;
import CaoQuyetChien.lap3_18520526.R;

public class MainActivity extends AppCompatActivity {

    MeowBottomNavigation meowBottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showCustomUI();

//        Assign ID layout
        meowBottomNavigation = findViewById(R.id.bottomNavigation);
        meowBottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_news));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_search));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_turn));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.ic_setting));

        meowBottomNavigation.setOnShowListener(item -> {
            int id = item.getId();
            Fragment selectedFragment = null;
            switch (id) {
                case 1:
                    selectedFragment = new News_Fragment();
                    break;
                case 2:
                    selectedFragment = new Search_Fragment();
                    break;
                case 3:
                    selectedFragment = new TurnIn_Fragment();
                    break;
                case 4:
                    selectedFragment = new Setting_Fragment();
                    break;
            }
            assert selectedFragment != null;
            loadFragment(selectedFragment);

        });
        //set the initial fragment to show

        meowBottomNavigation.show(1, true);

        //set menu item on click listener
        meowBottomNavigation.setOnClickMenuListener(item -> {
            //display a toast
//                Toast.makeText(getApplicationContext(), " You clicked " + item.getId(), Toast.LENGTH_SHORT).show();
        });

        //set on reselect listener
        meowBottomNavigation.setOnReselectListener(item -> {
            //display a toast
//                Toast.makeText(getApplicationContext(), " You reselected " + item.getId(), Toast.LENGTH_SHORT).show();
        });

        //set count to dashboard item
        meowBottomNavigation.setCount(3, "10");
    }

    private void loadFragment(Fragment fragment){
//        Replace fragment
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_layout_main,fragment)
                .commit();
    }

    private void showCustomUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }
}
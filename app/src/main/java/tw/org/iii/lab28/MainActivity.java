package tw.org.iii.lab28;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager pager;
    private ArrayList<View> views;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = (ViewPager)findViewById(R.id.pager);
        initViewPager();
    }
    private void initViewPager() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View page1 = inflater.inflate(R.layout.page1, null);
        View page2 = inflater.inflate(R.layout.page2, null);
        View page3 = inflater.inflate(R.layout.page3, null);
        views.add(page1);
        views.add(page2);
        views.add(page3);
        pager.setAdapter();
    }
    private class MyPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return views.size();
        }
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return false;
        }
    }
}

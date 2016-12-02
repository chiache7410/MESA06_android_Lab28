package tw.org.iii.lab28;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager pager;
    private ArrayList<View> views;
    private ViewFlipper flipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = (ViewPager)findViewById(R.id.pager);
        initViewPager();
    }
    private void initViewPager() {
        views = new ArrayList<>();
        LayoutInflater inflater = LayoutInflater.from(this);
        View page0 = inflater.inflate(R.layout.page0, null);
        View page1 = inflater.inflate(R.layout.page1, null);
        View page2 = inflater.inflate(R.layout.page2, null);
        View page3 = inflater.inflate(R.layout.page3, null);
        View pageover = inflater.inflate(R.layout.pageover, null);
        views.add(page0);
        views.add(page1);
        views.add(page2);
        views.add(page3);
        views.add(pageover);

        flipper = (ViewFlipper)page2.findViewById(R.id.flipper);
        //View f0 = flipper.getChildAt(0);
        //View f1 = flipper.getChildAt(1);
        //View f2 = flipper.getChildAt(2);
        flipper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipper.showNext();
            }
        });

        pager.setAdapter(new MyPagerAdapter());
        pager.setOnPageChangeListener(new MyPageChangeListener());
        pager.setCurrentItem(1);
    }
    private class MyPageChangeListener extends ViewPager.SimpleOnPageChangeListener {
        @Override
        public void onPageSelected(int position) {
            //super.onPageSelected(position);
            if (position == 0) {
                pager.setCurrentItem(1);
            }else if (position == views.size()-1) {
                pager.setCurrentItem(3);
            }
        }
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            Log.v("brad", "pos:" + position);
        }
    }
    private class MyPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            Log.v("LabTest", "getCount()");
            return views.size();
        }
        @Override
        public boolean isViewFromObject(View view, Object object) {
            Log.v("LabTest", "isViewFromObject()");
            return view == object;
        }
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Log.v("LabTest", "instantiateItem()");
            View view = views.get(position);
            pager.addView(view);
            return view;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //super.destroyItem(container, position, object);
            Log.v("LabTest", "destroyItem()");
            View view = views.get(position);
            pager.removeView(view);
        }


    }
}

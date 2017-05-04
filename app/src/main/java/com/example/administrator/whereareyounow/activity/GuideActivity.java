package com.example.administrator.whereareyounow.activity;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.whereareyounow.R;

import java.util.ArrayList;

public class GuideActivity extends AppCompatActivity {

    int[] imgs = {
            R.drawable.guide1,
            R.drawable.guide2,
            R.drawable.guide3,

    };
    private LinearLayout containBottom;
    private Runnable r;
    private boolean flag = false;
    ViewPager pager;
    ArrayList<ImageView> list = new ArrayList<ImageView>();
    android.os.Handler handler = new android.os.Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        pager = (ViewPager)findViewById(R.id.pager);
        containBottom=(LinearLayout)findViewById(R.id.bottom_container);
// initView();
        initData();
        initXiaoYuanDian();
        pager.setAdapter(new MyPagerAdapter());

//默认选中指定条目，即设置支持ViewPager初始显示时既可以向右滑动
//       pager.setCurrentItem(200);

//让它自己动起来，实现广告播放
//       r = new Runnable() {
//            @Override
//            public void run() {
//                pager.setCurrentItem(pager.getCurrentItem() + 1);
//                handler.postDelayed(this, 1000);
//            }
//        };
//        handler.postDelayed(r, 3000);

        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            //对小圆点进行设置
            @Override
            public void onPageSelected(int arg0) {
                for (int i = 0; i < list.size(); i++) {
// 可以实现小圆点的切换
                    // 通过container容器和下标position,找到指定的ImageView,修改他的图片就可以了
                    ImageView iv = (ImageView) containBottom.getChildAt(i);
                    if(i == arg0%list.size()){
                        iv.setImageResource(R.drawable.guide_yellow); //选中的图片
                    }else {
//其他ImageView都是默认的小圆点
                        iv.setImageResource(R.drawable.guide_white);
                    }
                }
            }
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            //强制停止图片的自动切换，也就是停止handler的调用
            @Override
            public void onPageScrollStateChanged(int arg0) {
                switch (arg0) {
                    case ViewPager.SCROLL_STATE_DRAGGING:
//强制停止图片的自动切换，也就是停止handler的调用
                        handler.removeCallbacks(r);
                        flag = true;
                        break;
                    case ViewPager.SCROLL_STATE_IDLE:
                        if (flag) {
                            handler.postDelayed(r, 3000);
                            flag = false;
                        }
                        break;
                }
            }
        });
    }
/*private void initView() {
        //初始化ViewPager
        //将ViewPager的高度设置为屏幕高度的1/4
        int screenH = getResources().getDisplayMetrics().heightPixels;
        *//*
       * 通过设置控件的布局参数对象设置viewpager的宽高信息。也可以直接在布局里设定viewpager的高度
       * *//*
        pager.setLayoutParams(new RelativeLayout.LayoutParams(ViewPager.LayoutParams.MATCH_PARENT, screenH / 4));
    }*/

    private void initData() {
        for (int i = 0; i < imgs.length; i++) {
            ImageView iv = new ImageView(this);
            iv.setImageResource(imgs[i]);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            list.add(iv);
        }
    }
    private void initXiaoYuanDian() {
        for (int i = 0; i < imgs.length; i++) {
            ImageView iv2 = new ImageView(this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            iv2.setLayoutParams(lp);
//设置图片源 (默认没有选中的图片,初始化时候第一张图片对应的小圆点是details_like_click_icon)
            if(i == 0){
//构建第一个ImageView的时候选用dot_0的图片
                iv2.setImageResource(R.drawable.guide_yellow);
            }else {
//构建后续ImageView使用details_like_icon的图片
//小圆点的距离
                lp.setMargins(30,0,0,0);
                iv2.setImageResource(R.drawable.guide_white);
            }
//添加到容器中
            containBottom.addView(iv2);
        }
    }

    class MyPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {

            return imgs.length;
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {

            return arg0 == arg1;
        }

        //对图片进行监听
        @Override
        public Object instantiateItem(ViewGroup container, final int position) {

            View v = list.get(position %list.size());
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                //    Toast.makeText(GuideActivity.this, "图片被监听了" + position, Toast.LENGTH_SHORT).show();
                }
            });
            container.addView(v);
            return v;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}

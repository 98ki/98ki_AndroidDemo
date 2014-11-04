package com.ki.android.demo;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import cn.trinea.android.common.util.ListUtils;
import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

import com.ki.demo.adapter.ImagePagerAdapter;
import com.viewpagerindicator.CirclePageIndicator;

/**
 * AutoScrollViewPagerDemo
 * 
 * @author <a href="http://www.trinea.cn" target="_blank">Trinea</a> 2014-2-22
 */
public class AutoScrollViewPagerDemo extends BaseActivity {

    private AutoScrollViewPager viewPager;
    private CirclePageIndicator indicator;

    private Button              innerViewPagerDemo;

    private List<Integer>       imageIdList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.auto_scroll_view_pager_demo);

        viewPager = (AutoScrollViewPager)findViewById(R.id.view_pager);
        indicator = (CirclePageIndicator)findViewById(R.id.cpi_indicator);
        
        imageIdList = new ArrayList<Integer>();
        imageIdList.add(R.drawable.banner1);
        imageIdList.add(R.drawable.banner2);
        imageIdList.add(R.drawable.banner3);
        imageIdList.add(R.drawable.banner4);
        viewPager.setAdapter(new ImagePagerAdapter(context, imageIdList));

        viewPager.setInterval(2000);
        viewPager.startAutoScroll();
        viewPager.setCurrentItem(Integer.MAX_VALUE / 2 - Integer.MAX_VALUE / 2 % ListUtils.getSize(imageIdList));
        indicator.setViewPager(viewPager);

        // the more properties whose you can set
        // // set whether stop auto scroll when touching, default is true
        // viewPager.setStopScrollWhenTouch(false);
        // // set whether automatic cycle when auto scroll reaching the last or first item
        // // default is true
        // viewPager.setCycle(false);
        // /** set auto scroll direction, default is AutoScrollViewPager#RIGHT **/
        // viewPager.setDirection(AutoScrollViewPager.LEFT);
        // // set how to process when sliding at the last or first item
        // // default is AutoScrollViewPager#SLIDE_BORDER_NONE
        // viewPager.setBorderProcessWhenSlide(AutoScrollViewPager.SLIDE_BORDER_CYCLE);
        // viewPager.setScrollDurationFactor(3);
        // viewPager.setBorderAnimation(false);

        innerViewPagerDemo = (Button)findViewById(R.id.auto_scroll_view_pager_inner);
        innerViewPagerDemo.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, AutoScrollViewPagerInnerDemo.class));
            }
        });
    }

  
}

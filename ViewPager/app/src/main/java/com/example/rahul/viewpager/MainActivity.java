package com.example.rahul.viewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

      ViewPager viewPager;
      Integer [] img={R.drawable.img1,R.drawable.image2,R.drawable.img3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Let's Make the application demo for Viewpager
        //Here i Copy 3 images into the Drwable folder.
        //get viewpager id form the xml
        viewPager=(ViewPager)findViewById(R.id.viewpager);

        //Now We have to make custom class for Load Custom xml file
        //Need to impment pager adapter over there

        MYJnextCustomPager mjc=new MYJnextCustomPager();
        //now we set that adapter into the viewpager
        viewPager.setAdapter(mjc);
        //let's run this app
        //Thank you for watching this video
        //In next video we will see auto slide by using thread.
        //Subscribe this channel & ask your question.I will be there soon
        //Let's begin from Yesterday session

        //Here we will see auto slide by using timer

        Timer tm=new Timer();
        //make the scheduler
        //first param:- TImer class object
        //second param:- how much time you want to see
        //third param:-how much time you want to set for dely
        tm.scheduleAtFixedRate(new MyTimer(),5000,2000);

        //Thank you for watching new videos
        //Enjoy programming
        // you can improve your design as i teach in other video
        





    }
    public class MyTimer extends  TimerTask
    {

        @Override
        public void run() {

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    //here i apply logic for every screen when it appear and destroy


                    if(viewPager.getCurrentItem()==0)
                    {
                        viewPager.setCurrentItem(1);
                    }
                    else if(viewPager.getCurrentItem()==1)
                    {
                        viewPager.setCurrentItem(2);
                    }
                    else
                    {
                        viewPager.setCurrentItem(0);
                    }

                }
            });




        }
    }






    public class MYJnextCustomPager extends PagerAdapter
    {

        @Override
        public int getCount() {
            //here we to return how many image you want to slide
            return img.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return  view==object;
        }
        //now we have to override one more method that use for view images that you want to slide


        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            //first we have to load custom xml file
            LayoutInflater lf=(LayoutInflater)MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v=lf.inflate(R.layout.custom_view_pager,null);
            ImageView im=(ImageView)v.findViewById(R.id.imag);
            //set images into the custom xml base on that position
            im.setImageResource(img[position]);
            //now we have to add this view into the viewpager widget
            //get viewpager form container
            ViewPager vp=(ViewPager)container;
            //here we add the view into one page
            vp.addView(v,0);

            return v;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //here we have to code for destroy slide when it goes to next slide

            ViewPager vp=(ViewPager)container;
            //here we get the existing slide object that we convert into the view by using downcasting
            View v=(View)object;
            //remove that view
            vp.removeView(v);



        }
    }





}

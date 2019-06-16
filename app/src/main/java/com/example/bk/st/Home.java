package com.example.bk.st;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {


    ViewFlipper v_flipper;
    private GestureDetector mGestureDetector;


    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_home, container, false);


//        read.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // startActivity(getActivity().getBaseContext(),AboutUs.class);
//                //startActivity(new Intent(getActivity(),AboutUs.class));
//                //swapFragment();
//            }
//        });

        int images[]={R.drawable.st1,R.drawable.st2,R.drawable.st3,};

        v_flipper = v.findViewById(R.id.v_flipper);
        for(int image: images)
            flipperImages(image);
        CustomGestureDetector customGestureDetector = new CustomGestureDetector();
        mGestureDetector = new GestureDetector(getActivity(), customGestureDetector);

        return v;
    }
//    private void swapFragment(){
//        AboutUs aboutUs = new AboutUs();
//        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id., aboutUs);
//        fragmentTransaction.addToBackStack(null);
//        fragmentTransaction.commit();
//    }


    public boolean onTouchEvent(MotionEvent event) {
        mGestureDetector.onTouchEvent(event);

        return getActivity().onTouchEvent(event);
    }
    class CustomGestureDetector extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            // Swipe left (next)
            if (e1.getX() > e2.getX()) {
                v_flipper.showNext();
            }

            // Swipe right (previous)
            if (e1.getX() < e2.getX()) {
                v_flipper.showPrevious();
            }

            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }
    public void flipperImages(int image){
        ImageView imageView= new ImageView(getActivity().getApplicationContext());
        imageView.setBackgroundResource(image);
        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);
        v_flipper.setInAnimation(getActivity().getApplicationContext(),android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(getActivity().getApplicationContext(),android.R.anim.slide_out_right);
    }


}

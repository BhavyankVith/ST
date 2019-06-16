package com.example.bk.st;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Services extends Fragment {



    CardView finish,sw,train,ment;
    public Services() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_services, container, false);


        finish = (CardView)v.findViewById(R.id.finishing);
        sw = (CardView)v.findViewById(R.id.sd);

        train = (CardView)v.findViewById(R.id.training);
        ment = (CardView)v.findViewById(R.id.mentoring);

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(),Finishing_school.class));
            }
        });

        ment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(),Mentoring.class));
            }
        });


        train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(),Training.class));
            }
        });


        sw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),SW_Development.class));
            }
        });


        return v;//inflater.inflate(R.layout.fragment_services, container, false);
    }

}

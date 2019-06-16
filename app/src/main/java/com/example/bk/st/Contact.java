package com.example.bk.st;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.text.style.BackgroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Contact extends Fragment {

    CardView sendm;
    EditText name,mob,msg,email;

    String username,usermob,usermsg,usermail;
    public Contact() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_contact, container, false);
        sendm = (CardView)v.findViewById(R.id.send);

        name = (EditText)v.findViewById(R.id.cname);

        mob = (EditText)v.findViewById(R.id.cmob);

        email = (EditText)v.findViewById(R.id.cmail);

        msg = (EditText)v.findViewById(R.id.cmsg);

        sendm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userMessage(view);
                sendm.setCardBackgroundColor(Color.parseColor("#00bbff"));
                Toast.makeText(getContext(),"Delivered",Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
    public void userMessage(View view)
    {

        username = name.getText().toString();
        usermail = email.getText().toString();
        usermob = mob.getText().toString();
        usermsg = msg.getText().toString();

        String method = "register";

        BackgroundTask backgroundTask = new BackgroundTask(getActivity().getBaseContext());
        backgroundTask.execute("register",username,usermail,usermob,usermsg);
        getActivity().finish();
    }

}

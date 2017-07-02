package com.example.serge.interviewedition.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.serge.interviewedition.R;
import com.example.serge.interviewedition.activities.LoginActivity;
import com.example.serge.interviewedition.activities.RegisterActivity;
import com.example.serge.interviewedition.fragments.listeners.OnFragmentInteractionListener;

/**
 * A fragment with a Google +1 button.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // The request code must be 0 or greater.
    private static final int PLUS_ONE_REQUEST_CODE = 0;
    // The URL to +1.  Must be a valid URL.
    private final String PLUS_ONE_URL = "http://developer.android.com";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button have_account_button;
    private Button dont_have_account_button;

    private Button have_account_button_activity;
    private Button dont_have_account_button_activity;

    private OnFragmentInteractionListener mListener;

    public FirstFragment() {
        // Required empty public constructor
    }



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.first_fragment, container, false);

        have_account_button = (Button) view.findViewById(R.id.have_account);
        dont_have_account_button = (Button) view.findViewById(R.id.dont_have_account);

        have_account_button_activity = (Button) view.findViewById(R.id.have_account_activity);
        dont_have_account_button_activity = (Button) view.findViewById(R.id.dont_have_account_activity);

        TextView textView = (TextView) view.findViewById(R.id.selection_view);
        String page =  mParam1 + mParam2;
        textView.setText(page);

        have_account_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.addToBackStack(null);
                transaction.replace(R.id.fragment_container, SecondFragment.newInstance("Page : ","2"));
                transaction.commit();
            }
        });

        dont_have_account_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.addToBackStack(null);
                transaction.replace(R.id.fragment_container, RegisterFragment.newInstance("Page : ","Register"));
                transaction.commit();
            }
        });

        have_account_button_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity().getApplicationContext(), LoginActivity.class);
                startActivityForResult(intent,PLUS_ONE_REQUEST_CODE);
            }
        });

        dont_have_account_button_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity().getApplicationContext(), RegisterActivity.class);
                startActivityForResult(intent,PLUS_ONE_REQUEST_CODE);
            }
        });
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if(bundle != null)
        {
            mParam1 = bundle.getString(ARG_PARAM1);
            mParam2 = bundle.getString(ARG_PARAM2);
        }

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String msg) {
        if (mListener != null) {
            mListener.onFragmentInteraction(msg);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement com.example.serge.interviewedition.fragments.listeners.OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.have_account : getFragmentManager()
                                        .beginTransaction()
                                            .addToBackStack(null)
                                                .replace(R.id.fragment_container,SecondFragment.newInstance("Page : ","2"))
                                                    .commit();
                break;
            case R.id.dont_have_account : getFragmentManager()
                                            .beginTransaction()
                                                .addToBackStack(null)
                                                    .replace(R.id.fragment_container,SecondFragment.newInstance("Page : ","2"))
                                                        .commit();
                break;
            default:break;
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

}

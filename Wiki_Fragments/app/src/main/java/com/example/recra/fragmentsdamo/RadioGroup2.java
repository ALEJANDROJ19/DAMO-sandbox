package com.example.recra.fragmentsdamo;

import android.content.Context;
import android.os.Bundle;
//import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class RadioGroup2 extends Fragment {
    private static final String ARG_PARAM1 = "item_sel_max";

    // TODO: Rename and change types of parameters
    private int item_sel_max;
    private RadioButton b1, b2, b3, b4, b5;
    private RadioButton[] botons;
    private int acc;

    public RadioGroup2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param max_selected Max RadioButtons selected.
     * @return A new instance of fragment RadioGroup2.
     */
    public static RadioGroup2 newInstance(Integer max_selected) {
        RadioGroup2 fragment = new RadioGroup2();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, max_selected);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //Default value = 1;
            item_sel_max = getArguments().getInt(ARG_PARAM1, 1);
        }

    }

    private void initialize() {
        b1 = (RadioButton) getActivity().findViewById(R.id.boto1);
        b2 = (RadioButton) getActivity().findViewById(R.id.boto2);
        b3 = (RadioButton) getActivity().findViewById(R.id.boto3);
        b4 = (RadioButton) getActivity().findViewById(R.id.boto4);
        b5 = (RadioButton) getActivity().findViewById(R.id.boto5);
        botons = new RadioButton[item_sel_max];
        acc = 0;

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boto_pulsat((RadioButton) view);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boto_pulsat((RadioButton) view);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boto_pulsat((RadioButton) view);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boto_pulsat((RadioButton) view);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boto_pulsat((RadioButton) view);
            }
        });

    }

    private void boto_pulsat(RadioButton boto) {
        if (!isButtonChecked(boto)){
            if (botons[acc] != null)
                botons[acc].setChecked(false);
            addButtonChecked(boto);
        }
    }

    private boolean isButtonChecked(RadioButton boto){
        boolean ret = false;
        for (int i=0; i<botons.length && !ret; i++) {
            ret = boto == botons[i];
        }
        return ret;
    }

    private void addButtonChecked(RadioButton boto) {
        botons[acc] = boto;
        acc = (acc+1)%item_sel_max;
        Log.println(Log.DEBUG,"DB: ",String.valueOf(acc));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_radio_group2, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }




}

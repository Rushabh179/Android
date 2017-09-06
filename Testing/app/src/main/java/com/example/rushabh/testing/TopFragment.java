package com.example.rushabh.testing;

//import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.support.v4.app.Fragment;


/**
 * Created by Rushabh on 26-07-2017.
 */

public class TopFragment extends Fragment {

    private static EditText topTextInput;
    private static EditText bottomTextInput;

    TopListener activityCommander;

    public interface TopListener{
       public void createMeme(String top,String bottom);
    }
//Can be error here//////////////////////////////////////////////////////
@Override
public void onAttach(Context context) {
    try {
        activityCommander = (TopListener)context;
    }catch (ClassCastException e){
        throw new ClassCastException(context.toString());
    }
    super.onAttach(context);
}

//////////////////////////////////////////////////////////////////////////
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.top_fragment,container,false);

        topTextInput = (EditText) view.findViewById(R.id.topTextInput);
        bottomTextInput = (EditText) view.findViewById(R.id.bottomTextInput);

        Button memeButton= (Button) view.findViewById(R.id.memeButton);

    memeButton.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buttonClicked(v);
                }
            }
    );
    return view;
    }
    public void buttonClicked(View view){
        activityCommander.createMeme(topTextInput.getText().toString(),
                bottomTextInput.getText().toString());
    }

}

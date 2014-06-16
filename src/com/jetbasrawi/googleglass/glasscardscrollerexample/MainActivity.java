package com.jetbasrawi.googleglass.glasscardscrollerexample;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.jetbasrawi.googleglass.glasscardscrollerexample.MainActivity;
import com.jetbasrawi.googleglass.glasscardscrollerexample.CardAdapter;
import com.google.android.glass.app.Card;
import com.google.android.glass.widget.CardScrollView;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();
	
	private CardScrollView mCardScroller;
	private CardAdapter mCardAdapter;
	
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        mCardAdapter = new CardAdapter(createCards(this));
        
        mCardScroller = new CardScrollView(this);
        mCardScroller.setAdapter(mCardAdapter);
        
        setContentView(mCardScroller);
    }

   
    private List<Card> createCards(Context context) {
        
        Card card1 = new Card(context);
        card1.setText("First Card");
        
        Card card2 = new Card(context);
        card2.setText("Second Card");
        
        Card card3 = new Card(context);
        card3.setText("Third Card");
        
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        
        return cards;
    }


    @Override
    protected void onResume() {
        super.onResume();
        mCardScroller.activate();
    }

    @Override
    protected void onPause() {
        mCardScroller.deactivate();
        super.onPause();
    }


//	@Override
//	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
//		// TODO Auto-generated method stub
//		
//	}
    
    

    
    
}


package com.yong.calo;

import android.R.bool;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CaloActivity3 extends Activity {
	
	private boolean isTwo;


	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button requestInfo = (Button) findViewById(R.id.button1);
		requestInfo.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				EditText et_cm = (EditText) findViewById(R.id.mycm);
				int in_cm = Integer.parseInt(et_cm.getText().toString());

				EditText et_kg = (EditText) findViewById(R.id.mykg);
				int in_kg = Integer.parseInt(et_kg.getText().toString());

				double in_agekg = (in_cm - 100) * 0.9;
				
				if (in_cm == 0 & in_kg == 0) {
					AlertDialog.Builder alert = new AlertDialog.Builder(
							CaloActivity3.this);
					alert.setTitle("안내");
					alert.setMessage("키와 몸무게를 입력해 주세요.");
					alert.setIcon(R.drawable.iicoo);
					alert.setPositiveButton("확인", null);
					alert.show();
					return;
				
				}
				
				AlertDialog.Builder alert = new AlertDialog.Builder(
						CaloActivity3.this);
				alert.setTitle("평균체중");
				alert.setMessage("키 : " + in_cm + "\n체중 : " + in_kg
						+ "\n평균체중 : " + in_agekg);
				alert.setIcon(R.drawable.iicoo);
				alert.setPositiveButton("확인", null);
				alert.show();
			}
		});
		
		
		Button requestInfo2 = (Button) findViewById(R.id.button2);
		requestInfo2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				EditText et_cm = (EditText) findViewById(R.id.mycm);
				int in_cm = Integer.parseInt(et_cm.getText().toString());

				EditText et_kg = (EditText) findViewById(R.id.mykg);
				int in_kg = Integer.parseInt(et_kg.getText().toString());

				//double in_agekg = (in_cm - 100) * 0.9;
				double in_change_cm = (in_cm/100.0)*(in_cm/100.0);
				
				double in_pig = (double) in_kg / in_change_cm;

				String in_piga1 = null;
				if (in_pig >= 35) {
					String in_piga = "고도비만";
					in_piga1 = in_piga.toString();
				}
				if (in_pig >= 30 & in_pig < 35) {
					String in_piga = "중등도비만";
					in_piga1 = in_piga.toString();
				}
				if (in_pig >= 25 & in_pig < 30) {
					String in_piga = "경도비만";
					in_piga1 = in_piga.toString();
				}
				if (in_pig >= 23 & in_pig < 25) {
					String in_piga = "과체중";
					in_piga1 = in_piga.toString();
				}
				if (in_pig >= 18.5 & in_pig < 23) {
					String in_piga = "정상";
					in_piga1 = in_piga.toString();
				}
				if (in_pig < 18.5) {
					String in_piga = "저체중";
					in_piga1 = in_piga.toString();
				}
				if (in_cm == 0 & in_kg == 0) {
					AlertDialog.Builder alert = new AlertDialog.Builder(
							CaloActivity3.this);
					alert.setTitle("안내");
					alert.setMessage("키와 몸무게를 입력해 주세요.");
					alert.setIcon(R.drawable.iicoo);
					alert.setPositiveButton("확인", null);
					alert.show();
					return;
				
				}
		
				AlertDialog.Builder alert = new AlertDialog.Builder(
						CaloActivity3.this);
				alert.setTitle("BMI지수/체형");
				alert.setMessage("\nBMI지수 : " + String.format("%.2f", in_pig) +  "\n체형: "
						+ in_piga1);
				alert.setIcon(R.drawable.iicoo);
				alert.setPositiveButton("확인", null);
				alert.show();
			}
		});
		Button requestInfo3 = (Button) findViewById(R.id.button3);
		requestInfo3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(CaloActivity3.this,
						CaloActivity32.class);
				startActivity(intent);
			}
		});

		Button requestInfo4 = (Button) findViewById(R.id.button4);
		requestInfo4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(CaloActivity3.this,
						CaloActivity321.class);
				startActivity(intent);
			}
		});
		
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event){
	     switch(keyCode){
	     case KeyEvent.KEYCODE_BACK:
	      String alertTitle = getResources().getString(R.string.app_name);
	      String buttonMessage = getResources().getString(R.string.alert_msg_exit);
	      String buttonYes = getResources().getString(R.string.button_yes);
	      String buttonNo = getResources().getString(R.string.button_no);
	         
	      new AlertDialog.Builder(CaloActivity3.this)
	      .setTitle("종료")
	      .setMessage(buttonMessage)
	      .setPositiveButton(buttonYes, new DialogInterface.OnClickListener() {
	       
	       @Override
	       public void onClick(DialogInterface dialog, int which) {
	        // TODO Auto-generated method stub
	        moveTaskToBack(true);
	        finish();
	       }
	      })
	      .setNegativeButton(buttonNo, null)
	      .show();
	     }
	    return true;
	    }
	   
	}

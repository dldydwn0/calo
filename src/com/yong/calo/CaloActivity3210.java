package com.yong.calo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class CaloActivity3210 extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main4);
		sleeper slep = new sleeper();
		new Thread(slep).start();
		
		
		
	
	}	
	
	class sleeper implements Runnable{

		@Override
		public void run() {
			try {
				Thread.sleep(3000);
				
				Intent intent = new Intent(CaloActivity3210.this, CaloActivity3.class);
				//3210 ��Ƽ��Ƽ���� 3��Ƽ��Ƽ�� �Ѿ�� ����
				startActivity(intent);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}

}

package com.example.flashlght;

import android.os.Bundle;
import android.app.Activity;
import android.hardware.Camera;//changed to hardware
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
Button btn1,btn2;
Camera cameraobj;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn1=(Button)findViewById(R.id.button1);
		cameraobj=Camera.open();
		btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Camera.Parameters cameraparams=cameraobj.getParameters();
				cameraparams.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
				cameraobj.setParameters(cameraparams);
				cameraobj.startPreview();
			}
		});
		btn2=(Button)findViewById(R.id.button2);                       //write this in try catch
		btn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try{Camera.Parameters cameraparams=cameraobj.getParameters();
				cameraparams.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
				
				cameraobj.setParameters(cameraparams);
				cameraobj.startPreview();}catch (Exception e){
					e.printStackTrace();
				}
				//cameraobj.release();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

package de.marcburian.blob_engine_2;
import de.marcburian.tilt.*;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;

/**
 * Created by Marc on 07.08.2015.
 * **/

 public class MainActivity extends Activity {
 private Stage stage;

 @Override
 public void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
 getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
 getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
 setContentView(R.layout.main_layout);
 stage = (Stage)findViewById(R.id.my_visible);

 TextureManager.add(new int[]{R.drawable.slime});
 stage.setScene(new MyScene(stage));
 }

 @Override
 protected void onPause() {
 super.onPause();
 stage.onPause();
 }

 @Override
 protected void onResume() {
 super.onResume();
 stage.onResume();
 }
 }

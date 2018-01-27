package com.zac4j.web;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.view.KeyEvent;
import android.view.View;

public class MainActivity extends Activity implements View.OnClickListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main_advanced);

    updateUi();
  }

  private void updateUi() {
    findViewById(R.id.main_btn_tbs_browser).setOnClickListener(this);
    findViewById(R.id.main_btn_tbs_video).setOnClickListener(this);
    findViewById(R.id.main_btn_file_chooser).setOnClickListener(this);
  }

  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {
    switch (keyCode) {
      case KeyEvent.KEYCODE_BACK:
        this.tbsSuiteExit();
    }
    return super.onKeyDown(keyCode, event);
  }

  private void tbsSuiteExit() {
    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
    dialog.setTitle("X5功能演示");
    dialog.setPositiveButton("OK", new AlertDialog.OnClickListener() {

      @Override
      public void onClick(DialogInterface dialog, int which) {
        Process.killProcess(Process.myPid());
      }
    });
    dialog.setMessage("quit now?");
    dialog.create().show();
  }

  @Override
  public void onClick(View view) {
    Intent intent;
    switch (view.getId()) {
      case R.id.main_btn_file_chooser:
        intent = new Intent(MainActivity.this, FileChooserActivity.class);
        MainActivity.this.startActivity(intent);
        break;
      case R.id.main_btn_tbs_video:
        intent = new Intent(MainActivity.this, FullScreenActivity.class);
        MainActivity.this.startActivity(intent);
        break;
      case R.id.main_btn_tbs_browser:
        intent = new Intent(MainActivity.this, BrowserActivity.class);
        MainActivity.this.startActivity(intent);
    }
  }
}

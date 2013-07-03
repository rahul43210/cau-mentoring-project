package cau.cse.iconlocker;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class MainActivity extends Activity {
	LockView mLockView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// FrameLayout rootLayout =
		// (FrameLayout)findViewById(R.id.rootFrameLayout);
		// rootLayout.addView(new LockView(this));

		mLockView = (LockView) findViewById(R.id.lockView);
		mLockView.setVisibility(LockView.INVISIBLE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN
				|| event.getAction() == MotionEvent.ACTION_UP) {
			switchLockViewVisible();
			mLockView.onTouchEvent(event);
		}

		return true;
	}

	private void switchLockViewVisible() {
		if (mLockView == null)
			return;

		if (mLockView.getVisibility() == LockView.INVISIBLE)
			mLockView.setVisibility(LockView.VISIBLE);
		else
			mLockView.setVisibility(LockView.INVISIBLE);
	}
}
package cau.cse.iconlocker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class LockView extends View {
	Label tempLabel = new Label(new Point(100, 100), 200, 200);
	boolean isTouch = false;
	Point offset = new Point();

	public LockView(Context context) {
		super(context);
		// Write code
	}

	public LockView(Context context, AttributeSet attr) {
		super(context, attr);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// Write code
		tempLabel.draw(canvas);
		super.onDraw(canvas);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (!isTouch) {
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				if (tempLabel.getRect().contains((int) event.getX(),
						(int) event.getY())) {
					isTouch = true;
					offset.set((int) event.getX() - tempLabel.getLocation().x,
							(int) event.getY() - tempLabel.getLocation().y);
					Log.d("LOCKVIEW", "TOUCH!!!");
				} else
					isTouch = false;
			}
		} else {
			if (event.getAction() == MotionEvent.ACTION_MOVE) {
				Point labelLocation = tempLabel.getLocation();
				int x = (int) event.getX();
				int y = (int) event.getY();
				tempLabel.setLocation(x - offset.x, y - offset.y);
				invalidate();
				Log.d("LOCKVIEW", "MOVE!!!");
				Log.d("LOCKVIEW", "x: " + tempLabel.getLocation().x + ", y:"
						+ tempLabel.getLocation().y);
			}

			if (event.getAction() == MotionEvent.ACTION_UP) {
				isTouch = false;
				Log.d("LOCKVIEW", "UP!!!");
			}
		}

		return true;
	}
}
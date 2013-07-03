package cau.cse.iconlocker;

import android.graphics.*;

public class Label {
	Bitmap mImage = null;
	Rect mImageRect = null;
	Paint mPaint = new Paint();
	Point mLocation = new Point(0, 0);
	Point mSize = new Point(0, 0);
	Rect mLabelRect = new Rect(0, 0, 100, 100);

	public Label(Point leftTop, int width, int height) {
		mLocation.set(leftTop.x, leftTop.y);
		mSize.x = width;
		mSize.y = height;
		setLabelRect();
		mPaint.setARGB(255, 0, 0, 0);
	}

	public void setImage(Bitmap bitmap) {
		mImage = bitmap;
		mImageRect = new Rect(0, 0, mImage.getWidth(), mImage.getHeight());
	}

	public void draw(Canvas canvas) {
		if (mImage != null)
			canvas.drawBitmap(mImage, mImageRect, mLabelRect, mPaint);
		else
			canvas.drawRect(mLabelRect, mPaint);
	}

	public Point getLocation() {
		return mLocation;
	}

	public void setLocation(int x, int y) {
		mLocation.set(x, y);
		setLabelRect();
	}

	public Point getSize() {
		return mSize;
	}

	public void setSize(int width, int height) {
		mSize.set(width, height);
		setLabelRect();
	}
	
	public Rect getRect(){
		return mLabelRect;
	}

	private void setLabelRect() {
		mLabelRect.set(mLocation.x, mLocation.y, mLocation.x + mSize.x,
				mLocation.y + mSize.y);
	}
}
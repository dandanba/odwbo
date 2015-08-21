package wei.mark.example;

import wei.mark.standout.StandOutWindow;
import wei.mark.standout.constants.StandOutFlags;
import wei.mark.standout.ui.Window;
import android.content.Intent;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

public class SimpleWindow extends StandOutWindow {
	@Override
	public String getAppName() {
		return "odwbo";
	}

	@Override
	public String getPersistentNotificationTitle(int id) {
		return getAppName() + "运行中...";
	}

	@Override
	public int getAppIcon() {
		return R.drawable.odwbo_icon;
	}

	@Override
	public void createAndAttachView(int id, FrameLayout frame) {
		// create a new layout from body.xml
		LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.simple, frame, true);
	}

	// the window will be centered
	@Override
	public StandOutLayoutParams getParams(int id, Window window) {// for samsung t900
		return new StandOutLayoutParams(id, 1600, 325, StandOutLayoutParams.CENTER, 2560 - 325 - 50);
	}

	// move the window by dragging the view
	@Override
	public int getFlags(int id) {
		return super.getFlags(id) | StandOutFlags.FLAG_BODY_MOVE_ENABLE | StandOutFlags.FLAG_ADD_FUNCTIONALITY_ALL_DISABLE;
	}

	@Override
	public String getPersistentNotificationMessage(int id) {
		return "点击关闭";
	}

	@Override
	public Intent getPersistentNotificationIntent(int id) {
		return StandOutWindow.getCloseIntent(this, SimpleWindow.class, id);
	}
}

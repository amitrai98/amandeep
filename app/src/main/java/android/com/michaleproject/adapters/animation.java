package android.com.michaleproject.adapters;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by amitrai on 25/3/16.
 */
public class animation extends Animation {

    int initialHeight;
    int actualHeight;
    public animation()
    {

    }
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        int newHeight;

        newHeight = (int)(initialHeight * interpolatedTime);

//        ril1.removeAllViews();
//        btn.setWidth(100);
//        btn.setHeight(300);
//        btn.setText("as");
//        ril1.addView(btn);
//        ril1.getLayoutParams().height = newHeight;
//        ril1.requestLayout();

    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        initialHeight = actualHeight;

    }

    @Override
    public boolean willChangeBounds() {
        return true;
    }
};
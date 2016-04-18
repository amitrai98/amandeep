package android.com.michaleproject.aman;

import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by amitrai on 12/4/16.
 */
public class MyGestureListener implements GestureDetector.OnGestureListener {

    private MyListView mMyListView; //f11123a  //a


    public MyGestureListener(MyListView ourbestlistview)
    {
        super();
        mMyListView = ourbestlistview;

    }

//    MyGestureListener(MyListView ourbestlistview, MyListView _pcls1)
//    {
//        this(ourbestlistview);
//    }

    public boolean onDown(MotionEvent motionevent)
    {
        if (MyListView.b(mMyListView))
        {
            MyListView.init(mMyListView, false);
        }

        return true;
    }

    class MyRun implements Runnable {
        final /* synthetic */ MyGestureListener f11122a;

        MyRun(MyGestureListener myGesture) {
            this.f11122a = myGesture;
        }

        public void run() {
            this.f11122a.mMyListView.smoothScrollToPositionFromTop(this.f11122a.mMyListView.position, 0, 200);
        }
    }




//    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f1, float f2)
//    {
//        int j;
//        int k;
//        j = 0;
//        if (MyListView.c(mMyListView) || MyListView.b(mMyListView))
//        {
//            return false;
//        }
//        MyListView.init(mMyListView, true);
//        f1 = (float)Math.abs(mMyListView.getChildAt(0).getTop()) / (float)MyListView.d(mMyListView);
//        k = mMyListView.getFirstVisiblePosition();
////        if (f2 >= 0.0F) goto _L2; else goto _L1
////        _L1:
//        int i;
//        if (f1 > 0.9F)
//        {
//            i = k + 2;
//        } else
//        {
//            i = k + 1;
//        }
//        _L4:
//        if (i < 0)
//        {
//            i = j;
//        }
//        j = i;
//        if (i >= mMyListView.getAdapter().getCount() - 1)
//        {
//            j = mMyListView.getAdapter().getCount() - 2;
//        }
//        MyListView.init(mMyListView, j);
//        mMyListView.post(new Runnable() {
//
//            final MyGestureListener a;
//
//            public void run()
//            {
//                a.mMyListView.smoothScrollToPositionFromTop(MyListView.init(a.mMyListView), 0, 200);
//            }
//
//
////            (MyGestureListener f1)
////            {
////                a = f1;
////                super();
////            }
//
//            {
//                a = MyGestureListener.this;
////                super();
//            }
//        });
//        return true;
////        _L2:
////        i = k;
////        if (f1 < 0.1F)
////        {
////            i = k - 1;
////        }
////        if (true) goto _L4; else goto _L3
////        _L3:
//    }


    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i = 0;
//        if (this.mMyListView.k || this.mMyListView.j) {   // fll047 k    // fll048k    j
//            return false;
//        }

//        if (MyListView.c(mMyListView) || MyListView.b(mMyListView))
//        {
//            return false;
//        }
        MyListView.init(mMyListView, true);
        this.mMyListView.j = true;
        float abs = ((float) Math.abs(this.mMyListView.getChildAt(0).getTop())) / ((float) this.mMyListView.getMinimizedHeight());
        int firstVisiblePosition = this.mMyListView.getFirstVisiblePosition();
        if (f2 < 0.0f) {
            if (abs > 0.9f) {
                firstVisiblePosition += 2;
            } else {
                firstVisiblePosition++;
            }
        } else if (abs < 0.1f) {
            firstVisiblePosition--;
        }
        if (firstVisiblePosition >= 0) {
            i = firstVisiblePosition;
        }
        if (i >= this.mMyListView.getAdapter().getCount() - 1) {
            i = this.mMyListView.getAdapter().getCount() - 2;
        }
        this.mMyListView.position = i;
        this.mMyListView.post(new MyRun(this));
        return true;
    }

    public void onLongPress(MotionEvent motionevent)
    {
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f1, float f2)
    {
        return false;
    }

    public void onShowPress(MotionEvent motionevent)
    {
    }

    public boolean onSingleTapUp(MotionEvent motionevent)
    {
        return false;
    }

}
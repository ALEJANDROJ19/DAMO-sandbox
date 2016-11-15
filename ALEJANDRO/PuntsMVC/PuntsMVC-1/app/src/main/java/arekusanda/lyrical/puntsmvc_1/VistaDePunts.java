package arekusanda.lyrical.puntsmvc_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


public class VistaDePunts extends View implements ConjuntDePunts.ConjuntDePuntsListener{

    private ConjuntDePunts punts;
    private Paint paint;


    public VistaDePunts(Context context) {
        super(context);
        paint = new Paint();
    }

    public VistaDePunts(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
    }

    public VistaDePunts(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
    }

    public void defineixModel(ConjuntDePunts model){
        this.punts = model;
        punts.enregistrarObservador(this);
    }

    @Override
    public void onCanviConjuntdePunts() {
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);
        if(null == punts) return;
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(hasFocus() ? Color.BLUE : Color.GRAY);
        paint.setStyle(Paint.Style.FILL);

        for (Punt dot : punts.getPunts()){
            paint.setColor(dot.getColor());
            canvas.drawCircle(
                    (float) dot.getCoordX(),
                    (float) dot.getCoordY(),
                    (float) dot.getMida(),
                    paint
            );
        }



    }
}

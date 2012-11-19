package fr.dubois.space.invader;



import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


import android.app.Activity;



import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;





public class SpaceInvaderView extends View {
	
	Alien alien;
	// Dimensions souhaitées
	private static final int TARGET_HEIGHT = 800;
	private static final int TARGET_WIDTH = 600;

	private Paint paint; // Style pour le texte	
	private String text; // texte à afficher
	
	// Modifier par Mathieu DOUHET
		private static final int ENNEMI_BLUE = 1;
		private static final int ENNEMI_RED = 2; 
		private static final int VAISSEAU = 3;
		private static final int MISSILE_VAI = 4;
		private static final int MISSILE_ENN = 5;
		


	public SpaceInvaderView(Context context) {
		super(context);
		init();
	}

	public SpaceInvaderView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public SpaceInvaderView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}


	

	void init(){
		paint = new Paint();
		paint.setStyle(Style.STROKE);
		paint.setColor(Color.YELLOW);
		paint.setTypeface(Typeface.SANS_SERIF);
		paint.setTextSize(36);
		paint.setTextAlign(Paint.Align.CENTER);
		text = "Texte";

		Bitmap alienbitmap = loadImage(R.drawable.enemibleu);
		this.alien= new Alien(alienbitmap,0,0);
	}



	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawRGB(0, 0, 0);
		canvas.drawRect(0, 0, TARGET_WIDTH-1, TARGET_HEIGHT-1, paint);
		if (text != null){
			canvas.drawText(text, canvas.getWidth()/2,canvas.getHeight()/2, paint);
		}
	}


	private int computeSize(int spec,int def){
		int mode = View.MeasureSpec.getMode(spec);
		if (mode == View.MeasureSpec.UNSPECIFIED) return def;
		int size = View.MeasureSpec.getSize(spec);
		if (mode == View.MeasureSpec.EXACTLY) {
			return size;
		}
		//		MeasureSpec.AT_MOST
		if (size < def ) return size;
		return def;
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int x = computeSize(widthMeasureSpec,TARGET_WIDTH);
		int y = computeSize(heightMeasureSpec,TARGET_HEIGHT);
		this.setMeasuredDimension(x,y);
	}
	

	// Modifier par Mathieu DOUHET 
	
	public Bitmap loadImage(int key){
		Drawable image;
		int x,y;
		Bitmap bitmap;
		
		Resources r = this.getContext().getResources();
		image=r.getDrawable(key);
		x=image.getIntrinsicWidth();
	    y=image.getIntrinsicHeight();
	    bitmap = Bitmap.createBitmap(x,y,null);
	    Canvas canvas = new Canvas(bitmap);
	    image.setBounds(0,0,x,y);
        image.draw(canvas);
	    return bitmap;
			
		
	}

	private void resetImage(int i) {
		// TODO Auto-generated method stub
		
	}
}

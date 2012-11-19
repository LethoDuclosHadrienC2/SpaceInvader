package fr.dubois.space.invader;

import android.graphics.Bitmap;

public abstract class Alien extends Sprite {

	
	public Alien(Bitmap bitmap, float x, float y) {
		super(bitmap, x, y);
		// TODO Auto-generated constructor stub
	}

	public abstract void act();
}
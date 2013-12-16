package com.game.bugattong.model;

public class SearchObject {
	private int imageResource = 0;
	private float translationX = 0f;
	private float translationY = 0f;

	public SearchObject() {
	}

	public SearchObject(float translationX, float translationY) {
		super();
		this.translationX = translationX;
		this.translationY = translationY;
	}

	public SearchObject(int imageResource, float translationX,
			float translationY) {
		super();
		this.imageResource = imageResource;
		this.translationX = translationX;
		this.translationY = translationY;
	}

	public int getImageResource() {
		return imageResource;
	}

	public void setImageResource(int imageResource) {
		this.imageResource = imageResource;
	}

	public float getTranslationX() {
		return translationX;
	}

	public void setTranslationX(float translationX) {
		this.translationX = translationX;
	}

	public float getTranslationY() {
		return translationY;
	}

	public void setTranslationY(float translationY) {
		this.translationY = translationY;
	}

}

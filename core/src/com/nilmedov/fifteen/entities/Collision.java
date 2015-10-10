package com.nilmedov.fifteen.entities;

/**
 * Created by Nazar on 10.10.2015.
 */
public class Collision {
	private boolean right = false;
	private boolean left = false;
	private boolean top = false;
	private boolean bottom = false;

	public Collision() {
	}

	public boolean isRight() {
		return this.right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isLeft() {
		return this.left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isTop() {
		return this.top;
	}

	public void setTop(boolean top) {
		this.top = top;
	}

	public boolean isBottom() {
		return this.bottom;
	}

	public void setBottom(boolean bottom) {
		this.bottom = bottom;
	}
}

package com.game.bugattong.model;

public class LevelQuestion {
	private String question = "";
	private String answer = "";
	private boolean special = false;
	private String hintOrder;

	public LevelQuestion() {

	}

	public LevelQuestion(String question, String answer, String hintOrder) {
		this.question = question;
		this.answer = answer;
		this.hintOrder = hintOrder;
	}

	public LevelQuestion(String question, String answer, String hintOrder,
			boolean special) {
		this.question = question;
		this.answer = answer;
		this.special = special;
		this.hintOrder = hintOrder;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public boolean isSpecial() {
		return special;
	}

	public void setSpecial(boolean special) {
		this.special = special;
	}

	public String getHintOrder() {
		return hintOrder;
	}

	public void setHintOrder(String hintOrder) {
		this.hintOrder = hintOrder;
	}

}

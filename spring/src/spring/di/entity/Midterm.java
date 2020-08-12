package spring.di.entity;

public class Midterm implements Exam {

	private int kor, eng, math, com;

	@Override
	public int total() {
		return kor + eng + math + com;
	}

	@Override
	public float avg() {
		return total() / 4.0f;
	}

}
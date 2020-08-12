package spring.di.ui;

import spring.di.entity.Exam;

public class InlineExamConsole implements ExamConsole {

	private Exam exam;

	public InlineExamConsole(Exam exam) {
		this.exam = exam;
	}

	@Override
	public void print() {
		System.out.printf("Total is %d, Avg is %f\n", exam.total(), exam.avg());
	}

}
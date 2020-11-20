package grade;

public class GradeServiceImpl implements GradeService{
	private GradeDTO[] grades;
	private int count;
	
	public GradeServiceImpl() {
		grades = new GradeDTO[3];
		count = 0;

	}
	@Override
	public void addGrade(GradeDTO grade) {
		int sum = sum(grade);
		float avg = avg(sum);
		grade.setSum(sum);
		grade.setAvg(avg);
		grades[count] = grade;
		count++;
	}

	@Override
	public void updateGrade(GradeDTO grade) {
		for(int i = 0; i < count; i++) {
			if(grade.getName().equals(grades[i].getName())){
				grades[i].setKor(grade.getKor());
				grades[i].setEng(grade.getEng());
				grades[i].setMath(grade.getMath());
				break;
			}
		}
	}

	@Override
	public void deleteGrade(GradeDTO grade) {
		for(int i = 0; i < count; i++) {
			if(grade.getName().equals(grades[i].getName())) {
				grades[i] = grades[count-1];
				grades[count-1] = null;
				count--;
				break;
			}
		}
	}

	@Override
	public int sum(GradeDTO grade) {
		return grade.getKor() + grade.getEng() + grade.getMath();
	}

	@Override
	public float avg(int sum) {
		return (float)sum / 3;
	}

	@Override
	public GradeDTO[] gradeSort() {
		GradeDTO[] sort = new GradeDTO[3];
		if(grades[0].getAvg() > grades[1].getAvg() &&
				grades[0].getAvg() > grades[2].getAvg()) {
			if(grades[1].getAvg() > grades[2].getAvg()) {
				sort[0] = grades[0];
				sort[1] = grades[1];
				sort[2] = grades[2];
			}else {
				sort[0] = grades[0];
				sort[1] = grades[2];
				sort[2] = grades[1];
			}
		}
		if(grades[1].getAvg() > grades[0].getAvg() &&
				grades[1].getAvg() > grades[2].getAvg()) {
			if(grades[0].getAvg() > grades[2].getAvg()) {
				sort[0] = grades[1];
				sort[1] = grades[0];
				sort[2] = grades[2];
			}else {
				sort[0] = grades[1];
				sort[1] = grades[2];
				sort[2] = grades[0];
			}
		}
		if(grades[2].getAvg() > grades[1].getAvg() &&
				grades[2].getAvg() > grades[0].getAvg()) {
			if(grades[1].getAvg() > grades[0].getAvg()) {
				sort[0] = grades[2];
				sort[1] = grades[1];
				sort[2] = grades[0];
			}else {
				sort[0] = grades[2];
				sort[1] = grades[0];
				sort[2] = grades[1];
			}
		}
		return sort;
	}
	@Override
	public int count() {
		return count;
	}

}











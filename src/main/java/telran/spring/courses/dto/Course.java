package telran.spring.courses.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Course  implements Serializable {
	@Min(value=1)
	@Max(value=999999)
	public long id;
	@NotNull
	@NotEmpty
	public String courseName;
	@NotNull
	@NotEmpty
	public String lecturer;
	@Min(value=800)
	@Max(value=15000)
	public int cost;
	@Min(value=60)
	@Max(value=700)
	public int hours;
	@NotNull
	public Date openingDate;
	
	public Course() {
	}

	public Course(int id, String courseName, String lecturer, int cost,
			int hours, Date openingDate) {
		this.id = id;
		this.courseName = courseName;
		this.lecturer = lecturer;
		this.cost = cost;
		this.hours = hours;
		this.openingDate = openingDate;
	}
	
	public Course(Course course) {
		this.id = course.id;
		this.courseName = course.courseName;
		this.lecturer = course.lecturer;
		this.cost = course.cost;
		this.hours = course.hours;
		this.openingDate = course.openingDate;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Course other = (Course) obj;
		if (id != other.id) {
			return false;
		}
		if(!courseName.equals(other.courseName) || !lecturer.equals(other.lecturer)) {
			return false;
		}
		return true;
	}
}

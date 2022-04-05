package telran.spring.courses.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

import telran.spring.calculator.exceptions.BadRequestException;
import telran.spring.courses.dto.Course;
import telran.spring.courses.exceptions.ResourceNotFoundException;

@Service
public class CoursesServiceImpl implements CoursesService {

	Map<Long, Course> courses = new HashMap<>();
	/*
	@Override
	public Course addCourse(Course course) {
		if(courses.containsKey(course.id)) {
			throw new ResourceNotFoundException(String.format(
					"course id=%d already exists. Request is rejected", course.id));
		}
		courses.put(course.id, course);
		return course;
	}
	*/
	@Override
	public Course addCourse(Course course) {
		course.id = generateId(course.id);
		courses.put(course.id, course);
		return course;
	}
	

	@Override
	public List<Course> getCourses() {
		if(courses.size() == 0) {
			throw new ResourceNotFoundException(
					"The list of courses is empty");
		}
		return new ArrayList<>(courses.values());
	}

	@Override
	public Course getCourse(long id) {
		if(!courses.containsKey(id)) {
			throw new ResourceNotFoundException(String.format(
					"course id=%d isn't found", id));
		}
		return courses.get(id);
	}
	private long generateId(long existingId) {
		if (!courses.containsKey(existingId)) {
			return existingId;
		}
		while (true) {
			long id = new Random().nextLong(1, 999999);
			if (!courses.containsKey(id)) {
				return id;
			}
		}
	}

}

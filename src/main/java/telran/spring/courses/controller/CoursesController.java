package telran.spring.courses.controller;


import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import telran.spring.calculator.service.Calculator;
import telran.spring.courses.CoursesWebAppl;
import telran.spring.courses.dto.Course;
import telran.spring.courses.service.CoursesService;
import telran.spring.courses.service.CoursesServiceImpl;

@RestController
@RequestMapping("/courses")
@Validated
public class CoursesController {
	static Logger LOG = LoggerFactory.getLogger(CoursesWebAppl.class);
//	CoursesService service = new CoursesServiceImpl();
	CoursesService service;
	@Autowired
	public CoursesController() {
		service = new CoursesServiceImpl();
	}
	
	@PostMapping
	Course addCourse(@RequestBody @Valid Course course) {
		LOG.debug("add() operation. courseId="+course.id);
		return service.addCourse(course);
	}
	@GetMapping("/list")
	List<Course> getCourses() {
		LOG.debug("getCourses() operation.");
		return service.getCourses();
	}
	@GetMapping("/course")
	Course getCourse( @RequestParam(name="id") @Min(value=1) @Max(value=999999) long id) {
		LOG.debug("getCourse() operation. id="+id);
		return service.getCourse(id);
	}
	
}

package gr.aueb.cf.teachersapp.service;

import java.sql.SQLException;
import java.util.List;
import gr.aueb.cf.teachersapp.dao.ICourseDAO;
import gr.aueb.cf.teachersapp.dto.CourseDTO;
import gr.aueb.cf.teachersapp.model.Course;
import gr.aueb.cf.teachersapp.service.exceptions.CourseNotFoundException;

public class CourseServiceImpl implements ICourseService {

	private final ICourseDAO courseDAO;

	public CourseServiceImpl(ICourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	@Override
	public void insertCourse(CourseDTO courseDTO) throws SQLException {
		Course course = new Course();
		course.setDescription(courseDTO.getDescription());
		course.setTeacherId(courseDTO.getTeacherId());

		try {

			courseDAO.insert(course);

		} catch (SQLException e) {

			throw e;
		}

	}

	@Override
	public void updateCourse(CourseDTO oldCourseDTO, CourseDTO newCourseDTO)
			throws SQLException, CourseNotFoundException {

		Course courseToUpdate = new Course();
		// courseToUpdate.setDescription(oldCourseDTO.getDescription());
		courseToUpdate.setId(oldCourseDTO.getId());

		Course newCourse = new Course();
		newCourse.setDescription(newCourseDTO.getDescription());
		newCourse.setTeacherId(newCourseDTO.getTeacherId());

		try {
			if (courseDAO.getCourse(courseToUpdate.getDescription()) != null) {
				courseToUpdate.setId(courseDAO.getCourse(courseToUpdate.getDescription()).getId());
				courseDAO.update(courseToUpdate, newCourse);
			} else {
				throw new CourseNotFoundException(courseToUpdate);
			}
		} catch (SQLException | CourseNotFoundException e) {

			throw e;
		}
	}

	@Override
	public void deleteCourse(CourseDTO courseDTO) throws SQLException, CourseNotFoundException {

		Course courseToDelete = new Course();
		courseToDelete.setId(courseDTO.getId());

		try {
			/*
			 * if (courseDAO.getCourse(courseToDelete.getDescription()) != null ) {
			 * 
			 * courseToDelete.setId(courseDAO.getCourse(courseToDelete.getDescription()).
			 * getId());
			 */
			courseDAO.delete(courseToDelete);

			/*
			 * } else {
			 * 
			 * throw new CourseNotFoundException(courseToDelete);
			 * 
			 * }
			 */

		} catch (SQLException /* | CourseNotFoundException */ e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public Course GetCourse(String description) throws SQLException {
		try {

			return courseDAO.getCourse(description);

		} catch (SQLException e) {

			throw e;
		}
	}

	@Override
	public List<Course> GetAllCourses() throws SQLException {

		try {

			return courseDAO.getAll();

		} catch (SQLException e) {

			throw e;
		}
	}

}
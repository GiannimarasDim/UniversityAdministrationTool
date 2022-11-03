package gr.aueb.cf.teachersapp.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import gr.aueb.cf.teachersapp.dao.ITeacherDAO;
import gr.aueb.cf.teachersapp.model.Teacher;

@Path("teachers")
public class TeacherJaxRestController {
	
	/*
	 * @Inject private ITeacherDAO teacherDAOImpl;
	 */
	
	@Path("/ping")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response ping() {
		Teacher teacher = null;;
		//return "Hello Coding Factory";
		return Response.ok().entity(teacher).build();
	}
}

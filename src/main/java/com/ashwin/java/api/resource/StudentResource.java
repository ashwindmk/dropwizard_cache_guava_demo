package com.ashwin.java.api.resource;

import com.ashwin.java.domain.model.Student;
import com.ashwin.java.domain.service.StudentService;
import com.codahale.metrics.annotation.Timed;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/student")
public class StudentResource {
    private StudentService studentService;

    @Inject
    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    public Response getById(@PathParam("id") Long id) {
        return Response.ok(this.studentService.getById(id)).build();
    }
}

package co.mesquita.linketinder

import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/register")
class HelloResources extends HttpServlet {

    @POST
    @Path("/{name}")
    @Produces("text/plain")
    public String customWelcome(@PathParam("name") String name) {
        return "Welcome " + name + "!";
    }
}

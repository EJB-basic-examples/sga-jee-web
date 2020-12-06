package com.lagm.sga.web;

import com.lagm.sga.domain.Persona;
import com.lagm.sga.servicio.PersonaService;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/personas")
public class PersonaServlet extends HttpServlet {
    // @WebServlet: para convertir a la clase en un Servlet
    
    @Inject // @Inject: Para inyectar el EJB local. Es parte de la API CDI (Context Dependency Injection)
    PersonaService personaService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Persona> personas = personaService.listarPersonas();
        System.out.println(personas);
        
        // Poner la lista de personas en algún alcance: en request
        request.setAttribute("personas", personas);
        
        /* Hacemos un requestDispatcher para redirigir hacia el JSP que va a desplegar el listado de personas*/
        request.getRequestDispatcher("/listadoPersonas.jsp").forward(request, response);
    }
}

package com.lagm.sga.servicio;

import com.lagm.sga.domain.Persona;
import java.util.List;
import javax.ejb.Local;

@Local
public interface PersonaService {
    // @Local: para que podamos acceder a esta infertaz de manera local

    public List<Persona> listarPersonas();

    public Persona encontrarPersonaPorId(Persona persona);

    public Persona encontrarPersonaPorEmail(Persona persona);

    public void registrarPersona(Persona persona);

    public void modificarPersona(Persona persona);

    public void eliminarPersona(Persona persona);
}

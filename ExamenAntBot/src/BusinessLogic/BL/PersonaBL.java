package BusinessLogic.BL;

import java.util.List;

import DataAccess.DAO.PersonaDAO;

import DataAccess.DTO.PersonaDTO;

public class PersonaBL {
    private PersonaDTO Persona;
    private PersonaDAO pDAO = new PersonaDAO();
    
    public PersonaBL() {}

    public List<PersonaDTO> getAll() throws Exception{
        return pDAO.readAll();
    }

    public PersonaDTO getBy(int IdPersona)throws Exception{
       Persona = pDAO.readBy(IdPersona);
        return Persona;
    }
     public boolean add(String Nombre) throws Exception{
       Persona= new PersonaDTO();
       Persona.setNombre(Nombre);
        return pDAO.create(Persona);
     }
     public boolean update(int idPersona,String Nombre) throws Exception{
       Persona = new PersonaDTO();
       Persona.setIdPersona(idPersona);
       Persona.setNombre(Nombre);
        return pDAO.update(Persona);
     }
     public boolean delete(int idPersona)throws Exception{
        return pDAO.delete(idPersona);
     }
}
    


package BusinessLogic.BL;

import java.util.List;

import DataAccess.DAO.PersonaTipoDAO;

import DataAccess.DTO.PersonaTipoDTO;

public class PersonaTipoBL {
    private PersonaTipoDTO PersonaTipo;
    private PersonaTipoDAO ptDAO = new PersonaTipoDAO();
    
    public PersonaTipoBL() {}

    public List<PersonaTipoDTO> getAll() throws Exception{
        return ptDAO.readAll();
    }

    public PersonaTipoDTO getBy(int IdPersonaTipo)throws Exception{
       PersonaTipo = ptDAO.readBy(IdPersonaTipo);
        return PersonaTipo;
    }
     public boolean add(String Nombre) throws Exception{
       PersonaTipo= new PersonaTipoDTO();
       PersonaTipo.setNombre(Nombre);
        return ptDAO.create(PersonaTipo);
     }
     public boolean update(int idPersonaTipo,String Nombre) throws Exception{
       PersonaTipo = new PersonaTipoDTO();
       PersonaTipo.setIdPersonaTipo(idPersonaTipo);
       PersonaTipo.setNombre(Nombre);
        return ptDAO.update(PersonaTipo);
     }
     public boolean delete(int idPersonaTipo)throws Exception{
        return ptDAO.delete(idPersonaTipo);
     }
}
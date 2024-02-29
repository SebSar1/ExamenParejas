package BusinessLogic.BL;

import java.util.List;

import DataAccess.DAO.saHormigaComidaDAO;

import DataAccess.DTO.saHormigaComidaDTO;

public class saHormigaComidaBL {
    private saHormigaComidaDTO HormigaComida;
    private saHormigaComidaDAO pDAO = new saHormigaComidaDAO();
    
    public saHormigaComidaBL() {}

    public List<saHormigaComidaDTO> getAll() throws Exception{
        return pDAO.readAll();
    }

    public saHormigaComidaDTO getBy(int IdHormigaComida)throws Exception{
       HormigaComida = pDAO.readBy(IdHormigaComida);
        return HormigaComida;
    }

     public boolean update(int idHormiga,String HormigaTipo,String Codigo) throws Exception{
       HormigaComida = new saHormigaComidaDTO();
       HormigaComida.setSaIdHormiga(idHormiga);
       HormigaComida.setSaHormigaTipo(HormigaTipo);
       HormigaComida.setSaCodigoHormiga(Codigo);
        return pDAO.update(HormigaComida);
     }
     public boolean delete(int idHormigaComida)throws Exception{
        return pDAO.delete(idHormigaComida);
     }
}
    


package BusinessLogic.BL;

import java.util.ArrayList;
import java.util.List;

import DataAccess.DAO.saHormigaComidaDAO;

import DataAccess.DTO.saHormigaComidaDTO;

public class saHormigaComidaBL {
    private saHormigaComidaDTO HormigaComida;
    private static saHormigaComidaDAO pDAO = new saHormigaComidaDAO();

    public saHormigaComidaBL() {
    }

    public static ArrayList<saHormigaComidaDTO> getAll() throws Exception {
        return pDAO.readAll();
    }

    public saHormigaComidaDTO getBy(int IdHormigaComida) throws Exception {
        HormigaComida = pDAO.readBy(IdHormigaComida);
        return HormigaComida;
    }

    public boolean update(int idHormiga, String HormigaTipo, String comio) throws Exception {
        HormigaComida = new saHormigaComidaDTO();
        HormigaComida.setSaIdHormiga(idHormiga);
        HormigaComida.setSaHormigaTipo(HormigaTipo);
        HormigaComida.setSaComio(comio);
        return pDAO.update(HormigaComida);
    }

    public boolean delete(int idHormigaComida) throws Exception {
        return pDAO.delete(idHormigaComida);
    }
}

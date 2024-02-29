package BusinessLogic.BL;

import java.util.ArrayList;
import java.util.List;

import DataAccess.DAO.HormigaTipoDAO;

import DataAccess.DTO.HormigaTipoDTO;

public class HormigaTipoBL {
   private HormigaTipoDTO HormigaTipo;
   private static HormigaTipoDAO htDAO = new HormigaTipoDAO();

   public HormigaTipoBL() {
   }

   public static ArrayList<HormigaTipoDTO> getAll() throws Exception {
      return htDAO.readAll();
   }

   public HormigaTipoDTO getBy(int IdHormigaTipo) throws Exception {
      HormigaTipo = htDAO.readBy(IdHormigaTipo);
      return HormigaTipo;
   }

   public boolean add(String Nombre) throws Exception {
      HormigaTipo = new HormigaTipoDTO();
      HormigaTipo.setNombre(Nombre);
      return htDAO.create(HormigaTipo);
   }

   public boolean update(int idHormigaTipo, String Nombre) throws Exception {
      HormigaTipo = new HormigaTipoDTO();
      HormigaTipo.setIdHormigaTipo(idHormigaTipo);
      HormigaTipo.setNombre(Nombre);
      return htDAO.update(HormigaTipo);
   }

   public boolean delete(int idHormigaTipo) throws Exception {
      return htDAO.delete(idHormigaTipo);
   }
}

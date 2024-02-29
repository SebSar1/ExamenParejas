package BusinessLogic.BL;

import java.util.ArrayList;
import java.util.ArrayList;

import DataAccess.DAO.HormigaDAO;

import DataAccess.DTO.HormigaDTO;
import DataAccess.DTO.UsuarioSistemaDTO;
import DataAccess.DTO.HormigaDTO;

public class HormigaBL {
   private static HormigaDTO Hormiga;
   private static HormigaDAO hDAO = new HormigaDAO();

   public HormigaBL() {
   }

   public static ArrayList<HormigaDTO> getAll() throws Exception {
      return hDAO.readAll();
   }

   public static HormigaDTO getHormigaRol(Integer idHormiga) throws Exception {
      return hDAO.obtenerHormigaRol(idHormiga);
   }

   public static HormigaDTO getBy(int IdHormiga) throws Exception {
      Hormiga = hDAO.readBy(IdHormiga);
      return Hormiga;
   }

   public static boolean codigoExiste(String codigo) throws Exception {

      // Obtener la lista de códigos existentes
      for (String hormiga : hDAO.obtenerCodigo()) {

         System.out.println(hormiga);
         if (hormiga.equals(codigo)) {
            return false; // El código ya existe, retorna false
         }
      }
      return true; // El código no existe, retorna true
   }

   public static boolean idHormigaExiste(String idHormiga) throws Exception {

      // Obtener la lista de códigos existentes
      for (String hormiga : hDAO.obtenerIdHormiga()) {

         System.out.println(hormiga);
         if (hormiga.equals(idHormiga)) {
            return true; // El código si existe
         }
      }
      return false;
   }

   public boolean add(String Nombre, Integer IdHormigaTipo, String Codigo) throws Exception {

      Hormiga = new HormigaDTO();
      Hormiga.setNombre(Nombre);
      Hormiga.setIdHormigaTipo(IdHormigaTipo);
      Hormiga.setCodigo(Codigo);
      return hDAO.create(Hormiga);
   }

   public boolean update(Integer idHormiga, String Nombre, Integer IdHormigaTipo, String Codigo) throws Exception {

      Hormiga = new HormigaDTO();
      Hormiga.setIdHormiga(idHormiga);
      Hormiga.setNombre(Nombre);
      Hormiga.setIdHormigaTipo(IdHormigaTipo);
      Hormiga.setCodigo(Codigo);
      return hDAO.update(Hormiga);
   }

   public boolean delete(int idHormiga) throws Exception {
      return hDAO.delete(idHormiga);
   }
}
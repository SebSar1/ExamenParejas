package BusinessLogic.BL;

import java.util.ArrayList;
import java.util.List;

import DataAccess.DAO.UsuarioSistemaDAO;

import DataAccess.DTO.UsuarioSistemaDTO;

public class UsuarioSistemaBL {
   private UsuarioSistemaDTO UsuarioSistema;
   private static UsuarioSistemaDAO htDAO = new UsuarioSistemaDAO();

   public UsuarioSistemaBL() {
   }

   public static ArrayList<UsuarioSistemaDTO> getAll() throws Exception {
      return htDAO.readAll();
   }

   public static UsuarioSistemaDTO getClave(Integer idHormigaTipo) throws Exception {
      return htDAO.obtenerClave(idHormigaTipo);
   }

   public static ArrayList<UsuarioSistemaDTO> getUsuario() throws Exception {
      return htDAO.obtenerUsuario();
   }

   public UsuarioSistemaDTO getBy(int IdUsuarioSistema) throws Exception {
      UsuarioSistema = htDAO.readBy(IdUsuarioSistema);
      return UsuarioSistema;
   }

   public boolean add(String Nombre) throws Exception {
      UsuarioSistema = new UsuarioSistemaDTO();
      UsuarioSistema.setContraseña(Nombre);
      return htDAO.create(UsuarioSistema);
   }

   public boolean update(int idUsuarioSistema, String Nombre) throws Exception {
      UsuarioSistema = new UsuarioSistemaDTO();
      UsuarioSistema.setIdUsuarioSistema(idUsuarioSistema);
      UsuarioSistema.setContraseña(Nombre);
      return htDAO.update(UsuarioSistema);
   }

   public boolean delete(int idUsuarioSistema) throws Exception {
      return htDAO.delete(idUsuarioSistema);
   }
}
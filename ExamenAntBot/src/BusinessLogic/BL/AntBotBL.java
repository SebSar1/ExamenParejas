package BusinessLogic.BL;

import java.util.ArrayList;
import java.util.List;

import DataAccess.DAO.AntBotDAO;

import DataAccess.DTO.AntBotDTO;

public class AntBotBL {
   private AntBotDTO AntBot;
   private static AntBotDAO aDAO = new AntBotDAO();

   public AntBotBL() {
   }

   public static ArrayList<AntBotDTO> getAll() throws Exception {
      return aDAO.readAll();
   }

   public AntBotDTO getBy(int IdAntBot) throws Exception {
      AntBot = aDAO.readBy(IdAntBot);
      return AntBot;
   }

   public boolean add(String Nombre) throws Exception {
      AntBot = new AntBotDTO();
      AntBot.setNombre(Nombre);
      return aDAO.create(AntBot);
   }

   public boolean update(int idAntBot, String Nombre) throws Exception {
      AntBot = new AntBotDTO();
      AntBot.setIdAntBot(idAntBot);
      AntBot.setNombre(Nombre);
      return aDAO.update(AntBot);
   }

   public boolean delete(int idAntBot) throws Exception {
      return aDAO.delete(idAntBot);
   }
}
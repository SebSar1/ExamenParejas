package DataAccess.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import DataAccess.SQLiteDataHelper;
import DataAccess.DTO.AntBotDTO;

public class AntBotDAO extends SQLiteDataHelper implements IDAO<AntBotDTO> {

    @Override
    public boolean create(AntBotDTO entity) throws Exception {
        String query = "INSERT INTO AntBot (Nombre) VALUES (?)";
        try {
            Connection conn = openConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, entity.getNombre());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public ArrayList<AntBotDTO> readAll() throws Exception {
        ArrayList<AntBotDTO> list = new ArrayList<>();
        String query = "SELECT IdAntBot,IdIABot,Nombre,Serie,Estado FROM AntBot WHERE Estado = 'A'";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                AntBotDTO s = new AntBotDTO(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
                list.add(s);
            }
        } catch (SQLException e) {
            throw e;
        }
        return list;
    }

    @Override
    public AntBotDTO readBy(Integer id) throws Exception {
        AntBotDTO oS = new AntBotDTO();
        String query = "SELECT IdAntBot,IdIABot,Nombre,Serie,Estado FROM AntBot WHERE Estado = 'A'AND IdAntBot = "
                + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                oS = new AntBotDTO(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
            }
        } catch (SQLException e) {
            throw e;
        }
        return oS;
    }

    @Override
    public boolean update(AntBotDTO entity) throws Exception {
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE AntBot SET Nombre = ?,FechaModifica = ?,WHERE IdAntBot = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, entity.getNombre());
            stmt.setString(2, date.format(now).toString());
            stmt.setInt(3, entity.getIdAntBot());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE AntBot SET Estado = ? WHERE IdAntBot = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "X");
            stmt.setInt(2, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

}

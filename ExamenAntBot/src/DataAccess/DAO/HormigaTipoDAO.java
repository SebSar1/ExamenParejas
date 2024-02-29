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
import DataAccess.DTO.HormigaTipoDTO;

public class HormigaTipoDAO extends SQLiteDataHelper implements IDAO<HormigaTipoDTO> {

    @Override
    public boolean create(HormigaTipoDTO entity) throws Exception {
        String query = "INSERT INTO HormigaTipo (Nombre) VALUES (?)";
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
    public ArrayList<HormigaTipoDTO> readAll() throws Exception {
        ArrayList<HormigaTipoDTO> list = new ArrayList<>();
        String query = "SELECT IdHormigaTipo,IdHormigaTipoPadre, Nombre,Estado,FechaCrea FROM HormigaTipo WHERE Estado = 'A'";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                HormigaTipoDTO s = new HormigaTipoDTO(rs.getInt(1),
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
    public HormigaTipoDTO readBy(Integer id) throws Exception {
        HormigaTipoDTO oS = new HormigaTipoDTO();
        String query = "SELECT IdHormigaTipo,IdHormigaTipoPadre,Nombre,Estado,FechaCrea FROM HormigaTipo WHERE Estado = 'A'AND IdHormigaTipo = "
                + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                oS = new HormigaTipoDTO(rs.getInt(1),
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
    public boolean update(HormigaTipoDTO entity) throws Exception {
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE HormigaTipo SET Nombre = ?,FechaModifica = ?,WHERE IdHormigaTipo = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, entity.getNombre());
            stmt.setString(2, date.format(now).toString());
            stmt.setInt(3, entity.getIdHormigaTipo());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE HormigaTipo SET Estado = ? WHERE IdHormigaTipo = ?";
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

package DataAccess.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DataAccess.SQLiteDataHelper;
import DataAccess.DTO.saHormigaComidaDTO;

public class saHormigaComidaDAO extends SQLiteDataHelper implements IDAO<saHormigaComidaDTO> {

    @Override
    public boolean create(saHormigaComidaDTO entity) throws Exception {
        return false;
    }

    @Override
    public ArrayList<saHormigaComidaDTO> readAll() throws Exception {
        ArrayList<saHormigaComidaDTO> list = new ArrayList<>();
        String query = "SELECT IdHormiga,HormigaTipo,CodigoHormiga,Estado,Comio, Region FROM saHormigaComida WHERE Estado = 'A'";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                saHormigaComidaDTO s = new saHormigaComidaDTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6));
                list.add(s);
            }
        } catch (SQLException e) {
            throw e;
        }
        return list;
    }

    @Override
    public saHormigaComidaDTO readBy(Integer id) throws Exception {
        saHormigaComidaDTO oS = new saHormigaComidaDTO();
        oS = null;
        String query = "SELECT IdHormiga,HormigaTipo,CodigoHormiga,Estado,Comio, Region FROM saHormigaComida WHERE Estado = 'A'AND IdHormiga = "
                + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                oS = new saHormigaComidaDTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        } catch (SQLException e) {
            throw e;
        }
        return oS;
    }

    @Override
    public boolean update(saHormigaComidaDTO entity) throws Exception {

        String query = "UPDATE saHormigaComida SET HormigaTipo = ?,Comio = ? WHERE IdHormiga = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, entity.getSaHormigaTipo());
            stmt.setString(2, entity.getSaComio());
            stmt.setInt(3, entity.getSaIdHormiga());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE saHormigaComida SET Estado = ? WHERE IdHormiga = ?";
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

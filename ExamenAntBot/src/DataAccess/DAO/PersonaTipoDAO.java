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
import DataAccess.DTO.PersonaTipoDTO;


public class PersonaTipoDAO extends SQLiteDataHelper implements IDAO<PersonaTipoDTO> {

    @Override
    public boolean create(PersonaTipoDTO entity) throws Exception {
        String query = "INSERT INTO PersonaTipo (Nombre) VALUES (?)";
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
    public List<PersonaTipoDTO> readAll() throws Exception {
        ArrayList<PersonaTipoDTO> list = new ArrayList<>();
        String query = "SELECT IdPersonaTipo, Nombre,Estado,FechaCrea FROM PersonaTipo WHERE Estado = 'A'";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                PersonaTipoDTO s = new PersonaTipoDTO(rs.getInt(1),
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
    public PersonaTipoDTO readBy(Integer id) throws Exception {
        PersonaTipoDTO oS = new PersonaTipoDTO();
        String query = "SELECT IdPersonaTipo, Nombre, Estado,FechaCrea FROM PersonaTipo WHERE Estado = 'A'AND IdPersonaTipo = "+ id.toString();
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                oS = new PersonaTipoDTO(rs.getInt(1),
                                    rs.getString(2),
                                    rs.getString(3), 
                                    rs.getString(4));
            }
        } catch (SQLException e) {
            throw e;
        }
        return oS;
    }

    @Override
    public boolean update(PersonaTipoDTO entity) throws Exception {
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE PersonaTipo SET Nombre = ?,FechaModifica = ?,WHERE IdPersonaTipo = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, entity.getNombre());
            stmt.setString(2,date.format(now).toString());
            stmt.setInt(3, entity.getIdPersonaTipo());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE PersonaTipo SET Estado = ? WHERE IdPersonaTipo = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "X");
            stmt.setInt(2,id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        } 
    }
    
    
}


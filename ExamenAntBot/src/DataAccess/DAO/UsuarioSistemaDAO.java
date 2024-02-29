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
import DataAccess.DTO.UsuarioSistemaDTO;

public class UsuarioSistemaDAO extends SQLiteDataHelper implements IDAO<UsuarioSistemaDTO> {

    @Override
    public boolean create(UsuarioSistemaDTO entity) throws Exception {
        String query = "INSERT INTO UsuarioSistema (Contraseña) VALUES (?)";
        try {
            Connection conn = openConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, entity.getContraseña());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    public UsuarioSistemaDTO obtenerClave(Integer id) throws Exception {
        UsuarioSistemaDTO oS = new UsuarioSistemaDTO();

        String query = " SELECT Contraseña FROM UsuarioSistema WHERE Estado = 'A' AND IdUsuarioSistema =   "
                + id.toString();

        try {
            Connection conn = openConnection(); // Conectar a la base de datos
            Statement stmt = conn.createStatement(); // Crear una declaración SQL
            ResultSet rs = stmt.executeQuery(query); // Ejecutar la consulta SQL
            while (rs.next()) {
                // Obtener el identificador de persona de la fila actual
                oS = new UsuarioSistemaDTO(rs.getString(1)); // Crear un nuevo objeto
                                                             // UsuarioSistemaDTO con el
                                                             // identificador de persona
                // Agregar el objeto a la lista
                return oS;
            }
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        return oS;
    }

    public ArrayList<UsuarioSistemaDTO> obtenerUsuario() throws Exception {
        ArrayList<UsuarioSistemaDTO> lst = new ArrayList<>();
        String query = "SELECT IdHormigaTipo FROM UsuarioSistema WHERE Estado = 'A'";
        try {
            Connection conn = openConnection(); // Conectar a la base de datos
            Statement stmt = conn.createStatement(); // Crear una declaración SQL
            ResultSet rs = stmt.executeQuery(query); // Ejecutar la consulta SQL
            while (rs.next()) {
                // Obtener el identificador de persona de la fila actual
                UsuarioSistemaDTO idHormigaTipo = new UsuarioSistemaDTO(rs.getInt(1)); // Crear un nuevo objeto
                // UsuarioSistemaDTO con el
                // identificador de persona
                // Agregar el objeto a la lista
                lst.add(idHormigaTipo);
            }
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        return lst;
    }

    @Override
    public ArrayList<UsuarioSistemaDTO> readAll() throws Exception {
        ArrayList<UsuarioSistemaDTO> list = new ArrayList<>();
        String query = "SELECT IdUsuarioSistema,IdHormigaTipo,Contraseña,Estado,FechaCrea,FechaModifica FROM UsuarioSistema WHERE Estado = 'A'";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                UsuarioSistemaDTO s = new UsuarioSistemaDTO(rs.getInt(1),
                        rs.getInt(2),
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
    public UsuarioSistemaDTO readBy(Integer id) throws Exception {
        UsuarioSistemaDTO oS = new UsuarioSistemaDTO();
        String query = "SELECT IdUsuarioSistema,IdHormigaTipo,Contraseña,Estado,FechaCrea,FechaModifica FROM UsuarioSistema AND IdUsuarioSistema = "
                + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                oS = new UsuarioSistemaDTO(rs.getInt(1),
                        rs.getInt(2),
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
    public boolean update(UsuarioSistemaDTO entity) throws Exception {
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE UsuarioSistema SET Contraseña = ?,FechaModifica = ?,WHERE IdUsuarioSistema = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, entity.getContraseña());
            stmt.setString(2, date.format(now).toString());
            stmt.setInt(3, entity.getIdUsuarioSistema());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE UsuarioSistema SET Estado = ? WHERE IdUsuarioSistema = ?";
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

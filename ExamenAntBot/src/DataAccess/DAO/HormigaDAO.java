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
import DataAccess.DTO.HormigaDTO;
import DataAccess.DTO.HormigaDTO;
import DataAccess.DTO.HormigaDTO;

public class HormigaDAO extends SQLiteDataHelper implements IDAO<HormigaDTO> {

    @Override
    public boolean create(HormigaDTO entity) throws Exception {
        String query = "INSERT INTO Hormiga (Nombre, IdHormigaTipo, Codigo) VALUES (?, ?, ?)";
        try {
            Connection conn = openConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, entity.getNombre());
            stmt.setInt(2, entity.getIdHormigaTipo());
            stmt.setString(3, entity.getCodigo());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public ArrayList<HormigaDTO> readAll() throws Exception {
        ArrayList<HormigaDTO> list = new ArrayList<>();
        String query = "SELECT IdHormiga,IdHormigaTipo,Codigo,Nombre,Estado,FechaCrea FROM Hormiga WHERE Estado = 'A'";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                HormigaDTO s = new HormigaDTO(rs.getInt(1),
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
    public HormigaDTO readBy(Integer id) throws Exception {
        HormigaDTO oS = new HormigaDTO();
        String query = "SELECT IdHormiga,IdHormigaTipo,Codigo,Nombre,Estado,FechaCrea FROM Hormiga WHERE Estado = 'A'AND IdHormiga = "
                + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                oS = new HormigaDTO(rs.getInt(1),
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

    public HormigaDTO obtenerHormigaRol(Integer idHormiga) throws Exception {
        HormigaDTO hormigaDTO = new HormigaDTO();

        String query = " SELECT IdHormigaTipo FROM Hormiga WHERE Estado = 'A' AND IdHormiga =   "
                + idHormiga.toString();

        try {
            Connection conn = openConnection(); // Conectar a la base de datos
            Statement stmt = conn.createStatement(); // Crear una declaración SQL
            ResultSet rs = stmt.executeQuery(query); // Ejecutar la consulta SQL
            while (rs.next()) {
                // Obtener el identificador de persona de la fila actual
                hormigaDTO = new HormigaDTO(rs.getInt(1)); // Crear un nuevo objeto
                // HormigaDTO con el
                // identificador de persona
                // Agregar el objeto a la lista
                return hormigaDTO;
            }
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        return hormigaDTO;
    }

    @Override
    public boolean update(HormigaDTO entity) throws Exception {

        String query = "UPDATE Hormiga SET Nombre = ?, IdHormigaTipo = ?, Codigo = ? WHERE IdHormiga = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, entity.getNombre());
            stmt.setInt(2, entity.getIdHormigaTipo());
            stmt.setString(3, entity.getCodigo());
            stmt.setInt(4, entity.getIdHormiga());

            stmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE Hormiga SET Estado = ? WHERE IdHormiga = ?";
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

    public ArrayList<String> obtenerCodigo() throws Exception {
        ArrayList<String> codigos = new ArrayList<>();
        String query = "SELECT Codigo FROM Hormiga WHERE Estado = 'A'";
        try {
            Connection conn = openConnection(); // Conectar a la base de datos
            Statement stmt = conn.createStatement(); // Crear una declaración SQL
            ResultSet rs = stmt.executeQuery(query); // Ejecutar la consulta SQL
            while (rs.next()) {
                // Obtener el código de la fila actual
                String codigo = rs.getString("Codigo");
                // Agregar el código a la lista
                codigos.add(codigo);
            }
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        return codigos;
    }

    public ArrayList<String> obtenerIdHormiga() throws Exception {
        ArrayList<String> codigos = new ArrayList<>();
        String query = "SELECT IdHormiga FROM Hormiga WHERE Estado = 'A'";
        try {
            Connection conn = openConnection(); // Conectar a la base de datos
            Statement stmt = conn.createStatement(); // Crear una declaración SQL
            ResultSet rs = stmt.executeQuery(query); // Ejecutar la consulta SQL
            while (rs.next()) {
                // Obtener el código de la fila actual
                String codigo = rs.getInt(1) + "";
                // Agregar el código a la lista
                codigos.add(codigo);
            }
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        return codigos;
    }

}
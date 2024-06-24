package dao;

<<<<<<< HEAD
public class VacinaDao {
}
=======
import model.Vacina;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VacinaDao {
    private Connection connection;

    public VacinaDao() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dbvacinacao2?useTimezone=true&serverTimezone=UTC", "root", "daniel");
        } catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void inserir(Vacina vacina) throws SQLException {
        String sql = "insert into vacina(nomeVacina,descricao) values(?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, vacina.getNomeVacina());
        ps.setString(2, vacina.getDescricao());
        ps.execute();
    }

    public List<Vacina> listarTodos() throws SQLException {
        List<Vacina> vacinas = new ArrayList<Vacina>();

        ResultSet rs = connection.prepareStatement("select * from vacina").executeQuery();
        while (rs.next()) {
            vacinas.add(new Vacina(
                    rs.getLong("id"),
                    rs.getString("nomeVacina"),
                    rs.getString("descricao")));

        }
        rs.close();

        return vacinas;
    }

    public void atualizar(Vacina vacina) throws SQLException {
        String sql = "update vacina set nomeVacina = ?, descricao = ? where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, vacina.getNomeVacina());
        ps.setString(2, vacina.getDescricao());
        ps.setLong(3, vacina.getId());
        ps.execute();
    }

    public void deletar(int id) throws SQLException {
        String sql = "delete from Vacina where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
    }
}

>>>>>>> java

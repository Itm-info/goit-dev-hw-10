package planet;

import java.sql.SQLException;

public interface IPlanetCrudService {
    void create(Planet planet) throws SQLException;
    Planet getById(String id) throws SQLException;
    void update(String id) throws SQLException;
    void delete(String id) throws SQLException;
}

package client;

import java.sql.SQLException;
public interface IClientCrudService {
    void create(Client client) throws SQLException;
    Client getById(long id) throws SQLException;
    Client getByName(String name) throws SQLException;
}

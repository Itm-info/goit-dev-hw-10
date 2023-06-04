package client;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import storage.hibernate.HibernateUtil;

import java.sql.SQLException;

public class HibernateClientCrudService implements IClientCrudService {
    @Override
    public void create(Client client) throws SQLException {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(client);
        transaction.commit();
        session.close();
    }

    @Override
    public Client getById(long id) throws SQLException {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Query<Client> query = session.createQuery(
                    "from Client where id = :id",
                    Client.class
            );
            query.setParameter("id", id);
            return query.stream().findFirst().orElse(null);
        }
    }

    @Override
    public Client getByName(String name) throws SQLException {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Query<Client> query = session.createQuery(
                    "from Client where name = :name",
                    Client.class
            );
            query.setParameter("name", name);
            return query.stream().findFirst().orElse(null);
        }
    }
}
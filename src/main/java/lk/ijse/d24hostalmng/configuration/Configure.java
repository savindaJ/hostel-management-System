package lk.ijse.d24hostalmng.configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Configure {
    private static Configure configure;
    private static final SessionFactory factory;

    static {
        factory = new Configuration()
                .configure()
                .addAnnotatedClass(Object.class)
                .buildSessionFactory();
    }

    private Configure(){}

    public static Configure getInstance(){
        return configure == null ? new Configure() : configure;
    }

    public Session getSession(){
        return factory.openSession();
    }
}

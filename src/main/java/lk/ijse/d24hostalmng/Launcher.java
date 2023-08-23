package lk.ijse.d24hostalmng;

import lk.ijse.d24hostalmng.configuration.Configure;
import lk.ijse.d24hostalmng.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;

public class Launcher {
    public static void main(String[] args) {
//        AppInitializer.main(args);
        Session session = Configure.getInstance().getSession();
    }
}

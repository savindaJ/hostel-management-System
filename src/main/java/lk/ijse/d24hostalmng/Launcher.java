package lk.ijse.d24hostalmng;

import lk.ijse.d24hostalmng.configuration.Configure;
import org.hibernate.Session;

public class Launcher {
    public static void main(String[] args) {
        AppInitializer.main(args);
//        Session session = Configure.getInstance().getSession();
    }
}

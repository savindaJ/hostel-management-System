package lk.ijse.d24hostalmng.dao.custom;

import lk.ijse.d24hostalmng.dao.CrudDAO;
import lk.ijse.d24hostalmng.entity.Reservation;

public interface ReservationDAO extends CrudDAO<Reservation,String> {
    String getNextId();

}

package lk.ijse.d24hostalmng.dao.custom;

import lk.ijse.d24hostalmng.dao.SuperDAO;
import lk.ijse.d24hostalmng.dto.CustomReservationDTO;
import org.hibernate.Session;

import java.util.List;

public interface QuaryDAO extends SuperDAO {
    List<CustomReservationDTO> getAllReservation();

    void setSession(Session session);
}

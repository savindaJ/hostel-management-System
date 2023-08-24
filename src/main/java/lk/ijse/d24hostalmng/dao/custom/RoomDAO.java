package lk.ijse.d24hostalmng.dao.custom;

import lk.ijse.d24hostalmng.dao.CrudDAO;
import lk.ijse.d24hostalmng.entity.Room;

public interface RoomDAO extends CrudDAO<Room,String> {
    String getNextID();
}

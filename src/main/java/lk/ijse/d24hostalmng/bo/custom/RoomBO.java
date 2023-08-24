package lk.ijse.d24hostalmng.bo.custom;

import lk.ijse.d24hostalmng.bo.CrudBO;
import lk.ijse.d24hostalmng.dao.CrudDAO;
import lk.ijse.d24hostalmng.dto.RoomDTO;

public interface RoomBO extends CrudBO<RoomDTO,String> {
    String genarateID();
}

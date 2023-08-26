package lk.ijse.d24hostalmng.bo.custom;

import lk.ijse.d24hostalmng.bo.CrudBO;
import lk.ijse.d24hostalmng.dto.ReservationDTO;

public interface ReservationBO extends CrudBO<ReservationDTO,String> {
    String getNextResID();
}

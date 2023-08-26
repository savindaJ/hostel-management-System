package lk.ijse.d24hostalmng.bo.custom.impl;

import lk.ijse.d24hostalmng.bo.custom.ReservationBO;
import lk.ijse.d24hostalmng.configuration.Configure;
import lk.ijse.d24hostalmng.dao.DAOFactory;
import lk.ijse.d24hostalmng.dao.custom.ReservationDAO;
import lk.ijse.d24hostalmng.dto.ReservationDTO;
import org.hibernate.Session;

import java.util.List;

public class ReservationBOImpl implements ReservationBO {
    ReservationDAO reservationDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.RESERVATIONDAO);

    @Override
    public boolean save(ReservationDTO reservationDTO) {
        return false;
    }

    @Override
    public boolean update(ReservationDTO reservationDTO) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public ReservationDTO find(String s) {
        return null;
    }

    @Override
    public List<ReservationDTO> getAll() {
        return null;
    }

    @Override
    public String getNextResID() {
        Session session = Configure.getInstance().getSession();
        reservationDAO.setSession(session);
        String id = reservationDAO.getNextId();
        Integer newId = Integer.parseInt(id.replace("RES", "")) + 1;
        return String.format("RES%03d", newId);
    }
}

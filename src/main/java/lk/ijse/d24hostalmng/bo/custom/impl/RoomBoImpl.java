package lk.ijse.d24hostalmng.bo.custom.impl;

import lk.ijse.d24hostalmng.bo.custom.RoomBO;
import lk.ijse.d24hostalmng.configuration.Configure;
import lk.ijse.d24hostalmng.dao.DAOFactory;
import lk.ijse.d24hostalmng.dao.custom.RoomDAO;
import lk.ijse.d24hostalmng.dto.RoomDTO;
import lk.ijse.d24hostalmng.entity.Room;
import org.hibernate.Session;


import java.util.ArrayList;
import java.util.List;

public class RoomBoImpl implements RoomBO {

    private final RoomDAO roomDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.ROOMDAO);

    @Override
    public boolean save(RoomDTO roomDTO) {
        Session session = Configure.getInstance().getSession();
        roomDAO.setSession(session);
        return roomDAO.save(new Room(
                roomDTO.getRoomId(),
                roomDTO.getRoomType(),
                roomDTO.getKeyMoney(),
                roomDTO.getQty(),
                roomDTO.getAvailability()
        ));
    }

    @Override
    public boolean update(RoomDTO roomDTO) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public RoomDTO find(String s) {
        return null;
    }

    @Override
    public List<RoomDTO> getAll() {
        Session session = Configure.getInstance().getSession();
        roomDAO.setSession(session);
        List<RoomDTO> roomDTOS = new ArrayList<>();
        for (Room room : roomDAO.getAll()){
            roomDTOS.add(new RoomDTO(
                    room.getRoomId(),
                    room.getRoomType(),
                    room.getKeyMoney(),
                    room.getQty(),
                    room.getRoomAvailability()
            ));
        }
        return roomDTOS;
    }

    @Override
    public String genarateID() {
        Session session = Configure.getInstance().getSession();
        roomDAO.setSession(session);
        String id = roomDAO.getNextID();
        Integer newId = Integer.parseInt(id.replace("RM", "")) + 1;
        return String.format("RM%03d", newId);
    }
}

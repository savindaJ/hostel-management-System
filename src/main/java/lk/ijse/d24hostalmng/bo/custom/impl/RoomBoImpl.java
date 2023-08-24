package lk.ijse.d24hostalmng.bo.custom.impl;

import lk.ijse.d24hostalmng.bo.custom.RoomBO;
import lk.ijse.d24hostalmng.dto.RoomDTO;


import java.util.List;

public class RoomBoImpl implements RoomBO {

    @Override
    public boolean save(RoomDTO roomDTO) {
        return false;
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
        return null;
    }
}

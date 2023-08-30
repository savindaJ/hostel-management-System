package lk.ijse.d24hostalmng.bo.custom;

import lk.ijse.d24hostalmng.bo.SuperBO;

public interface HomeBO extends SuperBO {
    String getStuTotal();
    String getRoomTotalForTypes();
    String getAvlTotal();
}

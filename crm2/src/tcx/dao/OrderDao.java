package tcx.dao;



import java.util.ArrayList;

import tcx.pojo.Order;

public interface OrderDao {
    //杩斿洖鐢ㄦ埛鍚嶅拰璁㈠崟閲戦
    ArrayList<Order> searchOrder();
    //鎸夋墍閫夊勾浠借繑鍥炵敤鎴峰悕鍜岃鍗曢噾棰�
    ArrayList<Order> searchOrder(String year);
    //鎸夊鎴峰悕绉板拰鎵��骞翠唤杩斿洖鐢ㄦ埛鍚嶅拰璁㈠崟閲戦
    ArrayList<Order> searchOrder(String name,String year);
}

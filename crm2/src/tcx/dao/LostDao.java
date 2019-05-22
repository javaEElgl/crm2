package tcx.dao;



import java.util.ArrayList;

import tcx.pojo.Lost;

public interface LostDao {
    //杩斿洖鍏ㄩ儴娴佸け淇℃伅
    ArrayList<Lost> searchLost();
    //鎸夋潯浠惰繑鍥炴祦澶变俊鎭�
    ArrayList<Lost> searchLost(String lstCustName,String lstCustManagerName);
}
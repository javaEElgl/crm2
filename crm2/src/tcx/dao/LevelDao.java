package tcx.dao;


import java.util.ArrayList;

import tcx.pojo.Level;

public interface LevelDao {
    //返回用户名和等级
    ArrayList<Level> searchLevel();
    //按满意度返回用户名和等级
    ArrayList<Level> searchLevelBySatisfy();
    //按信用度返回用户名和等级
    ArrayList<Level> searchLevelByCredit();
}

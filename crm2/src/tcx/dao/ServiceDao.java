package tcx.dao;



import java.util.ArrayList;

import tcx.pojo.Service;

public interface ServiceDao {
    
    ArrayList<Service> searchService();
    
    ArrayList<Service> searchServiceByYear(String year);
}

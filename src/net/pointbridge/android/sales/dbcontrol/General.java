package net.pointbridge.android.sales.dbcontrol;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import net.pointbridge.android.sales.db.ConfigDao;
import net.pointbridge.android.sales.db.Customer;
import net.pointbridge.android.sales.db.CustomerDao;
import net.pointbridge.android.sales.db.DaoSession;
 

public class General {
	public Map getRecordList(DaoSession session,Map params){
		/*"table" :this.getId(),
							"sorters" : operation.getSorters(),
				            "filters":operation.getFilters(),
				            "start":operation.getStart(),
				            "limit":operation.getLimit(),
				            "enablePaging":this.getEnablePagingParams()*/
		Map res= new HashMap();
		System.out.println("sorters "+params.get("sorters"));
		System.out.println("filters "+params.get("filters"));
		System.out.println("start "+params.get("start"));
		System.out.println("limit "+params.get("limit"));
		System.out.println("enablePaging "+params.get("enablePaging"));
		if (((String)params.get("table")).equalsIgnoreCase("config")){
			ConfigDao configDao=session.getConfigDao();
			
			 if (Boolean.parseBoolean((String)params.get("enablePaging"))){
				List recList = configDao.queryBuilder()
						.offset(Integer.valueOf((String) params.get("start")))
						.limit(Integer.valueOf((String) params.get("limit")))
						.orderAsc(ConfigDao.Properties.Id)
						.list();
				 
				 res.put("data",new Gson().toJson(recList));
			 }
			else {
				List recList = configDao.queryBuilder()
					 
						.orderAsc(ConfigDao.Properties.Id)
						.list(); 
				 
				 res.put("data",new Gson().toJson(recList));
			}
			 res.put("count", Long.toString(configDao.count()));
			
		}
		else
			if (((String)params.get("table")).equalsIgnoreCase("customer")){
				CustomerDao customerDao=session.getCustomerDao();
				if (Boolean.parseBoolean((String)params.get("enablePaging"))){
					System.out.println("start :"+(Integer.valueOf((String) params.get("start"))));
					System.out.println("limit :"+(Integer.valueOf((String) params.get("limit"))));
					List recList = customerDao.queryBuilder()
							.offset(Integer.valueOf((String) params.get("start")))
							.limit(Integer.valueOf((String) params.get("limit")))
							.orderAsc(CustomerDao.Properties.Cust_code)
							.list();
					res.put("data",new Gson().toJson(recList));
				 }
				else {
					List recList = customerDao.queryBuilder()
						 
							.orderAsc(CustomerDao.Properties.Cust_code)
							.list();
					res.put("data",new Gson().toJson(recList));
				}
				 res.put("count", Long.toString(customerDao.count()));
			}
			else {
				System.out.println("nothing process in getRecordList");
			}
			
		return res;
	}
	public String getRecord(DaoSession session,Map params){
		/*"table" :this.getId(),
							"sorters" : operation.getSorters(),
				            "filters":operation.getFilters(),
				            "start":operation.getStart(),
				            "limit":operation.getLimit(),
				            "enablePaging":this.getEnablePagingParams()*/
		String res="";
		 
		if (((String)params.get("table")).equalsIgnoreCase("config")){
			ConfigDao configDao=session.getConfigDao();
			 	
				List recList = configDao.queryBuilder()
						.where(ConfigDao.Properties.Id.eq((String)params.get("id")))
						.orderAsc(ConfigDao.Properties.Id)
						.list();
				if (recList.size()>0)
				 res = new Gson().toJson(recList.get(0));
			 
		}
		else
			if (((String)params.get("table")).equalsIgnoreCase("customer")){
				CustomerDao customerDao=session.getCustomerDao();
				List recList = customerDao.queryBuilder()
						.where(CustomerDao.Properties.Cust_code.eq((String)params.get("id")))
						.orderAsc(CustomerDao.Properties.Cust_code)
						.list();
				if (recList.size()>0)
				 res = new Gson().toJson(recList.get(0));
			}
			
		return res;
	}
	public long insertRecord(DaoSession session,Map params){
		
		Customer cust = new Gson().fromJson((String)params.get("record"), Customer.class);
		System.out.println("customer :"+cust.getCust_code()+"||"+cust.getCust_city()+"||"+cust.getCust_name()+"||"+cust.getCust_address1());
		CustomerDao custDao=session.getCustomerDao();
		 
		return custDao.insert(cust);
		
	}
}

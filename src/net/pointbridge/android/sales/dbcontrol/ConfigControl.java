package net.pointbridge.android.sales.dbcontrol;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import net.pointbridge.android.sales.db.Config;
import net.pointbridge.android.sales.db.ConfigDao;
import net.pointbridge.android.sales.db.ConfigDao.Properties;
import net.pointbridge.android.sales.db.Customer;
import net.pointbridge.android.sales.db.CustomerDao;
import net.pointbridge.android.sales.db.DaoSession;

 

import com.google.gson.Gson;

public class ConfigControl {

	public void initConfig(DaoSession session){
		ConfigDao configDao=session.getConfigDao();
		//for testing lets insert customer
		CustomerDao custDao=session.getCustomerDao();
		if (custDao.count()==0){
		Customer cust = new Customer();
		cust.setCust_code("AAAA");
		cust.setCust_name("TOKO AAAA");
		cust.setCust_address1("JL. AAAA NO 123");
		custDao.insert(cust);
		 cust = new Customer();
		cust.setCust_code("BBBB");
		cust.setCust_name("TOKO BBBB");
		cust.setCust_address1("JL. BBBB NO 123");
		custDao.insert(cust);
		 cust = new Customer();
		cust.setCust_code("CCCC");
		cust.setCust_name("TOKO CCCC");
		cust.setCust_address1("JL. CCCC NO 123");
		custDao.insert(cust);
		}
		
		//configDao.deleteAll();
		if (configDao.count()==0){
			 Config config = new Config(null,"","Server Address","svr_addr");
			 configDao.insert(config);
			 config = new Config(null,"","Server Port","svr_port");
			 configDao.insert(config);
			 config = new Config(null,"","User Name","username");
			 configDao.insert(config);
			 config = new Config(null,"","Password","password");
			 configDao.insert(config);
			 config = new Config(null,"1","Remember Me","remember_me");
			 configDao.insert(config);
		}
	}
	public void saveSetup(DaoSession session,JSONObject jobAsk) throws JSONException{
		ConfigDao configDao=session.getConfigDao();
		Config config=configDao.queryBuilder() .where(ConfigDao.Properties.Conf_name.eq("svr_addr")) .unique();
		config.setConf_val(jobAsk.getString("svr_addr"));
		configDao.insertOrReplace(config);
		config=configDao.queryBuilder() .where(ConfigDao.Properties.Conf_name.eq("svr_port")) .unique();
		config.setConf_val(jobAsk.getString("svr_port"));
		System.out.println("SAVE SETUP :"+jobAsk.getString("svr_port"));
		configDao.insertOrReplace(config);
		config=configDao.queryBuilder() .where(ConfigDao.Properties.Conf_name.eq("username")) .unique();
		config.setConf_val(jobAsk.getString("username"));
		configDao.insertOrReplace(config);
		config=configDao.queryBuilder() .where(ConfigDao.Properties.Conf_name.eq("password")) .unique();
		config.setConf_val(jobAsk.getString("password"));
		configDao.insertOrReplace(config);
		
	}
	public String getConfigList(DaoSession session){
		
		ConfigDao configDao=session.getConfigDao();
		
		List configList = configDao.queryBuilder()
			 
				.orderAsc(ConfigDao.Properties.Id)
				.list();
		String res = new Gson().toJson(configList);
		return res;
	}
}

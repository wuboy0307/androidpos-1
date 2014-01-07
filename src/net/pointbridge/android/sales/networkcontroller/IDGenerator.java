package net.pointbridge.android.sales.networkcontroller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
 
import android.text.format.DateFormat;
import android.util.Base64;
import android.util.Log;

public class IDGenerator {
	public static int NO_OPTIONS=0;
	 
	private static String convertToHex(byte[] data)  
    {
            
            
           StringBuffer sb = new StringBuffer();
           String hex=null;
            
           hex=Base64.encodeToString(data, 0, data.length, NO_OPTIONS);
            
           sb.append(hex);
                        
           return sb.toString();
       }
    
    
   public static String computeSHAHash(String password)  
     {
         MessageDigest mdSha1 = null;
           try
           {
             mdSha1 = MessageDigest.getInstance("SHA-1");
           } catch (NoSuchAlgorithmException e1) {
        	   Log.e("IDGEN", "Error initializing SHA1 message digest");
           }
           try {
               mdSha1.update(password.getBytes("ASCII"));
           } catch (UnsupportedEncodingException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
           byte[] data = mdSha1.digest();
          
            
       
			return convertToHex(data);
		 
       }
    
    
   public static String computeMD5Hash(String password)  
   {

       
           // Create MD5 Hash
           MessageDigest digest;
		try {
			digest = java.security.MessageDigest.getInstance("MD5");
		
           digest.update(password.getBytes());
           byte messageDigest[] = digest.digest();
     
           StringBuffer MD5Hash = new StringBuffer();
           for (int i = 0; i < messageDigest.length; i++)
           {
               String h = Integer.toHexString(0xFF & messageDigest[i]);
               while (h.length() < 2)
                   h = "0" + h;
               MD5Hash.append(h);
           }
                 
       
      
           return MD5Hash.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
        
   }
	 public static synchronized String getRandomID(String node,String cmd)  {
		Date myDate = new Date();
		 
		SimpleDateFormat fdf = new SimpleDateFormat("yyyy-MM-dd:HH-mm-ss"); //-> thread safe, single instance aja
        
        String myDateString = fdf.format(new Date());
       
        Random randgen=new Random(); 
       
        return computeMD5Hash(node+cmd+myDateString+ Integer.toString(randgen.nextInt(10)));
	 }
	 public static synchronized String createNodeID()  {
		 Random randgen=new Random(); 
		 String res=computeMD5Hash(Integer.toString(randgen.nextInt(10)));
		 return  (res.substring(1, 3)+res.substring(15,17)+res.substring(30,32)).toUpperCase();

	 }
}

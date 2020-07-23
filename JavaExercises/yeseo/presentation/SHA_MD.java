package presentation;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
 MD5=메세지 축약 알고리즘 , 파일 무결성 검사용도 
 */


public class SHA_MD {

	public String MD5(String str) {
		String MD5="";
		try {
			MessageDigest md=MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte byteData[]=md.digest();
			StringBuffer sb=new StringBuffer();
			for(int i=0;i<byteData.length;i++) {
				sb.append(Integer.toString((byteData[i]&0xff)+0x100,16).substring(1));
			}
			MD5=sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			MD5=null;
		}
		return MD5;
	}
	
public String testSHA256(String str){

		String SHA = ""; 

		try{
			MessageDigest sh = MessageDigest.getInstance("SHA-256"); 
			sh.update(str.getBytes()); 
			byte byteData[] = sh.digest();
			StringBuffer sb = new StringBuffer(); 
			for(int i = 0 ; i < byteData.length ; i++){
				sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
			}
			SHA = sb.toString();	
		}catch(NoSuchAlgorithmException e){

			e.printStackTrace(); 
			SHA = null; 
		}
		return SHA;
	}


}

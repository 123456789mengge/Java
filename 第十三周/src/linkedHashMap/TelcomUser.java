package linkedHashMap;
	import java.util.*;
	public class TelcomUser {
	     private String phoneNumber;
	     private String callTo;
	     private ArrayList communicationRecords;
	     private LinkedHashMap singleRecord;
	     public TelcomUser(String phoneNumber){
	 		this.phoneNumber=phoneNumber;
	 		this.communicationRecords=new ArrayList();
	 		//假定通话记录存在总理，以分号隔开；每条记录内部都有主叫和被叫、开始和结束时间
	 	}
	     void generateCommubicateRecord(){
	 		//随机生成通话记录数目
	 		int recordNum=new Random().nextInt(10);
	 		for(int i=0;i<=recordNum;i++){
	 			//随机生成第i条通话记录
	 			//开始时间，当前时间之前的某个随机时间
	 			//用System.currentTimeMillis()精确到毫秒
	 			long timeStart=System.currentTimeMillis()-new Random().nextInt(36000000);
	 			//结束时间开始后的十分钟内随机的一个时间，至少一分钟
	 			long timeEnd=timeStart+60000+new Random().nextInt(600000);
	 			//用Calendar获取当前时间
	 			Calendar cal=Calendar.getInstance();
	 			//随机减去若干小时（10小时以内）
	 			cal.add(Calendar.HOUR,-new Random().nextInt(10));
	 			//获得对应毫秒
	 			//long timeStart=cal.getTimeInMillis();
	 			//结束时间开始后的十分钟内随机的一个时间，至少一分钟
	 			//long timeEnd=timeStart+60000+new Random().nextInt(600000);
	 			
	 			//被叫号码
	 			this.callTo=getCallTophoneNumber();
	 			//插入通话记录
	 			this.singleRecord = new LinkedHashMap();
	 		     this.singleRecord.put("主叫",this.phoneNumber);//put方法是将指定的值与此映射中的指定关键字关联
	 		     this.singleRecord.put("开始时间",new Date(timeStart));
	 		     this.singleRecord.put("结束时间",new Date(timeEnd));
	 		     this.singleRecord.put("被叫号码",this.callTo);
	 		     this.singleRecord.put("计费",this.accountFee(timeStart,timeEnd));
	 		     this.communicationRecords.add(this.singleRecord);
	 		     //this.treeMapCallToAndFee.put(this.callTo,this.accountFee(timeStart, timeEnd));
	 	}
	 	}
	 	//随机生成被叫号码（后四位随机）并返回
	 	private String getCallTophoneNumber(){
	 		return "1551515"+String.valueOf(new Random().nextInt(10))
	 		+String.valueOf(new Random().nextInt(10))
	 		+String.valueOf(new Random().nextInt(10))
	 		+String.valueOf(new Random().nextInt(10));
	 	}
	 	//模拟计费方法，以字符串的形式返回保留四位小数点计费结果
	 	private String accountFee(long timeStart,long timeEnd){
	 		//每分钟计费N元
	 		double feePerMinute=0.2;
	 		//通话分钟数按四舍五入计算
	 		int minutes=Math.round((timeEnd-timeStart)/60000);
	 		double feeTotal=feePerMinute * minutes;
	 		return String.format("%.4f",feeTotal);
	 	}
	 	//打印通话记录
	 	void printDetails(){
	 		Iterator itRecords = this.communicationRecords.iterator();
	 	      while(itRecords.hasNext()){
	 	    	  System.out.println("---------通话记录分割线---------");
	 	    	  this.singleRecord = ((LinkedHashMap)itRecords.next());//取出键值对集合
	 	    	  Set keySet = this.singleRecord.keySet();//取出键的集合
	 	    	  Iterator itKey = keySet.iterator();
	 	    	  while(itKey.hasNext()){
	 	    		  Object key = itKey.next();
	 	    		  Object value = this.singleRecord.get(key);
	 	    		  System.out.println(key+":"+value);
	 	    		  
	 	    	  }
	 	      }
	 	}
	}




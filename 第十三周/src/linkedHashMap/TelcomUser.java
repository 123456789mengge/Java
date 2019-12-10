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
	 		//�ٶ�ͨ����¼���������ԷֺŸ�����ÿ����¼�ڲ��������кͱ��С���ʼ�ͽ���ʱ��
	 	}
	     void generateCommubicateRecord(){
	 		//�������ͨ����¼��Ŀ
	 		int recordNum=new Random().nextInt(10);
	 		for(int i=0;i<=recordNum;i++){
	 			//������ɵ�i��ͨ����¼
	 			//��ʼʱ�䣬��ǰʱ��֮ǰ��ĳ�����ʱ��
	 			//��System.currentTimeMillis()��ȷ������
	 			long timeStart=System.currentTimeMillis()-new Random().nextInt(36000000);
	 			//����ʱ�俪ʼ���ʮ�����������һ��ʱ�䣬����һ����
	 			long timeEnd=timeStart+60000+new Random().nextInt(600000);
	 			//��Calendar��ȡ��ǰʱ��
	 			Calendar cal=Calendar.getInstance();
	 			//�����ȥ����Сʱ��10Сʱ���ڣ�
	 			cal.add(Calendar.HOUR,-new Random().nextInt(10));
	 			//��ö�Ӧ����
	 			//long timeStart=cal.getTimeInMillis();
	 			//����ʱ�俪ʼ���ʮ�����������һ��ʱ�䣬����һ����
	 			//long timeEnd=timeStart+60000+new Random().nextInt(600000);
	 			
	 			//���к���
	 			this.callTo=getCallTophoneNumber();
	 			//����ͨ����¼
	 			this.singleRecord = new LinkedHashMap();
	 		     this.singleRecord.put("����",this.phoneNumber);//put�����ǽ�ָ����ֵ���ӳ���е�ָ���ؼ��ֹ���
	 		     this.singleRecord.put("��ʼʱ��",new Date(timeStart));
	 		     this.singleRecord.put("����ʱ��",new Date(timeEnd));
	 		     this.singleRecord.put("���к���",this.callTo);
	 		     this.singleRecord.put("�Ʒ�",this.accountFee(timeStart,timeEnd));
	 		     this.communicationRecords.add(this.singleRecord);
	 		     //this.treeMapCallToAndFee.put(this.callTo,this.accountFee(timeStart, timeEnd));
	 	}
	 	}
	 	//������ɱ��к��루����λ�����������
	 	private String getCallTophoneNumber(){
	 		return "1551515"+String.valueOf(new Random().nextInt(10))
	 		+String.valueOf(new Random().nextInt(10))
	 		+String.valueOf(new Random().nextInt(10))
	 		+String.valueOf(new Random().nextInt(10));
	 	}
	 	//ģ��Ʒѷ��������ַ�������ʽ���ر�����λС����Ʒѽ��
	 	private String accountFee(long timeStart,long timeEnd){
	 		//ÿ���ӼƷ�NԪ
	 		double feePerMinute=0.2;
	 		//ͨ���������������������
	 		int minutes=Math.round((timeEnd-timeStart)/60000);
	 		double feeTotal=feePerMinute * minutes;
	 		return String.format("%.4f",feeTotal);
	 	}
	 	//��ӡͨ����¼
	 	void printDetails(){
	 		Iterator itRecords = this.communicationRecords.iterator();
	 	      while(itRecords.hasNext()){
	 	    	  System.out.println("---------ͨ����¼�ָ���---------");
	 	    	  this.singleRecord = ((LinkedHashMap)itRecords.next());//ȡ����ֵ�Լ���
	 	    	  Set keySet = this.singleRecord.keySet();//ȡ�����ļ���
	 	    	  Iterator itKey = keySet.iterator();
	 	    	  while(itKey.hasNext()){
	 	    		  Object key = itKey.next();
	 	    		  Object value = this.singleRecord.get(key);
	 	    		  System.out.println(key+":"+value);
	 	    		  
	 	    	  }
	 	      }
	 	}
	}




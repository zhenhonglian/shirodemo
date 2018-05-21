package com.java1234.mqtt;

 import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
 import org.eclipse.paho.client.mqttv3.MqttCallback;  
 import org.eclipse.paho.client.mqttv3.MqttMessage;  
   
 /**  
  * ������Ϣ�Ļص���  
  *   
  * ����ʵ��MqttCallback�Ľӿڲ�ʵ�ֶ�Ӧ����ؽӿڷ���CallBack �ཫʵ�� MqttCallBack��  
11  * ÿ���ͻ�����ʶ����Ҫһ���ص�ʵ�����ڴ�ʾ���У����캯�����ݿͻ�����ʶ�����Ϊʵ�����ݡ�
12  * �ڻص��У�����������ʶ�Ѿ������˸ûص����ĸ�ʵ����  
13  * �����ڻص�����ʵ������������  
14  *   
15  *  public void messageArrived(MqttTopic topic, MqttMessage message)�����Ѿ�Ԥ���ķ�����  
16  *   
17  *  public void connectionLost(Throwable cause)�ڶϿ�����ʱ���á�  
18  *   
19  *  public void deliveryComplete(MqttDeliveryToken token))  
20  *  ���յ��Ѿ������� QoS 1 �� QoS 2 ��Ϣ�Ĵ�������ʱ���á�  
21  *  �� MqttClient.connect ����˻ص���  
22  *   
23  */    
 public class PushCallback implements MqttCallback {  
   
     public void connectionLost(Throwable cause) {  
         // ���Ӷ�ʧ��һ�����������������  
         System.out.println("���ӶϿ�������������");  
     }  
     
     public void deliveryComplete(IMqttDeliveryToken token) {
         System.out.println("deliveryComplete---------" + token.isComplete());  
     }
 
     public void messageArrived(String topic, MqttMessage message) throws Exception {
         // subscribe��õ�����Ϣ��ִ�е�������  
         System.out.println("������Ϣ���� : " + topic);  
         System.out.println("������ϢQos : " + message.getQos());  
         System.out.println("������Ϣ���� : " + new String(message.getPayload()));  
     }  
 }
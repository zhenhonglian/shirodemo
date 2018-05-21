package com.java1234.mqtt;

 import org.eclipse.paho.client.mqttv3.MqttClient;
 import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
 import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
 import org.eclipse.paho.client.mqttv3.MqttException;
 import org.eclipse.paho.client.mqttv3.MqttMessage;
 import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
 import org.eclipse.paho.client.mqttv3.MqttTopic;
 import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
 /**
  * 
  * Title:Server
14  * Description: �����������ͻ����������⣬����ͬ�ͻ��˿��������������ͬ����
15  * @author chenrl
16  * 2016��1��6������3:29:28
17  */
 public class Server {
 
     public static final String HOST = "tcp://192.168.31.70:61613";
     public static final String TOPIC = "toclient/124";
     public static final String TOPIC125 = "toclient/125";
     private static final String clientid = "server";
 
     private MqttClient client;
     private MqttTopic topic;
     private MqttTopic topic125;
     private String userName = "admin";
     private String passWord = "password";
 
     private MqttMessage message;
 
     public Server() throws MqttException {
         // MemoryPersistence����clientid�ı�����ʽ��Ĭ��Ϊ���ڴ汣��
         client = new MqttClient(HOST, clientid, new MemoryPersistence());
         connect();
     }
 
     private void connect() {
         MqttConnectOptions options = new MqttConnectOptions();
         options.setCleanSession(false);
         options.setUserName(userName);
         options.setPassword(passWord.toCharArray());
         // ���ó�ʱʱ��
         options.setConnectionTimeout(10);
        // ���ûỰ����ʱ��
         options.setKeepAliveInterval(20);
         try {
             client.setCallback(new PushCallback());
             client.connect(options);
             topic = client.getTopic(TOPIC);
             topic125 = client.getTopic(TOPIC125);
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
 
     public void publish(MqttTopic topic , MqttMessage message) throws MqttPersistenceException,
             MqttException {
         MqttDeliveryToken token = topic.publish(message);
         token.waitForCompletion();
         System.out.println("message is published completely! "
                 + token.isComplete());
     }
 
     public static void main(String[] args) throws MqttException {
         Server server = new Server();
 
         server.message = new MqttMessage();
         server.message.setQos(2);
         server.message.setRetained(true);
         server.message.setPayload("���ͻ���124���͵���Ϣ".getBytes());
         server.publish(server.topic , server.message);
         
         server.message = new MqttMessage();
         server.message.setQos(2);
         server.message.setRetained(true);
         server.message.setPayload("���ͻ���125���͵���Ϣ".getBytes());
         server.publish(server.topic125 , server.message);
 
         System.out.println(server.message.isRetained() + "------ratained״̬");     }
 }
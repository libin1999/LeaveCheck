package com.sasu.Util;

import java.io.IOException;

import org.json.JSONException;

import com.github.qcloudsms.SmsMobileStatusPuller;
import com.github.qcloudsms.SmsStatusPullCallbackResult;
import com.github.qcloudsms.SmsStatusPullReplyResult;
import com.github.qcloudsms.SmsStatusPuller;
import com.github.qcloudsms.SmsVoicePromptSender;
import com.github.qcloudsms.SmsVoicePromptSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import com.sasu.Util.qcloudsms.SmsSingleSender;
import com.sasu.Util.qcloudsms.SmsSingleSenderResult;

public class SendMessage {
	private static int appid = 1400164711;
	private static String appkey="d181c59b2e07999576e5d9880af3d15b";
	
	public static boolean setmessage(int id, String phoneNumbers,String content) {
			boolean flage=false;
	        

	        // ��������
	        try {
	            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
				try {
					SmsSingleSenderResult result = ssender.send(0, "86", phoneNumbers,
					    content, "", "");
					System.out.println(result);
					if(result!=null) {
						flage=true;
					}else {
						flage=false;
					}
				} catch (com.github.qcloudsms.httpclient.HTTPException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        } catch (JSONException e) {
	            // json��������
	            e.printStackTrace();
	        } catch (IOException e) {
	            // ����IO����
	            e.printStackTrace();
	        }
	        return flage;
	}
	public static boolean sedMessageAndBack() {
		boolean flag=false;
        try {
        	  // Note: ������ȡ������Ҫ��ϵ��Ѷ�ƶ��ż���֧�֣�QQ��3012203387����ͨȨ��
        	  int maxNum = 10;  // ������ȡ�����
        	  SmsStatusPuller spuller = new SmsStatusPuller(appid, appkey);

        	  // ��ȡ���Ż�ִ
        	  SmsStatusPullCallbackResult callbackResult = spuller.pullCallback(maxNum);
        	  System.out.println(callbackResult);

        	  // ��ȡ�ظ������ʶ��Ų�֧�ֻظ�����
        	  SmsStatusPullReplyResult replyResult = spuller.pullReply(maxNum);
        	  System.out.println(replyResult);
        	  SmsVoicePromptSender smsVoicePromtSender = new SmsVoicePromptSender(appid,appkey);
      		  SmsVoicePromptSenderResult smsSingleVoiceSenderResult = smsVoicePromtSender.send("86", "18908240242", 2,2,"��ӭʹ��", "");
      		  System.out.println(smsSingleVoiceSenderResult);
      		  
        	} catch (HTTPException e) {
        	  // HTTP ��Ӧ�����
        	  e.printStackTrace();
        	} catch (JSONException e) {
        	  // JSON ��������
        	  e.printStackTrace();
        	} catch (IOException e) {
        	  // ���� IO ����
        	  e.printStackTrace();
        	}
		return flag;
	}
	public static boolean send() {
		try {
            int beginTime = 1511125600;  // ��ʼʱ��(unix timestamp)
            int endTime = 1511841600;    // ����ʱ��(unix timestamp)
            int maxNum = 10;             // ������ȡ�����
            SmsMobileStatusPuller mspuller = new SmsMobileStatusPuller(appid, appkey);

            // ��ȡ���Ż�ִ
            SmsStatusPullCallbackResult callbackResult = mspuller.pullCallback("86",
                "18908240242", beginTime, endTime, maxNum);
            System.out.println(callbackResult);

            // ��ȡ�ظ�
            SmsStatusPullReplyResult replyResult = mspuller.pullReply("86",
                "18908240242", beginTime, endTime, maxNum);
            System.out.println(replyResult);
            SmsVoicePromptSender smsVoicePromtSender = new SmsVoicePromptSender(appid,appkey);
    		  SmsVoicePromptSenderResult smsSingleVoiceSenderResult = smsVoicePromtSender.send("86", "18908240242", 2,2,"��ӭʹ��", "");
    		  System.out.println(smsSingleVoiceSenderResult);
        } catch (HTTPException e) {
            // HTTP��Ӧ�����
            e.printStackTrace();
        } catch (JSONException e) {
            // json��������
            e.printStackTrace();
        } catch (IOException e) {
            // ����IO����
            e.printStackTrace();
}
		return false;
		
	}
}

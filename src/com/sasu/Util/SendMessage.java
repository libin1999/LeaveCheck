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
	        

	        // 单发短信
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
	            // json解析错误
	            e.printStackTrace();
	        } catch (IOException e) {
	            // 网络IO错误
	            e.printStackTrace();
	        }
	        return flage;
	}
	public static boolean sedMessageAndBack() {
		boolean flag=false;
        try {
        	  // Note: 短信拉取功能需要联系腾讯云短信技术支持（QQ：3012203387）开通权限
        	  int maxNum = 10;  // 单次拉取最大量
        	  SmsStatusPuller spuller = new SmsStatusPuller(appid, appkey);

        	  // 拉取短信回执
        	  SmsStatusPullCallbackResult callbackResult = spuller.pullCallback(maxNum);
        	  System.out.println(callbackResult);

        	  // 拉取回复，国际短信不支持回复功能
        	  SmsStatusPullReplyResult replyResult = spuller.pullReply(maxNum);
        	  System.out.println(replyResult);
        	  SmsVoicePromptSender smsVoicePromtSender = new SmsVoicePromptSender(appid,appkey);
      		  SmsVoicePromptSenderResult smsSingleVoiceSenderResult = smsVoicePromtSender.send("86", "18908240242", 2,2,"欢迎使用", "");
      		  System.out.println(smsSingleVoiceSenderResult);
      		  
        	} catch (HTTPException e) {
        	  // HTTP 响应码错误
        	  e.printStackTrace();
        	} catch (JSONException e) {
        	  // JSON 解析错误
        	  e.printStackTrace();
        	} catch (IOException e) {
        	  // 网络 IO 错误
        	  e.printStackTrace();
        	}
		return flag;
	}
	public static boolean send() {
		try {
            int beginTime = 1511125600;  // 开始时间(unix timestamp)
            int endTime = 1511841600;    // 结束时间(unix timestamp)
            int maxNum = 10;             // 单次拉取最大量
            SmsMobileStatusPuller mspuller = new SmsMobileStatusPuller(appid, appkey);

            // 拉取短信回执
            SmsStatusPullCallbackResult callbackResult = mspuller.pullCallback("86",
                "18908240242", beginTime, endTime, maxNum);
            System.out.println(callbackResult);

            // 拉取回复
            SmsStatusPullReplyResult replyResult = mspuller.pullReply("86",
                "18908240242", beginTime, endTime, maxNum);
            System.out.println(replyResult);
            SmsVoicePromptSender smsVoicePromtSender = new SmsVoicePromptSender(appid,appkey);
    		  SmsVoicePromptSenderResult smsSingleVoiceSenderResult = smsVoicePromtSender.send("86", "18908240242", 2,2,"欢迎使用", "");
    		  System.out.println(smsSingleVoiceSenderResult);
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
}
		return false;
		
	}
}

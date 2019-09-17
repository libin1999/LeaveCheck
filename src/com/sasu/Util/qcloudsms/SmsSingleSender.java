package com.sasu.Util.qcloudsms;

import com.github.qcloudsms.httpclient.HTTPClient;
import com.github.qcloudsms.httpclient.HTTPException;
import com.github.qcloudsms.httpclient.HTTPMethod;
import com.github.qcloudsms.httpclient.HTTPRequest;
import com.github.qcloudsms.httpclient.HTTPResponse;
import com.github.qcloudsms.SmsSenderUtil;
import com.github.qcloudsms.httpclient.DefaultHTTPClient;
import org.json.JSONObject;
import org.json.JSONException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;


public class SmsSingleSender extends SmsBase {

    private String url = "https://yun.tim.qq.com/v5/tlssmssvr/sendsms";

    public SmsSingleSender(int appid, String appkey) {
        super(appid, appkey, new DefaultHTTPClient());
    }

    public SmsSingleSender(int appid, String appkey, HTTPClient httpclient) {
        super(appid, appkey, httpclient);
    }

    /**
     * 閺咁噣锟芥艾宕熼崣锟�
     *
     * 閺咁噣锟芥艾宕熼崣鎴犵叚娣団剝甯撮崣锝忕礉閺勫海鈥橀幐鍥х暰閸愬懎顔愰敍灞筋洤閺嬫粍婀佹径姘嚋缁涙儳鎮曢敍宀冾嚞閸︺劌鍞寸�归�涜厬娴犮儯锟芥劑锟芥垹娈戦弬鐟扮础濞ｈ濮為崚棰佷繆閹垰鍞寸�归�涜厬閿涘苯鎯侀崚娆戦兇缂佺喎鐨㈡担璺ㄦ暏姒涙顓荤粵鎯ф倳
     *
     * @param type 閻厺淇婄猾璇茬�烽敍锟�0 娑撶儤娅橀柅姘辩叚娣団槄绱�1 閽�銉╂敘閻厺淇�
     * @param nationCode 閸ヨ棄顔嶉惍渚婄礉婵★拷 86 娑撹桨鑵戦崶锟�
     * @param phoneNumber 娑撳秴鐢崶钘夘啀閻胶娈戦幍瀣簚閸欙拷
     * @param msg 娣団剝浼呴崘鍛啇閿涘苯绻�妞よ绗岄悽瀹狀嚞閻ㄥ嫭膩閺夋寧鐗稿蹇庣閼疯揪绱濋崥锕�鍨亸鍡氱箲閸ョ偤鏁婄拠锟�
     * @param extend 閹碘晛鐫嶉惍渚婄礉閸欘垰锝炵粚锟�
     * @param ext 閺堝秴濮熺粩顖氬斧閺嶇柉绻戦崶鐐垫畱閸欏倹鏆熼敍灞藉讲婵夘偆鈹�
     * @return {@link}SmsSingleSenderResult
     * @throws HTTPException  http status exception
     * @throws JSONException  json parse exception
     * @throws IOException    network problem
     */
    public SmsSingleSenderResult send(int type, String nationCode, String phoneNumber,
        String msg, String extend, String ext)
            throws HTTPException, JSONException, IOException {

        long random = SmsSenderUtil.getRandom();
        long now = SmsSenderUtil.getCurrentTime();
        JSONObject body = new JSONObject()
            .put("tel", (new JSONObject()).put("nationcode", nationCode).put("mobile", phoneNumber))
            .put("type", type)
            .put("msg", msg)
            .put("sig", SmsSenderUtil.calculateSignature(this.appkey, random, now, phoneNumber))
            .put("time", now)
            .put("extend", SmsSenderUtil.isNotEmpty(extend) ? extend : "")
            .put("ext", SmsSenderUtil.isNotEmpty(ext) ? ext : "");

        HTTPRequest req = new HTTPRequest(HTTPMethod.POST, this.url)
            .addHeader("Conetent-Type", "application/json")
            .addQueryParameter("sdkappid", this.appid)
            .addQueryParameter("random", random)
            .setConnectionTimeout(60 * 1000)
            .setRequestTimeout(60 * 1000)
            .setBody(body.toString());

        // TODO Handle timeout exception
        try {
            // May throw IOException and URISyntaxexception
            HTTPResponse res = httpclient.fetch(req);

            // May throw HTTPException
            handleError(res);

            // May throw JSONException
            return (new SmsSingleSenderResult()).parseFromHTTPResponse(res);
        } catch(URISyntaxException e) {
            throw new RuntimeException("API url has been modified, current url: " + url);
        }
    }

    /**
     * 閹稿洤鐣惧Ο鈩冩緲閸楁洖褰�
     *
     * @param nationCode 閸ヨ棄顔嶉惍渚婄礉婵★拷 86 娑撹桨鑵戦崶锟�
     * @param phoneNumber 娑撳秴鐢崶钘夘啀閻胶娈戦幍瀣簚閸欙拷
     * @param templateId 娣団剝浼呴崘鍛啇
     * @param params 濡剝婢橀崣鍌涙殶閸掓銆冮敍灞筋洤濡剝婢� {1}...{2}...{3}閿涘矂鍋呮稊鍫ユ付鐟曚礁鐢稉澶夐嚋閸欏倹鏆�
     * @param sign 缁涙儳鎮曢敍灞筋洤閺嬫粌锝炵粚鐚寸礉缁崵绮烘导姘▏閻€劑绮拋銈囶劮閸氾拷
     * @param extend 閹碘晛鐫嶉惍渚婄礉閸欘垰锝炵粚锟�
     * @param ext 閺堝秴濮熺粩顖氬斧閺嶇柉绻戦崶鐐垫畱閸欏倹鏆熼敍灞藉讲婵夘偆鈹�
     * @return {@link}SmsSingleSenderResult
     * @throws HTTPException  http status exception
     * @throws JSONException  json parse exception
     * @throws IOException    network problem
     */
    public SmsSingleSenderResult sendWithParam(String nationCode, String phoneNumber, int templateId,
        ArrayList<String> params, String sign, String extend, String ext)
            throws HTTPException, JSONException, IOException {

        long random = SmsSenderUtil.getRandom();
        long now = SmsSenderUtil.getCurrentTime();

        JSONObject body = new JSONObject()
            .put("tel", (new JSONObject()).put("nationcode", nationCode).put("mobile", phoneNumber))
            .put("sig", SmsSenderUtil.calculateSignature(appkey, random, now, phoneNumber))
            .put("tpl_id", templateId)
            .put("params", params)
            .put("sign", sign)
            .put("time", now)
            .put("extend", SmsSenderUtil.isNotEmpty(extend) ? extend : "")
            .put("ext", SmsSenderUtil.isNotEmpty(ext) ? ext : "");

        HTTPRequest req = new HTTPRequest(HTTPMethod.POST, this.url)
            .addHeader("Conetent-Type", "application/json")
            .addQueryParameter("sdkappid", this.appid)
            .addQueryParameter("random", random)
            .setConnectionTimeout(60 * 1000)
            .setRequestTimeout(60 * 1000)
            .setBody(body.toString());

        try {
            // May throw IOException and URISyntaxexception
            HTTPResponse res = httpclient.fetch(req);

            // May throw HTTPException
            handleError(res);

            // May throw JSONException
            return (new SmsSingleSenderResult()).parseFromHTTPResponse(res);
        } catch(URISyntaxException e) {
            throw new RuntimeException("API url has been modified, current url: " + url);
        }
    }

    public SmsSingleSenderResult sendWithParam(String nationCode, String phoneNumber, int templateId,
        String[] params, String sign, String extend, String ext)
            throws HTTPException, JSONException, IOException {

        return sendWithParam(nationCode, phoneNumber, templateId,
            new ArrayList<String>(Arrays.asList(params)), sign, extend, ext);
    }
}

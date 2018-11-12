package util;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

/**
 * @author yan
 * @date 2018/11/12 17:39
 * @descripition
 */
public class QiNiuFileHelper {
    private static final String BK="job-management-system-based-on-open-cloud-storage";
    private static final String AK="0ygyCNdhOs4z9SOcS5uBYMo5sv80imPMeb3LhsPQ";
    private static final String SK="KareIDSEvAnMJNgODTQ43CYD4Nj5XIy5NWqsr65x";

    public static void main(String[] args) {
        Configuration cfg = new Configuration(Zone.zone0());
        UploadManager uploadManager = new UploadManager(cfg);
        String localFilePath = "C:\\Users\\11835\\Desktop\\121.png";
        Auth auth = Auth.create(AK, SK);
        String upToken = auth.uploadToken(BK);
        System.out.println(upToken);
        try {
            Response response = uploadManager.put(localFilePath, "121.png", upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
    }

}

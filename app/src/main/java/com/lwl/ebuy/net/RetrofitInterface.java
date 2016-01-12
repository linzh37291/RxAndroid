package com.lwl.ebuy.net;




import com.lwl.ebuy.bean.User;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;


/**
 * Created by lwl on 7/8/2015.
 * 对于 Retrofit 2.0中新的URL定义方式，这里是我的建议：

 - Base URL: 总是以 /结尾

 - @Url: 不要以 / 开头


 get方式提交的参数编码，只支持iso8859-1编码。
 因此，如果里面有中文。
 在后台就需要转换编码，如下
 String zhongwen = request.getParameter("zhongwen");
 zhongwen = new String(zhongwen.getBytes("iso8859-1"),"GBK");
 前提是你页面编码就是GBK，如果是utf-8，那上面那句代码后面就改成utf-8
 */
public interface RetrofitInterface {


   @GET("msg.action")
   Call<User> rGetUser1();

   @GET("mGetParams.action?gsonBean={\"name\":\"from手机\",\"weight\":\"rGetUser2\"}")
   Call<User> rGetUser2();



   @GET("{next}/nGetParams.action")
   Call<User> rGetUser3(@Path("next") String path, @Query("gsonBean") String str);

   @GET("{next}/nGetParams.action")
   Call<User> rGetUser4(@Path("next") String path, @QueryMap Map<String, String> options);

   @Headers("Cache-Control:max-age=640000")
   @GET("msg.action")
   Call<User> rGetUser5();

   @Headers({
           "Accept: application/vnd.github.v3.full+json",
           "User-Agent: Retrofit-Sample-App"
   })
   @GET("msg.action")
   Call<User> rGetUser6();

   @GET("msg.action")
   Call<User> rGetUser7(@Header("Authorization") String authorization);


   @POST("mPostParams.action")
   Call<User> rPostUser1(@Body User user);

   @FormUrlEncoded
   @POST("mPostParams.action")
   Call<User> rPostUser2(@Field("gsonBean") String obj);

   @FormUrlEncoded
   @POST("mPostParams.action")
   Observable<User> rPostUser3(@Field("gsonBean") String obj);

   @Multipart
   @PUT("mPostParams.action")
   Call<User> rPutUser1(@Part("gsonBean") User user);









}

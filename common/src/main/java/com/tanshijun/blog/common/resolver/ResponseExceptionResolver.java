package com.tanshijun.blog.common.resolver;

import com.alibaba.fastjson.JSONObject;
import com.tanshijun.blog.common.exception.ResponseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;


/**
 * Created by tanshijun-pc on 2017/10/30.
 */
public class ResponseExceptionResolver implements HandlerExceptionResolver {
    private ModelAndView EMPTY_VIEW = new ModelAndView("empty");
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        logger.info("========enter ResponseExceptionResolver================");
        ResponseException exception = findException(e);
        JSONObject resultJson = new JSONObject();
        if(exception != null){
            resultJson.put("responseCode",exception.getResponseCode());
            resultJson.put("responseMsg",exception.getResponseMsg());
        }else{
//3819  3807 3794 3775
            resultJson.put("responseCode","999999");
            resultJson.put("responseMsg","系统异常");
        }
        try{
            writeResult(resultJson.toJSONString(),httpServletResponse);
        }catch (IOException e1){
            logger.error("writeResult exception",e1);
        }

        return EMPTY_VIEW;
    }

    private static final String DEFAULT_CHARSET = "UTF-8";

    private void writeResult(String resultJson,HttpServletResponse httpServletResponse) throws IOException{
        logger.info("writeResult:"+resultJson);
        httpServletResponse.setContentType("application/json");
        httpServletResponse.setCharacterEncoding(DEFAULT_CHARSET);
        byte[] resultData = resultJson.getBytes(DEFAULT_CHARSET);
        httpServletResponse.setContentLength(resultData.length);
        OutputStream write = null;
        write = httpServletResponse.getOutputStream();
        write.write(resultData);
        write.flush();

    }
    private static ResponseException findException(Exception e){
        Throwable temp = e;
        while(temp != null){
            if(temp instanceof ResponseException){
                return (ResponseException)temp;
            }else{
                temp = temp.getCause();
            }
        }
        return null;
    }

    public static void main(String[] args){
        ResponseException e = new ResponseException("111","2121");
        ResponseException e1 = findException(e);
        System.out.println(e1);
    }
}

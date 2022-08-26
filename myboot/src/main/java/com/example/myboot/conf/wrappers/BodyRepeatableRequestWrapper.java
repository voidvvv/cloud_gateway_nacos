package com.example.myboot.conf.wrappers;

import javax.servlet.ReadListener;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.Part;
import java.io.*;
import java.util.Collection;
import java.util.Map;

/**
 * @Classname BodyRepeatableRequestWrapper
 * @Description
 * @Date 2022/8/23 23:34
 * @Created by voidvvv
 */
public class BodyRepeatableRequestWrapper extends HttpServletRequestWrapper {

    private ByteArrayOutputStream byteArrayOutputStream;

    byte[] data = null;
    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request The request to wrap
     * @throws IllegalArgumentException if the request is null
     */
    public BodyRepeatableRequestWrapper(HttpServletRequest request) throws IOException, ServletException {
        super(request);
        ServletInputStream inputStream = request.getInputStream();
        byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] datas = new byte[2048];
        String contentType = request.getContentType();
//        Map<String, String[]> parameterMap = request.getParameterMap();

        Collection<Part> parts = request.getParts();
//        if (parts!=null && parts.size() > 0 ){
//            for (Part p:parts){
//                System.out.println(p.getContentType());
//                System.out.println(p.getName());;
//            }
//        }
        int i = 0;
        while ((i = inputStream.read(datas))>0){
            byteArrayOutputStream.write(datas,0,i);
        }
        data = byteArrayOutputStream.toByteArray();
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener listener) {

            }

            @Override
            public int read() throws IOException {
                return byteArrayInputStream.read();
            }
        };
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(new ByteArrayInputStream(data)));
    }
}

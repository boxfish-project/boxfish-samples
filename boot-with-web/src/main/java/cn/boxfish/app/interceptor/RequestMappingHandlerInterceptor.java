package cn.boxfish.app.interceptor;

import com.google.common.base.Stopwatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * Created by undancer on 15/8/16.
 */
@Named
public class RequestMappingHandlerInterceptor implements WebRequestInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(RequestMappingHandlerInterceptor.class);

    private static final String PATH = RequestMappingHandlerInterceptor.class + ".PATH";
    private static final String METHOD = RequestMappingHandlerInterceptor.class + ".METHOD";
    private static final String TIME = RequestMappingHandlerInterceptor.class + ".TIME";

    private ThreadLocal<Stopwatch> timer = new ThreadLocal();

    public void preHandle(WebRequest request) throws Exception {
        timer.set(Stopwatch.createStarted());
        if (request instanceof ServletWebRequest) {
            HttpServletRequest httpRequest = ((ServletWebRequest) request).getNativeRequest(HttpServletRequest.class);
            StringBuilder sb = new StringBuilder(httpRequest.getServletPath());
            String query = httpRequest.getQueryString();
            if (query != null && query.length() > 0) {
                sb.append('?').append(query);
            }
            request.setAttribute(PATH, sb.toString(), RequestAttributes.SCOPE_REQUEST);
            request.setAttribute(METHOD, httpRequest.getMethod().toUpperCase(), RequestAttributes.SCOPE_REQUEST);
        }

    }

    public void postHandle(WebRequest request, ModelMap model) throws Exception {
    }

    public void afterCompletion(WebRequest request, Exception ex) throws Exception {
        String path = (String) request.getAttribute(PATH, RequestAttributes.SCOPE_REQUEST);
        String method = (String) request.getAttribute(METHOD, RequestAttributes.SCOPE_REQUEST);
        long time = timer.get().stop().elapsed(TimeUnit.MILLISECONDS);

        logger.info("[BREATH/CORE][{}] {} {} ms.", method, path, time);
    }

}

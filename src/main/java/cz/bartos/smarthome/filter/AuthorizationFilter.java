package cz.bartos.smarthome.filter;

import javax.servlet.*;
import java.io.IOException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Míra
 */
@WebFilter(
    filterName = "shfilter",
    urlPatterns = {"/*"}
)
public class AuthorizationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, 
            FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;        
        String requestURI = servletRequest.getRequestURI();
        
        System.out.println("requestURI: " + requestURI);
        
        servletResponse.setHeader("Access-Control-Allow-Origin", "*");  
        servletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        servletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, HEAD, OPTIONS");
        servletResponse.setHeader("Access-Control-Allow-Headers", "Origin, Accept, x-auth-token, "
                + "Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
        chain.doFilter(servletRequest, servletResponse);
        
    }

    @Override
    public void destroy() {
    }
}

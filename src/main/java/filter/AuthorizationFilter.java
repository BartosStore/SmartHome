/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Míra
 */
@WebFilter(filterName = "AuthFIlter", urlPatterns = {"*.xhtml"})
public class AuthorizationFilter implements Filter {

    public AuthorizationFilter() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest rqst = (HttpServletRequest) request;
        HttpServletResponse rsps = (HttpServletResponse) response;
        HttpSession sssn = rqst.getSession(false);

        String rqstURI = rqst.getRequestURI();
        if (rqstURI.indexOf("/login.xhtml") >= 0
                || (sssn != null && sssn.getAttribute("username") != null)
                || rqstURI.indexOf("/public/") >= 0
                || rqstURI.contains("javax.faces.resource")) {
            chain.doFilter(request, response);
        } else {
            rsps.sendRedirect(rqst.getContextPath() + "/login.xhtml");
        }
    }

    @Override
    public void destroy() {

    }

}
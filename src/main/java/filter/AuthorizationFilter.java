/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import cz.bartos.smarthome.beans.UserSession;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Míra
 */
//@WebFilter(filterName = "AuthFilter", urlPatterns = {"/restricted/*"})
//@WebFilter(filterName = "AuthFilter", urlPatterns = {"*.xhtml"})
@WebFilter(filterName = "AuthFilter", urlPatterns = {"*.xhtml"})
public class AuthorizationFilter implements Filter {

    @Inject
    private UserSession userSession;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String requestURI = httpServletRequest.getRequestURI();

        //chce uzivatel na login.xhtml?
        if (requestURI.equalsIgnoreCase("/SmartHome-1.0/login.xhtml")) {
            //je prihlasen? -> zbytecne; poslat na index.xhtml
            if (userSession.isLoggedIn()) {
                ((HttpServletResponse) response).sendRedirect(httpServletRequest.getContextPath() + "/login.xhtml");
            } //neni prihlasen? -> OK
            else {
                chain.doFilter(httpServletRequest, httpServletResponse);
            }
        } //smerovani mimo login.xhtml?
        else {
            //je prihlasen? -> OK
            if (userSession.isLoggedIn()) {
                chain.doFilter(httpServletRequest, httpServletResponse);
            } //neni prihlasen? -> spatne; smerovat na login.xhtml
            else {
                ((HttpServletResponse) response).sendRedirect(httpServletRequest.getContextPath() + "/login.xhtml");
            }
        }
    }

    @Override
    public void destroy() {
    }

}

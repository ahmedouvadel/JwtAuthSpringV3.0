package net.lebssty.lebsstyv5.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SimpleCorsFilter implements Filter {
    @Value("${app.client.url}")
    private String clientAppUrl = "";

    public SimpleCorsFilter() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Map<String, String> map = new HashMap<>();

        String originHeader = request.getHeader("origin");
        // Specify domains you want to allow, or use "*" for all
        response.setHeader("Access-Control-Allow-Origin", originHeader);
        // Methods you want to allow
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        // Request headers you want to allow
        response.setHeader("Access-Control-Allow-Headers", "*");
        // Expose headers
        // Set how long the response from the server should be cached in seconds.
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Expose-Headers", "Authorization");


        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            // If it's a pre-flight request, we only return the headers without passing the request down the filter chain
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            // For all other requests, proceed with the rest of the filter chain
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) {
        // No initialization logic needed for this simple filter
    }

    @Override
    public void destroy() {
        // No cleanup necessary for this simple filter
    }
}

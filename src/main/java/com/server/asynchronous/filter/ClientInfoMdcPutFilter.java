package com.server.asynchronous.filter;

import org.apache.log4j.MDC;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Optional;

public class ClientInfoMdcPutFilter extends OncePerRequestFilter {

	private static final String FORWARDED_FOR_HEADER_NAME = "x-Forwarded-For";
	
	private String mdcKey = FORWARDED_FOR_HEADER_NAME;

	protected final void doFilterInternal(HttpServletRequest request, 
			HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		String remoteIp = Optional.ofNullable(request.getHeader(FORWARDED_FOR_HEADER_NAME)).orElse(request.getRemoteAddr());
		MDC.put(mdcKey, remoteIp);
		try {
			filterChain.doFilter(request, response);
		} finally {
			MDC.remove(mdcKey);
		}
	}
	
	/**
	 * @return the mdcKey
	 */
	public String getMdcKey() {
		return mdcKey;
	}

	
	/**
	 * @param mdcKey the mdcKey to set
	 */
	public void setMdcKey(String mdcKey) {
		this.mdcKey = mdcKey;
	}
	
}

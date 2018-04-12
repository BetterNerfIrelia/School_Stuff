<%--
  Created by IntelliJ IDEA.
  User: schie
  Date: 03.04.2018
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Cookie[] cookies = null;
    cookies = request.getCookies();

    if (cookies != null) {
        out.println("<h2> Found Cookies </h2>");
        for (Cookie c : cookies) {
            if (c.getName() == "adresse") {
                out.println("<h2> Adresse-Cookie found </h2>");
            } else {
                Cookie adresse = new Cookie("adresse", request.getRequestURI());
                adresse.setMaxAge(60 * 60 * 24);
                response.addCookie(adresse);
            }
        }
    } else {
        out.println("<h2> No Cookies found</h2>");
    }
%>

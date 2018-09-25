package com.hsnn.medstgmini.servlet;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.captcha.Captcha;
import nl.captcha.backgrounds.GradiatedBackgroundProducer;
import nl.captcha.servlet.CaptchaServletUtil;

import com.hsnn.medstgmini.util.HsnnWordRender;

public class HsnnCaptchaServlet extends HttpServlet {
	
	public HsnnCaptchaServlet() {}
	
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        if(getInitParameter("captcha-height") != null)
            _height = Integer.valueOf(getInitParameter("captcha-height")).intValue();
        if(getInitParameter("captcha-width") != null)
            _width = Integer.valueOf(getInitParameter("captcha-width")).intValue();
    }
    
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HsnnWordRender wordRenderer = new HsnnWordRender(COLORS, FONTS);
        Captcha captcha = (new nl.captcha.Captcha.Builder(_width, _height)).addText(wordRenderer).gimp().addNoise().addBackground(new GradiatedBackgroundProducer()).build();
        CaptchaServletUtil.writeImage(resp, captcha.getImage());
        req.getSession().setAttribute("simpleCaptcha", captcha);
    }
    
    private static final long serialVersionUID = 1L;
    private static int _width = 200;
    private static int _height = 50;
    private static final java.util.List COLORS;
    private static final java.util.List FONTS;

    static 
    {
        COLORS = new ArrayList(2);
        FONTS = new ArrayList(3);
        COLORS.add(Color.ORANGE);
        COLORS.add(Color.BLUE);
        FONTS.add(new Font("Geneva", 2, 48));
        FONTS.add(new Font("Courier", 1, 48));
        FONTS.add(new Font("Arial", 1, 48));
    }
}

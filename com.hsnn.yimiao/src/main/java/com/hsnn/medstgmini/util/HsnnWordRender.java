package com.hsnn.medstgmini.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.security.SecureRandom;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.Random;

import nl.captcha.text.renderer.WordRenderer;

public class HsnnWordRender implements WordRenderer {
	
    public HsnnWordRender() {
        this(DEFAULT_COLORS, DEFAULT_FONTS, 0.0F);
    }

    public HsnnWordRender(java.util.List colors, java.util.List fonts) {
        this(colors, fonts, 0.0F);
    }

    public HsnnWordRender(java.util.List colors, java.util.List fonts, float strokeWidth) {
        _colors = colors == null ? DEFAULT_COLORS : colors;
        _fonts = fonts == null ? DEFAULT_FONTS : fonts;
        _strokeWidth = strokeWidth >= 0.0F ? strokeWidth : 0.0F;
    }

    public void render(String word, BufferedImage image) {
        Graphics2D g = image.createGraphics();
        RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        hints.add(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g.setRenderingHints(hints);
        AttributedString as = new AttributedString(word);
        as.addAttribute(TextAttribute.FONT, getRandomFont());
        java.awt.font.FontRenderContext frc = g.getFontRenderContext();
        AttributedCharacterIterator aci = as.getIterator();
        TextLayout tl = new TextLayout(aci, frc);
        int xBaseline = (int)Math.round((double)image.getWidth() * 0.050000000000000003D);
        int yBaseline = image.getHeight() - (int)Math.round((double)image.getHeight() * 0.25D);
        java.awt.Shape shape = tl.getOutline(AffineTransform.getTranslateInstance(xBaseline, yBaseline));
        g.setColor(getRandomColor());
        g.fill(shape);
        g.draw(shape);
    }

    private Color getRandomColor() {
        return (Color)getRandomObject(_colors);
    }

    private Font getRandomFont() {
        return (Font)getRandomObject(_fonts);
    }

    private Object getRandomObject(java.util.List objs) {
        if (objs.size() == 1) {
            return objs.get(0);
        } else {
            int i = RAND.nextInt(objs.size());
            return objs.get(i);
        }
    }

    private static final Random RAND = new SecureRandom();
    private static final java.util.List DEFAULT_COLORS;
    private static final java.util.List DEFAULT_FONTS;
    private static final float DEFAULT_STROKE_WIDTH = 0F;
    private static final double YOFFSET = 0.25D;
    private static final double XOFFSET = 0.050000000000000003D;
    private final java.util.List _fonts;
    private final java.util.List _colors;
    private final float _strokeWidth;

    static {
        DEFAULT_COLORS = new ArrayList();
        DEFAULT_FONTS = new ArrayList();
        DEFAULT_FONTS.add(new Font("Arial", 1, 40));
        DEFAULT_COLORS.add(Color.BLACK);
    }
}
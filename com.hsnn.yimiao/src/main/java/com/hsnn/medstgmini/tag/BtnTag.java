package com.hsnn.medstgmini.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.hsnn.medstgmini.Constants;

public class BtnTag extends BodyTagSupport {

	private static final long serialVersionUID = 1L;

	private PageContext pageContext;

	private String url;

	@SuppressWarnings("unchecked")
	@Override
	public int doEndTag() throws JspException {
		HttpSession session = pageContext.getSession();
		List<String> privList = (List<String>) session
				.getAttribute(Constants.USER_RESOURCE);

		BodyContent body = this.getBodyContent();
		try {
			if (privList != null && !privList.isEmpty()) {
				if (privList.contains(url)) {
					body.writeOut(body.getEnclosingWriter());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doEndTag();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public PageContext getPageContext() {
		return pageContext;
	}

	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
	}

}

package com.apachefirst;


import com.apachefirst.header.HeaderPanel;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class DefaultPage extends WebPage {

    private static final long serialVersionUID = 1L;

    public DefaultPage(final PageParameters pageParameters) {
        super(pageParameters);

        add(new HeaderPanel("header"));

    }
}

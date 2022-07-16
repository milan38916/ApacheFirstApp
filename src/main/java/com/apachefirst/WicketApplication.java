package com.apachefirst;

import org.apache.wicket.csp.CSPDirective;
import org.apache.wicket.csp.CSPDirectiveSrcValue;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.protocol.http.mock.Cookies;

public class WicketApplication extends WebApplication {

    @Override
    public Class<? extends WebPage> getHomePage() {
        return DefaultPage.class;
    }

    @Override
    public void init() {
        super.init();

        getCspSettings().blocking()
                .add(CSPDirective.STYLE_SRC, CSPDirectiveSrcValue.SELF)
                .add(CSPDirective.STYLE_SRC, "https://fonts.googleapis.com/css")
                .add(CSPDirective.FONT_SRC, "https://fonts.gstatic.com");

    }




}

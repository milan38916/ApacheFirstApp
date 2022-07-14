package com.apachefirst;


import com.apachefirst.main.hangmanGame.HangmanGameApp;
import com.apachefirst.modalWindows.ModalDialog;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage {

    private static final long serialVersionUID = 1L;

    public HomePage(final PageParameters pageParameters) {
        super(pageParameters);

        add(new BookmarkablePageLink<Void>("openHangman", HangmanGameApp.class));
        add(new BookmarkablePageLink<Void>("openModal", ModalDialog.class));
    }


}

package com.apachefirst;


import com.apachefirst.header.HeaderPanel;

import com.apachefirst.modalWindows.ModalDialogInputPhotoContent;
import com.apachefirst.modalWindows.ModalDialogPhotoContent;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.head.CssContentHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.net.CookieHandler;
import java.net.CookiePolicy;

public class DefaultPage extends WebPage {

    private static final long serialVersionUID = 1L;

    public DefaultPage(final PageParameters pageParameters) {
        super(pageParameters);

        ModalWindow modalDialogPhoto = new ModalWindow("modalDialogPhoto");
        add(modalDialogPhoto);
        modalDialogPhoto.setResizable(true);
        modalDialogPhoto.setOutputMarkupId(true);
        modalDialogPhoto.setWidthUnit("px");
        modalDialogPhoto.setHeightUnit("px");
        modalDialogPhoto.setInitialWidth(600);
        modalDialogPhoto.setInitialHeight(600);

        modalDialogPhoto.setPageCreator(() -> new ModalDialogPhotoContent(modalDialogPhoto.getContentId()));

        ModalWindow modalDialogInputPhoto = new ModalWindow("modalDialogInputPhoto");
        add(modalDialogInputPhoto);
        modalDialogInputPhoto.setResizable(true);
        modalDialogInputPhoto.setOutputMarkupId(true);

        modalDialogInputPhoto.setPageCreator(() -> new ModalDialogInputPhotoContent(modalDialogInputPhoto.getContentId()));

        add(new HeaderPanel("header", modalDialogPhoto, modalDialogInputPhoto));

    }

}

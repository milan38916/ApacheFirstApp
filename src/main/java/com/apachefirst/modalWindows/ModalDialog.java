package com.apachefirst.modalWindows;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.request.resource.PackageResourceReference;

public class ModalDialog extends WebPage {

    public ModalDialog() {

        WebMarkupContainer webMarkupContainer = new WebMarkupContainer("userImageBox");
        add(webMarkupContainer);
        Image userImage = new Image("userImage", new PackageResourceReference(getClass(), "man.png"));
        userImage.add(new AttributeModifier("style", "width: 100px; height: 200px;"));
        webMarkupContainer.add(userImage);

        webMarkupContainer.add(new AjaxLink<Void>("openModalWindow") {
            @Override
            public void onClick(AjaxRequestTarget ajaxRequestTarget) {
            }
        });

    }

}

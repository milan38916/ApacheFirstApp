package com.apachefirst.header;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

import com.apachefirst.main.hangmanGame.ToDoList;
import com.apachefirst.modalWindows.ModalDialogInputPhotoContent;
import com.apachefirst.modalWindows.ModalDialogPhoto;
import com.apachefirst.modalWindows.ModalDialogPhotoContent;

public class HeaderPanel extends Panel
{

    public HeaderPanel(final String id)
    {
        super(id);

        ModalWindow modalDialogPhoto = new ModalWindow("modalDialogPhoto");
        add(modalDialogPhoto);
        modalDialogPhoto.setInitialHeight(500);
        modalDialogPhoto.setInitialWidth(500);
        modalDialogPhoto.setResizable(false);
        modalDialogPhoto.setOutputMarkupId(true);

        modalDialogPhoto.setContent(new ModalDialogPhotoContent(modalDialogPhoto.getContentId()));

        add(new AjaxLink<Void>("userImagePreview")
        {
            @Override
            public void onClick(final AjaxRequestTarget ajaxRequestTarget)
            {
                modalDialogPhoto.show(ajaxRequestTarget);
            }
        });

        ModalWindow modalDialogInputPhoto = new ModalWindow("modalDialogInputPhoto");
        add(modalDialogInputPhoto);
        modalDialogInputPhoto.setInitialHeight(500);
        modalDialogInputPhoto.setInitialWidth(500);
        modalDialogInputPhoto.setResizable(false);
        modalDialogInputPhoto.setOutputMarkupId(true);

        modalDialogInputPhoto.setContent(new ModalDialogInputPhotoContent(modalDialogPhoto.getContentId()));

        add(new AjaxLink<Void>("addImageModal")
        {
            @Override
            public void onClick(final AjaxRequestTarget ajaxRequestTarget)
            {
                modalDialogInputPhoto.show(ajaxRequestTarget);
            }
        });





        add(new BookmarkablePageLink<Void>("backToHome", getApplication().getHomePage()));
        add(new BookmarkablePageLink<Void>("openToDo", ToDoList.class));
        add(new BookmarkablePageLink<Void>("openModal", ModalDialogPhoto.class));
    }

    public HeaderPanel(final String id, final IModel<?> model)
    {
        super(id, model);
    }


}

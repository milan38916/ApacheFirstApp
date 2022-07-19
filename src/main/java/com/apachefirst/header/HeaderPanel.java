package com.apachefirst.header;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

import com.apachefirst.main.toDo.ToDoList;
import com.apachefirst.modalWindows.ModalDialogPhoto;

public class HeaderPanel extends Panel
{

    public HeaderPanel(final String id, ModalWindow modalDialogPhoto, ModalWindow modalDialogInputPhoto)
    {
        super(id);



        add(new AjaxLink<Void>("userImagePreview")
        {
            @Override
            public void onClick(final AjaxRequestTarget ajaxRequestTarget)
            {
                modalDialogPhoto.show(ajaxRequestTarget);
            }
        });



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

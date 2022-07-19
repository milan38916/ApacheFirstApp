package com.apachefirst.main.toDo;

import com.apachefirst.modalWindows.UpdateTaskModal;
import com.apachefirst.models.Task;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalDialog;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.apachefirst.DefaultPage;

import java.util.ArrayList;
import java.util.List;

public class ToDoList extends DefaultPage
{
    private ListView toDoList;
    private ModalDialog updateTask;

    public ToDoList(final PageParameters pageParameters) {
        super(pageParameters);
        initTask();

        List<Task> tasksList = new ArrayList<>();

        TextField title = new TextField("title", new Model());
        TextField detail = new TextField("detail", new Model());

        toDoList = new ListView<Task>("toDoList", tasksList) {
            @Override
            protected void populateItem(ListItem<Task> listItem) {
                listItem.setOutputMarkupId(true);
                listItem.add(new Label("itemTitle", listItem.getModelObject().getTitle()));
                listItem.add(new Label("itemDetail", listItem.getModelObject().getDetail()));
                listItem.add(new AjaxLink<Void>("delete") {
                    @Override
                    public void onClick(AjaxRequestTarget ajaxRequestTarget) {
                        tasksList.remove(listItem.getModelObject());
                        ajaxRequestTarget.add(toDoList.getParent());
                    }
                });

                listItem.add(new AjaxLink<Void>("update") {
                    @Override
                    public void onClick(AjaxRequestTarget ajaxRequestTarget) {
                        updateTask.open(ajaxRequestTarget);
                    }
                });

            }
        };
        toDoList.setOutputMarkupId(true);

        Form<?> toDoForm = new Form<Void>("toDoForm") {
            @Override
            protected void onSubmit() {
                tasksList.add(new Task(title.getInput(), detail.getInput()));
            }
        };


        toDoForm.add(title);
        toDoForm.add(detail);

        add(toDoForm);
        add(toDoList);

    }

    public void initTask() {
        updateTask = new ModalDialog("updateDialog");
        updateTask.setContent(new UpdateTaskModal(ModalDialog.CONTENT_ID));
        updateTask.closeOnEscape();
        add(updateTask);
    }

}

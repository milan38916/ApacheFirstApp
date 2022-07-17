package com.apachefirst.main.hangmanGame;

import com.apachefirst.models.Task;
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

    public ToDoList(final PageParameters pageParameters) {
        super(pageParameters);

        List<Task> tasksList = new ArrayList<>();

        TextField title = new TextField("title", new Model());
        TextField detail = new TextField("detail", new Model());

        ListView toDoList = new ListView<Task>("toDoList", tasksList) {
            @Override
            protected void populateItem(ListItem<Task> listItem) {
                listItem.add(new Label("itemTitle", listItem.getModelObject().getTitle()));
                listItem.add(new Label("itemDetail", listItem.getModelObject().getDetail()));

            }
        };

        Form<?> toDoForm = new Form<Void>("toDoForm") {
            @Override
            protected void onSubmit() {
                tasksList.add(new Task(title.getInput(), detail.getInput()));
                toDoList.setList(tasksList);
            }
        };
        toDoForm.add(title);
        toDoForm.add(detail);

        add(toDoForm);
        add(toDoList);

    }

}
